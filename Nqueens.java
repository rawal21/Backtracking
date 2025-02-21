public class Nqueens {

  // Function to check if a queen can be placed at board[row][col]
  public static boolean isSafe(char board[][], int row, int col) {
    // Check the vertical column above the current row
 
    for (int i = row - 1; i >= 0; i--) { 
      if (board[i][col] == 'Q') { // If a queen is found in the same column
        return false;
      }
    }

    // Check the upper-left diagonal
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') { // If a queen is found in the left diagonal
        return false;
      }
    }

    // Check the upper-right diagonal
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
      if (board[i][j] == 'Q') { // If a queen is found in the right diagonal
        return false;
      }
    }

    return true; // No conflicts, safe to place a queen
  }

  // Function to solve the N-Queens problem and print solutions
  static boolean NqueensPrint(char board[][], int row) {
   
    // Base case: If all queens are placed (row == board size), print the board
    if (row == board.length) {
      printBoard(board);
      System.out.println(); // Separate multiple solutions
      count++;
      System.out.println("number of possible soluation" + count );
      return true; // Indicates a solution is found
    }

    boolean foundSolution = false; // Track if at least one solution exists

    // Try placing a queen in each column of the current row
    for (int j = 0; j < board.length; j++) {
      if (isSafe(board, row, j)) { // Check if it's safe to place the queen
        board[row][j] = 'Q'; // Place the queen

        // Recursive call to place the rest of the queens
        foundSolution = NqueensPrint(board, row + 1) || foundSolution;

        // Backtracking: Remove the queen to explore other possibilities
        board[row][j] = 'X';
      }
    }

    return foundSolution; // Returns true if at least one solution exists
  }

  // Function to print the chessboard
  public static void printBoard(char board[][]) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  static int count = 0 ;

  public static void main(String[] args) {
    int n = 4; // Change N to 4 because N=2 and N=3 have no valid solutions
    char board[][] = new char[n][n];

    // Initialize the board with 'X' (empty spaces)
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = 'X';
      }
    }

    // Call the function to solve the N-Queens problem
    if (!NqueensPrint(board, 0)) { // If no solution exists
      System.out.println("No solution exists for N = " + n);
    }
  }
}
