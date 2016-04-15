<?php

// Create connection servername,db username, db password, database naem
$con=mysqli_connect("mysql","hardik7p","root123","mysql");

// Check connection
if (mysqli_connect_errno())
{
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

//inserting record
if(isset($_POST) && !empty($_POST))
{
	$firstname=isset($_POST['fname']) ? $_POST['fname']:null;
	$lastname=isset($_POST['lname']) ? $_POST['lname']:null;
	$email=isset($_POST['email']) ? $_POST['email']:null;
	$username=isset($_POST['username']) ? $_POST['username']:null;
        $password=isset($_POST['password']) ? $_POST['password']:null;       
}
if($firstname==null || $lastname==null || $email==null || $username==null || $password==null)
{
	echo "Fill all fields, Jim..!";
	exit();
} 

$result = mysqli_query($con,"SELECT username,email FROM registered_members where username='$username' and email='$email'"); 

while($row = mysqli_fetch_array($result))
{
        $ex_username=$row["username"];
	$ex_email=$row["email"];
}
if($ex_usernmae==$username)
{
       echo "username already registered..try new one..!";
       exit();
}
else if($ex_email==$email)
{
	echo "emailid already registered with us...!";
    	exit();
}
$confirm_code=md5(uniqid(rand())); 
$sql="INSERT INTO temp_members_db(confirm_code, firstname, lastname, email, username, password)
	VALUES
	('$confirm_code','$firstname','$lastname','$email','$username','$password')";

if (!mysqli_query($con,$sql))
{
	echo "Something went wrog...Cannot register at this moment..Try Again.";
    	die('Error: ' . mysqli_error($con));
}
else
{
	$to=$email;

	// Your subject
	$subject="Your confirmation link here";

	// From
	$header="from:admin@cloud-hp.com";
	
	// Your message
	$message="Your Comfirmation link \r\n";
	$message.="Click on this link to activate your account \r\n";
	$message.="http://www.cloud-hp.com/confirmation.php?passkey=$confirm_code";

	// send email
	$sentmail = mail($to,$subject,$message,$header);
	if($sentmail){
		echo "A Confirmation Link Has Been Sent To Your Email Address. Kindly Confirm.";
	}
	else
	{
		echo "Cannot send Confirmation Link to your e-mail address";
	}
}
?>