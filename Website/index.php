<!DOCTYPE html>
<html lang="en">
	<title>Reserve!</title>
	<meta charset="UTF-8">
	<style>
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
	</style>
	<body>
		<!-- Title -->
		<h1 style="margin-top: 0;margin-bottom: 0;">Reserve</h1>
		<h2 style="margin-top: 0;margin-bottom: 0;margin-left: 5px;font-weight: normal;color: #777777;">Reserve seats in your favorite stores<br> in real time.</h2>

		<!-- Log In -->
		<form class="topright" name="login_form" method="POST" action="login.php">
			<h5 style="margin-top: 0;margin-bottom: 0;font-weight: normal;">Login:</h5>
			<input style="width: 100%;" type="text" name="username" placeholder="Username"><br>
			<input style="width: 100%;" type="password" name="password" placeholder="Password"><br>
			<input style="width: 100%;background-color: #555555;color: #FFFFFF;" type="submit" value="Login">
		</form>

		<!-- Navbar -->
		<ul>
			<li><a href="#" >Home</a></li>
			<li><a href="#" >News</a></li>
			<li><a href="#" >Contact</a></li>
			<li><a href="#" >About Us</a></li>
		</ul>

		<!-- Description -->
		<h2 style="margin-bottom: 0;margin-left: 50px;">Description</h2>
		<div>
			<p style="font-size: 20px;margin-left: 50px;margin-right: 50px;">
				<?php 
					echo file_get_contents("Description.txt");
				?>
			</p>
		</div>
	</body>
</html>
