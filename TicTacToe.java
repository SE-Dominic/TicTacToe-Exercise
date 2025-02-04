enum Status {
  WIN, DRAW, CONTINUE
}

public class TicTacToe {
  private final int BOARDSIZE = 3;
  private Status status;
  private char board[][] = new char[BOARDSIZE][BOARDSIZE];
  private boolean firstPlayer;
  private boolean gameOver;
  
  public void play() {
    printBoard();
  }
  public void printBoard(){
    //fill matrix with empty spaces
    for (int i = 0; i < BOARDSIZE; i++) {
      for (int j = 0; j < BOARDSIZE; j++) {
          board[i][j] = ' ';
      }
    }

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
  private void printStatus() {

  }
  private boolean validMove() {
    return false;
  }

  private char printSymbol(int column, int row) {
    char output;

    output = board[column][row];

    return output;
  }
}
