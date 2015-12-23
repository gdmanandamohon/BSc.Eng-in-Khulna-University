<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Google Nexus Website Menu</title>
		<meta name="description" content="A sidebar menu as seen on the Google Nexus 7 website" />
		<meta name="keywords" content="google nexus 7 menu, css transitions, sidebar, side menu, slide out menu" />
		<meta name="author" content="Codrops" />

		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<script src="js/modernizr.custom.js"></script>
	</head>
	<body>
		<div class="container">
			<ul id="gn-menu" class="gn-menu-main">
				<li class="gn-trigger">
					<a class="gn-icon gn-icon-menu"><span>Menu</span></a>
					<nav class="gn-menu-wrapper">
						<div class="gn-scroller">
							<ul class="gn-menu">
								<li class="gn-search-item">
									<input placeholder="Search" type="search" class="gn-search">
									<a class="gn-icon gn-icon-search"><span>Search</span></a>
								</li>
								<li>
									<a class="gn-icon gn-icon-download" data-src ='#markerslist'>Markers</a>
									
								</li>
								<li><a class="gn-icon gn-icon-cog" data-src ='#setting'>Settings</a></li>
								<li><a class="gn-icon gn-icon-help">Help</a></li>
								<li>
									<a class="gn-icon gn-icon-archive" data-src ='#types'>Types</a>
									
								</li>
							</ul>
						</div><!-- /gn-scroller -->
					</nav>
				</li>
				<li><a href="http://tympanus.net/codrops">Codrops</a></li>
				<li><a class="codrops-icon codrops-icon-prev" href="http://tympanus.net/Development/HeaderEffects/"><span>Previous Demo</span></a></li>
				<li><a class="codrops-icon codrops-icon-drop" href="http://tympanus.net/codrops/?p=16030"><span>Back to the Codrops Article</span></a></li>
			</ul>
			<header>
				<h1>Google Nexus Website Menu <span>A sidebar menu as seen on the <a href="http://www.google.com/nexus/index.html">Google Nexus 7</a> page</span></h1>	
			</header>
			<div class="body-area">
				<div id ='markerslist'>
                    <iframe src="map.php" name="targetframe" allowTransparency="true" scrolling="no" frameborder="0" ></iframe>
				</div>
				<div id ='setting'>

                    <iframe src="centersave.php" name="targetframe" allowTransparency="true" scrolling="no" frameborder="0" ></iframe>
				</div>
				<div id ='types'>
                    <p>Existing Types are : </p>
                    <ol >

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

                    </ol>
                    Click Here For <input type="button" value="Add a New Type" name="" onclick="addOpenwindow()">
                    <div id ='new-type-save-div'>
                        <input type="text" name="newType" placeholder="new Type" class='newType'>
                        <input type="button" value="SAVE" onclick="saveNewType()">
                    </div>
				</div>
				
			</div>
			
		</div><!-- /container -->
		<script src="js/jquery-1.10.2.min.js"></script>
		<script src="js/classie.js"></script>
		<script src="js/gnmenu.js"></script>
		<script src="js/custom.js"></script>
		<script>
			new gnMenu( document.getElementById( 'gn-menu' ) );
            $(document).ready(function(){
                $('#new-type-save-div').hide();
            });
           function addOpenwindow()
            {
                $('#new-type-save-div').show();
            }
           function saveNewType()
           {

                   var data={type:$('.newType').val()};
               $.ajax({
                   method:"POST",
                   url:"newTypeadd.php",
                   data:data,
                       success:function(data){
                           $('#new-type-save-div').hide();
                           alert( $('.newType').val()+ " has been added to your type" );
                       },
                   error:function(data){alert('wrong coaling');}
               });
           }
        </script>
	</body>
</html>