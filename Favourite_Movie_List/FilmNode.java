package sen2212_Datastruc;

public class FilmNode {
    private Film film; // Film nesnesini tutar
    private FilmNode leftChild; // sol çocuk düğümün işaretçisini tutar
    private FilmNode rightChild; // sağ çocuk düğümün işaretçisini tutar

    // Constructor metodu, Film nesnesini parametre olarak alır
    public FilmNode(Film film) {
        this.film = film;
        this.leftChild = null;
        this.rightChild = null;
    }

    // Getter ve setter metotları
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public FilmNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(FilmNode leftChild) {
        this.leftChild = leftChild;
    }

    public FilmNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(FilmNode rightChild) {
        this.rightChild = rightChild;
    }
}

