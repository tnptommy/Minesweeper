public class Minefield {

    private int width;
    private int height;
    private boolean[][] hasMine;
    private int totalMines;

    public Minefield(int width, int height) {
        this.width = width;
        this.height = height;
        this.hasMine = new boolean[height][width];
        this.totalMines = 0;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isInBounds(Location location) {
        return location.getRow() >= 0 && location.getRow() < height && location.getCol() >= 0 && location.getCol() < width;
    }

    public void placeMine(Location location) {
        if (isInBounds(location) && !hasMine[location.getRow()][location.getCol()]) {
            hasMine[location.getRow()][location.getCol()] = true;
            totalMines++;
        }
    }

    public boolean hasMine(Location location) {
        if (location == null || !isInBounds(location)) {
            return false;
        }
        return hasMine[location.getRow()][location.getCol()];
    }

    public int getTotalMines() {
        return totalMines;
    }

    public int getAdjacentMines(Location location) {
    if (location == null || !isInBounds(location)) {
        return 0;
    }

    int count = 0;
    int startRow = Math.max(location.getRow() - 1, 0);
    int endRow = Math.min(location.getRow() + 1, height - 1);
    int startCol = Math.max(location.getCol() - 1, 0);
    int endCol = Math.min(location.getCol() + 1, width - 1);


    for (int row = startRow; row <= endRow; row++) {
        for (int col = startCol; col <= endCol; col++) {
            if (row == location.getRow() && col == location.getCol()) {
                continue;
            }
            if (hasMine[row][col]) {
                count++;
                }
            }
        }
        return count;
    }
}
