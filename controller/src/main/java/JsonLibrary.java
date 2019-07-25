import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class JsonLibrary implements ILibrary {

    private ILibrary baseLibrary;
    private String filePath;

    private void TryLoadFile(){
        File file = new File(this.filePath);
        if (file.exists()) {
            baseLibrary = new HashMapLibrary(ReadFile(this.filePath));
            System.out.println("Library contains books:");
            for (Author author : baseLibrary.getAllAuthor()){
                HashSet<Book> books = baseLibrary.getBooks(author);
                for(Book book : books){
                    System.out.println(author + " " + book);
                }
            }
        }else {
            baseLibrary = new HashMapLibrary();
        }
    }

    public JsonLibrary(ILibrary baseLibrary){
        this.filePath = "D:/library.json";
        TryLoadFile();
    }

    public JsonLibrary(ILibrary baseLibrary, String filePath) {
        this.filePath = filePath;
        TryLoadFile();
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
        //я не нашёл, можно ли в методах вызывать super() по аналогии base() в c#, потому так
        baseLibrary.addBook(bookName,yearOfEtitor,author);
        SaveFile();
    }

    @Override
    public void addBook(@NotNull Book newBook, @NotNull Author author) {
        baseLibrary.addBook(newBook, author);
        SaveFile();
    }

    @Override
    public void addBook(@NotNull FullBookData fullBookData) {
        baseLibrary.addBook(fullBookData);
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

    private void SaveFile() {
        File libraryFile = new File(this.filePath);
        if (libraryFile.exists()) {
            try {
                libraryFile.delete();
                libraryFile.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        try (FileWriter writer = new FileWriter(libraryFile, false)) {
            for (Author author : baseLibrary.getAllAuthor()) {
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
