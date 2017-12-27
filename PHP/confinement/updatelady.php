<?PHP
include_once("connection.php");

if(isset($_POST['mobile']) && $_POST['mobile'] == "android" && 
   isset($_POST['idlady']) && isset($_POST['phone']) && 
   isset($_POST['address'])){
    
    $iduser = $_POST['idlady'];
    $phone = $_POST['phone'];
    $address = $_POST['address'];

    $query = "UPDATE lady 
        SET phone='$phone', address=$address, idlady=$idlady
        WHERE idlady=$idlady";
    
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