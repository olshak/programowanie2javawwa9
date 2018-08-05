package tictactoe;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static tictactoe.MARK.*;

public class BoardTest {
  private Board board;

  @Before
  public void setup() {
    board = new Board();
  }

  @Test
  public void shouldCreateEmptyBoard() {
    Assertions.assertThat(board.isEmpty());
  }

  @Test
  public void shouldAddCorrectMove() {
    board.addMove(0, 0, X);
    Assertions.assertThat(!board.isEmpty());
  }

  @Test(expected = IllegalStateException.class)
  public void shouldThrowIllegalArgumentExceptionWhenMadeSameMoveTwice() {
    board.addMove(0, 0, X);
    board.addMove(0, 0, X);
  }

  @Test
  public void shouldGetValueForIndexes() {
    board.addMove(0, 0, X);
    MARK expected = board.getValue(0, 0);
    Assertions.assertThat(expected).isEqualTo(X);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowIllegalArgumentExceptionWhenGettingValueForWrongIndex() {
    board.getValue(-1, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowIllegalArgumentExceptionWhenAddingValueForWrongIndex() {
    board.getValue(-1, 0);
  }
}
