<?php   
      require_once('connect.php'); 
  
      mysqli_select_db($conn, $dbname);
	
      $query_search = "SELECT * FROM demandeextrait";  
      $query_exec = mysqli_query($conn, $query_search)or die(mysql_error());  
      
if($query_exec!=null){  
      $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
      $root_element = "demandeextrait"; 
      $xml .= "<$root_element>";
	while($result_array = mysqli_fetch_assoc($query_exec))
     {
      $xml .= "<demandeextrait ";
 
      foreach($result_array as $key => $value)
      {
		 
         //$key holds the table column name
         $xml .= " $key=\"$value\"";
 
         //embed the SQL data in a CDATA element to avoid XML entity issues
         $xml .= ""; 
      }
 
      $xml.="></demandeextrait>";
    }
//close the root element
$xml .= "</$root_element>";

//send the xml header to the browser
header ("Content-Type:text/xml"); 
 
//output the XML data
echo $xml;
 }  
 ?> 