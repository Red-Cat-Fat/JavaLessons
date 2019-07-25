import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class JsonLibrary implements ILibrary {

    private ILibrary baseLibrary;
    private String filePath;

    private void TryLoadFile() {
        File file = new File(this.filePath);
        if (file.exists()) {
            baseLibrary = new HashMapLibrary(JsonWriteRead.ReadFile(this.filePath));
            System.out.println("Library contains books:");
            for (Author author : baseLibrary.getDataBase().keySet()) {
                HashSet<Book> books = baseLibrary.getBooks(author);
                for (Book book : books) {
                    System.out.println(author + " " + book);
                }
            }
        } else {
            baseLibrary = new HashMapLibrary();
        }
    }

    public JsonLibrary(ILibrary baseLibrary){
        this.baseLibrary = baseLibrary;
        this.filePath = "library.json";
        TryLoadFile();
    }

    public JsonLibrary(ILibrary baseLibrary, String filePath) {
        this.baseLibrary = baseLibrary;
        this.filePath = filePath;
        TryLoadFile();
    }

    @Override
    public void addBook(@NotNull Book newBook, @NotNull Author author) {
        baseLibrary.addBook(newBook, author);
        SaveFile();
    }

    @Override
    public void changeBook(@NotNull Book oldBook, @NotNull Book newBook, @NotNull Author author) {
        baseLibrary.changeBook(oldBook, newBook, author);
        SaveFile();
    }

    @Override
    public void removeBook(@NotNull Book book, @NotNull Author author) {
        baseLibrary.removeBook(book, author);
        SaveFile();
    }

    @Override
    public HashSet<Book> getBooks(@NotNull Author author) {
        return baseLibrary.getBooks(author);
    }

    @Override
    public Set<Author> getAllAuthor() {
        return baseLibrary.getAllAuthor();
    }

    @Override
    public HashMap<Author, HashSet<Book>> getDataBase() {
        return baseLibrary.getDataBase();
    }

    private void SaveFile() {
        JsonWriteRead.WriteFile(baseLibrary.getDataBase(), this.filePath);
    }
}
