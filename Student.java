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
        Color o1 = new Color(255, 51, 51);
        J.setSize(900,600);
        J.setLayout(null);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        J.setLocationRelativeTo(null);
        J.setContentPane(new JLabel(new ImageIcon("BG.jpg")));
        J.setTitle("Student");
        JPanel M = new JPanel(); //Marks Panel
        JPanel G = new JPanel(); //Grade Panel
        JPanel T = new JPanel(); //Attendance
        UIManager.put("TabbedPane.selected", o1);
        UIManager.put("TabbedPane.contentOpaque", true);
        JTabbedPane tab=new JTabbedPane(); 
        tab.add("MARKS",M);
        tab.add("GRADE",G);
        tab.add("ATTENDANCE",T);
        tab.setBounds(60,140,1000,500);  
        J.add(tab);
        J.getContentPane().setBackground(o1);
        J.setVisible(true);

        //Marks Panel Design
        
        M.setLayout(null);
        String[] D = {"P1","P2","END SEM"};
        JComboBox DD = new JComboBox<>(D);
        DD.setBounds(135,50,100,20);
        M.add(DD);
        JLabel A = new JLabel("MATH");
        A.setBounds(10,100,100,10);
        M.add(A);
        JTextField AIn = new JTextField();
        AIn.setBounds(10,120,250,20);
        M.add(AIn);
        JLabel B = new JLabel("CORE");
        B.setBounds(10,155,100,10);
        M.add(B);
        JTextField BIn = new JTextField();
        BIn.setBounds(10,172,250,20);
        M.add(BIn);
        JLabel C = new JLabel("LAB");
        C.setBounds(10,195,100,10);
        M.add(C);
        JTextField CIn = new JTextField();
        CIn.setBounds(10,205,250,20);
        M.add(CIn);
        tab.setBackground(Color.GREEN);
        
            

        // Grade panel

        G.setLayout(null);
        JComboBox DD1 = new JComboBox<>(D);
        DD1.setBounds(135,50,100,20);
        G.add(DD1);
        JLabel X = new JLabel("MATH");
        X.setBounds(10,100,100,10);
        G.add(X);
        JTextField Xx = new JTextField();
        Xx.setBounds(10,120,250,20);
        G.add(Xx);
        JLabel Y = new JLabel("CORE");
        Y.setBounds(10,150,100,10);
        G.add(Y);
        JTextField Yy = new JTextField();
        Yy.setBounds(10,170,250,20);
        G.add(Yy);
        JLabel Z = new JLabel("LAB");
        Z.setBounds(10,195,100,10);
        G.add(Z);
        JTextField Zz = new JTextField();
        Zz.setBounds(10,205,250,20);
        G.add(Zz);
        tab.setBackground(Color.RED);
       
        
        //Attendance Panel
        
        T.setLayout(null);
        JComboBox DD2 = new JComboBox<>(D);
        DD2.setBounds(135,50,100,20);
        T.add(DD2);
        JLabel P = new JLabel("MATH");
        P.setBounds(10,100,100,10);
        T.add(P);
        JTextField PIn = new JTextField();
        PIn.setBounds(10,120,250,20);
        T.add(PIn);
        JLabel Q = new JLabel("CORE");
        Q.setBounds(10,140,100,10);
        T.add(Q);
        JTextField QIn = new JTextField();
        QIn.setBounds(10,160,250,20);
        T.add(QIn);
        JLabel R = new JLabel("LAB");
        R.setBounds(10,185,100,10);
        T.add(R);
        JTextField RIn = new JTextField();
        RIn.setBounds(10,205,250,20);
        T.add(RIn);
        tab.setBackground(Color.GREEN);
      
   }

       
    public static void main(String[] args) {
        Student S = new Student();
        
    }
}


