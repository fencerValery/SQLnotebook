package javaproject.su-fencer.SQLnotebook;

public class DrowGo extends Thread {
     Drow t;
     DrowGo(Drow t){
     this.t = t;    
     }
       
    public void run(){ 
      t.goDrow();       
    }
 }  