<?php
 	session_start();
	if(!isset($_SESSION['session_username'])){
		header("location: index.php");
		exit();
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
		<h2 style="margin-top: 0;margin-bottom: 0;margin-left: 5px;font-weight: normal;color: #777777;">Reserve seats on your favorite stores<br> in real time.</h2>

		<!-- Profile -->
		<div class="topright">
			<h3 style="margin-top: 0;margin-bottom: 0px;font-weight: normal;">Welcome, <b><?php echo $_SESSION['session_username'];?></b>!</h3>
			<img src="profile.jpg" class="profile_pic">
		</div>

			<br><a style="top: 80px;" class="topright" href='logoff.php'>Log off</a>
		<!-- Navbar -->
		<ul>
			<li><a href="index.php" >Home</a></li>
			<li><a href="#" >News</a></li>
			<li><a href="#" >Contact</a></li>
			<li><a href="#" >About Us</a></li>
			<li><a href="UpdatePage.php" >Update Page</a></li>
		</ul>

		<!-- Drop down list -->
		<form style="margin-top: 50px;margin-left: 50px;margin-right: 50px;"action="/action_page.php">
			<select name="cars">
				<option value="volvo">Volvo</option>
				<option value="saab">Saab</option>
				<option value="fiat">Fiat</option>
				<option value="audi">Audi</option>
			</select>
		</form>

		<!-- Description -->
		<h2 style="margin-bottom: 0;margin-left: 50px;">Description:	</h2>
		<div>
			<textarea style="font-size: 20px;margin-left: 50px;margin-right: 50px;" rows="4" cols="50">This is where the store page description goes.</textarea> 
		</div>

		<!-- Address -->
		<h2 style="margin-bottom: 0;margin-left: 50px;">Address:</h2>
		<div style="font-size: 20px;margin-left: 50px;margin-right: 50px;">
			<input type="address" name="address" placeholder="Address, City"><br>
		</div>

		<!-- Schedule -->
		<h2 style="margin-bottom: 0;margin-left: 50px;">Schedule:</h2>
		<div>
			<div style="font-size: 20px;margin-left: 50px;" rows="7" cols="11">
				<p>
					<label>Monday:</label>
					<input type="address" name="address" placeholder="hh:mm-hh:mm">
				</p>
				<p>
					<label>Tuesday:</label>
					<input type="address" name="address" placeholder="hh:mm-hh:mm">
				</p>
				<p>
					<label>Wednesday:</label>
					<input type="address" name="address" placeholder="hh:mm-hh:mm">
				</p>
				<p>
					<label>Thursday:</label>
					<input type="address" name="address" placeholder="hh:mm-hh:mm">
				</p>
				<p>
					<label>Friday:</label>
					<input type="address" name="address" placeholder="hh:mm-hh:mm">
				</p>
				<p>
					<label>Saturday:</label>
					<input type="address" name="address" placeholder="hh:mm-hh:mm">
				</p>
				<p>
					<label>Sunday:</label>
					<input type="address" name="address" placeholder="hh:mm-hh:mm">
				</p>
			</div> 
		</div>

		<!-- Events -->
		<h2 style="margin-bottom: 0;margin-left: 50px;">Events:</h2>
		<div>
			<textarea style="font-size: 20px;margin-left: 50px;margin-right: 50px;" rows="4" cols="50">This is where the event description goes.</textarea> 
		</div>

		<!-- Map -->
		<div class="topright" style="margin-top: 192px;margin-right: 34px">
			<div id="mapid"></div>
			<script src="https://unpkg.com/leaflet@1.4.0/dist/leaflet.js"
			   integrity="sha512-QVftwZFqvtRNi0ZyCtsznlKSWOStnDORoefr1enyq5mVL4tmKB3S/EnC3rRJcxCPavG10IcrVGSmPh6Qw5lwrg=="
			   crossorigin=""></script>
			<script>
				var map;
				var marker;

				mymap = L.map('mapid').setView([51.505, -0.09], 13);
				mymap.on('click', function(ev){
				  var latlng = mymap.mouseEventToLatLng(ev.originalEvent);
				  x= latlng.lat;
				  y= latlng.lng;
				  console.log(latlng.lat + ', ' + latlng.lng);
				});
				L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
				        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
				    }).addTo(mymap);
				marker = L.marker([51.505, -0.09]).addTo(mymap);
			</script>
		</div>

		 <!-- The grid: four columns -->
		<div class="topright" style="margin-top: 592px;margin-right: 39px">
			<div class="column">
				<img src="example1.png" onclick="myFunction(this);">
			 </div>
			<div class="column">
				<img src="example2.png" onclick="myFunction(this);">
			</div>
			<div class="column">
				<img src="example3.png" onclick="myFunction(this);">
  			</div>
			<div class="column">
				<img src="example4.png" onclick="myFunction(this);">
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
