import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class JsonLibrary implements ILibrary {

    private HashMapLibrary baseLibrary;
    private String filePath;
    public JsonLibrary(String filePath) {
        this.filePath = filePath;
        baseLibrary = new HashMapLibrary(ReadFile(this.filePath));
    }

    private static HashMap<Author, HashSet<Book>> ReadFile(String filePath){
        HashMapLibrary library = new HashMapLibrary();
        Gson gson = new Gson();
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                FullBookData data = gson.fromJson(line, FullBookData.class);
                library.addBook(data);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return library.getLibrary();
    }

    @Override
    public void addBook(@NotNull String bookName, @NotNull int yearOfEtitor, @NotNull Author author) {
        baseLibrary.addBook(bookName,yearOfEtitor,author);
        SaveFile(this.filePath);
    }

    @Override
    public void addBook(@NotNull Book newBook, @NotNull Author author) {
        baseLibrary.addBook(newBook, author);
        SaveFile(this.filePath);
    }

    @Override
    public void addBook(@NotNull FullBookData fullBookData) {
        baseLibrary.addBook(fullBookData);
        SaveFile(this.filePath);
    }

    @Override
    public void changeBook(@NotNull Book oldBook, @NotNull Book newBook, @NotNull Author author) {
        baseLibrary.changeBook(oldBook, newBook, author);
        SaveFile(this.filePath);
    }

    @Override
    public void removeBook(@NotNull Book book, @NotNull Author author) {
        baseLibrary.removeBook(book, author);
        SaveFile(this.filePath);
    }

    @Override
    public HashSet<Book> getBooks(@NotNull Author author) {
        return baseLibrary.getBooks(author);
    }

    private void SaveFile(String pathFile) {
        File libraryFile = new File(pathFile);
        if (libraryFile.exists()) {
            try {
                libraryFile.delete();
                libraryFile.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        try (FileWriter writer = new FileWriter(libraryFile, false)) {
            for (Author author : baseLibrary.getLibrary().keySet()) {
                HashSet<Book> books = getBooks(author);
                for (Book book : books) {
                    FullBookData fullBookData = new FullBookData(author, book);
                    Gson gson = new Gson();
                    String text = gson.toJson(fullBookData);
                    writer.write(text);
                    writer.append('\n');
                }
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
