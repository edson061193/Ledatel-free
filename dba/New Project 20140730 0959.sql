-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.15


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema ledatel
--

CREATE DATABASE IF NOT EXISTS ledatel;
USE ledatel;

--
-- Temporary table structure for view `v_compra_producto`
--
DROP TABLE IF EXISTS `v_compra_producto`;
DROP VIEW IF EXISTS `v_compra_producto`;
CREATE TABLE `v_compra_producto` (
  `CODIGOPRODUCTO` varchar(10),
  `MARCA` varchar(50),
  `SERIE` varchar(50),
  `PRECIOCOMPRA` decimal(10,2),
  `PRECIOVENTA` decimal(10,2),
  `CANTIDAD` int(11),
  `FECHA` date,
  `SOCIEDAD` varchar(50),
  `ESTADO` varchar(30)
);

--
-- Temporary table structure for view `v_compras`
--
DROP TABLE IF EXISTS `v_compras`;
DROP VIEW IF EXISTS `v_compras`;
CREATE TABLE `v_compras` (
  `CODIGOPRODUCTO` varchar(10),
  `MARCA` varchar(50),
  `SERIE` varchar(50),
  `COSTOS` decimal(10,0),
  `CANTIDAD` int(11),
  `FECHA` date,
  `SOCIEDAD` varchar(50),
  `ESTADO` varchar(30)
);

--
-- Temporary table structure for view `v_contrato`
--
DROP TABLE IF EXISTS `v_contrato`;
DROP VIEW IF EXISTS `v_contrato`;
CREATE TABLE `v_contrato` (
  `CODCONTRADO` char(6),
  `DNI` char(8),
  `DATOS` varchar(50),
  `CODIGOPRODUCTO` varchar(10),
  `MARCA` varchar(50),
  `SERIE` varchar(50)
);

--
-- Temporary table structure for view `v_empleados`
--
DROP TABLE IF EXISTS `v_empleados`;
DROP VIEW IF EXISTS `v_empleados`;
CREATE TABLE `v_empleados` (
  `codigoEmpleado` char(6),
  `dni` char(8),
  `apellidos` varchar(30),
  `nombres` varchar(30),
  `direccion` varchar(50),
  `correo` varchar(50),
  `telefono` varchar(10),
  `tipoempleado` varchar(30),
  `sueldo` decimal(10,2),
  `estado` varchar(10)
);

--
-- Temporary table structure for view `v_producto_ventas`
--
DROP TABLE IF EXISTS `v_producto_ventas`;
DROP VIEW IF EXISTS `v_producto_ventas`;
CREATE TABLE `v_producto_ventas` (
  `TIPO` varchar(50),
  `CODIGOPRODUCTO` varchar(10),
  `MARCA` varchar(50),
  `SERIE` varchar(50),
  `PRECIOVENTA` decimal(10,2),
  `CANTIDAD` int(11),
  `OBSERVACION` text,
  `ESTADO` varchar(30)
);

--
-- Temporary table structure for view `v_reparaciones`
--
DROP TABLE IF EXISTS `v_reparaciones`;
DROP VIEW IF EXISTS `v_reparaciones`;
CREATE TABLE `v_reparaciones` (
  `FACTURA` varchar(10),
  `TIPO` varchar(50),
  `CODIGOPRODUCTO` varchar(10),
  `MARCA` varchar(50),
  `SERIE` varchar(50),
  `OBSERVACION` varchar(50),
  `COSTO` decimal(10,2),
  `CANTIDAD` int(11),
  `IMPORTE` decimal(10,2),
  `FECHA` date
);

--
-- Temporary table structure for view `v_ventas`
--
DROP TABLE IF EXISTS `v_ventas`;
DROP VIEW IF EXISTS `v_ventas`;
CREATE TABLE `v_ventas` (
  `FACTURA` varchar(10),
  `CODIGOPRODUCTO` varchar(10),
  `MARCA` varchar(50),
  `SERIE` varchar(50),
  `CANTIDAD` int(11),
  `PRECIOVENTA` decimal(10,2),
  `IMPORTE` decimal(10,2),
  `FECHA` date,
  `ESTADO` varchar(30)
);

--
-- Definition of table `tb_caja`
--

DROP TABLE IF EXISTS `tb_caja`;
CREATE TABLE `tb_caja` (
  `fecha` date NOT NULL DEFAULT '0000-00-00',
  `inicio` decimal(10,2) DEFAULT NULL,
  `compras` decimal(10,2) DEFAULT NULL,
  `ventas` decimal(10,2) DEFAULT NULL,
  `Reparaciones` decimal(10,2) DEFAULT NULL,
  `nuevoSaldo` decimal(10,2) DEFAULT NULL,
  `hrInicial` varchar(45) DEFAULT NULL,
  `hrFinal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_caja`
--

/*!40000 ALTER TABLE `tb_caja` DISABLE KEYS */;
INSERT INTO `tb_caja` (`fecha`,`inicio`,`compras`,`ventas`,`Reparaciones`,`nuevoSaldo`,`hrInicial`,`hrFinal`) VALUES 
 ('2014-05-18','300.00','0.00','0.00','0.00','300.00',NULL,NULL),
 ('2014-05-19','300.00','400.00','0.00','0.00','-100.00',NULL,NULL),
 ('2014-05-20','377.00','0.00','0.00','0.00','0.00',NULL,NULL),
 ('2014-05-21','300.00','60.00','1397.00','0.00','1637.00',NULL,NULL),
 ('2014-05-22','40.00','0.00','0.00','0.00','0.00',NULL,NULL),
 ('2014-05-23','400.00','0.00','0.00','0.00','0.00',NULL,NULL),
 ('2014-06-01','100.00','0.00','0.00','0.00','100.00',NULL,NULL),
 ('2014-06-02','0.00','0.00','0.00','0.00','0.00',NULL,NULL),
 ('2014-06-03','60.00','0.00','0.00','0.00','0.00',NULL,NULL),
 ('2014-06-04','300.00','0.00','0.00','0.00','0.00',NULL,NULL),
 ('2014-06-05','300.00','0.00','0.00','0.00','300.00','11:22:51','11:28:03'),
 ('2014-06-06','100.00','2000.00','260.00','2210.00','570.00','10:33:17','10:42:22'),
 ('2014-06-07','300.00','1000.00','180.00','2000.00','0.00','05:33:05','05:36:37'),
 ('2014-06-10','100.00','240.00','1830.00','210.00','1900.00','05:32:45','05:38:32'),
 ('2014-06-12','100.00','0.00','0.00','0.00','0.00','03:00:09','hh:mm:ss'),
 ('2014-06-13','300.00','0.00','0.00','0.00','0.00','04:41:11','hh:mm:ss'),
 ('2014-06-20','100.00','0.00','0.00','0.00','0.00','10:33:29','hh:mm:ss'),
 ('2014-06-28','100.00','0.00','0.00','0.00','0.00','10:37:27','hh:mm:ss'),
 ('2014-06-29','668.00','0.00','0.00','0.00','0.00','05:20:48','hh:mm:ss'),
 ('2014-07-01','1000.00','0.00','0.00','0.00','0.00','05:12:41','hh:mm:ss'),
 ('2014-07-10','1000.00','0.00','0.00','0.00','0.00','09:01:59','hh:mm:ss'),
 ('2014-07-11','100.00','0.00','0.00','0.00','0.00','01:14:04','hh:mm:ss'),
 ('2014-07-14','100.00','0.00','0.00','0.00','0.00','07:34:57','hh:mm:ss'),
 ('2014-07-23','100.00','0.00','0.00','0.00','0.00','03:56:56','hh:mm:ss'),
 ('2014-07-24','300.00','0.00','0.00','0.00','0.00','11:34:33','hh:mm:ss'),
 ('2014-07-25','300.00','0.00','0.00','0.00','0.00','08:46:17','hh:mm:ss'),
 ('2014-07-30','100.00','0.00','0.00','0.00','0.00','09:17:59','hh:mm:ss');
/*!40000 ALTER TABLE `tb_caja` ENABLE KEYS */;


--
-- Definition of table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
CREATE TABLE `tb_cliente` (
  `codigocliente` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(30) DEFAULT NULL,
  `DNI` char(8) DEFAULT NULL,
  `datos` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `celular` char(9) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`codigocliente`),
  UNIQUE KEY `u_dni_c` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cliente`
--

/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` (`codigocliente`,`tipo`,`DNI`,`datos`,`direccion`,`celular`,`email`,`estado`) VALUES 
 (12,'GENERAL','73483995','SUAREZ LOLI EDSON','PUERTO SUPE','956970181','EDSON061193@GMAIL.COM','1'),
 (14,'GENERAL','98098765','BLAS GOMEZ LUIS','LETICIA','','','1'),
 (15,'GENERAL','78900098','TORRES TAFUR ELISABETH','PUERTO SUPE','','','1'),
 (16,'GENERAL','78976543','JORGE VALDEZ','LIMA','','','1'),
 (17,'GENERAL','89700098','NELIDA','SUPE','','NELIDA@GMAIL.COM','1'),
 (18,'GENERAL','76890943','MIRELLA BAUTISTA','LIMA PERU','','','1');
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;


--
-- Definition of table `tb_compras`
--

DROP TABLE IF EXISTS `tb_compras`;
CREATE TABLE `tb_compras` (
  `codigocompra` int(11) NOT NULL AUTO_INCREMENT,
  `codigoRegP` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `costos` decimal(10,0) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`codigocompra`),
  KEY `fk_comp_prod` (`codigoRegP`),
  CONSTRAINT `fk_comp_prod` FOREIGN KEY (`codigoRegP`) REFERENCES `tb_producto` (`codigoRegP`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_compras`
--

/*!40000 ALTER TABLE `tb_compras` DISABLE KEYS */;
INSERT INTO `tb_compras` (`codigocompra`,`codigoRegP`,`cantidad`,`costos`,`fecha`) VALUES 
 (1,1,1,'20','2014-05-18'),
 (2,4,2,'300','2014-05-18'),
 (3,4,2,'400','2014-05-19'),
 (4,4,5,'5000','2014-05-19'),
 (5,8,1,'10','2014-05-19'),
 (6,9,1,'78','2014-05-20'),
 (7,10,3,'60','2014-05-21'),
 (8,11,10,'50','2014-05-22'),
 (9,12,1000,'1500000','2014-05-22'),
 (10,13,1,'100','2014-06-02'),
 (11,14,2,'2000','2014-06-04'),
 (12,15,2,'400','2014-06-05'),
 (13,16,2,'2600','2014-06-05'),
 (14,17,1,'100','2014-06-05'),
 (15,18,10,'2000','2014-06-06'),
 (16,19,1,'1000','2014-06-07'),
 (17,21,8,'240','2014-06-10'),
 (18,22,1,'200','2014-06-28'),
 (19,23,3,'6000','2014-07-11'),
 (20,24,10,'3000','2014-07-25');
/*!40000 ALTER TABLE `tb_compras` ENABLE KEYS */;


--
-- Definition of table `tb_contrato`
--

DROP TABLE IF EXISTS `tb_contrato`;
CREATE TABLE `tb_contrato` (
  `codContrado` char(6) NOT NULL DEFAULT '',
  `codigocliente` int(11) DEFAULT NULL,
  `codigoRegP` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precioActual` decimal(10,2) DEFAULT NULL,
  `precioNuevo` decimal(10,2) DEFAULT NULL,
  `periodo` int(11) DEFAULT NULL,
  `pago` decimal(10,2) DEFAULT NULL,
  `letra` int(11) DEFAULT NULL,
  `fechapagos` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codContrado`),
  KEY `fk_crd_cli` (`codigocliente`),
  KEY `fk_crd_prd` (`codigoRegP`),
  CONSTRAINT `fk_crd_cli` FOREIGN KEY (`codigocliente`) REFERENCES `tb_cliente` (`codigocliente`),
  CONSTRAINT `fk_crd_prd` FOREIGN KEY (`codigoRegP`) REFERENCES `tb_producto` (`codigoRegP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_contrato`
--

/*!40000 ALTER TABLE `tb_contrato` DISABLE KEYS */;
INSERT INTO `tb_contrato` (`codContrado`,`codigocliente`,`codigoRegP`,`cantidad`,`precioActual`,`precioNuevo`,`periodo`,`pago`,`letra`,`fechapagos`) VALUES 
 ('09',12,4,2,'30.00','40.00',2,'20.00',2,''),
 ('10',12,4,2,'30.00','40.00',2,'20.00',2,'10'),
 ('11',15,2,1,'250.00','400.00',10,'40.00',4,'30'),
 ('12',14,1,2,'1000.00','2000.00',10,'200.00',10,'12'),
 ('13',12,1,3,'1500.00','2500.00',10,'250.00',10,'25'),
 ('14',12,10,2,'44.00','50.00',2,'25.00',2,'06');
/*!40000 ALTER TABLE `tb_contrato` ENABLE KEYS */;


--
-- Definition of table `tb_detalle_servicios`
--

DROP TABLE IF EXISTS `tb_detalle_servicios`;
CREATE TABLE `tb_detalle_servicios` (
  `codigoFactura` int(11) NOT NULL DEFAULT '0',
  `codigoservicio` int(11) NOT NULL DEFAULT '0',
  `precio` decimal(10,2) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `importe` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`codigoFactura`,`codigoservicio`),
  KEY `fk_ser_det` (`codigoservicio`),
  CONSTRAINT `fk_ser_det` FOREIGN KEY (`codigoservicio`) REFERENCES `tb_servicio` (`codigoservicio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_detalle_servicios`
--

/*!40000 ALTER TABLE `tb_detalle_servicios` DISABLE KEYS */;
INSERT INTO `tb_detalle_servicios` (`codigoFactura`,`codigoservicio`,`precio`,`cantidad`,`importe`) VALUES 
 (30,12,'7.00',1,'7.00'),
 (35,13,'210.00',1,'210.00'),
 (35,14,'2000.00',1,'2000.00'),
 (38,15,'2000.00',1,'2000.00'),
 (40,16,'210.00',1,'210.00'),
 (41,17,'230.00',1,'230.00'),
 (45,18,'1800.00',6,'10800.00'),
 (56,19,'2500.00',1,'2500.00'),
 (57,20,'500.00',1,'500.00'),
 (57,21,'1500.00',1,'1500.00'),
 (58,22,'500.00',3,'1500.00'),
 (58,23,'300.00',4,'1200.00'),
 (59,24,'500.00',3,'1500.00'),
 (59,25,'300.00',3,'900.00'),
 (59,26,'2500.00',2,'5000.00');
/*!40000 ALTER TABLE `tb_detalle_servicios` ENABLE KEYS */;


--
-- Definition of table `tb_detalle_venta`
--

DROP TABLE IF EXISTS `tb_detalle_venta`;
CREATE TABLE `tb_detalle_venta` (
  `codigoFactura` int(11) NOT NULL DEFAULT '0',
  `codigoRegP` int(11) NOT NULL DEFAULT '0',
  `precio` decimal(10,2) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `importe` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`codigoFactura`,`codigoRegP`),
  KEY `fk_prd_det` (`codigoRegP`),
  CONSTRAINT `FK_FACT_DE` FOREIGN KEY (`codigoFactura`) REFERENCES `tb_factura` (`codigoFactura`),
  CONSTRAINT `fk_prd_det` FOREIGN KEY (`codigoRegP`) REFERENCES `tb_producto` (`codigoRegP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_detalle_venta`
--

/*!40000 ALTER TABLE `tb_detalle_venta` DISABLE KEYS */;
INSERT INTO `tb_detalle_venta` (`codigoFactura`,`codigoRegP`,`precio`,`cantidad`,`importe`) VALUES 
 (29,4,'15.00',2,'30.00'),
 (31,3,'7.00',1,'7.00'),
 (31,4,'15.00',2,'30.00'),
 (31,10,'22.00',1,'22.00'),
 (31,12,'1800.00',4,'7200.00'),
 (32,4,'15.00',2,'30.00'),
 (32,15,'230.00',1,'230.00'),
 (36,18,'210.00',8,'1680.00'),
 (37,4,'15.00',2,'30.00'),
 (37,17,'150.00',1,'150.00'),
 (39,4,'15.00',2,'30.00'),
 (39,12,'1800.00',1,'1800.00'),
 (42,3,'7.00',1,'7.00'),
 (43,4,'15.00',16,'240.00'),
 (44,12,'1800.00',3,'5400.00'),
 (46,12,'1800.00',3,'5400.00'),
 (47,12,'1800.00',3,'5400.00'),
 (49,11,'7.00',4,'28.00'),
 (50,2,'250.00',7,'1750.00'),
 (50,11,'7.00',1,'7.00'),
 (50,12,'1800.00',17,'30600.00'),
 (54,1,'500.00',3,'1500.00'),
 (54,2,'250.00',2,'500.00'),
 (55,1,'500.00',3,'1500.00'),
 (60,1,'500.00',2,'1000.00'),
 (60,5,'200.00',3,'600.00'),
 (60,22,'300.00',5,'1500.00'),
 (61,1,'500.00',2,'1000.00'),
 (61,2,'250.00',1,'250.00'),
 (62,3,'300.00',4,'1200.00'),
 (63,12,'1800.00',3,'5400.00'),
 (64,1,'500.00',4,'2000.00'),
 (64,3,'300.00',3,'900.00'),
 (64,22,'300.00',4,'1200.00'),
 (65,1,'500.00',7,'3500.00'),
 (65,4,'15.00',89,'1335.00'),
 (66,1,'500.00',3,'1500.00'),
 (66,5,'200.00',1,'200.00'),
 (67,1,'500.00',1,'500.00'),
 (67,3,'300.00',1,'300.00'),
 (67,22,'300.00',1,'300.00'),
 (73,16,'2000.00',8,'16000.00'),
 (74,1,'500.00',3,'1500.00'),
 (74,3,'300.00',4,'1200.00');
/*!40000 ALTER TABLE `tb_detalle_venta` ENABLE KEYS */;


--
-- Definition of table `tb_empleado`
--

DROP TABLE IF EXISTS `tb_empleado`;
CREATE TABLE `tb_empleado` (
  `codigoempleado` char(6) NOT NULL DEFAULT '',
  `tipoEmpleado` varchar(30) DEFAULT NULL,
  `dni` char(8) DEFAULT NULL,
  `apellidos` varchar(30) DEFAULT NULL,
  `nombres` varchar(30) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `sueldo` decimal(10,2) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `idEmpleado` varchar(30) DEFAULT NULL,
  `clave` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codigoempleado`),
  UNIQUE KEY `u_ide` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_empleado`
--

/*!40000 ALTER TABLE `tb_empleado` DISABLE KEYS */;
INSERT INTO `tb_empleado` (`codigoempleado`,`tipoEmpleado`,`dni`,`apellidos`,`nombres`,`sexo`,`direccion`,`correo`,`telefono`,`sueldo`,`estado`,`idEmpleado`,`clave`) VALUES 
 ('100000','Administrador','73483995','suarez loli','edson j','m','leticia','edson061193@gmail.com','956970181','800.00','E','edson061193','qwerty'),
 ('100001','Tecnica','67809087','damian palacios','karol','f','barranca','karold@hotmail.com','909087567','500.00','trabajando','karold','102030'),
 ('100003','VENDEDOR','73493995','SUAREZ RODRIGUEZ','MISHEL','F','HUACHO','hMishel05@gmail.com','980980980','400.00','Trabajando','mishel05','black'),
 ('100004','VENDEDOR','76890987','TRUJILLO LOZA','LUCIA','F','LIMA','lucia@gmail.com','978900988','2000.00','Trabajando','megadeth001','qwerty');
/*!40000 ALTER TABLE `tb_empleado` ENABLE KEYS */;


--
-- Definition of table `tb_factura`
--

DROP TABLE IF EXISTS `tb_factura`;
CREATE TABLE `tb_factura` (
  `codigoFactura` int(11) NOT NULL AUTO_INCREMENT,
  `factura` varchar(10) DEFAULT NULL,
  `ruc` varchar(15) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `igv` decimal(10,2) DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `tipodepago` varchar(20) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `caja` date DEFAULT NULL,
  `codigoempleado` char(6) DEFAULT NULL,
  `codigocliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoFactura`),
  KEY `fk_fac_emp` (`codigoempleado`),
  KEY `fk_fact_cli` (`codigocliente`),
  KEY `fk_caj_fact` (`caja`),
  CONSTRAINT `fk_caj_fact` FOREIGN KEY (`caja`) REFERENCES `tb_caja` (`fecha`),
  CONSTRAINT `fk_fact_cli` FOREIGN KEY (`codigocliente`) REFERENCES `tb_cliente` (`codigocliente`),
  CONSTRAINT `fk_fac_emp` FOREIGN KEY (`codigoempleado`) REFERENCES `tb_empleado` (`codigoempleado`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_factura`
--

/*!40000 ALTER TABLE `tb_factura` DISABLE KEYS */;
INSERT INTO `tb_factura` (`codigoFactura`,`factura`,`ruc`,`fecha`,`igv`,`subtotal`,`total`,`tipodepago`,`estado`,`caja`,`codigoempleado`,`codigocliente`) VALUES 
 (29,'100020','734810987','2014-08-05','5.40','24.60','30.00','VENTA REALIZADA','EFECTIVO','2014-06-05','100001',12),
 (30,'100021','734810987','2014-09-03','1.26','5.74','7.00','VENTA R REALIZADA','EFECTIVO','2014-06-05','100001',12),
 (31,'100022','734810987','2014-01-05','1306.62','5952.38','7259.00','VENTA REALIZADA','EFECTIVO','2014-06-05','100001',14),
 (32,'100023','734810987','2014-10-06','46.80','213.20','260.00','VENTA REALIZADA','EFECTIVO','2014-06-06','100001',15),
 (33,'100024','734810987','2014-11-06','43.20','196.80','240.00','VENTA R REALIZADA','EFECTIVO','2014-06-06','100001',12),
 (34,'100024','734810987','2014-12-06','5.40','24.60','30.00','VENTA R REALIZADA','EFECTIVO','2014-06-06','100001',12),
 (35,'100025','734810987','2014-02-06','397.80','1812.20','2210.00','VENTA R REALIZADA','EFECTIVO','2014-06-06','100001',12),
 (36,'200301','734810987','2014-06-06','302.40','1377.60','1680.00','VENTA REALIZADA','EFECTIVO','2014-06-06','100001',12),
 (37,'200302','734810987','2014-06-07','32.40','147.60','180.00','VENTA REALIZADA','EFECTIVO','2014-06-07','100001',12),
 (38,'200303','734810987','2014-06-07','360.00','1640.00','2000.00','VENTA R REALIZADA','EFECTIVO','2014-06-07','100001',14),
 (39,'200304','734810987','2014-06-10','329.40','1500.60','1830.00','VENTA REALIZADA','EFECTIVO','2014-06-10','100001',16),
 (40,'200305','734810987','2014-06-10','37.80','172.20','210.00','VENTA R REALIZADA','EFECTIVO','2014-06-10','100001',12),
 (41,'200306','734810987','2014-06-10','41.40','188.60','230.00','VENTA R REALIZADA','EFECTIVO','2014-06-10','100001',12),
 (42,'200306','734810987','2014-06-10','1.26','5.74','7.00','VENTA REALIZADA','EFECTIVO','2014-06-10','100001',12),
 (43,'200307','734810987','2014-06-10','43.20','196.80','240.00','VENTA REALIZADA','EFECTIVO','2014-06-10','100001',12),
 (44,'200308','734810987','2014-06-12','972.00','4428.00','5400.00','VENTA REALIZADA','EFECTIVO','2014-06-12','100001',15),
 (45,'200309','734810987','2014-06-12','1944.00','8856.00','10800.00','VENTA R REALIZADA','EFECTIVO','2014-06-12','100001',12),
 (46,'200310','734810987','2014-06-13','972.00','4428.00','5400.00','VENTA REALIZADA','EFECTIVO','2014-06-13','100001',15),
 (47,'200311','734810987','2014-06-13','0.00','0.00','0.00','VENTA R REALIZADA','EFECTIVO','2014-06-13','100001',12),
 (48,'200312','734810987','2014-06-12','972.00','4428.00','5400.00','VENTA REALIZADA','EFECTIVO','2014-06-12','100001',12),
 (49,'200313','734810987','2014-06-13','5.04','22.96','28.00','VENTA REALIZADA','EFECTIVO','2014-06-13','100001',14),
 (50,'200314','734810987','2014-07-01','5508.00','25092.00','30600.00','VENTA REALIZADA','EFECTIVO','2014-07-01','100001',12),
 (51,'200315','734810987','2014-06-28','648.00','2952.00','3600.00','VENTA REALIZADA','EFECTIVO','2014-06-28','100001',12),
 (52,'200316','734810987','2014-06-28','1.26','5.74','7.00','VENTA REALIZADA','EFECTIVO','2014-06-28','100001',16),
 (53,'200317','734810987','2014-06-29','315.00','1435.00','1750.00','VENTA REALIZADA','EFECTIVO','2014-06-29','100001',12),
 (54,'200318','734810987','2014-07-10','360.00','1640.00','2000.00','VENTA REALIZADA','EFECTIVO','2014-07-10','100001',12),
 (55,'200319','734810987','2014-07-11','270.00','1230.00','1500.00','VENTA REALIZADA','EFECTIVO','2014-07-11','100001',17),
 (56,'200320','734810987','2014-07-11','450.00','2050.00','2500.00','VENTA R REALIZADA','EFECTIVO','2014-07-11','100001',17),
 (57,'200321','734810987','2014-07-11','360.00','1640.00','2000.00','VENTA R REALIZADA','EFECTIVO','2014-07-11','100001',12),
 (58,'200322','734810987','2014-07-14','486.00','2214.00','2700.00','VENTA R REALIZADA','EFECTIVO','2014-07-14','100001',15),
 (59,'200323','734810987','2014-07-14','1332.00','6068.00','7400.00','VENTA R REALIZADA','EFECTIVO','2014-07-14','100001',15),
 (60,'200324','734810987','2014-07-14','558.00','2542.00','3100.00','VENTA REALIZADA','EFECTIVO','2014-07-14','100001',15),
 (61,'200325','734810987','2014-07-23','225.00','1025.00','1250.00','VENTA REALIZADA','EFECTIVO','2014-07-23','100001',12),
 (62,'200326','734810987','2014-07-24','216.00','984.00','1200.00','VENTA REALIZADA','EFECTIVO','2014-07-24','100001',12),
 (63,'200327','734810987','2014-07-24','972.00','4428.00','5400.00','VENTA REALIZADA','EFECTIVO','2014-07-24','100001',15),
 (64,'200328','734810987','2014-07-24','738.00','3362.00','4100.00','VENTA REALIZADA','EFECTIVO','2014-07-24','100001',14),
 (65,'200329','734810987','2014-07-24','870.30','3964.70','4835.00','VENTA REALIZADA','EFECTIVO','2014-07-24','100001',16),
 (66,'200330','734810987','2014-07-25','306.00','1394.00','1700.00','VENTA REALIZADA','EFECTIVO','2014-07-25','100001',18),
 (67,'200331','734810987','2014-07-25','198.00','902.00','1100.00','VENTA REALIZADA','EFECTIVO','2014-07-25','100001',14),
 (68,'200332','734810987','2014-07-25','144.00','656.00','800.00','VENTA R REALIZADA','EFECTIVO','2014-07-25','100001',17),
 (69,'200332','734810987','2014-07-25','144.00','656.00','800.00','VENTA R REALIZADA','EFECTIVO','2014-07-25','100001',17),
 (70,'200332','734810987','2014-07-25','144.00','656.00','800.00','VENTA R REALIZADA','EFECTIVO','2014-07-25','100001',17),
 (71,'200332','734810987','2014-07-25','144.00','656.00','800.00','VENTA R REALIZADA','EFECTIVO','2014-07-25','100001',17),
 (72,'200332','734810987','2014-07-25','144.00','656.00','800.00','VENTA R REALIZADA','EFECTIVO','2014-07-25','100001',17),
 (73,'200333','734810987','2014-07-30','2880.00','13120.00','16000.00','VENTA REALIZADA','EFECTIVO','2014-07-30','100001',15),
 (74,'200334','734810987','2014-07-30','486.00','2214.00','2700.00','VENTA REALIZADA','EFECTIVO','2014-07-30','100001',15);
/*!40000 ALTER TABLE `tb_factura` ENABLE KEYS */;


--
-- Definition of table `tb_informacion`
--

DROP TABLE IF EXISTS `tb_informacion`;
CREATE TABLE `tb_informacion` (
  `codInformacion` int(11) NOT NULL AUTO_INCREMENT,
  `codigoRegP` int(11) DEFAULT NULL,
  `fechaLanzamiento` date DEFAULT NULL,
  `demanda` text,
  `caracteristicas` text,
  `alertas` text,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codInformacion`),
  KEY `fk_inf_prod` (`codigoRegP`),
  CONSTRAINT `fk_inf_prod` FOREIGN KEY (`codigoRegP`) REFERENCES `tb_producto` (`codigoRegP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_informacion`
--

/*!40000 ALTER TABLE `tb_informacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_informacion` ENABLE KEYS */;


--
-- Definition of table `tb_pedido`
--

DROP TABLE IF EXISTS `tb_pedido`;
CREATE TABLE `tb_pedido` (
  `codigocliente` int(11) NOT NULL DEFAULT '0',
  `codSolicitud` int(11) NOT NULL DEFAULT '0',
  `fecha` date DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigocliente`,`codSolicitud`),
  KEY `fk_p_s` (`codSolicitud`),
  CONSTRAINT `fk_p_c` FOREIGN KEY (`codigocliente`) REFERENCES `tb_cliente` (`codigocliente`),
  CONSTRAINT `fk_p_s` FOREIGN KEY (`codSolicitud`) REFERENCES `tb_solicitud` (`codSolicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pedido`
--

/*!40000 ALTER TABLE `tb_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_pedido` ENABLE KEYS */;


--
-- Definition of table `tb_producto`
--

DROP TABLE IF EXISTS `tb_producto`;
CREATE TABLE `tb_producto` (
  `codigoRegP` int(11) NOT NULL AUTO_INCREMENT,
  `codigoproveedor` char(6) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `codigoProducto` varchar(10) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `serie` varchar(50) DEFAULT NULL,
  `precioCompra` decimal(10,2) DEFAULT NULL,
  `precioVenta` decimal(10,2) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `observacion` text,
  `estado` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codigoRegP`),
  KEY `fk_prov_prod` (`codigoproveedor`),
  CONSTRAINT `fk_prov_prod` FOREIGN KEY (`codigoproveedor`) REFERENCES `tb_proveedor` (`codigoproveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_producto`
--

/*!40000 ALTER TABLE `tb_producto` DISABLE KEYS */;
INSERT INTO `tb_producto` (`codigoRegP`,`codigoproveedor`,`tipo`,`codigoProducto`,`marca`,`serie`,`precioCompra`,`precioVenta`,`cantidad`,`observacion`,`estado`) VALUES 
 (1,'PRV001','MOVIL','XC100ER1','SAMSUNG','XR200','300.00','500.00',65,'BUEN ESTADO','NUEVO'),
 (2,'PRV002','MOVIL','XC100ER2','LG','A20X9','200.00','250.00',0,'BUEN ESTADO','SEGUNDA'),
 (3,'PRV004','CARGADOR','RRTXX01','NOKIA','AP2','5.00','300.00',1071,'CARGADOR SALIDA CUADRADA','NUEVO'),
 (4,'PRV004','CARGADOR','R0Y200Q','MOTOROLA','BT50','10.00','15.00',11,'BATERIA PARA CELULARES MOTOROLA','MANTENIMIENTO'),
 (5,'PRV003','MOVIL','SP009C1','ASES','ASES C1','150.00','200.00',396,'PANTALLA TOUCH, INTERNT , SISTEMA OPERATIVO ANDROID','NUEVO'),
 (6,'PRV001','MOVIL','S00TX20','SAMSUNG','S500','200.00','230.00',0,'SISTEMA OPERATIVO ANDROID , MENORIA 4GB , CAMARA 15MPX','NUEVO'),
 (7,'PRV003','MOVIL','ACOPYUT','NOKIA','NR300T','1000.00','2000.00',0,'RADIO','BUENO'),
 (8,'PRV005','MOVIL','BT00E34','LG','LG X200','10.00','15.00',0,'BATERIA LG LGX200','MANTENIMIENTO'),
 (9,'PRV005','MOVIL','GFFJKH','NOKIA','JHJHJG','78.00','97.00',0,'SISTEMA OPERATIVO ANDR','BUENO'),
 (10,'PRV005','CARGADOR','4RT67Y','LG','LG ASC','20.00','22.00',809,'','BUENO'),
 (11,'PRV005','MOVIL','GFGFDJM','TOSHIBA','','5.00','7.00',0,'JDSJDJS','MALO'),
 (12,'PRV002','MOVIL','C10','MOTOROLA','Z10','1500.00','1800.00',960,'','NUEVO'),
 (13,'PRV005','MOVIL','YUIP005','LG','F250','100.00','110.00',0,'PANTALLA TOUCH','MANTENIMIENTO'),
 (14,'PRV002','CABLE DE DATO','LEX00VO','LENOVO','X200','1000.00','1500.00',0,'DISCO DURO 1TB','NUEVO'),
 (15,'PRV003','MOVIL','HHUI9','SAMSUNG','SPO','200.00','230.00',0,'----','BUENO'),
 (16,'PRV002','CARGADOR','TU0O1','LENOVO','APP200XP','1300.00','2000.00',992,'','NUEVO'),
 (17,'PRV005','MOVIL','XP002','SAMSUNG','GALAXIS','100.00','150.00',500,'....................','MANTENIMIENTO'),
 (18,'PRV002','MOVIL','UIOP00','NOKIA','LUMIA','200.00','210.00',900,'PANTALLA TOUCH , SISTEMA OPERATIVO ANDROID , CAMB 12 MPX','NUEVO'),
 (19,'PRV005','MOVIL','JFTUE','NOKIA','','1000.00','2000.00',0,'CEDJCDEJCBJDBCJDSBCJHDBCHDBHVDBSHCVDSGCVDSCBVSDCGDW','NUEVO'),
 (20,'PRV000','MOVIL','ggg','skskks','JSJS','0.00','11.00',8,'jddjjd','BUENO'),
 (21,'PRV003','MOVIL','HHGF','HHHHH','','30.00','40.00',8,'JGJHGHGHDFGHJKLKJHGFDFGHJM,.LKJHGFDFGHNM','BUENO'),
 (22,'PRV005','MOVIL','BDJFHJ','TOSHIBA','MAC X200','200.00','300.00',990,'','NUEVO'),
 (23,'PRV005','MOVIL','EDS089','TOSHIBA','INTEL','2000.00','2500.00',0,'','NUEVO'),
 (24,'PRV002','MOVIL','PROXRB','ES7','ES7','300.00','400.00',10,'SISTEMA DE  VENTAS YOUTUBE.COM/SOFTWARE.WORLD.EJM','NUEVO');
/*!40000 ALTER TABLE `tb_producto` ENABLE KEYS */;


--
-- Definition of table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
CREATE TABLE `tb_proveedor` (
  `codigoproveedor` char(6) NOT NULL DEFAULT '',
  `sociedad` varchar(50) DEFAULT NULL,
  `representante` varchar(50) DEFAULT NULL,
  `celular` char(9) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `actividad` text,
  `estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`codigoproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_proveedor`
--

/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` (`codigoproveedor`,`sociedad`,`representante`,`celular`,`direccion`,`email`,`tipo`,`actividad`,`estado`) VALUES 
 ('PRV000','Dominio Propio','Dominio Propio',NULL,NULL,NULL,'Dominio Propio','Dominio Propio',NULL),
 ('PRV001','MOVISTAR SAC','MIGUEL TELLO','980654123','LIMA-PERU','MTELLO@MOVISTAR.COM.PE','PROVEEDOR ESTABLE','VENTA DE CELULARES MOVISTAR','1'),
 ('PRV002','SOFTWARE.WORLD.EJM','EDSON SUAREZ','956970181','BARRANCA','EDSON061193@GMAIL.COM','PROVEEDOR ESTABLE','VENTA DE SOFTWARE','1'),
 ('PRV003','CLARO','JORGE VARGAS','907896543','LIMA PERU','JV@HOTMAIL.COM','PROVEEDOR ESTABLE','VENTA DE CELULARES CLARO\nRPC','1'),
 ('PRV004','LEDATEL','VICTOR C','900056743','BARRANCA','VICTOR@GMAIL.COM','PROVEEDOR ASOCIADO','VENTA, COMPRAS Y REPARACIONES DE CELULARES ','1'),
 ('PRV005','PUBLICO GENERAL','PUBLICO','','NULL','NULL','PROVEEDOR PUBLICO','NULL','1');
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;


--
-- Definition of table `tb_servicio`
--

DROP TABLE IF EXISTS `tb_servicio`;
CREATE TABLE `tb_servicio` (
  `codigoservicio` int(11) NOT NULL AUTO_INCREMENT,
  `observacion` varchar(50) NOT NULL,
  `costo` decimal(10,2) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `codigoRegP` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoservicio`,`observacion`) USING BTREE,
  KEY `fk_ser_prd` (`codigoRegP`),
  CONSTRAINT `fk_ser_prd` FOREIGN KEY (`codigoRegP`) REFERENCES `tb_producto` (`codigoRegP`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_servicio`
--

/*!40000 ALTER TABLE `tb_servicio` DISABLE KEYS */;
INSERT INTO `tb_servicio` (`codigoservicio`,`observacion`,`costo`,`fecha`,`codigoRegP`) VALUES 
 (1,'cambio de pantalla(LG LG ASC)','22.00','2014-06-03',10),
 (2,'mantenimiento(NOKIA NR300T)','2000.00','2014-06-03',7),
 (3,'c','5.00','2014-06-01',2),
 (3,'cambio de pantalla(NOKIA AP2)','7.00','2014-06-03',2),
 (4,'cambio de audio(NOKIA NR300T)','2000.00','2014-06-03',2),
 (5,'reparacion(NOKIA NR300T)','2000.00','2014-06-03',7),
 (6,'cambio de pantalla(MOTOROLA Z10)','1800.00','2014-06-03',7),
 (7,'cambio de cargador(NOKIA AP2)','21.00','2014-06-03',3),
 (8,'cambio de auriculares(NOKIA NR300T)','2000.00','2014-06-03',3),
 (9,'cambio de teclado(LG LG ASC)','22.00','2014-06-03',10),
 (10,'cambio de pantalla(TOSHIBA )','14.00','2014-06-03',11),
 (11,'xd xd(TOSHIBA )','21.00','2014-06-03',11),
 (12,'cambio de pantalla(NOKIA AP2)','7.00','2014-06-05',3),
 (13,'cambio de pantalla(NOKIA LUMIA)','210.00','2014-06-06',18),
 (14,'reparacion de partes(LENOVO APP200XP)','2000.00','2014-06-06',16),
 (15,'cambio de pantalla(NOKIA )','2000.00','2014-06-07',19),
 (16,'reparacion  etc tec(NOKIA LUMIA)','210.00','2014-06-10',18),
 (17,'(SAMSUNG SPO)','230.00','2014-06-10',15),
 (18,'(MOTOROLA Z10)','10800.00','2014-06-12',12),
 (19,'cambio de xxxxx(TOSHIBA INTEL)','2500.00','2014-07-11',23),
 (20,'ajajjajajajaja(SAMSUNG XR200)','500.00','2014-07-11',1),
 (21,'XDXDXDDXD(LENOVO X200)','1500.00','2014-07-11',14),
 (22,'cambio de pantalla(SAMSUNG XR200)','1500.00','2014-07-14',1),
 (23,'repararlo(NOKIA AP2)','1200.00','2014-07-14',3),
 (24,'cambio de pantalla(SAMSUNG XR200)','1500.00','2014-07-14',1),
 (25,'cambio de teclado(NOKIA AP2)','900.00','2014-07-14',3),
 (26,'cambio de pantalla(TOSHIBA INTEL)','5000.00','2014-07-14',23);
/*!40000 ALTER TABLE `tb_servicio` ENABLE KEYS */;


--
-- Definition of table `tb_solicitud`
--

DROP TABLE IF EXISTS `tb_solicitud`;
CREATE TABLE `tb_solicitud` (
  `codSolicitud` int(11) NOT NULL AUTO_INCREMENT,
  `marcaProducto` varchar(50) DEFAULT NULL,
  `modeloProducto` varchar(50) DEFAULT NULL,
  `demanda` text,
  PRIMARY KEY (`codSolicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_solicitud`
--

/*!40000 ALTER TABLE `tb_solicitud` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_solicitud` ENABLE KEYS */;


--
-- Definition of procedure `sp_caja_update`
--

DROP PROCEDURE IF EXISTS `sp_caja_update`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_caja_update`(
in xfecha date,
in xinicio decimal(10,2),
in xcompras decimal(10,2),
in xventas decimal(10,2),
in xreparaciones decimal(10,2),
in xnuevosaldo decimal(10,2),
in xhraFinal varchar(45))
begin
update tb_caja set inicio=xinicio,compras=xcompras,ventas=xventas,reparaciones=xreparaciones,nuevosaldo=xnuevosaldo,hrFinal=xhraFinal
 where fecha=xfecha;
commit;
end $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_empleado_delete`
--

DROP PROCEDURE IF EXISTS `sp_empleado_delete`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_empleado_delete`(
in xcodigo char(6))
begin
update tb_empleado set estado='E' where codigoempleado=xcodigo;
commit;
end $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_empleado_insert`
--

DROP PROCEDURE IF EXISTS `sp_empleado_insert`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_empleado_insert`(
in xtipoEmpl  varchar(30),
in xdni char(8),
in xApellidos varchar(30),
in xNombres varchar(30),
in xsexo char(1),
in xdireccion varchar(50),
in xemail varchar(50),
in xtelefono varchar(10),
in xsueldo decimal(10,2),
in xidLogin  varchar(30),
in xclave varchar(30))
begin
set @num=0;
select count(*)into @num from tb_empleado;
set @codC=concat('1',right(concat('0000',cast((@num+1) as char)),5));
insert into tb_empleado values(@codC,xtipoEmpl,xdni, xApellidos,xNombres,xsexo,xdireccion,xemail,xtelefono,xsueldo,'Trabajando',xidLogin,xclave);
commit;
end $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_empleado_update`
--

DROP PROCEDURE IF EXISTS `sp_empleado_update`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_empleado_update`(
in xcodigo char(6),
in xarea varchar(30),
in xdni char(8),
in xapellidos varchar(30),
in xnombres varchar(30),
in xdireccion varchar(50),

in xemail varchar(50),
in xtelefono varchar(10),

in xsueldo decimal(10,2))
begin
update tb_empleado set
tipoEmpleado=xarea,
dni=xdni,
apellidos=xapellidos,
nombres=xnombres,
direccion=xdireccion,

correo=xemail,
telefono=xtelefono,

sueldo=xsueldo,
estado='trabajando' where codigoempleado=xcodigo;
commit;
end $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_producto_update`
--

DROP PROCEDURE IF EXISTS `sp_producto_update`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_producto_update`(
in xcodigo int,
in xprecio decimal(10,2),
in xcantidad int,
in xestado varchar(30))
begin
UPDATE tb_producto t SET precioventa=xprecio,cantidad=xcantidad,estado=xestado where codigoRegp=xcodigo;
commit;
end $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_proveedor_delete`
--

DROP PROCEDURE IF EXISTS `sp_proveedor_delete`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_proveedor_delete`(
in xcodigo char(6)
)
begin
update tb_proveedor set estado='0' where codigoproveedor=xcodigo;
commit;
end $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_proveedor_insertar`
--

DROP PROCEDURE IF EXISTS `sp_proveedor_insertar`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_proveedor_insertar`(
in xempresa varchar(50),
in xcontacto varchar(50),

in xtelefono varchar(9),
in xdireccion varchar(50),
in xemail varchar(50),


in xtipo varchar(50),
in xservicios varchar(50))
begin
set @num=0;
select count(*)into @num from tb_proveedor;
set @codC=concat('P',right(concat('RV00',cast((@num+1) as char)),5));
insert into tb_proveedor values(@codC,xempresa, xcontacto,xtelefono,xdireccion,xemail,xtipo,xservicios,'1');
commit;
end $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_proveedor_update`
--

DROP PROCEDURE IF EXISTS `sp_proveedor_update`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_proveedor_update`(
in xcodigo char(6),
in xsociedad varchar(50),
in xrepresentante varchar(50),
in xcelular char(9),
in xdireccion varchar(50),
in xemail varchar(50),
in xtipo varchar(50),
in xactividad text)
begin
update tb_proveedor set sociedad=xsociedad,representante=xrepresentante,celular=xcelular,direccion=xdireccion,email=xemail,tipo=xtipo,actividad=xactividad,
estado='1' where codigoproveedor=xcodigo;
commit;
end $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of view `v_compra_producto`
--

DROP TABLE IF EXISTS `v_compra_producto`;
DROP VIEW IF EXISTS `v_compra_producto`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_compra_producto` AS select `p`.`codigoProducto` AS `CODIGOPRODUCTO`,`p`.`marca` AS `MARCA`,`p`.`serie` AS `SERIE`,`p`.`precioCompra` AS `PRECIOCOMPRA`,`p`.`precioVenta` AS `PRECIOVENTA`,`c`.`cantidad` AS `CANTIDAD`,`c`.`fecha` AS `FECHA`,`pr`.`sociedad` AS `SOCIEDAD`,`p`.`estado` AS `ESTADO` from ((`tb_producto` `p` join `tb_compras` `c`) join `tb_proveedor` `pr`) where ((`p`.`codigoproveedor` = `pr`.`codigoproveedor`) and (`p`.`codigoRegP` = `c`.`codigoRegP`));

--
-- Definition of view `v_compras`
--

DROP TABLE IF EXISTS `v_compras`;
DROP VIEW IF EXISTS `v_compras`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_compras` AS select `p`.`codigoProducto` AS `CODIGOPRODUCTO`,`p`.`marca` AS `MARCA`,`p`.`serie` AS `SERIE`,`c`.`costos` AS `COSTOS`,`c`.`cantidad` AS `CANTIDAD`,`c`.`fecha` AS `FECHA`,`pr`.`sociedad` AS `SOCIEDAD`,`p`.`estado` AS `ESTADO` from ((`tb_producto` `p` join `tb_compras` `c`) join `tb_proveedor` `pr`) where ((`p`.`codigoproveedor` = `pr`.`codigoproveedor`) and (`p`.`codigoRegP` = `c`.`codigoRegP`));

--
-- Definition of view `v_contrato`
--

DROP TABLE IF EXISTS `v_contrato`;
DROP VIEW IF EXISTS `v_contrato`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_contrato` AS select `cn`.`codContrado` AS `CODCONTRADO`,`c`.`DNI` AS `DNI`,`c`.`datos` AS `DATOS`,`p`.`codigoProducto` AS `CODIGOPRODUCTO`,`p`.`marca` AS `MARCA`,`p`.`serie` AS `SERIE` from ((`tb_producto` `p` join `tb_contrato` `cn`) join `tb_cliente` `c`) where ((`cn`.`codigoRegP` = `p`.`codigoRegP`) and (`c`.`codigocliente` = `cn`.`codigocliente`));

--
-- Definition of view `v_empleados`
--

DROP TABLE IF EXISTS `v_empleados`;
DROP VIEW IF EXISTS `v_empleados`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_empleados` AS select `tb_empleado`.`codigoempleado` AS `codigoEmpleado`,`tb_empleado`.`dni` AS `dni`,`tb_empleado`.`apellidos` AS `apellidos`,`tb_empleado`.`nombres` AS `nombres`,`tb_empleado`.`direccion` AS `direccion`,`tb_empleado`.`correo` AS `correo`,`tb_empleado`.`telefono` AS `telefono`,`tb_empleado`.`tipoEmpleado` AS `tipoempleado`,`tb_empleado`.`sueldo` AS `sueldo`,`tb_empleado`.`estado` AS `estado` from `tb_empleado` where (`tb_empleado`.`estado` = 'TRABAJANDO');

--
-- Definition of view `v_producto_ventas`
--

DROP TABLE IF EXISTS `v_producto_ventas`;
DROP VIEW IF EXISTS `v_producto_ventas`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_producto_ventas` AS select `tb_producto`.`tipo` AS `TIPO`,`tb_producto`.`codigoProducto` AS `CODIGOPRODUCTO`,`tb_producto`.`marca` AS `MARCA`,`tb_producto`.`serie` AS `SERIE`,`tb_producto`.`precioVenta` AS `PRECIOVENTA`,`tb_producto`.`cantidad` AS `CANTIDAD`,`tb_producto`.`observacion` AS `OBSERVACION`,`tb_producto`.`estado` AS `ESTADO` from `tb_producto`;

--
-- Definition of view `v_reparaciones`
--

DROP TABLE IF EXISTS `v_reparaciones`;
DROP VIEW IF EXISTS `v_reparaciones`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_reparaciones` AS select `f`.`factura` AS `FACTURA`,`p`.`tipo` AS `TIPO`,`p`.`codigoProducto` AS `CODIGOPRODUCTO`,`p`.`marca` AS `MARCA`,`p`.`serie` AS `SERIE`,`s`.`observacion` AS `OBSERVACION`,`s`.`costo` AS `COSTO`,`d`.`cantidad` AS `CANTIDAD`,`d`.`importe` AS `IMPORTE`,`f`.`fecha` AS `FECHA` from (((`tb_producto` `p` join `tb_servicio` `s`) join `tb_detalle_servicios` `d`) join `tb_factura` `f`) where ((`f`.`codigoFactura` = `d`.`codigoFactura`) and (`d`.`codigoservicio` = `s`.`codigoservicio`) and (`s`.`codigoRegP` = `p`.`codigoRegP`));

--
-- Definition of view `v_ventas`
--

DROP TABLE IF EXISTS `v_ventas`;
DROP VIEW IF EXISTS `v_ventas`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_ventas` AS select `f`.`factura` AS `FACTURA`,`p`.`codigoProducto` AS `CODIGOPRODUCTO`,`p`.`marca` AS `MARCA`,`p`.`serie` AS `SERIE`,`d`.`cantidad` AS `CANTIDAD`,`p`.`precioVenta` AS `PRECIOVENTA`,`d`.`importe` AS `IMPORTE`,`f`.`fecha` AS `FECHA`,`p`.`estado` AS `ESTADO` from ((`tb_producto` `p` join `tb_detalle_venta` `d`) join `tb_factura` `f`) where ((`p`.`codigoRegP` = `d`.`codigoRegP`) and (`f`.`codigoFactura` = `d`.`codigoFactura`)) order by `f`.`factura` desc;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
