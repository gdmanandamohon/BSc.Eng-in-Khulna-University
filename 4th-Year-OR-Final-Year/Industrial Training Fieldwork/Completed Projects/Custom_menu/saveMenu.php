<?php
/**
 * Created by PhpStorm.
 * User: Ananda Mohon Ghosh
 * Date: 11/27/14
 * Time: 1:13 PM
 */
include'dbConnect.php';
$menuString=$_POST['JSdata'];
$query ="UPDATE `tbl_menujson` SET `menu_json`='$menuString'";
mysql_query($query);
//echo("<script>alert('hi man gooda day')</script>");