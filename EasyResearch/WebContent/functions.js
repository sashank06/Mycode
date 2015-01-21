/**
 * This is main js file which has functions to check and populate details into the forms etc. 
 */
function displaySingleConference(name,place,description){
	if(document.getElementById("ConferenceArea")!= undefined && document.getElementById("ConferenceArea")!= null){
		document.getElementById("ConferenceArea").style.display="inline-block";
		document.getElementById("conferenceName").innerHTML = name +" at "+place;;
		document.getElementById("TitleValue").value = name;
		document.getElementById("ConfDescription").value = description;
	}
}

function displaySingleAbstractPaperStatus(name){
	if(document.getElementById("AbstractPaperStatusArea")!= undefined && document.getElementById("AbstractPaperStatusArea")!= null){
		document.getElementById("AbstractPaperStatusArea").style.display="inline-block";
		document.getElementById("StatusValue").innerHTML = name;
	}
}

function displaySingleAbstract(nameofconf,UserKey,title,abstractKeywords,abstractsText,abstractId){
	if(document.getElementById("CheckAbstractArea")!= undefined && document.getElementById("CheckAbstractArea")!= null){
		document.getElementById("CheckAbstractArea").style.display="inline-block";
		document.getElementById("nameofconf").value= nameofconf;//values[0];
		document.getElementById("title").value= title;//values[2];
		document.getElementById("showConfAbsTitle").innerHTML= nameofconf+" - "+ title;//values[0] +" - "+ values[2];
		document.getElementById("checkAbstractKeywords").value= abstractKeywords;//values[3];
		document.getElementById("abstract").value= abstractsText;//values[4];
		document.getElementById("abstractKeywords").value= abstractKeywords;//values[3];
		document.getElementById("abstractsText").value= abstractsText;//values[4];
		document.getElementById("UserKey").value= UserKey;//values[1];
		document.getElementById("abstractId").value= abstractId;//values[1];
	}
}

function displaySingleReviewingPaper(title,paperlocation){
	if(document.getElementById("ReviewPaperArea")!= undefined && document.getElementById("ReviewPaperArea")!= null){
		document.getElementById("ReviewPaperArea").style.display="inline-block";
		
		document.getElementById("revEvalTable").style.height="360px";
		document.getElementById("revEvalTable").style.width="254px";
		
		document.getElementById("listofPaperTitles").valign="top";
		document.getElementById("listofPaperTitles").style.height="50px";
		
		document.getElementById("showPaperReviewTitle").innerHTML= title;
		document.getElementById("downloadPaper").innerHTML = title;
		document.getElementById("paperLocationDownload").value= paperlocation;
		document.getElementById("paperLocationSave").value= paperlocation;
	}
}

function downloadPaper(){
		document.forms["downloadPaperform1"].submit();	
}
function checkValueOfDecision(){
	if(document.getElementById("decisionValue").value == 'Decision') return false;
	else document.forms["absChkform1"].submit();
};
	
function displayAbstractStatus(confName, title, abstactStatus,abstractId,paperStatus){
	if(document.getElementById("AbstractStatusArea")!= undefined && document.getElementById("AbstractStatusArea")!= null){
		document.getElementById("AbstractStatusArea").style.display="inline-block";
		if(abstactStatus == 'Accept' && (paperStatus!=null && paperStatus.trim()!='')){
			document.getElementById("authorstatusmaintable").style.width = "844px";
			document.getElementById("AbstractStatusArea").style.width = "739px";
			document.getElementById("AutPapUpAbstStat").style.borderRight="1px solid #aaa";
			document.getElementById("abstractStatusAuthorCheckStatus").style.borderRight="1px solid #aaa";
			document.getElementById("AutPapUpPaperStat").style.display= "inline-block";
			document.getElementById("paperStatusAuthorCheckStatus").style.display= "inline-block";
			document.getElementById("paperStatusAuthorCheckStatus").innerHTML=paperStatus.toString();
		}
		else if(abstactStatus == 'Accept'){
			document.getElementById("authorstatusmaintable").style.width = "923px";
			document.getElementById("AbstractStatusArea").style.width = "825px";
			document.getElementById("AutPapUpAbstStat").style.borderRight="1px solid #aaa";
			document.getElementById("abstractStatusAuthorCheckStatus").style.borderRight="1px solid #aaa";
			document.getElementById("AutPapUp").style.display= "inline-block";
			document.getElementById("uploadPaperAuthorCheckStatus").style.display= "inline-block";
			document.getElementById("AutPapUpPaperStat").style.display= "none";
			document.getElementById("paperStatusAuthorCheckStatus").style.display= "none";
		}
		else{
			document.getElementById("authorstatusmaintable").style.width = "600px";
			document.getElementById("AbstractStatusArea").style.width = "510px";
			document.getElementById("AutPapUpAbstStat").style.borderRight="0px";
			document.getElementById("abstractStatusAuthorCheckStatus").style.borderRight="0px";
			document.getElementById("AutPapUp").style.display= "none";
			document.getElementById("uploadPaperAuthorCheckStatus").style.display= "none";
			document.getElementById("AutPapUpPaperStat").style.display= "none";
			document.getElementById("paperStatusAuthorCheckStatus").style.display= "none";
		}
		document.getElementById("uploadPaperAbstractId").value = abstractId.toString();
		document.getElementById("conferenceNameAuthorCheckStatus").innerHTML= confName.toString();
		document.getElementById("uploadPaperTitleName").value=title.toString();
		document.getElementById("titleAuthorCheckStatus").innerHTML=title.toString();
		document.getElementById("abstractStatusAuthorCheckStatus").innerHTML=abstactStatus.toString();
	}
}

function sendEmailToInputBox(email){
	if(document.getElementById("addEmails")!=undefined && document.getElementById("addEmails")!=null){
		var emailList = document.getElementById("addEmails").value;
		if(emailList!=undefined && emailList!=null && emailList!=''){
			emailList = emailList + ";" + email;
		}
		else{
			emailList = email;
		}
		document.getElementById("addEmails").value = emailList.toString(); 
	}
}
function paperStatusUpload(){
}

function overlay(confName, place, confDate, absSubDate) {
	el = document.getElementById("overlay");
	el.style.visibility = (el.style.visibility == "visible") ? "hidden" : "visible";
	document.getElementById("homeConfNameValue").innerHTML= confName.toString();
	document.getElementById("homeConfPlaceValue").innerHTML=place.toString();
	document.getElementById("homeConfDateValue").innerHTML=confDate.toString();
	document.getElementById("homeAbsSubDateValue").innerHTML=absSubDate.toString();
	document.getElementById('closeButtonModalId').onclick = function()
	{
		el.style.visibility = "hidden";
	}
}

function displaySinglePaper(paperId, paperName){
	if(document.getElementById("paperTable")!= undefined && document.getElementById("paperTable")!= null){		        
		document.getElementById("paperId").value=paperValue[0].toString();
		document.getElementById("paperName").value=paperValue[1].toString();
	}
}

function singlePaperValues(){
	if(document.getElementById("paperTable")!= undefined && document.getElementById("paperTable")!= null){
		var radios = document.getElementsByName('paperSelected');

		for (var i = 0, length = radios.length; i < length; i++) {
		    if (radios[i].checked) {
		        var paperDetails = radios[i].value;
		        var paperValue  = paperDetails.split("_:_");
		        document.getElementById("paperId").value=paperValue[0].toString();
		        document.getElementById("paperName").value=paperValue[1].toString();
		        return true;
		    }
		}
	}
	return false;
}

function fetchPaperAndReviewerDetails(){
	var pass_fail = singlePaperValues();
	var reviewervalues = [];
	reviewervalues = getCheckedCheckboxesFor();
	if(reviewervalues!=null && reviewervalues!=undefined && reviewervalues!='' && pass_fail==true){
		document.getElementsByName("reviewersDetailsInputList[]").value = reviewervalues;
		document.forms["formpapRev"].submit();
	}
}

function getCheckedCheckboxesFor() {
    var checkboxes = document.querySelectorAll('input[name="reviewerList"]:checked'), values = [];
    Array.prototype.forEach.call(checkboxes, function(el) {
        values.push(el.value);
    });
    return values;
}

function displaySinglePaperNotification(title, abstractText, conferenceName){
	if(document.getElementById("PaperNotificationArea")!= undefined && document.getElementById("PaperNotificationArea")!= null){
		document.getElementById("PaperNotificationArea").style.display="inline-block";
		document.getElementById("nameofconfPaper").value= conferenceName;
		document.getElementById("paperTitle").value= title;
		document.getElementById("showConfReviewPaperTitleSpan").innerHTML= title+" - "+ conferenceName;
		document.getElementById("abstractPaper").value= abstractText;
		document.getElementById("paperAbstractsText").value= abstractText;
	}
}

function checkValueOfPaperReviewDecision(){
	if(document.getElementById("paperDecisionValue").value == 'Decision') return false;
	else document.forms["revPaperform1"].submit();
};

function displaySinglePaperFinalDecision(paperId,conferenceName,paperTitle,paperLocation,reviewerCommentDetail1,reviewerCommentDetail2,reviewerCommentDetail3){
	if(document.getElementById("MakeDecArea")!= undefined && document.getElementById("MakeDecArea")!= null){
		document.getElementById("MakeDecArea").style.display="inline-block";
		
		document.getElementById("confMakeDecTable").style.height="300px";
		document.getElementById("confMakeDecTable").style.width="330px";
		
		document.getElementById("listofPaperDecisionTitles").valign="top";
		document.getElementById("listofPaperDecisionTitles").style.height="50px";
		
		document.getElementById("paperDecisionId").value = paperId.toString();
		document.getElementById("showPaperMakeDecisionTitle").innerHTML= paperTitle;
		document.getElementById("downloadPaperforDecision").innerHTML = paperTitle;
		document.getElementById("paperDecisionLocationDownload").value= paperLocation;
		
		var commentvalues1 = commentvalues2 = commentvalues3 = [];
		
		reviewerCommentDetail1 = reviewerCommentDetail1.replace("[","").replace("]","");
		reviewerCommentDetail2 = reviewerCommentDetail2.replace("[","").replace("]","");
		reviewerCommentDetail3 = reviewerCommentDetail3.replace("[","").replace("]","");
		
		commentvalues1 = reviewerCommentDetail1.split(",");
		commentvalues2 = reviewerCommentDetail2.split(",");
		commentvalues3 = reviewerCommentDetail3.split(",");
		
		var commentString1= "<span style='font-style:italic; vertical-align:top;'>" + commentvalues1[0] + " " + commentvalues1[1] + " wrote: " + commentvalues1[2] + "</span><br/><br/>";
		var commentString2= "<span style='font-style:italic; vertical-align:top;'>" + commentvalues2[0] + " " + commentvalues2[1] + " wrote: " + commentvalues2[2] + "</span><br/><br/>";
		var commentString3= "<span style='font-style:italic; vertical-align:top;'>" + commentvalues3[0] + " " + commentvalues3[1] + " wrote: " + commentvalues3[2] + "</span><br/><br/>";
		
		var fullCommentSection = commentString1+commentString2+commentString3;
		document.getElementById("reviewerPaperDecisionComments").innerHTML= fullCommentSection;
	}
}

function checkValueOfFinalPaperDecision(){
	if(document.getElementById("finalPaperDecisionValue").value == 'Decision') return false;
	else document.forms["makeDecisionOnCommentsform1"].submit();
};

function downloadPaperForDecision(){
	document.forms["downloadPaperDecisionform1"].submit();
}