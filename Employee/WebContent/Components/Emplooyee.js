/*$(document).ready(function() 
{ 
if ($("#alertSuccess").text().trim() == "") 
 { 
 $("#alertSuccess").hide(); 
 } 
 $("#alertError").hide(); 
}); */
// SAVE 
function onEmplooyeeSaveComplete(response, status) 
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully saved."); 
 $("#alertSuccess").show(); 
 $("#divEmplooyeesGrid").html(resultSet.data); 
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
 
 $("#hidEmplooyeeIDSave").val(""); 
 $("#formEmplooyee")[0].reset(); 
}

$(document).on("click", "#btnSave", function(event) 
{ 
// Clear alerts---------------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
// Form validation-------------------
var status = validateEmplooyeeForm(); 
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
// If valid------------------------
var type = ($("#hidEmplooyeeIDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "emplooyeeAPI", 
 type : type, 
 data : $("#formEmplooyee").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onEmplooyeeSaveComplete(response.responseText, status); 
 } 
 }); 
}); 
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) 
{ 
 $("#hidEmplooyeeIDSave").val($(this).data("Emplooyeeid")); 

 $("#emplooyeeName").val($(this).closest("tr").find('td:eq(0)').text()); 
 $("#emplooyeeAddr").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#emplooyeeNic").val($(this).closest("tr").find('td:eq(2)').text()); 
 $("#emplooyeeAge").val($(this).closest("tr").find('td:eq(3)').text()); 
 $("#emplooyeePhoneNo").val($(this).closest("tr").find('td:eq(4)').text());
 $("#emplooyeeEmail").val($(this).closest("tr").find('td:eq(3)').text());  
}); 

$(document).on("click", ".btnRemove", function(event) 
{ 
 $.ajax( 
 { 
 url : "emplooyeeAPI", 
 type : "DELETE", 
 data : "emplooyeeID=" + $(this).data("Emplooyeeid"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onEmplooyeeDeleteComplete(response.responseText, status); 
 } 
 }); 
});
function onEmplooyeeDeleteComplete(response, status) 
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divEmplooyeesGrid").html(resultSet.data); 
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
function validateEmplooyeeForm() 
{ 
// CODE
if ($("#emplooyeeName").val().trim() == "") 
 { 
 return "Insert Name."; 
 } 
// NAME
if ($("#emplooyeeAddr").val().trim() == "") 
 { 
 return "Insert Address."; 
 } 
 
// PRICE-------------------------------
if ($("#emplooyeeNic").val().trim() == "") 
 { 
 return "Insert NIC."; 
 } 
 
// DESCRIPTION------------------------
if ($("#emplooyeeAge").val().trim() == "") 
 { 
 return "Insert Age."; 
 } 
if ($("#emplooyeePhoneNo").val().trim() == "") 
 { 
 return "Insert Contact no."; 
 } 
 if ($("#emplooyeeEmail").val().trim() == "") 
 { 
 return "Insert Email."; 
 }
return true; 
}