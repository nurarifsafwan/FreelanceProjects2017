<?php
    $con = mysqli_connect("localhost", "root", "", "customer");
    
	$user_id = $_POST["user_id"];
	$time = $_POST["time"];
    $date = $_POST["date"];
	$pax = $_POST["pax"];

    $statement = mysqli_prepare($con, "INSERT INTO reservation (user_id, date, time, pax) VALUES (?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "iiii", $user_id, $date, $time, $pax, $email, $phonenumber);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true; 
    
    echo json_encode($response);
?>