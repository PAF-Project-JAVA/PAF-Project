package com;

import model.Payment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Payment")
public class PaymentManagement {
	Payment PaymentObj = new Payment();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPayment() {
		return PaymentObj.readPayment();
	}

	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment(
		@FormParam("Pay_customer_ame") String Pay_customer_ame,
		@FormParam("Pay_acc") String Pay_acc,
		@FormParam("Pay_date") String Pay_date,
		@FormParam("Pay_total_price") String Pay_total_price) {
		String output = PaymentObj.insertPayment(Pay_customer_ame, Pay_acc, Pay_date, Pay_total_price);
		return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String updatePayment(String paymentData) {
		// Convert the input string of payment details to a JSON object 
		JsonObject PaymentMObject = new JsonParser().parse(paymentData).getAsJsonObject();
		// Read the values from the JSON object
		String pay_id = PaymentMObject.get("pay_id").getAsString();
		String Pay_customer_ame = PaymentMObject.get("Pay_customer_ame").getAsString();
		String Pay_acc = PaymentMObject.get("Pay_acc").getAsString();
		String Pay_date = PaymentMObject.get("Pay_date").getAsString();
		String Pay_total_price = PaymentMObject.get("Pay_total_price").getAsString();	
		String output = PaymentObj.updatePayment(pay_id, Pay_customer_ame, Pay_acc, Pay_date, Pay_total_price);
		return output;
	}
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayment(String paymentData) {
		// Convert the input string payment details to an XML document
		Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser());

		// Read the payment detail values from the element
		String pay_id = doc.select("pay_id").text();
		String output = PaymentObj.deletePayment(pay_id);
		return output;
		
	}
}
