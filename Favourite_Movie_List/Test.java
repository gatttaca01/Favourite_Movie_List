public class Test {
    public static void main(String[] args) {
        // FilmTree nesnesi oluşturulur
        FilmTree filmTree = new FilmTree();

        // Filmler oluşturulur
        Film film1 = new Film("Inception", "Christopher Nolan", Arrays.asList("Leonardo DiCaprio", "Ellen Page"), 8.8, "2010");
        Film film2 = new Film("The Shawshank Redemption", "Frank Darabont", Arrays.asList("Tim Robbins", "Morgan Freeman"), 9.3, "1994");
        Film film3 = new Film("The Godfather", "Francis Ford Coppola", Arrays.asList("Marlon Brando", "Al Pacino"), 9.2, "1972");

        // Filmler BST'ye eklenir
        filmTree.addFilm(film1);
        filmTree.addFilm(film2);
        filmTree.addFilm(film3);

        // Filmler aranır ve güncellenir
        Film searchedFilm = filmTree.searchFilm("Inception");
        if (searchedFilm != null) {
            filmTree.updateImdbScore(searchedFilm.getFilmName(), 9.0);
            filmTree.updateReleaseDate(searchedFilm.getFilmName(), "2011");
            filmTree.addActor(searchedFilm.getFilmName(), "Tom Hardy");
        }

        // Filmler silinir
        filmTree.deleteFilm("The Godfather");

        // Bağlantılı liste oluşturulur ve bilgiler eklenir
        LinkedList linkedList = new LinkedList();
        linkedList.addInfo("Leonardo DiCaprio");
        linkedList.addInfo("Morgan Freeman");
        linkedList.addInfo("Tom Hardy");

        // Bilgiler aranır ve silinir
        System.out.println(linkedList.searchInfo("Morgan Freeman")); // true
        linkedList.deleteInfo("Morgan Freeman");
        System.out.println(linkedList.searchInfo("Morgan Freeman")); // false

        // Tüm bilgiler listelenir
        ArrayList<String> infoList = linkedList.listInfo();
        for (String info : infoList) {
            System.out.println(info);
        }
    }
}