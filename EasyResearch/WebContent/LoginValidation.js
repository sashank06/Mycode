/**
 * 
 */
function chklogin()
{
	if((document.form1.username.value=="") || (document.form1.password.value=="")){
		if((document.form1.username.value=="") && (document.form1.password.value==""))
			alert("Enter username and password");
		else if(document.form1.username.value=="")
			alert("Enter username or password");
		else if(document.form1.password.value=="")
			alert("Enter password");
		
		return false;
	}
}

function chkContactParam(){
	if((document.addcontactform.AddContactFirstname.value=="") || (document.addcontactform.AddContactLastname.value=="") || (document.addcontactform.AddContactEmail.value=="")){
		if((document.addcontactform.AddContactFirstname.value=="") && (document.addcontactform.AddContactLastname.value=="") && (document.addcontactform.AddContactEmail.value==""))
			alert("Enter Name and Email Details");
		else if(document.addcontactform.AddContactFirstname.value=="" && document.addcontactform.AddContactLastname.value=="")
			alert("Enter First Name and Last Name");
		else if(document.addcontactform.AddContactFirstname.value=="" && document.addcontactform.AddContactEmail.value=="")
			alert("Enter First Name and Email Id");
		else if(document.addcontactform.AddContactLastname.value=="" && document.addcontactform.AddContactEmail.value=="")
			alert("Enter Last Name and Email Id");
		else if(document.addcontactform.AddContactFirstname.value=="")
			alert("Enter First Name");
		else if(document.addcontactform.AddContactLastname.value=="")
			alert("Enter Last Name");
		else if(document.addcontactform.AddContactEmail.value=="")
			alert("Enter Email Id");
		
		return false;
	}
}

