<?php
include 'dbConnect.php';
$selectType=$_REQUEST['type'];
//select type from type no
$query= "SELECT distinct(type_name) FROM tbl_marker_type WHERE type='$selectType'";
$result =mysql_query($query);
$row =mysql_fetch_array($result);
$varType=$row['type_name'];
$query="SELECT * FROM tbl_markers WHERE type='$selectType'";
$result =mysql_query($query);
$arraypoint= array();
$count =0;
while($row =mysql_fetch_array($result))
{
    $arraypoint[$count][0]=$row['name'];
    $arraypoint[$count][1]=$row['address'];
    $arraypoint[$count][2]=$row['lat'];
    $arraypoint[$count][3]=$row['lng'];
    $arraypoint[$count][4]=$row['contact'];
    $arraypoint[$count][5]=$varType;
    $count++;
}
echo(json_encode($arraypoint));
