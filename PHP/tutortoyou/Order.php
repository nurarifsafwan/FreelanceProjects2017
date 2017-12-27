<?php
    $con = mysqli_connect("localhost", "root", "", "ladycon");
    
    $customer_id = $_POST["customer_id"];
	$menu_id = $_POST["menu_id"];
    $quantity = $_POST["quantity"];

    $statement = mysqli_prepare($con, "INSERT INTO order (customer_id, menu_id, quantity) VALUES ($customer_id, $menu_id, $quantity)");
    mysqli_stmt_bind_param($statement, "iii", $customer_id, $menu_id, $quantity);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>
