<?php
require_once('connect.php');



$numcp=$_GET['num_compte'];
$cin=$_GET['cin'];
$montant=$_GET['montant'];
$query_search = "SELECT `id` FROM `cin` where num_cin='".$cin."' ;";  

$found = mysqli_query($conn,$query_search);

if($found != FALSE){
	$idcin =mysqli_fetch_array($found)[0];

$sql = "INSERT INTO compte ( num_compte,cin,montant) VALUES 
( '$numcp','$idcin','$montant')";

if (mysqli_query($conn, $sql)) {
    echo "Succes d ajout!!";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}
}
mysqli_close($conn);
?>