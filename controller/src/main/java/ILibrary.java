import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public interface ILibrary {
    void addBook(@NotNull Book newBook, @NotNull Author author);
    void changeBook(@NotNull Book oldBook, @NotNull Book newBook, @NotNull Author author);
    void removeBook(@NotNull Book book, @NotNull Author author);

    HashSet<Book> getBooks(@NotNull Author author);
    Set<Author> getAllAuthor();
    HashMap<Author, HashSet<Book>> getDataBase();
}
