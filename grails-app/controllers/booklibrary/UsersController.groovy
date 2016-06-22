import booklibrary.Role
import booklibrary.User
import booklibrary.UserRole

class UsersController {

    def usersService
    def rolesService
    def authService

    def index() {
        def users = usersService.getUsers()
        render(view: "users", model: [users: users])
    }

    def addUser() {
        if (usersService.getUserByUsername(params.username)) {
            flash.message = "User with this login already exists"
            flash.code = "danger"
        }
        else if (usersService.getUserByEmail(params.email)) {
            flash.message = "User with this email already exists"
            flash.code = "danger"
        }
        else {
            if (usersService.addUser(
                    params.username,
                    params.password,
                    params.email,
                    params.firstname,
                    params.lastname,
                    params.middlename)) {

                flash.message = "User is created"
                flash.code = "success"

            } else {
                flash.message = "An error has occurred. Please try again later or check your entries"
                flash.code = "danger"
            }
        }
        redirect(uri: "/admin/users")
    }

    def edit() {
        def user = usersService.getUser(params.id)
        render(view: "edit", model: [user: user])
    }

    def updateUser() {
        if (usersService.updateUser(params.id, params.email, params.firstname, params.lastname, params.middlename)) {
            flash.message = "User is updated"
            flash.code = "success"
        } else {
            flash.message = "An error has occurred. Please try again later or check your entries"
            flash.code = "danger"
        }
        redirect(uri: "/admin/users")
    }

    def deleteUser() {
        if (usersService.deleteUser(params.id)) {
            flash.message = "User is deleted"
            flash.code = "success"

            authService.logout(session, params.id)

        } else {
            flash.message = "An error has occurred. Please try again later or check your entries"
            flash.code = "danger"
        }
        redirect(uri: "/admin/users")
    }

    def roles() {
        def roles = rolesService.getRoles()
        def userRoles = usersService.getUserRoles(params.id)
        def currentUser = usersService.getUser(params.id)
        render(view: "roles", model: [roles: roles, userRoles: userRoles, user: currentUser])
    }

    def grantRole() {
        if (!usersService.getUserRole(params.id, params.roleId)) {
            if (usersService.grantRole(params.id, params.roleId)) {
                flash.message = "Role is granted"
                flash.code = "success"
            } else {
                flash.message = "An error has occurred. Please try again later or check your entries"
                flash.code = "danger"
            }
        } else {
            flash.message = "Role has already granted to the user"
            flash.code = "danger"
        }
        redirect(action: "roles", id: params.id)
    }

    def revokeRole() {
        if (usersService.revokeRole(params.userId, params.roleId)) {
            flash.message = "Role is revoked"
            flash.code = "success"
        } else {
            flash.message = "An error has occurred. Please try again later"
            flash.code = "danger"
        }
        redirect(action: "roles", id: params.userId)
    }
}
