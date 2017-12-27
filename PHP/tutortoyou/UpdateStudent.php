<?PHP
include_once("connection.php");

if(isset($_POST['mobile']) && $_POST['mobile'] == "android" && 
   isset($_POST['idstudent']) && isset($_POST['email']) && 
   isset($_POST['phone'])){
    
    $idstudent = $_POST['idstudent'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];

    $query = "UPDATE student 
        SET email='$email', phone=$phone, idstudent=$idstudent
        WHERE idstudent=$idstudent";
    
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