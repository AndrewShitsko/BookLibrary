package booklibrary

class UserRole {

    static mapping = {
        version false
        table "UserRoles"
        userId column: "UserId"
        roleId column: "RoleId"
    }

    static constraints = {
    }

    Integer id
    Integer userId
    Integer roleId
}
