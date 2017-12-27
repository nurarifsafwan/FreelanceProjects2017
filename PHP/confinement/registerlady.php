<?php
    $con = mysqli_connect("localhost", "root", "", "confinement");
    
    $username = $_POST["username"];
	$password = $_POST["password"];
    $name = $_POST["name"];
    $phone = $_POST["phone"];
    $address = $_POST["address"];

    $statement = mysqli_prepare($con, "INSERT INTO lady (username, password, name, phone, address) VALUES (?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sssss", $username, $password, $name, $phone, $address);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>
