
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class myJFrame extends JFrame {

  IntroPanel introPanel;
  OptionsPanel optionsPanel;
  RankingPanel rankingPanel;
  GamePanel gamePanel1;
  boolean optionDone = false;

  public myJFrame() {
    super("Timberman by Team 11");
    setResizable(false);  // So it doesn't mess up absolute positioning layout.
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(400, 600);
    setVisible(true);
    loadIntroPanel();
  }

  public void loadGamePanel() {
    getContentPane().removeAll();
    getContentPane().invalidate();
    gamePanel1 = new GamePanel(this);
    getContentPane().add(gamePanel1, "Center");
    getContentPane().revalidate();
  }

  public void loadIntroPanel() {
    getContentPane().removeAll();
    getContentPane().invalidate();
    introPanel = new IntroPanel(this);
    getContentPane().add(introPanel, "Center");
    getContentPane().revalidate();
  }
  
  public void loadRankingPanel()
  {
       getContentPane().removeAll();
    getContentPane().invalidate();
    rankingPanel = new RankingPanel(this);
    getContentPane().add(rankingPanel, "Center");
    getContentPane().revalidate();
  }

  public void loadOptionsPanel() {
    getContentPane().removeAll();
    getContentPane().invalidate();
    optionsPanel = new OptionsPanel(this);
    rankingPanel = new RankingPanel(this);
    
   
    getContentPane().add(optionsPanel, "Center");
    getContentPane().revalidate();
  }

}
