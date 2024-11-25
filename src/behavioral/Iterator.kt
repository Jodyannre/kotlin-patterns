package behavioral

/* Behavioral Iterator pattern

Is a behavioral design pattern that lets you traverse elements of a collection without
exposing its underlying representation (list, stack, tree, etc.).

 */

data class Book(val title:String)

class BookShelf(private val capacity: Int): Iterable<Book> {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        if (books.size < capacity) {
            books.add(book)
        } else {
            println("The bookshelf is full.")
        }
    }

    override fun iterator(): Iterator<Book> {
        return object: Iterator<Book> {
            private var index = 0
            override fun hasNext(): Boolean {
                return index < books.size
            }
            override fun next(): Book {
                if (!hasNext()) throw NoSuchElementException()
                return books[index++]
            }
        }
    }
}


/* Example of use

fun main() {
    val bookshelf = BookShelf(2)

    val book1 = Book("Harry Potter 1")
    val book2 = Book("Lord of the Rings")
    val book3 = Book("Lorem Ipsum")

    bookshelf.addBook(book1)
    bookshelf.addBook(book2)
    bookshelf.addBook(book3)

    val iterator = bookshelf.iterator()

    while (iterator.hasNext()) {
        println(iterator.next())
    }
}
 */