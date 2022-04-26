package model;

import java.sql.*;

public class UserModel {
	
	//java method to connect to the DB
		private Connection connect() 
		{ 
				 Connection con = null; 
				 try
				 { 
					 Class.forName("com.mysql.jdbc.Driver"); 
					 
					 //DBServer/DBName, username, password 
					 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clients", "root", ""); 
				 } 
				 catch (Exception e) 
				 {e.printStackTrace();} 
				 return con; 
		} 
		
		
		//create new connection
		
		public String createClient(String Name, String Address, String phoneNo, String nic, String zone) 
		{ 
				 String output = ""; 
				 try
				 { 
					 Connection con = connect(); 
					 
					 if (con == null) 
					 {return "Error while connecting to the database for inserting."; } 
					 
					 // create a prepared statement
					 String query = "insert into users (`connectionNo`,`clientName`,`clientAddress`,`phoneNo`,`nic`,`zone`)" + " values (?, ?, ?, ?, ?,?)"; 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 
					 // binding values
					 preparedStmt.setInt(1, 0); 
					 preparedStmt.setString(2, Name); 
					 preparedStmt.setString(3, Address);
					 preparedStmt.setInt(4, Integer.parseInt(phoneNo)); 
					 preparedStmt.setString(5, nic);
					 preparedStmt.setString(6, zone);
			
					 
					 // execute the statement
					 
					 preparedStmt.execute(); 
					 con.close(); 
					 output = "Inserted successfully"; 
				 } 
				 catch (Exception e) 
				 { 
					 output = "Error while inserting the item."; 
					 System.err.println(e.getMessage()); 
				 } 
				 return output; 
		} 
		
		//view all clients
		
		public String readClients() 
		{ 
					 String output = ""; 
					 try
					 { 
						 Connection con = connect(); 
						 if (con == null) 
						 {return "Error while connecting to the database for reading."; } 
						 
						 // Prepare the html table to be displayed
						 output = "<table border='1'><tr><th>connectionNo</th><th>clientName</th>" +
						 "<th>clientAddress</th>" + 
						 "<th>phoneNo</th>" +
						 "<th>nic</th>" +
						 "<th>zone</th>" +
						 "<th>Update</th><th>Remove</th></tr>"; 
						 
						 String query = "select * from users"; 
						 Statement stmt = con.createStatement(); 
						 ResultSet rs = stmt.executeQuery(query);
						 
						 // iterate through the rows in the result set
						 while (rs.next()) 
						 { 
								 String connectionNo= Integer.toString(rs.getInt("connectionNo")); 
								 String clientName = rs.getString("clientName"); 
								 String clientAddress = rs.getString("clientAddress");
								 String phoneNo = rs.getString("phoneNo");
								 String nic = rs.getString("nic");
								 String zone = rs.getString("zone"); 
								 
								 // Add into the html table
								 output += "<tr><td>" + connectionNo + "</td>"; 
								 output += "<td>" + clientName + "</td>"; 
								 output += "<td>" + clientAddress + "</td>"; 
								 output += "<td>" + phoneNo + "</td>";
								 output += "<td>" + nic + "</td>";
								 output += "<td>" + zone + "</td>";
								 // buttons
								 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
								 + "<td><form method='post' action='items.jsp'>"
								 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
								 + "<input name='itemID' type='hidden' value='" + connectionNo 
								 + "'>" + "</form></td></tr>"; 
						 } 
						 con.close(); 
						 // Complete the html table
						 output += "</table>"; 
					 } 
					 catch (Exception e) 
					 { 
						 output = "Error while reading the items."; 
						 System.err.println(e.getMessage()); 
					 } 
					 return output; 
		}
		
		//Update Client Details
		
		public String updateClient(String NO, String Name, String Address, String phoneNo, String nic, String zone) 
		 
		{ 
			 String output = ""; 
			 try
			 { 
				 Connection con = connect(); 
				 if (con == null) 
				 {return "Error while connecting to the database for updating."; } 
				 
				 // create a prepared statement
				 String query = "UPDATE users SET clientName=?,clientAddress=?,phoneNo=?,nic=?,zone=? WHERE connectionNo=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 
				 // binding values
				 preparedStmt.setString(1, Name); 
				 preparedStmt.setString(2, Address);
				 preparedStmt.setInt(3, Integer.parseInt(phoneNo)); 
				 preparedStmt.setString(4, nic);
				 preparedStmt.setString(5, zone); 
				 preparedStmt.setInt(6, Integer.parseInt(NO)); 
				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 output = "Updated successfully"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while updating the item."; 
				 System.err.println(e.getMessage()); 
			 } 
			 return output; 
		}
		
		//Delete a client
		
		public String deleteClient(String connectionNo) 
		{ 
			 String output = ""; 
			 try
			 { 
				 Connection con = connect(); 
				 if (con == null) 
				 {return "Error while connecting to the database for deleting."; } 
				 
				 // create a prepared statement
				 String query = "delete from users where connectionNo=?"; 
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 
				 // binding values
				 preparedStmt.setInt(1, Integer.parseInt(connectionNo)); 
				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 
				 output = "Deleted successfully"; 
			 } 
			 catch (Exception e) 
			 { 
				 output = "Error while deleting the item."; 
				 System.err.println(e.getMessage()); 
			 } 
			 return output; 
		} 
		
		
		

}
