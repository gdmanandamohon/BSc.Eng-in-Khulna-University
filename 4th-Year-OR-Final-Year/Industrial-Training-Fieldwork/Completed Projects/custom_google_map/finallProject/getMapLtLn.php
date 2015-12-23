<?php
/**
 * Created by PhpStorm.
 * User: Ananda Mohon Ghosh
 * Date: 11/25/14
 * Time: 2:23 PM
 */
include 'dbConnect.php';
$query ="SELECT * FROM `tbl_setting` WHERE `key`='latitude' OR `key`='longitude'";
$result=mysql_query($query);
$latlong=array();
$ii=0;
while($row =mysql_fetch_array($result))
{
    $latlong[$ii]=$row['value'];
    $ii++;
}
echo(json_encode($latlong));