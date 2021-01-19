import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
  public static void main (String[] args)
  {
    System.out.println("nn***** MySQL JDBC Connection Testing *****");
    Connection conn = null;
    try
    {
      Class.forName("com.mysql.jdbc.Driver").newInstance();

      conn = conn = DriverManager.getConnection("jdbc:mysql://localhost/project?"
        + "user=root&password=");
      System.out.println ("Database Connection Established...");
    }
    catch (Exception ex)
    {
      System.err.println ("Cannot connect to database server");
      ex.printStackTrace();
    }
    finally
    {
      if (conn != null)
      {
        try
        {
          System.out.println("n***** Let terminate the Connection *****");
          conn.close ();
          System.out.println ("Database connection terminated... ");
        }
        catch (Exception ex)
        {
          System.out.println ("Error in connection termination!");
        }
      }
    }
  }
}
