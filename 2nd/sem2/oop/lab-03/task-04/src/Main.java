class Matrix {
    private final int rowsCount;
    private final int colsCount;
    private final int[][] data;

    public Matrix(int rowsCount, int colsCount, int[][] data) {
        this.rowsCount = rowsCount;
        this.colsCount = colsCount;
        this.data = data;
    }

    public int sumRow(int row) {
        if (row < 0 || row > this.rowsCount) {
            throw new UnsupportedOperationException();
        }

        int result = 0;
        for (int i = 0; i < this.colsCount; ++i) {
            result += this.data[row][i];
        }

        return result;
    }

    public int sumCol(int col) {
        if (col < 0 || col > this.colsCount) {
            throw new UnsupportedOperationException();
        }

        int result = 0;
        for (int i = 0; i < this.rowsCount; ++i) {
            result += this.data[i][col];
        }

        return result;
    }

    public int sum() {
        int result = 0;
        for (int i = 0; i < this.rowsCount; ++i) {
            for (int j = 0; j < this.colsCount; ++j) {
                result += this.data[i][j];
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] values = new int[3][4];
        Matrix matrix = new Matrix(
                3,
                4,
                values);
        System.exit(0);
    }
}