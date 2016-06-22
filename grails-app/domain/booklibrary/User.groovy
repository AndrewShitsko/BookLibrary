package booklibrary

class User {

    static mapping = {
        version false
        table "Users"
        createdAt column: "CreatedAt"
    }

    static constraints = {
        username(nullable: false)
    }

    Integer id
    String username
    String password
    String salt
    String email
    String firstname
    String lastname
    String middlename
    Date createdAt
}
