<?php

mysql_connect('localhost', 'root', '');

mysql_select_db('customer');

$sql="SELECT * FROM `order`";

$records = mysql_query($sql);

?>

<html>
<head><title>Orders Data</title></head>

<body>

	<center>List of Orders</center>
	
	
	<center><table width = "600" border = "1" cellpadding = "1" cellspacing = "1">
		
		<tr>
			<th>Order ID</th>
			<th>Menu</th>
			<th>Order Made by</th>
			<th>Order Quantity</th>
		<tr>
		
		<?php
			while($order=mysql_fetch_assoc($records)){
				
				echo "<tr>";
				
				echo "<td>".$order['order_id']."</td>";
				echo "<td>".$order['order_name']."</td>";
				echo "<td>".$order['order_cust']."</td>";
				echo "<td>".$order['quantity']."</td>";
				echo "<td><a href='Delete_Order.php?del=$order[order_id]'>Delete</a></td>";

				echo"</tr>";
				
			}
		?>
		
	</table></center>

</body>
</html>