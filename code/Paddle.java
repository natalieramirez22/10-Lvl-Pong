//Final Project
//Natalie Ramirez
//Paddle Class

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Paddle
{
   private static int x, y;
   private static int width, height, arcWidth, arcHeight;
         
   Paddle() 
   {
      width = 90;
      height = 15;
      arcWidth = 20;
      arcHeight = 20;
      x = 300;
      y = Pong.frameY - Pong.scoreHeight - 80;
   }

   public void checkBoundary() 
   {
      //Keeps the paddle from going out of the frame
      if (x <= 3)
         x = 1;
      else if (x + width >= Pong.frameX - 10)
         x = Pong.frameX - width - 5;
   }

   public static int sectionHit(Ball b) 
   {
      //Determine if ball is hitting paddle
      int firstSection = (width / 3) + x;
      int middleSection = ((width / 3) * 2) + x;
      //int thirdSection = x + width;
      
      if (b.getBallLeft() >= x && b.getBallLeft() <= x + width && b.getY() == y - height)
      {
         if (b.getX() <= firstSection)
            return 30;
         else if (b.getX() <= middleSection)
            return 45;
         else
            return 30;
      }
      else if (b.getBallRight() >= x && b.getBallRight() <= x + width && b.getY() == y - height)
      {         
         if (b.getX() <= firstSection)
            return 30;
         else if (b.getX() <= middleSection)
            return 45;
         else
            return 30;
      }
      else
         return 0;
   }

   public void paintPaddle(Graphics g) 
   {
      g.setColor(Color.BLUE);
      g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
   }

   public void paddleKeyPressed(KeyEvent e) 
   {
      int key = e.getKeyCode();
      
      //Speed of paddle
      if (key == KeyEvent.VK_LEFT)
         x += -40;
      if (key == KeyEvent.VK_RIGHT)
         x += 40;
   }

   public void paddleKeyReleased(KeyEvent e) 
   {
      int key = e.getKeyCode();
      
      if (key == KeyEvent.VK_LEFT)
         x += 0;
      if (key == KeyEvent.VK_RIGHT)
         x += 0;
   }
}