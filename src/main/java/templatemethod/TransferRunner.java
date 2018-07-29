package templatemethod;

public class TransferRunner {

  public static void main(String[] args) {

    AbstractMoneyTransfer pkoTranster = new PkoMoneyTransfer();
    AbstractMoneyTransfer bzwbkTranster = new BzwbkMoneyTransfer();

    pkoTranster.performTransfer(100, new PolishComission());
    bzwbkTranster.performTransfer(100, new UsaComission());

    bzwbkTranster.performTransfer(100, ()->0);
  }
}
