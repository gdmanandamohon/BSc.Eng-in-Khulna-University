<?php
/**
 * Created by PhpStorm.
 * User: Ananda Mohon Ghosh
 * Date: 11/22/14
 * Time: 3:50 PM
 */

include'dbConnect.php';

//echo'<select>';
include 'dbConnect.php';
$sqlQuery ="SELECT * FROM `tbl_marker_type`";
$result= mysql_query($sqlQuery);
$returnstring ='';
while($row =mysql_fetch_array($result))
{
    $value =$row['type'];
   echo  "<option value ='$value'>".$row['type_name']."</option>";
}
//echo(json_encode($returnstring));
//echo('</select>');