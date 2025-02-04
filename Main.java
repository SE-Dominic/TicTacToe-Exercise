enum Status {
  WIN, DRAW, CONTINUE
}

class TicTacToe {
  private static int BOARDSIZE = 3;
  private static char board[][] = new char[BOARDSIZE][BOARDSIZE];
  private boolean firstPlayer;
  private boolean secondPlayer;
  private Status status;

  public static void main(String[] args) {
    printBoard();
  }

  public static void play() {

  }
  public static void printBoard(){
    //fill matrix with x
    for (int i = 0; i < BOARDSIZE; i++) {
      for (int j = 0; j < BOARDSIZE; j++) {
          board[i][j] = 'x';
      }
    }

    //print board
    for (int i = 0; i < BOARDSIZE; i++) {
      for (int j = 0; j < BOARDSIZE; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }
  private static void printStatus(){

  }
  private static boolean validMove(){
    return false;}

  private static char printSymbol() {
    return 'a';
  }
}
