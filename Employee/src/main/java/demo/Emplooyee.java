package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Emplooyee {
	
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 
	 //Connection method
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/emplooyeedb", "root", "admin");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 }
	
	
	
	//insert
	public String insertEmplooyee(String name, String address, String nic, String age, String phoneno, String email)
	 {
	 String output = "";
	 try
	 {
		 Connection con = connect();
	 	 if (con == null)
	 {
		 return "Error while connecting to the database for inserting."; 
	 }
	 
	 	 
	 	 // create a prepared statement
	 
	 String query = " insert into emplooyee(`emplooyeeID`,`emplooyeeName`,`emplooyeeAddr`,`emplooyeeNic`,`emplooyeeAge`,`emplooyeePhoneNo`,`emplooyeeEmail`)"
				 + " values (?, ?, ?, ?, ?, ?, ?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, name);
	 preparedStmt.setString(3, address);
	 preparedStmt.setString(4, nic);
	 preparedStmt.setString(5, age);
	 preparedStmt.setString(6, phoneno);
	 preparedStmt.setString(7, email);
	 
	 // execute the statement

	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	 catch (Exception e)
	 {
		 //use for debug insert que
	 output = "Error while inserting the inquiry post.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
	
	//gg
	public String readEmplooyee()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 // Prepare the html table to be displayed
	 
	 //gg
	 output = "<table border='1'><tr><th>Emplooyee Name</th><th>Emplooyee Address</th>" +
	 "<th>Emplooyee NIC</th>" +
	 "<th>Emplooyee Age</th>" +
	 "<th>Emplooyee Phone No</th>" +
	 "<th>Emplooyee Email</th>" +
	 "<th>Update</th><th>Remove</th></tr>";

	 //gg
	 String query = "select * from emplooyee";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
		 
		 /* emplooyee(`emplooyeeID`,`emplooyeeName`,
		  * `emplooyeeAddr`,`emplooyeeNic`,`emplooyeeAge`,
		  * 'emplooyeePhoneNo','emplooyeeEmail')" */
		 
	 String emplooyeeID = Integer.toString(rs.getInt("emplooyeeID"));
	 String emplooyeeName = rs.getString("emplooyeeName");
	 String emplooyeeAddr = rs.getString("emplooyeeAddr");
	 String emplooyeeNic = rs.getString("emplooyeeNic");
	 String emplooyeeAge = rs.getString("emplooyeeAge");
	 String emplooyeePhoneNo = rs.getString("emplooyeePhoneNo");
	 String emplooyeeEmail = rs.getString("emplooyeeEmail");
	 // Add into the html table
	 output += "<tr><td>" + emplooyeeName + "</td>";
	 output += "<td>" + emplooyeeAddr + "</td>";
	 output += "<td>" + emplooyeeNic + "</td>";
	 output += "<td>" + emplooyeeAge + "</td>";
	 output += "<td>" + emplooyeePhoneNo + "</td>";
	 output += "<td>" + emplooyeeEmail + "</td>";
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='emplooyee.jsp'>"+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
	 + "<input name='inquiryID' type='hidden' value='" + emplooyeeID
	 + "'>" + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the inquiry.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	//Update function
	//(String name, String address, String nic, String age, String phoneno, String email
	public String updateEmplooyee(String ID, String name, String address, String nic, String age, String phoneno, String email)
	{
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for updating."; }
		 // create a prepared statement
		 //query
		 String query = "UPDATE emplooyee SET emplooyeeName=?,emplooyeeAddr=?,emplooyeeNic=?,"
		 		+ "emplooyeeAge=?, emplooyeePhoneNo=?, emplooyeeEmail=? WHERE emplooyeeID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setString(1, name);
		 preparedStmt.setString(2, address);
		 preparedStmt.setString(3, nic);
		 preparedStmt.setString(4, age);
		 preparedStmt.setString(5, phoneno);
		 preparedStmt.setString(6, email);
		 preparedStmt.setInt(7, Integer.parseInt(ID));
		 
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Updated successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while updating the inquiry.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
	
	
	
		//Delete function
		public String deleteEmplooyee(String emplooyeeID)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for deleting."; }
		 // create a prepared statement
		 String query = "delete from emplooyee where emplooyeeID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(emplooyeeID));
		 /*String inquiryID = Integer.toString(rs.getInt("inquiryID"));
		 String inquiryTitle = rs.getString("inquiryTitle");
		 String inquiryDesc = rs.getString("inquiryDesc");
		 String inquiryPayNo = rs.getString("inquiryPayNo");
		 String inquiryAddr = rs.getString("inquiryAddr");
		 String inquiryConNo = rs.getString("inquiryConNo");*/
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Deleted successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while deleting the Inauiry.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		
	
	

}
