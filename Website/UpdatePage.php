<?php
 	session_start();
	if(!isset($_SESSION['session_username'])){
		header("location: index.php");
		exit();
	}
	if($_SESSION['update_page_initialized'] == 0){
		$_SESSION['selected_store'] = "";
		$_SESSION['selected_event'] = "";
		$_SESSION['store_id'] = 0;
		$_SESSION['event_id'] = 0;
		$_SESSION['update_page_initialized'] = 1;
	}
?>
<html lang="en">
	<title>Reserve!</title>
	<head>	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link rel="stylesheet" href="https://unpkg.com/leaflet@1.4.0/dist/leaflet.css"
		   integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA=="
		   crossorigin=""/>
		<meta charset="UTF-8">
		<style>
			#mapid { height: 400px; width: 400px; }
			ul {
				list-style-type: none;
				margin: 0;
				padding: 0;
				overflow: hidden;
				background-color: #333;
			}

			li {
				float: left;
			}

			li a {
				display: block;
				color: white;
				text-align: center;
				padding: 14px 16px;
				text-decoration: none;
			}

			li a:hover {
				background-color: #111;
			}

			.topright {
				color: #555555;
				position: absolute;
				top: 8px;
				right: 16px;
				font-size: 18px;
			}
			.profile_pic {
				vertical-align: middle;
				float: right;
				width: 50px;
				height: 50px;
				border-radius: 50%;
				margin-top: 0px;
				margin-bottom: 0px;
				margin-left: 0px;
			}

			/* The grid: Four equal columns that floats next to each other */
			.column {
				float: left;
				width: 90px;
				padding: 5px;
			}

			/* Style the images inside the grid */
			.column img {
				opacity: 0.8;
				cursor: pointer;
				width: 100px;
				height: 100px;
			}

			.column img:hover {
				opacity: 1;
			}

			/* Clear floats after the columns */
			.row:after {
				content: "";
				display: table;
				clear: both;
			}

			/* The expanding image container (positioning is needed to position the close button and the text) */
			.container {
				position: relative;
				display: none;
			}

			/* Closable button inside the image */
			.closebtn {
				position: absolute;
				top: 10px;
				right: 15px;
				color: white;
				font-size: 35px;
				cursor: pointer;
			} 

			form  { display: table;      }
			p     { display: table-row;  }
			label { display: table-cell; }
			input { display: table-cell; }
		</style>
	</head>
	<body>
		<!-- Title -->
		<h1 style="margin-top: 0;margin-bottom: 0;">Reserve</h1>
		<h2 style="margin-top: 0;margin-bottom: 0;margin-left: 5px;font-weight: normal;color: #777777;">Reserve seats in your favorite stores<br> in real time.</h2>

		<!-- Profile -->
		<div class="topright">
			<h3 style="margin-top: 0;margin-bottom: 0px;font-weight: normal;">Welcome, <b><?php echo $_SESSION['session_username'];?></b>!</h3>
			<img src="Resources/profile.jpg" class="profile_pic">
		</div>

			<br><a style="top: 80px;" class="topright" href='logoff.php'>Log off</a>
		<!-- Navbar -->
		<ul>
			<li><a href="index.php" >Home</a></li>
			<li><a href="news.php" >News</a></li>
			<li><a href="contact.php" >Contact</a></li>
			<li><a href="about_us.php" >About Us</a></li>
			<li><a href="UpdatePage.php" >Update Page</a></li>
		</ul>

		<!-- Drop down list -->
		<?php
			$db_server["host"] = "localhost"; //database server
			$db_server["username"] = "softeng"; // DB username
			$db_server["password"] = "softeng"; // DB password
			$db_server["database"] = "RESERVE";// database name

			$mysql_con = mysqli_connect($db_server["host"], $db_server["username"], $db_server["password"], $db_server["database"]);
			$mysql_con->query ('SET CHARACTER SET utf8');
			$mysql_con->query ('SET COLLATION_CONNECTION=utf8_unicode_ci');

			$query = "SELECT * FROM STORE WHERE OWNER_ID=\"".$_SESSION['user_id']."\"";
			$result = $mysql_con->query($query);
			$stores = array();

			include 'Classes/store.php';
			while($row = $result->fetch_assoc()) {
				array_push($stores, new Store($row['ID'], $row['STORE_NAME'], $row['OWNER_ID'], $row['CAPACITY'], $row['CURRENT_AVAILABILITY'], $row['DESCRIPTION'], $row['VISIBLE'], $row['TYPE'], $row['X'], $row['Y']));
			}
			$curr = 0;
			echo '<form style="margin-top: 50px;margin-left: 50px;margin-right: 50px;" method="POST">';
			echo '	<select name="Store">';
			for($i=0;$i<sizeof($stores);$i++){
				echo 	'<option value="'.$stores[$i]->Name.'">'.$stores[$i]->Name.'</option>';
			}
			echo '	<input type="submit" name="submit" value="Load" />';
			echo '	</select>';
			echo '</form>';


			if(isset($_POST['submit'])){
				$_SESSION['selected_store'] = $_POST['Store'];
				$_SESSION['selected_event'] = "";
			}
			for($i=0;$i<sizeof($stores);$i++){
				if(strcmp($_SESSION['selected_store'], $stores[$i]->Name) == 0){
					$curr = $i;
				}
			}
			echo '<a style="margin-top: 50px;margin-left: 50px;margin-right: 50px;">Current Store: </a>'.$_SESSION['selected_store'];
			# Description 
			echo '<h2 style="margin-bottom: 0;margin-left: 50px;">Description:</h2>
				<form id="store_description" method="POST" action="store_description.php">
					<div>
				 	<textarea style="font-size: 20px;margin-left: 50px;margin-right: 50px;" rows="4" cols="50" name="store_description">'.$stores[$curr]->Description.'</textarea>
						<br>
						<input type="hidden" name="store_id" value='.$stores[$curr]->ID.'>
						<input style="font-size: 18px;margin-left: 50px;background-color: #555555;color: #FFFFFF;" type="submit" value="Save Changes">
					</div>
				</form>';


			$query = "SELECT * FROM EVENT WHERE STORE_ID=\"".$stores[$curr]->ID."\"";
			$result = $mysql_con->query($query);
			$events = array();

			$curr_ev = 0;
			include 'Classes/event.php';
			while($row = $result->fetch_assoc()) {
				array_push($events, new Events($row['ID'], $row['EVENT_NAME'], $row['STORE_ID'], $row['START_DATE'], $row['END_DATE'], $row['DESCRIPTION']));
			}

			echo '<form style="margin-top: 50px;margin-left: 50px;margin-right: 50px;" method="POST">';
			echo '	<select name="Event">';
			for($i=0;$i<sizeof($events);$i++){
				echo 	'<option value="'.$events[$i]->Name.'">'.$events[$i]->Name.'</option>';
			}
			echo '	<input type="submit" name="submit_ev" value="Load" />';
			echo '	</select>';
			echo '</form>';


			if(isset($_POST['submit_ev'])){
				$_SESSION['selected_event'] = $_POST['Event'];	
			}
		
			for($i=0;$i<sizeof($events);$i++){
				if(strcmp($_SESSION['selected_event'], $events[$i]->Name) == 0){
					$curr_ev = $i;
				}
			}
				echo '<a style="margin-top: 50px;margin-left: 50px;margin-right: 50px;">Current Event: </a>'.$_SESSION['selected_event'];
				# Event 
			echo '<h2 style="margin-bottom: 0;margin-left: 50px;">Event:</h2>
				<form id="store_description" method="POST" action="event_description.php">
					<div>
				 	<textarea style="font-size: 20px;margin-left: 50px;margin-right: 50px;" rows="4" cols="50" name="event_description">'.$events[$curr_ev]->Description.'</textarea>
						<br>
						<input type="hidden" name="event_id" value='.$events[$curr_ev]->ID.'>
						<input style="font-size: 18px;margin-left: 50px;background-color: #555555;color: #FFFFFF;" type="submit" value="Save Changes">
					</div>
				</form>';
		


				# Map
				echo '<div class="topright" style="margin-top: 192px;margin-right: 34px">
					<b>Click to change address.</b>
					<div id="mapid"></div>
					<script src="https://unpkg.com/leaflet@1.4.0/dist/leaflet.js"
					   integrity="sha512-QVftwZFqvtRNi0ZyCtsznlKSWOStnDORoefr1enyq5mVL4tmKB3S/EnC3rRJcxCPavG10IcrVGSmPh6Qw5lwrg=="
					   crossorigin=""></script>
					<script>
						var mymap = L.map(\'mapid\').setView(['.$stores[$curr]->x.', '.$stores[$curr]->y.'], 13);

						L.tileLayer(\'http://{s}.tile.osm.org/{z}/{x}/{y}.png\', {
						        attribution: \'&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors\'
						    }).addTo(mymap);
						var marker = L.marker(['.$stores[$curr]->x.', '.$stores[$curr]->y.']).addTo(mymap);

						mymap.on(\'click\', function(ev){
							var latlng = mymap.mouseEventToLatLng(ev.originalEvent);
							console.log(latlng.lat + \', \' + latlng.lng);
							var xhttp = new XMLHttpRequest();
							xhttp.onreadystatechange = function() {
							    if (this.readyState == 4 && this.status == 200){
							    	console.log(JSON.parse(this.responseText));
							    }
							};
							xhttp.open("POST", "store_loc.php", false);
							xhttp.setRequestHeader(\'Content-Type\', \'application/x-www-form-urlencoded\');
							xhttp.send(\'x=\'+latlng.lat+\'&y=\'+latlng.lng+\'&id='.$stores[$curr]->ID.'\');
							setTimeout("location.reload(true);",10);
						});

					</script>
			</div>';	
		?>




		 <!-- The grid: four columns -->
		<div class="topright" style="margin-top: 600px;margin-right: 39px">
			<div class="column">
				<img src="Resources/example1.png" onclick="myFunction(this);">
			 </div>
			<div class="column">
				<img src="Resources/example2.png" onclick="myFunction(this);">
			</div>
			<div class="column">
				<img src="Resources/example3.png" onclick="myFunction(this);">
  			</div>
			<div class="column">
				<img src="Resources/example4.png" onclick="myFunction(this);">
			</div>
		</div>

		<!-- The expanding image container -->
		<div class="container">
			<!-- Close the image -->
			<span onclick="this.parentElement.style.display='none'" class="closebtn">&times;</span>

			<!-- Expanded image -->
			<img id="expandedImg" style="width:100%">

			<!-- Image text -->
			<div id="imgtext"></div>
		</div>
		<script>
			function myFunction(imgs) {
				// Get the expanded image
				var expandImg = document.getElementById("expandedImg");
				// Get the image text
				var imgText = document.getElementById("imgtext");
				// Use the same src in the expanded image as the image being clicked on from the grid
				expandImg.src = imgs.src;
				// Use the value of the alt attribute of the clickable image as text inside the expanded image
				imgText.innerHTML = imgs.alt;
				// Show the container element (hidden with CSS)
				expandImg.parentElement.style.display = "block";
			} 
		</script>

		<input class="topright" style="margin-top: 700px;margin-right: 34px;background-color: #555555;color: #FFFFFF;width: 10%;" type="submit" value="Upload Image">

		<input class="topright" style="margin-top: 800px;margin-right: 34px;background-color: #555555;color: #FFFFFF;width: 10%;" type="submit" value="Save Changes">
	</body>
</html>
