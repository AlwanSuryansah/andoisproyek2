<?php
 
  require_once 'koneksi.php';
 
  header('Content-Type: application/json');
 
  if($_SERVER['REQUEST_METHOD']=='POST') {
    
    $id_transaksi = isset($_POST['id_transaksi'])?$_POST['id_transaksi']:"";
    $jumlah_transaksi = isset($_POST['jumlah_transaksi'])?$_POST['jumlah_transaksi']:"";
    $id_toko = isset($_POST['id_toko'])?$_POST['id_toko']:"";
    $id_pelanggan = isset($_POST['id_pelanggan'])?$_POST['id_pelanggan']:"";


    $query = "INSERT INTO tb_transaksi (id_transaksi, jumlah_transaksi, id_toko, id_pelanggan)
    VALUES ('$id_transaksi', '$jumlah_transaksi', '$id_toko', '$id_pelanggan')";

    $exeq = mysqli_query($con, $query);
 
    echo ($exeq) ? json_encode(array('kode' => 1, 'pesan' => 'Register berhasil, silahkan login')):
                  json_encode(array('kode' => 2, 'pesan' => 'Register gagal, silahkan cobalagi'));
  } else {
      echo json_encode(array('kode' => 101, 'pesan' => 'Request tidak valid'));
  }
?>