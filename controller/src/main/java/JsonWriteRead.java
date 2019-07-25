import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class JsonWriteRead {

    private static final class LibraryDataType extends TypeToken<HashMap<Author, HashSet<Book>>> {

    }

    private static HashMap<Author, HashSet<Book>> ReadFile(String filePath) {
        final URL resource = LibraryFactory.class.getClassLoader().getResource(filePath);
        try {
            final Path path = Paths.get(Objects.requireNonNull(resource).toURI());
            final String json = new String(Files.readAllBytes(path));
            final Gson gson = new Gson();
            final HashMap<Author, HashSet<Book>> map = gson.fromJson(json, new LibraryDataType().getType());
            return map;
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    public static void WriteFile(HashMap<Author, HashSet<Book>> library, String filePath) {
        final Gson gson = new Gson();
        final String json = gson.toJson(library, new LibraryDataType().getType());

        File libraryFile = new File(filePath);
        if (libraryFile.exists()) {
            try {
                libraryFile.delete();
                libraryFile.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter(libraryFile, false)) {
            writer.write(json);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
