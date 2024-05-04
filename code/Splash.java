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
    Color backgroundColor = new Color(215, 87, 73); // coral
    Color textColor = new Color(253, 242, 200); // light beige

    setBounds(0, 0, Pong.frameX, Pong.frameY);
    setBackground(backgroundColor);
    setLayout(new GridLayout(3,3,4,4));
    
    JLabel gameLabel = new JLabel("10  Lvl  Pong!");
    gameLabel.setForeground(textColor);
    gameLabel.setFont(new Font("ArcadeClassic", Font.BOLD, 70));
    gameLabel.setBounds(400, 400, 300, 200);
    
    JLabel nameLabel = new JLabel("By:  Natalie  Ramirez");
    nameLabel.setForeground(textColor);
    nameLabel.setFont(new Font("ArcadeClassic", Font.BOLD, 30));

    button = new JButton("  Start Game  ");
    button.setForeground(backgroundColor);
    button.setBackground(textColor);
    button.setOpaque(true);
    button.setBorderPainted(false);
    button.setFont(new Font("ArcadeClassic", Font.BOLD, 18));

    JPanel p = new JPanel();
    p.setLayout(new FlowLayout(FlowLayout.CENTER));
    p.setBackground(backgroundColor);

    JPanel q = new JPanel();
    q.setLayout(new FlowLayout(FlowLayout.CENTER));
    q.setBackground(backgroundColor);
    
    r = new JPanel();
    r.setLayout(new FlowLayout(FlowLayout.CENTER));
    r.setBackground(backgroundColor);
    r.add(button);

    add(p);
    add(q);
    add(r);
    p.add(gameLabel);
    q.add(nameLabel);
  }
}
