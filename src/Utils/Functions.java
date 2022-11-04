package src.Utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import src.App;

public class Functions {
  public static void invalid(JPanel p) {
    Component c = p.getComponent(p.getComponentCount()-1);
    c.setBackground(Color.red);
    c.setForeground(Color.white);
    String name= p.getName()==null ? "Text" : p.getName();
    App.setMsg(name + " is invalid, try again.");
  }

  public static void clearError(JPanel p) {
    Component c = p.getComponent(p.getComponentCount()-1);
    c.setBackground(Color.white);
    c.setForeground(Color.black);
  }
}
