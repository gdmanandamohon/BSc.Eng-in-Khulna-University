<html>
    <head>
        <title>JI</title>
        <link type="text/css" rel="stylesheet" href="style2.css">
        <script type="text/javascript" src="js/jquery-1.3.1.min.js"></script>
        <script type="text/javascript" language="javascript" src="js/jquery.dropdownPlain.js"></script>
    </head>
    <body>
        <div>
            <?php
            /**
             * Created by PhpStorm.
             * User: Ananda Mohon Ghosh
             * Date: 11/26/14
             * Time: 6:00 PM
             */
            include'dbConnect.php';
            $query ="SELECT * FROM `tbl_menujson`";
            $result =mysql_query($query);
            $row =mysql_fetch_array($result);
            $ss =$row['menu_json'];
            //$ss= '[{"id":"Item 1","children":[{"id":"Item 2","children":[{"id":"Item 3"},{"id":"Item 4"},{"id":"Item 5","children":[{"id":"Item 6"},{"id":"Item 7"},{"id":"Item 8"}]},{"id":"Item 9"},{"id":"Item 10"}]}]},{"id":"Item 11","children":[{"id":"Item 12"}]}]';
            $x =json_decode($ss);
            echo('<ul class="dropdown">');
            break_array2($x);
            echo('</ul>');
            function break_array2($x)
            {
                foreach($x as $data){
                    if(!empty($data->children) && is_array($data->children))
                    {
                        echo "<li>".$data->id;
                        echo('<ul class =dropdown >');
                        break_array2($data->children);
                        echo('</ul>');
                        echo "</li>";
                    }
                    else
                        echo "<li>".$data->id.'</li>';
                }

            }
            ?>
        </div>
    </body>
</html>


