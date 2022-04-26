package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import com.google.gson.*;


import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;


import model.Bill;

@Path("/Bill")
public class BillService {
	Bill BillingObj = new Bill();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readBilling() {
		return BillingObj.readBilling();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertBilling(@FormParam("B_date") String B_date,		
	 @FormParam("B_account") String B_account,
	 @FormParam("B_units") String B_units,
	 @FormParam("B_total") String B_total)
	{
	 String output = BillingObj.insertBilling(B_date, B_account, B_units, B_total);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateBilling(String billingData)
	{
	//Convert the input string to a JSON object
	 JsonObject billObject = new JsonParser().parse(billingData).getAsJsonObject();
	//Read the values from the JSON object
	 String Bid = billObject.get("Bid").getAsString();
	 String B_date = billObject.get("B_date").getAsString();
	 String B_account = billObject.get("B_account").getAsString();
	 String B_units = billObject.get("B_units").getAsString();
	 String B_total = billObject.get("B_total").getAsString();
	 String output = BillingObj.updateBilling(Bid, B_date, B_account, B_units, B_total);
	return output;
	} 
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBilling(String billingData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(billingData, "", Parser.xmlParser());

	//Read the value from the element 
	 String Bid = doc.select("Bid").text();
	 String output = BillingObj.deleteBilling(Bid);
	return output;
	}
}
