<?php
/**
 * Created by PhpStorm.
 * User: Ananda Mohon Ghosh
 * Date: 11/25/14
 * Time: 4:08 PM
 */
include'dbConnect.php';
$mLatLang	= explode(',',$_REQUEST["latlang"]);
$mLat 		= filter_var($mLatLang[0], FILTER_VALIDATE_FLOAT);
$mLng 		= filter_var($mLatLang[1], FILTER_VALIDATE_FLOAT);
$queryLat ="UPDATE `tbl_setting` SET `value`='$mLat' WHERE `key`='latitude'";
$queryLng  ="UPDATE `tbl_setting` SET `value`='$mLng' WHERE `key`='longitude'";
mysql_query($queryLat);
mysql_query($queryLng);
$output = '<h1 class="marker-heading">Center</h1><p>Lat:Long:'.$mLat.":".$mLng .'</p>';
exit($output);