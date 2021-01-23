//Final Project
//Natalie Ramirez
//"Splash" or Start Screen class

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.*;

public class Splash extends JPanel
{
  public JPanel r;
  public JButton button;

  Splash()
  {
    Color color = Color.BLACK;

    setBounds(0, 0, Pong.frameX, Pong.frameY);
    setBackground(Color.BLACK);
    setLayout(new GridLayout(3,3,4,4));
    
    JLabel gameLabel = new JLabel("10 Lvl Pong!");
    gameLabel.setForeground(Color.WHITE);
    gameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 70));
    gameLabel.setBounds(400, 400, 300, 200);
    
    JLabel nameLabel = new JLabel("By: Natalie Ramirez");
    nameLabel.setForeground(Color.WHITE);
    nameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

    button = new JButton("  Start Game  ");

    JPanel p = new JPanel();
    p.setLayout(new FlowLayout(FlowLayout.CENTER));
    p.setBackground(color);

    JPanel q = new JPanel();
    q.setLayout(new FlowLayout(FlowLayout.CENTER));
    q.setBackground(color);
    
    r = new JPanel();
    r.setLayout(new FlowLayout(FlowLayout.CENTER));
    r.setBackground(color);
    r.add(button);

    add(p);
    add(q);
    add(r);
    p.add(gameLabel);
    q.add(nameLabel);
  }
}