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
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset; 

public class Student{
	int [] mar = new int[9];
	int[] a;
	int c1=0;
    public Student(String ID){
        
        a = new int[9];
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

        // Log Out Button
        JButton LO = new JButton("Log-Out");
        LO.setBackground(o1);
        LO.setBounds(750,10,130,25);
        J.add(LO);
        LO.addActionListener(new ActionListener(){
        
          @Override
          public void actionPerformed(ActionEvent e) {
            J.dispose();
            Login L = new Login();

          }
        });
        

        //Marks Panel Design
        String gS=GradeCal(a[0], a[1], a[2]);
        String[] columns = new String[] {
            "Id", "Name", "Hourly Rate", "Part Time","Grade"
        };
        String Gm = GradeCal(a[0], a[1], a[2]);
        String Gd = GradeCal(a[3], a[4], a[5]);
        String Gj = GradeCal(a[6], a[7], a[8]);
        JLabel c = new JLabel("Course");
        JLabel p1 = new JLabel("P1");
        JLabel p2 = new JLabel("P2");
        JLabel p3 = new JLabel("End_SEM");
        JLabel G1 = new JLabel("Grade");
        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
            {"Maths",a[0],a[1],a[2],Gm},
            {"Ds",a[3],a[4],a[5],Gd},
            {"Java",a[6],a[7],a[8],Gj},
        };
        //create table with data
        JTable table = new JTable(data, columns);
        c.setBounds(195,80,50,10);
        M.add(c);
        p1.setBounds(300,80,50,10);
        M.add(p1);
        p2.setBounds(400,80,50,10);
        M.add(p2);
        p3.setBounds(480,80,80,10);
        M.add(p3);
        G1.setBounds(580,80,80,10);
        M.add(G1);
        table.setBounds(165,100,500,48);
        table.setBackground(Color.WHITE );
        M.add(table);  
        M.add(panel1);
        M.setLayout(null);
        tab.setBackground(Color.WHITE);
        
            

        // Performance Analyzer panel
        try{
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con1=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Students","Beta","1234"); //Connecting MySQL to java via JDBC API.
            Statement stmt2=con1.createStatement();//Create a statement object to perform a query.
            
            // Method to Insert
            String q5  = "SELECT max( P1 ) FROM users WHERE Subject = 'Maths'";
            String q51 = "SELECT max( P2 ) FROM users WHERE Subject = 'Maths'";
            String q52 = "SELECT max( P3 ) FROM users WHERE Subject = 'Maths'";
            String q6  = "SELECT max( P1 ) FROM users WHERE Subject = 'DS'";
            String q61 = "SELECT max( P2 ) FROM users WHERE Subject = 'DS'";
            String q62 = "SELECT max( P3 ) FROM users WHERE Subject = 'DS'";
            String q7  = "SELECT max( P3 ) FROM users WHERE Subject = 'Java'";
            String q71 = "SELECT max( P3 ) FROM users WHERE Subject = 'Java'";
            String q72 = "SELECT max( P3 ) FROM users WHERE Subject = 'Java'";
            
            getMaxMarks(q5);
            getMaxMarks(q51);
            getMaxMarks(q52);
            getMaxMarks(q6);
            getMaxMarks(q61);
            getMaxMarks(q62);
            getMaxMarks(q7);
            getMaxMarks(q71);
            getMaxMarks(q72);
                 
        }
        catch(Exception e3) {System.out.println(e3);}
        
 
        CategoryDataset dataset = createDataset(); 
	    //Create chart  
	    JFreeChart chart=ChartFactory.createBarChart(  
	        "Histogram", //Chart Title  
	        "Exams", // Category axis  
	        "Marks", // Value axis  
	        dataset,  
	        PlotOrientation.VERTICAL,  
	        true,true,false  
	       );
	    ChartPanel panel=new ChartPanel(chart);
	    panel.setSize(840,395);
	    G.add(panel); 
        G.setLayout(null);
//        G.add(panel2);
        tab.setBackground(Color.WHITE);
        
        
        
       
        
        //Personal Panel
        try{
          // Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Students","Beta","1234"); //Connecting MySQL to java via JDBC API.
          Statement stmt=con.createStatement();//Create a statement object to perform a query.
          
          // Method to Insert
          String query1 = "SELECT * from users WHERE ID = ? && Field = 'S'";
          PreparedStatement preparedStmt = con.prepareStatement(query1);
          preparedStmt.setString (1,ID);
          ResultSet resultSet = preparedStmt.executeQuery();
          if(resultSet.next()) {
            String Name = resultSet.getString(1);
            JLabel nm = new JLabel("User Name :");
            JLabel n = new JLabel(Name);
            JLabel rn = new JLabel("Roll No :");
            JLabel r = new JLabel(ID);
            nm.setBounds(5,50,100,20);
            n.setBounds(110,50,100,20);
            rn.setBounds(5,80,100,20);
            r.setBounds(110,80,100,20);
            T.add(nm);
            T.add(n);
            T.add(rn);
            T.add(r);
          }
          else
              JOptionPane.showMessageDialog(null, "Error");
          
          JLabel cp = new JLabel("Current Password");
          cp.setBounds(5,100,150,50);
          T.add(cp);
          JPasswordField cpf = new JPasswordField();
          cpf.setBounds(5,140,150,15);
          T.add(cpf);
          JLabel np = new JLabel("New Password");
          np.setBounds(5,145,150,50);
          T.add(np);
          JPasswordField npf = new JPasswordField();
          npf.setBounds(5,185,154,15);
          T.add(npf);
          
        JButton PU = new JButton("UPDATE");
        PU.setBackground(o1);
        PU.setBounds(5,220,130,25);
        T.add(PU);
        PU.addActionListener(new ActionListener(){
        
          @Override
          public void actionPerformed(ActionEvent e) {
            String Cpw = String.valueOf(cpf.getPassword());
            String New = String.valueOf(npf.getPassword());
            String q2= "SELECT * from users WHERE ID = ? and Password = ?";
            try{
              Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Students","Beta","1234"); //Connecting MySQL to java via JDBC API.
              Statement stmt=con.createStatement();//Create a statement object to perform a query.
              PreparedStatement preparedStmt = con.prepareStatement(q2);
              preparedStmt.setString (1,ID);
              preparedStmt.setString (2,Cpw);
              ResultSet resultSet = preparedStmt.executeQuery();
              if(resultSet.next()){
                String q3 = "UPDATE users SET Password = ? WHERE ID = ? ";
                PreparedStatement preparedStmt1 = con.prepareStatement(q3);
                preparedStmt1.setString (1,New);
                preparedStmt1.setString (2,ID);
                preparedStmt1.executeUpdate();      
                JOptionPane.showMessageDialog(null, "Successful Update"); 
              }
              else
                JOptionPane.showMessageDialog(null, "Invalid Current-Password"); 
            }
            catch(Exception e1){System.out.println(e1);}

          }
        });
      }
      catch(Exception e1){ System.out.println(e1);}
        T.setLayout(null);
        T.add(panel3);
        tab.setBackground(Color.WHITE);  
   }
   
    //Method to get marks
    void getMaxMarks(String q){
	   ResultSet rt = null;
	   try {
		  
		   Connection con1=DriverManager.getConnection( "jdbc:mysql://localhost:3306/Students","Beta","1234"); //Connecting MySQL to java via JDBC API.
           Statement stmt2=con1.createStatement();//Create a statement object to perform a query.
           PreparedStatement preparedStmt2 = con1.prepareStatement(q);
//           preparedStmt2.setString (1,S);
           rt = preparedStmt2.executeQuery();
           if(rt.next()) {
        	   mar[c1]=rt.getInt(1);
        	   c1+=1;
           	}
	   }
	   catch(Exception e) {System.out.println(e);
	   }
	   
   }
    
    //Method to create the dataset for the histogram
    private CategoryDataset createDataset() {  
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
	    dataset.addValue(a[0], "P1", "Maths");
	    dataset.addValue(mar[0], "P1_Max", "Maths"); 
	    dataset.addValue(a[1], "P2", "Maths");  
	    dataset.addValue(mar[1], "P2_MAx", "Maths");
	    dataset.addValue(a[2], "End_Sem", "Maths"); 
	    dataset.addValue(mar[2], "End_Sem_Max", "Maths");  
	    dataset.addValue(a[3], "P1", "DS");
	    dataset.addValue(mar[3], "P1_Max", "DS"); 
	    dataset.addValue(a[4], "P2", "DS");  
	    dataset.addValue(mar[4], "P2_MAx", "DS");
	    dataset.addValue(a[5], "End_Sem", "DS"); 
	    dataset.addValue(mar[5], "End_Sem_Max", "DS");
	    dataset.addValue(a[6], "P1", "Java");
	    dataset.addValue(mar[6], "P1_Max", "Java"); 
	    dataset.addValue(a[7], "P2", "Java");  
	    dataset.addValue(mar[7], "P2_MAx", "Java");
	    dataset.addValue(a[8], "End_Sem", "Java"); 
	    dataset.addValue(mar[8], "End_Sem_Max", "Java"); 
	    return dataset;  
	  }
    
    //Method to get the grade
    String GradeCal(int p1,int p2,int p3) {
    	double sum = (p1*0.5)+(p2*0.5)+(p3*0.5);
    	if(p1 == -1 || p2 == -1 || p3 ==  -1 )
    		return "-";
    	else if(sum>=95)//10
    		return "O";
    	else if (sum>=90)//9.5
    		return "A+";
    	else if (sum>=85)//9
    		return "A";
    	else if (sum>=80)//8
    		return "B+";
    	else if (sum>=75)//7
    		return "B";
    	else if (sum>=60 && sum <75)//6
    		return "C";
    	else if(sum>=45 && sum < 59)
    		return "P";
    	else
    		return "F";
    }
}


