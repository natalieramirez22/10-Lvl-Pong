//Final Project
//Natalie Ramirez
//Ball Class

import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;

public class Ball 
{
   private static int x, y, radius;
   private static double dx, dy;
   private static double ballSpeed = 6000000.0; 
   private static int ballLeft, ballRight;
   
   public Ball() 
   {
      radius = 20;
      dx = 1; 
      dy = 1;
      x = (int)(Math.random() * Pong.frameX); //Ball spawns in a random point in beginning of game and after life lost
      y = 100;
   }
   
   public void paintBall(Graphics g)
   {
      g.setColor(Color.PINK);
      g.fillOval(x, y, radius, radius);
   }
   
   public void calculatedx()
   {
      int angle = Paddle.sectionHit(Gameboard.ball);
      
      if (angle == 45)
         if (dx > 0)
            dx = 1;
         else
            dx = -1;
      else if (angle == 30)
         if (dx > 0)
            dx = 2;
         else 
            dx = -2;
   }
   
   public void bounce() 
   {
      //Bounces off paddle
      calculatedx();
      
      dy = -dy;
   }
      
   public void move()
   {
      //Checks if ball hits a wall and bounces if true
      
      int angle = Paddle.sectionHit(Gameboard.ball);
      
      if (x+dx >= Pong.frameX - (radius)) //Left side
      {
         if (angle == 30)
            dx = -2;
         else 
            dx = -1;
      }
      else if (x <= 0) //Right side
      {
         if (angle == 30)
            dx = 2;
         else 
            dx = 1;
      }
      if (y+dy > Pong.frameY - (radius+25))  //Bottom Side
      {
         Scoreboard.lives--;
         
         if (Scoreboard.lives == 2)
            Gameboard.isPlaying = false;
            Gameboard.lifeLostReset();
         if (Scoreboard.lives == 1)
            Gameboard.isPlaying = false;
            Gameboard.lifeLostReset();
         if (Scoreboard.lives == 0)
            Gameboard.isPlaying = false;
      }
      else if (y <= Pong.scoreHeight) //Top side
         dy=-dy;
   
      for (double i = 0.0; i < ballSpeed; i++)
      {
         if (Scoreboard.level == 1)
            i += 1;
         if (Scoreboard.level == 2)
            i += 2;
         if (Scoreboard.level == 3)
            i += 3;
         if (Scoreboard.level == 4)
            i += 4;
         if (Scoreboard.level == 5)
            i += 5;
         if (Scoreboard.level == 6)
            i += 6;
         if (Scoreboard.level == 7)
            i += 7;
         if (Scoreboard.level == 8)
            i += 8;
         if (Scoreboard.level == 9)
            i += 9;
         if (Scoreboard.level == 10)
            i += 10;
      }
      x+=dx;
      y+=dy;
   }
   
   public double getdy()
   {
      return dy;
   }
   
   public void setdy(int newdy)
   {
      dy = newdy;
   }
   
   public int getX()
   {
      return x;
   }
   
   public int getY()
   {
      return y;
   }
   
   public int getRadius()
   {
      return radius;
   }
   
   public int getBallLeft()
   {
      ballLeft = x - radius;
      return ballLeft;
   }
   
   public int getBallRight()
   {
      ballRight = x + radius;
      return ballRight;
   }
}