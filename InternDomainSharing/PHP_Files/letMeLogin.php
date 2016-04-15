<?php
  if( $_POST["username"] || $_POST["password"] )
  {
     $con=mysqli_connect("mysql","hardik7p","root123","mysql");
     if (mysqli_connect_errno())
     {
         echo "Something went wrong...Try after sometime..";
//        echo "Failed to connect to MySQL: " . mysqli_connect_error();
     }
     $user_name=$_POST['username'];
     $user_pass=$_POST['password'];
     $result = mysqli_query($con,"SELECT username,password FROM registered_members where username='$user_name' and password='$user_pass'"); 
     while($row = mysqli_fetch_array($result))
     {
                $user=$row["username"];
		$pass=$row["password"];
     }
     if($user_name==$user && $user_pass==$pass)
     {
       echo "OK";
     }
     else
     {
       echo "I dont Know You";
        exit();
     }

   }
?>
