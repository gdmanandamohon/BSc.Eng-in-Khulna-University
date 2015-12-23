<!DOCTYPE html>
<html>
    <head>
        <title>Google Map</title>
        <link href="style.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAspk2p4d6TkPfIaVOSwc6e6Aaf57j36-c&sensor=false"></script>
        <script type="text/javascript">
        $(document).ready(function() {

            var mapCenter = new google.maps.LatLng(23.700, 90.3750); //Google map Coordinates
            var map;

            map_initialize(); // initialize google map

            //############### Google Map Initialize ##############
            function map_initialize()
            {
                    var googleMapOptions =
                    {
                        center: mapCenter, // map center
                        zoom: 12, //zoom level, 0 = earth view to higher value
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
                    $.get("map_process.php", function (data) {
                        $(data).find("marker").each(function () {
                              var name 		= $(this).attr('name');
                              var address 	= '<p>'+ $(this).attr('address') +'</p>';
                              var contact 	= $(this).attr('type');
                              var point 	= new google.maps.LatLng(parseFloat($(this).attr('lat')),parseFloat($(this).attr('lng')));
                              create_marker(contact,point, name, address, false, false, false, "icons/pin_blue.png");
                        });
                    });

                    //Right Click to Drop a New Marker
                    google.maps.event.addListener(map, 'rightclick', function(event) {
                        //Edit form to be displayed with new marker
                        var EditForm = '<p><div class="marker-edit">'+
                        '<form action="ajax-save.php" method="POST" name="SaveMarker" id="SaveMarker">'+
                        '<label for="pName"><span>Place Name :</span><input type="text" name="pName" class="save-name" placeholder="Enter Title" maxlength="40" /></label>'+
                        '<label for="pDesc"><span>Description :</span><textarea name="pDesc" class="save-desc" placeholder="Enter Address" maxlength="150"></textarea></label>'+
                        '<label for="pType"><span>Contact :</span> <input name="pType" class="contact-no"></label>'+
                        '<label for="pType"><span>Reign :</span> <select name="pType" class="save-type"><option value="dhaka">Dhaka</option><option value="khulna">Khulna</option>'+
                            '<option value="syhlet">Syhlet</option></select></label>'+
                        '</form>'+
                        '</div></p><button name="save-marker" class="save-marker">Save Tower Info</button>';

                        //Drop a new Marker with our Edit Form
                        create_marker("", event.latLng, 'New Marker', EditForm, true, true, true, "icons/pin_green.png");

                    });

            }

            //############### Create Marker Function ##############
            function create_marker(contact,MapPos, MapTitle, MapDesc,  InfoOpenDefault, DragAble, Removable, iconPath)
            {

                //new marker
                var marker = new google.maps.Marker({
                    contact:contact,
                    position: MapPos,
                    map: map,
                    draggable:DragAble,
                    animation: google.maps.Animation.DROP,
                    title:MapTitle,
                    icon: iconPath
                });

                //Content structure of info Window for the Markers
                var contentString = $('<div class="marker-info-win">'+
                '<div class="marker-inner-win"><span class="info-content">'+
                '<h1 class="marker-heading">'+MapTitle+'</h1>'+
                MapDesc+'<h4>Lat:Long: '+MapPos+'</h4>'+'<h4>Contact: '+contact+'</h4>'+
                '</span><button name="remove-marker" class="remove-marker" title="Remove Marker">Delete The Tower Info</button>'+
                 '<img src="icons/pin_green.png">'+
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
                    remove_marker(marker);
                });

                if(typeof saveBtn !== 'undefined') //continue only when save button is present
                {
                    //add click listner to save marker button
                    google.maps.event.addDomListener(saveBtn, "click", function(event) {
                        var mReplace = contentString.find('span.info-content'); //html to be replaced after success
                        var mName = contentString.find('input.save-name')[0].value; //name input field value
                        var mDesc  = contentString.find('textarea.save-desc')[0].value; //description input field value
                        var mContact = contentString.find('input.contact-no')[0].value; //contact of marker
                        var mype = contentString.find('select.save-type')[0].value;
                        alert(mReign);
                        if(mName =='' || mDesc ==''||mContact ==''|| mReign=='')
                        {
                            alert("Please enter Name and Description!");
                        }else{
                            save_marker(marker, mName, mDesc, mContact, mReplace); //call save marker function
                        }
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
            function remove_marker(Marker)
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
                    $.ajax({
                      type: "POST",
                      url: "map_process.php",
                      data: myData,
                      success:function(data){
                            Marker.setMap(null);
                            alert(data);
                        },
                        error:function (xhr, ajaxOptions, thrownError){
                            alert(thrownError); //throw any errors
                        }
                    });
                }

            }

            //############### Save Marker Function ##############
            function save_marker(Marker, mName, mAddress, mContact, replaceWin)
            {
                //Save new marker using jQuery Ajax
                var mLatLang = Marker.getPosition().toUrlValue(); //get marker position
                var myData = {name : mName, address : mAddress, latlang : mLatLang, contact : mContact }; //post variables
                console.log(replaceWin);
                $.ajax({
                  type: "POST",
                  url: "map_process.php",
                  data: myData,
                  success:function(data){
                        replaceWin.html(data); //replace info window with new html
                        Marker.setDraggable(false); //set marker to fixed
                        Marker.setIcon('icons/pin_blue.png'); //replace icon
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