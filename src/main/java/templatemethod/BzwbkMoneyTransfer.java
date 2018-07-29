package templatemethod;

public class BzwbkMoneyTransfer extends AbstractMoneyTransfer {

  @Override
  protected void prepareTransfer() {
    System.out.println("Preparing bzwbk transfer...");
  }

  @Override
  protected int addBankCommision() {
    return 2;
  }
}
