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

	}
	</style>
	<body>
		<!-- Title -->
		<h1 style="margin-top: 0;margin-bottom: 0;">Reserve</h1>
		<h2 style="margin-top: 0;margin-bottom: 0;margin-left: 5px;font-weight: normal;color: #777777;">Reserve seats in your favorite stores<br> in real time.</h2>

		<!-- Log In -->
		<?php
		 	session_start();
			if(!isset($_SESSION['session_username'])){
				echo '<form class="topright" name="login_form" method="POST" action="login.php">
						<h5 style="margin-top: 0;margin-bottom: 0;font-weight: normal;">Login:</h5>
						<input style="width: 100%;" type="text" name="username" placeholder="Username"><br>
						<input style="width: 100%;" type="password" name="password" placeholder="Password"><br>
						<input style="width: 100%;background-color: #555555;color: #FFFFFF;" type="submit" value="Login">
					</form>';
			}else{
				echo '<div class="topright">
						<h3 style="margin-top: 0;margin-bottom: 0px;font-weight: normal;">Welcome, <b>'.$_SESSION['session_username'].'</b>!</h3>
						<img src="profile.jpg" class="profile_pic">
					</div>
					<br><a style="top: 80px;" class="topright" href=\'logoff.php\'>Log off</a>';
			}
		?>

		<!-- Navbar -->
		<ul>
			<li><a href="index.php" >Home</a></li>
			<li><a href="news.php" >News</a></li>
			<li><a href="contact.php" >Contact</a></li>
			<li><a href="about_us.php" >About Us</a></li>
			<?php
				if(isset($_SESSION['session_username'])){
					echo '<li><a href="UpdatePage.php" >Update Page</a></li>';
				}
			?>	
		</ul>

		<!-- News -->
		<h2 style="margin-bottom: 0;margin-left: 50px;">News</h2>
		<div>
			<p style="font-size: 20px;margin-left: 50px;margin-right: 50px;">
				<?php 
					echo file_get_contents("Resources/News.txt");
				?>
			</p>
		</div>
	</body>
</html>
