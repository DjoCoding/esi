record Location(int row, int col) {
}

class Solution {

    private static Integer findLocationInRow(boolean[] row, int cols, int k) {
        for (int col = 0; col < cols - k; ++col) {
            boolean found = true;

            for (int j = 0; j < k; ++j) {
                if (row[col + j]) {
                    found = false;
                    break;
                }
            }

            if (found)
                return col;
        }

        return null;
    }

    public static Location findLocation(boolean[][] seats, int rows, int cols, int k) {
        if (k > cols)
            return null;

        for (int row = 0; row < rows; ++row) {
            Integer col = Solution.findLocationInRow(seats[row], cols, k);
            if (col != null)
                return new Location(row, col);
        }

        return null;
    }
}

public class Main {
    public static void main(String[] args) {
    }
}