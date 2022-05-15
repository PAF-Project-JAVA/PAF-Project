$(document).on("click", "#btnSave", function(event)
{ 
// Clear alerts---------------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
 
// Form validation-------------------
var status = validateUserForm(); 
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
// If valid------------------------
var type = ($("#hidUserIDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "UsersApi", 
 type : type, 
 data : $("#formUser").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onUserSaveComplete(response.responseText, status); 
 } 
 }); 
});

function onUserSaveComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully saved."); 
 $("#alertSuccess").show(); 
 $("#divItemsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while saving."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while saving.."); 
 $("#alertError").show(); 
 }
$("#hidUserIDSave").val(""); 
$("#formUser")[0].reset(); 
}


// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
		{ 
		$("#hidUserIDSave").val($(this).data("uID")); 
		 $("#uName").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#uAddress").val($(this).closest("tr").find('td:eq(2)').text()); 
		 $("#uEmail").val($(this).closest("tr").find('td:eq(3)').text()); 
		 $("#uNIC").val($(this).closest("tr").find('td:eq(4)').text());
		 $("#uPhoneNo").val($(this).closest("tr").find('td:eq(5)').text());
		});




$(document).on("click", ".btnRemove", function(event)
		{ 
		 $.ajax( 
		 { 
		 url : "UsersAPI", 
		 type : "DELETE", 
		 data : "uID=" + $(this).data("uID"),
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 onUserDeleteComplete(response.responseText, status); 
		 } 
		 }); 
		});
		
function onUserDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divItemsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while deleting."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while deleting.."); 
 $("#alertError").show(); 
 } 
}


// CLIENT-MODEL================================================================
function validateUserForm()
{
	// NAME
	if ($("#uName").val().trim() == "")
	{
	return "Insert User Name.";
	}
	// Address
	if ($("#uAddress").val().trim() == "")
	{
	return "Insert User Address.";
    }

    // EMAIL
    if ($("#uEmail").val().trim() == "")
   {
	return "Insert User Email.";
    }
	
   // NIC
    if ($("#uNIC").val().trim() == ""){
	return "Insert User NIC.";
    }
   // Phone
    if ($("#uPhoneNo").val().trim() == ""){
	return "Insert User Phone.";
    }
	// is numerical value
	var uphone = $("#uPhoneNo").val().trim();
	if (!$.isNumeric(uphone))
		{
		return "Insert a numerical value for Phone.";
		}
	
	return true;
}