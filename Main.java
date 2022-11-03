import src.App;
import src.LoginPanel;

public class Main {

  public static void main(String[] args) {

    App.prepareGUI();
    App.show(new LoginPanel().getPanel());
  }
}