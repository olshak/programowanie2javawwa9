package templatemethod;

public class PkoMoneyTransfer extends AbstractMoneyTransfer {

  @Override
  protected void prepareTransfer() {
    System.out.println("Preparing pko transfer...");
  }

  @Override
  protected int addBankCommision() {
    return 4;
  }
}
