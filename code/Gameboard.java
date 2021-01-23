//Final Project
//Natalie Ramirez
//GameBoard class

import javax.swing.JPanel;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Gameboard extends JPanel //implements KeyListener
{
  public static boolean isPlaying;

  public static Paddle paddle;
  public static Ball ball;

  private KeyLis listener;

  Gameboard()
  {
    this.setBounds(0, Pong.scoreHeight, Pong.frameX, Pong.frameY - Pong.scoreHeight);
    this.setBackground(Color.WHITE);
    this.setLayout(null);

    listener = new KeyLis();
    this.setFocusable(true);
    this.requestFocusInWindow();
    this.addKeyListener(listener);
    reset();
  }

  public void reset() 
  {
     ball = new Ball();
     paddle = new Paddle();
     setFocusable(true);
  }

  public void play()
  {
    isPlaying = true;
    Gameboard mainPanel = new Gameboard();

    this.setFocusable(true);
    this.requestFocusInWindow();
    this.add(mainPanel);
    
    while (isPlaying)
    {
      update();
      repaint();
    }
  }

  public void update() 
  {
    paddle.checkBoundary();
    ball.move();
    checkCollision();
    advanceLevel();
    gameOver();
  }

  public void paintComponent(Graphics g) 
  {
    paddle.paintPaddle(g);
    ball.paintBall(g);
    Scoreboard.draw(g);
  }

  public void advanceLevel() 
  {
    if (Scoreboard.level == 2 && Scoreboard.lives != 0) 
    {
      //Pong.window.setBackground(Color.BLACK);
      Scoreboard.points = 10;
    }
    if (Scoreboard.level == 3 && Scoreboard.lives != 0) 
    {
      //Pong.window.setBackground(Color.DARK_GRAY);
      Scoreboard.points = 30;
    }
    if (Scoreboard.level == 4 && Scoreboard.lives != 0) 
    {
      //Pong.window.setBackground(Color.GRAY);
      Scoreboard.points = 60;
    }
    if (Scoreboard.level == 5 && Scoreboard.lives != 0) 
    {
      //Pong.window.setBackground(Color.MAGENTA);
      Scoreboard.points = 100;
    }
    if (Scoreboard.level == 6 && Scoreboard.lives != 0) 
    {
      //Pong.window.setBackground(Color.CYAN);
      Scoreboard.points = 150;
    }
    if (Scoreboard.level == 7 && Scoreboard.lives != 0) 
    {
      //Pong.window.setBackground(Color.GREEN);
      Scoreboard.points = 210;
    }
    if (Scoreboard.level == 8 && Scoreboard.lives != 0) 
    {
      //Pong.window.setBackground(Color.YELLOW);
      Scoreboard.points = 280;
    }
    if (Scoreboard.level == 9 && Scoreboard.lives != 0) 
    {
      //Pong.window.setBackground(Color.ORANGE);
      Scoreboard.points = 360;
    }
    if (Scoreboard.level == 10 && Scoreboard.lives != 0) 
    {
      //Pong.window.setBackground(Color.RED);
      Scoreboard.points = 450;
    }
  }

  public void gameOver() 
  {
    if (isPlaying == false)
      try 
      {
        Thread.sleep(10);
      } catch (InterruptedException ex) 
      {
        reset();
      }
  }

  public static void lifeLostReset() 
  {
    ball = new Ball();
    paddle = new Paddle();
    isPlaying = true;
  }

  public void checkCollision() 
  {
    if (Paddle.sectionHit(ball) != 0)
      ball.bounce();
  }

  private class KeyLis extends KeyAdapter
  {
    @Override
    public void keyPressed(KeyEvent e) 
    {
      paddle.paddleKeyPressed(e);
    }
  }  
}