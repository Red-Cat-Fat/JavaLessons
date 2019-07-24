import lombok.Data;

@Data
public class Author {
    private String name;
    private String surname;

    public Author(String name, String surname){
        setName(name);
        setSurname(surname);
    }

    @Override
    public String toString() {
        return getName() + ' ' + getSurname();
    }
}
