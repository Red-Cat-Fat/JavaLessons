import org.jetbrains.annotations.NotNull;
import java.util.HashSet;

public interface ILibrary {
    void addBook(@NotNull String bookName,@NotNull  int yearOfEtitor, @NotNull Author author);
    void addBook(@NotNull Book newBook, @NotNull Author author);
    void changeBook(@NotNull Book oldBook, @NotNull Book newBook, @NotNull Author author);
    void removeBook(@NotNull Book book, @NotNull Author author);

    HashSet<Book> getBooks(@NotNull Author author);
}
