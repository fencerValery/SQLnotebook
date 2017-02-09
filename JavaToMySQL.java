package javaproject.su-fencer.SQLnotebook;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


public class JavaToMySQL {
 
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/ValeryPriceBase";
    private static final String user = "root";
    private static final String password = "1234";
 
    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    
    private  static ArrayList<JavaContact> list = new ArrayList<JavaContact>();
    
    
     public JavaToMySQL(){}
     
      public  static ArrayList<JavaContact> getList(){
          return list;
      }  
      public synchronized void  deleteUpdateContact(String s){   
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
 
            // getting Statement object to execute query
            stmt = con.createStatement();
            stmt.executeUpdate(s); 
            con.close();
            stmt.close();
                  
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }     
    }
     
    public  synchronized ArrayList<JavaContact> selectContact(){
         String query = "select * from Contact ";  
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
 
            // getting Statement object to execute query
            stmt = con.createStatement();
           
            // executing SELECT query
            rs = stmt.executeQuery(query);
               while (rs.next()) {
                String a = rs.getString("num");
                String b = rs.getString("family");
                String c = rs.getString("name");
                String d = rs.getString("fatherName");               
                String e = rs.getString("phone");
                String f = rs.getString("dateCreate");
                String g = rs.getString("dateChange");
                String i = rs.getString("birthday");
                
                          
               list.add( new JavaContact(b, c, d, e, f, g, i));
              
               }
             for (int j = 0; j < list.size(); j++){
                
                 String s = String.format("%tF", new Date()).substring(4);
                 String d = list.get(j).getBirthday().substring(4);
                 if (d != null && s.equals(d)){
                  System.out.println("День рождения " + list.get(j).getFamily() + " " + list.get(j).getName());
                    }
                
               }
    
             con.close();
             stmt.close();  
             rs.close();
            
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } 
         return list;
    }
     
    
    
    
     public synchronized void insertContact(){
       
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
 
            // getting Statement object to execute query
            stmt = con.createStatement();
            
            JavaContact val = new  JavaContact();
            val.makeContact();
            String query =  "insert into contact values (0, " + "'" + val.getFamily() + "'" + ", " + "'" + val.getName()+ "'" + ", "
                + "'" + val.getfatherName() + "'" + ", " + "'" + val.getPhone() + "'" + ", "
                + "'" + val.getBirthday() + "'" + ", " + "'" + val.getdateCreate() + "'" + ", "
                + "'" + val.getdateChange() + "');";
            // executing SELECT query
            stmt.executeUpdate(query);
             con.close();
             stmt.close();  
            
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } 
        
    }
    
        public void  disConnect(){
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
 // TODO code application logic here
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
    
    
     SwingUtilities.invokeLater(new Runnable(){
         public void run(){
             new SwingDemo();
         }
     });
          
    }
    
}





 














     
    
  
    
    
  