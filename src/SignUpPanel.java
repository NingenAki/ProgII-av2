package src;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JPanel;

import src.Components.PasswordInput;
import src.Components.TextInput;
import src.Utils.Colors;
import src.Utils.Functions;

public class SignUpPanel {

  private JPanel panel;
  private TextInput email;
  private TextInput email2;
  private PasswordInput password;
  private PasswordInput password2;

  public SignUpPanel() {

    App.setHeader("Sign Up");
    App.setMsg("");
    this.panel = new JPanel();

    this.email = new TextInput("Email", "email@email.com");
    this.email2 = new TextInput("Confirm email", "email@email.com");
    this.password = new PasswordInput("Password");
    this.password2 = new PasswordInput("Confirm Password");

    JButton backButton = new JButton("Back");
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panel.getParent().remove(panel);
        App.show(new LoginPanel().getPanel());
        App.setMsg("");
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
            App.setMsg("User saved!");
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
    this.panel.add(email.getPanel());
    this.panel.add(email2.getPanel());
    this.panel.add(password.getPanel());
    this.panel.add(password2.getPanel());
    this.panel.add(buttonPanel);
    this.panel.setLayout(new GridLayout(panel.getComponentCount(), 1));
  }

  public JPanel getPanel() {
    return this.panel;
  }

  private Boolean isUserValid() {
    try {
      validateEmail();
      validateEmailConfirmation();
      validatePassword();
      validatePasswordConfirmation();
    } catch (Exception e) {
      App.setMsg(e.getMessage());
      return false;
    }
    return true;
  }

  private void validateEmail() throws Exception {
    String email = this.email.getInput().trim();
    if (email.matches(".+@email.com$")) {
      /*
       * TODO: Check email availability
       * if (getUserByLogin(email) != null) {
       * Functions.invalid(this.email.getField());
       * throw new Exception("Email is already in use!");
       * }
       */
      Functions.clearError(this.email.getField());
    } else {
      Functions.invalid(this.email.getField());
      throw new Exception("This is not a valid email!");
    }
  }

  private void validateEmailConfirmation() throws Exception {
    String email = this.email.getInput().trim();
    String email2 = this.email2.getInput().trim();
    if (email.equals(email2)) {
      Functions.clearError(this.email2.getField());
    } else {
      Functions.invalid(this.email2.getField());
      throw new Exception("The emails must match!");
    }
  }

  private void validatePassword() throws Exception {
    char[] password = this.password.getInput();
    if (password.length >= 6) {
      Functions.clearError(this.password.getPassword());
    } else {
      Functions.invalid(this.password.getPassword());
      throw new Exception("This is not a valid password! It must contain at least 6 characters.");
    }
  }

  private void validatePasswordConfirmation() throws Exception {
    char[] password = this.password.getInput();
    char[] password2 = this.password2.getInput();
    if (Arrays.equals(password, password2)) {
      Functions.clearError(this.password2.getPassword());
    } else {
      Functions.invalid(this.password2.getPassword());
      throw new Exception("The passwords must match!");
    }
  }
}