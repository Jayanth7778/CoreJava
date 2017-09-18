package derbyex;

//JDBC Demo1
import java.sql.*;
public class JDBCDemo
{

	public static void main(String[] args)
	{
		String dburl="jdbc:h2:tcp://localhost/~/test";
		String user="sa";
		String pass="";
		String updateQ="update student set name='Abdul' where age=13";
		String q="select * from student";
		try
		{
			Connection con= DriverManager.getConnection(dburl,user,pass);
			Statement stmt = con.createStatement();

			int count= stmt.executeUpdate(updateQ);
			System.out.println(count +" rows updated");
			ResultSet rs = stmt.executeQuery(q);
			while(rs.next())
			{
				String col1= rs.getString(1);
				String col2= rs.getString(2);
				System.out.println(col1+ " "+ col2);
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.getSQLState());
			System.out.println(e.getErrorCode());
		}


	}

}