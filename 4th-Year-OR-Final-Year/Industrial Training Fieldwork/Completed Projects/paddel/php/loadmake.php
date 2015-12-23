<?php
/**
 * Created by PhpStorm.
 * User: Ananda Mohon Ghosh
 * Date: 03-Dec-14
 * Time: 10:53 AM
 */
include'dbConnect.php';
$year =$_GET['year'];

$query ="SELECT DISTINCT(make_name) FROM tbl_make
          JOIN tbl_model ON tbl_make.make_id = tbl_model.make_id
          JOIN tbl_car ON tbl_car.model_id = tbl_model.model_id
          WHERE `year_start`<='$year' AND `year_end`>='$year'";

$result =mysql_query($query);
$finalresult =array();
$count=0;
while($row =mysql_fetch_array($result))
{
    $finalresult[$count]=$row['make_name'];
    $count++;
}
echo(json_encode($finalresult));