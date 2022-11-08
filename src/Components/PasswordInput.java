package src.Components;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import src.Utils.Colors;

public class PasswordInput {
  
  private JPanel panel;
  private JLabel label;
  private JPasswordField password;

  public PasswordInput (String name){
    this.panel = new JPanel();
    panel.setName(name);
    this.panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    this.label = new JLabel(name + ": ");
    this.label.setForeground(Colors.panelText);
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
  
  public char[] getInput(){
    return this.password.getPassword();
  }

  public JPasswordField getPassword(){
    return this.password;
  }
}
