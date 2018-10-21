<?php
require_once('connect.php');



$sql = "SELECT * FROM facture";
$result = $conn->query($sql);
$xml = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $mydata = $xml->addChild('facture');
        $mydata->addChild('id',$row['id']);
        $mydata->addChild('cin',$row['cin']);
	
        
         }
} else {
    echo "0 results";
}
$conn->close();
header ("Content-Type:text/xml");
	echo($xml->asXML());
?>