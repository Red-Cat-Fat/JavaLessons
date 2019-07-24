import lombok.Data;

@Data
public class Author {
    private final String name;
    private final String surname;

    @Override
    public String toString() {
        return getName() + ' ' + getSurname();
    }
}
