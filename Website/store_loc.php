<?php
	$x = $_POST['x'];
	$y = $_POST['y'];
	$id = $_POST['id'];

	$db_server["host"] = "localhost"; //database server
	$db_server["username"] = "softeng"; // DB username
	$db_server["password"] = "softeng"; // DB password
	$db_server["database"] = "RESERVE";// database name

	$mysql_con = mysqli_connect($db_server["host"], $db_server["username"], $db_server["password"], $db_server["database"]);
	$mysql_con->query ('SET CHARACTER SET utf8');
	$mysql_con->query ('SET COLLATION_CONNECTION=utf8_unicode_ci');

	$query = "UPDATE STORE SET X=".$x." , Y=".$y." WHERE ID=\"".$id."\"";
	$result = $mysql_con->query($query);
	$mysql_con->close();
	echo json_encode($result);
?>