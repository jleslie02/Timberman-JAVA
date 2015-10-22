/**
 *
 * @author Matthew Ryan, Matthew Dalto
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GamePanel extends myJPanel implements KeyListener, ActionListener 
{
ImageIcon brLeft, brRight, rightImg, leftImg,timberManLeft, timberManRight; 
JLabel backgroundImageLabel,tMan, branch1r, branch2r, branch3r, branch1l, branch2l, branch3l;
JButton left, right;
Timer timer;
int delay;
JProgressBar timeBar;
OptionsPanel optPanel;

public GamePanel(myJFrame frame)
{
    super();    
    timberManLeft = new ImageIcon("src/tMan_small_left.jpg");
    timberManRight = new ImageIcon("src/tMan_small_right.jpg");
    brLeft = new ImageIcon("src/brLeft.jpg");
    brRight = new ImageIcon("src/brRight.jpg");
    rightImg = new ImageIcon("src/right.jpg");
    leftImg = new ImageIcon("src/left.jpg");
    left = new JButton(leftImg);
    right = new JButton(rightImg);
    tMan = new JLabel();
    right.setBounds(250, 475, 100, 100);
    left.setBounds(50, 475, 100, 100);
    tMan.setBounds(250, 475, 100, 100);
    backgroundImageLabel = new JLabel();
    backgroundImageLabel.setBounds(0, 0, 400, 600);
    //declare the 6 possible location for branches
    branch1r = new JLabel(brRight);
    branch1r.setBounds(250, 75, 153, 70);
    branch2r = new JLabel(brRight);
    branch2r.setBounds(250, 175, 153, 70);
    branch3r = new JLabel(brRight);
    branch3r.setBounds(250, 275, 153, 70);
    branch1l = new JLabel(brLeft);
    branch1l.setBounds(0, 75, 153, 70);
    branch2l = new JLabel(brLeft);
    branch2l.setBounds(0, 175, 153, 70);
    branch3l = new JLabel(brLeft);
    branch3l.setBounds(0, 275, 153, 70);
    delay = 1000;
    timer = new Timer(delay, this);
    timeBar = new JProgressBar(0,500);
    timeBar.setStringPainted(true);
    timeBar.setString("Time Remaining");
    left.addActionListener(this);
    right.addActionListener(this);
    add(backgroundImageLabel);
    add(left);
    add(right);    
    add(timeBar);
    add(tMan);
    /**
    add(branch1r);
    add(branch2r);
    add(branch3r);
    add(branch1l); 
    add(branch2l); 
    add(branch3l);
    **/
    setFocusable(true);
    addKeyListener(this);
    }

public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Image myImage = Toolkit.getDefaultToolkit().getImage("src/game_background.jpg");
    g.drawImage(myImage, 0, 0, this);
}

public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();
    if (o == left) {
      tMan.setIcon(timberManLeft); 
      tMan.setBounds(50, 375, 100, 100);
      
    } else if (o == right) {
      tMan.setIcon(timberManRight);
      tMan.setBounds(250, 375, 100, 100);
        
    }
  }

public void keyPressed(KeyEvent evt) 
  {
    System.out.println("Key pressed");
    int kk = evt.getKeyCode();
    if(kk ==  evt.VK_LEFT) 
    {
    tMan.setIcon(timberManLeft); 
    tMan.setBounds(50, 375, 100, 100);
    }
    if(kk ==  evt.VK_RIGHT) 
    {
    tMan.setIcon(timberManRight);
    tMan.setBounds(250, 375, 100, 100);
    }
  }

    public void keyTyped(KeyEvent evt) 
    {
    }
    public void keyReleased(KeyEvent evt) 
    {
    }

}
