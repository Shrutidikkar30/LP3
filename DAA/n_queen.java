public class NQueens {

    // Size of the chessboard (N x N)
    private int N;
    private int[][] board;

    // Constructor to initialize the chessboard and place the first queen
    public NQueens(int N, int row, int col) {
        this.N = N;
        board = new int[N][N];
        // Place the first queen at the given position
        board[row][col] = 1;
    }

    // Function to print the chessboard configuration
    private void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to check if a queen can be placed at board[row][col]
    private boolean isSafe(int row, int col) {
        // Check this column on upper rows
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;  // No conflicts, safe to place the queen
    }

    // Backtracking function to place queens on the board
    private boolean solveNQueens(int row) {
        // If all queens are placed, return true
        if (row == N) {
            return true;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;  // Place the queen

                // Recur to place queens in subsequent rows
                if (solveNQueens(row + 1)) {
                    return true;
                }

                // If placing queen at (row, col) doesn't lead to a solution,
                // backtrack by removing the queen
                board[row][col] = 0;
            }
        }

        // If no placement is possible, return false
        return false;
    }

    // Function to solve the N-Queens problem
    public void solve() {
        // Start solving from the second row, as the first queen is already placed
        if (!solveNQueens(1)) {
            System.out.println("No solution exists");
        } else {
            printSolution();
        }
    }

    // Main function to test the N-Queens solution
    public static void main(String[] args) {
        int N = 4;  // Size of the chessboard
        int firstRow = 0, firstCol = 1;  // Position of the first queen

        // Initialize the board with the first queen placed
        NQueens nQueens = new NQueens(N, firstRow, firstCol);
        nQueens.solve();
    }
}
