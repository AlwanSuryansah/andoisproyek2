<?php

require_once 'koneksi.php';

header('Content-Type: application/json');

$id_toko = $_GET['id_toko'];

$query = "SELECT id_transaksi, jumlah_transaksi, nama_toko, id_pelanggan
FROM tb_toko INNER JOIN tb_transaksi USING (id_toko);";

$result = mysqli_query($con, $query);

$array = array();

while ($row = mysqli_fetch_assoc($result))
{
	$array[] = $row;
}
echo ($result) ? json_encode(array('kode' => 1, 'result' => $array)):
                json_encode(array('kode' => 0, 'pesan' => 'id toko tidak ada'));
?>