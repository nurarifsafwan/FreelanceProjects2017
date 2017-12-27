<?php
    $con = mysqli_connect("localhost", "root", "", "tutortoyou");
    
    $username = $_POST["username"];
	$password = $_POST["password"];
    $name = $_POST["name"];
    $email = $_POST["email"];
    $phone = $_POST["phone"];

    $statement = mysqli_prepare($con, "INSERT INTO student (username, password, name, email, phone) VALUES (?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sssss", $username, $password, $name, $email, $phone);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>
