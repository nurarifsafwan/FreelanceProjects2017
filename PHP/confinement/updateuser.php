<?PHP
include_once("connection.php");

if(isset($_POST['mobile']) && $_POST['mobile'] == "android" && 
   isset($_POST['iduser']) && isset($_POST['phone']) && 
   isset($_POST['address'])){
    
    $iduser = $_POST['iduser'];
    $phone = $_POST['phone'];
    $address = $_POST['address'];

    $query = "UPDATE user 
        SET phone='$phone', address=$address, iduser=$iduser
        WHERE iduser=$iduser";
    
    $result = mysqli_query($conn, $query);

    if($result > 0){
        echo "success";
        exit;
    }
    else{
        echo "failed";
        exit;
    }
}    
?>