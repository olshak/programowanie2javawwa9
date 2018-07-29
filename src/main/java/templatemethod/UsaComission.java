package templatemethod;

public class UsaComission implements ForeignTransferCommisionStrategy{
  @Override
  public int getForeignComission() {
    return 20;
  }
}
