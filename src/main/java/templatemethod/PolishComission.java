package templatemethod;

public class PolishComission implements ForeignTransferCommisionStrategy{
  @Override
  public int getForeignComission() {
    return 10;
  }
}
