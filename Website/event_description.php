<?php
	$id = $_POST['event_id'];
	$description = $_POST['event_description'];


	$db_server["host"] = "localhost"; //database server
	$db_server["username"] = "softeng"; // DB username
	$db_server["password"] = "softeng"; // DB password
	$db_server["database"] = "RESERVE";// database name

	$mysql_con = mysqli_connect($db_server["host"], $db_server["username"], $db_server["password"], $db_server["database"]);
	$mysql_con->query ('SET CHARACTER SET utf8');
	$mysql_con->query ('SET COLLATION_CONNECTION=utf8_unicode_ci');

	$query = "UPDATE EVENT SET DESCRIPTION=\"".$description."\" WHERE ID=\"".$id."\"";
	$result = $mysql_con->query($query);
	$mysql_con->close();
	header('location: UpdatePage.php');
	exit();
?>