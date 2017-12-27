<?php
    $con = mysqli_connect("localhost", "root", "", "customer");
    
    $user_id = $_POST["user_id"];
    $date = $_POST["date"];
    $time = $_POST["time"];
	$pax = $_POST["pax"];

    $statement = mysqli_prepare($con, "INSERT INTO reservation (user_id, date, time, pax) VALUES (?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssss", $user_id, $date, $time, $pax);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>