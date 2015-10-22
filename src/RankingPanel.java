
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.BorderFactory;
import java.util.ArrayList;
import java.io.*;
import javax.swing.JTable;
import java.io.Serializable;
import java.awt.Component;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class RankingPanel  extends myJPanel implements ActionListener, Serializable{
    
  ImageIcon soundEffectsImageIcon; 
  JLabel backgroundOptionImageLabel, characterLabel;
  ImageIcon easy, hard, medium, easySelected, mediumSelected, hardSelected, backgroundOptionImageIcon;// TODO(alexyu): Create an image icon.
  JButton closeButton;
  JComboBox characters;
  Boolean soundOnOff = true;
  JButton soundEffectsButton;
  JLabel bestScoreLabel;
  myJFrame topFrame;
 JToggleButton jtbButton;
 JRadioButton tbBeginner, tbAmateur, tbPro;
 ImageIcon soundOnImageIcon;
 ImageIcon soundOffImageIcon;
 JLabel soundOnOffLabel;
 int difficulty = 0;
 int character = 0;
 JTable scoreTable;
   final Color alphaZero = new Color(0, 0, 0, 64);
 ArrayList <Scores> scores;
    
      public RankingPanel(myJFrame frame)  {
             super();
           topFrame = frame;
   
    // TODO(alexyu): Load saved options.
       
        scores = new ArrayList<Scores>();
    
    // Override default layout.
    // TODO(alexyu): Work on a better layout.
     // Display the background image.  Order does matter.
  
   
    // TODO(alexyu): Should track the origin panel here.
    // Display the 'Sound Effects' button.
  
    easy = new ImageIcon("src/easy.png");
    medium = new ImageIcon("src/medium.png");
        hard = new ImageIcon("src/hard.png");
                   easySelected = new ImageIcon("src/easy_selected.png");
                        mediumSelected  = new ImageIcon("src/medium_selected.png");
                            hardSelected  = new ImageIcon("src/hard_selected.png");
    bestScoreLabel = new JLabel("BEST SCORES");
     bestScoreLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
    bestScoreLabel.setForeground(Color.WHITE);
    bestScoreLabel.setBounds(20, 20, 150, 150);
    add(bestScoreLabel);
    
     ArrayList <Scores> sc = new ArrayList <Scores>();
     sc.add(new Scores("MFKNER",548));
      sc.add(new Scores("MFKnmknnNER",8));
       sc.add(new Scores("MFKknknkNER",548));
        sc.add(new Scores("MFknknlkjvuKNER",548));
        
     
             try
      {
         FileOutputStream fileOut =
         new FileOutputStream("bestsc.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(sc);
         out.close();
         fileOut.close();
      
         
      }catch(IOException i)
      {
          i.printStackTrace();
      }
      
   
    // Deserializing the Object ArrayList of scores 
      try
      {
         FileInputStream fileIn = new FileInputStream("bestsc.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         scores = (ArrayList<Scores>) in.readObject();
         
         in.close();
         fileIn.close();
      }catch(IOException i)
      {
 
   
      }catch(ClassNotFoundException c)
      {
         System.out.println("Scores not found");
 
      }
      
       String  sco[][] = new String [scores.size()][2];
       
              
      for (int i =0; i<scores.size(); i++)
      {
          
        
          sco[i][0] = "  "+scores.get(i).getName();
          sco[i][1] = "  "+scores.get(i).getScore()+" pts";
        
         
           
      }
           bestScoreLabel.setFont(new Font("SEGOE UI", Font.BOLD, 20));
           bestScoreLabel.setForeground(Color.WHITE);
           bestScoreLabel.setBounds(0, 30, 400, 50);
           bestScoreLabel.setOpaque(true);
           bestScoreLabel.setBackground(alphaZero);
           
      Object columnNames[]= {"Name","Scores"};
      Object rowData[][] = sco;
      
      scoreTable = new JTable(rowData, columnNames);
      
      scoreTable.setEnabled(false);

    scoreTable.setOpaque(false);

  scoreTable.setBackground(alphaZero);
  scoreTable.setRowSelectionAllowed(false);
 
       scoreTable.setForeground(Color.WHITE);
       scoreTable.setRowHeight(60);
       scoreTable.setFont(new Font("Segoe UI", Font.BOLD, 16));
//////////////////
     
       scoreTable.setPreferredScrollableViewportSize(scoreTable.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane( scoreTable );
         scrollPane.setBackground(new Color(0,true));
         scrollPane.setOpaque(false);
     scrollPane.setBounds(0, 160, 400, 265);
     scrollPane.getViewport().setOpaque(false);
       add( scrollPane );

    
   
    // Display the 'Close' button.
    closeButton = new JButton("RETURN");
   closeButton.setBounds(150, 530, 80, 30);
    closeButton.addActionListener(this);
    add(closeButton);
    
     backgroundOptionImageIcon = new ImageIcon("src/bgOption.png");
    backgroundOptionImageLabel = new JLabel(backgroundOptionImageIcon, JLabel.CENTER);
    backgroundOptionImageLabel.setBounds(0, 0, 400, 600);
    add(backgroundOptionImageLabel);
    // TODO(alexyu): Load saved options.
  }

  @Override
  public void actionPerformed(ActionEvent e) 
  {
    Object o = e.getSource();
    if (o == closeButton) {
      // TODO(alexyu): Replace following code and return back to the origin panel.
      topFrame.loadIntroPanel();
    } 
    
  }
}
