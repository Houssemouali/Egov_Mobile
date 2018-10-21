<?php
require_once('connect.php');



$sql = "SELECT sum(case when Type = 'STEG' then 1 else 0 end) STEG,
  sum(case when Type = 'SONEDE' then 1 else 0 end) SONEDE,
  count(*)TOTAL	
FROM  facture";
$result = $conn->query($sql);
$xml = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $mydata = $xml->addChild('facturetype');
        $mydata->addChild('STEG',$row['STEG']);
        $mydata->addChild('SONEDE',$row['SONEDE']);
		 $mydata->addChild('TOTAL',$row['TOTAL']);
	
        
         }
} else {
    echo "0 results";
}
$conn->close();
header ("Content-Type:text/xml");
	echo($xml->asXML());
?>