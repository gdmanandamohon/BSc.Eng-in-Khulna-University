<?php
/**
 * Created by PhpStorm.
 * User: Ananda Mohon Ghosh
 * Date: 04-Dec-14
 * Time: 11:48 AM
 */
include'dbConnect.php';
$year =$_GET['year'];
$make = $_GET['make'];
$model =$_GET['model'];

$query ="SELECT `doors`,`no_of_wd`,`weight`,`engine`  FROM tbl_make
          LEFT JOIN tbl_model ON tbl_make.make_id = tbl_model.make_id
          LEFT JOIN tbl_car ON tbl_car.model_id = tbl_model.model_id
          WHERE `year_start`<=$year AND `year_end`>=$year AND `make_name`='$make' AND `model`='$model'";

$result =mysql_query($query);
$finalresult =array();
$count=0;
while($row =mysql_fetch_array($result))
{
    $finalresult[$count]=$row['doors']."dr-".$row['no_of_wd'].'wd-'.$row['weight'].'Kg-'.$row['engine'].'Eng';
    $count++;
}
echo(json_encode($finalresult));