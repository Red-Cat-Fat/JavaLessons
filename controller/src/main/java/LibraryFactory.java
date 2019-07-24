import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;

public class LibraryFactory {

    public static ILibrary getLibrary(@NotNull LibraryType type){
        switch (type){
            case JSONType:
                return null;
            case DataBaseType:
                return null;
        }
        return null;
    }
}
