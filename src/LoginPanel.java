package src;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import src.Components.PasswordInput;
import src.Components.TextInput;

public class LoginPanel {

  private JPanel panel;

  public LoginPanel() {

    App.setHeader("Login");
    panel = new JPanel();

    JPanel email = new TextInput("Email: ", "email@email.com").getPanel();
    JPanel password = new PasswordInput("Password: ").getPanel();

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

    panel.setLayout(new GridLayout(3, 1));
    panel.setBackground(new Color(153, 204, 255));
    panel.add(email);
    panel.add(password);
    panel.add(buttonPanel);
  }

  public JPanel getPanel() {
    return this.panel;
  }
}