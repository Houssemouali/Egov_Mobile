<?php
require_once('connect.php');



$nom=$_GET['nom'];
$prenom=$_GET['prenom'];
$cinpere=$_GET['cinpere'];
$cinmere=$_GET['cinmere'];
$lieu=$_GET['lieu'];
$dat=$_GET['dat'];

$sql = "INSERT INTO demandeextrait ( nom, prenom, lieu_naissance, date_naissance, cin_pere, cin_mere, etat, commentaire) VALUES ('$nom', '$prenom', '$lieu', '$dat', '$cinpere', '$cinmere', 'En Cours', 'vvv')";

if (mysqli_query($conn, $sql)) {
    echo "successfully added";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>