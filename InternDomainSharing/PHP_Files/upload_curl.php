<html>
<head>

<title>Untitled</title>

</head>
<body>

<?php

$uploadpath = "uploads/";
$filedata = $_FILES['filedata']['tmp_name'];
$filename = $_POST['filename'];
if ($filedata != '' && $filename != '')
    copy($filedata,$uploadpath.$filename);



?>

</body>
</html>