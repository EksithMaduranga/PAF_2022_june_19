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

import model.inquiry;

@Path("/inquiry")
public class InquiryService {
	inquiry inquiryObj = new inquiry();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readInquiry()
	 {
	 return inquiryObj.readInquiry();
	 }
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String insertInquiry(@FormParam("inquiryTitle") String inquiryTitle,
			 @FormParam("inquiryDesc") String inquiryDesc,
			 @FormParam("inquiryPayNo") String inquiryPayNo,
			 @FormParam("inquiryAddr") String inquiryAddr,
			 @FormParam("inquiryConNo") String inquiryConNo)
			{ 
		String output = inquiryObj.insertInquiry(inquiryTitle, inquiryDesc, inquiryPayNo, inquiryAddr,inquiryConNo);
		return output;
			}
	
	
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateInquiry(String inquiryData)
	{
		//Convert the input string to a JSON object
		 JsonObject inquiryObject = new JsonParser().parse(inquiryData).getAsJsonObject();
		//Read the values from the JSON object
			 String inquiryID = inquiryObject.get("inquiryID").getAsString();
			 String inquiryTitle = inquiryObject.get("inquiryTitle").getAsString();
			 String inquiryDesc = inquiryObject.get("inquiryDesc").getAsString();
			 String inquiryPayNo = inquiryObject.get("inquiryPayNo").getAsString();
			 String inquiryAddr = inquiryObject.get("inquiryAddr").getAsString();
			 String inquiryConNo = inquiryObject.get("inquiryConNo").getAsString();
			 String output = inquiryObj.updateInquiry(inquiryID, inquiryTitle, inquiryDesc, inquiryPayNo, inquiryAddr, inquiryConNo);
		return output;
	}
	
	
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteInquiry(String inquiryData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(inquiryData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String inquiryID = doc.select("inquiryID").text();
	 String output = inquiryObj.deleteInquiry(inquiryID);
	return output;
	}



	

}
