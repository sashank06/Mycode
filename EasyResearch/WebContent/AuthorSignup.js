/* 
 * This js check the sign up credentials on the author sign up page
 */
function signupcheck()
{
	if ((document.form2.fname.value=="")||(document.form2.lname.value=="")||(document.form2.username.value=="")||(document.form2.password.value=="")||(document.form2.retypepassword.value=="")||(document.form2.Email.value=="")||(document.form2.ReEmail.value=="")||(document.form2.company.value=="")||(document.form2.authortype.value=="")||(document.form2.address.value=="")||(document.form2.city.value=="")||(document.form2.state.value=="")||(document.form2.country.value=="")||(document.form2.phone.value==""))
	{
		alert("Missing fields");
	}
	else if ((document.form2.password.value != document.form2.retypepassword.value))
		{
			alert("Mismatch passwords");
		}
	
	else if ((document.form2.Email.value != document.form2.ReEmail.value))
	{
			alert("Mismatch Email");
	}
}