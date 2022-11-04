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
import src.Utils.Functions;

public class SignUpPanel {

  private JPanel panel;
  private JPanel email;
  private JPanel email2;
  private JPanel password;
  private JPanel password2;

  public SignUpPanel() {

    App.setHeader("Sign Up");
    this.panel = new JPanel();

    this.email = new TextInput("Email", "email@email.com").getPanel();
    this.email2 = new TextInput("Email confirmation", "email@email.com").getPanel();
    this.password = new PasswordInput("Password").getPanel();
    this.password2 = new PasswordInput("Password confirmation").getPanel();

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
        if (isUserValid()) {
          try {
            // TODO: Save User
            panel.getParent().remove(panel);
            App.show(new LoginPanel().getPanel());            
          } catch (Exception ex) {
            App.setMsg("Failed to save. Try again.");
          }
        }
      }
    });
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    buttonPanel.setOpaque(false);
    buttonPanel.add(backButton);
    buttonPanel.add(saveButton);

    this.panel.setBackground(Colors.panel);
    this.panel.add(email);
    this.panel.add(email2);
    this.panel.add(password);
    this.panel.add(password2);
    this.panel.add(buttonPanel);
    this.panel.setLayout(new GridLayout(panel.getComponentCount(), 1));
  }

  public JPanel getPanel() {
    return this.panel;
  }

  private Boolean isUserValid() {
    if (isEmailValid()) {
      Functions.clearError(this.email);
    } else {
      Functions.invalid(this.email);
    }
    // TODO: Validate User
    return false;
  }

  private Boolean isEmailValid() {
    // TODO: Validate Email
    return false;
  }
}