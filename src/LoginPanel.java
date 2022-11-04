package src;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import src.Components.PasswordInput;
import src.Components.TextInput;
import src.Utils.Colors;

public class LoginPanel {

  private JPanel panel;
  private JPanel email;
  private JPanel password;

  public LoginPanel() {

    App.setHeader("Login");
    this.panel = new JPanel();

    this.email = new TextInput("Email", "email@email.com").getPanel();
    this.password = new PasswordInput("Password").getPanel();

    JButton signupButton = new JButton("Sign up");
    signupButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panel.getParent().remove(panel);
        App.show(new SignUpPanel().getPanel());
      }
    });
    JButton loginButton = new JButton("Log in");
    loginButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          JPanel parent = (JPanel) panel.getParent();
          authenticate();
          parent.remove(panel);
          parent.updateUI();
          // TODO: Go to Home
        } catch (Exception ex) {
          App.setMsg("Failed to log in. Type your email and password and try again.");
        }
      }
    });
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    buttonPanel.setOpaque(false);
    buttonPanel.add(signupButton);
    buttonPanel.add(loginButton);

    this.panel.setBackground(Colors.panel);
    this.panel.add(email);
    this.panel.add(password);
    this.panel.add(buttonPanel);
    this.panel.setLayout(new GridLayout(panel.getComponentCount(), 1));
  }

  public JPanel getPanel() {
    return this.panel;
  }

  private void authenticate() throws Exception {
    // TODO: Validate login
    throw new Exception();
  }
}