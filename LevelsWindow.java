import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class LevelsWindow extends JDialog{
   ImageIcon logo;
   JLabel logoholder;
   JLabel prompt;
   JButton[] buttons;
   int Levelint;
   LevelsWindow(JFrame frame){
      super(frame, "Levels Window/ intro page",true);
      Container pane = this.getContentPane();
      pane.setLayout(new GridLayout(3,1,2,2));
      JPanel top = new JPanel();
      top.setLayout(new GridLayout(1,1));
      logo= new ImageIcon(getClass().getResource("/Images/sudokunauts logo.JPG"));
      logoholder = new JLabel(logo);
      top.add(logoholder);
      pane.add(top);
      JPanel middle = new JPanel();
      middle.setLayout(new GridLayout(1,1));
      prompt= new JLabel("CHOOSE A LEVEL:",SwingConstants.CENTER);
      middle.add(prompt);
      pane.add(middle);
      JPanel bottom = new JPanel();
      bottom.setLayout(new GridLayout(2,5));
      buttons= new JButton[10];
      for(int i=0;i<10;i++){
         bottom.add(buttons[i]=new JButton(""+(i+1)));}
      pane.add(bottom);
      event e = new event();
      for(int k=0; k<10;k++){
         buttons[k].addActionListener(e);
      }
   }
public class event implements ActionListener{
public void actionPerformed(ActionEvent e){
Levelint= Integer.parseInt(e.getActionCommand());
LevelsWindow.this.setVisible(false);
}
}

}