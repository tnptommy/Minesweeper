import java.util.Scanner;

public class Minesweeper {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Minefield minefield = MinefieldGenerator.generateMinefield(input);
        Guesses guesses = new Guesses(minefield.getWidth(), minefield.getHeight());
        int safeSpots = minefield.getWidth() * minefield.getHeight() - minefield.getTotalMines();

        while (true) {
            Renderer.display(Renderer.render(minefield, guesses));
            Location guess = getUserGuess();

            guesses.addGuess(guess);

            if (minefield.hasMine(guess)) {
                Renderer.display(Renderer.render(minefield));
                System.out.println("BOOM! Game over.");
                break;
            }

            GuessExpander expander = new GuessExpander(minefield);
            guesses = expander.expandGuess(guess, guesses);
            safeSpots -= 1;

            if (safeSpots == 0) {
                Renderer.display(Renderer.render(minefield));
                System.out.println("Minefield cleared. Well done!");
                break;
            }
        }
    }

    private static Location getUserGuess() {
        Location guess = null;
        do {
            System.out.println("Guess a location: ");
            String location = input.nextLine().trim().toUpperCase();
            guess = Location.fromString(location);

            if (guess == null) {
                System.out.println("Invalid location, please try again.");
            }
        } while (guess == null);

        return guess;
    }
}




