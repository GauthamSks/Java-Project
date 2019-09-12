import java.awt.Color;

import javax.swing.*;
public class Login{
    public static void main(String[] args) {
        JFrame J = new JFrame();
        J.setSize(390,530);
        J.setLayout(null);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        J.setLocationRelativeTo(null);
        J.setTitle("Login");
        JPanel Sin = new JPanel(); //Sign in Panel
        JPanel Sup = new JPanel(); //Sign up Panel
        JTabbedPane tab=new JTabbedPane(); 
        tab.add("Sign In",Sin);
        tab.add("Create an Account",Sup);
        tab.setBounds(0,40,390,490);  
        J.add(tab);
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
        Color o = new Color(255,133,26);
        Lin.setBackground(o);
        Sin.add(Lin);

        //SignUp Panel Design
    }
}
