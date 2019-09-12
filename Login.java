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
        tab.setBounds(50,50,290,400);  
        J.add(tab);
        J.setVisible(true);
    }
}