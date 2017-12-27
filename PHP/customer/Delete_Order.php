<?php

mysql_connect('localhost', 'root', '');

mysql_select_db('customer');

if( isset($_GET['del'])){
	$order_id = $_GET['del'];
	$sql= "DELETE FROM `order` WHERE order_id='$order_id'";
	$res = mysql_query($sql) or die ("Failed".mysql_error());
	echo "<meta http-equiv='refresh' content='0;url=Customer_Order.php'>";
}

?>