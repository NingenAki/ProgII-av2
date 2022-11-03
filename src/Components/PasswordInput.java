package src.Components;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PasswordInput {
  
  private JPanel panel;
  private JLabel label;
  private JPasswordField password;

  public PasswordInput (String labelText){
    this.panel = new JPanel();
    this.panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    this.label = new JLabel(labelText);
    this.password = new JPasswordField(20);
    this.password.setText("*******");
    this.panel.setOpaque(false);
    this.panel.add(label);
    this.panel.add(password);
  }

  public PasswordInput (){
    this.panel = new JPanel();
    this.panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    this.password = new JPasswordField(20);
    this.password.setText("*******");
    this.panel.setOpaque(false);
    this.panel.add(password);
  }
  
  public JPanel getPanel(){
    return this.panel;
  }
}
