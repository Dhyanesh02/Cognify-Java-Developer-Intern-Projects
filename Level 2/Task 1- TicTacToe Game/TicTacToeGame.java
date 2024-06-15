import java.util.Scanner;

public class TicTacToeGame {
  

  public static void main(String[] args) {
    
    System.out.println("#################### Welcome to Tic-Tac-Toe game ####################");
    char[][] board = new char[3][3];
    
    printEmptyBoard(board);

    char player = 'X';
    boolean gameOver = false, continueGame = false;
    Scanner input = new Scanner(System.in);

    while (!gameOver && !continueGame ) {
      printBoard(board);
      System.out.print("Player " + player + " Enter the position : ");
      int row = input.nextInt();
      int col = input.nextInt();
      System.out.println();

      if (board[row][col] == ' ') {
        board[row][col] = player;
        gameOver = hasWon(board, player);
        if (gameOver) {
          System.out.println("---------------------------------");
          System.out.println("Player " + player + " has won!!");
          System.out.println("---------------------------------");
          System.out.print("Play one again (yes|no): ");
          String choice = input.next();
          continueGame = playagain(choice, continueGame, gameOver);
          gameOver = continueGame;
          if (!continueGame) {
            printEmptyBoard(board);
          }
        } else {
          player = player == 'X' ? 'O' : 'X';
        }
      } else {
        System.out.println("Invalid position.Try again!");
      }
    }
    printBoard(board);
  }

  private static boolean playagain(String choice, boolean continueGame,boolean gameOver) {
    if (choice.equals("no")) {
      continueGame = true;
      gameOver = true;
      System.out.println("---------------------------------");
      System.out.println("Thanks for playing Tic-Tac-Toe!");
      System.out.println("---------------------------------");
    }
    return continueGame;
  }

  private static boolean hasWon(char[][] board, char player) {
    //Row Check 
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
        return true;
      }
    }
    
    //Column Check
    for (int col = 0; col < board[0].length; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
        return true;
      }
    }
    //Diagonal Check
    if (board[0][0] == player && board[1][1] == player & board[2][2] == player) {
      return true;
    }
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }
    return false;
  }

  private static void printBoard(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(board[row][col] + " | ");
      }
      System.out.println();
    }
  }

  private static char[][] printEmptyBoard(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = ' ';
      }
    }
    return board;
  }
}