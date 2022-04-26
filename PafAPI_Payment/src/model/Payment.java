package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Payment {

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

	public String insertPayment(String Pay_customer_ame, String Pay_acc, String Pay_date, String Pay_total_price) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into paymg(`pay_id`,`Pay_customer_ame`,`Pay_acc`,`Pay_date`,`Pay_total_price`)" 
			+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, Pay_customer_ame);
			preparedStmt.setString(3, Pay_acc);
			preparedStmt.setString(4, Pay_date);
			preparedStmt.setString(5, Pay_total_price);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the Payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readPayment() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Pay ID</th><th>Name</th><th>Electricity Account No</th><th>Pay Date</th><th>Total Price</th></tr>";
			String query = "select * from paymg";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String pay_id = Integer.toString(rs.getInt("pay_id"));
				String Pay_customer_ame = rs.getString("Pay_customer_ame");
				String Pay_acc = rs.getString("Pay_acc");
				String Pay_date = rs.getString("Pay_date");
				String Pay_total_price = rs.getString("Pay_total_price");

				output += "<tr><td>" + pay_id + "</td>";
				output += "<td>" + Pay_customer_ame + "</td>";
				output += "<td>" + Pay_acc + "</td>";
				output += "<td>" + Pay_date + "</td>";
				output += "<td>" + Pay_total_price + "</td>";
			}
			con.close();

			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the Payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updatePayment(String pay_id, String Pay_customer_ame, String Pay_acc, String Pay_date, String Pay_total_price) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE paymg SET Pay_customer_ame=?,Pay_acc=?,Pay_date=?,Pay_total_price=? WHERE pay_id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, Pay_customer_ame);
			preparedStmt.setString(2, Pay_acc);
			preparedStmt.setString(3, Pay_date);
			preparedStmt.setString(4, Pay_total_price);
			preparedStmt.setInt(5, Integer.parseInt(pay_id));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the Payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deletePayment(String pay_id) {

		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from paymg where pay_id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(pay_id));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the Payment.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
