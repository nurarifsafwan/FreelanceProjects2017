<?php
    $con = mysqli_connect("localhost", "root", "", "customer");
    
    $order_name = $_POST["order_name"];
    $order_cust = $_POST["order_cust"];
    $quantity = $_POST["quantity"];

    $statement = mysqli_prepare($con, "INSERT INTO order (order_name, order_cust, quantity) VALUES (?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sss", $order_name, $order_cust, $quantity);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>