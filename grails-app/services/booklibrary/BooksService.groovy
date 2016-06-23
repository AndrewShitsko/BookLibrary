package booklibrary

import grails.transaction.Transactional

@Transactional
public class BooksService {

    public def getBooks() {
        Book.findAll()
    }

    public def getBook(id) {
        Book.get(id)
    }

    public def addBook(String title, String author, String description, publishYear, String bookUrl, userId) {
        def result = false
        try {
            def book = new Book(title: title,
                                author: author,
                                description: description,
                                publishYear: publishYear,
                                bookUrl: bookUrl,
                                userId: userId)
            book.save()
            result = true
        } catch (e) {
            e.printStackTrace()
        }
        return result
    }

    public def updateBook(id, String title, String author, String description, publishYear, String bookUrl) {
        def result = false
        try {
            def book = getBook(id)
            if (book) {
                book.title = title
                book.author = author
                book.description = description
                book.publishYear = Integer.parseInt(publishYear)
                book.bookUrl = bookUrl

                book.save()

                result = true
            }
        } catch (e) {
            e.printStackTrace()
        }
        return result
    }

    public def deleteBook(id) {
        def result = false
        try {
            def book = getBook(id)
            if (book) {
                book.delete()
                result = true
            }
        } catch (e) {
            e.printStackTrace()
        }
        return result
    }
}
