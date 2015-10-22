import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane; 

public class IntroPanel extends myJPanel implements ActionListener 
{
  ImageIcon backgroundImageIcon;
  ImageIcon rankingButtonImageIcon;
  ImageIcon startButtonImageIcon;
  JButton rankingButton;
  JButton startButton;
  JLabel backgroundImageLabel;
  OptionsPanel optionsPanel;
  RankingPanel rankingPanel;
  myJFrame topFrame;
  String sound="off";
  String diff = "easy";
  String ch= "jeff";

  public IntroPanel(myJFrame frame) 
  {
    super();
    topFrame = frame;
    optionsPanel = frame.optionsPanel;
    rankingPanel = frame.rankingPanel;
    // Display the 'Ranking' button.
    rankingButtonImageIcon = new ImageIcon("src/introPanelRanking.png");
    rankingButton = new JButton(rankingButtonImageIcon);
    rankingButton.setBounds(80, 450, 110, 60);
    rankingButton.addActionListener(this);
    add(rankingButton);
    // Display the 'Start' button.
    startButtonImageIcon = new ImageIcon("src/introPanelStart.png");
    startButton = new JButton(startButtonImageIcon);
    startButton.setBounds(210, 450, 110, 60);
    startButton.addActionListener(this);
    add(startButton);
    // Display the background image.  Order does matter.
    backgroundImageIcon = new ImageIcon("src/introPanelBackground.png");
    backgroundImageLabel = new JLabel(backgroundImageIcon, JLabel.CENTER);
    backgroundImageLabel.setBounds(0, 0, 400, 600);
    add(backgroundImageLabel);
  }

  @Override
  public void actionPerformed(ActionEvent e) 
  {
    Object o = e.getSource();
    if (o == rankingButton)
    {
          topFrame.loadRankingPanel();    
    }
    
    else if (o == startButton) {
        if (!topFrame.optionDone)
        {
             topFrame.loadOptionsPanel();
        }
        else
        {
            if (topFrame.optionsPanel.soundOnOff)
            {
                sound= "on";
               
            }
            else
            {
                sound = "off";
            }
            
             if (topFrame.optionsPanel.difficulty == 0)
            {
                diff = "easy";
               
            }
             else if(topFrame.optionsPanel.difficulty == 1)
            {
                diff = "medium";
            }
             else
             {
                 diff = "hard";
             }
             
             if(topFrame.optionsPanel.character == 0)
            {
                ch = "Jeff";
            }
             else if (topFrame.optionsPanel.character == 1)
             {
                 diff = "Storm";
             }
              else if (topFrame.optionsPanel.character == 2)
             {
                 diff = "Woody";
             }
            
           JOptionPane.showMessageDialog(null, "Dear " + topFrame.optionsPanel.playerName + ", \n your options are:\n "
                   + "Sound : "+ sound + "\n"
                   + "Difficulty : "+ diff + "\n"
                   + "Character : "+ ch + "\n"
                   + " Let's Play (^_^)!!!");
           

        }
     
    }
  }
}
