 <?php
if(isset($_POST["ekle"])){
include"baglanti.php";

$sql="INSERT INTO `vatan` (`marka_model`, `modelno`, `islemcitipi`, `islemcinesli`, `disk_turu`, `bellek`, `ram`, `ekran_boyutu`, `isletim_sistemi`, `fiyat`,`site`,`link`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?);";
    $dizi=[
    $_POST["mrk"],
    $_POST["mdl"],
    $_POST["tip"],
    $_POST["nes"],
    $_POST["dsk"],
    $_POST["blk"],
    $_POST["ram"],
    $_POST["boy"],
    $_POST["sis"],
    $_POST["fiy"],
    $_POST["site"],
    $_POST["link"]
];
    $sth=$baglan->prepare($sql);
   $sonuc= $sth->execute($dizi);
    header("location:vatanlistele.php");
}
        ?>


 <!DOCTYPE HTML>
 <html>

 <head>
 	<script src="https://kit.fontawesome.com/c20485228a.js" crossorigin="anonymous"></script>

 	<link rel="stylesheet" href="css/style.css">
 	<link rel='stylesheet' href='https://cdn-uicons.flaticon.com/uicons-bold-rounded/css/uicons-bold-rounded.css'>
 	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 	<style>
 		body {
 			height: 600px;
 			background-image: url(img/laptops.jpg);
 			background-size: cover;
 			background-position: center;
 			background-attachment: fixed;
 			;
 		}
 	</style>
 </head>

 <body>



 	<form action="vatanekle.php" method="post">
 		<div class="form-group">
 			<label for="exampleInputEmail1"><b>Marka</b></label>
 			<input type="giris" class="form-control" id="exampleInputEmail1" aria-describedby="Bir Deger Giriniz" placeholder="Bir Deger Giriniz" name=mrk>

 		</div>
 		<div class="form-group">
 			<label for="exampleInputPassword1"><b>Model No</b></label>
 			<input type="giris" class="form-control" id="exampleInputPassword1" placeholder="Bir Deger Giriniz" name="mdl">
 		</div>
 		<div class="form-group">
 			<label for="exampleInputPassword1"><b>Islemci Tipi</b></label>
 			<input type="giris" class="form-control" id="exampleInputPassword1" placeholder="Bir Deger Giriniz" name=tip>
 		</div>
 		<div class="form-group">
 			<label for="exampleInputPassword1"><b>Islemci Nesli</b></label>
 			<input type="giris" class="form-control" id="exampleInputPassword1" placeholder="Bir Deger Giriniz" name=nes>
 		</div>
 		<div class="form-group">
 			<label for="exampleInputPassword1"><b>Disk Turu</b></label>
 			<input type="giris" class="form-control" id="exampleInputPassword1" placeholder="Bir Deger Giriniz" name=dsk>
 		</div>
 		<div class="form-group">
 			<label for="exampleInputPassword1"><b>Bellek</b></label>
 			<input type="giris" class="form-control" id="exampleInputPassword1" placeholder="Bir Deger Giriniz" name=blk>
 		</div>
 		<div class="form-group">
 			<label for="exampleInputPassword1"><b>Ram</b></label>
 			<input type="giris" class="form-control" id="exampleInputPassword1" placeholder="Bir Deger Giriniz" name=ram>
 		</div>
 		<div class="form-group">
 			<label for="exampleInputPassword1"><b>Ekran Boyutu</b></label>
 			<input type="giris" class="form-control" id="exampleInputPassword1" placeholder="Bir Deger Giriniz" name=boy>
 		</div>
 		<div class="form-group">
 			<label for="exampleInputPassword1"><b>Isletim Sistemi</b></label>
 			<input type="giris" class="form-control" id="exampleInputPassword1" placeholder="Bir Deger Giriniz" name=sis>
 		</div>
 		<div class="form-group">
 			<label for="exampleInputPassword1"><b>Fiyat</b></label>
 			<input type="giris" class="form-control" id="exampleInputPassword1" placeholder="Bir Deger Giriniz" name=fiy>
 		</div>
 		<div class="form-group">
 			<label for="exampleInputPassword1"><b>Site</b></label>
 			<input type="giris" class="form-control" id="exampleInputPassword1" placeholder="Bir Deger Giriniz" name=site>
 		</div>
 		<div class="form-group">
 			<label for="exampleInputPassword1"><b>Link</b></label>
 			<input type="giris" class="form-control" id="exampleInputPassword1" placeholder="Bir Deger Giriniz" name=link>
 		</div>


 		<button type="submit" class="btn btn-primary" name=ekle>Urun Ekle</button>
 	</form>



 </body>

 </html>