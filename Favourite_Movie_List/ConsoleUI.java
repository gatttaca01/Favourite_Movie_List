import java.util.Scanner;

public class ConsoleUI {
    private static Scanner scanner = new Scanner(System.in);
    private static FilmTree filmTree = new FilmTree();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Add film");
            System.out.println("2. Update film");
            System.out.println("3. Delete film");
            System.out.println("4. Search film");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // to consume the newline character

            switch (choice) {
                case 1:
                    addFilm();
                    break;
                case 2:
                    updateFilm();
                    break;
                case 3:
                    deleteFilm();
                    break;
                case 4:
                    searchFilm();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addFilm() {
        System.out.print("Enter film name: ");
        String filmName = scanner.nextLine();

        System.out.print("Enter director name: ");
        String directorName = scanner.nextLine();

        System.out.print("Enter actor names (comma-separated): ");
        String actorsString = scanner.nextLine();
        String[] actors = actorsString.split(",");

        System.out.print("Enter IMDB score: ");
        double imdbScore = scanner.nextDouble();
        scanner.nextLine(); // to consume the newline character

        System.out.print("Enter release date: ");
        String releaseDate = scanner.nextLine();

        Film film = new Film(filmName, directorName, Arrays.asList(actors), imdbScore, releaseDate);
        filmTree.addFilm(film);

        System.out.println("Film added successfully.");
    }

    private static void updateFilm() {
        System.out.print("Enter film name: ");
        String filmName = scanner.nextLine();

        Film film = filmTree.searchFilm(filmName);

        if (film == null) {
            System.out.println("Film not found.");
            return;
        }

        System.out.println("Select field to update:");
        System.out.println("1. Director name");
        System.out.println("2. Actor names");
        System.out.println("3. IMDB score");
        System.out.println("4. Release date");

        int choice = scanner.nextInt();
        scanner.nextLine(); // to consume the newline character

        switch (choice) {
            case 1:
                System.out.print("Enter new director name: ");
                String directorName = scanner.nextLine();
                film.setDirectorName(directorName);
                System.out.println("Director name updated successfully.");
                break;
            case 2:
                System.out.print("Enter new actor names (comma-separated): ");
                String actorsString = scanner.nextLine();
                String[] actors = actorsString.split(",");
                film.setActors(Arrays.asList(actors));
                System.out.println("Actor names updated successfully.");
                break;
            case 3:
                System.out.print("Enter new IMDB score: ");
                double imdbScore = scanner.nextDouble();
                scanner
