package notificationservice;

public interface PigeonService {
  public boolean isAvailable();
  public void sendMessage(String message);
}
