public class Film {
    String name;
    String release_year;
    String director;
    String genre;

    Film(String arg_name, String arg_release_year, String arg_director, String arg_genre) {
        this.name = arg_name;
        this.release_year = arg_release_year;
        this.director = arg_director;
        this.genre = arg_genre;
    }

    public String getName() {
        return name;
    }

    public String getReleaseYear() {
        return release_year;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public void info() {
        System.out.println("====================############=======================");
        System.out.printf("Название фильма: %s", name);
        System.out.println();
        System.out.printf("Год релиза: %s", release_year);
        System.out.println();
        System.out.printf("Сценарист: %s", director);
        System.out.println();
        System.out.printf("Жанр: %s", genre);
        System.out.println();
    }
}