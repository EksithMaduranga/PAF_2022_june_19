package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class inquiry {
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 
	 //Connection method
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inquirydb", "root", "eksith1234");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 }
	
	
	
	//insert
	public String insertInquiry(String title, String desc, String payNo, String addr, String conNo)
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
	 String query = " insert into inquiry(`inquiryID`,`inquiryTitle`,`inquiryDesc`,`inquiryPayNo`,`inquiryAddr`,`inquiryConNo`)"
				 + " values (?, ?, ?, ?, ?, ?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, title);
	 preparedStmt.setString(3, desc);
	 preparedStmt.setString(4, payNo);
	 preparedStmt.setString(5, addr);
	 preparedStmt.setString(6, conNo);
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
	
	
	
	
	public String readInquiry()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 // Prepare the html table to be displayed
	 
	
	 output = "<table border='1'><tr><th>Inquiry Title</th><th>Inquiry Description</th>" +
	 "<th>Inquiry Payment No</th>" +
	 "<th>Address</th>" +
	 "<th>Inquiry Contact No</th>" +
	 "<th>Update</th><th>Remove</th></tr>";

	
	 String query = "select * from inquiry";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
		 
		
	 String inquiryID = Integer.toString(rs.getInt("inquiryID"));
	 String inquiryTitle = rs.getString("inquiryTitle");
	 String inquiryDesc = rs.getString("inquiryDesc");
	 String inquiryPayNo = rs.getString("inquiryPayNo");
	 String inquiryAddr = rs.getString("inquiryAddr");
	 String inquiryConNo = rs.getString("inquiryConNo");
	 // Add into the html table
	 output += "<tr><td>" + inquiryTitle + "</td>";
	 output += "<td>" + inquiryDesc + "</td>";
	 output += "<td>" + inquiryPayNo + "</td>";
	 output += "<td>" + inquiryAddr + "</td>";
	 output += "<td>" + inquiryConNo + "</td>";
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='inquiry.jsp'>"+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
	 + "<input name='inquiryID' type='hidden' value='" + inquiryID
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
	
	public String updateInquiry(String ID, String title, String desc, String payNo, String addr, String conNo)
	{
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for updating."; }
		 // create a prepared statement
		
		 String query = "UPDATE inquiry SET inquiryTitle=?,inquiryDesc=?,inquiryPayNo=?,inquiryAddr=?, inquiryConNo=? WHERE inquiryID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setString(1, title);
		 preparedStmt.setString(2, desc);
		 preparedStmt.setString(3, payNo);
		 preparedStmt.setString(4, addr);
		 preparedStmt.setString(5, conNo);
		 preparedStmt.setInt(6, Integer.parseInt(ID));
		
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
		public String deleteInquiry(String inquiryID)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for deleting."; }
		 // create a prepared statement
		 String query = "delete from inquiry where inquiryID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(inquiryID));
		 
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
