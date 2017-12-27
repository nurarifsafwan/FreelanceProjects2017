<?php
    $con = mysqli_connect("localhost", "root", "", "tutortoyou");
    
    $name = $_POST["name"];
	$description = $_POST["description"];
    $region = $_POST["region"];
    $phone = $_POST["phone"];
	$idstudent = $_POST["idstudent"];
	$idtutor = $_POST["idtutor"];

    $statement = mysqli_prepare($con, "INSERT INTO class (name, description, region, phone, idstudent, idtutor) VALUES (?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssssii", $name, $description, $region, $phone, $idstudent, $idtutor);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>