<?php 
 require_once 'koneksi.php';
 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
   $id_toko = isset($_POST['id_toko'])?$_POST['id_toko']:"";
    $nama_toko = isset($_POST['nama_toko'])?$_POST['nama_toko']:"";
    $alamat_toko = isset($_POST['alamat_toko'])?$_POST['alamat_toko']:"";
    $jenis_toko = isset($_POST['jenis_toko'])?$_POST['jenis_toko']:"";
    $username = isset($_POST['username'])?$_POST['username']:"";
    $password = isset($_POST['password'])?$_POST['password']:"";
    $saldo_toko = isset($_POST['saldo_toko'])?$_POST['saldo_toko']:"";
    $status = isset($_POST['status'])?$_POST['status']:"";

 	$query = "UPDATE  tb_toko SET nama_toko = '$nama_toko',alamat_toko = '$alamat_toko', jenis_toko = '$jenis_toko' ,username = '$username',password = '$password', saldo_toko = '$saldo_toko', status = '$status' WHERE id_toko='$id_toko'";

 	$exeQuery = mysqli_query($con, $query); 
 	echo ($exeQuery) ? json_encode(array('kode' =>1, 'pesan' => 'data berhasil update')) :  json_encode(array('kode' =>2, 'pesan' => 'data gagal diupdate'));
 }
 else
 {
 	 echo json_encode(array('kode' =>101, 'pesan' => 'request tidak valid'));
 }
 ?>