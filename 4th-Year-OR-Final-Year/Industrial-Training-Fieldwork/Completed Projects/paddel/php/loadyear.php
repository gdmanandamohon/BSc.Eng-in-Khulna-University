<?php
/**
 * Created by PhpStorm.
 * User: Ananda Mohon Ghosh
 * Date: 03-Dec-14
 * Time: 10:44 AM
 */
include'dbConnect.php';
$query ="SELECT `year_end`,`year_start` FROM `tbl_car`";
$result =mysql_query($query);
$finalresult=array();
$countt =0;
while($row =mysql_fetch_array($result))
{
    $start=$row['year_start'];
    $end=$row['year_end'];
    //echo $start;
    //echo $end;
    for($i =$start; $i<=$end; $i++)
    {
        $flag =false;
        $j=0;
        while($j<count($finalresult))
        {
            if($i==$finalresult[$j])
            {
                $flag=true;
                break;
            }
            $j++;
        }
        if($flag==false)
        {
            $finalresult[$countt]=$i;
            $countt++;
        }

    }

}
rsort($finalresult);
echo(json_encode($finalresult));