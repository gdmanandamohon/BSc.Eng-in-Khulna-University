<?php
/**
 * Created by PhpStorm.
 * User: Ananda Mohon Ghosh
 * Date: 11/22/14
 * Time: 10:35 AM
 */
// database settings
$db_username = 'root';
$db_password = '';
$db_name = 'customgooglemap';
$db_host = 'localhost';

$db_select =mysql_connect($db_host,$db_username,$db_password);
$db_=mysql_select_db($db_name,$db_select);
