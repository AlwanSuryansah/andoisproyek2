<?php

require_once 'koneksi.php';

header('Content-Type: application/json');

$id_pelanggan = $_GET['id_pelanggan'];

$query = "SELECT id_transaksi, jumlah_transaksi, id_toko, nama_pelanggan
FROM tb_pelanggan INNER JOIN tb_transaksi USING (id_pelanggan);";

$result = mysqli_query($con, $query);

$array = array();

while ($row = mysqli_fetch_assoc($result))
{
	$array[] = $row;
}

echo ($result) ? json_encode(array('kode' => 1, 'result' => $array)):
                json_encode(array('kode' => 0, 'pesan' => 'id pelanggan tidak ada'));
?>