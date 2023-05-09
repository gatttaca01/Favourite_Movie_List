public class FilmTree {
    private FilmNode root; // BST'nin kök düğümünü saklar

    // Constructor metodu, kök düğümü null olarak belirler
    public FilmTree() {
        this.root = null;
    }

    // Yeni bir film ekler
    public void addFilm(Film film) {
        FilmNode newNode = new FilmNode(film);
        if (root == null) {
            root = newNode;
        } else {
            FilmNode current = root;
            while (true) {
                if (film.getFilmName().compareTo(current.getFilm().getFilmName()) < 0) {
                    if (current.getLeftChild() == null) {
                        current.setLeftChild(newNode);
                        break;
                    } else {
                        current = current.getLeftChild();
                    }
                } else {
                    if (current.getRightChild() == null) {
                        current.setRightChild(newNode);
                        break;
                    } else {
                        current = current.getRightChild();
                    }
                }
            }
        }
    }

    // Belirli bir filmi arar ve Film nesnesini döndürür
    public Film searchFilm(String filmName) {
        FilmNode current = root;
        while (current != null) {
            if (current.getFilm().getFilmName().equals(filmName)) {
                return current.getFilm();
            } else if (filmName.compareTo(current.getFilm().getFilmName()) < 0) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return null;
    }

    // Belirli bir filmi siler
    public boolean deleteFilm(String filmName) {
        FilmNode current = root;
        FilmNode parent = root;
        boolean isLeftChild = true;

        while (!current.getFilm().getFilmName().equals(filmName)) {
            parent = current;
            if (filmName.compareTo(current.getFilm().getFilmName()) < 0) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null) {
                return false;
            }
        }

        // Silinecek düğümün çocuklarından en az biri yoksa
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        }
        // Silinecek düğümün bir çocuğu yoksa
        else if (current.getRightChild() == null) {
            if (current == root) {
                root = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (current == root) {
                root = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        }
        // Silinecek düğümün iki çocuğu da varsa
        else {
            FilmNode successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeftChild(successor
            } else {
                parent.setRightChild(successor);
            }
    
            successor.setLeftChild(current.getLeftChild());
        }
    
        return true;
    }
    
    // Belirli bir film için IMDB puanını günceller
    public boolean updateImdbScore(String filmName, double newScore) {
        Film filmToUpdate = searchFilm(filmName);
        if (filmToUpdate != null) {
            filmToUpdate.setImdbScore(newScore);
            return true;
        } else {
            return false;
        }
    }
    
    // Belirli bir film için yayın tarihini günceller
    public boolean updateReleaseDate(String filmName, String newReleaseDate) {
        Film filmToUpdate = searchFilm(filmName);
        if (filmToUpdate != null) {
            filmToUpdate.setReleaseDate(newReleaseDate);
            return true;
        } else {
            return false;
        }
    }
    
    // Belirli bir filme yeni bir oyuncu ekler
    public void addActor(String filmName, String newActor) {
        Film filmToUpdate = searchFilm(filmName);
        if (filmToUpdate != null) {
            ArrayList<String> actors = filmToUpdate.getActors();
            actors.add(newActor);
        }
    }
    
    // Düğümün halefi (en küçük sağ alt düğümü)ni döndürür
    private FilmNode getSuccessor(FilmNode node) {
        FilmNode parent = node;
        FilmNode successor = node;
        FilmNode current = node.getRightChild();
    
        while (current != null) {
            parent = successor;
            successor = current;
            current = current.getLeftChild();
        }
    
        if (successor != node.getRightChild()) {
            parent.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }
    
        return successor;
    }
    