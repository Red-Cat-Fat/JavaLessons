import org.jetbrains.annotations.NotNull;

public class LibraryFactory {

    public static ILibrary getLibrary(@NotNull LibraryType type){
        switch (type){
            case HashMapLibrary:
                return new HashMapLibrary();
            case JSONType:
                return new JsonLibrary(new HashMapLibrary(), "library.json");
            case DataBaseType:
                return null;
        }
        return null;
    }
}
