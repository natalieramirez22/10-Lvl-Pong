//Final Project
//Natalie Ramirez
//ScoreBoard class

import javax.swing.JPanel;
import java.awt.Color;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Scoreboard extends JPanel
{
   public static int points = 0;
   public static int lives = 3; //To modify game and make it easier - give many more lives to not lose
   public static int level = 1;
   public static int countDown = 15; //Change Time countDown Here (to make game easier, lower time) official game time: 20 secs
   public static int secondsLeft;
   public static Timer timer;    
  
  //Fun graphics at the end if player wins 
   public static ImageIcon dancePenguin = new ImageIcon("dancePenguin.png");
   public static ImageIcon cowboyPenguin = new ImageIcon("cowboyPenguin.png");

   Scoreboard()
   {
      createTimer();
   }

   public static void draw(Graphics g)
   {
      g.setColor(Color.BLACK);
      g.setFont(new Font("ArcadeClassic", Font.PLAIN, 18));
      
   // FOR THE FULL SCREEN COLOR EFFECT
      //if (level == 2 || level == 3 || level == 4 || level == 5 || level == 7 || level == 9 || level == 10)
        // g.setColor(Color.BLACK); //Color.WHITE

   //FOR THE WHITE BACKGROUND TEXT COLOR CHANGING EFFECT
      if (level == 2)
         g.setColor(Color.DARK_GRAY);
      if (level == 3)
         g.setColor(Color.GRAY);
      if (level == 4)
         g.setColor(Color.MAGENTA);
      if (level == 5)
         g.setColor(Color.BLUE);
      if (level == 6)
         g.setColor(Color.CYAN);
      if (level == 7)
         g.setColor(Color.GREEN);
      if (level == 8)
         g.setColor(Color.ORANGE);
      if (level == 9)
         g.setColor(Color.PINK);
      if (level == 10)
         g.setColor(Color.RED);
   


      g.drawString("Lives  left:   " + lives, 30, 40);
      g.drawString("Points:   " + points, 30, 65);
      g.drawString("Level:   " + level, 30, 90);
      g.drawString("Timer:   " + secondsLeft, 30, 115);
     
      if (points == 450)
      {
         g.setColor(Color.BLACK);
         g.drawString("LAST LEVEL", 285, 330);
      }
      if (points == 450 && secondsLeft == 0)
      {
         g.setColor(Color.BLUE);
         g.drawString("YOU WIN!!!", 285, 285);
         g.drawImage(cowboyPenguin.getImage(), 425, 330, 169, 206, null);
         g.drawImage(dancePenguin.getImage(), 50, 350, 232, 172, null);
      }
     
      if (lives == 0)
      {
         g.setColor(Color.RED);
         g.drawString("Game Over", 285, 260);
         g.setColor(Color.DARK_GRAY);
         g.drawString("Exit and Run to Play Again", 255, 285);
      }
   }
  
   public static void createTimer()
   {
      timer = new Timer();
      int delay = 0;
      int period = 1000;
   
      secondsLeft = countDown;
      timer.schedule(
         new TimerTask()
         {
            @Override
            public void run()
            {
               secondsLeft--;
               if(secondsLeft == 0)
               {
                  if (level == 10 && secondsLeft == 0)
                     Gameboard.isPlaying = false;
                  else 
                  {
                     timer.cancel();
                     level++;
                     createTimer();
                  }
               }
            }
         }, delay, period);
   }   
}