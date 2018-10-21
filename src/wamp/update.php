<?php
require_once('connect.php');



$nom=$_GET['nom'];
$prenom=$_GET['prenom'];
$sql = " UPDATE `espritbd.personne` SET `nom`=".$nom.", `prenom`=".$prenom."where`id`=1";

if (mysqli_query($personne, $sql)) {
    echo "successfully mofided";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);