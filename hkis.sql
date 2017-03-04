-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.19-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for hkis_v2
CREATE DATABASE IF NOT EXISTS `hkis_v2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hkis_v2`;

-- Dumping structure for table hkis_v2.d_inisial
CREATE TABLE IF NOT EXISTS `d_inisial` (
  `INISIAL_ID` varchar(9) NOT NULL,
  `TGL_PROTEKSI_BATAL_ORDER_BELI` datetime DEFAULT NULL,
  `TGL_PROTEKSI_FAKTUR_PEMBELIAN` datetime DEFAULT NULL,
  `TGL_PROTEKSI_ORDER_PEMBELIAN` datetime DEFAULT NULL,
  `TGL_PROTEKSI_REQUEST_BELI` datetime DEFAULT NULL,
  `TGL_PROTEKSI_RETUR_BELI` datetime DEFAULT NULL,
  `ACC_LR_DITAHAN` varchar(255) DEFAULT NULL,
  `AP_START` datetime DEFAULT NULL,
  `AR_START` datetime DEFAULT NULL,
  `BOOK_CURRENCY_INDEX` double DEFAULT NULL,
  `BOOK_START` datetime DEFAULT NULL,
  `IS_DEPLOY` tinyint(1) DEFAULT NULL,
  `IS_MIGRATING` tinyint(1) DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `LOGO_PERUSAHAAN` varchar(255) DEFAULT NULL,
  `BOOK_CURRENCY` varchar(255) DEFAULT NULL,
  `MRU_LIMIT` int(11) DEFAULT NULL,
  `NAMA_PERUSAHAAN` varchar(255) DEFAULT NULL,
  `PPH_VALUE` double DEFAULT NULL,
  `PPN_VALUE` double DEFAULT NULL,
  `STOCK_WARNING` tinyint(1) DEFAULT NULL,
  `SUPPLIER_FK` varchar(255) DEFAULT NULL,
  `TGL_JTEMPO_EQ_TGL_CAIR_KB_KELUAR` tinyint(1) DEFAULT NULL,
  `TGL_JTEMPO_EQ_TGL_CAIR_KB_MASUK` tinyint(1) DEFAULT NULL,
  `TGL_SALDO_AWAL` datetime DEFAULT NULL,
  `TGL_STOCK_OPNAME` datetime DEFAULT NULL,
  `TOGGLE_STOCK_OPNAME` tinyint(1) DEFAULT NULL,
  `TOLERANSI` double DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `WS_SERVER_ADDRESS_CELUP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`INISIAL_ID`),
  KEY `FK_8qpc5mocmxqearrtb2oocrqgt` (`BOOK_CURRENCY`),
  KEY `FK_9cqxrq27v0dn3pdt55dnw4ekw` (`SUPPLIER_FK`),
  CONSTRAINT `FK_8qpc5mocmxqearrtb2oocrqgt` FOREIGN KEY (`BOOK_CURRENCY`) REFERENCES `m_mata_uang` (`MATA_UANG_ID`),
  CONSTRAINT `FK_9cqxrq27v0dn3pdt55dnw4ekw` FOREIGN KEY (`SUPPLIER_FK`) REFERENCES `m_supplier` (`SUPPLIER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.d_inisial: ~-1 rows (approximately)
DELETE FROM `d_inisial`;
/*!40000 ALTER TABLE `d_inisial` DISABLE KEYS */;
INSERT INTO `d_inisial` (`INISIAL_ID`, `TGL_PROTEKSI_BATAL_ORDER_BELI`, `TGL_PROTEKSI_FAKTUR_PEMBELIAN`, `TGL_PROTEKSI_ORDER_PEMBELIAN`, `TGL_PROTEKSI_REQUEST_BELI`, `TGL_PROTEKSI_RETUR_BELI`, `ACC_LR_DITAHAN`, `AP_START`, `AR_START`, `BOOK_CURRENCY_INDEX`, `BOOK_START`, `IS_DEPLOY`, `IS_MIGRATING`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `LOGO_PERUSAHAAN`, `BOOK_CURRENCY`, `MRU_LIMIT`, `NAMA_PERUSAHAAN`, `PPH_VALUE`, `PPN_VALUE`, `STOCK_WARNING`, `SUPPLIER_FK`, `TGL_JTEMPO_EQ_TGL_CAIR_KB_KELUAR`, `TGL_JTEMPO_EQ_TGL_CAIR_KB_MASUK`, `TGL_SALDO_AWAL`, `TGL_STOCK_OPNAME`, `TOGGLE_STOCK_OPNAME`, `TOLERANSI`, `VERSION`, `WS_SERVER_ADDRESS_CELUP`) VALUES
	('1', '2016-07-31 00:00:00', '2016-07-31 00:00:00', '2016-07-31 00:00:00', '2016-07-31 00:00:00', '2016-03-31 00:00:00', '33', NULL, NULL, 0.1, '2014-12-03 00:00:00', 0, 1, 'it', '2017-03-01 11:55:36', NULL, 'Rp', 5, 'PT. Harapan Kurnia Textile Indonesia', 2, 10, NULL, 'CT', 1, 1, '2014-12-01 00:00:00', '2015-12-31 00:00:00', 1, 30, 20, 'http://192.168.8.4:8080/HK/services');
/*!40000 ALTER TABLE `d_inisial` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_access_user
CREATE TABLE IF NOT EXISTS `m_access_user` (
  `ACCESS_USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MODULE_FK` varchar(255) NOT NULL,
  `USER_FK` varchar(255) NOT NULL,
  PRIMARY KEY (`ACCESS_USER_ID`),
  KEY `FK_jq7r4x1uvhk2os7fg6yie8cal` (`MODULE_FK`),
  KEY `FK_c2uhoet2pbqn22whkdbgarx41` (`USER_FK`),
  CONSTRAINT `FK_c2uhoet2pbqn22whkdbgarx41` FOREIGN KEY (`USER_FK`) REFERENCES `m_user` (`USER_ID`),
  CONSTRAINT `FK_jq7r4x1uvhk2os7fg6yie8cal` FOREIGN KEY (`MODULE_FK`) REFERENCES `m_module` (`MODULE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_access_user: ~-1 rows (approximately)
DELETE FROM `m_access_user`;
/*!40000 ALTER TABLE `m_access_user` DISABLE KEYS */;
INSERT INTO `m_access_user` (`ACCESS_USER_ID`, `MODULE_FK`, `USER_FK`) VALUES
	(1, 'HOME', 'it'),
	(8, 'QWE', 'it');
/*!40000 ALTER TABLE `m_access_user` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_agama
CREATE TABLE IF NOT EXISTS `m_agama` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Agama` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_agama: ~-1 rows (approximately)
DELETE FROM `m_agama`;
/*!40000 ALTER TABLE `m_agama` DISABLE KEYS */;
/*!40000 ALTER TABLE `m_agama` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_akun
CREATE TABLE IF NOT EXISTS `m_akun` (
  `AKUN_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `AKUN_GRUP_FK` varchar(255) NOT NULL,
  `AKUN_FK` varchar(255) DEFAULT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `LEVEL_AKUN` int(11) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `POSISI_DK` varchar(1) NOT NULL,
  `SALDO_AWAL` decimal(19,2) NOT NULL,
  `SALDO_YTD` decimal(19,2) NOT NULL,
  `TIPE_AKUN` varchar(1) NOT NULL,
  PRIMARY KEY (`AKUN_ID`),
  KEY `FK_aud5edelgmdauixgj3d8mgfv2` (`AKUN_GRUP_FK`),
  KEY `FK_se5915swtg3v5wxkl1cyyyq9f` (`AKUN_FK`),
  CONSTRAINT `FK_aud5edelgmdauixgj3d8mgfv2` FOREIGN KEY (`AKUN_GRUP_FK`) REFERENCES `m_akun_grup` (`AKUN_GRUP_ID`),
  CONSTRAINT `FK_se5915swtg3v5wxkl1cyyyq9f` FOREIGN KEY (`AKUN_FK`) REFERENCES `m_akun` (`AKUN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_akun: ~-1 rows (approximately)
DELETE FROM `m_akun`;
/*!40000 ALTER TABLE `m_akun` DISABLE KEYS */;
INSERT INTO `m_akun` (`AKUN_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `AKUN_GRUP_FK`, `AKUN_FK`, `DATE_NON_ACTIVE`, `IS_ACTIVE`, `LEVEL_AKUN`, `NAMA`, `POSISI_DK`, `SALDO_AWAL`, `SALDO_YTD`, `TIPE_AKUN`) VALUES
	('7', 'it', '2017-02-21 11:09:51', 'it', '2017-02-28 10:17:07', 2, 'BT', NULL, NULL, 1, 1, 'Tambahan Transport', 'D', 2500.00, 2500.00, 'T'),
	('7.1', 'it', '2017-02-21 11:11:11', NULL, NULL, 0, 'BT', '7', NULL, 1, 2, 'Tambahan Transport Child', 'D', 1000.00, 1000.00, 'T');
/*!40000 ALTER TABLE `m_akun` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_akun_grup
CREATE TABLE IF NOT EXISTS `m_akun_grup` (
  `AKUN_GRUP_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  PRIMARY KEY (`AKUN_GRUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_akun_grup: ~-1 rows (approximately)
DELETE FROM `m_akun_grup`;
/*!40000 ALTER TABLE `m_akun_grup` DISABLE KEYS */;
INSERT INTO `m_akun_grup` (`AKUN_GRUP_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `IS_ACTIVE`, `NAMA`) VALUES
	('BT', 'it', '2017-02-21 09:34:46', 'it', '2017-02-28 14:15:20', 19, '2017-02-28 14:15:20', 0, 'asc'),
	('XC', 'it', '2017-03-01 13:56:04', NULL, NULL, 0, NULL, 1, 'Xceon'),
	('XC2', 'it', '2017-03-01 13:56:48', NULL, NULL, 0, NULL, 1, 'Xceon2');
/*!40000 ALTER TABLE `m_akun_grup` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_barang
CREATE TABLE IF NOT EXISTS `m_barang` (
  `BARANG_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `AKUN_FK` varchar(255) NOT NULL,
  `BARANG_DIVISI_FK` varchar(255) NOT NULL,
  `BARANG_GRUP_FK` varchar(255) NOT NULL,
  `BARANG_MERK_FK` varchar(255) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `GUDANG_FK` varchar(255) NOT NULL,
  `HARGA_BELI` decimal(19,2) DEFAULT NULL,
  `HARGA_JUAL` decimal(19,2) DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `NAMA` varchar(100) NOT NULL,
  `NAMA_BARANG_SUPPLIER` varchar(100) DEFAULT NULL,
  `QUANTITY_KONVERSI` int(11) DEFAULT NULL,
  `SALDO_AWAL` decimal(19,2) DEFAULT NULL,
  `STOK_MAKSIMAL` int(11) DEFAULT NULL,
  `STOK_MINIMAL` int(11) DEFAULT NULL,
  `SUPPLIER_FK` varchar(255) NOT NULL,
  `UNIT_BELI_FK` varchar(255) NOT NULL,
  `UNIT_BESAR_FK` varchar(255) NOT NULL,
  `UNIT_JUAL_FK` varchar(255) NOT NULL,
  `UNIT_KECIL_FK` varchar(255) NOT NULL,
  PRIMARY KEY (`BARANG_ID`),
  KEY `FK_ley646k61euw8tg06sj43h6eb` (`AKUN_FK`),
  KEY `FK_eeh8xr60t3bgfju8i56hn3jb3` (`BARANG_DIVISI_FK`),
  KEY `FK_hatrtqhlmi63vl2w678noixfk` (`BARANG_GRUP_FK`),
  KEY `FK_pb4eybq8krcwf7kbtau8ypwcy` (`BARANG_MERK_FK`),
  KEY `FK_c9f05p47n2xfg27jwpkxwhcq0` (`GUDANG_FK`),
  KEY `FK_1ofh4t5p83sckxcgsuq03hud4` (`SUPPLIER_FK`),
  KEY `FK_tnr4v4iib0o4kqode23efnfk1` (`UNIT_BELI_FK`),
  KEY `FK_kbe4qjum6sret9jpeax6n0in0` (`UNIT_BESAR_FK`),
  KEY `FK_trr4fp51c6qnjxwmt28s3d0xx` (`UNIT_JUAL_FK`),
  KEY `FK_cfcixenj6opuhh04ljoyc4i2b` (`UNIT_KECIL_FK`),
  CONSTRAINT `FK_1ofh4t5p83sckxcgsuq03hud4` FOREIGN KEY (`SUPPLIER_FK`) REFERENCES `m_supplier` (`SUPPLIER_ID`),
  CONSTRAINT `FK_c9f05p47n2xfg27jwpkxwhcq0` FOREIGN KEY (`GUDANG_FK`) REFERENCES `m_gudang` (`GUDANG_ID`),
  CONSTRAINT `FK_cfcixenj6opuhh04ljoyc4i2b` FOREIGN KEY (`UNIT_KECIL_FK`) REFERENCES `m_unit` (`UNIT_ID`),
  CONSTRAINT `FK_eeh8xr60t3bgfju8i56hn3jb3` FOREIGN KEY (`BARANG_DIVISI_FK`) REFERENCES `m_barang_divisi` (`BARANG_DIVISI_ID`),
  CONSTRAINT `FK_hatrtqhlmi63vl2w678noixfk` FOREIGN KEY (`BARANG_GRUP_FK`) REFERENCES `m_barang_grup` (`BARANG_GRUP_ID`),
  CONSTRAINT `FK_kbe4qjum6sret9jpeax6n0in0` FOREIGN KEY (`UNIT_BESAR_FK`) REFERENCES `m_unit` (`UNIT_ID`),
  CONSTRAINT `FK_ley646k61euw8tg06sj43h6eb` FOREIGN KEY (`AKUN_FK`) REFERENCES `m_akun` (`AKUN_ID`),
  CONSTRAINT `FK_pb4eybq8krcwf7kbtau8ypwcy` FOREIGN KEY (`BARANG_MERK_FK`) REFERENCES `m_barang_merk` (`BARANG_MERK_ID`),
  CONSTRAINT `FK_tnr4v4iib0o4kqode23efnfk1` FOREIGN KEY (`UNIT_BELI_FK`) REFERENCES `m_unit` (`UNIT_ID`),
  CONSTRAINT `FK_trr4fp51c6qnjxwmt28s3d0xx` FOREIGN KEY (`UNIT_JUAL_FK`) REFERENCES `m_unit` (`UNIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_barang: ~-1 rows (approximately)
DELETE FROM `m_barang`;
/*!40000 ALTER TABLE `m_barang` DISABLE KEYS */;
INSERT INTO `m_barang` (`BARANG_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `AKUN_FK`, `BARANG_DIVISI_FK`, `BARANG_GRUP_FK`, `BARANG_MERK_FK`, `DATE_NON_ACTIVE`, `GUDANG_FK`, `HARGA_BELI`, `HARGA_JUAL`, `IS_ACTIVE`, `NAMA`, `NAMA_BARANG_SUPPLIER`, `QUANTITY_KONVERSI`, `SALDO_AWAL`, `STOK_MAKSIMAL`, `STOK_MINIMAL`, `SUPPLIER_FK`, `UNIT_BELI_FK`, `UNIT_BESAR_FK`, `UNIT_JUAL_FK`, `UNIT_KECIL_FK`) VALUES
	('TLR', 'it', '2017-02-24 14:10:34', NULL, NULL, 0, '7', 'BD1', 'BG1', 'BM1', NULL, 'GB1', 12000.00, 15000.00, 1, 'Telur', 'Telur Ayam Negeri KW', 1000, 10000.00, 100, 1, 'CT', 'KG', 'KG', 'KG', 'GR');
/*!40000 ALTER TABLE `m_barang` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_barang_divisi
CREATE TABLE IF NOT EXISTS `m_barang_divisi` (
  `BARANG_DIVISI_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  PRIMARY KEY (`BARANG_DIVISI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_barang_divisi: ~-1 rows (approximately)
DELETE FROM `m_barang_divisi`;
/*!40000 ALTER TABLE `m_barang_divisi` DISABLE KEYS */;
INSERT INTO `m_barang_divisi` (`BARANG_DIVISI_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `IS_ACTIVE`, `NAMA`) VALUES
	('BD1', 'it', '2017-02-24 14:02:17', NULL, NULL, 0, NULL, 1, 'Barang Divisi 1');
/*!40000 ALTER TABLE `m_barang_divisi` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_barang_grup
CREATE TABLE IF NOT EXISTS `m_barang_grup` (
  `BARANG_GRUP_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  PRIMARY KEY (`BARANG_GRUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_barang_grup: ~-1 rows (approximately)
DELETE FROM `m_barang_grup`;
/*!40000 ALTER TABLE `m_barang_grup` DISABLE KEYS */;
INSERT INTO `m_barang_grup` (`BARANG_GRUP_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `IS_ACTIVE`, `NAMA`) VALUES
	('BG1', 'it', '2017-02-24 13:40:20', NULL, NULL, 0, NULL, 1, 'Barang Grup 1');
/*!40000 ALTER TABLE `m_barang_grup` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_barang_merk
CREATE TABLE IF NOT EXISTS `m_barang_merk` (
  `BARANG_MERK_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  PRIMARY KEY (`BARANG_MERK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_barang_merk: ~-1 rows (approximately)
DELETE FROM `m_barang_merk`;
/*!40000 ALTER TABLE `m_barang_merk` DISABLE KEYS */;
INSERT INTO `m_barang_merk` (`BARANG_MERK_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `IS_ACTIVE`, `NAMA`) VALUES
	('BM1', 'it', '2017-02-24 13:40:06', NULL, NULL, 0, NULL, 1, 'Barang Merk 1');
/*!40000 ALTER TABLE `m_barang_merk` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_cost
CREATE TABLE IF NOT EXISTS `m_cost` (
  `COST_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `AKUN_FK` varchar(255) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `GRUP_ID` varchar(50) NOT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `MATA_UANG_FK` varchar(255) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `SALDO_AWAL` decimal(19,2) NOT NULL,
  `TGL_AWAL` datetime NOT NULL,
  PRIMARY KEY (`COST_ID`),
  KEY `FK_hb65tinxpjvuacdqbftonrmi9` (`AKUN_FK`),
  KEY `FK_jm0latsnq3d7q4mcxpq2k62vj` (`MATA_UANG_FK`),
  CONSTRAINT `FK_hb65tinxpjvuacdqbftonrmi9` FOREIGN KEY (`AKUN_FK`) REFERENCES `m_akun` (`AKUN_ID`),
  CONSTRAINT `FK_jm0latsnq3d7q4mcxpq2k62vj` FOREIGN KEY (`MATA_UANG_FK`) REFERENCES `m_mata_uang` (`MATA_UANG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_cost: ~-1 rows (approximately)
DELETE FROM `m_cost`;
/*!40000 ALTER TABLE `m_cost` DISABLE KEYS */;
INSERT INTO `m_cost` (`COST_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `AKUN_FK`, `DATE_NON_ACTIVE`, `GRUP_ID`, `IS_ACTIVE`, `MATA_UANG_FK`, `NAMA`, `SALDO_AWAL`, `TGL_AWAL`) VALUES
	('BGN', 'it', '2017-02-22 11:45:50', NULL, NULL, 0, '7', NULL, 'Cost Grup 1', 1, 'Rp', 'Bangunan', 150000.00, '2017-01-01 00:00:00');
/*!40000 ALTER TABLE `m_cost` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_customer
CREATE TABLE IF NOT EXISTS `m_customer` (
  `CUSTOMER_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `AKUN_FK` varchar(255) NOT NULL,
  `ALAMAT` varchar(255) NOT NULL,
  `ALAMAT_PKP` varchar(255) DEFAULT NULL,
  `BARCODE` varchar(255) DEFAULT NULL,
  `DAERAH` varchar(50) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `GRUP_ID` varchar(50) NOT NULL,
  `HARI_RAYA` varchar(30) DEFAULT NULL,
  `HARI_TAGIH` varchar(10) NOT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `KAS_BANK_FK` varchar(255) NOT NULL,
  `KATEGORI_ID` varchar(50) NOT NULL,
  `KODE_POS` varchar(50) NOT NULL,
  `KOTA` varchar(50) NOT NULL,
  `LAMA_BAYAR` int(11) NOT NULL,
  `NAMA` varchar(100) NOT NULL,
  `NAMA_DI_FAKTUR` varchar(50) NOT NULL,
  `NAMA_PKP` varchar(50) DEFAULT NULL,
  `NPWP` varchar(50) DEFAULT NULL,
  `PEMILIK` varchar(50) DEFAULT NULL,
  `PLAFON_FAKTUR` decimal(19,2) NOT NULL,
  `PLAFON_RP` decimal(19,2) NOT NULL,
  `PROSPEK_FK` varchar(255) NOT NULL,
  `PROVINSI` varchar(50) NOT NULL,
  `SALDO_AWAL` decimal(19,2) NOT NULL,
  `SALES_FK` varchar(255) DEFAULT NULL,
  `STATUS_PROPERTY` varchar(10) DEFAULT NULL,
  `TANGGAL_DIDIRIKAN` datetime DEFAULT NULL,
  `TANGGAL_LAHIR` datetime DEFAULT NULL,
  `TIPE_ID` varchar(50) NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`),
  KEY `FK_drbcifdgls144l2m7x7yqdoy3` (`AKUN_FK`),
  KEY `FK_f7kh3n8fjc8ssa48ocrpg75r5` (`KAS_BANK_FK`),
  KEY `FK_cmgpd45fu9gnek23qc91iibyf` (`PROSPEK_FK`),
  KEY `FK_ho3vg7wsdengyp9fqphwgd6sh` (`SALES_FK`),
  CONSTRAINT `FK_cmgpd45fu9gnek23qc91iibyf` FOREIGN KEY (`PROSPEK_FK`) REFERENCES `m_prospek` (`PROSPEK_ID`),
  CONSTRAINT `FK_drbcifdgls144l2m7x7yqdoy3` FOREIGN KEY (`AKUN_FK`) REFERENCES `m_akun` (`AKUN_ID`),
  CONSTRAINT `FK_f7kh3n8fjc8ssa48ocrpg75r5` FOREIGN KEY (`KAS_BANK_FK`) REFERENCES `m_kas_bank` (`KAS_BANK_ID`),
  CONSTRAINT `FK_ho3vg7wsdengyp9fqphwgd6sh` FOREIGN KEY (`SALES_FK`) REFERENCES `m_sales` (`SALES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_customer: ~-1 rows (approximately)
DELETE FROM `m_customer`;
/*!40000 ALTER TABLE `m_customer` DISABLE KEYS */;
INSERT INTO `m_customer` (`CUSTOMER_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `AKUN_FK`, `ALAMAT`, `ALAMAT_PKP`, `BARCODE`, `DAERAH`, `DATE_NON_ACTIVE`, `GRUP_ID`, `HARI_RAYA`, `HARI_TAGIH`, `IS_ACTIVE`, `KAS_BANK_FK`, `KATEGORI_ID`, `KODE_POS`, `KOTA`, `LAMA_BAYAR`, `NAMA`, `NAMA_DI_FAKTUR`, `NAMA_PKP`, `NPWP`, `PEMILIK`, `PLAFON_FAKTUR`, `PLAFON_RP`, `PROSPEK_FK`, `PROVINSI`, `SALDO_AWAL`, `SALES_FK`, `STATUS_PROPERTY`, `TANGGAL_DIDIRIKAN`, `TANGGAL_LAHIR`, `TIPE_ID`) VALUES
	('8081', 'it', '2017-02-24 16:25:59', NULL, NULL, 0, '7', 'Jl. Kaliam', '', '8081', 'Ngamrah', NULL, 'Grup 1', 'Idul Fitri', 'Kamis', 1, 'KB1', 'Kat 1', '40552', 'Cimohay', 60, 'Susi', 'Susi', '', '', 'Susi', 14000.00, 1500000.00, '8081', 'Jawa Barat', 750000.00, 'RISMA', 'SEWA', '2016-01-01 07:00:00', '2015-04-01 07:00:00', 'Type 1');
/*!40000 ALTER TABLE `m_customer` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_cutomer_contact
CREATE TABLE IF NOT EXISTS `m_cutomer_contact` (
  `CUSTOMER_CONTACT_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `CUSTOMER_FK` varchar(255) DEFAULT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `DEPARTMENT` varchar(50) DEFAULT NULL,
  `DIVISI` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `FAX` varchar(20) DEFAULT NULL,
  `HP` varchar(20) DEFAULT NULL,
  `INDEX_COUNT` int(11) DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `PIC` varchar(50) NOT NULL,
  `TELEPON` varchar(20) NOT NULL,
  PRIMARY KEY (`CUSTOMER_CONTACT_ID`),
  KEY `FK_a52sq1maiadltngn3b9vx1ari` (`CUSTOMER_FK`),
  CONSTRAINT `FK_a52sq1maiadltngn3b9vx1ari` FOREIGN KEY (`CUSTOMER_FK`) REFERENCES `m_customer` (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_cutomer_contact: ~-1 rows (approximately)
DELETE FROM `m_cutomer_contact`;
/*!40000 ALTER TABLE `m_cutomer_contact` DISABLE KEYS */;
INSERT INTO `m_cutomer_contact` (`CUSTOMER_CONTACT_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `CUSTOMER_FK`, `DATE_NON_ACTIVE`, `DEPARTMENT`, `DIVISI`, `EMAIL`, `FAX`, `HP`, `INDEX_COUNT`, `IS_ACTIVE`, `PIC`, `TELEPON`) VALUES
	('8081-1', 'it', '2017-02-24 16:25:59', NULL, NULL, 0, '8081', NULL, '', '', 'sus@imail.com', '', '081818181', 1, 1, 'Susi', '021212121'),
	('8081-2', 'it', '2017-02-24 16:27:35', NULL, NULL, 0, '8081', NULL, '', '', '', '', '078787878', 2, 1, 'Rendi', '0232323232');
/*!40000 ALTER TABLE `m_cutomer_contact` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_department_dtl
CREATE TABLE IF NOT EXISTS `m_department_dtl` (
  `DEPARTMENT_DTL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `DEPARTMENT_HDR_FK` varchar(255) NOT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `JAM_KELUAR` varchar(5) NOT NULL,
  `JAM_MASUK` varchar(5) NOT NULL,
  `SHIFT` varchar(15) NOT NULL,
  PRIMARY KEY (`DEPARTMENT_DTL_ID`),
  KEY `FK_nagdw3g3yyb93rh71m9ck4ce7` (`DEPARTMENT_HDR_FK`),
  CONSTRAINT `FK_nagdw3g3yyb93rh71m9ck4ce7` FOREIGN KEY (`DEPARTMENT_HDR_FK`) REFERENCES `m_department_hdr` (`DEPARTMENT_HDR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_department_dtl: ~-1 rows (approximately)
DELETE FROM `m_department_dtl`;
/*!40000 ALTER TABLE `m_department_dtl` DISABLE KEYS */;
INSERT INTO `m_department_dtl` (`DEPARTMENT_DTL_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `DEPARTMENT_HDR_FK`, `IS_ACTIVE`, `JAM_KELUAR`, `JAM_MASUK`, `SHIFT`) VALUES
	(3, 'it', '2017-02-27 16:36:10', NULL, NULL, 0, NULL, 'D1', 1, '21:30', '14:30', '2');
/*!40000 ALTER TABLE `m_department_dtl` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_department_hdr
CREATE TABLE IF NOT EXISTS `m_department_hdr` (
  `DEPARTMENT_HDR_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `NAMA` varchar(100) NOT NULL,
  PRIMARY KEY (`DEPARTMENT_HDR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_department_hdr: ~-1 rows (approximately)
DELETE FROM `m_department_hdr`;
/*!40000 ALTER TABLE `m_department_hdr` DISABLE KEYS */;
INSERT INTO `m_department_hdr` (`DEPARTMENT_HDR_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `IS_ACTIVE`, `NAMA`) VALUES
	('D1', 'it', '2017-02-27 16:28:27', NULL, NULL, 0, NULL, 1, 'Dept.1');
/*!40000 ALTER TABLE `m_department_hdr` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_detail_jenis_produk
CREATE TABLE IF NOT EXISTS `m_detail_jenis_produk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detail_jenis_produk` varchar(50) NOT NULL,
  `fk_jenis_produk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cvg9rq2os1e7tsoq3ev1ja4ng` (`fk_jenis_produk`),
  CONSTRAINT `FK_cvg9rq2os1e7tsoq3ev1ja4ng` FOREIGN KEY (`fk_jenis_produk`) REFERENCES `m_jenis_produk` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_detail_jenis_produk: ~-1 rows (approximately)
DELETE FROM `m_detail_jenis_produk`;
/*!40000 ALTER TABLE `m_detail_jenis_produk` DISABLE KEYS */;
/*!40000 ALTER TABLE `m_detail_jenis_produk` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_gudang
CREATE TABLE IF NOT EXISTS `m_gudang` (
  `GUDANG_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `ALAMAT` varchar(255) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `GUDANG_GRUP_FK` varchar(255) NOT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `IS_BOOKED` tinyint(1) NOT NULL,
  `IS_PUTIHKAN` tinyint(1) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `TGL_AWAL_STOK` datetime NOT NULL,
  PRIMARY KEY (`GUDANG_ID`),
  KEY `FK_ji74i19cp1n9p3qb5dnfjpbld` (`GUDANG_GRUP_FK`),
  CONSTRAINT `FK_ji74i19cp1n9p3qb5dnfjpbld` FOREIGN KEY (`GUDANG_GRUP_FK`) REFERENCES `m_gudang_grup` (`GUDANG_GRUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_gudang: ~-1 rows (approximately)
DELETE FROM `m_gudang`;
/*!40000 ALTER TABLE `m_gudang` DISABLE KEYS */;
INSERT INTO `m_gudang` (`GUDANG_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `ALAMAT`, `DATE_NON_ACTIVE`, `GUDANG_GRUP_FK`, `IS_ACTIVE`, `IS_BOOKED`, `IS_PUTIHKAN`, `NAMA`, `TGL_AWAL_STOK`) VALUES
	('GB1', 'it', '2017-02-21 11:47:39', NULL, NULL, 2, 'Padalrang', NULL, 'GB', 1, 1, 1, 'Gudang Barang Umum 2', '2017-01-01 00:00:00'),
	('GB2', 'it', '2017-02-21 11:47:59', NULL, NULL, 0, 'Padalrang', NULL, 'GB', 1, 1, 1, 'Gudang Barang Umum 2', '2017-01-01 00:00:00');
/*!40000 ALTER TABLE `m_gudang` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_gudang_grup
CREATE TABLE IF NOT EXISTS `m_gudang_grup` (
  `GUDANG_GRUP_ID` varchar(255) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  PRIMARY KEY (`GUDANG_GRUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_gudang_grup: ~-1 rows (approximately)
DELETE FROM `m_gudang_grup`;
/*!40000 ALTER TABLE `m_gudang_grup` DISABLE KEYS */;
INSERT INTO `m_gudang_grup` (`GUDANG_GRUP_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `IS_ACTIVE`, `NAMA`) VALUES
	('GB', 'it', '2017-02-20 15:49:51', NULL, NULL, 0, NULL, 1, 'Gudang Baik');
/*!40000 ALTER TABLE `m_gudang_grup` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_jenis_produk
CREATE TABLE IF NOT EXISTS `m_jenis_produk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jenis_produk` varchar(80) NOT NULL,
  `fk_kelompok_produk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q5dyc8t7tk1k49iju618ws0sv` (`fk_kelompok_produk`),
  CONSTRAINT `FK_q5dyc8t7tk1k49iju618ws0sv` FOREIGN KEY (`fk_kelompok_produk`) REFERENCES `m_kelompok_produk` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_jenis_produk: ~-1 rows (approximately)
DELETE FROM `m_jenis_produk`;
/*!40000 ALTER TABLE `m_jenis_produk` DISABLE KEYS */;
/*!40000 ALTER TABLE `m_jenis_produk` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_kas_bank
CREATE TABLE IF NOT EXISTS `m_kas_bank` (
  `KAS_BANK_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `AKUN_FK` varchar(255) NOT NULL,
  `ATAS_NAMA` varchar(100) DEFAULT NULL,
  `BANK` varchar(100) DEFAULT NULL,
  `CABANG` varchar(50) DEFAULT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `DESKRIPSI` varchar(100) NOT NULL,
  `GROUP_ID` varchar(50) NOT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `KURS` decimal(19,2) NOT NULL,
  `MATA_UANG_FK` varchar(255) NOT NULL,
  `NO_REK` varchar(50) DEFAULT NULL,
  `PERLU_PASSWORD` tinyint(1) NOT NULL,
  `PLAFON_KREDIT` decimal(19,2) NOT NULL,
  `SALDO_AWAL` decimal(19,2) NOT NULL,
  `SALDO_AWAL_RP` decimal(19,2) NOT NULL,
  `SALES_BILING` tinyint(1) NOT NULL,
  `TANGGAL_REGISTRASI` datetime DEFAULT NULL,
  PRIMARY KEY (`KAS_BANK_ID`),
  KEY `FK_4jdmf5tons6ht9b94b8v4ges7` (`AKUN_FK`),
  KEY `FK_lratgqm9k2p7v5oqv3ypmeruy` (`MATA_UANG_FK`),
  CONSTRAINT `FK_4jdmf5tons6ht9b94b8v4ges7` FOREIGN KEY (`AKUN_FK`) REFERENCES `m_akun` (`AKUN_ID`),
  CONSTRAINT `FK_lratgqm9k2p7v5oqv3ypmeruy` FOREIGN KEY (`MATA_UANG_FK`) REFERENCES `m_mata_uang` (`MATA_UANG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_kas_bank: ~-1 rows (approximately)
DELETE FROM `m_kas_bank`;
/*!40000 ALTER TABLE `m_kas_bank` DISABLE KEYS */;
INSERT INTO `m_kas_bank` (`KAS_BANK_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `AKUN_FK`, `ATAS_NAMA`, `BANK`, `CABANG`, `DATE_NON_ACTIVE`, `DESKRIPSI`, `GROUP_ID`, `IS_ACTIVE`, `KURS`, `MATA_UANG_FK`, `NO_REK`, `PERLU_PASSWORD`, `PLAFON_KREDIT`, `SALDO_AWAL`, `SALDO_AWAL_RP`, `SALES_BILING`, `TANGGAL_REGISTRASI`) VALUES
	('KB1', 'it', '2017-02-21 11:20:45', NULL, NULL, 0, '7', 'YTH', 'BCA', 'Cimahi', NULL, 'Buku Kas 1', 'Grup 1', 1, 1.00, 'Rp', '1234567890', 0, 1.00, 20000.00, 20000.00, 0, '2017-02-21 00:00:00');
/*!40000 ALTER TABLE `m_kas_bank` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_kelompok_produk
CREATE TABLE IF NOT EXISTS `m_kelompok_produk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kelompok_produk` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_kelompok_produk: ~-1 rows (approximately)
DELETE FROM `m_kelompok_produk`;
/*!40000 ALTER TABLE `m_kelompok_produk` DISABLE KEYS */;
/*!40000 ALTER TABLE `m_kelompok_produk` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_login_user
CREATE TABLE IF NOT EXISTS `m_login_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_add` tinyint(1) DEFAULT NULL,
  `is_confirm` tinyint(1) DEFAULT NULL,
  `KataSandi` varchar(50) NOT NULL,
  `NamaUser` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_login_user: ~-1 rows (approximately)
DELETE FROM `m_login_user`;
/*!40000 ALTER TABLE `m_login_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `m_login_user` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_mata_uang
CREATE TABLE IF NOT EXISTS `m_mata_uang` (
  `MATA_UANG_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  PRIMARY KEY (`MATA_UANG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_mata_uang: ~-1 rows (approximately)
DELETE FROM `m_mata_uang`;
/*!40000 ALTER TABLE `m_mata_uang` DISABLE KEYS */;
INSERT INTO `m_mata_uang` (`MATA_UANG_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `IS_ACTIVE`) VALUES
	('JPY', 'it', '2017-03-01 16:03:12', NULL, NULL, 0, NULL, 1),
	('JPY2', 'it', '2017-03-01 16:39:53', NULL, NULL, 0, NULL, 1),
	('JPY3', 'it', '2017-03-02 16:19:30', NULL, NULL, 0, NULL, 1),
	('Rp', 'it', '2017-02-20 13:17:56', NULL, NULL, 0, NULL, 1);
/*!40000 ALTER TABLE `m_mata_uang` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_module
CREATE TABLE IF NOT EXISTS `m_module` (
  `MODULE_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `ICON` varchar(255) DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `MODULE_FK` varchar(255) DEFAULT NULL,
  `NAMA` varchar(50) NOT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `STATUS` varchar(1) DEFAULT NULL,
  `URUTAN` int(11) DEFAULT NULL,
  `PATH_MAP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MODULE_ID`),
  KEY `FK_3b7evnppshn7m9btxsxipdbr7` (`MODULE_FK`),
  CONSTRAINT `FK_3b7evnppshn7m9btxsxipdbr7` FOREIGN KEY (`MODULE_FK`) REFERENCES `m_module` (`MODULE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_module: ~-1 rows (approximately)
DELETE FROM `m_module`;
/*!40000 ALTER TABLE `m_module` DISABLE KEYS */;
INSERT INTO `m_module` (`MODULE_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `ICON`, `IS_ACTIVE`, `MODULE_FK`, `NAMA`, `STATE`, `STATUS`, `URUTAN`, `PATH_MAP`) VALUES
	('HOME', 'it', '2017-02-24 14:28:16', NULL, NULL, 0, NULL, 'fa-dashboard', 1, NULL, 'Home', 'dashboard.home', '0', 1, '/mataUang'),
	('QWE', 'it', '2017-02-22 13:38:18', NULL, NULL, 0, NULL, 'asd', 1, 'HOME', 'qwe', 'qwe.asd', '0', 0, NULL);
/*!40000 ALTER TABLE `m_module` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_pegawai
CREATE TABLE IF NOT EXISTS `m_pegawai` (
  `PEGAWAI_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `AGAMA` varchar(15) NOT NULL,
  `AKHIR_KONTRAK` datetime DEFAULT NULL,
  `AKUN_FK` varchar(255) NOT NULL,
  `ALAMAT` varchar(255) NOT NULL,
  `ATAS_NAMA` varchar(100) DEFAULT NULL,
  `BANK` varchar(100) DEFAULT NULL,
  `BONUS` decimal(19,2) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `DEPARTMENT_HDR_FK` varchar(255) DEFAULT NULL,
  `DIVISI` varchar(20) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `GAJI_POKOK` decimal(19,2) NOT NULL,
  `GOL` varchar(20) NOT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `JABATAN` varchar(50) NOT NULL,
  `KOTA` varchar(50) NOT NULL,
  `LP` varchar(1) NOT NULL,
  `MATA_UANG_FK` varchar(255) NOT NULL,
  `MULAI_BEKERJA` datetime DEFAULT NULL,
  `NAMA` varchar(100) NOT NULL,
  `NO_HP` varchar(25) NOT NULL,
  `NO_KTP` varchar(30) NOT NULL,
  `NO_REKENING` varchar(50) DEFAULT NULL,
  `NO_SIM` varchar(30) NOT NULL,
  `NO_TELEPON` varchar(25) NOT NULL,
  `PLAFON_RP` decimal(19,2) NOT NULL,
  `STATUS` varchar(15) NOT NULL,
  `TANGGAL_LAHIR` datetime NOT NULL,
  `UANG_HADIR` decimal(19,2) NOT NULL,
  `UANG_JABATAN` decimal(19,2) NOT NULL,
  PRIMARY KEY (`PEGAWAI_ID`),
  KEY `FK_mjaaguvfx9k3w86qwhsvox1yn` (`AKUN_FK`),
  KEY `FK_7nvpfo2wln7u1ltatxi0ehk2u` (`DEPARTMENT_HDR_FK`),
  KEY `FK_fyshkokdv8ltckdc19toib4n9` (`MATA_UANG_FK`),
  CONSTRAINT `FK_7nvpfo2wln7u1ltatxi0ehk2u` FOREIGN KEY (`DEPARTMENT_HDR_FK`) REFERENCES `m_department_hdr` (`DEPARTMENT_HDR_ID`),
  CONSTRAINT `FK_fyshkokdv8ltckdc19toib4n9` FOREIGN KEY (`MATA_UANG_FK`) REFERENCES `m_mata_uang` (`MATA_UANG_ID`),
  CONSTRAINT `FK_mjaaguvfx9k3w86qwhsvox1yn` FOREIGN KEY (`AKUN_FK`) REFERENCES `m_akun` (`AKUN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_pegawai: ~-1 rows (approximately)
DELETE FROM `m_pegawai`;
/*!40000 ALTER TABLE `m_pegawai` DISABLE KEYS */;
/*!40000 ALTER TABLE `m_pegawai` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_produk
CREATE TABLE IF NOT EXISTS `m_produk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama_produk` varchar(255) NOT NULL,
  `fk_detail_jenis_produk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7cervu3mxnam68pw9fds751jv` (`fk_detail_jenis_produk`),
  CONSTRAINT `FK_7cervu3mxnam68pw9fds751jv` FOREIGN KEY (`fk_detail_jenis_produk`) REFERENCES `m_detail_jenis_produk` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_produk: ~-1 rows (approximately)
DELETE FROM `m_produk`;
/*!40000 ALTER TABLE `m_produk` DISABLE KEYS */;
/*!40000 ALTER TABLE `m_produk` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_prospek
CREATE TABLE IF NOT EXISTS `m_prospek` (
  `PROSPEK_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `ALAMAT` varchar(255) NOT NULL,
  `ALAMAT_PKP` varchar(255) DEFAULT NULL,
  `DAERAH` varchar(50) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `GRUP_ID` varchar(50) NOT NULL,
  `HARI_RAYA` varchar(30) DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `KATEGORI_ID` varchar(50) NOT NULL,
  `KODE_POS` varchar(50) NOT NULL,
  `KOTA` varchar(50) NOT NULL,
  `NAMA` varchar(100) NOT NULL,
  `NAMA_PKP` varchar(50) DEFAULT NULL,
  `NPWP` varchar(50) DEFAULT NULL,
  `PEMILIK` varchar(50) DEFAULT NULL,
  `PROVINSI` varchar(50) NOT NULL,
  `SALES_FK` varchar(255) DEFAULT NULL,
  `STATUS_PROPERTY` varchar(10) DEFAULT NULL,
  `TANGGAL_DIDIRIKAN` datetime DEFAULT NULL,
  `TANGGAL_LAHIR` datetime DEFAULT NULL,
  `TIPE_ID` varchar(50) NOT NULL,
  PRIMARY KEY (`PROSPEK_ID`),
  KEY `FK_c784bs6vq4ad5j0c93gg3rp0d` (`SALES_FK`),
  CONSTRAINT `FK_c784bs6vq4ad5j0c93gg3rp0d` FOREIGN KEY (`SALES_FK`) REFERENCES `m_sales` (`SALES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_prospek: ~-1 rows (approximately)
DELETE FROM `m_prospek`;
/*!40000 ALTER TABLE `m_prospek` DISABLE KEYS */;
INSERT INTO `m_prospek` (`PROSPEK_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `ALAMAT`, `ALAMAT_PKP`, `DAERAH`, `DATE_NON_ACTIVE`, `GRUP_ID`, `HARI_RAYA`, `IS_ACTIVE`, `KATEGORI_ID`, `KODE_POS`, `KOTA`, `NAMA`, `NAMA_PKP`, `NPWP`, `PEMILIK`, `PROVINSI`, `SALES_FK`, `STATUS_PROPERTY`, `TANGGAL_DIDIRIKAN`, `TANGGAL_LAHIR`, `TIPE_ID`) VALUES
	('8081', 'it', '2017-02-24 15:12:52', NULL, NULL, 0, 'Jl. Kaliam', '', 'Ngamrah', NULL, 'Grup 1', 'Idul Fitri', 1, 'Kat 1', '40553', 'Cimohay', 'Susi', '', '', 'Susi', 'Jawa Barat', 'RISMA', 'SEWA', '2016-01-01 07:00:00', '2015-04-01 07:00:00', 'Type 1');
/*!40000 ALTER TABLE `m_prospek` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_prospek_contact
CREATE TABLE IF NOT EXISTS `m_prospek_contact` (
  `PROSPEK_CONTACT_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `DEPARTMENT` varchar(50) DEFAULT NULL,
  `DIVISI` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `FAX` varchar(20) DEFAULT NULL,
  `HP` varchar(20) DEFAULT NULL,
  `INDEX_COUNT` int(11) DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `PIC` varchar(50) NOT NULL,
  `PROSPEK_FK` varchar(255) DEFAULT NULL,
  `TELEPON` varchar(20) NOT NULL,
  PRIMARY KEY (`PROSPEK_CONTACT_ID`),
  KEY `FK_8r9c9ymr56mdlsj2a92m1lq69` (`PROSPEK_FK`),
  CONSTRAINT `FK_8r9c9ymr56mdlsj2a92m1lq69` FOREIGN KEY (`PROSPEK_FK`) REFERENCES `m_prospek` (`PROSPEK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_prospek_contact: ~-1 rows (approximately)
DELETE FROM `m_prospek_contact`;
/*!40000 ALTER TABLE `m_prospek_contact` DISABLE KEYS */;
INSERT INTO `m_prospek_contact` (`PROSPEK_CONTACT_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `DEPARTMENT`, `DIVISI`, `EMAIL`, `FAX`, `HP`, `INDEX_COUNT`, `IS_ACTIVE`, `PIC`, `PROSPEK_FK`, `TELEPON`) VALUES
	('8081-2', 'it', '2017-02-24 15:15:08', NULL, NULL, 0, NULL, '', '', '', '', '0878787878', 2, 1, 'Rio', '8081', '022222222'),
	('8081-3', 'it', '2017-02-24 15:15:37', NULL, NULL, 0, NULL, '', '', '', '', '123412312', 3, 1, 'Zae', '8081', '543122');
/*!40000 ALTER TABLE `m_prospek_contact` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_role
CREATE TABLE IF NOT EXISTS `m_role` (
  `ROLE_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_role: ~-1 rows (approximately)
DELETE FROM `m_role`;
/*!40000 ALTER TABLE `m_role` DISABLE KEYS */;
INSERT INTO `m_role` (`ROLE_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `IS_ACTIVE`, `NAMA`) VALUES
	('ACC2', 'it', '2017-02-27 12:37:31', NULL, NULL, 0, NULL, 1, 'Acc2222'),
	('PROD', 'it', '2017-02-21 09:05:51', NULL, NULL, 0, NULL, 1, 'Produksi');
/*!40000 ALTER TABLE `m_role` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_role_widget
CREATE TABLE IF NOT EXISTS `m_role_widget` (
  `M_ROLE_WIDGET_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_FK` varchar(255) NOT NULL,
  `WIDGET_FK` varchar(255) NOT NULL,
  PRIMARY KEY (`M_ROLE_WIDGET_ID`),
  KEY `FK_qpglau1ar468w7iwsywii2e7s` (`ROLE_FK`),
  KEY `FK_5tah0s8ml4uoa06ljc6q611h9` (`WIDGET_FK`),
  CONSTRAINT `FK_5tah0s8ml4uoa06ljc6q611h9` FOREIGN KEY (`WIDGET_FK`) REFERENCES `m_widget` (`WIDGET_ID`),
  CONSTRAINT `FK_qpglau1ar468w7iwsywii2e7s` FOREIGN KEY (`ROLE_FK`) REFERENCES `m_role` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_role_widget: ~-1 rows (approximately)
DELETE FROM `m_role_widget`;
/*!40000 ALTER TABLE `m_role_widget` DISABLE KEYS */;
INSERT INTO `m_role_widget` (`M_ROLE_WIDGET_ID`, `ROLE_FK`, `WIDGET_FK`) VALUES
	(1, 'ACC2', 'MRU'),
	(2, 'PROD', 'MRU');
/*!40000 ALTER TABLE `m_role_widget` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_sales
CREATE TABLE IF NOT EXISTS `m_sales` (
  `SALES_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `GRUP_ID` varchar(255) DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `USER_FK` varchar(255) NOT NULL,
  PRIMARY KEY (`SALES_ID`),
  KEY `FK_71i9t3gryb77yk1cnq29g4eh3` (`USER_FK`),
  CONSTRAINT `FK_71i9t3gryb77yk1cnq29g4eh3` FOREIGN KEY (`USER_FK`) REFERENCES `m_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_sales: ~-1 rows (approximately)
DELETE FROM `m_sales`;
/*!40000 ALTER TABLE `m_sales` DISABLE KEYS */;
INSERT INTO `m_sales` (`SALES_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `GRUP_ID`, `IS_ACTIVE`, `NAMA`, `USER_FK`) VALUES
	('RISMA', 'it', '2017-02-24 15:12:27', NULL, NULL, 0, NULL, 'Follow Up', 1, 'Risma', 'it');
/*!40000 ALTER TABLE `m_sales` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_supplier
CREATE TABLE IF NOT EXISTS `m_supplier` (
  `SUPPLIER_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `ACC_UM_ID` varchar(255) NOT NULL,
  `ALAMAT` varchar(50) NOT NULL,
  `ALAMAT_PKP` varchar(255) DEFAULT NULL,
  `ATAS_NAMA` varchar(50) DEFAULT NULL,
  `BANK` varchar(50) DEFAULT NULL,
  `BARCODE` varchar(50) DEFAULT NULL,
  `CABANG` varchar(50) DEFAULT NULL,
  `DAERAH` varchar(50) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `GROUP_ID` varchar(50) NOT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `KODE_PO` int(11) NOT NULL,
  `LAMA_BAYAR` int(11) NOT NULL,
  `MATA_UANG_FK` varchar(255) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `NAMA_PKP` varchar(50) DEFAULT NULL,
  `NOREK` varchar(30) DEFAULT NULL,
  `NPWP` varchar(50) DEFAULT NULL,
  `PLAFON_RP` decimal(19,2) NOT NULL,
  `SALDO_AWAL` decimal(19,2) NOT NULL,
  `UL` varchar(50) DEFAULT NULL,
  `WILAYAH` varchar(50) NOT NULL,
  PRIMARY KEY (`SUPPLIER_ID`),
  KEY `FK_t3dqu310qxxu8i8qe66dotirb` (`ACC_UM_ID`),
  KEY `FK_p3sredcgd9e7w4m0r7tdg06e1` (`MATA_UANG_FK`),
  CONSTRAINT `FK_p3sredcgd9e7w4m0r7tdg06e1` FOREIGN KEY (`MATA_UANG_FK`) REFERENCES `m_mata_uang` (`MATA_UANG_ID`),
  CONSTRAINT `FK_t3dqu310qxxu8i8qe66dotirb` FOREIGN KEY (`ACC_UM_ID`) REFERENCES `m_akun` (`AKUN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_supplier: ~-1 rows (approximately)
DELETE FROM `m_supplier`;
/*!40000 ALTER TABLE `m_supplier` DISABLE KEYS */;
INSERT INTO `m_supplier` (`SUPPLIER_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `ACC_UM_ID`, `ALAMAT`, `ALAMAT_PKP`, `ATAS_NAMA`, `BANK`, `BARCODE`, `CABANG`, `DAERAH`, `DATE_NON_ACTIVE`, `GROUP_ID`, `IS_ACTIVE`, `KODE_PO`, `LAMA_BAYAR`, `MATA_UANG_FK`, `NAMA`, `NAMA_PKP`, `NOREK`, `NPWP`, `PLAFON_RP`, `SALDO_AWAL`, `UL`, `WILAYAH`) VALUES
	('CT', 'it', '2017-02-24 10:05:43', NULL, NULL, 0, '7', 'Jl. Cibaligo', '', 'Textilindo', 'BCA', '', 'Cimahi', 'Jawa Barat', NULL, 'Grup 1', 1, 27, 60, 'Rp', 'Cimahi Textilindo', '', '1234567890', '', 500000.00, 1500000.00, 'qwe', 'Bandung');
/*!40000 ALTER TABLE `m_supplier` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_supplier_contact
CREATE TABLE IF NOT EXISTS `m_supplier_contact` (
  `SUPLIER_CONTACT_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `DEPARTMENT` varchar(50) DEFAULT NULL,
  `DIVISI` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(20) DEFAULT NULL,
  `FAX` varchar(20) DEFAULT NULL,
  `HP` varchar(20) DEFAULT NULL,
  `INDEX_COUNT` int(11) DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `PIC` varchar(50) NOT NULL,
  `SUPPLIER_FK` varchar(255) DEFAULT NULL,
  `TELEPON` varchar(20) NOT NULL,
  PRIMARY KEY (`SUPLIER_CONTACT_ID`),
  KEY `FK_gr5qdswgye2kspeuhx3xuw2rh` (`SUPPLIER_FK`),
  CONSTRAINT `FK_gr5qdswgye2kspeuhx3xuw2rh` FOREIGN KEY (`SUPPLIER_FK`) REFERENCES `m_supplier` (`SUPPLIER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_supplier_contact: ~-1 rows (approximately)
DELETE FROM `m_supplier_contact`;
/*!40000 ALTER TABLE `m_supplier_contact` DISABLE KEYS */;
INSERT INTO `m_supplier_contact` (`SUPLIER_CONTACT_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `DEPARTMENT`, `DIVISI`, `EMAIL`, `FAX`, `HP`, `INDEX_COUNT`, `IS_ACTIVE`, `PIC`, `SUPPLIER_FK`, `TELEPON`) VALUES
	('CT-1', 'it', '2017-02-24 10:05:43', NULL, NULL, 0, NULL, '', '', '', '', '0808080808', 1, 1, 'Jajang', 'CT', '0221234567'),
	('CT-2', 'it', '2017-02-24 10:05:43', NULL, NULL, 0, NULL, '', '', '', '', '08131313131', 2, 1, 'Erik', 'CT', '021321321321'),
	('CT-3', 'it', '2017-02-24 10:55:29', NULL, NULL, 0, NULL, '', '', 'rudi@mail.com', '', '08787878787', 3, 1, 'Rudi', 'CT', '0232323232');
/*!40000 ALTER TABLE `m_supplier_contact` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_unit
CREATE TABLE IF NOT EXISTS `m_unit` (
  `UNIT_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  PRIMARY KEY (`UNIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_unit: ~-1 rows (approximately)
DELETE FROM `m_unit`;
/*!40000 ALTER TABLE `m_unit` DISABLE KEYS */;
INSERT INTO `m_unit` (`UNIT_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `IS_ACTIVE`, `NAMA`) VALUES
	('GR', 'it', '2017-02-23 08:58:31', NULL, NULL, 0, NULL, 1, 'Gram'),
	('KG', 'it', '2017-02-23 08:58:31', NULL, NULL, 0, NULL, 1, 'Kilogram');
/*!40000 ALTER TABLE `m_unit` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_user
CREATE TABLE IF NOT EXISTS `m_user` (
  `USER_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `IS_CANCEL` tinyint(1) NOT NULL,
  `IS_CONFIRM` tinyint(1) NOT NULL,
  `IS_CREATE` tinyint(1) NOT NULL,
  `IS_DELETE` tinyint(1) NOT NULL,
  `IS_PRINT` tinyint(1) NOT NULL,
  `IS_REPORT` tinyint(1) NOT NULL,
  `IS_SUPERUSER` tinyint(1) NOT NULL,
  `IS_SUPERVISOR` tinyint(1) NOT NULL,
  `IS_UNCONFIRM` tinyint(1) NOT NULL,
  `IS_UPDATE` tinyint(1) NOT NULL,
  `MRU_LIMIT` int(11) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `PEGAWAI_FK` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `FK_f3oq94dqmxxucswj7ti4w968d` (`PEGAWAI_FK`),
  CONSTRAINT `FK_f3oq94dqmxxucswj7ti4w968d` FOREIGN KEY (`PEGAWAI_FK`) REFERENCES `m_pegawai` (`PEGAWAI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_user: ~-1 rows (approximately)
DELETE FROM `m_user`;
/*!40000 ALTER TABLE `m_user` DISABLE KEYS */;
INSERT INTO `m_user` (`USER_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `IS_ACTIVE`, `IS_CANCEL`, `IS_CONFIRM`, `IS_CREATE`, `IS_DELETE`, `IS_PRINT`, `IS_REPORT`, `IS_SUPERUSER`, `IS_SUPERVISOR`, `IS_UNCONFIRM`, `IS_UPDATE`, `MRU_LIMIT`, `NAMA`, `PASSWORD`, `PEGAWAI_FK`) VALUES
	('it', 'jim', '2015-01-19 09:37:19', 'it', '2016-06-13 08:51:57', 111, NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 'IT', '7R2bV7up7EoB5LsJqEo08yVz1kQ=$t5D3plyB2IY=', NULL),
	('TEST', 'it', '2017-02-22 09:16:48', NULL, NULL, 0, NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 'test', 'fG5OxlUVapE/tHyzWd0eGxhR8/I=$1ybc6pLdhOw=', NULL),
	('TEST99', 'it', '2017-02-28 15:16:28', NULL, NULL, 0, NULL, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 'Test 99', '+lOsSuRlK8LDKBdi+trnH48eXSY=$O/7KbxfBX80=', NULL);
/*!40000 ALTER TABLE `m_user` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_user_gudang
CREATE TABLE IF NOT EXISTS `m_user_gudang` (
  `USER_GUDANG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `GUDANG_FK` varchar(255) NOT NULL,
  `USER_FK` varchar(255) NOT NULL,
  PRIMARY KEY (`USER_GUDANG_ID`),
  KEY `FK_4sp5nb07848oc3kg51kseacpk` (`GUDANG_FK`),
  KEY `FK_7seqwh8xvdhjnk6sx33t8umuk` (`USER_FK`),
  CONSTRAINT `FK_4sp5nb07848oc3kg51kseacpk` FOREIGN KEY (`GUDANG_FK`) REFERENCES `m_gudang` (`GUDANG_ID`),
  CONSTRAINT `FK_7seqwh8xvdhjnk6sx33t8umuk` FOREIGN KEY (`USER_FK`) REFERENCES `m_user` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_user_gudang: ~-1 rows (approximately)
DELETE FROM `m_user_gudang`;
/*!40000 ALTER TABLE `m_user_gudang` DISABLE KEYS */;
INSERT INTO `m_user_gudang` (`USER_GUDANG_ID`, `GUDANG_FK`, `USER_FK`) VALUES
	(1, 'GB1', 'it'),
	(2, 'GB2', 'TEST');
/*!40000 ALTER TABLE `m_user_gudang` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_user_kas_bank
CREATE TABLE IF NOT EXISTS `m_user_kas_bank` (
  `USER_KAS_BANK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `KAS_BANK_FK` varchar(255) NOT NULL,
  `USER_FK` varchar(255) NOT NULL,
  PRIMARY KEY (`USER_KAS_BANK_ID`),
  KEY `FK_9fnikbva6jnp8dvkrwos11gru` (`KAS_BANK_FK`),
  KEY `FK_iubd8unbtqvshyf2qlpcvq7ta` (`USER_FK`),
  CONSTRAINT `FK_9fnikbva6jnp8dvkrwos11gru` FOREIGN KEY (`KAS_BANK_FK`) REFERENCES `m_kas_bank` (`KAS_BANK_ID`),
  CONSTRAINT `FK_iubd8unbtqvshyf2qlpcvq7ta` FOREIGN KEY (`USER_FK`) REFERENCES `m_user` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_user_kas_bank: ~-1 rows (approximately)
DELETE FROM `m_user_kas_bank`;
/*!40000 ALTER TABLE `m_user_kas_bank` DISABLE KEYS */;
INSERT INTO `m_user_kas_bank` (`USER_KAS_BANK_ID`, `KAS_BANK_FK`, `USER_FK`) VALUES
	(1, 'KB1', 'it');
/*!40000 ALTER TABLE `m_user_kas_bank` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_user_mru
CREATE TABLE IF NOT EXISTS `m_user_mru` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MODULE_FK` varchar(255) NOT NULL,
  `TANGGAL_AKSES` datetime NOT NULL,
  `USER_FK` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_klij8nj5voioxl7l4qyk3w10l` (`MODULE_FK`),
  KEY `FK_7c15lr0359gbe076a1tyxt61h` (`USER_FK`),
  CONSTRAINT `FK_7c15lr0359gbe076a1tyxt61h` FOREIGN KEY (`USER_FK`) REFERENCES `m_user` (`USER_ID`),
  CONSTRAINT `FK_klij8nj5voioxl7l4qyk3w10l` FOREIGN KEY (`MODULE_FK`) REFERENCES `m_module` (`MODULE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_user_mru: ~-1 rows (approximately)
DELETE FROM `m_user_mru`;
/*!40000 ALTER TABLE `m_user_mru` DISABLE KEYS */;
INSERT INTO `m_user_mru` (`ID`, `MODULE_FK`, `TANGGAL_AKSES`, `USER_FK`) VALUES
	(1, 'QWE', '2017-02-23 10:03:25', 'it'),
	(2, 'QWE', '2017-02-23 10:04:12', 'it'),
	(3, 'QWE', '2017-02-23 10:04:13', 'it'),
	(4, 'QWE', '2017-02-23 10:04:14', 'it'),
	(5, 'QWE', '2017-02-23 10:04:14', 'it'),
	(6, 'QWE', '2017-02-23 10:04:15', 'it');
/*!40000 ALTER TABLE `m_user_mru` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_user_role
CREATE TABLE IF NOT EXISTS `m_user_role` (
  `USER_ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_FK` varchar(255) NOT NULL,
  `USER_FK` varchar(255) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  KEY `FK_sbdh98q685ij8waes27b0hyjm` (`ROLE_FK`),
  KEY `FK_8poj55ky96r1rv8k3is998we9` (`USER_FK`),
  CONSTRAINT `FK_8poj55ky96r1rv8k3is998we9` FOREIGN KEY (`USER_FK`) REFERENCES `m_user` (`USER_ID`),
  CONSTRAINT `FK_sbdh98q685ij8waes27b0hyjm` FOREIGN KEY (`ROLE_FK`) REFERENCES `m_role` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_user_role: ~-1 rows (approximately)
DELETE FROM `m_user_role`;
/*!40000 ALTER TABLE `m_user_role` DISABLE KEYS */;
INSERT INTO `m_user_role` (`USER_ROLE_ID`, `ROLE_FK`, `USER_FK`) VALUES
	(1, 'ACC2', 'it'),
	(2, 'PROD', 'TEST');
/*!40000 ALTER TABLE `m_user_role` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.m_widget
CREATE TABLE IF NOT EXISTS `m_widget` (
  `WIDGET_ID` varchar(50) NOT NULL,
  `CREATE_BY` varchar(50) NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `LAST_UPDATE_BY` varchar(50) DEFAULT NULL,
  `LAST_UPDATE_DATE` datetime DEFAULT NULL,
  `VERSION` int(11) NOT NULL,
  `DATE_NON_ACTIVE` datetime DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL,
  `NAMA` varchar(50) NOT NULL,
  PRIMARY KEY (`WIDGET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.m_widget: ~-1 rows (approximately)
DELETE FROM `m_widget`;
/*!40000 ALTER TABLE `m_widget` DISABLE KEYS */;
INSERT INTO `m_widget` (`WIDGET_ID`, `CREATE_BY`, `CREATE_DATE`, `LAST_UPDATE_BY`, `LAST_UPDATE_DATE`, `VERSION`, `DATE_NON_ACTIVE`, `IS_ACTIVE`, `NAMA`) VALUES
	('MRU', 'it', '2017-02-28 14:22:48', 'it', '2017-02-28 14:32:28', 12, NULL, 1, 'User MRU');
/*!40000 ALTER TABLE `m_widget` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.t_detail_komponen_harga
CREATE TABLE IF NOT EXISTS `t_detail_komponen_harga` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deskripsi` varchar(80) NOT NULL,
  `fk_struk_order_detail` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q8atwbd0v63tv26evce6syjdl` (`fk_struk_order_detail`),
  CONSTRAINT `FK_q8atwbd0v63tv26evce6syjdl` FOREIGN KEY (`fk_struk_order_detail`) REFERENCES `t_struk_order_detail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.t_detail_komponen_harga: ~-1 rows (approximately)
DELETE FROM `t_detail_komponen_harga`;
/*!40000 ALTER TABLE `t_detail_komponen_harga` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_detail_komponen_harga` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.t_struk_order
CREATE TABLE IF NOT EXISTS `t_struk_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggalOrder` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.t_struk_order: ~-1 rows (approximately)
DELETE FROM `t_struk_order`;
/*!40000 ALTER TABLE `t_struk_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_struk_order` ENABLE KEYS */;

-- Dumping structure for table hkis_v2.t_struk_order_detail
CREATE TABLE IF NOT EXISTS `t_struk_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_produk` int(11) NOT NULL,
  `fk_struk_order` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cmjiipbm6aaly5739higs2aon` (`fk_produk`),
  KEY `FK_fmeknp5pqniryygqt2is8qeak` (`fk_struk_order`),
  CONSTRAINT `FK_cmjiipbm6aaly5739higs2aon` FOREIGN KEY (`fk_produk`) REFERENCES `m_produk` (`id`),
  CONSTRAINT `FK_fmeknp5pqniryygqt2is8qeak` FOREIGN KEY (`fk_struk_order`) REFERENCES `t_struk_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table hkis_v2.t_struk_order_detail: ~-1 rows (approximately)
DELETE FROM `t_struk_order_detail`;
/*!40000 ALTER TABLE `t_struk_order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_struk_order_detail` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
