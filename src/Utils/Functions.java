package src.Utils;

import java.awt.Color;

import javax.swing.JComponent;

public class Functions {
  public static void invalid(JComponent c) {
    c.setBackground(Color.red);
    c.setForeground(Color.white);
  }

  public static void clearError(JComponent c) {
    c.setBackground(Color.white);
    c.setForeground(Color.black);
  }
}
