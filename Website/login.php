<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	</head>
<?php
	//Start Session
	session_start();

	//If username is set, user is logged in
	if (isset($_SESSION['session_username']))
	{
		header('location: UpdatePage.php');
		exit();
	}
	//If not check form
	else
	{
		//Check form info with database
		//TO-DO Check with DB
		$db_server["host"] = "localhost"; //database server
		$db_server["username"] = "softeng"; // DB username
		$db_server["password"] = "softeng"; // DB password
		$db_server["database"] = "RESERVE";// database name

		$mysql_con = mysqli_connect($db_server["host"], $db_server["username"], $db_server["password"], $db_server["database"]);
		$mysql_con->query ('SET CHARACTER SET utf8');
		$mysql_con->query ('SET COLLATION_CONNECTION=utf8_unicode_ci');

		$query = "SELECT * FROM OWNER WHERE username=\"".$_POST['username']."\" AND password=\"".$_POST['password']."\"";
		$result = $mysql_con->query($query);
		$mysql_con->close();
		if ($result->num_rows==0)
		{
			//If not prompt user that his login info is incorrect
			echo "<h1>Wrong login info!</h1>";
			header('location: index.php');
			exit();
		}
		else
		{
			//Create session for user
			$_SESSION['session_username'] = $_POST['username'];
			header('location: UpdatePage.php');
			exit();
		}
	}
?>
</html>


	