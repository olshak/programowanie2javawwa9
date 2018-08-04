package notificationservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceTest {
  @Mock
  private EmailService emailService;
  @Mock
  private PigeonService pigeonService;
  @InjectMocks
  private NotificationService notificationService;

  @Test
  public void shouldSendEmailWhenEmailServiceAvailable() {
    Mockito.when(emailService.isAvailable()).thenReturn(true);
    Mockito.when(emailService.hasCredits()).thenReturn(true);
    notificationService.sendNotification("message");
    Mockito.verify(emailService).sendEmail("message");
  }

  @Test
  public void shouldSendPigeonMessageWhenPigeonServiceAvailable() {
    Mockito.when(pigeonService.isAvailable()).thenReturn(true);
    notificationService.sendNotification("message");
    Mockito.verify(pigeonService).sendMessage("message");
  }

  @Test(expected = IllegalStateException.class)
  public void shouldThrowIllegalStateExceptionWhenBothServicesUnavailable() {
    notificationService.sendNotification("message");
  }
}
