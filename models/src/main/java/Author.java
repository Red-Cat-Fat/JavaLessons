import lombok.Data;

@Data
public class Author {
    private String name;
    private String surname;

    public Author(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return getName() + ' ' + getSurname();
    }
}
