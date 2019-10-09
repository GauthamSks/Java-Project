import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.sql.*;
import java.io.*;

public class Login{
    public Login(){


        ImagePanel panel1 = new ImagePanel(new ImageIcon("img.jpg").getImage());
        ImagePanel panel2 = new ImagePanel(new ImageIcon("img.jpg").getImage());
        JFrame J = new JFrame();
        Color o1 = new Color(255, 51, 51);
        J.setSize(390,530);
        J.setLayout(null);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        J.setLocationRelativeTo(null);
        J.setContentPane(new JLabel(new ImageIcon("BG.jpg")));
        J.setTitle("Login");
        JPanel Sin = new JPanel(); //Sign in Panel
        JPanel Sup = new JPanel(); //Sign up Panel
        UIManager.put("TabbedPane.selected", o1);
        UIManager.put("TabbedPane.contentOpaque", true);
        JTabbedPane tab=new JTabbedPane(); 
        tab.add("Sign In",Sin);
        tab.add("Create an Account",Sup);
        tab.setBounds(0,40,390,490);  
        J.add(tab);
        J.getContentPane().setBackground(o1);
        J.setVisible(true);

        //SignIn Panel Design
        
        Sin.setLayout(null);
        String[] D = {"Student","Faculty"};
        JComboBox DD = new JComboBox<>(D);
        DD.setBounds(135,50,100,20);
        Sin.add(DD);
        JLabel UID = new JLabel("User Name");
        UID.setBounds(10,100,100,10);
        Sin.add(UID);
        JTextField UIDIn = new JTextField();
        UIDIn.setBounds(10,120,250,20);
        Sin.add(UIDIn);
        JLabel p = new JLabel("Password");
        p.setBounds(10,155,100,10);
        Sin.add(p);
        JPasswordField pf = new JPasswordField();
        pf.setBounds(10,172,250,20);
        Sin.add(pf);
        JButton Lin = new JButton("Sign In");
        Lin.setBounds(10,205,100,50);
        Lin.setBackground(Color.GREEN);
        Sin.add(Lin);
        tab.setBackground(Color.RED);
        Sin.add(panel1);

        // SignUp panel

        Sup.setLayout(null);
        JComboBox DD1 = new JComboBox<>(D);
        DD1.setBounds(135,50,100,20);
        Sup.add(DD1);
        JLabel Name = new JLabel("ID:");
        Name.setBounds(10,190,100,50);
        Sup.add(Name);
        JTextField Nf = new JTextField();
        Nf.setBounds(10,230,250,20);
        Sup.add(Nf);
        JLabel UID1 = new JLabel("USER NAME:");
        UID1.setBounds(10,100,100,10);
        Sup.add(UID1);
        JTextField UIDIn1 = new JTextField();
        UIDIn1.setBounds(10,120,250,20);
        Sup.add(UIDIn1);
        JLabel p1 = new JLabel("PASSWORD:");
        p1.setBounds(10,155,100,10);
        Sup.add(p1);
        JPasswordField pf1 = new JPasswordField();
        pf1.setBounds(10,172,250,20);
        Sup.add(pf1);
        JButton Lin1 = new JButton("Sign Up");
        Lin1.setBounds(10,265,100,50);
        Lin1.setBackground(Color.GREEN);
        Sup.add(Lin1);
        tab.setBackground(Color.RED);
        Sup.add(panel2);

        Lin.addActionListener(new ActionListener(){
        
          @Override
          public void actionPerformed(ActionEvent e) {
            {
              
              if(DD.getSelectedItem() == "Student"){
                try{
                  File htmlFile = new File(this.getClass().getResource("student1.html").getFile());
                  Desktop.getDesktop().browse(htmlFile.toURI());
                  }
                  catch(IOException ex){
                    System.out.println(ex);
                  }
              }
              else{
                try{
                    Faculty f = new Faculty();
                    J.setVisible(false);
                  }
                  catch(Exception e1){
                    System.out.println(e1);
                  }
              }
            }
          }
        });

        // Sign-up button Link to MySQl
        
        Lin1.addActionListener(new ActionListener(){
        
          @Override
          public void actionPerformed(ActionEvent e) {
               String Uname =  UIDIn1.getText();
               String Upw  =  String.valueOf(pf1.getPassword());
               String UID = Nf.getText();
              if(DD1.getSelectedItem() == "Student"){
               try{
                // Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Students","Beta","1234"); //Connecting MySQL to java via JDBC API.
                Statement stmt=con.createStatement();//Create a statement object to perform a query.
                
                // Method to Insert
                String query1 = " insert into users(Name,ID,Subject,P1,P2,P3,Grade,Password,Field)"+" values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = con.prepareStatement(query1);
                preparedStmt.setString (1,Uname);
                preparedStmt.setString (2,UID);
                preparedStmt.setString (3,null);
                preparedStmt.setInt(4,0);
                preparedStmt.setInt(5,0);
                preparedStmt.setInt(6,0);
                preparedStmt.setString (7,null);
                preparedStmt.setString (8,Upw);
                preparedStmt.setString (9,"S");
                preparedStmt.execute();
                JOptionPane.showMessageDialog(null, "Successful Sign-up"); 
            }
            catch(Exception e1){ System.out.println(e1);}    
          }
          else if(DD1.getSelectedItem() == "Faculty"){
            try{
              // Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Students","Beta","1234"); //Connecting MySQL to java via JDBC API.
              Statement stmt=con.createStatement();//Create a statement object to perform a query.
              
              // Method to Insert
              String query1 = " insert into users(Name,ID,Subject,P1,P2,P3,Grade,Password,Field)"+" values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
              PreparedStatement preparedStmt = con.prepareStatement(query1);
              preparedStmt.setString (1,Uname);
              preparedStmt.setString (2,UID);
              preparedStmt.setString (3,null);
              preparedStmt.setInt(4,0);
              preparedStmt.setInt(5,0);
              preparedStmt.setInt(6,0);
              preparedStmt.setString (7,null);
              preparedStmt.setString (8,Upw);
              preparedStmt.setString (9,"F");
              preparedStmt.execute();
              JOptionPane.showMessageDialog(null, "Successful Sign-up"); 
          }
          catch(Exception e1){ System.out.println(e1);} 
        }         
      }
    });



  } 
    public static void main(String[] args) {
        Login l = new Login();
    }
}


class ImagePanel extends JPanel {

    private Image img;
    public ImagePanel(String img) {
      this(new ImageIcon(img).getImage());
    }
  
    public ImagePanel(Image img) {
      this.img = img;
      Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
      setPreferredSize(size);
      setMinimumSize(size);
      setMaximumSize(size);
      setSize(size);
      setLayout(null);
    }
  
    public void paintComponent(Graphics g) {
      g.drawImage(img, 0, 0, null);
    }
  
  }