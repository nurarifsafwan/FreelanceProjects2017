<?php
    $con = mysqli_connect("localhost", "root", "", "customer");
    
    $name = $_POST["name"];
    $username = $_POST["username"];
    $password = $_POST["password"];
	$email = $_POST["email"];
	$phonenumber = $_POST["phonenumber"];

    $statement = mysqli_prepare($con, "INSERT INTO user (username, name, password, email, phonenumber) VALUES (?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sssss", $username, $name, $password, $email, $phonenumber);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>
