package javaproject.su-fencer.SQLnotebook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

 public class MyDrow extends JPanel{   
      public void paintComponent(Graphics q){
        
        q.setColor(Color.WHITE);
        q.fillRect(0, 0, this.getWidth(), this.getHeight());
        q.setColor(Color.red);
        q.fillOval(x, y, 40, 40);
        q.setColor(Color.BLUE);
        q.fillOval( x1, y1, 40, 40);
        q.setColor(Color.GREEN);
        q.fillOval(x2, y2, 40, 40);
        q.setColor(Color.YELLOW);
        q.fillOval( x3, y3, 40, 40);
       
      if (x1 > 170){
        q.setColor(Color.MAGENTA);
        q.fillOval(xxx, yyy, 40, 40);
        
        q.setColor(Color.blue);
        q.fillOval( xxx1, yyy1, 40, 40);
       
        q.setColor(Color.PINK);
        q.fillOval(xxx2, yyy2, 40, 40);
        
        q.setColor(Color.CYAN);
        q.fillOval( xxx3, yyy3, 40, 40);
        }
		
      if (x1 == 340){
        q.setColor(Color.YELLOW);
        q.fillRect(80, 160, 240, 30);
        q.setColor(Color.YELLOW);
        q.fillOval(60, 40, 80, 80);
        
        q.setColor(Color.GREEN);
        q.fillOval( 60, 260, 80, 80);
       
        q.setColor(Color.BLUE);
        q.fillOval(240, 40, 80, 80);
        
        q.setColor(Color.RED);
        q.fillOval( 240, 260, 80, 80);
             
        Font font1 = new Font("Time New Roman", Font.BOLD|Font.ITALIC, 30);
        q.setFont(font1);
        q.setColor(Color.red);
        q.drawString(hap, xx - 20, yy + 40);      
        }
		
        Font font = new Font("Time New Roman", Font.BOLD|Font.ITALIC, 30);
        q.setFont(font);
        q.setColor(Color.red);
        q.drawString(happy, xx, yy);         
      }
     
    }
  }