<?php

require_once 'koneksi.php';

header('Content-Type: application/json');

$id_toko = $_GET['id_toko'];

$query = "SELECT * FROM tb_toko Where id_toko = '$id_toko'";

$result = mysqli_query($con, $query);

$array = array();

while ($row = mysqli_fetch_assoc($result))
{
	$array[] = $row;
}

echo ($result) ? json_encode(array('kode' => 1, 'result' => $array)):
                json_encode(array('kode' => 0, 'pesan' => 'Resi tidak ada'));
?>