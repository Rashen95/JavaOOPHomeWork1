public class Film {
    String name;
    int release_year;
    String director;
    String genre;
    String[] genre_list = new String[]{"drama", "fantasy", "comedy"};

    public creater(String arg_name, int arg_release_year, String arg_director, int genre) {
        this.name = arg_name;
        this.release_year = arg_release_year;
        this.director = arg_director;
        this.genre = genre_list[genre];
    }

    public String getName() {
        return name;
    }
    public String getReleaseYear() {
        return String.copyValueOf(release_year);
    }
}
