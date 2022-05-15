/*
package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.User;

@Path("/User")
public class UserService {
	User UserObj = new User();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readUser() {
		return UserObj.readUser();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUser(@FormParam("uName") String uName,			
	 @FormParam("uAddress") String uAddress,
	 @FormParam("uEmail") String uEmail,
	 @FormParam("uNIC") String uNIC,
	 @FormParam("uPhoneNo") String uPhoneNo)
	{
	 String output = UserObj.insertUser(uName, uAddress, uEmail, uNIC, uPhoneNo);
	return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUser(String userData)
	{

	 JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
	//Read the values from the JSON object
	 String uID = userObject.get("uID").getAsString();
	 String uName = userObject.get("uName").getAsString();
	 String uAddress = userObject.get("uAddress").getAsString();
	 String uEmail = userObject.get("uEmail").getAsString();
	 String uNIC = userObject.get("uNIC").getAsString();
	 String uPhoneNo = userObject.get("uPhoneNo").getAsString();
	 
	 String output = UserObj.updateUser(uID, uName, uAddress, uEmail, uNIC, uPhoneNo);
	return output;
	} 
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(String userData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(userData, "", Parser.xmlParser());

	 String uID = doc.select("uID").text();
	 String output = UserObj.deleteUser(uID);
	return output;
	}
	
}
*/