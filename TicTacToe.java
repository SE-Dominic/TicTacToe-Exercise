import java.util.Scanner; //scanner for user input
enum Status {
  WIN, DRAW, CONTINUE
}

public class TicTacToe {
  private final int BOARDSIZE = 3;
  private Status status;
  private char board[][] = new char[BOARDSIZE][BOARDSIZE];
  private boolean firstPlayer = true;
  private boolean gameOver = false;
  

  public void play() { 

    //game started
    //fill matrix with empty spaces
    for (int i = 0; i < BOARDSIZE; i++) {
      for (int j = 0; j < BOARDSIZE; j++) {
          board[i][j] = ' ';
      }
    }
     
    Scanner input = new Scanner(System.in);
    printBoard(); //prints the board

    while (gameOver == false) {
      int row, col; //row and column for the move
      if (firstPlayer) {
        //player 1's turn
        System.out.println("Player 1's turn.\n");
        System.out.println("Enter row: ");
        row = input.nextInt(); //user input for row
        System.out.println("Enter column: ");
        col = input.nextInt(); //user input for column
        
        //check if their move is valid
        if (validMove(row, col)) {
          printSymbol(row, col); //place an x on the board
          printBoard(); //print the board
          //printStatus(); //print the status of the game
          firstPlayer = false; //change to player 2's turn
        } else {
          System.out.println("Invalid move. Try again.");
        }
      } 
      if (!firstPlayer) { //player 2's turn
        System.out.println("Player 2's turn.\n");
        System.out.println("Enter row: ");
        row = input.nextInt(); //user input for row
        System.out.println("Enter column: ");
        col = input.nextInt(); //user input for column
        
        //check if their move is valid
        if (validMove(row, col)) {
          printSymbol(row, col); //place an o on the board
          printBoard(); //print the board
          //printStatus(); //print the status of the game
          firstPlayer = true; //change to player 1's turn
        } else {
          System.out.println("Invalid move. Try again.");
        }
      }
      if (checkWin()) {
        gameOver = true; //end the game
      }
    } //end of while loop
    input.close(); //close scanner
  }
  public void printBoard(){


    //print board
    System.out.println(" _______________________ ");

    //fill board with matrix charactres
    for (int i = 0; i < BOARDSIZE; i++) {
      System.out.println("|       |       |       |");
      System.out.print("|   ");

      for (int j = 0; j < BOARDSIZE; j++) {
        String output = printSymbol(i, j) + "   |   ";
        System.out.print(output);
      }

      System.out.println("\n|_______|_______|_______|");
    }
  }
  /*
  private void printStatus() {
    switch(status){
      case WIN: 
          System.out.println("Player " + firstPlayer + "wins.");
          break;
      case DRAW:
          System.out.println("Draw.");
          break;
      case CONTINUE:
          System.out.println("Player " + firstPlayer + "'s turn.");
          break;
    }

  }
   */
  
  //function checks to see if the move they made is valid
  public boolean validMove(int row, int col) {
    if (board[row][col] != 'x' || board[row][col] != 'o') {
      return true;
    } else {
    return false;
    }
  }
  
  private char printSymbol(int row, int column) {
    char output;
    if (firstPlayer = true){
      output = 'x';
      output = board[row][column];
    } else {
      output = 'o';
      output = board[row][column];
    }
    return output;
}
  private boolean checkWin() {
    //check rows
    for (int i = 0; i < BOARDSIZE; i++) {
      if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
        if (board[i][0] == 'x') {
          System.out.println("Player 1 wins.");
        } else {
          System.out.println("Player 2 wins.");
        }
        return true;
      }
    }
    //check columns
    for (int i = 0; i < BOARDSIZE; i++) {
      if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
        if (board[0][i] == 'x') {
          System.out.println("Player 1 wins.");
        } else {
          System.out.println("Player 2 wins.");
        }
        return true;
      }
    }
    //check diagonals
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
      if (board[0][0] == 'x') {
        System.out.println("Player 1 wins.");
      } else {
        System.out.println("Player 2 wins.");
      }
      return true;
    }
    if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
      if (board[0][2] == 'x') {
        System.out.println("Player 1 wins.");
      } else {
        System.out.println("Player 2 wins.");
      }
      return true;
    }
    return false;
  }

}
