import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        DirLister dirLister = new DirLister();
        List<FileEntry> finalFile = dirLister.listDir(Path.of("C:\\Users\\ntd\\Desktop\\ntd\\bbbb"));
        dirLister.countDirsFiles(finalFile);
        for (FileEntry fileEntry : finalFile) {
            fileEntry.printFileEntry();
        }
    }

}