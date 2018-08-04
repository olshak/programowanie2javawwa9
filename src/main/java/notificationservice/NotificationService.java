package notificationservice;

public class NotificationService {
  private EmailService emailService;
  private PigeonService pigeonService;

  public NotificationService(EmailService emailService, PigeonService pigeonService) {
    this.emailService = emailService;
    this.pigeonService = pigeonService;
  }

  public void sendNotification(String message) {
    if (emailService.isAvailable() && emailService.hasCredits()) {
      emailService.sendEmail(message);
    } else if (pigeonService.isAvailable()) {
      pigeonService.sendMessage(message);
    } else {
        throw new IllegalStateException("Message services unavailable");
    }
  }
}
