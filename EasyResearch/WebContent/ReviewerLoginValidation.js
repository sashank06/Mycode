/**
 * This page validations the login credentials of reviewer
 */
function signupcheck()
{
    if ((document.formrs.fname.value=="")||(document.formrs.lname.value=="")||(document.formrs.username.value=="")||(document.formrs.password.value=="")||
(document.formrs.Email.value=="")||(document.formrs.primaryaoi.value=="")||(document.formrs.secondaryaoi.value==""))
    {
        alert("Missing fields");
    }
    else if ((document.formrs.password.value != document.formrs.retypepassword.value))
	{
		alert("Mismatch passwords");
	}
}