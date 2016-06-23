package booklibrary

class BooksController {

    def booksService

    def index() {
        def books = booksService.getBooks()
        render(view: "../index", model: [books: books])
    }

    def add() {
        render(view: "add")
    }

    def addBook() {
        if (booksService.addBook(params.title, params.author, params.description, params.publishYear, params.bookUrl, params.id)) {
            flash.message = "Book is added"
            flash.code = "success"
        } else {
            flash.message = "An error has occurred. Please try again later or check your entries"
            flash.code = "danger"
        }
        redirect(uri: "/")
    }

    def edit() {
        def book = booksService.getBook(params.id)
        render(view: "edit", model: [book: book])
    }

    def updateBook() {
        if (booksService.updateBook(params.id, params.title, params.author, params.description, params.publishYear, params.bookUrl)) {
            flash.message = "Book is updated"
            flash.code = "success"
        } else {
            flash.message = "An error has occurred. Please try again later or check your entries"
            flash.code = "danger"
        }
        redirect(uri: "/")
    }

    def deleteBook() {
        if (booksService.deleteBook(params.id)) {
            flash.message = "Book is deleted"
            flash.code = "success"
        } else {
            flash.message = "An error has occurred. Please try again later or check your entries"
            flash.code = "danger"
        }
        redirect(uri: "/")
    }
}
