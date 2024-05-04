//Final Project
//Natalie Ramirez
//10 lvls Pong Game
//Run this Class to Play

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.*;

public class Pong extends JFrame implements ActionListener
{
  public static final int frameX = 650;
  public static final int frameY = 650;
  public static final int scoreHeight = 0;

  public static Pong window;
  public static Splash splash;
  public static JButton button;
  public static Scoreboard score;
  public static Gameboard board;

  public Pong()
  {
    super("10 Lvl Pong");
    setBounds(0, 0, frameX, frameY);
    setBackground(Color.WHITE);
    setResizable(false);
    setAlwaysOnTop(true);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void showWelcome()
  {
    splash = new Splash();
    splash.button.addActionListener(this);

    window.add(splash);    
  }

  public void playGame()
  {

    Runnable switchBoards = new Runnable() 
    {
      public void run() 
      {
        splash.setVisible(false);
        window.getContentPane().removeAll();
      }
    };
  
    Thread stockPicker = new Thread() 
    {
      public void run() 
      {
        try 
        {
          SwingUtilities.invokeAndWait(switchBoards);
        }
        catch (Exception e) 
        {
          e.printStackTrace();
        }
        board = new Gameboard();
        window.getContentPane().add(board);
        window.setVisible(true);
        board.play();
      }
    };
    stockPicker.start();
  }

  public static void main(String[] args) 
  {
    window = new Pong();
    new Scoreboard();
    window.showWelcome();
    window.setVisible(true);
  }

  public void actionPerformed(ActionEvent e)
  {
    playGame();
  }
}