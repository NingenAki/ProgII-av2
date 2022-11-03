package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login {

  private JPanel panel;

  public Login() {

    panel = new JPanel();

    final JLabel emailLabel = new JLabel("        Email: ");
    final JTextField email = new JTextField(20);
    email.setText("email@email.com");
    JPanel emailPanel = new JPanel();
    emailPanel.setLayout(new FlowLayout());
    emailPanel.setOpaque(false);
    emailPanel.add(emailLabel);
    emailPanel.add(email);
    
    final JLabel passwordLabel = new JLabel("Password: ");
    final JTextField password = new JTextField(20);
    password.setText("*******");
    JPanel passwordPanel = new JPanel();
    passwordPanel.setLayout(new FlowLayout());
    passwordPanel.setOpaque(false);
    passwordPanel.add(passwordLabel);
    passwordPanel.add(password);

    JButton button = new JButton("Entrar");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        email.setText("Welcome to Javatpoint.");
      }
    });
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    buttonPanel.setOpaque(false);
    buttonPanel.add(button);

    panel.setLayout(new GridLayout(3, 1));
    panel.setBackground(new Color(153, 204, 255));
    panel.add(emailPanel);
    panel.add(passwordPanel);
    panel.add(buttonPanel);
  }

  public JPanel getPanel() {
    return this.panel;
  }
}