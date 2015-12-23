<?php
/**
 * Created by PhpStorm.
 * User: Ananda Mohon Ghosh
 * Date: 03-Dec-14
 * Time: 11:51 AM
 */
$db_username = 'root';
$db_password = '';
$db_name = 'peddle';
$db_host = 'localhost';

$db_select =mysql_connect('localhost', 'root','');
$db_=mysql_select_db($db_name,$db_select);

