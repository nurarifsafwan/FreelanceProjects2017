<?php
    $con = mysqli_connect("localhost", "root", "", "tutortoyou");
    
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM tutor WHERE username = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $idtutor, $username, $password, $name, $email, $phone);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
		$response["idtutor"] = $idtutor;
        $response["username"] = $username;
        $response["password"] = $password;
        $response["name"] = $name;
        $response["email"] = $email;
		$response["phone"] = $phone;
    }
    
    echo json_encode($response);
?>
