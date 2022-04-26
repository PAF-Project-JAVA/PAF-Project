package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bill{

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

	
	public String insertBilling(String B_date, String B_account, String B_units, String B_total) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into billing(`Bid`,`B_date`,`B_account`,`B_units`,`B_total`)" + " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, B_date);
			preparedStmt.setString(3, B_account);
			preparedStmt.setString(4, B_units);
			preparedStmt.setString(5, B_total);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the billing.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readBilling() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Bill ID</th><th>Date</th><th>Account No</th><th>Units</th><th>Total Price</th></tr>";
			String query = "select * from billing";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String Bid = Integer.toString(rs.getInt("Bid"));
				String B_date = rs.getString("B_date");
				String B_account = rs.getString("B_account");
				String B_units = rs.getString("B_units");
				String B_total = rs.getString("B_total");
				

				// Add into the html table
				output += "<tr><td>" + Bid + "</td>";
				output += "<td>" + B_date + "</td>";
				output += "<td>" + B_account + "</td>";
				output += "<td>" + B_units + "</td>";
				output += "<td>" + B_total + "</td>";
				
				
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the billing.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateBilling(String Bid, String B_date, String B_account, String B_units, String B_total) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE billing SET B_date=?,B_account=?,B_units=?,B_total=?" + "WHERE Bid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, B_date);
			preparedStmt.setString(2, B_account);
			preparedStmt.setString(3, B_units);
			preparedStmt.setString(4, B_total);
			preparedStmt.setInt(5, Integer.parseInt(Bid));

			// execute the statement
			preparedStmt.execute();
			con.close();
			//bill details update success
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the billing.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deleteBilling(String Bid) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from billing where Bid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(Bid));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the billing.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
