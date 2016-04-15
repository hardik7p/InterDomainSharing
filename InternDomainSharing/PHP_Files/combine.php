<?php
$pathToImages="uploads/";
$pathToThumbs="uploads/thumbs/";
$thumbWidth =250;
  
$dir = opendir( $pathToImages );

while (false !== ($fname = readdir( $dir )))
{
    
    $info = pathinfo($pathToImages . $fname);


    if ( strtolower($info['extension']) == 'jpg' ||  strtolower($info['extension']) == 'png' || strtolower($info['extension']) == 'JPG' || strtolower($info['extension']) == 'jpeg' || strtolower($info['extension']) == 'gif') 
    {

      $img = imagecreatefromjpeg( "{$pathToImages}{$fname}" );
      $width = imagesx( $img );
      $height = imagesy( $img );
      $new_width = $thumbWidth;
      $new_height = floor( $height * ( $thumbWidth / $width ) );
      $tmp_img = imagecreatetruecolor( $new_width, $new_height );
      imagecopyresized( $tmp_img, $img, 0, 0, 0, 0, $new_width, $new_height, $width, $height );
      imagejpeg( $tmp_img, "{$pathToThumbs}{$fname}" );

    }
}

closedir( $dir );

// Make a Gallery

$pathToImages="uploads/";
$pathToThumbs="uploads/thumbs/";

//echo "Creating gallery.html <br />";

$output = "<html>";
$output .= "<head><title>Thumbnails</title></head>";
$output .= "<body>";
$output .= "<table cellspacing=\"0\" cellpadding=\"2\" width=\"500\">";
$output .= "<tr>";

$dir = opendir( $pathToThumbs );

$counter = 0;
  
while (false !== ($fname = readdir($dir)))
{
 
    if ($fname != '.' && $fname != '..') 
    {
      $output .= "<td valign=\"middle\" align=\"center\"><a href=\"{$pathToImages}{$fname}\">";
      $output .= "<img src=\"{$pathToThumbs}{$fname}\" border=\"0\" />";
      $output .= "</a></td>";

      $counter += 1;
      if ( $counter % 5 == 0 ) { $output .= "</tr><tr>"; }
    }
}

closedir( $dir );

$output .= "</tr>";
$output .= "</table>";
$output .= "</body>";
$output .= "</html>";

$fhandle = fopen( "gallery.html", "w" );
fwrite( $fhandle, $output ); 
fclose( $fhandle );


header("Location: gallery.html");
	exit;

?>