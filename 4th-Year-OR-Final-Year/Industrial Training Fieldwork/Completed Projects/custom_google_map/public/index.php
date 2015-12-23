<!DOCTYPE html>
<html>
<head>
    <title>Custom Google Map</title>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <link href="style.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css">

</head>

<!-- <i class="fa fa-check"></i>-->
<body>
<div id ='wrapper'>
    <div id ='main-section'>
        <div class="menu-list">
            <ul>
                <li><a href="">Room Information </li>
                <li><a href="">Area Map </li>
                <li><a href="">Street View </li>
                <li><a href="">Local Entities </li>
                <li><a href="">Walk Score </li>
            </ul>
        </div>
        <div id ='selector-type'>
            <ul>
                <li><a href="">Elementary Schools</a></li>
                <li><a href="">Secondary Schools</a></li>
                <li><a href="">Day Care</a></li>
                <li><a href="">Hospitals</a></li>
                <li><a href="">Doctors</a></li>
                <li><a href="">Dentists</a></li>
                <li><a href="">Veterinarians</a></li>
                <li><a href="">Pharmacies</a></li>
                <li><a href="">Cinemas</a></li>
                <li><a href="">Restaurants</a></li>
                <li><a href="">Grocery Stores</a></li>
                <li><a href="">Liquor, Beer & Wine</a></li>
                <li><a href="">Fitness</a></li>
                <li><a href="">Pools</a></li>
                <li><a href="">Tennis Courts</a></li>
                <li><a href="">Ice Rinks</a></li>
                <li><a href="">Salon / Spa</a></li>
                <li><a href="">Banks</a></li>
                <li><a href="">Dry Cleaners</a></li>
                <li><a href="">Car Wash</a></li>
                <li><a href="">Attractions</a></li>
                <li><a href="">Places of Worship</a></li>
                <li><a href="">Medical Clinics</a></li>
                <li><a href="">Recreation Centres</a></li>

            </ul>
            <select onchange="">
                <option value="1">1 KM</option>
                <option value="2">2 KM</option>
                <option value="3">3 KM</option>
                <option value="5">5 KM</option>
            </select>
        </div>
        <div id ='map-canvas'>

            <iframe src="map.php" name="targetframe" allowTransparency="true" scrolling="no" frameborder="0" width="100%" height="100%"></iframe>
        </div>
    </div>
</div>
</body>
</html>