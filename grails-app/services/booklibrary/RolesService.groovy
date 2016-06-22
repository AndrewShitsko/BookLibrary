import booklibrary.Role
import grails.transaction.Transactional

@Transactional
public class RolesService {

    def usersService

    public def getRoles() {
        Role.findAll()
    }

    public def getRole(id) {
        Role.get(id)
    }

    public def getRoleByName(String name) {
        Role.findByName(name)
    }

    public boolean addRole(String name) {
        def result = false
        try {
            def role = new Role(name: name)
            role.save()
            result = true
        } catch (e) {
            e.printStackTrace()
        }
        return result
    }

    public boolean updateRole(id, String name) {
        def result = false
        try {
            def role = getRole(id)
            if (role) {
                role.name = name
                role.save()
                result = true
            }
        } catch (e) {
            e.printStackTrace()
        }
        return result
    }

    public boolean deleteRole(id) {
        def result = false
        try {
            def role = getRole(id)
            if (role) {
                usersService.revokeRoles(id, false)
                role.delete()
                result = true
            }
        } catch (e) {
            e.printStackTrace()
        }
        return result
    }
}
