import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;

public class Reader {

    public HashSet<Film> read() throws IOException {
        String fileName = "src/films.txt";
        String text = readUsingScanner(fileName); // Чтение в text
        HashSet<Film> all_films = new HashSet<>();
        text = text.replace("\n", ", ");
        String[] array = text.split(", ");
        for (int i = 0; i < array.length; i += 4) {
            all_films.add(new Film(array[i], array[i + 1], array[i + 2], array[i + 3]));
        }
        return all_films;
    }

    // Чтение из файла и преобразование в строку
    private static String readUsingScanner(String fileName) throws IOException {
        Scanner s = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8);
        String data = s.useDelimiter("\\Z").next();
        s.close();
        return data;
    }
}
