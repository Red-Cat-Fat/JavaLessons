import org.jetbrains.annotations.NotNull;

public class LibraryFactory {

    public ILibrary getLibrary(@NotNull LibraryType type){
        switch (type){
            case JSONType:
                return null;
            case DataBaseType:
                return null;
        }
        return null;
    }
}
