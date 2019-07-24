import com.sun.istack.internal.NotNull;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.HashSet;

@NoArgsConstructor
public class HashMapLibrary implements ILibrary{

    public HashMapLibrary(HashMap<Author, HashSet<Book>> library){
        this.library = library;
    }

    private HashMap<Author, HashSet<Book>> library = new HashMap<>();

    @Override
    public void addBook(@NotNull String bookName, @NotNull int yearOfEtitor, @NotNull Author author) {
        Book newBook = new Book(bookName, yearOfEtitor);
        addBook(newBook, author);
    }

    @Override
    public void addBook(@NotNull Book newBook, @NotNull Author author) {
        if (library.containsKey(author)) {
            HashSet<Book> books = library.get(author);
            books.add(newBook);
        }else{
            HashSet<Book> books = new HashSet<>();
            books.add(newBook);
            library.put(author, books);
        }
    }

    @Override
    public void changeBook(@NotNull Book oldBook, @NotNull Book newBook, @NotNull Author author) {
        if(library.containsKey(author)) {
            HashSet<Book> books = library.get(author);
            if (books.equals(oldBook)) {
                books.remove(oldBook);
                books.add(newBook);
            }
        }
    }

    @Override
    public void removeBook(@NotNull Book book, @NotNull Author author) {
        if(library.containsKey(author)) {
            HashSet<Book> books = library.get(author);
            if (books.equals(book)) {
                books.remove(book);
            }
        }
    }

    @Override
    public HashSet<Book> getBooks(Author author) {
        if(library.containsKey(author)){
            return library.get(author);
        }
        return null;
    }
}
