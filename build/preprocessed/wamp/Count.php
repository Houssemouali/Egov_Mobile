<?php
require_once('connect.php');


$sql = "SELECT sum(case when Type = 'STEG' then 1 else 0 end) STEG,
  sum(case when Type = 'SONEDE' then 1 else 0 end) SONEDE,
  count(*)TOTAL	
FROM  facture";
$STEG=$_SET['STEG'];
$SONEDE=$_SET['SONEDE'];
$TOTAL=$_SET['TOTAL'];





mysqli_close($conn);
?>




