package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;


public class admin2 {
	static Connection connect() throws Exception
    {
       Class.forName("com.mysql.jdbc.Driver");
       return DriverManager.getConnection("jdbc:mysql://localhost:3306/complain1","root","");
    }
	public static String addblog(String title, String msag)
    {
      try
      {
         CallableStatement cs = connect().prepareCall("{call addblog(?,?,?)}");
         
         cs.setString(1, title);
         cs.setString(2, msag);
         cs.registerOutParameter(3, Types.VARCHAR); 
         cs.execute();
         return cs.getString(3); // return out mode parameter value.
          
      }catch(Exception ex) { return  ex.toString(); }
    }
	 public static ResultSet listblog() throws Exception
	    {
	       return connect().prepareCall("{call listblog()}").executeQuery();
	    }

	   public static String delblog(String bid)
	    {
	      try
	      {
	         CallableStatement cs = connect().prepareCall("{call delblog(?)}");
	         
	         cs.setString(1, bid);
	         cs.execute();
	         return "Blog Deleted."; // return out mode parameter value.
	      }catch(Exception ex) { return  ex.toString(); }
	    }
}
