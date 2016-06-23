package booklibrary

class Book {

    static mapping = {
        version false
        table "Books"
        publishYear column: "PublishYear"
        bookUrl column: "BookUrl"
        userId column: "UserId"
    }

    static constraints = {
    }

    Integer id
    String title
    String author
    String description
    Integer publishYear
    String bookUrl
    Integer userId
}
