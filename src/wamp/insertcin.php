<?php
require_once('connect.php');



$nom=$_GET['nom'];
$prenom=$_GET['prenom'];
//$datenaissance=$_GET['date_naissance'];
$adresse=$_GET['adresse'];
$profession=$_GET['profession'];
$lieu=$_GET['lieucreation'];
$datecreation=$_GET['datecreation'];
$numcin=$_GET['num_cin'];

$query_search = "SELECT `id` FROM `extraitnaissances` where nom='".$nom."' and prenom='".$prenom."';";  

$found = mysqli_query($conn,$query_search);

if($found != FALSE){
	$id_extrait =mysqli_fetch_array($found)[0];
	$sql = "INSERT INTO cin ( extrait,adresse,profession,lieu_creation,date_creation,num_cin) VALUES 
	( '$id_extrait','$adresse','$profession','$lieu','$datecreation','$numcin')";

	if (mysqli_query($conn, $sql)) {
	    echo "Succesfully added!!";
	} else {
	    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
	}
}else{
	echo "Extrait de naissance invalide";
}

mysqli_close($conn);
?>