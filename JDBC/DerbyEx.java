package derbyex;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyEx 
{

	public static void main(String[] args) 
	{
		String url = "jdbc:h2:tcp://localhost/~/test";
		String username = "sa";
		String password = "";
		String q = "select * from student";// SQl DQL syntax
										   // Connection con1= DriverManager.getConnection("jdbc:h2:tcp://localhost//Cloudscape/test","sa","");
		try (Connection con = DriverManager.getConnection(url, username, password);//creating
                                                                                  //creating the connection object con with url, username and password.
				Statement stmt = con.createStatement();// we are creating statement class object which will
													// use the con object and execute the query in the database
				ResultSet rs = stmt.executeQuery(q))
				{
					while (rs.next()) 
					{// act has the cursor
						String first = rs.getString(1);// first column
						String second = rs.getString(2);// second column
					 // String fourth = rs.getString(3);// third column

						System.out.println(first + " " + second+ " " );
					} // end of while
				} 
		
				catch (SQLException ex) 
				{

					System.out.println("SQLState: " + ex.getSQLState());// pre-defined
					System.out.println("Error Code:" + ex.getErrorCode());// pre-defined
					System.out.println("Message: " + ex.getMessage());// pre-defined
				}

	}
}
