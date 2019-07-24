import java.util.Scanner;

public class ProgramStarter {
    public static void main(String[] args){
        Run(LibraryType.HashMapLibrary);
        Run(LibraryType.JSONType);
    }

    public static void Run(LibraryType type){
        ILibrary hashMapLibrary = LibraryFactory.getLibrary(type);
        hashMapLibrary.addBook(new Book("War and peace", 1873),
                new Author("Lev", "Tolstoy"));
        hashMapLibrary.addBook(new Book("Anna Karenina", 1873),
                new Author("Lev", "Tolstoy"));
        hashMapLibrary.addBook(new Book("How to work", 2019),
                new Author("Petr", "Ivanov"));
        hashMapLibrary.addBook(new Book("How to not work", 2019),
                new Author("Petr", "Ivanov"));
        hashMapLibrary.changeBook(new Book("How to not work", 2019),
                new Book("How to work every night", 2019),
                new Author("Petr", "Ivanov"));
        hashMapLibrary.addBook(new Book("asdasdasdas", 2019),
                new Author("Andrey", "Boronnikov"));
        hashMapLibrary.removeBook(new Book("asdasdasdas", 2019),
                new Author("Andrey", "Boronnikov"));
        hashMapLibrary.SaveFile();

    }
}

