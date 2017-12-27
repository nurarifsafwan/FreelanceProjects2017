<?php
    $con = mysqli_connect("localhost", "root", "", "confinement");
    
    $name = $_POST["name"];
	$description = $_POST["description"];
    $idlady = $_POST["idlady"];
    $region = $_POST["region"];
    $phone = $_POST["phone"];
	$iduser = $_POST["iduser"];

    $statement = mysqli_prepare($con, "INSERT INTO package (name, description, region, idlady, iduser, phone) VALUES (?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sssiis", $name, $description, $region, $idlady, $iduser, $phone);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>