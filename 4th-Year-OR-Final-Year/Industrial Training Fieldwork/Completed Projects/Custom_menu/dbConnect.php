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
$db_name = 'custommenu';
$db_host = 'localhost';

$db_select =mysql_connect('localhost', 'root','');
$db_=mysql_select_db($db_name,$db_select);

