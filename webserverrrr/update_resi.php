<?php
 
  require_once 'koneksi.php';
 
  header('Content-Type: application/json');
 
  if($_SERVER['REQUEST_METHOD']=='POST') {
 
    $nama_lokasi = isset($_POST['nama_lokasi'])?$_POST['nama_lokasi']:"";
    $lng = isset($_POST['lng'])?$_POST['lng']:"";
    $lat = isset($_POST['lat'])?$_POST['lat']:"";
    $jam = isset($_POST['jam'])?$_POST['jam']:"";
    $tgl = isset($_POST['tgl'])?$_POST['tgl']:"";
    $deskripsi = isset($_POST['deskripsi'])?$_POST['deskripsi']:"";
    $no_resi = isset($_POST["no_resi"])?$_POST["no_resi"]:"";
    $status = isset($_POST["status"])?$_POST["status"]:"";
    $id_user = isset($_POST["id_user"])?$_POST["id_user"]:"";
 
    $query = "INSERT INTO tb_tracking (nama_lokasi, lng, lat, jam, tgl, deskripsi, no_resi, status, id_user)
             VALUES ('$nama_lokasi', '$lng', '$lat', '$jam', '$tgl', '$deskripsi', '$no_resi', '$status', '$id_user')";
    $exeq = mysqli_query($con, $query);
 
    echo ($exeq) ? json_encode(array('kode' => 1, 'pesan' => 'Update resi berhasil')):
                  json_encode(array('kode' => 2, 'pesan' => 'Update resi gagal'));
  } else {
      echo json_encode(array('kode' => 101, 'pesan' => 'Request tidak valid'));
  }
?>