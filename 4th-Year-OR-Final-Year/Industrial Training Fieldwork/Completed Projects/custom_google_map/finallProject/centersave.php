<?php
/**
 * Created by PhpStorm.
 * User: Ananda Mohon Ghosh
 * Date: 11/25/14
 * Time: 3:49 PM
 */ ?>

<!DOCTYPE html>
<html>
<head>
<title>Google Map</title>
<link href="style.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAspk2p4d6TkPfIaVOSwc6e6Aaf57j36-c&sensor=false"></script>
<script type="text/javascript">
$(document).ready(function() {

    var data, lat, lng;
    var mapCenter;
    data ={}
    $.ajax({
        type: "POST",
        url: "getMapLtLn.php",
        data: data,
        success:function(data){
            var ltlng = $.parseJSON(data);
            lat =ltlng[0];
            lng =ltlng[1];
            //alert(lat+'  '+lng);
            mapCenter = new google.maps.LatLng(lat, lng);
            map_initialize();
            create_marker('','',mapCenter, 'Center Location', '', true, true, true, "icons/schools_maps.png");
        },
        error:function (xhr, ajaxOptions, thrownError){
            alert(thrownError); //throw any errors
        }
    });

    //Google map Coordinates
    var map;

    // initialize google map

    //############### Google Map Initialize ##############
    function map_initialize()
    {

        var googleMapOptions =
        {
            center: mapCenter, // map center
            zoom: 10, //zoom level, 0 = earth view to higher value
            maxZoom: 18,
            minZoom: 1,
            zoomControlOptions: {
                style: google.maps.ZoomControlStyle.SMALL //zoom control size
            },

            scaleControl: true, // enable scale control
            mapTypeId: google.maps.MapTypeId.ROADMAP // google map type

        };

        map = new google.maps.Map(document.getElementById("google_map"), googleMapOptions);


        //Load Markers from the XML File, Check (map_process.php)


        //Right Click to Drop a New Marker
        google.maps.event.addListener(map, 'rightclick', function(event) {
            //Edit form to be displayed with new marker
            var EditForm = '<p><div class="marker-edit">'+
                '<form action="ajax-save.php" method="POST" name="SaveMarker" id="SaveMarker">'+
                '</form>'+
                '</div></p><button name="save-marker" class="save-marker">Save this Center</button>';

            //Drop a new Marker with our Edit Form
            create_marker('','',event.latLng, 'Center Location', EditForm, true, true, true, "icons/pin_green.png");
        });

    }



    //############### Create Marker Function ##############
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

        //Content structure of info Window for the Markers
        var contentString = $('<div class="marker-info-win">'+
            '<div class="marker-inner-win"><span class="info-content">'+
            '<h1 class="marker-heading">'+MapTitle+'</h1>'+'<h4 style="color :#cccccc">lat:Lon : '+ MapPos +'</h4>'+
            MapDesc+
            '</span><button name="remove-marker" class="remove-marker" title="Remove Marker">NO/Deselect</button>'+
            '</div></div>');


        //Create an infoWindow
        var infowindow = new google.maps.InfoWindow();
        //set the content of infoWindow
        infowindow.setContent(contentString[0]);

        //Find remove button in infoWindow
        var removeBtn 	= contentString.find('button.remove-marker')[0];
        var saveBtn 	= contentString.find('button.save-marker')[0];

        //add click listner to remove marker button
        google.maps.event.addDomListener(removeBtn, "click", function(event) {
            remove_center(marker);
        });

        if(typeof saveBtn !== 'undefined') //continue only when save button is present
        {
            //add click listner to save marker button
            google.maps.event.addDomListener(saveBtn, "click", function(event) {

                var mReplace = contentString.find('span.info-content'); //html to be replaced after success

                    alert('hii');
                    save_center(marker, '', '', '','', mReplace); //call save marker function

            });
        }

        //add click listner to save marker button
        google.maps.event.addListener(marker, 'click', function() {
            infowindow.open(map,marker); // click on marker opens info window
        });

        if(InfoOpenDefault) //whether info window should be open by default
        {
            infowindow.open(map,marker);
        }
    }

    //############### Remove Marker Function ##############
    function remove_center(Marker)
    {
        /* determine whether marker is draggable
         new markers are draggable and saved markers are fixed */
        if(Marker.getDraggable())
        {
            Marker.setMap(null); //just remove new marker
        }
        else
        {
            //Remove saved marker from DB and map using jQuery Ajax
            var mLatLang = Marker.getPosition().toUrlValue(); //get marker position
            var myData = {del : 'true', latlang : mLatLang}; //post variables
            Marker.setMap(null);
        }

    }

    //############### Save Marker Function ##############
    function save_center(Marker, mName, mAddress, mType,mContact, replaceWin)
    {
        //Save new marker using jQuery Ajax
        var mLatLang = Marker.getPosition().toUrlValue(); //get marker position
        var myData = { latlang : mLatLang}; //post variables
        console.log(replaceWin);

        $.ajax({
            type: "POST",
            url: "centerSaveBackend.php",
            data: myData,
            success:function(data){
                replaceWin.html(data); //replace info window with new html
                Marker.setDraggable(false); //set marker to fixed
                Marker.setIcon('icons/schools_maps.png'); //replace icon

            },
            error:function (xhr, ajaxOptions, thrownError){
                alert(thrownError); //throw any errors
            }
        });
    }

});
</script>
</head>
<body>
<div id="google_map"></div>
</body>
</html>