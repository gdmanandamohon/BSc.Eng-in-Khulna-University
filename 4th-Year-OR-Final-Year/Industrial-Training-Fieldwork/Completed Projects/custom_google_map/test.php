<?php
/**
 * Created by PhpStorm.
 * User: Ananda Mohon Ghosh
 * Date: 11/22/14
 * Time: 11:59 AM
 */
//echo'<select>';
include 'dbConnect.php';
$sqlQuery ="SELECT * FROM `tbl_marker_type`";
$result= mysql_query($sqlQuery);
while($row =mysql_fetch_array($result))
{
    $value =$row['type'];
    echo"<option value ='$value'>".$row['type_name']."</option>";
}
//echo('</select>');
?>
<html>
    <head>
        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>

    </head>
    <body>
        <div style="height: 100px; width: 100px; background: #0000FF" id="item1">

        </div>

        <div style="height: 100px; width: 100px; background: #000"id="item2">

        </div>
    <input type="button" id="button1">
    <input type="button" id="button2">
        <script>
            $(document).ready(function(){
                $( "#item1").toggle();
            });
            $( "#button1" ).click(function() {
                $( "#item1").toggle();

            });
            $( "#button2" ).click(function() {
                $( "#item2").toggle();
            });
        </script>
    </body>
</html>

<?php
include 'dbConnect.php';
$selectType=6;//$_REQUEST['type'];
$query="SELECT * FROM tbl_markers where type ='6'";
$result =mysql_query($query);
$arraypoint= array();
$count =0;
while($row =mysql_fetch_array($result))
{
    $array[$count][0]=$row['name'];
    $array[$count][1]=$row['address'];
    $array[$count][2]=$row['lat'];
    $array[$count][3]=$row['lng'];
    $array[$count][4]=$row['contact'];
    $array[$count][5]=$row['type'];
    $count++;

}
while($count==true)
{
    echo($array[$count-1][0]);
    echo($array[$count-1][1]);
    echo($array[$count-1][2]);
    echo($array[$count-1][3]);
    echo($array[$count-1][4]);
    echo($array[$count-1][5]);
    $count--;
    echo("hi "."</br>");
}