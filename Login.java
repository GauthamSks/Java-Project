import java.awt.Color;

import javax.swing.*;
public class Login{
    public Login(){

        JFrame J = new JFrame();
        Color o1 = new Color(232, 91, 9);
        Color o2 = new Color(255,133,26);
        Color o3 = new Color(80, 86, 87);
        J.setSize(390,530);
        J.setLayout(null);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        J.setLocationRelativeTo(null);
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
        Sin.setBackground(o3);
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
        Lin.setBackground(Color.BLUE);
        Sin.add(Lin);
        tab.setBackground(o2);
    }
    public static void main(String[] args) {
        Login l = new Login();
    }
}
