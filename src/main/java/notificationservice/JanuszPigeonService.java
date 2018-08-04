package notificationservice;

public class JanuszPigeonService implements PigeonService{
  @Override
  public boolean isAvailable() {
    System.out.println("calling Janusz to check availability");
    return true;
  }

  @Override
  public void sendMessage(String message) {
    System.out.println("sending message by pigeon");
  }
}
