/* SiteCatalyst code version: H.14. Copyright Omniture, Inc. More info available at http://www.omniture.com */
/* Author: Neil Evans */
/************************** CONFIG SECTION ****************************************/
/* Specify the Report Suite(s) */
var s_account="devsundevel";
var sun_dynamicAccountSelection=true;
var sun_dynamicAccountList="sunglobal,sundeveloper=java.sun.com;devsundevel=.";	
/* Specify the Report Suite ID */
var s_siteid="jsc:";
/* Settings for pageName */
/* Remote Omniture JS call  */
var sun_ssl=(window.location.protocol.toLowerCase().indexOf("https")!=-1);
	if(sun_ssl == true) { var fullURL = "https://java.sun.com/js/omi/metrics_group1.js"; }
		else { var fullURL= "http://java.sun.com/js/omi/metrics_group1.js"; }
document.write("<sc" + "ript language=\"JavaScript\" src=\""+fullURL+"\"></sc" + "ript>");
/************************** END CONFIG SECTION **************************************/