package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App{

  private static JFrame mainFrame;
  JLabel headerLabel;
  JPanel mainPanel;
  JLabel statusLabel;
  JLabel msgLabel;

  public App(){

    prepareGUI();
  }

  private void prepareGUI(){

    mainFrame = new JFrame("MedHub");
    mainFrame.setSize(400, 400);
    mainFrame.setLayout(new GridLayout(3, 1));
    mainFrame.getContentPane().setBackground(new Color(102, 178, 255));
    mainFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent){
         System.exit(0);
      }        
   });

   headerLabel = new JLabel("", JLabel.CENTER);
   statusLabel = new JLabel("", JLabel.CENTER);
   statusLabel.setSize(350, 100);
   msgLabel = new JLabel("Welcome to MedHub!", JLabel.CENTER);

   mainPanel = new JPanel();
   mainPanel.setLayout(new FlowLayout());
   mainPanel.setOpaque(false);

   mainFrame.add(headerLabel);
   mainFrame.add(mainPanel);
   mainFrame.add(statusLabel);
   mainFrame.setVisible(true);
  }

  public void show(){
    headerLabel.setText("Login");
    Login login = new Login();
    mainPanel.add(login.getPanel());
    mainFrame.setVisible(true);  
 }
}