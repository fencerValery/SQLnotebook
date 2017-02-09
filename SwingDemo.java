package javaproject.su-fencer.SQLnotebook;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;



public class SwingDemo {
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
      // создание контейнера верхнего уровн¤
     
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
                                                     + "фамили¤ или<br>"
                                                     + "им¤ или<br>"
                                                     + "отчество или<br>"
                                                     + "дата рождени¤ 1999-05-05");
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
                                      + "фамили¤ или<br>"
                                      + "им¤ или<br>"
                                      + "отчество или<br>"
                                      + "дата рождени¤ 1999-05-05");
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

