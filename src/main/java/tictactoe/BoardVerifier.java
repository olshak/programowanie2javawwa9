package tictactoe;

import java.util.Arrays;
import java.util.List;

public class BoardVerifier {

  private static final List<List<Integer>> WINNING_COMBINATIONS = Arrays.asList(
      Arrays.asList(0, 1, 2),
      Arrays.asList(3, 4, 5),
      Arrays.asList(6, 7, 8),
      Arrays.asList(0, 3, 6),
      Arrays.asList(1, 4, 7),
      Arrays.asList(2, 5, 8),
      Arrays.asList(0, 4, 8),
      Arrays.asList(2, 4, 6)

  );

  public static boolean hasWinner(Board board) {
    if (board.getSize() != 3) {
      throw new IllegalStateException("Cannot verify board of size other than 3");
    }

    return !board.isEmpty() && (hasWinnerInRow(board) || hasWinnerInColumn(board) || hasWinnerAcross(board));

  }

  public static boolean hasWinnerUsingCombinations(Board board) {
    if (board.getSize() != 3) {
      throw new IllegalStateException("Cannot verify board of size other than 3");
    }

    if (board.isEmpty()) {
      return false;
    }

    for (List<Integer> combination : WINNING_COMBINATIONS) {
      if (board.getValue(combination.get(0)) == board.getValue(combination.get(1)) && board.getValue(combination.get(1)) == board.getValue(combination.get(2))) {
        return true;
      }
    }
    return false;
  }

  private static boolean hasWinnerInRow(Board board) {
    for (int row = 0; row < board.getSize(); row++) {
      if (board.getValue(row, 0) == board.getValue(row, 1) && board.getValue(row, 1) == board.getValue(row, 2)) {
        return true;
      }
    }

    return false;
  }

  private static boolean hasWinnerInColumn(Board board) {
    for (int column = 0; column < board.getSize(); column++) {
      if (board.getValue(0, column) == board.getValue(1, column) && board.getValue(1, column) == board.getValue(2, column)) {
        return true;
      }
    }

    return false;
  }

  private static boolean hasWinnerAcross(Board board) {
      if (board.getValue(0, 0) == board.getValue(1, 1) && board.getValue(1, 1) == board.getValue(2, 2)) {
        return true;
      } else if (board.getValue(0, 2) == board.getValue(1, 1) && board.getValue(1, 1) == board.getValue(2, 0)) {
        return true;
    }

    return false;
  }
}
