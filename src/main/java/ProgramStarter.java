import java.util.Scanner;

public class ProgramStarter {
    public static void main(String[] args){
        Run(LibraryType.HashMapLibrary);
        Run(LibraryType.JSONType);
    }

    public static void Run(LibraryType type){
        ILibrary libraryFile = LibraryFactory.getLibrary(type);
        libraryFile.addBook(new Book("War and peace", 1873),
                new Author("Lev", "Tolstoy"));
        libraryFile.addBook(new Book("Anna Karenina", 1873),
                new Author("Lev", "Tolstoy"));
        libraryFile.addBook(new Book("How to work", 2019),
                new Author("Petr", "Ivanov"));
        libraryFile.addBook(new Book("How to not work", 2019),
                new Author("Petr", "Ivanov"));
        libraryFile.changeBook(new Book("How to not work", 2019),
                new Book("How to work every night", 2019),
                new Author("Petr", "Ivanov"));
        libraryFile.addBook(new Book("asdasdasdas", 2019),
                new Author("Andrey", "Boronnikov"));
        libraryFile.removeBook(new Book("asdasdasdas", 2019),
                new Author("Andrey", "Boronnikov"));
    }
}

