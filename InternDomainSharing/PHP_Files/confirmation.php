<?php

$passkey=$_GET['passkey'];
$con=mysqli_connect("mysql","hardik7p","root123","mysql");
if (mysqli_connect_errno())
{
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$result1 = mysqli_query($con,"SELECT * FROM temp_members_db WHERE confirm_code='$passkey'"); 
while($row = mysqli_fetch_array($result1))
{
                $code=$row["confirm_code"];
                $firstname=$row["firstname"];
                $lastname=$row["lastname"];
                $email=$row["email"];
                $username=$row["username"];
	        $password=$row["password"];
}
if($code==$passkey)
{
	$result2 = mysqli_query($con,"INSERT INTO registered_members(firstname, lastname, email, username, password) VALUES('$firstname','$lastname','$email','$username','$password')"); 
		
        if($result2)
	{
		echo "Your account has been activated";
               $result3 = mysqli_query($con,"DELETE FROM temp_members_db WHERE confirm_code = '$passkey'"); 
	}
	else
	{
		echo "Something went wrong. User Activated";
	}
}
else
{
	echo "Wrong Confirmation code.";
}
?>
