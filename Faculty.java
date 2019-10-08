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

public class Faculty {
    public Faculty() {

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

        // Personal Panel

    }

    // public static void main(String[] args) {
    //     Faculty F = new Faculty();

    // }
}

// class ImagePanel extends JPanel {

//     private Image img;
//     public ImagePanel(String img) {
//       this(new ImageIcon(img).getImage());
//     }
  
//     public ImagePanel(Image img) {
//       this.img = img;
//       Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
//       setPreferredSize(size);
//       setMinimumSize(size);
//       setMaximumSize(size);
//       setSize(size);
//       setLayout(null);
//     }
  
//     public void paintComponent(Graphics g) {
//       g.drawImage(img, 0, 0, null);
//     }
  
//   }