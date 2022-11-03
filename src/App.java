package src;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App{

  private static JFrame mainFrame;
  private static JLabel headerLabel;
  private static JPanel mainPanel;
  private static JLabel msgLabel;

  public static void prepareGUI(){

    mainFrame = new JFrame("MedHub");
    mainFrame.setSize(600, 900);
    mainFrame.setLayout(new GridLayout(3, 1));
    mainFrame.getContentPane().setBackground(new Color(102, 178, 255));
    mainFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent){
        System.exit(0);
      }        
    });

    headerLabel = new JLabel("", JLabel.CENTER);
    headerLabel.setForeground(Color.white);
    headerLabel.setFont(headerLabel.getFont().deriveFont(32f));
    msgLabel = new JLabel("", JLabel.CENTER);
    msgLabel.setForeground(Color.white);

    mainPanel = new JPanel();
    mainPanel.setLayout(new FlowLayout());
    mainPanel.setOpaque(false);

    mainFrame.add(headerLabel);
    mainFrame.add(mainPanel);
    mainFrame.add(msgLabel);
    mainFrame.setVisible(true);
  }

  public static void show(JPanel panel){
    mainPanel.add(panel);
    mainPanel.updateUI();  
  }

  public static void setMsg(String msg){
    msgLabel.setText(msg);
  }

  public static void setHeader(String header){
    headerLabel.setText(header);
  }
}