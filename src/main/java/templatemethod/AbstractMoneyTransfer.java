package templatemethod;

public abstract class AbstractMoneyTransfer {

  protected abstract void prepareTransfer();
  protected abstract int addBankCommision();


  private void sendMoney(int amount) {
    System.out.println("sending money..." + amount);
  }

  private int addForeignTransferCommision(ForeignTransferCommisionStrategy commisionStrategy) {
    return commisionStrategy.getForeignComission();
  };

  public void performTransfer(int amount, ForeignTransferCommisionStrategy commisionStrategy) {
    prepareTransfer();
    sendMoney(amount + addBankCommision() + addForeignTransferCommision(commisionStrategy));
  }
}
