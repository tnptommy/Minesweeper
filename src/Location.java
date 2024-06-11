public class Location {

    public static char[] ROW_CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
    public static char[] COL_CHARS = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private int row;
    private int col;

    public Location(int row, int col) {
        if (isValid(row, col)) {
            this.row = row;
            this.col = col;
        } 
        else {
            this.row = -1; 
            this.col = -1; 
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

   
    public String toString() {
        if (isValid(row, col)) {
            return ROW_CHARS[row] + String.valueOf(COL_CHARS[col]);
        } 
        else {
            return "INVALID";
        }
    }

    public static Location fromString(String str) {
        if (str == null || str.length() != 2) {
            return null;
        }

        str = str.trim().toUpperCase();

        int row = indexOf(ROW_CHARS, str.charAt(0));
        int col = indexOf(COL_CHARS, str.charAt(1));

        if (isValid(row, col)) {
            return new Location(row, col);
        }

        return null;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < ROW_CHARS.length && col >= 0 && col < COL_CHARS.length;
    }

    private static int indexOf(char[] array, char character) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == character) {
                return i;
            }
        }
        return -1;
    }
}

