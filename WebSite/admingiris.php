<!DOCTYPE html>
<html>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Add icon library -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<style>
		body {
			background-image: url(img/laptops.jpg);
			background-size: cover;
			background-position: center;
			background-attachment: fixed;
		}
		}

		body {
			font-family: Arial, Helvetica, sans-serif;
		}

		* {
			box-sizing: border-box;
		}

		.input-container {
			display: -ms-flexbox;
			/* IE10 */
			display: flex;
			width: 100%;
			margin-bottom: 15px;
		}

		.icon {
			padding: 10px;
			background: dodgerblue;
			color: white;
			min-width: 50px;
			text-align: center;
		}

		.input-field {
			width: 100%;
			padding: 10px;
			outline: none;
		}

		.input-field:focus {
			border: 2px solid dodgerblue;
		}

		/* Set a style for the submit button */
		.btn {
			background-color: dodgerblue;
			color: white;
			padding: 15px 20px;
			border: none;
			cursor: pointer;
			width: 100%;
			opacity: 0.9;
		}

		.btn:hover {
			opacity: 1;
		}
	</style>
</head>

<body>





	<form action="urunekle.php" method="post" style="max-width:500px;margin:auto">
		<h2 style="color:#8DCD14">Admin Girişi</h2>
		<div class="input-container">
			<i class="fa fa-user icon"></i>
			<input class="input-field" type="text" placeholder="Kullanıcı Adı" name="usrnm">
		</div>



		<div class="input-container">
			<i class="fa fa-key icon"></i>
			<input class="input-field" type="password" placeholder="Sifre" name="psw">
		</div>

		<button type="submit" class="btn">Giriş Yap</button>
	</form>

</body>

</html>
<?php
session_start();    
if(isset($_POST["usrnm"],$_POST["psw"]))
    if($_POST["usrnm"]=="admin" && $_POST["psw"]=="admin")
    {
        $_SESSSION["user"]=$_POST["usrnm"];
        header("location:urunlistele.php");
    }
else if($_POST["usrnm"]=="" && $_POST["psw"]=="")
{
    echo "<script>alert('Kullanıcı adi veya sifre bos olamaz') 
    </script>";
}
else
{
    echo "<script>alert('Kullanıcı adi veya sifre yanlis') 
    </script>";
}


?>