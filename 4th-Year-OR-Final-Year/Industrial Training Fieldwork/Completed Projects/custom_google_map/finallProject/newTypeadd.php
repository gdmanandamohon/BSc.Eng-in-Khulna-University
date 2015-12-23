<?php
/**
 * Created by PhpStorm.
 * User: Ananda Mohon Ghosh
 * Date: 11/25/14
 * Time: 12:25 PM
 */
include'dbConnect.php';
$type = $_REQUEST['type'];
$query ="INSERT INTO `tbl_marker_type`(`type_name`) VALUES ('$type')";
mysql_query($query);