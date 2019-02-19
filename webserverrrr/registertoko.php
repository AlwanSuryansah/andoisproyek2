<?php
 
  require_once 'koneksi.php';
 
  header('Content-Type: application/json');
 
  if($_SERVER['REQUEST_METHOD']=='POST') {
    $id_toko = isset($_POST['id_toko'])?$_POST['id_toko']:"";
    $nama_toko = isset($_POST['nama_toko'])?$_POST['nama_toko']:"";
    $alamat_toko = isset($_POST['alamat_toko'])?$_POST['alamat_toko']:"";
    $jenis_toko = isset($_POST['jenis_toko'])?$_POST['jenis_toko']:"";
    $username = isset($_POST['username'])?$_POST['username']:"";
    $password = isset($_POST['password'])?$_POST['password']:"";
    $saldo_toko = isset($_POST['saldo_toko'])?$_POST['saldo_toko']:"";
    $status = isset($_POST['status'])?$_POST['status']:"";


    $query = "INSERT INTO tb_toko (id_toko, nama_toko, alamat_toko, jenis_toko, username, password, saldo_toko, status)
    VALUES ('$id_toko', '$nama_toko', '$alamat_toko', '$jenis_toko', '$username', '$password', '$saldo_toko', '$status')";


    $exeq = mysqli_query($con, $query);
 
    echo ($exeq) ? json_encode(array('kode' => 1, 'pesan' => 'Register berhasil, silahkan login')):
                  json_encode(array('kode' => 2, 'pesan' => 'Register gagal, silahkan cobalagi'));
  } else {
      echo json_encode(array('kode' => 101, 'pesan' => 'Request tidak valid'));
  }
?>