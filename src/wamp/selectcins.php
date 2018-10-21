<?php
require_once('connect.php');



$sql = "SELECT * FROM cin";
$result = $conn->query($sql);
$xml = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $mydata = $xml->addChild('cin');
        $mydata->addChild('id',$row['id']);
        $mydata->addChild('num_cin',$row['num_cin']);
        
         }
} else {
    echo "0 results";
}
$conn->close();
header ("Content-Type:text/xml");
	echo($xml->asXML());
?>