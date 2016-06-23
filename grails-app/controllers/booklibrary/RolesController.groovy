package booklibrary

class RolesController {

    def rolesService

    def index() {
        def roles = rolesService.getRoles()
        render(view: "roles", model: [roles: roles])
    }

    def add() {
        render(view: "add")
    }

    def addRole() {
        if (rolesService.getRoleByName(params.name)) {
            flash.message = "Role with this name already exists"
            flash.code = "danger"
        } else {
            if (rolesService.addRole(params.name)) {
                flash.message = "Role is created"
                flash.code = "success"
            } else {
                flash.message = "An error has occurred. Please try again later or check your entries"
                flash.code = "danger"
            }
        }
        redirect(uri: "/admin/roles")
    }

    def edit() {
        def role = rolesService.getRole(params.id)
        render(view: "edit", model: [role: role])
    }

    def updateRole() {
        if (rolesService.updateRole(params.id, params.name)) {
            flash.message = "Role is updated"
            flash.code = "success"
        } else {
            flash.message = "An error has occurred. Please try again later or check your entries"
            flash.code = "danger"
        }
        redirect(uri: "/admin/roles")
    }

    def deleteRole() {
        if (rolesService.deleteRole(params.id)) {
            flash.message = "Role is deleted"
            flash.code = "success"
        } else {
            flash.message = "An error has occurred. Please try again later or check your entries"
            flash.code = "danger"
        }
        redirect(uri: "/admin/roles")
    }
}
