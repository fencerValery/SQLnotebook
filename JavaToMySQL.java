
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


/**
 *
 * @author 1
 */
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
                  System.out.println("ƒень рождени€ " + list.get(j).getFamily() + " " + list.get(j).getName());
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




class JavaContact {
private String family;
private String name;
private String fatherName;
private String phone;
private String dateCreate = String.format("%tF", new Date());
private String dateChange;
private String birthday;
private int birthyear;
private int birthmonth;
private int birthdayOfMonth;

public JavaContact(){
    
}
 
public JavaContact(String family,String name,String fatherName, String phone, String dateCreate, String dateChange, String birthday){
    this.family = family;
    this.name = name;
    this.fatherName = fatherName;
    this.phone = phone;
    this.dateCreate = dateCreate;
    this.dateChange = dateChange;
    this.birthday = birthday;
} 
    // JDBC variables for opening and managing connection
 
public String getdateChange(){
    return dateChange;
}
public String getdateCreate(){
    return dateCreate;
}
public String getFamily(){
    return family;
}
public void setFamily(String family){
    this.family = family;
    dateChange = String.format("%tF", new Date());
}

public String getName(){
    return name;
}
public void setName(String name){
    this.name = name;
    dateChange = String.format("%tF", new Date());
}

public String getfatherName(){
    return fatherName;
}
public void setFatherName(String fatherName){
    this.fatherName = fatherName;
    dateChange = String.format("%tF", new Date());
}

public String getPhone(){
    return phone;
}
public void setPhone(String phone){
    this.phone = phone;
    dateChange = String.format("%tF", new Date());
}


public String getBirthday(){
    return birthday;
}
public void setBirthday(int year, int month, int dayOfMonth){
  birthyear = year;
  birthmonth = month;
  birthdayOfMonth = dayOfMonth;
  GregorianCalendar birthday =  new GregorianCalendar(birthyear, birthmonth - 1, birthdayOfMonth); 
  this.birthday = String.format("%tF", birthday);
  dateChange = String.format("%tF", new Date());
}




public  void makeContact(){
    
    BufferedReader rd = null;
    
  try{
     
     rd = new BufferedReader(new InputStreamReader (System.in, "Cp1251")); 
      
    System.out.println("¬ведите фамилию");
    family = rd.readLine();
    System.out.println("¬ведите им€");
    name = rd.readLine();
    System.out.println("¬ведите отчество");
    fatherName = rd.readLine();
    System.out.println("¬ведите телефон");
    phone = rd.readLine();
    System.out.println("¬ведите год (2016) рождени€");
    String w33 = rd.readLine();
    birthyear = Integer.parseInt(w33);
    System.out.println("¬ведите мес€ц (2)  рождени€");
    String w11 = rd.readLine();
    birthmonth = Integer.parseInt(w11);
    System.out.println("¬ведите день (1) рождени€");
    String w22 = rd.readLine();
    birthdayOfMonth = Integer.parseInt(w22);   
   GregorianCalendar birthday =  new GregorianCalendar(birthyear, birthmonth - 1, birthdayOfMonth); 
   this.birthday = String.format("%tF", birthday);
   dateChange = String.format("%tF", new Date());
  
   
    
  }catch(IOException e){
        e.printStackTrace();
     }

}
}

 class SwingDemo {
  JFrame jfr;
 
  JLabel panLab;
  int lst;
  JTextField sea;
  JLabel searchRes;
  JavaToMySQL sql;
  JRadioButton allCon;
  JRadioButton allBirth;
  JRadioButton jbuttonAdd;
  JRadioButton jbuttonDelete;
  JRadioButton jbuttonSearch;
  JButton jbuttonExit;
  JRadioButton familyButton;
  JRadioButton nameButton;
  JRadioButton fatherButton;
  JRadioButton birthButton;
  JRadioButton phoneButton;
  JRadioButton exit;
  JCheckBox updateBox;
  JPanel pan11;
  
  
  
  
  
  
  
  SwingDemo(){
       
     sql = new JavaToMySQL();
     sql.selectContact();
     lst = JavaToMySQL.getList().size();
      // создание контейнера верхнего уровн€
     
        jfr = new JFrame("My contacts");
        jfr.setSize(550, 600);
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
      
        
        JPanel pan = new JPanel();
        pan.setSize(400, 400);
        jfr.add(pan, BorderLayout.CENTER);
        pan.setLayout(new BorderLayout());
        pan.setOpaque(true);
        pan.setBorder(BorderFactory.createLineBorder(Color.yellow, 9));
        JLabel labOption = new JLabel("Option");
        panLab = new JLabel("", SwingConstants.CENTER);
        JScrollPane scroll = new JScrollPane(panLab);
        scroll.setViewportBorder(BorderFactory.createLineBorder(Color.GREEN, 7));
        JLabel jlabelScroll = new JLabel(" онтакты", SwingConstants.CENTER);
        scroll.setColumnHeaderView(jlabelScroll);
        pan.add(scroll, BorderLayout.CENTER);
        allCon = new JRadioButton("allCon");
        allBirth = new JRadioButton("allBirth");
        jbuttonAdd = new JRadioButton("add");
        jbuttonDelete = new JRadioButton("delete");
        jbuttonSearch = new JRadioButton("search");
        jbuttonExit = new JButton("EXIT");
        ButtonGroup bg = new ButtonGroup();
        bg.add(allCon);
        bg.add(allBirth);
        bg.add(jbuttonAdd);
        bg.add(jbuttonDelete);
        bg.add( jbuttonSearch);
       
        pan11 = new JPanel();
        pan11.setSize(new Dimension(50, 50));
        pan11.setLayout(new GridLayout(7, 1));
        pan.add(pan11, BorderLayout.WEST);
        pan11.add(labOption );
        pan11.add(allCon);
        pan11.add(allBirth);
        pan11.add(jbuttonAdd);
        pan11.add(jbuttonDelete);
        pan11.add(jbuttonSearch);
        pan11.add(jbuttonExit);
        allCon.setEnabled(true);
        allBirth.setEnabled(true);
        jbuttonAdd.setEnabled(true);
        jbuttonDelete.setEnabled(true);
        jbuttonSearch.setEnabled(true);
       
        
        allCon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
             
                
                if (ae.getActionCommand().equals("allCon")){
                    String s, g = "";
                    lst = JavaToMySQL.getList().size();
                    for (int i = 0; i < lst; i++){
                     s = "" + (i + 1) + "<br>family:    " + JavaToMySQL.getList().get(i).getFamily() + "<br>name:    "
                     + JavaToMySQL.getList().get(i).getName()  + "<br>father name:    " + JavaToMySQL.getList().get(i).getfatherName()+ "<br>"
                     + JavaToMySQL.getList().get(i).getPhone() + "<br>" 
                     +  "birthday:   " + JavaToMySQL.getList().get(i).getBirthday() + "<br>"
                     +  "create:    " + JavaToMySQL.getList().get(i).getdateCreate() + "<br>"
                     +  "change:    " + JavaToMySQL.getList().get(i).getdateChange() + "<br>"
                             + "<br>"; 
                     
                     g = g + s;
                    }
                    
                   panLab.setText("<html>" + g); 
                 }
                
            }
        });
        
         allBirth.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                 
                 
               
                
                if (ae.getActionCommand().equals("allBirth")){
                     GregorianCalendar cal = new GregorianCalendar();
                     GregorianCalendar cal1 = new GregorianCalendar();
                     cal1.add(cal1.DATE, 1);
                     GregorianCalendar cal2 = new GregorianCalendar();
                     cal2.add(cal1.DATE, 2);
                     GregorianCalendar cal3 = new GregorianCalendar();
                     cal3.add(cal1.DATE, 3);
        
                     String happy = " ";
                     String s = String.format("%tF", cal).substring(4);
                     String s1 = String.format("%tF",  cal1).substring(4);
                     String s2 = String.format("%tF",  cal2).substring(4);
                     String s3 = String.format("%tF",  cal3).substring(4);
                     String d = " ";
                     
                   
                     for (int i = 0; i < lst; i++){
                         
                      if (s.equals(JavaToMySQL.getList().get(i).getBirthday().substring(4))){
                         d += JavaToMySQL.getList().get(i).getFamily() + " "
                           + JavaToMySQL.getList().get(i).getName() + " " + JavaToMySQL.getList().get(i).getBirthday() + "<br>";
                         
                         happy += JavaToMySQL.getList().get(i).getFamily() + " "
                           + JavaToMySQL.getList().get(i).getName();
                      }
                      if (s1.equals(JavaToMySQL.getList().get(i).getBirthday().substring(4))){
                          d += JavaToMySQL.getList().get(i).getFamily() + " "
                           + JavaToMySQL.getList().get(i).getName() + " " + JavaToMySQL.getList().get(i).getBirthday() + "<br>";
                           }
                      if (s2.equals(JavaToMySQL.getList().get(i).getBirthday().substring(4))){
                          d += JavaToMySQL.getList().get(i).getFamily() + " "
                           + JavaToMySQL.getList().get(i).getName() + " " + JavaToMySQL.getList().get(i).getBirthday() + "<br>";
                      }
                           if (s3.equals(JavaToMySQL.getList().get(i).getBirthday().substring(4))){
                          d += JavaToMySQL.getList().get(i).getFamily() + " "
                           + JavaToMySQL.getList().get(i).getName() + " " + JavaToMySQL.getList().get(i).getBirthday() + "<br>";
                          
                          
                         
                           
                      }
                           
                     } 
                   
                    if(d.equals(" ")){
                      panLab.setText("<html> TODAY: " + "<br>" + String.format("%tF", cal));
                      
                    
                     
                      
                     
                    } 
                    else{ panLab.setText("<html> TODAY: " + "<br>" + String.format("%tF", cal) + "<br>"
                   + "BIRTHDAY: " + "<br>" + d);
                   
                     try{  
                                    Drow drow = new Drow();
                                    drow.hap = happy;
                                 
                                  jfr.setVisible(false);
                                   Thread.yield();
                                   
                                   new DrowGo(drow).start();
                                   drow = null;
                           }catch(Exception e){}
                      finally{
                      jfr.setVisible(true);
                     
                             }     
                
                    }
                     
                 }       
            }
        });
         
      jbuttonAdd.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent ae){
              if (ae.getActionCommand().equals("add")){
                String family = JOptionPane.showInputDialog("Enter family");
                String name = JOptionPane.showInputDialog("Enter name");
                String fatherName = JOptionPane.showInputDialog("Enter fatherName");
                String phone = JOptionPane.showInputDialog("Enter phone");
                String birthday = JOptionPane.showInputDialog("<html>Enter birthday year month day<br>1999-02-01");
                String dateCreate = String.format("%tF", new Date());
                String dateChange = String.format("%tF", new Date());
                JavaContact javaContact = new JavaContact(family, name, fatherName, phone, dateCreate, dateChange, birthday);
                String pol = "insert into contact values (0, " + "'" + javaContact.getFamily() + "'" + ", " + "'" + javaContact.getName()+ "'" + ", "
                + "'" + javaContact.getfatherName() + "'" + ", " + "'" + javaContact.getPhone() + "'" + ", "
                + "'" + javaContact.getBirthday() + "'" + ", " + "'" + javaContact.getdateCreate() + "'" + ", "
                + "'" + javaContact.getdateChange() + "');";
               
                sql.deleteUpdateContact(pol);
                JavaToMySQL.getList().add(javaContact);
                
                 allCon.doClick();
               
                 
              }
          }
      });
         
         
    
      
      
      
      
      
      
      jbuttonDelete.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent ae){
           if (ae.getActionCommand().equals("delete")){
                String number;
                int numb;
               number = JOptionPane.showInputDialog("<html>Enter number.<br>"
                 + "MIN >= 1"      + " MAX <= " + JavaToMySQL.getList().size());
                numb = Integer.parseInt(number);
                
                String pol = "delete from contact where num=" + numb;
                sql.deleteUpdateContact(pol);
                JavaToMySQL.getList().remove(numb - 1);
                 allCon.doClick();
                
               }            
           }            
      });
      
      
       jbuttonSearch.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent ae){
           if (ae.getActionCommand().equals("search")){
                String number;
               
               number = JOptionPane.showInputDialog("<html>Search Result:<br>"
                                                     + "фамили€ или<br>"
                                                     + "им€ или<br>"
                                                     + "отчество или<br>"
                                                     + "дата рождени€ 1999-05-05");
                String d = "";
               for (int i = 0; i < lst; i++){
                   if (number.equalsIgnoreCase(JavaToMySQL.getList().get(i).getFamily()) 
                       || number.equalsIgnoreCase(JavaToMySQL.getList().get(i).getName())
                       || number.equalsIgnoreCase(JavaToMySQL.getList().get(i).getfatherName())
                       || number.equals(JavaToMySQL.getList().get(i).getPhone().substring(0, 10))
                       || number.equals(JavaToMySQL.getList().get(i).getBirthday())){
                     d += (i + 1) + "<br>" + JavaToMySQL.getList().get(i).getFamily() + " "
                     + JavaToMySQL.getList().get(i).getName()  + " " + JavaToMySQL.getList().get(i).getfatherName()+ "<br>"
                     + JavaToMySQL.getList().get(i).getPhone() + " " +  "<br>" 
                     +  "birthday: " + JavaToMySQL.getList().get(i).getBirthday() + "<br>"
                     +  "create: " + JavaToMySQL.getList().get(i).getdateCreate() + "<br>"
                     +  "change: " + JavaToMySQL.getList().get(i).getdateChange() + "<br>"
                             + "<br>";
                     
                   }
               }
               if (d.equals("")){
                    panLab.setText("<html>Result of search<br>No contact. ¬веди еще<br>"
                                      + "фамили€ или<br>"
                                      + "им€ или<br>"
                                      + "отчество или<br>"
                                      + "дата рождени€ 1999-05-05");
               }
               else {
                   panLab.setText("<html>Result of search<br>" + d);
               }
                
            
                
               }            
           }            
      });
      
      
     
     jbuttonExit. addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        System.exit(0);
           }  
        });    
      
      
      
      
      
         
         
        JPanel pan12 = new JPanel();
        pan12.setSize(new Dimension(50, 50));
        pan12.setLayout(new GridLayout(8, 1));
        pan.add(pan12, BorderLayout.EAST);
        updateBox = new JCheckBox("<html>Option<br>Enable");
        pan12.add(updateBox);
        updateBox.setEnabled(true);
        JLabel update = new JLabel("<html>Option<br>change");
        pan12.add(update);
        familyButton = new JRadioButton("family");
        nameButton = new JRadioButton("name");
        fatherButton = new JRadioButton("father");
        birthButton = new JRadioButton("birth");
        phoneButton = new JRadioButton("phone");
        exit = new JRadioButton("<html>exit<br>option");
        ButtonGroup dr = new ButtonGroup();
        dr.add(familyButton);
        dr.add(nameButton);
        dr.add(fatherButton);
        dr.add(birthButton);
        dr.add(phoneButton);
        dr.add(exit);
        pan12.add(familyButton);
        pan12.add(nameButton);
        pan12.add(fatherButton);
        pan12.add(birthButton);
        pan12.add(phoneButton);
        pan12.add(exit);
        familyButton.setEnabled(false);
        nameButton.setEnabled(false);
        fatherButton.setEnabled(false);
        birthButton.setEnabled(false);
        phoneButton.setEnabled(false);
        exit.setEnabled(false);
        
        exit. addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
        if (updateBox.isSelected()){
         updateBox.doClick();
         }         
        }
        }); 
        
        
        
        updateBox.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent ae){
            if (ae.getStateChange() == ItemEvent.SELECTED) {  
             allCon.setEnabled(false);
             allBirth.setEnabled(false);
             jbuttonAdd.setEnabled(false);
             jbuttonDelete.setEnabled(false);
             jbuttonSearch.setEnabled(false);
             
             familyButton.setEnabled(true);
             nameButton.setEnabled(true);
             fatherButton.setEnabled(true);
             birthButton.setEnabled(true);
             phoneButton.setEnabled(true);
             exit.setEnabled(true);
             
            }
            if (ae.getStateChange() == ItemEvent.DESELECTED){
              allCon.setEnabled(true);
             allBirth.setEnabled(true);
             jbuttonAdd.setEnabled(true);
             jbuttonDelete.setEnabled(true);
             jbuttonSearch.setEnabled(true);
             
             familyButton.setEnabled(false);
             nameButton.setEnabled(false);
             fatherButton.setEnabled(false);
             birthButton.setEnabled(false);
             phoneButton.setEnabled(false);
             exit.setEnabled(false);
                
           }
          }
       });
        
        familyButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
         if (ae.getActionCommand().equals("family")){
         String s = JOptionPane.showInputDialog("Enter number contact for change MIN >= 1 MAX <= " + JavaToMySQL.getList().size());
         int s1 = Integer.parseInt(s);
         String ss = JOptionPane.showInputDialog("Enter family for change");
         String date = String.format("%tF", new Date());;
         String pol = "update contact  set family= '" + ss
            + "'" 
             + ", dateChange= '"
             + date + "' where num=" + (s1); 
         sql.deleteUpdateContact(pol);
         JavaToMySQL.getList().get(s1 - 1).setFamily(ss);
         exit.doClick();
         allCon.doClick();
         }
        }
        }); 
        
        
        
    nameButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
         if (ae.getActionCommand().equals("name")){
         String s = JOptionPane.showInputDialog("Enter number contact for change MIN >= 1 MAX <= " + JavaToMySQL.getList().size());
         int s1 = Integer.parseInt(s);
         String ss = JOptionPane.showInputDialog("Enter name for change");
         String date = String.format("%tF", new Date());;
         String pol = "update contact set name= '" + ss
            + "'" 
             + ", dateChange= '"
             + date + "' where num=" + (s1); 
         sql.deleteUpdateContact(pol);
         JavaToMySQL.getList().get(s1 - 1).setName(ss);
         exit.doClick();
         allCon.doClick();
         }
        }
        });     
        
        
        
     fatherButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
         if (ae.getActionCommand().equals("father")){
         String s = JOptionPane.showInputDialog("Enter number contact for change MIN >= 1 MAX <= " + JavaToMySQL.getList().size());
         int s1 = Integer.parseInt(s);
         String ss = JOptionPane.showInputDialog("Enter fatherName for change");
         String date = String.format("%tF", new Date());;
         String pol = "update contact set fatherName= '" + ss
            + "'" 
             + ", dateChange= '"
             + date + "' where num=" + (s1); 
         sql.deleteUpdateContact(pol);
         JavaToMySQL.getList().get(s1 - 1).setFatherName(ss);
         exit.doClick();
         allCon.doClick();
         }
        }
        });  
     
     
     birthButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
         if (ae.getActionCommand().equals("birth")){
         String s = JOptionPane.showInputDialog("Enter number contact for change MIN >= 1 MAX <= " + JavaToMySQL.getList().size());
         int s1 = Integer.parseInt(s);
         String ss = JOptionPane.showInputDialog("Enter birthday year for change 1967");
         int ss1 = Integer.parseInt(ss);
         String ss2 = JOptionPane.showInputDialog("Enter birthday month for change 1");
         int ss4 = Integer.parseInt(ss2);
         String ss5 = JOptionPane.showInputDialog("Enter birthday day for change 1");
         int ss6 = Integer.parseInt(ss5);
         JavaToMySQL.getList().get(s1 - 1).setBirthday(ss1, ss4, ss6);
         
         String date = String.format("%tF", new Date());
        
         
         String pol = "update contact  set birthday= '" +  JavaToMySQL.getList().get(s1 - 1).getBirthday()
            + "'" 
             + ", dateChange= '"
             + date + "' where num=" + (s1); 
         sql.deleteUpdateContact(pol);
        
         exit.doClick();
         allCon.doClick();
         }
        }
        });  
     
        
        phoneButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
         if (ae.getActionCommand().equals("phone")){
         String s = JOptionPane.showInputDialog("Enter number contact for change MIN >= 1 MAX <= " + JavaToMySQL.getList().size());
         int s1 = Integer.parseInt(s);
         String ss = JOptionPane.showInputDialog("Enter  phone for change");
         String date = String.format("%tF", new Date());;
         String pol = "update contact  set  phone= '" + ss
            + "'" 
             + ", dateChange= '"
             + date + "' where num=" + (s1); 
         sql.deleteUpdateContact(pol);
         JavaToMySQL.getList().get(s1 - 1).setPhone(ss);
         exit.doClick();
         allCon.doClick();
         }
        }
        });   
        
        
        jfr.add(pan);
        
        
      
        
        
        
        
        
        
        jfr.setVisible(true); 
    
    
 
         
         
  }
  
  
  
  
  
 
 }
















     
    
  class Drow{
        
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
     
    
    
    class MyDrow extends JPanel{
       
       
       
        
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
    
 class DrowGo extends Thread {
     Drow t;
     DrowGo(Drow t){
     this.t = t;    
     }
       
    public void run(){
             
             t.goDrow(); 
            
    }
 }  