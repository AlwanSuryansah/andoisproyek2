<?php

require_once 'koneksi.php';

header('Content-Type: application/json');

$id_transaksi = $_GET['id_transaksi'];
$saldo_pelanggan = $_GET['saldo_pelanggan'];
$saldo_toko = $_GET['saldo_toko'];

	$query = "UPDATE tb_transaksi SET saldo_pelanggan = '$saldo_pelanggan',saldo_toko = '$saldo_toko' WHERE id_toko='$id_toko'";

$result = mysqli_query($con, $query);

$array = array();

while ($row = mysqli_fetch_assoc($result))
{
	$array[] = $row;
}

echo ($result) ? json_encode(array('kode' => 1, 'result' => $array)):
                json_encode(array('kode' => 0, 'pesan' => 'Resi tidak ada'));
?>