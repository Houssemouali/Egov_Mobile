<?php
require_once('connect.php');



$CIN=$_GET['cin'];

$Type=$_GET['Type'];
$Montant=$_GET['Montant'];
$PayerAvant=$_GET['PayerAvant'];
$query_search = "SELECT `id` FROM `cin` where num_cin='".$CIN."' ;";  

$found = mysqli_query($conn,$query_search);

if($found != FALSE){
	$idcin =mysqli_fetch_array($found)[0];
$sql = "INSERT INTO facture ( cin,Type,Montant,PayerAvant) VALUES ( '$idcin','$Type','$Montant','$PayerAvant')";

if (mysqli_query($conn, $sql)) {
    echo "successfully added";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}
}
mysqli_close($conn);
?>