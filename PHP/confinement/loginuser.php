<?php
    $con = mysqli_connect("localhost", "root", "", "confinement");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $iduser, $username, $password, $name, $phone, $address);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
		$response["iduser"] = $iduser;
        $response["username"] = $username;
        $response["password"] = $password;
        $response["name"] = $name;
        $response["phone"] = $phone;
		$response["address"] = $address;
    }
    
    echo json_encode($response);
?>
