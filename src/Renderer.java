public class Renderer {

    public static final char DEFAULT = ' ';
    public static final char MINE = 'X';
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private static int cellCol2GridCol(int cellCol) {
        return 2 + (2 * cellCol);
    }

    private static int cellRow2GridRow(int cellRow) {
        return 1 + cellRow;
    }

    public static char[][] render(int width, int height) {
        if (width <= 0 || width > 10 || height <= 0 || height > 10) {
            throw new IllegalArgumentException();
        }
        char[][] grid = new char[height + 1][width * 2 + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = DEFAULT;
            }
        }
        for (int i = 1; i <= width; i++) {
            grid[0][cellCol2GridCol(i - 1)] = DIGITS[i];
        }
        for (int i = 1; i <= height; i++) {
            grid[cellRow2GridRow(i - 1)][0] = (char) ('A' + i - 1);
        }
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                grid[cellRow2GridRow(i - 1)][cellCol2GridCol(j - 1)] = '·';
            }
        }
        return grid;
    }

    public static char[][] render(Minefield minefield) {
        if (minefield == null) {
            throw new NullPointerException();
        }
        char[][] grid = render(minefield.getWidth(), minefield.getHeight());
        for (int i = 0; i < minefield.getHeight(); i++) {
            for (int j = 0; j < minefield.getWidth(); j++) {
                Location location = new Location(i, j);
                int adjacencyCount = minefield.getAdjacentMines(location);
                if (minefield.hasMine(location)) {
                    grid[cellRow2GridRow(i)][cellCol2GridCol(j)] = MINE;
                } 
                else {
                    grid[cellRow2GridRow(i)][cellCol2GridCol(j)] = DIGITS[adjacencyCount];
                }
            }
        }
        return grid;
    }

    public static char[][] render(Minefield minefield, Guesses guesses) {
        if (minefield == null || guesses == null) {
            throw new NullPointerException();
        }

        int height = minefield.getHeight();
        int width = minefield.getWidth();
        char[][] grid = render(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Location location = new Location(i, j);
                boolean isGuessed = guesses.isGuessed(location);
                boolean hasMine = minefield.hasMine(location);

                if (isGuessed) {
                    if (hasMine) {
                        grid[cellRow2GridRow(i)][cellCol2GridCol(j)] = MINE;
                    } 
                    else {
                        int adjacencyCount = minefield.getAdjacentMines(location);
                        grid[cellRow2GridRow(i)][cellCol2GridCol(j)] = DIGITS[adjacencyCount];
                    }
                } 
                else if (!hasMine) {
                    grid[cellRow2GridRow(i)][cellCol2GridCol(j)] = '·';
                }
            }
        }
        return grid;
    }

    public static void display(char[][] grid) {
        if (grid == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}


