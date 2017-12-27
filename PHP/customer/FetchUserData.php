<?php
	$con = mysqli_connect ("localhost", "root", "", "customer");
	
	$username = $_POST["username"];
	$password = $_POST["password"];
	
	$statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND = ?");
	mysqli_stmt_bind_param($statement, "ss", $username, $password);
	
	mysqli_stmt_store_result($statement);
	mysqli_stmt_bind_result($statement, $userID, $username, $name, $password, $email, $phonenumber);
	
	$user = array();
	
	while(mysqli_stmt_fetch($statement){
		$user[name] = $name;
		$user[email] = $email;
		$user[phonenumber] = $phonenumber;
		$user[username] = $username;
		$user[password] = $password;
	}
	
	echo json_encode($user);
	mysqli_stmt_close($statement);
	
	mysqli_close($con);
?>	
