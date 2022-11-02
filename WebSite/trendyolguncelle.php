<?php
 
include "baglanti.php";
 
if(isset($_POST['guncelle'])){
 
    $sql = "UPDATE `trendyol`
    SET `marka_model` = ?,
    `modelno` = ?,
    `islemcitipi` = ?,
    `islemcinesli` = ?,
    `disk_turu` = ?,
    `bellek` = ?,
    `ram` = ?,
    `ekran_boyutu` = ?,
    `isletim_sistemi` = ?,
    `fiyat` = ?,
    `site` = ?,
    `link` = ?
    WHERE `trendyol`.`id` = ?";
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
        $_POST["link"],
        $_POST["id"],

    ];
    $sorgu = $baglan->prepare($sql);
    $sorgu->execute($dizi);
 
    header("Location:trendyollistele.php");
}
 
$sql ="SELECT * FROM trendyol WHERE veriler.trendyol.id = ?";
$sorgu = $baglan->prepare($sql);
$sorgu->execute([
    $_GET['id']
]);
$satir = $sorgu->fetch(PDO::FETCH_ASSOC);
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


	

	<form action="" method="post">
            <input type="hidden" name="id" value="<?=$satir['id']?>">
            
		<div class="form-group">
			<label for="mrk"><b>Marka</b></label>
			<input type="giris" class="form-control"  aria-describedby="Bir Deger Giriniz" placeholder="Bir Deger Giriniz" name="mrk" 
			value="<?=$satir['marka_model']?>">

		</div>
		<div class="form-group">
			<label for="mdl"><b>Model No</b></label>
			<input type="giris" class="form-control"  placeholder="Bir Deger Giriniz" name="mdl" value="<?=$satir['modelno']?>">
		</div>
		<div class="form-group">
			<label for="tip"><b>Islemci Tipi</b></label>
			<input type="giris" class="form-control"  placeholder="Bir Deger Giriniz" name="tip" value="<?=$satir['islemcitipi']?>">
		</div>
		<div class="form-group">
			<label for="nes"><b>Islemci Nesli</b></label>
			<input type="giris" class="form-control"  placeholder="Bir Deger Giriniz" name="nes" value="<?=$satir['islemcinesli']?>">
		</div>
		<div class="form-group">
			<label for="dsk"><b>Disk Turu</b></label>
			<input type="giris" class="form-control" placeholder="Bir Deger Giriniz" name="dsk" value="<?=$satir['disk_turu']?>">
		</div>
		<div class="form-group">
			<label for="blk"><b>Bellek</b></label>
			<input type="giris" class="form-control" placeholder="Bir Deger Giriniz" name=blk value="<?=$satir['bellek']?>">
		</div>
		<div class="form-group">
			<label for="ram"><b>Ram</b></label>
			<input type="giris" class="form-control"  placeholder="Bir Deger Giriniz" name=ram value="<?=$satir['ram']?>">
		</div>
		<div class="form-group">
			<label for="boy"><b>Ekran Boyutu</b></label>
			<input type="giris" class="form-control"  placeholder="Bir Deger Giriniz" name=boy value="<?=$satir['ekran_boyutu']?>">
		</div>
		<div class="form-group">
			<label for="sis"><b>Isletim Sistemi</b></label>
			<input type="giris" class="form-control"  placeholder="Bir Deger Giriniz" name=sis value="<?=$satir['isletim_sistemi']?>">
		</div>
		<div class="form-group">
			<label for="fiy"><b>Fiyat</b></label>
			<input type="giris" class="form-control"  placeholder="Bir Deger Giriniz" name=fiy value="<?=$satir['fiyat']?>">
		</div>
		<div class="form-group">
			<label for="site"><b>Site</b></label>
			<input type="giris" class="form-control"  placeholder="Bir Deger Giriniz" name=site value="<?=$satir['site']?>">
		</div>
		<div class="form-group">
			<label for="link"><b>Link</b></label>
			<input type="giris" class="form-control"  placeholder="Bir Deger Giriniz" name=link value="<?=$satir['link']?>">
		</div>


		<button type="submit" class="btn btn-primary" name=guncelle>Guncelle</button>
	</form>


<footer></footer>

</body>

</html>