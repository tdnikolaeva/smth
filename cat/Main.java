import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу/файлам:");
        String str = scanner.nextLine();
        ArrayList<Path> paths = PathsGetter.getPaths(str);
        BufInOut.catFiles(paths);
    }
}