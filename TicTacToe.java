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
  private int turnCounter = 1;

  public void play() { 
    //game started, set counter to first turn
    //fill matrix with empty spaces
    for (int i = 0; i < BOARDSIZE; i++) {
      for (int j = 0; j < BOARDSIZE; j++) {
          board[i][j] = ' ';
      }
    }
     
    Scanner input = new Scanner(System.in);
    printBoard(); //prints the board
    
    //play game loop
    while (gameOver == false) {
      int row, col; //row and column for the move
      String player = (firstPlayer) ? "Player X" : "Player O"; //determine player string based on firstPlayer boolean
      char tileChar = (firstPlayer) ? 'x' : 'o';

      System.out.println(player + "'s turn.");
      System.out.print(player + ": Enter row ( 0, 1 or 2 ): ");
      row = input.nextInt();
      System.out.print(player + ": Enter row ( 0, 1 or 2 ): ");
      col = input.nextInt();


      //check if their move is valid
      if (validMove(row, col)) {
        board[row][col] = tileChar; //place corresponding tile on the board
        status = gameStatus(); //check if the game is over
        firstPlayer = !firstPlayer; //change to player 2's turn
      } else {
        System.out.println("Invalid move. Try again.");
      }
      
      System.out.println();
      printBoard(); //print the board

      switch(status){
        case Status.WIN:
          gameOver = true;
          System.out.println(player + " wins! ");
          break;
        case Status.CONTINUE:
          gameOver = false;
          turnCounter++;
          break;
        case Status.DRAW:
          System.out.println("Draw, neither player wins!");
          gameOver = true;
          break;
      }
    } //end of while loop
    input.close(); //close scanner
    System.out.println("Thank you for playing our game!");
  }

  public void printBoard(){
    char tileChar;

    //start board print
    System.out.println(" _______________________ ");

    //fill board with matrix charactres
    for (int i = 0; i < BOARDSIZE; i++) {
      System.out.println("|       |       |       |");

      for (int j = 0; j < BOARDSIZE; j++) {
        tileChar = board[i][j];
        printSymbol(j, tileChar);
      }

      System.out.println("\n|_______|_______|_______|");
    }
  }
  
  //function checks to see if the move they made is valid
  public boolean validMove(int row, int col) {
    if ((row <= 2 && row >= 0) && (col >= 0  && col <= 2)) {
      if(board[row][col] == ' ')
      return true;
    }
    return false; 
  }
  
  private void printSymbol(int column, char value) {
    switch(column){
      case 0:
        System.out.print("|   " + value + "   ");
        break;
      case 1:
        System.out.print("|   " + value + "   |");
        break;
      case 2:
        System.out.print("   " + value + "   |");
        break;
    }
  }

  private Status gameStatus() {
    //check rows
    for (int i = 0; i < BOARDSIZE; i++) {
      if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ' && board[i][1] != ' ' && board[i][2] != ' ') {
        return Status.WIN;
      }
    }
    //check columns
    for (int i = 0; i < BOARDSIZE; i++) {
      if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ' && board[1][i] != ' ' && board[2][i] != ' ') {
        return Status.WIN;
      }
    }
    //check diagonals
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ' && board[1][1] != ' ' && board[2][2] != ' ') {
      return Status.WIN;
    }
    if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ' && board[1][1] != ' ' && board[2][0] != ' ') {
      return Status.WIN;
    }
    //check draw
    if (turnCounter >= (BOARDSIZE * BOARDSIZE))
    {
      return Status.DRAW;
    }
    //else status stays CONTINUE
    return Status.CONTINUE;
  }
}
