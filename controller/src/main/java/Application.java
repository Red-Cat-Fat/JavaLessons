import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        System.out.println("===============================================================");
        Run(LibraryType.HashMapLibrary);
        System.out.println("===============================================================");
        Run(LibraryType.JSONType);
    }

    private static void Run(LibraryType type){
        ILibrary libraryFile = LibraryFactory.getLibrary(type);
        if(libraryFile == null){
            return;
        }
        libraryFile.addBook(
                new Book("War and peace", 1873),
                new Author("Lev", "Tolstoy"));
        libraryFile.addBook(
                new Book("Anna Karenina", 1873),
                new Author("Lev", "Tolstoy"));
        libraryFile.addBook(
                new Book("How to work", 2019),
                new Author("Petr", "Ivanov"));
        libraryFile.addBook(
                new Book("How to not work", 2019),
                new Author("Petr", "Ivanov"));
        libraryFile.changeBook(
                new Book("How to not work", 2019),
                new Book("How to work every night", 2019),
                new Author("Petr", "Ivanov"));
        libraryFile.addBook(
                new Book("asdasdasdas", 2019),
                new Author("Andrey", "Boronnikov"));
        libraryFile.removeBook(
                new Book("asdasdasdas", 2019),
                new Author("Andrey", "Boronnikov"));
    }
}
