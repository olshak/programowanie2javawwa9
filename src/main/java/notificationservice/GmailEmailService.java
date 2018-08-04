package notificationservice;

public class GmailEmailService implements EmailService{
  @Override
  public boolean isAvailable() {
    System.out.println("calling google to check availability");
    return true;
  }

  @Override
  public void sendEmail(String message) {
    System.out.println("sending message by google");
  }

  @Override
  public boolean hasCredits() {
    return false;
  }
}
