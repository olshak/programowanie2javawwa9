package notificationservice;

public interface EmailService {
  public boolean isAvailable();
  public void sendEmail(String message);
  public boolean hasCredits();
}
