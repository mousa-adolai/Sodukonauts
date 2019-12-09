import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Sudokunauts extends JFrame{
   JTextField inputx,inputy,tf11,tf12,tf13,tf14,tf15,tf16,tf17,tf18,tf19,tf21,tf22,tf23,tf24,tf25,tf26,tf27,tf28,tf29,tf31,tf32,tf33,tf34,tf35,tf36,tf37,tf38,tf39,tf41,tf42,tf43,tf44,tf45,tf46,tf47,tf48,tf49,tf51,tf52,tf53,tf54,tf55,tf56,tf57,tf58,tf59,tf61,tf62,tf63,tf64,tf65,tf66,tf67,tf68,tf69,tf71,tf72,tf73,tf74,tf75,tf76,tf77,tf78,tf79,tf81,tf82,tf83,tf84,tf85,tf86,tf87,tf88,tf89,tf91,tf92,tf93,tf94,tf95,tf96,tf97,tf98,tf99;
   JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
   Timer timer;
   int timeInt,mistakes=0;
   JLabel title,timeLabel,WinorLose,X,Y,mistakesLabel;
   int[][] check,ans;
   Sudokunauts(){
      Container pane = this.getContentPane();//whole board declared
      pane.setLayout(new GridLayout(4,1,5,5));//top(title,timer,and placement),middle(actual sudoku board),bottom1(Buttons),bottom2(the programs dialoige i.e you made a mistake,you win, or you lose)
      JPanel top = new JPanel();//top started
      top.setLayout(new GridLayout(1,6));
      X = new JLabel("Placement x");
      top.add(X);
      inputx = new JTextField();
      top.add(inputx);
      Y =new JLabel("Placement Y");
      top.add(Y);
      inputy = new JTextField();
      top.add(inputy);
      title = new JLabel("Sudokunauts",SwingConstants.CENTER);
      Font font = new Font("Serif",Font.BOLD,24);
      title.setFont(font);
      top.add(title);
      timeLabel= new JLabel("Timer: 0");
      top.add(timeLabel);
      pane.add(top);//top done
      JPanel middle = new JPanel();//middle started
      middle.setLayout(new GridLayout(9,9));
      tf11 =new JTextField();
      middle.add(tf11);
      tf12 =new JTextField();
      middle.add(tf12);
      tf13 =new JTextField();
      middle.add(tf13);
      tf14 =new JTextField();
      middle.add(tf14);
      tf15 =new JTextField();
      middle.add(tf15);
      tf16 =new JTextField();
      middle.add(tf16);
      tf17 =new JTextField();
      middle.add(tf17);
      tf18 =new JTextField();
      middle.add(tf18);
      tf19 = new JTextField();
      middle.add(tf19);
      tf21 =new JTextField();
      middle.add(tf21);
      tf22 =new JTextField();
      middle.add(tf22);
      tf23 =new JTextField();
      middle.add(tf23);
      tf24 =new JTextField();
      middle.add(tf24);
      tf25 =new JTextField();
      middle.add(tf25);
      tf26 =new JTextField();
      middle.add(tf26);
      tf27 =new JTextField();
      middle.add(tf27);
      tf28 =new JTextField();
      middle.add(tf28);
      tf29 = new JTextField();
      middle.add(tf29);
      tf31 =new JTextField();
      middle.add(tf31);
      tf32 =new JTextField();
      middle.add(tf32);
      tf33 =new JTextField();
      middle.add(tf33);
      tf34 =new JTextField();
      middle.add(tf34);
      tf35 =new JTextField();
      middle.add(tf35);
      tf36 =new JTextField();
      middle.add(tf36);
      tf37 =new JTextField();
      middle.add(tf37);
      tf38 =new JTextField();
      middle.add(tf38);
      tf39 = new JTextField();
      middle.add(tf39);
      tf41 =new JTextField();
      middle.add(tf41);
      tf42 =new JTextField();
      middle.add(tf42);
      tf43 =new JTextField();
      middle.add(tf43);
      tf44 =new JTextField();
      middle.add(tf44);
      tf45 =new JTextField();
      middle.add(tf45);
      tf46 =new JTextField();
      middle.add(tf46);
      tf47 =new JTextField();
      middle.add(tf47);
      tf48 =new JTextField();
      middle.add(tf48);
      tf49 = new JTextField();
      middle.add(tf49);
      tf51 =new JTextField();
      middle.add(tf51);
      tf52 =new JTextField();
      middle.add(tf52);
      tf53 =new JTextField();
      middle.add(tf53);
      tf54 =new JTextField();
      middle.add(tf54);
      tf55 =new JTextField();
      middle.add(tf55);
      tf56 =new JTextField();
      middle.add(tf56);
      tf57 =new JTextField();
      middle.add(tf57);
      tf58 =new JTextField();
      middle.add(tf58);
      tf59 = new JTextField();
      middle.add(tf59);
      tf61 =new JTextField();
      middle.add(tf61);
      tf62 =new JTextField();
      middle.add(tf62);
      tf63 =new JTextField();
      middle.add(tf63);
      tf64 =new JTextField();
      middle.add(tf64);
      tf65 =new JTextField();
      middle.add(tf65);
      tf66 =new JTextField();
      middle.add(tf66);
      tf67 =new JTextField();
      middle.add(tf67);
      tf68 =new JTextField();
      middle.add(tf68);
      tf69 = new JTextField();
      middle.add(tf69);
      tf71 =new JTextField();
      middle.add(tf71);
      tf72 =new JTextField();
      middle.add(tf72);
      tf73 =new JTextField();
      middle.add(tf73);
      tf74 =new JTextField();
      middle.add(tf74);
      tf75 =new JTextField();
      middle.add(tf75);
      tf76 =new JTextField();
      middle.add(tf76);
      tf77 =new JTextField();
      middle.add(tf77);
      tf78 =new JTextField();
      middle.add(tf78);
      tf79 = new JTextField();
      middle.add(tf79);
      tf81 =new JTextField();
      middle.add(tf81);
      tf82 =new JTextField();
      middle.add(tf82);
      tf83 =new JTextField();
      middle.add(tf83);
      tf84 =new JTextField();
      middle.add(tf84);
      tf85 =new JTextField();
      middle.add(tf85);
      tf86 =new JTextField();
      middle.add(tf86);
      tf87 =new JTextField();
      middle.add(tf87);
      tf88 =new JTextField();
      middle.add(tf88);
      tf89 = new JTextField();
      middle.add(tf89);
      tf91 =new JTextField();
      middle.add(tf91);
      tf92 =new JTextField();
      middle.add(tf92);
      tf93 =new JTextField();
      middle.add(tf93);
      tf94 =new JTextField();
      middle.add(tf94);
      tf95 =new JTextField();
      middle.add(tf95);
      tf96 =new JTextField();
      middle.add(tf96);
      tf97 =new JTextField();
      middle.add(tf97);
      tf98 =new JTextField();
      middle.add(tf98);
      tf99 = new JTextField();
      middle.add(tf99);
      pane.add(middle);//middle end
      JPanel bottom1 = new JPanel();//bottom1 started//
      bottom1.setLayout(new GridLayout(1,9));
      b1 = new JButton("1");
      bottom1.add(b1);
      b2 = new JButton("2");
      bottom1.add(b2);
      b3 = new JButton("3");
      bottom1.add(b3);
      b4 = new JButton("4");
      bottom1.add(b4);
      b5 = new JButton("5");
      bottom1.add(b5);
      b6 = new JButton("6");
      bottom1.add(b6);
      b7 = new JButton("7");
      bottom1.add(b7);
      b8 = new JButton("8");
      bottom1.add(b8);
      b9 = new JButton("9");
      bottom1.add(b9);
      pane.add(bottom1);
      event e = new event();
      b1.addActionListener(e);
      b2.addActionListener(e);
      b3.addActionListener(e);
      b4.addActionListener(e);
      b5.addActionListener(e);
      b6.addActionListener(e);
      b7.addActionListener(e);
      b8.addActionListener(e);
      b9.addActionListener(e);//bottom1 end
      JPanel bottom2 = new JPanel();//bottom2 started
      bottom2.setLayout(new GridLayout(1,2));
      mistakesLabel = new JLabel("Mistakes: 0/3");
      bottom2.add(mistakesLabel);
      WinorLose=new JLabel("");
      bottom2.add(WinorLose);
      pane.add(bottom2);
   }
   public class event implements ActionListener{
      public void actionPerformed(ActionEvent e){
      
      }
   }
   public static void main(String[] args){
   Sudokunauts mousa = new Sudokunauts();
   mousa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   mousa.pack();
   mousa.setVisible(true);
   mousa.setTitle("Sudokunauts");
   
   }





}