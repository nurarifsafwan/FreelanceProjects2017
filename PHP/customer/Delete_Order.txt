<?php

mysql_connect('localhost', 'root', '');

mysql_select_db('customer');

if( isset($_GET['del'])){
	$reserve_id = $_GET['del'];
	$sql= "DELETE FROM reservation WHERE reserve_id='$reserve_id'";
	$res = mysql_query($sql) or die ("Failed".mysql_error());
	echo "<meta http-equiv='refresh' content='0;url=Display_Reservations.php'>";
}

?>