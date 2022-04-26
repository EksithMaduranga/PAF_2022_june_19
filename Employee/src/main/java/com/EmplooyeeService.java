package com;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import demo.Emplooyee;

@Path("/emplooyee")

public class EmplooyeeService {Emplooyee emplooyeeObj = new Emplooyee();
@GET
@Path("/")
@Produces(MediaType.TEXT_HTML)
public String readEmplooyee()
 {
 return emplooyeeObj.readEmplooyee();
 }

@POST
@Path("/") 
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)

public String insertEmplooyee
		 (@FormParam("emplooyeeName") String emplooyeeName,
		 @FormParam("emplooyeeAddr") String emplooyeeAddr,
		 @FormParam("emplooyeeNic") String emplooyeeNic,
		 @FormParam("emplooyeeAge") String emplooyeeAge,
		 @FormParam("emplooyeePhoneNo") String emplooyeePhoneNo,
		 @FormParam("emplooyeeEmail") String emplooyeeEmail)



		{ 
	String output = emplooyeeObj.insertEmplooyee(emplooyeeName, emplooyeeAddr, emplooyeeNic, emplooyeeAge,emplooyeePhoneNo,emplooyeeEmail);
	return output;
		}




@PUT
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public String updateEmplooyee(String emplooyeeData)
{
	//Convert the input string to a JSON object
	 JsonObject emplooyeeObject = new JsonParser().parse(emplooyeeData).getAsJsonObject();
	//Read the values from the JSON object
		 String emplooyeeID = emplooyeeObject.get("emplooyeeID").getAsString();
		 String emplooyeeName = emplooyeeObject.get("emplooyeeName").getAsString();
		 String emplooyeeAddr = emplooyeeObject.get("emplooyeeAddr").getAsString();
		 String emplooyeeNic = emplooyeeObject.get("emplooyeeNic").getAsString();
		 String emplooyeeAge = emplooyeeObject.get("emplooyeeAge").getAsString();
		 String emplooyeePhoneNo = emplooyeeObject.get("emplooyeePhoneNo").getAsString();
		 String emplooyeeEmail = emplooyeeObject.get("emplooyeeEmail").getAsString();
		 
		 //update
		 String output = emplooyeeObject.updateEmplooyee(emplooyeeID, 
				 emplooyeeName, emplooyeeAddr, emplooyeeNic, emplooyeeAge, 
				 emplooyeePhoneNo, emplooyeeEmail);
		 
	return output;
}




@DELETE
@Path("/")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.TEXT_PLAIN)
public String deleteEmplooyee(String emplooyeeData)
{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(emplooyeeData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
		 String emplooyeeID = doc.select("emplooyeeID").text();
		 String output = emplooyeeObj.deleteEmplooyee(emplooyeeID);
	return output;
}





}