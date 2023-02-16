import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class PathsGetter {
    public static ArrayList<Path> getPaths(String str) throws IOException {
        ArrayList<Path> paths = new ArrayList<>();
        for (String s : str.split(" ")) {
            Path path = Path.of(s);
            if (!Files.exists(path)) {
                throw new IOException("Передали несуществующий файл");
            }
            paths.add(path);
        }
        return paths;
    }
}
