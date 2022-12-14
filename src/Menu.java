import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Menu {

    public void hello_menu() throws IOException {
        System.out.println("====================############=======================");
        System.out.println("             Перед вами библиотека фильмов             ");
        menu();
    }
    public void menu() throws IOException {
        boolean flag = false;
        while (!flag) {
            HashSet<Film> all_films; // Сюда будет происходить считывание файла
            all_films = new Reader().read();
            Scanner s = new Scanner(System.in);
            System.out.println("====================############=======================");
            System.out.println("Выберите необходимый пункт меню, путем ввода числа:");
            System.out.println("""
                    1. Вывести весь список фильмов
                    2. Поиск фильма по названию
                    3. Завершить работу библиотеки""");
            String change = s.next();
            if (change.equals("1") || change.equals("2") || change.equals("3")) {
                if (change.equals("1")) {
                    for (Film p: all_films) {
                        p.info();
                    }
                    menu();
                    flag = true;
                } else if (change.equals("2")) {
                    new Searcher().search(all_films);
                    flag = true;
                } else {
                    System.out.println("[--------------------------]");
                    System.out.println(" Завершаю работу библиотеки ");
                    System.out.println("[--------------------------]");
                    flag = true;
                }
            } else {
                System.out.println("[----------------------]");
                System.out.println(" Нет такого пункта меню ");
                System.out.println("[----------------------]");
            }
        }
    }
}