import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.*;
import java.sql.*;

public class Student{
    public Student(String ID){
        
        int[] a = new int[9];
        int idx=0;
        try{
        String[] q2={"SELECT * from users WHERE ID = ? and Subject = 'Maths'",
                     "SELECT * from users WHERE ID = ? and Subject = 'DS'",
                     "SELECT * from users WHERE ID = ? and Subject = 'Java'"};
        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Students","Beta","1234");
        Statement stmt=con.createStatement();
          for(int i=0;i<q2.length;i++){
            PreparedStatement preparedStmt1 = con.prepareStatement(q2[i]);
            preparedStmt1.setString (1,ID);
            ResultSet rs = preparedStmt1.executeQuery();
            if(rs.next()){
              for(int k=4;k<7;k++)
                {a[idx]=rs.getInt(k);
                idx=idx+1;
                }
            }
          }
        }
        catch(Exception e){System.out.println(e);}

        JFrame J = new JFrame();
        Color o1 = new Color(3, 165, 252);
        J.setSize(900,600);
        J.setLayout(null);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        J.setLocationRelativeTo(null);
        J.setContentPane(new JLabel(new ImageIcon("FBG.jpg")));
        J.setTitle("Student");
        JPanel M = new JPanel(); //Marks Panel
        JPanel G = new JPanel(); //Grade Panel
        JPanel T = new JPanel(); //Attendance
        UIManager.put("TabbedPane.selected", o1);
        UIManager.put("TabbedPane.contentOpaque", true);
        JTabbedPane tab=new JTabbedPane(); 
        tab.add("GRADES",M);
        tab.add("PERFORMANCE ANALYSER",G);
        tab.add("PERSONAL",T);
        tab.setBounds(60,140,1000,500);  
        J.add(tab);
        J.getContentPane().setBackground(o1);
        J.setVisible(true);
        ImagePanel panel1 = new ImagePanel(new ImageIcon("FBG5.jpg").getImage());
        ImagePanel panel2 = new ImagePanel(new ImageIcon("FBG5.jpg").getImage());
        ImagePanel panel3 = new ImagePanel(new ImageIcon("FBG5.jpg").getImage());
        

        //Marks Panel Design
        
        String[] columns = new String[] {
            "Id", "Name", "Hourly Rate", "Part Time"
        };
        JLabel c = new JLabel("Course");
        JLabel p1 = new JLabel("P1");
        JLabel p2 = new JLabel("P2");
        JLabel p3 = new JLabel("End_SEM");
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {"Maths",a[0],a[1],a[2] },
            {"Ds",a[3],a[4],a[5]},
            {"Java",a[6],a[7],a[8] },
        };
        //create table with data
        JTable table = new JTable(data, columns);
        c.setBounds(195,80,50,10);
        M.add(c);
        p1.setBounds(340,80,50,10);
        M.add(p1);
        p2.setBounds(470,80,50,10);
        M.add(p2);
        p3.setBounds(575,80,80,10);
        M.add(p3);
        table.setBounds(165,100,500,48);
        table.setBackground(o1);
        M.add(table);  
        M.add(panel1);
        M.setLayout(null);
        tab.setBackground(Color.WHITE);
        
            

        // Grade panel

        G.setLayout(null);
        G.add(panel2);
        tab.setBackground(Color.WHITE);
       
        
        //Attendance Panel
        
        T.setLayout(null);
        T.add(panel3);
        tab.setBackground(Color.WHITE);    
   }
}


