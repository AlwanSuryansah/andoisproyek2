<?php 
 require_once 'koneksi.php';
 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
    $id_pelanggan = isset($_POST['id_pelanggan'])?$_POST['id_pelanggan']:"";
    $nama_pelanggan = isset($_POST['nama_pelanggan'])?$_POST['nama_pelanggan']:"";
    $alamat = isset($_POST['alamat'])?$_POST['alamat']:"";
    $jenis_kelami = isset($_POST['jenis_kelami'])?$_POST['jenis_kelami']:"";
    $username = isset($_POST['username'])?$_POST['username']:"";
    $password = isset($_POST['password'])?$_POST['password']:"";
    $saldo_pelanggan = isset($_POST['saldo_pelanggan'])?$_POST['saldo_pelanggan']:"";
    $status = isset($_POST['status'])?$_POST['status']:"";

 	$query = "UPDATE  tb_pelanggan SET nama_pelanggan = '$nama_pelanggan',alamat = '$alamat', jenis_kelami = '$jenis_kelami' ,username = '$username',password = '$password', saldo_pelanggan = '$saldo_pelanggan', status = '$status' WHERE id_pelanggan='$id_pelanggan'";

 	$exeQuery = mysqli_query($con, $query); 
 	echo ($exeQuery) ? json_encode(array('kode' =>1, 'pesan' => 'data berhasil update')) :  json_encode(array('kode' =>2, 'pesan' => 'data gagal diupdate'));
 }
 else
 {
 	 echo json_encode(array('kode' =>101, 'pesan' => 'request tidak valid'));
 }
 ?>