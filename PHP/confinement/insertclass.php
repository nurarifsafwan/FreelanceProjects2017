<?php
    $con = mysqli_connect("localhost", "root", "", "confinement");
    
    $name = $_POST["name"];
	$description = $_POST["description"];
    $idlady = $_POST["idlady"];
    $region = $_POST["region"];
    $phone = $_POST["phone"];

    $statement = mysqli_prepare($con, "INSERT INTO unpackage (name, description, idlady, region, phone) VALUES (?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssiss", $name, $description, $idlady, $region, $phone);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>
