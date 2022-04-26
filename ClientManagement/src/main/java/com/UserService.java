package com;

//Importing REST API Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//Importing JSON
import com.google.gson.*;

import model.UserModel;

//Importing XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;



@Path("/Clients")
public class UserService {
	
	//creating client object	
	UserModel clientOb = new UserModel(); 
	
	
	//get all the registered clients
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readClients() 
	{ 	
	 
		return clientOb.readClients();
	}
	
	
	
	//add new client	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String createClient(
		 @FormParam("clientName") String clientName, 
		 @FormParam("clientAddress") String clientAddress, 
		 @FormParam("phoneNo") String phoneNo, 
		 @FormParam("nic") String nic,
	 	 @FormParam("zone") String zone) 
	{ 
		 String output = clientOb.createClient(clientName, clientAddress, phoneNo, nic,zone); 
		 return output; 
	}
	
	
	//Update A Client Info
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateClient(String userData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject(); 
		 
		//Read the values from the JSON object
		 String connectionNo = userObject.get("connectionNo").getAsString(); 
		 String clientName = userObject.get("clientName").getAsString(); 
		 String clientAddress = userObject.get("clientAddress").getAsString(); 
		 String phoneNo = userObject.get("phoneNo").getAsString(); 
		 String nic = userObject.get("nic").getAsString(); 
		 String zone = userObject.get("zone").getAsString();
		 String output = clientOb.updateClient(connectionNo, clientName, clientAddress, phoneNo, nic, zone); 
		 
		return output; 
	}
	
	
	//Delete a selected client
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteClient(String userData) 
	{ 
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(userData, "", Parser.xmlParser()); 
		 
		//Read the value from the Connection number 
		 String connectionNo = doc.select("connectionNo").text(); 
		 String output = clientOb.deleteClient(connectionNo); 
		return output; 
	}
	
	
	

}
