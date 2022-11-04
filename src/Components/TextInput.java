package src.Components;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.Utils.Colors;

public class TextInput {

  private JPanel panel;
  private JLabel label;
  private JTextField field;

  public TextInput (String name, String text){
    this.panel = new JPanel();
    this.panel.setName(name);
    this.panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    this.label = new JLabel(name + ": ");
    this.label.setForeground(Colors.panelText);
    this.field = new JTextField(20);
    this.field.setText(text);
    this.panel.setOpaque(false);
    this.panel.add(label);
    this.panel.add(field);
  }

  public TextInput (String text){
    this.panel = new JPanel();
    this.panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    this.field = new JTextField(20);
    this.field.setText(text);
    this.panel.setOpaque(false);
    this.panel.add(field);
  }
  
  public JPanel getPanel(){
    return this.panel;
  }
}
