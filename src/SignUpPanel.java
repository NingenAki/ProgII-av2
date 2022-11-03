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

public class SignUpPanel {

  private JPanel panel;

  public SignUpPanel() {

    App.setHeader("Sign Up");
    panel = new JPanel();

    final JPanel email = new TextInput("Email: ", "email@email.com").getPanel();
    final JPanel email2 = new TextInput("Confirm email: ", "email@email.com").getPanel();
    final JPanel password = new PasswordInput("Password: ").getPanel();
    final JPanel password2 = new PasswordInput("Confirm password: ").getPanel();

    JButton backButton = new JButton("Back");
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panel.getParent().remove(panel);
        App.show(new LoginPanel().getPanel());
      }
    });
    JButton saveButton = new JButton("Save");
    saveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panel.getParent().remove(panel);
        // TODO: Save User
        App.show(new LoginPanel().getPanel());
      }
    });
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    buttonPanel.setOpaque(false);
    buttonPanel.add(backButton);
    buttonPanel.add(saveButton);

    panel.setLayout(new GridLayout(5, 1));
    panel.setBackground(new Color(153, 204, 255));
    panel.add(email);
    panel.add(email2);
    panel.add(password);
    panel.add(password2);
    panel.add(buttonPanel);
  }

  public JPanel getPanel() {
    return this.panel;
  }
}