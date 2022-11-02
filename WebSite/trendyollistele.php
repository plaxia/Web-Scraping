 <?php
include("baglanti.php");

if(isset($_GET['sil'])){
    $sqlsil="DELETE FROM `trendyol` WHERE `trendyol`.`fiyat` = ?";
    $sorgusil=$baglan->prepare($sqlsil);
    $sorgusil->execute([
        $_GET['sil']
    ]);

    header('Location:trendyollistele.php');

}
$sql="Select * From veriler.trendyol";
$sorgu=$baglan->prepare($sql);
        $sorgu->execute();
        ?>

 
 <!DOCTYPE html>
 <html>

 <head>
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
 	<script src="https://kit.fontawesome.com/c20485228a.js" crossorigin="anonymous"></script>
 	<link rel="stylesheet" href="css/style.css">

 	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

 </head>

 <body>
 
 	<section id="urunliste">

 		<nav id="butonurun">
 		<a href="trendyolara.php?giris=">
 				<button type="button" style="background-color:#007bff;border-color: #007bff;    color: #fff;
padding: 0.375rem 0.75rem;" class="btn btn-primary"><i class="fi fi-br-plus"></i>ÜRÜN ARA</button></a>
 			<a href="trendyolekle.php">
 				<button type="button" style="background-color:#007bff;border-color: #007bff;    color: #fff;
padding: 0.375rem 0.75rem;" class="btn btn-primary"><i class="fi fi-br-plus"></i> <img src="img/plus.png" style="height:15px; weidth:13px;">ÜRÜN EKLE</button></a>
 			<a href="index.php">
 				<button type="button" style="background-color:#007bff;border-color: #007bff;    color: #fff;
padding: 0.375rem 0.75rem;" class="btn btn-primary"><i class="fas fa-home ikon"></i>Anasayfa</button></a>
 		</nav>


 	</section>

 	<h1 style="color:pink">Trendyol Urun Listesi</h1>

 	<table id="customers " class="table table-hover table-dark">
 		<tr>
 			<th>Marka</th>
 			<th>Modelno</th>
 			<th>Islemcitipi</th>
 			<th>Islemcinesli</th>
 			<th>Disk_Turu</th>
 			<th>Bellek</th>
 			<th>Ram</th>
 			<th>Ekran_Boyutu</th>
 			<th>IsletimSistemi</th>
 			<th>Fiyat</th>
 			<th>Site</th>
 			 

 			
 		</tr>
 		<?php while($satir=$sorgu->fetch(PDO::FETCH_ASSOC)){?>
 		<tr>
 			<td><?=$satir['marka_model']?></td>
 			<td><?=$satir['modelno']?></td>
 			<td><?=$satir['islemcitipi']?></td>
 			<td><?=$satir['islemcinesli']?></td>
 			<td><?=$satir['disk_turu']?></td>
 			<td><?=$satir['bellek']?></td>
 			<td><?=$satir['ram']?></td>
 			<td><?=$satir['ekran_boyutu']?></td>
 			<td><?=$satir['isletim_sistemi']?></td>
 			<td><?=$satir['fiyat']?></td>
 			<td><?=$satir['site']?>
 			
			
 			<div class="btn-group">
 				<a href="trendyolguncelle.php?id=<?=$satir['id']?>" class="btn btn-success">Güncelle</a>
 				
 				<a href="?sil=<?=$satir['fiyat']?>" onclick="return confirm('Silinsin mi?')" class="btn btn-danger">Kaldır</a>
 				<a href="<?=$satir['link']?>">
 									<input type="image" src="img/trendyol.png" value="submit" width="60px" >
 				</a>
 				


 			</div>
 			</td>
 			

 		</tr>
 		<?php } ?>

 	</table>
 </body>

 </html>