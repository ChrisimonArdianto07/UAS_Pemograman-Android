<?php
  $server = "localhost";
   $username = "root";
   $password = "";
   $database = "db_catatan";

   $konek = mysqli_connect($server,$username,$password,$database);

   if (mysqli_connect_error()) {
      echo "Gagal konek dengan Database" . mysqli_connect_error();
   }

 if($_SERVER['REQUEST_METHOD']=='POST')
{
   $judul=$_POST['judul'];
   $catatan=$_POST['catatan'];
   $tgl=$_POST['tgl'];

   $query="INSERT INTO tb_catatan(judul,catatan,tgl) VALUES('$judul','$catatan','$tgl')";
   $exeQuery=mysqli_query($konek,$query);

   echo($exeQuery)?json_encode(
   	array(
   		'kode'=>1,
   		'pesan'=>'Yeey berhasi di tambahkan'

      )
   ):json_encode(array('kode'=>2,'pesan'=>'data gagal ditambahkan'));
}

else
{
    echo json_encode(array('kode'=>101,'pesan'=>'request tidak valid'));
}

?>