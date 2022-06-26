<?php
 $server = "localhost";
   $username = "root";
   $password = "";
   $database = "db_catatan";

   $konek = mysqli_connect($server,$username,$password,$database);

   if (mysqli_connect_error()) {
      echo "Gagal konek dengan Database" . mysqli_connect_error();
   }

 if($_SERVER['REQUEST_METHOD'])
{
   $id=$_POST['id'];
   $judul=$_POST['judul'];
   $catatan=$_POST['catatan'];
   $tgl=$_POST['tgl'];

   $query="UPDATE tb_catatan SET judul='$judul',catatan='$catatan',tgl='$tgl' WHERE id='$id'";
   
   $exeQuery=mysqli_query($konek,$query);
   echo($exeQuery)?json_encode(
   	array(
   		'kode'=>1,
   		'pesan'=>'data berhasil update'
   	)
   ):json_encode(array('kode'=>2,'pesan'=>'Datanya Gk Bisa Di Edit'));
}

else
{
    echo json_encode(array('kode'=>101,'pesan'=>'request tidak nya gk valid'));
}

header('Content-Type: application/json');
?>
                     