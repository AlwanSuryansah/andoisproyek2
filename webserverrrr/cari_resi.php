<?php

require_once 'koneksi.php';

header('Content-Type: application/json');

$no_resi = $_GET['no_resi'];

$query = "SELECT * FROM tb_transaksi Where no_resi = '$no_resi'";

$result = mysqli_query($con, $query);

$array = array();

while ($row = mysqli_fetch_assoc($result))
{
	$array[] = $row;
}

echo ($result) ? json_encode(array('kode' => 1, 'result' => $array)):
                json_encode(array('kode' => 0, 'pesan' => 'Resi tidak ada'));
?>