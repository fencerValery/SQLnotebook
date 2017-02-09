package javaproject.su-fencer.SQLnotebook;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


public class Drow{
        
         int x = 340;
         int y = 0;
         int x1 = 0;
         int y1 = 340;
         
         int x2 = 0;
         int y2 = 0;
         int x3 = 340;
         int y3 = 340;
        
         int xx = 90;
         int yy = 190;
         
         char[] s = {'H', 'a', 'p', 'p', 'y', ' ', 'B', 'i', 'r', 't', 'h', 'd', 'a', 'y'};
         public static String hap;
         private String happy = "Happy Birfhday!";
         
         
         int xxx = 170;
         int yyy = 170;
         int xxx1 = 170;
         int yyy1 = 170;
         int xxx2 = 170;
         int yyy2 = 170;
         int xxx3 = 170;
         int yyy3 = 170;
         int xxx4 = 170;
         int yyy4 = 170;
        
         
         
   public void goDrow(){
        
      JFrame frame = new JFrame();
      frame.setSize(400, 420);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      MyDrow myDrow = new MyDrow();
      frame.add(myDrow);
      frame.setVisible(true); 
      
      for (int i = 0; i < 340; i++){
          if (i <= 170){
              x--;
              y++;
              x1++;
              y1--;
              x2++;
              y2++;
              x3--;
              y3--;
              yy--;
              
              myDrow.repaint(); 
          }
          
          if (i > 170){
              x--;
              y--;
              x1++;
              y1++;
              x2++;
              y2--;
              x3--;
              y3++;
              yy++;
              xxx++;
              xxx1--;
              yyy2++;
              yyy3--;
              myDrow.repaint();    
          }
          
          try{
              Thread.sleep(20);
          }catch(Exception e){}
      }
      
      for (int i = 0; i < 150; i++ ){
           myDrow.repaint();
            try{
              Thread.sleep(20);
          }catch(Exception e){}
      }
     frame.setVisible(false);  
    }
  }