<?php
/* Sürücü isteğiyle bir MySQL veritabanına bağlanalım */
$dsn = 'mysql:dbname=veriler;host=localhost';
$user = 'root';
$password = '';
try{
$baglan = new PDO($dsn, $user, $password);
}catch(PDOException $e){
    echo 'Baglanti kurulamadi:'.$e->getMessage();
}

?>