package challenge6;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GhibliFilms {

    public static List<Film> loadFilms(String filePath) {
        List<Film> films = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String title = scanner.nextLine().trim();
                if (title.equals("---") || title.isEmpty()) continue;

                String director    = scanner.nextLine();
                String producer    = scanner.nextLine();
                String releaseDate = scanner.nextLine();
                String runningTime = scanner.nextLine();
                String description = scanner.nextLine();

                films.add(new Film(title, director, producer, releaseDate, runningTime, description));

                // skip separator line
                if (scanner.hasNextLine()) scanner.nextLine();
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return films;
    }

    public static void main(String[] args) {
        List<Film> films = loadFilms("./src/challenge6/films.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== STUDIO GHIBLI FILMS ===");
            for (int i = 0; i < films.size(); i++) {
                System.out.println((i + 1) + ". " + films.get(i).getTitle());
            }
            System.out.println("0. Exit");
            System.out.print("Choose a film: ");

            String input = scanner.nextLine().trim();

            if (input.equals("0")) break;

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= films.size()) {
                    Film film = films.get(choice - 1);
                    System.out.println("\nTitle:       " + film.getTitle());
                    System.out.println("Director:    " + film.getDirector());
                    System.out.println("Producer:    " + film.getProducer());
                    System.out.println("Year:        " + film.getReleaseDate());
                    System.out.println("Runtime:     " + film.getRunningTime() + " min");
                    System.out.println("Description: " + film.getDescription());
                }
            } catch (NumberFormatException e) {
                // ignore invalid input
            }
        }

        scanner.close();
    }
}
