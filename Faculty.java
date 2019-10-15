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
import java.io.*;
import java.sql.*;

public class Faculty {
    public Faculty(String ID) {

        JFrame J = new JFrame();
        Color o1 = new Color(3, 165, 252);
        J.setSize(900,600);
        J.setLayout(null);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        J.setLocationRelativeTo(null);
        J.setContentPane(new JLabel(new ImageIcon("FBG.jpg")));
        J.setTitle("Faculty");
        JPanel M = new JPanel(); // Marks Panel
        JPanel A = new JPanel(); // Attendance Panel
        JPanel P = new JPanel(); // Personal Panel
        UIManager.put("TabbedPane.selected", o1);
        UIManager.put("TabbedPane.contentOpaque", true);
        JTabbedPane tab = new JTabbedPane();
        tab.add("MARKS", M);
        tab.add("ATTENDANCE", A);
        tab.add("PERSONAL", P);
        tab.setBounds(60, 140, 1000, 500);
        J.add(tab);
        J.getContentPane().setBackground(o1);
        J.setVisible(true);

        ImagePanel panel1 = new ImagePanel(new ImageIcon("FBG5.jpg").getImage());
        ImagePanel panel2 = new ImagePanel(new ImageIcon("FBG5.jpg").getImage());
        ImagePanel panel3 = new ImagePanel(new ImageIcon("FBG5.jpg").getImage());

        // Marks Panel Design

        M.setLayout(null);
        String[] D = { "P1", "P2", "END SEM" };
        String[] Sub = { "Maths", "DS", "Java" };
        JComboBox SubD = new JComboBox<>(Sub);
        SubD.setBounds(10, 50, 100, 20);
        M.add(SubD);
        JComboBox DD = new JComboBox<>(D);
        DD.setBounds(135, 50, 100, 20);
        M.add(DD);
        JLabel SN = new JLabel("STUDENT NAME:");
        SN.setBounds(10, 100, 150, 10);
        M.add(SN);
        JTextField AIn = new JTextField();
        AIn.setBounds(10, 118, 250, 20);
        M.add(AIn);
        JLabel B = new JLabel("ROLL NO:");
        B.setBounds(10, 155, 100, 10);
        M.add(B);
        JTextField BIn = new JTextField();
        BIn.setBounds(10, 172, 250, 20);
        M.add(BIn);
        JLabel C = new JLabel("MARKS:");
        C.setBounds(10, 205, 100, 10);
        M.add(C);
        JTextField CIn = new JTextField();
        CIn.setBounds(10, 222, 250, 20);
        M.add(CIn);
        JButton Up = new JButton("UPDATE");
        Up.setBounds(10,255,100,50);
        Up.setBackground(o1);
        M.add(Up);
        M.add(panel1);
        tab.setBackground(Color.WHITE);

        // Attendance Panel

        A.setLayout(null);
        JComboBox SubD1 = new JComboBox<>(Sub);
        SubD1.setBounds(10, 50, 100, 20);
        A.add(SubD1);
        JLabel SN1 = new JLabel("STUDENT NAME:");
        SN1.setBounds(10, 100, 150, 10);
        A.add(SN1);
        JTextField AIn1 = new JTextField();
        AIn1.setBounds(10, 118, 250, 20);
        A.add(AIn1);
        JLabel B1 = new JLabel("ROLL NO:");
        B1.setBounds(10, 155, 100, 10);
        A.add(B1);
        JTextField BIn1 = new JTextField();
        BIn1.setBounds(10, 172, 250, 20);
        A.add(BIn1);
        JLabel C1 = new JLabel("ATTENDANCE");
        C1.setBounds(10, 205, 100, 10);
        A.add(C1);
        JTextField CIn1 = new JTextField();
        CIn1.setBounds(10, 222, 250, 20);
        A.add(CIn1);
        A.add(panel2);
        tab.setBackground(Color.WHITE);

        // Marks update Panel setup
        Up.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
              {
                String name = AIn.getText();
                String rn = BIn.getText();
                String m = CIn.getText();
                if(AIn.getText().isEmpty() || BIn.getText().isEmpty() || CIn.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Please fill all the boxes");
                else if(SubD.getSelectedItem() == "Maths"){
                    try{
                        // Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Students","Beta","1234"); //Connecting MySQL to java via JDBC API.
                        Statement stmt=con.createStatement();//Create a statement object to perform a query.
                        String query1;
                        if(DD.getSelectedItem()=="P1")
                            query1 = "UPDATE users SET Subject = ?, P1 = ? WHERE ID = ? && Subject = 'Maths';";
                        else if(DD.getSelectedItem()=="P2")
                            query1 = "UPDATE users SET Subject = ?, P2 = ? WHERE ID = ? && Subject = 'Maths';";
                        else
                            query1 = "UPDATE users SET Subject = ?, P3 = ? WHERE ID = ? && Subject = 'Maths';";
                        PreparedStatement preparedStmt = con.prepareStatement(query1);
                        preparedStmt.setString (1,SubD.getSelectedItem().toString());
                        preparedStmt.setString (2,m);
                        preparedStmt.setString (3,rn);
                        preparedStmt.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Successful Update"); 
                    }
                    catch(Exception e1){ System.out.println(e1);}
                }
                else if(SubD.getSelectedItem()== "DS"){
                    try{
                        // Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Students","Beta","1234"); //Connecting MySQL to java via JDBC API.
                        Statement stmt=con.createStatement();//Create a statement object to perform a query.
                        String query1;
                        if(DD.getSelectedItem()=="P1")
                            query1 = "UPDATE users SET Subject = ?, P1 = ? WHERE ID = ? && Subject = 'DS';";
                        else if(DD.getSelectedItem()=="P2")
                            query1 = "UPDATE users SET Subject = ?, P2 = ? WHERE ID = ? && Subject = 'DS';";
                        else
                            query1 = "UPDATE users SET Subject = ?, P3 = ? WHERE ID = ? && Subject = 'DS';";
                        PreparedStatement preparedStmt = con.prepareStatement(query1);
                        preparedStmt.setString (1,SubD.getSelectedItem().toString());
                        preparedStmt.setString (2,m);
                        preparedStmt.setString (3,rn);
                        preparedStmt.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Successful Update"); 
                    }
                    catch(Exception e1){ System.out.println(e1);}
                    
                }
                else{
                    try{
                        // Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Students","Beta","1234"); //Connecting MySQL to java via JDBC API.
                        Statement stmt=con.createStatement();//Create a statement object to perform a query.
                        String query1;
                        if(DD.getSelectedItem()=="P1")
                            query1 = "UPDATE users SET Subject = ?, P1 = ? WHERE ID = ? && Subject = 'Java';";
                        else if(DD.getSelectedItem()=="P2")
                            query1 = "UPDATE users SET Subject = ?, P2 = ? WHERE ID = ? && Subject = 'Java';";
                        else
                            query1 = "UPDATE users SET Subject = ?, P3 = ? WHERE ID = ? && Subject = 'Java';";
                        PreparedStatement preparedStmt = con.prepareStatement(query1);
                        preparedStmt.setString (1,SubD.getSelectedItem().toString());
                        preparedStmt.setString (2,m);
                        preparedStmt.setString (3,rn);
                        preparedStmt.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Successful Update"); 
                    }
                    catch(Exception e1){ System.out.println(e1);}
                }
                }
              }
            });
    
    // Personal panel
    //Personal Panel
    try{
        // Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Students","Beta","1234"); //Connecting MySQL to java via JDBC API.
        Statement stmt=con.createStatement();//Create a statement object to perform a query.
        
        // Method to Insert
        String query1 = "SELECT * from users WHERE ID = ? && Field = 'F'";
        PreparedStatement preparedStmt = con.prepareStatement(query1);
        preparedStmt.setString (1,ID);
        ResultSet resultSet = preparedStmt.executeQuery();
        if(resultSet.next()) {
          String Name = resultSet.getString(1);
          JLabel nm = new JLabel("User Name :");
          JLabel n = new JLabel(Name);
          JLabel rn = new JLabel("ID :");
          JLabel r = new JLabel(ID);
          nm.setBounds(5,50,100,20);
          n.setBounds(110,50,100,20);
          rn.setBounds(5,80,100,20);
          r.setBounds(110,80,100,20);
          P.add(nm);
          P.add(n);
          P.add(rn);
          P.add(r);
        }
        else
            JOptionPane.showMessageDialog(null, "Error");
        
    }
    catch(Exception e1){ System.out.println(e1);}
      P.setLayout(null);
      P.add(panel3);
      tab.setBackground(Color.WHITE); 
    }
}
