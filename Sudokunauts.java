import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/* TO DO LIST
//graphics and formating
-we might put it down before we get this far no lets finish out
seprate the boxes and make is a square instead of its rectangal now
and be able to select a sqaure by pressing on it
*/
class Sudokunauts extends JFrame{
   JTextField inputx,inputy;//textfields that input postion
   JButton[] buttonyarray ;//array of buttons
   Timer timer;//the timer object
   int mistakes=0,x,y;
   static int levelInt=2;//for now we will leave this //global time,mistake counter,and index as well as postion
   JLabel title,timeLabel,WinorLose,X,Y,mistakesLabel;//the title, and prompting labels like X and time
   int[][] check,ans;//actual arrays to check the correctness of the users input
   JMenuBar menubar;//menubar
   JMenu file;//menu bar item
   JMenuItem exit,reset;//menuitems to exit and reset the game
   JPanel middle;//global panel
   JTextField[][] textyarray; //textfield array
   static File[] levelyarray; //array of files
   Sudokunauts(){
      LevelsWindow levelWindow = new LevelsWindow(Sudokunauts.this);
      levelWindow.pack();
      levelWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      levelWindow.setVisible(true);
      levelWindow.setTitle("Intro");
      levelInt= levelWindow.Levelint;
   /*FILES OF LEVELS GETTING PUT INTO AN ARRAY*/ 
      try{
         File levels = new File("Levels");
         levelyarray = levels.listFiles();
      }
      catch (Exception e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
      int[][][] checkAndAns = readFile();//reading in the selected level
      ans = checkAndAns[0];//intilization of answer key array
      check = checkAndAns[1];//intiallization of the play array
      textyarray = new JTextField[9][9];//intialization of textfield array
      buttonyarray = new JButton[9];//intilization of Button array
      //initilization of menu bar//
      menubar = new JMenuBar();
      setJMenuBar(menubar);
      file  = new JMenu("file");
      menubar.add(file);
      exit = new JMenuItem("exit");
      file.add(exit);
      reset = new JMenuItem("reset");
      file.add(reset);
      //intilization of menu items and corresponding events//
      SystemClose c = new SystemClose();
      SystemReset r = new SystemReset();
      exit.addActionListener(c);
      reset.addActionListener(r);
      //contruction of JFrame board//
      Container pane = this.getContentPane();//whole board declared
      pane.setLayout(new GridLayout(4,1,5,5));//top(title,timer,and placement),middle(actual sudoku board),bottom1(Buttons),bottom2(the programs dialoige i.e you made a mistake,you win, or you lose)
      JPanel top = new JPanel();
      //top started//
      top.setLayout(new GridLayout(1,6));
      X = new JLabel("Placement X");
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
      timeLabel= new JLabel("00:00");
      top.add(timeLabel);
      pane.add(top);
      //middle started//
      middle = new JPanel();
      middle.setLayout(new GridLayout(9,9));
      for(int i=0;i<9;i++){
         for(int k=0;k<9;k++){
            textyarray[i][k]=new JTextField();
            middle.add(textyarray[i][k]);
            if(check[i][k]!=0)
               textyarray[i][k].setText(""+check[i][k]); }}
      pane.add(middle);
      //bottom1 started//
      JPanel bottom1 = new JPanel();
      bottom1.setLayout(new GridLayout(1,9));
      event e = new event();
      for(int j=0;j<=8;j++){
         buttonyarray[j] = new JButton(""+(j+1));
         bottom1.add(buttonyarray[j]);
         buttonyarray[j].addActionListener(e);}
      pane.add(bottom1);
      //bottom2//
      JPanel bottom2 = new JPanel();
      bottom2.setLayout(new GridLayout(1,2));
      mistakesLabel = new JLabel("Mistakes: 0/3");
      bottom2.add(mistakesLabel);
      WinorLose=new JLabel("");
      bottom2.add(WinorLose);
      pane.add(bottom2);
      //TIME CLASS CREATION//
      TimeClass tc = new TimeClass();
      timer = new Timer(1000,tc);
      timer.start();
      /*
       TimeClass tc = new TimeClass(count);
         timer = new Timer(1000,tc);
         timer.start();
      }
      public class TimeClass implements ActionListener{
         int count;
         TimeClass(int count){
            this.count=count;
         }
         public void actionPerformed(ActionEvent tc){
            count--;
            if(count>=1)
               label.setText("Count: "+count);
            else{
               timer.stop();
               label.setText("Done!");
               Toolkit.getDefaultToolkit().beep();}}
      
      */
   }
   
   public class TimeClass implements ActionListener{
      int sec;
      int min;
      public void actionPerformed(ActionEvent tc){
         if(checkWin())
            timer.stop();
         else{
            sec++;
            sec=sec%60;
            if(sec==0)
            min++;
            timeLabel.setText(min+":"+sec);
         }
      }
   
   }
   //BUTTON ACTIONLISTENER//
   public class event implements ActionListener{
      public void actionPerformed(ActionEvent e){
         int buttonnum = Integer.parseInt(e.getActionCommand());
         try{ //getting textfield input and changing it to int
            x = Integer.parseInt(inputy.getText());
            y = Integer.parseInt(inputx.getText());
            if(x<1||x>9||y<1||y>9){
               WinorLose.setText("prameters are 1-9 for both text fields please try again with appropriate data");
               return;
            }
         }
         catch(NumberFormatException ex){
            WinorLose.setText("prameters are 1-9 for both text fields please try again with appropriate data");
            return;
         }
          //CHECK FOR RIGHT ANSWER AND PLACEMENT//
         check[x-1][y-1]=buttonnum;
         if(!checkPiece()){
            mistakes++;
            WinorLose.setText("That is Wrong. You now have "+mistakes+"/3 mistakes");
            mistakesLabel.setText("Mistakes: "+mistakes+"/3");}
         else{
            textyarray[x-1][y-1].setText(""+buttonnum);}
         if(mistakes>=3){
            WinorLose.setText("YOU LOSE PRESS RESET TO RESTART LOSER!");
            for(int i=0;i<9;i++){
               buttonyarray[i].setEnabled(false);
            }}}}
   public boolean checkPiece(){ //CHECK METHOD//
      if(check[x-1][y-1]==ans[x-1][y-1])
         return true;
      return false; }
   public boolean checkWin(){
      if(check.equals(ans))
         return true;
      return false;
   }
   public class SystemClose implements ActionListener{  //EXIT METHOD//
      public void actionPerformed(ActionEvent c){
         System.exit(0);}}
   public class SystemReset implements ActionListener{  //RESET METHOD//
      public void actionPerformed(ActionEvent r){
       
      }
   }
   public static int[][][] readFile() //THE LEVEL READING METHOD//
   {
      int[][][] ans = new int[2][9][9]; //level TRIPLE array with check and ans in it
      try {
         File file = levelyarray[levelInt-1];
         Scanner scanner = new Scanner(file);
         String data = scanner.nextLine();
         for(int j = 0; j < 9; j++) 
         {
            data = scanner.nextLine();// a line of the file
            Scanner line = new Scanner(data);
            for(int i =0; i < 9; i++)
            { 
               ans[0][j][i] = line.nextInt();//an int of that line
            }
            line.close();
         }
         data = scanner.nextLine();//skipping the label line in the text file
         for(int j = 0; j < 9; j++) 
         {
            data = scanner.nextLine();
            Scanner line = new Scanner(data);
            for(int i =0; i < 9; i++)
            { 
               ans[1][j][i] = line.nextInt();
            }
            line.close();
         }
         scanner.close();//closing the character stream//
      } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
      return ans;
   }


   public static void main(String[] args){
      Sudokunauts mousa = new Sudokunauts();
      mousa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mousa.pack();
      mousa.setVisible(true);
      mousa.setTitle("Sudokunauts");
   
   }





}