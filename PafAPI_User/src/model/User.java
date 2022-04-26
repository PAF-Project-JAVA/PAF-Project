package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/apielectricity?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertUser(String uName, String uAddress, String uEmail, String uNIC, String uPhoneNo) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into usermg(`uID`,`uName`,`uAddress`,`uEmail`,`uNIC`,`uPhoneNo`)" + " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, uName);
			preparedStmt.setString(3, uAddress);
			preparedStmt.setString(4, uEmail);
			preparedStmt.setString(5, uNIC);
			preparedStmt.setString(6, uPhoneNo);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "User Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the user.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readUser() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>ID</th><th>User Name</th><th>Address</th><th>Email</th><th>NIC</th><th>Phone No</th></tr>";
			String query = "select * from usermg";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String uID = Integer.toString(rs.getInt("uID"));
				String uName = rs.getString("uName");
				String uAddress = rs.getString("uAddress");
				String uEmail = rs.getString("uEmail");
				String uNIC = rs.getString("uNIC");
				String uPhoneNo = rs.getString("uPhoneNo");
				
				// Add into the html table
				output += "<tr><td>" + uID + "</td>";
				output += "<td>" + uName + "</td>";
				output += "<td>" + uAddress + "</td>";
				output += "<td>" + uEmail + "</td>";
				output += "<td>" + uNIC + "</td>";
				output += "<td>" + uPhoneNo + "</td>";
				
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the user data.";
			System.err.println(e.getMessage());
		}
		return output;
	}
  //update user
	public String updateUser(String uID, String uName, String uAddress, String uEmail, String uNIC, String uPhoneNo) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE usermg SET uName=?,uAddress=?,uEmail=?,uNIC=?,uPhoneNo=?" + "WHERE uID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, uName);
			preparedStmt.setString(2, uAddress);
			preparedStmt.setString(3, uEmail);
			preparedStmt.setString(4, uNIC);
			preparedStmt.setString(5, uPhoneNo);
			preparedStmt.setInt(6, Integer.parseInt(uID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "User Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the user.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	//user delete
	public String deleteUser(String uID) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from usermg where uID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(uID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "User Details Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the user.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
