import lombok.Data;

@Data
public class Book {
    private final Author author;
    private final String name;
    private final int yearOfEdition;

    @Override
    public String toString() {
        return getAuthor() + " \"" + getName() + "\" /" + getYearOfEdition() + " year";
    }
}
