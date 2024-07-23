package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import dto.Tasks;
import java.util.*;
public class DAO 
{
    private Connection con;
    public DAO()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded...");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gecdb","root","Hiran@999");
            System.out.println("Connected");
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public boolean addtodo(String email,String task,String startdate,String starttime,String enddate,String endtime)
    {
        boolean flag=false;
        try {
            PreparedStatement pstmt=con.prepareStatement("insert into tasks(email,task,startdate,starttime,enddate,endtime) values(?,?,?,?,?,?)");
            pstmt.setString(1, email);
            pstmt.setString(2,task);
            pstmt.setString(3,startdate);
            pstmt.setString(4,starttime);
            pstmt.setString(5,enddate);
            pstmt.setString(6, endtime);
            int r=pstmt.executeUpdate();
            if(r==1)
                flag=true;
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }
    
    public ArrayList<Tasks> getAllTasks()
    {
    	ArrayList<Tasks> tasksList=new ArrayList<Tasks>();
    	try {
    		Statement stmt=con.createStatement();
    		ResultSet rs= stmt.executeQuery("select * from tasks");
    		while(rs.next()) {
    			tasksList.add(new Tasks(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
    			
    		}
    	}
    	catch(Exception ex)
    	{
    		
    	}
    	return tasksList;
    }
    //i want to store the register form details in database
    public boolean doRegister(String email,String password,String phone,String address)
    {
        boolean flag=false;
        try {
            PreparedStatement pstmt=con.prepareStatement("insert into register(email,password,phone,address) values(?,?,?,?)");
            pstmt.setString(1,email);
            pstmt.setString(2,password);
            pstmt.setString(3,phone);
            pstmt.setString(4,address);
            int r=pstmt.executeUpdate();
            if(r==1)
                flag=true;
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return flag;
    }
    
    public String loginCheck(String email,String password)
    {
        String desig=null;
        try {
            PreparedStatement pstmt=con.prepareStatement("select * from register where email=? and password=?");
            pstmt.setString(1,email);
            pstmt.setString(2,password);
            ResultSet rs=pstmt.executeQuery();
            //
            //=> madhu@gmail.com | 123456   | 09912280626 | Vijayawada | user 
            if(rs.next())
            {
                desig=rs.getString("desig");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return desig;
    }
    
}