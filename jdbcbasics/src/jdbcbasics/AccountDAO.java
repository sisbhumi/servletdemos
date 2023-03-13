package jdbcbasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {
	public static void main(String args[]) {
		
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root" , "root");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from account");
			) {
			
			while(rs.next()) {
				int accno = rs.getInt(1);
				String lastname = rs.getString(2);
				String firstname = rs.getString(3);
				int balance = rs.getInt(4);
				System.out.println(accno +"|"+ lastname+"|"+firstname+"|"+balance);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
