<?php

mysql_connect('localhost', 'root', '');

mysql_select_db('customer');

$sql="SELECT * FROM reservation";

$records = mysql_query($sql);

?>

<html>
<head><title>Reservations Data</title></head>

<body>

	<center>List of Reservations</center>
	
	
	<center><table width = "600" border = "1" cellpadding = "1" cellspacing = "1">
		
		<tr>
			<th>Reservation ID</th>
			<th>Username</th>
			<th>Reservation Date</th>
			<th>Reservation Time</th>
			<th>Person Booked</th>
		<tr>
		
		<?php
			while($reservation=mysql_fetch_assoc($records)){
				echo "<tr>";
				
					echo "<td>".$reservation['reserve_id']."</td>";
					echo "<td>".$reservation['user_id']."</td>";
					echo "<td>".$reservation['date']."</td>";
					echo "<td>".$reservation['time']."</td>";
					echo "<td>".$reservation['pax']."</td>";
					echo "<td><a href='Delete.php?del=$reservation[reserve_id]'>Delete</a></td>";

					
				echo "</tr>";
			}
		?>
		
	</table></center>

</body>
</html>