package tictactoe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static tictactoe.MARK.*;

public class BoardVerifierTest {

  @Test
  public void shouldReturnFalseForEmptyArray() {
    Assertions.assertThat(BoardVerifier.hasWinner(new Board())).isEqualTo(false);
  }

  @Test
  public void shouldReturnTrueWhenHasWinnerInRow() {
    verifyHasWinnerInRow(0);
    verifyHasWinnerInRow(1);
    verifyHasWinnerInRow(2);
  }

  @Test
  public void shouldReturnTrueWhenHasWinnerInColumn() {
    verifyHasWinnerInColumn(0);
    verifyHasWinnerInColumn(1);
    verifyHasWinnerInColumn(2);
  }

  @Test
  public void shouldReturnTrueWhenHasWinnerAcross() {
    Board boardWithWinnerAcross1 = new Board();
    boardWithWinnerAcross1.addMove(0, 0, X);
    boardWithWinnerAcross1.addMove(1, 1, X);
    boardWithWinnerAcross1.addMove(2, 2, X);
    Assertions.assertThat(BoardVerifier.hasWinner(boardWithWinnerAcross1)).isEqualTo(true);

    Board boardWithWinnerAcross2 = new Board();
    boardWithWinnerAcross2.addMove(2, 0, X);
    boardWithWinnerAcross2.addMove(1, 1, X);
    boardWithWinnerAcross2.addMove(0, 2, X);
    Assertions.assertThat(BoardVerifier.hasWinner(boardWithWinnerAcross2)).isEqualTo(true);
  }

  private void verifyHasWinnerInRow(int rowNumber) {
    Board boardWithWinnerInFirstRow = new Board();
    boardWithWinnerInFirstRow.addMove(rowNumber, 0, X);
    boardWithWinnerInFirstRow.addMove(rowNumber, 1, X);
    boardWithWinnerInFirstRow.addMove(rowNumber, 2, X);
    Assertions.assertThat(BoardVerifier.hasWinner(boardWithWinnerInFirstRow)).isEqualTo(true);
  }

  private void verifyHasWinnerInColumn(int columnNumber) {
    Board boardWithWinnerInFirstColumn = new Board();
    boardWithWinnerInFirstColumn.addMove(0, columnNumber, X);
    boardWithWinnerInFirstColumn.addMove(1, columnNumber, X);
    boardWithWinnerInFirstColumn.addMove(2, columnNumber, X);
    Assertions.assertThat(BoardVerifier.hasWinner(boardWithWinnerInFirstColumn)).isEqualTo(true);
  }
}
