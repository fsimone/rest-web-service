/**
 * Invia SMS tramite Skebby 
 */

var SMS_CLASSIC_MAX_LENGTH = 765,
	SMS_BASIC_MAX_LENGTH = 1404,
	CURRENT_SMS_LENGTH = 765;
	var translations = Array();
	translations['ErrorTextMoreThan']='Warning! The text can\' be more than ';
	translations['ErrorChars']=' characters!\n';
function addRecipient() {
	var newRecipient = document.createElement('div');
	newRecipient.innerHTML = '<input id="recipients" name="recipients" type="text" value="39" /> <a href="javascript:;" onclick="removeRecipient(this.parentNode);"><small>Remove</small></a>';
	document.getElementById("recipients").appendChild(newRecipient);
}
function removeRecipient(obj) {
	document.getElementById("recipients").removeChild(obj);
}
window.onload = function() {
	var msgMaxLen = document.getElementById("messageMaxLength");
	document.getElementById("method").onchange = function(){
		switch(this.value) {
			case "classic":
			case "report":
				msgMaxLen.innerHTML = SMS_CLASSIC_MAX_LENGTH;
				CURRENT_SMS_LENGTH = SMS_CLASSIC_MAX_LENGTH;
				charLeft();
				break;
			case "basic":
				msgMaxLen.innerHTML = SMS_BASIC_MAX_LENGTH;
				CURRENT_SMS_LENGTH = SMS_BASIC_MAX_LENGTH;
				charLeft();
				break;
		}
	};
	document.getElementById("text").onkeyup = function(){
		charLeft();
	};
};
function charLeft(){
	var max = CURRENT_SMS_LENGTH;
	var smsText = document.getElementById("text").value;
	var doubleChars = 0;

	if(smsText==="") {
		var length = 0;
	} else {
		var length = getRealLengthFor(smsText,false);
		doubleChars = getRealLengthFor(smsText,true);
	}

	if (length > max){
		document.getElementById("text").value = smsText.substring(0, max-doubleChars);
		alert(translations['ErrorTextMoreThan'] + max + translations['ErrorChars']);
	}

	var leftChars = length;
	if (leftChars < 0){
		leftChars = 0;
	}
	document.getElementById("leftChars").innerHTML = leftChars;
	var numberOfSMS = document.getElementById("numberOfSMS");
	var actualNumberOfSMS = 0;
	switch(max) {
		case SMS_CLASSIC_MAX_LENGTH:
			if(length<=160) {
				numberOfSMS.innerHTML = '1';
			}
			if(length>160) {
				actualNumberOfSMS = Math.floor((length-1) / 153) + 1;
				numberOfSMS.innerHTML = actualNumberOfSMS;
			}
			break;
		case SMS_BASIC_MAX_LENGTH:
			numberOfSMS.innerHTML = getNumberOfSegmentForBasic(smsText.length, smsText);
			break;
	}
}
//from JAVA:
//var SPECIAL_CHARS = Array('[', '\\', ']', '^', '{', '|', '}', '~', '�', 8364);
var SPECIAL_CHARS = Array("\x5B", "\x5C", "\x5D", "\x5E", "\x7B", "\x7C", "\x7D", "\x7E", 8364, 49792, 14844588);
var CHAR_TO_CUT_BASIC = Array(' ', '.', ',', '?', '!');

// Check if a variable is null or empty
function isEmpty( inputStr ) { if ( null == inputStr || "" == inputStr ) { return true; } return false; }

// Add a method to toCharArray string class
// already existing in java
String.prototype.toCharArray = function() {
	var charArr=new Array();
	for(var i=0;i<this.length;i++) charArr[i]=this.charAt(i);
	return charArr;
};

// isIntInTheArray
// Search in the array if char c is present
// Parameters:
// char c, char[] chars
function isIntInTheArray(c, chars) {
	for(var i=0;i<chars.length;i++) {
		if(chars[i] == c || chars[i] == c.charCodeAt(0)) return true;
	}
	return false;
}

// getRealLengthFor
// Parameters:
// String s
// Return int
function getRealLengthFor(s,getDoubleChars) {
	if (isEmpty(s)) return 0;

	var chars = s.toCharArray();
	var numberOfSpecialChars = 0;
	for (var k=0; k<chars.length; k++) {
		if (isIntInTheArray(chars[k], SPECIAL_CHARS)) {
			numberOfSpecialChars++;
		}
	}
	if(getDoubleChars === true) return numberOfSpecialChars;
	return s.length + numberOfSpecialChars;
}

// SMS Basic Count - Mirko Mariani
// Traduction from JAVA algorithm
// Return Int
// Parameters:
// Integer len, String s
function getNumberOfSegmentForBasic(len, s) {
	if (len <= 160) return 1;

	var leftStringToSplit = s;
	var segmentNumber = 0, cycle = 0, segmentLength = 0;
	var c = 'c';
	var charForLeftString = null;

	while (!isEmpty(leftStringToSplit)) {
		var indexOfEndSegment = -1;
		var numberOfSpecialChars = 0;
		if ( cycle == 0 ) {
			segmentLength = 156;
		}
		else {
			segmentLength = 156;
		}

		// Check if we reached the last segment
		if ( getRealLengthFor( leftStringToSplit , false) > segmentLength ) {

			charForLeftString = leftStringToSplit.toCharArray();

			for ( var k = 0; k < charForLeftString.length; k++ ) {
				if ( isIntInTheArray( charForLeftString[k], SPECIAL_CHARS ) ) {
					numberOfSpecialChars++;
				}
			}

			indexOfEndSegment = segmentLength - numberOfSpecialChars;

			// go to the point where cut the text
			var charChecked = 0;
			var charForCuttingFound = false;

			// search till the 15 char back
			while ( charChecked < 15 && !charForCuttingFound ) {
				c = leftStringToSplit.charAt( indexOfEndSegment - charChecked  );

				if ( isIntInTheArray( c, CHAR_TO_CUT_BASIC ) ) {
					segmentNumber++;

					charForCuttingFound = true;
				}
				else {
					charChecked++;
				}
			}

			// if no char has been found the string will be cut at the end of the segment length -> put the charChecked to 0 to
			// use the substring method below to determine the left string still to split
			if (!charForCuttingFound ) {
				segmentNumber++;
				charChecked = 0;
			}

			// change the left string still to split
			leftStringToSplit = leftStringToSplit.substring( indexOfEndSegment - charChecked, leftStringToSplit.length );
		}
		else {
			// reset to end the cycle
			leftStringToSplit = "";
			segmentNumber++;
		}

		cycle++;
	}
	return segmentNumber;
}