import java.util.ArrayList;
import java.util.List;

public class Guesses {
    private boolean[][] guesses;
    private int totalGuesses;

    public Guesses(int width, int height) {
        guesses = new boolean[height][width];
        totalGuesses = 0;
        for (int i = 0; i < guesses.length; i++) {
            for (int j = 0; j < guesses[i].length; j++) {
                guesses[i][j] = false;
            }
        }
    }

    public void addGuess(Location location) {
        if (location == null) {
            return;
        }

        int row = location.getRow();
        int col = location.getCol();

        if (isValidLocation(location) && !guesses[row][col]) {
            guesses[row][col] = true;
            totalGuesses++;
        }
    }

    public int getTotalGuesses() {
        return totalGuesses;
    }

    private List<Location> getGuessedLocations() {
        List<Location> guessedLocations = new ArrayList<>();
        for (int i = 0; i < guesses.length; i++) {
            for (int j = 0; j < guesses[i].length; j++) {
                if (guesses[i][j]) {
                    guessedLocations.add(new Location(i, j));
                }
            }
        }
        return guessedLocations;
    }

    public boolean isGuessed(Location location) {
        if (location == null) {
            return false;
        }

        int row = location.getRow();
        int col = location.getCol();

        return isValidLocation(location) && guesses[row][col];
    }

    private boolean isValidLocation(Location location) {
        int row = location.getRow();
        int col = location.getCol();

        return row >= 0 && row < guesses.length 
            && col >= 0 && col < guesses[row].length; 
    }
}


