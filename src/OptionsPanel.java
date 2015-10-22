
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;
 

public class OptionsPanel extends myJPanel implements ActionListener{

  ImageIcon soundEffectsImageIcon; 
  JLabel backgroundOptionImageLabel, characterLabel;
  ImageIcon easy, hard, medium, easySelected, mediumSelected, hardSelected, backgroundOptionImageIcon;// TODO(alexyu): Create an image icon.
  JButton closeButton;
  JComboBox characters;
  Boolean soundOnOff = true;
  JButton soundEffectsButton;
  JLabel soundEffectsLabel, playerLabel;
  myJFrame topFrame;
 JToggleButton jtbButton;
 JRadioButton tbBeginner, tbAmateur, tbPro;
 ImageIcon soundOnImageIcon;
 ImageIcon soundOffImageIcon;
 JLabel soundOnOffLabel;
 JTextField playerNameField;
 int difficulty = 0;
 int character = 0;
 String playerName = "unknown";
 final Font ALLFONT = new Font("SEGOE UI",Font.BOLD, 17);
  final Color alphaZero = new Color(0, 0, 0, 30);

  public OptionsPanel(myJFrame frame) {
    super();
    topFrame = frame;
  JLabel empty = new  JLabel("");
  empty.setBounds(0,0,400,600);
  empty.setOpaque(true);
  empty.setBackground(alphaZero);

    soundEffectsImageIcon = new ImageIcon("src/icon-sounds.png");
    soundOnImageIcon= new ImageIcon("src/on.png");
    soundOffImageIcon = new ImageIcon("src/off.png");
    
    easy = new ImageIcon("src/easy.png");
    medium = new ImageIcon("src/medium.png");
        hard = new ImageIcon("src/hard.png");
                   easySelected = new ImageIcon("src/easy_selected.png");
                        mediumSelected  = new ImageIcon("src/medium_selected.png");
                            hardSelected  = new ImageIcon("src/hard_selected.png");
    soundEffectsLabel = new JLabel("SOUND EFFECTS : ");
     soundEffectsLabel.setFont(ALLFONT);
     soundEffectsLabel.setForeground(Color.WHITE);
    soundEffectsLabel.setBounds(20, 30, 150, 150);
    add(soundEffectsLabel);
     
      characterLabel = new JLabel("YOUR CHARACTER : ");
  characterLabel.setFont(ALLFONT);
      characterLabel.setForeground(Color.WHITE);
   characterLabel.setBounds(20, 290, 150, 200);
    add(characterLabel);
   String chars [] = {"JEFF", "STORM", "WOODY"};
   characters = new JComboBox(chars);
    
   characters.setBounds(180, 375, 150, 33);
   characters.setFont(ALLFONT);
           add(characters);
    
    playerLabel = new JLabel (" ENTER YOUR NAME : ");
    playerNameField = new JTextField(20);
    
 playerLabel.setBounds(20, 5, 250, 80);
   playerNameField.setBounds(200, 30, 150, 33);
    playerLabel.setFont(ALLFONT);
    playerNameField.setFont(ALLFONT);
    
     playerLabel.setForeground(Color.WHITE);
    
     add(playerLabel);
     add(playerNameField);
        
    soundEffectsButton = new JButton("on");
    soundEffectsButton.addActionListener(this);
    add(soundEffectsButton);
    
jtbButton = new JToggleButton("ToggleButton", false);
jtbButton.setIcon(soundOnImageIcon);

//////////////////////

jtbButton.setBounds(200, 90, 100, 40);
jtbButton.setOpaque(false);
jtbButton.setContentAreaFilled(false);
jtbButton.setBorderPainted(false);
jtbButton.setFocusPainted(false);

///////////////////

 add(jtbButton);
    jtbButton.addActionListener(new ActionListener( ) {
      public void actionPerformed(ActionEvent ev) {
       if(soundOnOff)
       {
           jtbButton.setSelected(true);
           jtbButton.setIcon(soundOffImageIcon);
           soundOnOff = false;
       }
           else
       {
           jtbButton.setSelected(false);
           jtbButton.setIcon(soundOnImageIcon);
           soundOnOff = true;
       }
               

      }
    });
    
     tbBeginner = new JRadioButton();
     tbAmateur = new JRadioButton();
     tbPro = new JRadioButton();
     ButtonGroup group = new ButtonGroup();
  
     group.add(tbBeginner);
     group.add(tbAmateur);
     group.add(tbPro);
     //////////////////
     
     tbBeginner.setBounds(110, 170, 150, 33);
     tbBeginner.setIcon(easy);
tbBeginner.setOpaque(false);
tbBeginner.setContentAreaFilled(false);
tbBeginner.setBorderPainted(false);
tbBeginner.setFocusPainted(false);
     
     ///////////////


//////////////////
     
    tbAmateur.setBounds(110, 220, 150, 33);
tbAmateur.setOpaque(false);
tbAmateur.setContentAreaFilled(false);
tbAmateur.setBorderPainted(false);
tbAmateur.setFocusPainted(false);
     tbAmateur.setIcon(medium);
     ///////////////

 
     //////////////////
     
 tbPro.setBounds(110, 270, 150, 33);
 tbPro.setOpaque(false);
 tbPro.setContentAreaFilled(false);
 tbPro.setBorderPainted(false);
 tbPro.setFocusPainted(false);
     tbPro.setIcon(hard);
     
     /////////////// 
     
     add(tbBeginner);
     add(tbAmateur);
     add(tbPro);
      tbBeginner.addActionListener(this);
    tbAmateur.addActionListener(this);
    tbPro.addActionListener(this);
     
 
   
    // Display the 'Close' button.
    closeButton = new JButton("Start");
   closeButton.setBounds(150, 530, 80, 30);
    closeButton.addActionListener(this);
    add(closeButton);
    add(empty);
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
      
      playerName = playerNameField.getText();
        System.out.print(playerName);
        topFrame.optionDone = true;
      topFrame.loadGamePanel();
    } 
    
  
    else if(o == tbBeginner)
    {
          tbBeginner.setIcon(easySelected);
          tbAmateur.setIcon(medium);
          tbPro.setIcon(hard);
          difficulty = 0;
    }
    else if(o == tbAmateur)
    {
          tbBeginner.setIcon(easy);
          tbAmateur.setIcon(mediumSelected);
          tbPro.setIcon(hard);
          difficulty = 1;
    }
      else if(o == tbPro)
    {
          tbBeginner.setIcon(easy);
          tbAmateur.setIcon(medium);
          tbPro.setIcon(hardSelected);
          difficulty = 2;
    }
       else if(o == characters)
    {
          String c = (String)characters.getSelectedItem();
         if (c.equals("JEFF"))
             character= 0;
         else if(c.equals("STORM"))
           character= 1;
         else if(c.equals("WOODY"))
               character= 2;   
    }
   
    
  }
}
