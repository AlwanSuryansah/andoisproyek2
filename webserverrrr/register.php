<?php
 
  require_once 'koneksi.php';
 
  header('Content-Type: application/json');
 
  if($_SERVER['REQUEST_METHOD']=='POST') {
    $id_pelanggan = isset($_POST['id_pelanggan'])?$_POST['id_pelanggan']:"";
    $nama_pelanggan = isset($_POST['nama_pelanggan'])?$_POST['nama_pelanggan']:"";
    $alamat = isset($_POST['alamat'])?$_POST['alamat']:"";
    $jenis_kelami = isset($_POST['jenis_kelami'])?$_POST['jenis_kelami']:"";
    $username = isset($_POST['username'])?$_POST['username']:"";
    $password = isset($_POST['password'])?$_POST['password']:"";
    $saldo_pelanggan = isset($_POST['saldo_pelanggan'])?$_POST['saldo_pelanggan']:"";
    $status = isset($_POST['status'])?$_POST['status']:"";


    $query = "INSERT INTO tb_pelanggan (id_pelanggan, nama_pelanggan, alamat, jenis_kelami, username, password, saldo_pelanggan, status)
    VALUES ('$id_pelanggan', '$nama_pelanggan', '$alamat', '$jenis_kelami', '$username', '$password', '$saldo_pelanggan', '$status')";


    $exeq = mysqli_query($con, $query);
 
    echo ($exeq) ? json_encode(array('kode' => 1, 'pesan' => 'Register berhasil, silahkan login')):
                  json_encode(array('kode' => 2, 'pesan' => 'Register gagal, silahkan cobalagi'));
  } else {
      echo json_encode(array('kode' => 101, 'pesan' => 'Request tidak valid'));
  }
?>