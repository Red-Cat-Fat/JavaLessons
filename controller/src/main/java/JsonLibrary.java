import java.util.HashMap;
import java.util.HashSet;

public class JsonLibrary extends HashMapLibrary {

    public JsonLibrary(HashMap<Author, HashSet<Book>> library) {
        super(library);
    }
}
