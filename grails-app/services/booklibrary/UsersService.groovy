import booklibrary.User
import booklibrary.UserRole
import grails.transaction.Transactional

@Transactional
public class UsersService {

    def rolesService

    public def getUsers() {
        User.findAll()
    }

    public def getUser(id) {
        User.get(id)
    }

    public def getUserByUsername(String username) {
        User.findByUsername(username)
    }

    public def getUserByEmail(String email) {
        User.findByEmail(email)
    }

    public boolean addUser(String username, String password, String email, String firstname, String lastname, String middlename) {
        def result = false
        try {
            PasswordHelper.SaltHash saltHash = PasswordHelper.computeHashWithSalt(password)
            long now = new Date().getTime()
            def user = new User(
                    username: username,
                    password: saltHash.getHash(),
                    salt: saltHash.getSalt(),
                    email: email,
                    firstname: firstname,
                    lastname: lastname,
                    middlename: middlename,
                    createdAt: now
            )

            user.save()

            result = true

        } catch (e) {
            e.printStackTrace()
        }
        return result
    }

    public boolean updateUser(id, String email, String firstname, String lastname, String middlename) {
        def result = false
        try {
            def user = getUser(id)
            if (user) {
                user.email = email
                user.firstname = firstname
                user.lastname = lastname
                user.middlename = middlename

                user.save()

                result = true
            }
        } catch (e) {
            e.printStackTrace()
        }
        return result
    }

    public boolean deleteUser(id) {
        def result = false
        try {
            def user = getUser(id)
            if (user) {
                revokeRoles(id, true)
                user.delete()
                result = true
            }
        } catch (e) {
            e.printStackTrace()
        }
        return result
    }

    public def getUserRoles(userId) {
        def userRoles = []
        def roles = rolesService.getRoles()
        def userRoleIds = getUserRoleIds(userId, true)
        if (userRoleIds) {
            for(userRoleId in userRoleIds) {
                for(role in roles) {
                    if (userRoleId.roleId == role.id)
                        userRoles.add(role)
                }
            }
        }
        userRoles
    }

    public def getUserRoleIds(id, boolean byUser) {
        if (byUser)
            UserRole.findAllByUserId(id)
        else
            UserRole.findAllByRoleId(id)
    }

    public def getUserRole(userId, roleId) {
        UserRole.findByUserIdAndRoleId(userId, roleId)
    }

    public boolean grantRole(userId, roleId) {
        def result = false
        try {
            def userRole = new UserRole(userId: userId, roleId: roleId)
            userRole.save()
            result = true
        } catch (e) {
            e.printStackTrace()
        }
        return result
    }

    public boolean revokeRole(userId, roleId) {
        def result = false
        try {
            def userRole = getUserRole(userId, roleId)
            if (userRole) {
                userRole.delete()
                result = true
            }
        } catch (e) {
            e.printStackTrace()
        }
        return result
    }

    public boolean revokeRoles(id, boolean byUser) {
        def result = false
        try {
            def userRoles = getUserRoleIds(id, byUser)
            if (userRoles) {
                for(userRole in userRoles)
                    userRole.delete()
                result = true
            }
        } catch (e) {
            e.printStackTrace()
        }
        return result
    }

    public boolean hasRole(user, String rolename) {
        def result = false
        try {
            def userRoles = getUserRoles(user.id);
            if (userRoles) {
                if (userRoles.find {i -> i.name == rolename})
                    result = true
            }
        } catch (e) {
            e.printStackTrace()
        }
        return result
    }
}
