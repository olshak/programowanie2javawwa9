package tictactoe;

public class Board {
  private MARK[][] board = new MARK[3][3];

  public boolean isEmpty() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (isFilled(i, j)) {
          return false;
        }
      }
    }
    return true;
  }

  public void addMove(int x, int y, MARK mark) {
    verifyIndexes(x, y);
    verifyFieldOccupied(x, y);

    board[x][y] = mark;
  }

  public MARK getValue(int x, int y) {
    verifyIndexes(x, y);
    return board[x][y];
  }

  private void verifyIndexes(int x, int y) {
    if (x < 0 || y < 0 || x > 2 || y > 2) {
      throw new IllegalArgumentException("Index should be between 0 and 2");
    }
  }

  private void verifyFieldOccupied(int x, int y) {
    if (isFilled(x, y)) {
      throw new IllegalStateException("Cannot mark occupied field");
    }
  }

  private boolean isFilled(int x, int y) {
    return board[x][y] != null;
  }
}
