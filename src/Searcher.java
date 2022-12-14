import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Searcher {
    public void search(HashSet<Film> all_films) throws IOException {
        boolean flag = false;
        while (!flag) {
            Scanner s = new Scanner(System.in);
            System.out.println("Введите название или часть названия фильма для поиска: ");
            String request = s.next();
            Map<Integer, Film> found_movies = new HashMap<>();
            if (request.isEmpty()) {
                System.out.println("====================############=======================");
                System.out.println("                Вы ничего не ввели                     ");
                System.out.println("====================############=======================");
            } else {
                int i = 1;
                for (Film a : all_films) {
                    if (a.getName().toLowerCase().contains(request.toLowerCase())) {
                        found_movies.put(i, a);
                        i++;
                    }
                }
            }
            if (found_movies.isEmpty()) {
                System.out.println("====================############=======================");
                System.out.println("        По вашему запросу ничего не найдено            ");
                System.out.println("====================############=======================");
                while (!flag) {
                    System.out.println("Если вы хотите продолжить поиск, введите 1");
                    System.out.println("Если вы хотите вернутся в предыдущее меню, введите 2: ");
                    request = s.next();
                    if (request.equals("1") || request.equals("2")) {
                        if (request.equals("1")) {
                            flag = true;
                            search(all_films);
                        } else {
                            flag = true;
                            new Menu().hello_menu();
                        }
                    }
                }
            } else {
                System.out.println("Список фильмов согласно вашего запроса:");
                for (Map.Entry<Integer, Film> entry : found_movies.entrySet()) {
                    System.out.printf("%d. %s\n", entry.getKey(), entry.getValue().getName());
                }
                System.out.println("Вы можете узнать дополнительную информацию по найденным фильмам");
                while (!flag) {
                    System.out.println("Введите цифру соответствующую фильму, который вас интересует: ");
                    request = s.next();
                    if (found_movies.containsKey(Integer.parseInt(request))) {
                        flag = true;
                        boolean flag2 = false;
                        while (!flag2) {
                            System.out.println("""
                                    1. Узнать год выхода фильма
                                    2. Узнать сценариста
                                    3. Узнать жанр
                                    4. Вернутся в меню поиска
                                    5. Вернутся в главное меню
                                    """);
                            System.out.print("Введите цифру соответствующую пункту меню: ");
                            String request2 = s.next();
                            if (request2.equals("1") || request2.equals("2") || request2.equals("3") || request2.equals("4") || request2.equals("5")) {
                                switch (request2) {
                                    case "1" -> {
                                        System.out.println("====================############=======================");
                                        System.out.printf("Фильм %s был снят в %s году\n", found_movies.get(Integer.parseInt(request)).getName(), found_movies.get(Integer.parseInt(request)).getReleaseYear());
                                        System.out.println("====================############=======================");
                                    }
                                    case "2" -> {
                                        System.out.println("====================############=======================");
                                        System.out.printf("Фильм %s снял %s\n", found_movies.get(Integer.parseInt(request)).getName(), found_movies.get(Integer.parseInt(request)).getDirector());
                                        System.out.println("====================############=======================");
                                    }
                                    case "3" -> {
                                        System.out.println("====================############=======================");
                                        System.out.printf("Фильм %s снят в жанре %s\n", found_movies.get(Integer.parseInt(request)).getName(), found_movies.get(Integer.parseInt(request)).getGenre());
                                        System.out.println("====================############=======================");
                                    }
                                    case "4" -> {
                                        search(all_films);
                                        flag2 = true;
                                    }
                                    default -> {
                                        new Menu().hello_menu();
                                        flag2 = true;
                                    }
                                }
                            } else {
                                System.out.println("====================############=======================");
                                System.out.println("                  Такого пункта нет                    ");
                                System.out.println("====================############=======================");
                            }
                        }
                    } else {
                        System.out.println("====================############=======================");
                        System.out.println("                  Такого пункта нет                    ");
                        System.out.println("====================############=======================");
                    }
                }
            }
        }
    }
}