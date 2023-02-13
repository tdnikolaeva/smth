import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DirLister {
    private FileEntry getFileEntry(Path path) throws IOException {
        String s = path.getFileName().toString();
        long size = Files.size(path);
        FileType type = Files.isDirectory(path) ? FileType.DIR_TYPE : FileType.FILE_TYPE;
        return new FileEntry(s,size,type);
    }
    public int compare(FileEntry o1, FileEntry o2) {
        if (o1.getType() == o2.getType())
            return o1.toString().compareTo(o2.toString());
        else if (o1.getType() == FileType.DIR_TYPE)
            return -1;
        return 1;
    }
    public List<FileEntry> listDir(Path pathEntry) throws IOException {
        if (!Files.exists(pathEntry)) {
            throw new IOException("Передали несуществующий файл");
        }
        if (!Files.isDirectory(pathEntry)) {
            throw new IOException("Передали не папку");
        }
        try {
            List<Path> listing = Files.walk(pathEntry, 1).toList();
            List<FileEntry> arrList = new ArrayList<>();
            for (Path path : listing) {
                arrList.add(getFileEntry(path));
            }
            arrList.sort(this::compare);
            return arrList;
        } catch (IOException e) {
            throw new IOException("Возникла ошибка при сканировании папки", e);
        }
    }
    public void countDirsFiles(List<FileEntry> arrList){
        int dirs = 0;
        int files = 0;
        for (FileEntry fileEntry : arrList) {
            if (fileEntry.getType() == FileType.DIR_TYPE)
                dirs += 1;
            else
                files += 1;
        }
        System.out.printf("Количесто папок: %s[35m%d%s[0m \n", (char) 27, dirs, (char) 27);
        System.out.printf("Количество файлов: %s[32m%d%s[0m \n", (char) 27, files, (char) 27);
    }
}
