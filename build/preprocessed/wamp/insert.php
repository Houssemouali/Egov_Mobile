<?php
require_once('connect.php');



$CIN=$_GET['cin'];
$CarteGrise=$_GET['CarteGrise'];
$cpp=$_GET['cpp'];
$FinAutorisation=$_GET['FinAutorisation'];
$query_search0 = "SELECT `id` FROM `cin` where num_cin='".$CIN."' ;";
$query_search1 = "SELECT `id` FROM `compte` where num_compte='".$cpp."' ;";

$found0 = mysqli_query($conn,$query_search0);
$found1 = mysqli_query($conn,$query_search1);

if($found0 != FALSE and $found1 != FALSE ){
	$idcin =mysqli_fetch_array($found0)[0];
	$idcompte =mysqli_fetch_array($found1)[0];
$sql = "INSERT INTO autorisationcirculation ( cin,CarteGrise,cpp,FinAutorisation) VALUES ( '$idcin','$CarteGrise','$idcompte','$FinAutorisation')";

if (mysqli_query($conn, $sql)) {
    echo "successfully added";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}
}
mysqli_close($conn);
?>