<?php
    $con = mysqli_connect("localhost", "root", "", "tutortoyou");
    
    $name = $_POST["name"];
	$description = $_POST["description"];
    $idtutor = $_POST["idtutor"];
    $region = $_POST["region"];
    $phone = $_POST["phone"];

    $statement = mysqli_prepare($con, "INSERT INTO unclass (name, description, idtutor, region, phone) VALUES (?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssiss", $name, $description, $idtutor, $region, $phone);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>
