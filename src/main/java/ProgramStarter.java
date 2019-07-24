public class ProgramStarter {
    public static void main(String[] args){
        Author a = new Author("Ivan", "Semakow");
        Book book = new Book(a, "How to created games", 2019);
        System.out.println(book);
    }
}
