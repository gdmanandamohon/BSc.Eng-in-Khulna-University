<?php
//PHP 5 +

// database settings
$db_username = 'root';
$db_password = '';
$db_name = 'customgooglemap';
$db_host = 'localhost';

//mysqli
$mysqli = new mysqli($db_host, $db_username, $db_password, $db_name);


################ Continue generating Map XML #################

//Create a new DOMDocument object
$dom = new DOMDocument("1.0");
$node = $dom->createElement("markers"); //Create new element node
$parnode = $dom->appendChild($node); //make the node show up 

// Select all the rows in the markers table
$results = $mysqli->query("SELECT * FROM tbl_markers");
if (!$results) {  
	header('HTTP/1.1 500 Error: Could not get markers!'); 
	exit();
} 

//set document header to text/xml
header("Content-type: text/xml"); 

// Iterate through the rows, adding XML nodes for each
while($obj = $results->fetch_object())
{
  $node = $dom->createElement("marker");  
  $newnode = $parnode->appendChild($node);   
  $newnode->setAttribute("name",$obj->name);
  $newnode->setAttribute("address", $obj->address);  
  $newnode->setAttribute("lat", $obj->lat);  
  $newnode->setAttribute("lng", $obj->lng);
  //$newnode->setAttribute("type", $obj->type);
    $varType =$obj->type;
    $results2 = $mysqli->query("SELECT * FROM tbl_marker_type WHERE type ='$varType'");
    $obj2=$results2->fetch_object();

  $newnode->setAttribute("type", $obj2->type_name);
  $newnode->setAttribute("contact", $obj->contact);


}

echo $dom->saveXML();
