import lombok.Data;

@Data
public class Book {
    private final String name;
    private final int yearOfEdition;

    @Override
    public String toString() {
        return "\"" + getName() + "\" /" + getYearOfEdition() + " year";
    }
}
