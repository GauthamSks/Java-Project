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

public class Student{
    public Student(){


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
        
        M.setLayout(null);
        tab.setBackground(Color.WHITE);
        
            

        // Grade panel

        G.setLayout(null);
        tab.setBackground(Color.WHITE);
       
        
        //Attendance Panel
        
        T.setLayout(null);
        
        tab.setBackground(Color.WHITE);
      
   }

       
    public static void main(String[] args) {
        Student S = new Student();
        
    }
}


