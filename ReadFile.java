import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ReadFile {
    public static void main(String[] args) {
        readAndPrintFile("adminCredentials.txt");
        readAndPrintFile("studentData.txt");
    }

    private static void readAndPrintFile(String fileName) {
        try (Stream<String> readFileStream = Files.lines(Paths.get(fileName))) {
            readFileStream.forEach(new Consumer<String>() {
                int testNum = 1;

                public void accept(String line) {
                    try {
                        System.out.println(line + testNum++);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
