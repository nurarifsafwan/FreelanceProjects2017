<?php
    $con = mysqli_connect("localhost", "root", "", "customer");
    
    $query = "SELECT * FROM menu ORDER BY menu_id DESC";
	
	$result = mysqli_query($con, $query);
	
	while($row = mysqli_fetch_assoc($result)){
		$data[] = $row;
	}
    
    echo json_encode($data);
?>