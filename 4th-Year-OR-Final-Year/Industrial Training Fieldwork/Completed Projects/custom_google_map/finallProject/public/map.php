<!DOCTYPE html>
<html>
<head>
    <title>Google Map</title>
    <link href="mapstyle.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAspk2p4d6TkPfIaVOSwc6e6Aaf57j36-c&sensor=false"></script>
    <script type="text/javascript">
        var mapCenter
        var map;
        $(document).ready(function() {

            mapCenter= new google.maps.LatLng(23.7000, 90.3750); //Google map Coordinates


            map_initialize(); // initialize google map

            //############### Google Map Initialize ##############
            function map_initialize()
            {
                var googleMapOptions =
                {
                    center: mapCenter, // map center
                    zoom: 14, //zoom level, 0 = earth view to higher value
                    maxZoom: 18,
                    minZoom: 1,
                    zoomControlOptions: {
                        style: google.maps.ZoomControlStyle.SMALL //zoom control size
                    },
                    scaleControl: true, // enable scale control
                    mapTypeId: google.maps.MapTypeId.ROADMAP // google map type
                };

                map = new google.maps.Map(document.getElementById("google_map"), googleMapOptions);
            }

            //############### Create Marker Function ##############

        });

        var gmarkers = [];

        function removeMarkers(){
            for(i=0; i<gmarkers.length; i++){
                gmarkers[i].setMap(null);
            }
        }


        function create_marker(type, contact, MapPos, MapTitle, MapDesc,  InfoOpenDefault, DragAble, Removable, iconPath)
        {



            //new marker
            var marker = new google.maps.Marker({
                position: MapPos,
                map: map,
                draggable:DragAble,
                animation: google.maps.Animation.DROP,
                title:MapTitle,
                icon: iconPath,
                contact:contact,
                type: type
            });

            gmarkers.push(marker);


            //Content structure of info Window for the Markers
            var contentString = $('<div class="marker-info-win">'+
                '<div class="marker-inner-win"><span class="info-content">'+
                '<h1 class="marker-heading">'+MapTitle+'</h1>'+'<h4 style="color :#cccccc">lat:Lon : '+ MapPos +'</h4>'+'<h4>Contact : '+ contact +'</h4>'+
                MapDesc+'</h4>'+'<h4>Type : '+ type +'</h4>'+
                '</span><button name="remove-marker" class="remove-marker" title="Remove Marker"></button>'+
                '</div></div>');


            //Create an infoWindow
            var infowindow = new google.maps.InfoWindow();
            //infowindow.setTitle("HTML");
            //map.infoWindow.resize(300, 200);
            //set the content of infoWindow
            infowindow.setContent(contentString[0]);

            //add click listner to save marker button
            google.maps.event.addListener(marker, 'click', function() {
                infowindow.open(map,marker); // click on marker opens info window
            });

            if(InfoOpenDefault) //whether info window should be open by default
            {
                infowindow.open(map,marker);
            }


        }
        function changemarkre(typeId)
        {
            var data={type:typeId};
            // alert(data);
            $.ajax({
                method:"POST",
                url:"retSlected.php",
                data:data,
                success:function(data){
                   var unavailabledates = $.parseJSON(data);
                    var length =unavailabledates.length;
                    while(length!=0)
                    {

                       var point =  new google.maps.LatLng(unavailabledates[length-1][2], unavailabledates[length-1][3]);
                        create_marker(unavailabledates[length-1][5],unavailabledates[length-1][4],point,unavailabledates[length-1][0], unavailabledates[length-1][1], false, false, false, "icons/pin_blue.png")
                        length--;
                    }

                },
                error:function(data){alert('wrong coaling');}
            });



        }

        var tt;
        function getID(ctrl)
        {
            tt=ctrl;
            //alert(ctrl.className);
            changemarkre(ctrl.className);
            removeMarkers();
        }

    </script>
</head>
<body>
<div id ='wrapper'>
    <div class="menu-list">
        <ul>
            <li>Room Information </li>
            <li>Area Map </li>
            <li>Street View </li>
            <li>Local Entities </li>
            <li>Walk Score </li>
        </ul>
    </div>
    <div id ='selector-type'>
        <ul >

            <?php
            include 'dbConnect.php';
            $sqlQuery ="SELECT * FROM `tbl_marker_type`";
            $result= mysql_query($sqlQuery);
            while($row =mysql_fetch_array($result))
            {
                $value =$row['type'];
                echo"<li class ='$value' onclick='getID(this)'>".$row['type_name']. "</li>";
            }
            ?>

        </ul>

        <select onchange="method()">
            <option value="1">1 KM</option>
            <option value="2">2 KM</option>
            <option value="3">3 KM</option>
            <option value="5">5 KM</option>
        </select>
    </div>

    <div id="google_map"></div>
</div>
</body>
</html>


