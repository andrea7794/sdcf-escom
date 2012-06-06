-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.50-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema banco
--

CREATE DATABASE IF NOT EXISTS banco;
USE banco;

--
-- Definition of table `bancos`
--

DROP TABLE IF EXISTS `bancos`;
CREATE TABLE `bancos` (
  `id_banco` int(11) NOT NULL AUTO_INCREMENT,
  `nom_banco` varchar(100) NOT NULL,
  PRIMARY KEY (`id_banco`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bancos`
--

/*!40000 ALTER TABLE `bancos` DISABLE KEYS */;
INSERT INTO `bancos` (`id_banco`,`nom_banco`) VALUES 
 (1,'Banco yo'),
 (2,'Banco de la republica'),
 (3,'Banco Bancomer'),
 (4,'Banco Banamex'),
 (5,'Banco Inverlat'),
 (6,'Banco Bx+'),
 (7,'Banco Santander Sefin'),
 (8,'Banco Nacional Financiera'),
 (9,'Banco Banregio'),
 (10,'Banco Banorte'),
 (11,'Banco HSBC'),
 (12,'Banco de Mexico');
/*!40000 ALTER TABLE `bancos` ENABLE KEYS */;


--
-- Definition of table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
CREATE TABLE `departamentos` (
  `id_depto` int(11) NOT NULL AUTO_INCREMENT,
  `desc_depto` varchar(50) NOT NULL,
  PRIMARY KEY (`id_depto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departamentos`
--

/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` (`id_depto`,`desc_depto`) VALUES 
 (1,'Manejo de fondos'),
 (2,'Monetaria'),
 (3,'Politica'),
 (4,'Sistemas financieros');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;


--
-- Definition of table `estado_resultados`
--

DROP TABLE IF EXISTS `estado_resultados`;
CREATE TABLE `estado_resultados` (
  `id_edo` int(11) NOT NULL AUTO_INCREMENT,
  `id_banco` int(11) NOT NULL,
  `id_dep` int(11) NOT NULL,
  `ingresos` double DEFAULT NULL,
  `egresos` double DEFAULT NULL,
  `liquidez` float DEFAULT NULL,
  `solvencia` float DEFAULT NULL,
  `año` int(11) DEFAULT NULL,
  `mes` int(11) DEFAULT NULL,
  `flag` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_edo`),
  KEY `id_banco` (`id_banco`),
  KEY `id_dep` (`id_dep`),
  CONSTRAINT `estado_resultados_ibfk_1` FOREIGN KEY (`id_banco`) REFERENCES `bancos` (`id_banco`) ON UPDATE CASCADE,
  CONSTRAINT `estado_resultados_ibfk_2` FOREIGN KEY (`id_dep`) REFERENCES `departamentos` (`id_depto`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=577 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estado_resultados`
--

/*!40000 ALTER TABLE `estado_resultados` DISABLE KEYS */;
INSERT INTO `estado_resultados` (`id_edo`,`id_banco`,`id_dep`,`ingresos`,`egresos`,`liquidez`,`solvencia`,`año`,`mes`,`flag`) VALUES 
 (1,1,1,144777,2135122,0.134666,0.175646,2010,1,0x01),
 (2,1,2,1329504,3766187,0.566197,0.0142387,2010,1,0x01),
 (3,1,3,1558953,4952752,0.906062,0.595652,2010,1,0x01),
 (4,1,4,1646062,2208502,0.977479,0.793928,2010,1,0x01),
 (5,1,1,1057336,73637,0.780183,0.687616,2010,2,0x01),
 (6,1,2,1657932,1362875,0.0136175,0.553205,2010,2,0x01),
 (7,1,3,562400,617120,0.863432,0.570694,2010,2,0x01),
 (8,1,4,1006141,1770906,0.422168,0.636842,2010,2,0x01),
 (9,1,1,1670303,583870,0.287863,0.331033,2010,3,0x01),
 (10,1,2,472836,826878,0.338407,0.259398,2010,3,0x01),
 (11,1,3,481058,562090,0.414829,0.714701,2010,3,0x01),
 (12,1,4,1306147,1111073,0.663317,0.8327,2010,3,0x01),
 (13,1,1,1107536,1466278,0.583592,0.200078,2010,4,0x01),
 (14,1,2,165290,4968522,0.410381,0.174735,2010,4,0x01),
 (15,1,3,871115,3046782,0.315088,0.0161045,2010,4,0x01),
 (16,1,4,943713,2696461,0.0563424,0.291365,2010,4,0x01),
 (17,1,1,691793,158467,0.13098,0.922802,2010,5,0x01),
 (18,1,2,1228120,2953761,0.181094,0.672251,2010,5,0x01),
 (19,1,3,680561,1026742,0.398164,0.820465,2010,5,0x01),
 (20,1,4,1651160,255634,0.931844,0.292413,2010,5,0x01),
 (21,1,1,1441868,2999256,0.858883,0.503934,2010,6,0x01),
 (22,1,2,895612,666880,0.0967121,0.760822,2010,6,0x01),
 (23,1,3,93979,2521526,0.756606,0.128356,2010,6,0x01),
 (24,1,4,1607867,3056969,0.822932,0.307427,2010,6,0x01),
 (25,1,1,515034,2324783,0.717828,0.20284,2010,7,0x01),
 (26,1,2,978531,4530227,0.264787,0.550038,2010,7,0x01),
 (27,1,3,1822641,64322,0.79994,0.178404,2010,7,0x01),
 (28,1,4,247947,4894415,0.696461,0.23245,2010,7,0x01),
 (29,1,1,1594792,3896631,0.365346,0.946639,2010,8,0x01),
 (30,1,2,1894459,1280983,0.874945,0.375234,2010,8,0x01),
 (31,1,3,839928,1733587,0.691951,0.815477,2010,8,0x01),
 (32,1,4,1763235,280269,0.688165,0.530591,2010,8,0x01),
 (33,1,1,223955,2161992,0.480213,0.778478,2010,9,0x01),
 (34,1,2,1893441,1204947,0.373478,0.0826756,2010,9,0x01),
 (35,1,3,1562046,1266734,0.666879,0.144042,2010,9,0x01),
 (36,1,4,301601,344980,0.841704,0.784796,2010,9,0x01),
 (37,1,1,1083013,845860,0.205595,0.840956,2010,10,0x01),
 (38,1,2,478944,2327371,0.891839,0.974903,2010,10,0x01),
 (39,1,3,1474073,4755833,0.724517,0.966668,2010,10,0x01),
 (40,1,4,1860553,944000,0.351613,0.160762,2010,10,0x01),
 (41,1,1,213837,1375258,0.2211,0.394715,2010,11,0x01),
 (42,1,2,1024129,3060812,0.429047,0.916229,2010,11,0x01),
 (43,1,3,201301,1425360,0.204214,0.507691,2010,11,0x01),
 (44,1,4,1876176,471655,0.810159,0.28002,2010,11,0x01),
 (45,1,1,1188683,1635493,0.943736,0.372178,2010,12,0x01),
 (46,1,2,1583435,810028,0.287993,0.0983965,2010,12,0x01),
 (47,1,3,1025901,991962,0.737791,0.922032,2010,12,0x01),
 (48,1,4,1507364,4882046,0.958103,0.00316433,2010,12,0x01),
 (49,2,1,224509,2558440,0.357777,0.966446,2010,1,0x01),
 (50,2,2,899480,4033886,0.265664,0.96639,2010,1,0x01),
 (51,2,3,1848902,106263,0.0813539,0.0891757,2010,1,0x01),
 (52,2,4,1615381,2416990,0.439371,0.623247,2010,1,0x01),
 (53,2,1,1242609,42869,0.97353,0.755356,2010,2,0x01),
 (54,2,2,605263,264328,0.0972582,0.8044,2010,2,0x01),
 (55,2,3,597475,376696,0.32602,0.192299,2010,2,0x01),
 (56,2,4,1438722,540982,0.0596282,0.96932,2010,2,0x01),
 (57,2,1,1873555,4706782,0.415018,0.860687,2010,3,0x01),
 (58,2,2,621692,2582342,0.654215,0.481954,2010,3,0x01),
 (59,2,3,77532,475374,0.987549,0.582562,2010,3,0x01),
 (60,2,4,963290,2583195,0.0487623,0.92014,2010,3,0x01),
 (61,2,1,1407455,1971810,0.136556,0.642528,2010,4,0x01),
 (62,2,2,750416,2050983,0.396154,0.860189,2010,4,0x01),
 (63,2,3,1271641,4825978,0.474874,0.428553,2010,4,0x01),
 (64,2,4,1987891,1586514,0.827269,0.828024,2010,4,0x01),
 (65,2,1,1689518,4979609,0.768247,0.428801,2010,5,0x01),
 (66,2,2,1461974,3605414,0.576708,0.358296,2010,5,0x01),
 (67,2,3,82252,1373696,0.437552,0.650885,2010,5,0x01),
 (68,2,4,885037,3863589,0.776547,0.35287,2010,5,0x01),
 (69,2,1,1960941,2840319,0.590375,0.779941,2010,6,0x01),
 (70,2,2,879251,2899986,0.70328,0.180107,2010,6,0x01),
 (71,2,3,520229,937169,0.492107,0.641958,2010,6,0x01),
 (72,2,4,57057,4759934,0.513101,0.206321,2010,6,0x01),
 (73,2,1,645100,1713025,0.636706,0.788729,2010,7,0x01),
 (74,2,2,956255,1612343,0.750689,0.700847,2010,7,0x01),
 (75,2,3,1338710,642493,0.827287,0.270871,2010,7,0x01),
 (76,2,4,1087528,4124044,0.166644,0.306098,2010,7,0x01),
 (77,2,1,1079052,1218273,0.926696,0.915284,2010,8,0x01),
 (78,2,2,1852194,3704559,0.628734,0.514041,2010,8,0x01),
 (79,2,3,1112258,3939236,0.188225,0.673488,2010,8,0x01),
 (80,2,4,588019,3984556,0.162112,0.840481,2010,8,0x01),
 (81,2,1,190365,3682602,0.326611,0.857211,2010,9,0x01),
 (82,2,2,1500882,141315,0.403657,0.638572,2010,9,0x01),
 (83,2,3,761346,4698489,0.739507,0.327668,2010,9,0x01),
 (84,2,4,1740137,934431,0.00558728,0.74295,2010,9,0x01),
 (85,2,1,1119235,3715117,0.53954,0.954907,2010,10,0x01),
 (86,2,2,1375442,4565092,0.77352,0.385902,2010,10,0x01),
 (87,2,3,522137,2892955,0.307147,0.913647,2010,10,0x01),
 (88,2,4,532902,722169,0.574116,0.0769785,2010,10,0x01),
 (89,2,1,785945,616085,0.724326,0.632016,2010,11,0x01),
 (90,2,2,1448328,2428414,0.297478,0.387445,2010,11,0x01),
 (91,2,3,361590,4359061,0.499464,0.459573,2010,11,0x01),
 (92,2,4,1695415,2550063,0.409447,0.830991,2010,11,0x01),
 (93,2,1,1403608,1117565,0.2434,0.371052,2010,12,0x01),
 (94,2,2,1346665,1083099,0.878968,0.282097,2010,12,0x01),
 (95,2,3,837868,2141105,0.206873,0.272204,2010,12,0x01),
 (96,2,4,1324858,579474,0.515666,0.623465,2010,12,0x01),
 (97,3,1,936245,4956075,0.0395188,0.724167,2010,1,0x01),
 (98,3,2,702890,3326565,0.0027987,0.563924,2010,1,0x01),
 (99,3,3,1406068,1917435,0.980571,0.152755,2010,1,0x01),
 (100,3,4,1209789,143145,0.16074,0.818204,2010,1,0x01),
 (101,3,1,1502159,777287,0.141411,0.85908,2010,2,0x01),
 (102,3,2,1700714,1905151,0.226146,0.0900057,2010,2,0x01),
 (103,3,3,1169253,4008658,0.790143,0.39791,2010,2,0x01),
 (104,3,4,1848764,1164537,0.181968,0.549751,2010,2,0x01),
 (105,3,1,722638,4872739,0.798329,0.140167,2010,3,0x01),
 (106,3,2,816396,2474476,0.42346,0.748432,2010,3,0x01),
 (107,3,3,1074806,4467880,0.660062,0.085982,2010,3,0x01),
 (108,3,4,1164265,1284212,0.295341,0.158969,2010,3,0x01),
 (109,3,1,1015951,248611,0.743509,0.244697,2010,4,0x01),
 (110,3,2,755321,2516830,0.285272,0.786462,2010,4,0x01),
 (111,3,3,556092,2752981,0.685105,0.148233,2010,4,0x01),
 (112,3,4,1911934,1193230,0.908798,0.538776,2010,4,0x01),
 (113,3,1,1836675,3526493,0.0865328,0.31423,2010,5,0x01),
 (114,3,2,1583904,3715589,0.570911,0.298831,2010,5,0x01),
 (115,3,3,1619431,3480910,0.924664,0.725351,2010,5,0x01),
 (116,3,4,785134,4673585,0.939401,0.890032,2010,5,0x01),
 (117,3,1,1860323,2176217,0.334599,0.641177,2010,6,0x01),
 (118,3,2,56799,286672,0.61513,0.376224,2010,6,0x01),
 (119,3,3,1376388,4764027,0.675977,0.30908,2010,6,0x01),
 (120,3,4,214812,845678,0.13441,0.38759,2010,6,0x01),
 (121,3,1,113288,4580701,0.0427033,0.390501,2010,7,0x01),
 (122,3,2,139413,767020,0.588626,0.413897,2010,7,0x01),
 (123,3,3,21375,628468,0.626254,0.169012,2010,7,0x01),
 (124,3,4,1864674,1122806,0.396262,0.256492,2010,7,0x01),
 (125,3,1,1048098,432831,0.592717,0.856593,2010,8,0x01),
 (126,3,2,1725751,760111,0.0124851,0.0804569,2010,8,0x01),
 (127,3,3,1254554,14534,0.383714,0.564525,2010,8,0x01),
 (128,3,4,821682,3372702,0.611459,0.758331,2010,8,0x01),
 (129,3,1,563989,3964372,0.601379,0.755288,2010,9,0x01),
 (130,3,2,551556,4138506,0.0265145,0.4468,2010,9,0x01),
 (131,3,3,150077,4859129,0.887527,0.241893,2010,9,0x01),
 (132,3,4,1481852,786089,0.483365,0.587767,2010,9,0x01),
 (133,3,1,1972780,2506918,0.457192,0.0510448,2010,10,0x01),
 (134,3,2,302772,203427,0.911496,0.775204,2010,10,0x01),
 (135,3,3,1469608,4760214,0.196666,0.716535,2010,10,0x01),
 (136,3,4,131372,2952270,0.868905,0.179195,2010,10,0x01),
 (137,3,1,910076,2884857,0.486223,0.819284,2010,11,0x01),
 (138,3,2,1919311,4301355,0.365336,0.468577,2010,11,0x01),
 (139,3,3,1421188,723298,0.157658,0.840432,2010,11,0x01),
 (140,3,4,1223027,1641761,0.119171,0.423577,2010,11,0x01),
 (141,3,1,191763,3140384,0.246814,0.643879,2010,12,0x01),
 (142,3,2,1094146,4397685,0.0331287,0.679865,2010,12,0x01),
 (143,3,3,1863385,489958,0.451249,0.154696,2010,12,0x01),
 (144,3,4,347949,3795934,0.923936,0.29542,2010,12,0x01),
 (145,4,1,1615836,2090538,0.453194,0.0497989,2010,1,0x01),
 (146,4,2,967700,1107384,0.791118,0.0816121,2010,1,0x01),
 (147,4,3,1954776,2948394,0.517968,0.527296,2010,1,0x01),
 (148,4,4,902657,4223713,0.160071,0.88992,2010,1,0x01),
 (149,4,1,1709526,4216265,0.0279986,0.47092,2010,2,0x01),
 (150,4,2,1017559,3682692,0.284572,0.295677,2010,2,0x01),
 (151,4,3,248734,4126018,0.862604,0.575941,2010,2,0x01),
 (152,4,4,1451432,505284,0.243875,0.370257,2010,2,0x01),
 (153,4,1,421748,2383528,0.783702,0.25298,2010,3,0x01),
 (154,4,2,1143494,4457865,0.219563,0.483111,2010,3,0x01),
 (155,4,3,233524,2264059,0.237586,0.376116,2010,3,0x01),
 (156,4,4,783995,2602844,0.487302,0.325047,2010,3,0x01),
 (157,4,1,1760848,896426,0.232945,0.191698,2010,4,0x01),
 (158,4,2,1947794,4250930,0.908651,0.594184,2010,4,0x01),
 (159,4,3,317721,4474217,0.205266,0.954277,2010,4,0x01),
 (160,4,4,1668491,4678384,0.9581,0.0359512,2010,4,0x01),
 (161,4,1,1377684,1382367,0.027779,0.106044,2010,5,0x01),
 (162,4,2,210916,1222481,0.570472,0.778576,2010,5,0x01),
 (163,4,3,1260933,2477342,0.579114,0.0662043,2010,5,0x01),
 (164,4,4,299800,1618499,0.343858,0.155439,2010,5,0x01),
 (165,4,1,94000,4009253,0.527807,0.946672,2010,6,0x01),
 (166,4,2,562438,691508,0.88324,0.455717,2010,6,0x01),
 (167,4,3,49838,4924135,0.24382,0.760508,2010,6,0x01),
 (168,4,4,443147,2766227,0.319953,0.294714,2010,6,0x01),
 (169,4,1,376118,1534713,0.99724,0.9395,2010,7,0x01),
 (170,4,2,347340,3408254,0.292148,0.545288,2010,7,0x01),
 (171,4,3,1219533,3797901,0.854293,0.22729,2010,7,0x01),
 (172,4,4,1273033,359926,0.921408,0.0217841,2010,7,0x01),
 (173,4,1,753952,3687352,0.930852,0.264458,2010,8,0x01),
 (174,4,2,687582,4784104,0.570678,0.357873,2010,8,0x01),
 (175,4,3,620201,2399307,0.913576,0.431967,2010,8,0x01),
 (176,4,4,1907477,179174,0.418656,0.769702,2010,8,0x01),
 (177,4,1,1185319,4380042,0.00884735,0.769378,2010,9,0x01),
 (178,4,2,739003,2578506,0.135818,0.645776,2010,9,0x01),
 (179,4,3,629079,2413196,0.729663,0.0342404,2010,9,0x01),
 (180,4,4,1637567,1897710,0.197208,0.154952,2010,9,0x01),
 (181,4,1,365579,4255242,0.180629,0.219056,2010,10,0x01),
 (182,4,2,143530,542917,0.617183,0.313985,2010,10,0x01),
 (183,4,3,1807752,2557415,0.751223,0.0922363,2010,10,0x01),
 (184,4,4,852325,1643399,0.141228,0.205996,2010,10,0x01),
 (185,4,1,1982566,1062343,0.377476,0.579454,2010,11,0x01),
 (186,4,2,676700,521794,0.180044,0.291299,2010,11,0x01),
 (187,4,3,4753,1313684,0.782229,0.0517874,2010,11,0x01),
 (188,4,4,1658885,4265227,0.0210163,0.00197486,2010,11,0x01),
 (189,4,1,916861,367052,0.354128,0.837075,2010,12,0x01),
 (190,4,2,90496,510602,0.102264,0.0616054,2010,12,0x01),
 (191,4,3,1903468,1240490,0.575498,0.520881,2010,12,0x01),
 (192,4,4,1197989,2807339,0.384395,0.221571,2010,12,0x01),
 (193,5,1,387344,4092805,0.159274,0.853478,2010,1,0x01),
 (194,5,2,1151489,1170861,0.105138,0.35532,2010,1,0x01),
 (195,5,3,15374,2368016,0.305128,0.329257,2010,1,0x01),
 (196,5,4,654784,2690087,0.452005,0.102019,2010,1,0x01),
 (197,5,1,1042087,4394212,0.73495,0.754962,2010,2,0x01),
 (198,5,2,874308,3302223,0.938139,0.500979,2010,2,0x01),
 (199,5,3,118561,2175102,0.417851,0.373168,2010,2,0x01),
 (200,5,4,964940,3098135,0.516504,0.308279,2010,2,0x01),
 (201,5,1,994544,362527,0.144834,0.357399,2010,3,0x01),
 (202,5,2,950399,3771579,0.717574,0.936985,2010,3,0x01),
 (203,5,3,141596,4648230,0.363288,0.745292,2010,3,0x01),
 (204,5,4,216079,3075575,0.345675,0.212365,2010,3,0x01),
 (205,5,1,1805057,63157,0.931465,0.126226,2010,4,0x01),
 (206,5,2,372117,2399198,0.519143,0.383519,2010,4,0x01),
 (207,5,3,1492676,922556,0.703106,0.6498,2010,4,0x01),
 (208,5,4,1744515,4828081,0.0894398,0.082824,2010,4,0x01),
 (209,5,1,1407676,405199,0.102349,0.171593,2010,5,0x01),
 (210,5,2,1252124,2301896,0.724404,0.174596,2010,5,0x01),
 (211,5,3,1834111,4004950,0.099094,0.602584,2010,5,0x01),
 (212,5,4,1927307,1732101,0.190774,0.684382,2010,5,0x01),
 (213,5,1,982289,2343010,0.244982,0.778666,2010,6,0x01),
 (214,5,2,838093,1193239,0.621148,0.250286,2010,6,0x01),
 (215,5,3,302104,79091,0.680128,0.416637,2010,6,0x01),
 (216,5,4,669626,3551065,0.800539,0.787735,2010,6,0x01),
 (217,5,1,772066,3909806,0.27078,0.973089,2010,7,0x01),
 (218,5,2,722735,1140777,0.757674,0.309089,2010,7,0x01),
 (219,5,3,171856,3892574,0.288055,0.472594,2010,7,0x01),
 (220,5,4,1587429,1358643,0.196205,0.089506,2010,7,0x01),
 (221,5,1,1846215,3583290,0.287907,0.621598,2010,8,0x01),
 (222,5,2,249131,4280303,0.550975,0.620464,2010,8,0x01),
 (223,5,3,1967977,726068,0.102482,0.774424,2010,8,0x01),
 (224,5,4,885458,4669017,0.7045,0.0423485,2010,8,0x01),
 (225,5,1,808056,1483322,0.103021,0.567795,2010,9,0x01),
 (226,5,2,1111379,1987154,0.648832,0.997514,2010,9,0x01),
 (227,5,3,20212,2444480,0.144464,0.290282,2010,9,0x01),
 (228,5,4,1930534,3274195,0.627943,0.0952155,2010,9,0x01),
 (229,5,1,448393,901601,0.851913,0.303079,2010,10,0x01),
 (230,5,2,150555,4535,0.545806,0.429833,2010,10,0x01),
 (231,5,3,1464476,130175,0.159105,0.0785182,2010,10,0x01),
 (232,5,4,520178,1288355,0.675303,0.843779,2010,10,0x01),
 (233,5,1,1344215,2663401,0.259062,0.672727,2010,11,0x01),
 (234,5,2,1345981,2028871,0.953147,0.876504,2010,11,0x01),
 (235,5,3,689208,798211,0.377063,0.698836,2010,11,0x01),
 (236,5,4,1846538,899211,0.395949,0.591008,2010,11,0x01),
 (237,5,1,1402700,4821321,0.0260972,0.117138,2010,12,0x01),
 (238,5,2,1819,4252209,0.4226,0.719253,2010,12,0x01),
 (239,5,3,227031,693613,0.654962,0.408616,2010,12,0x01),
 (240,5,4,155633,3326426,0.118119,0.817901,2010,12,0x01),
 (241,6,1,350536,181078,0.849154,0.948231,2010,1,0x01),
 (242,6,2,128952,3361627,0.724123,0.375761,2010,1,0x01),
 (243,6,3,1091727,2670675,0.494709,0.644391,2010,1,0x01),
 (244,6,4,101896,4487045,0.891083,0.0643764,2010,1,0x01),
 (245,6,1,168547,4159315,0.565153,0.160998,2010,2,0x01),
 (246,6,2,22211,495687,0.477508,0.573134,2010,2,0x01),
 (247,6,3,1560526,154297,0.441717,0.288478,2010,2,0x01),
 (248,6,4,798053,2867959,0.931226,0.72032,2010,2,0x01),
 (249,6,1,471643,473462,0.926971,0.280214,2010,3,0x01),
 (250,6,2,1032884,3657920,0.537911,0.781524,2010,3,0x01),
 (251,6,3,1401705,183345,0.362036,0.220765,2010,3,0x01),
 (252,6,4,1560293,2105408,0.0720208,0.226787,2010,3,0x01),
 (253,6,1,1834070,2163610,0.507528,0.742304,2010,4,0x01),
 (254,6,2,536558,1087345,0.635286,0.307915,2010,4,0x01),
 (255,6,3,547502,3036050,0.098391,0.655658,2010,4,0x01),
 (256,6,4,348761,771504,0.717924,0.187357,2010,4,0x01),
 (257,6,1,59990,446429,0.232775,0.312368,2010,5,0x01),
 (258,6,2,96262,3086000,0.767724,0.550052,2010,5,0x01),
 (259,6,3,1212338,937443,0.00512058,0.764179,2010,5,0x01),
 (260,6,4,1903359,1867800,0.802164,0.889653,2010,5,0x01),
 (261,6,1,399345,3901104,0.043591,0.0363531,2010,6,0x01),
 (262,6,2,1820927,4803533,0.848706,0.91054,2010,6,0x01),
 (263,6,3,456359,3348799,0.86203,0.0812254,2010,6,0x01),
 (264,6,4,574867,4525876,0.248446,0.737014,2010,6,0x01),
 (265,6,1,709067,487320,0.186582,0.228397,2010,7,0x01),
 (266,6,2,1919161,2478802,0.108251,0.871094,2010,7,0x01),
 (267,6,3,194282,1339145,0.667144,0.197984,2010,7,0x01),
 (268,6,4,851366,414967,0.436557,0.0903162,2010,7,0x01),
 (269,6,1,559577,4895256,0.633794,0.993315,2010,8,0x01),
 (270,6,2,448330,638517,0.747977,0.726938,2010,8,0x01),
 (271,6,3,1649560,3538767,0.808368,0.239497,2010,8,0x01),
 (272,6,4,579979,2356609,0.171877,0.0199619,2010,8,0x01),
 (273,6,1,1286604,3727636,0.131323,0.784246,2010,9,0x01),
 (274,6,2,258954,2752905,0.35007,0.481374,2010,9,0x01),
 (275,6,3,1253857,1174773,0.114057,0.627391,2010,9,0x01),
 (276,6,4,1883929,2646336,0.658801,0.468017,2010,9,0x01),
 (277,6,1,1988318,1013785,0.376838,0.495462,2010,10,0x01),
 (278,6,2,134422,2848419,0.540153,0.400494,2010,10,0x01),
 (279,6,3,991834,4688672,0.28249,0.627759,2010,10,0x01),
 (280,6,4,774900,3582391,0.978062,0.320509,2010,10,0x01),
 (281,6,1,467774,1555736,0.826009,0.590323,2010,11,0x01),
 (282,6,2,1126008,577466,0.404066,0.72806,2010,11,0x01),
 (283,6,3,191251,4435990,0.190247,0.184196,2010,11,0x01),
 (284,6,4,460716,2701471,0.567966,0.889877,2010,11,0x01),
 (285,6,1,120663,4606358,0.627837,0.764397,2010,12,0x01),
 (286,6,2,1083210,2245169,0.158549,0.0605284,2010,12,0x01),
 (287,6,3,1758378,2967921,0.579499,0.535997,2010,12,0x01),
 (288,6,4,1348334,221516,0.209525,0.307582,2010,12,0x01),
 (289,7,1,866720,1272163,0.539503,0.365729,2010,1,0x00),
 (290,7,2,1367753,4470363,0.860124,0.149562,2010,1,0x00),
 (291,7,3,1447524,4565775,0.409251,0.0138502,2010,1,0x00),
 (292,7,4,560516,2180384,0.0182449,0.924388,2010,1,0x00),
 (293,7,1,1911181,3576582,0.752286,0.609222,2010,2,0x00),
 (294,7,2,1981841,3208909,0.0141932,0.925485,2010,2,0x00),
 (295,7,3,1108133,2758948,0.526682,0.253329,2010,2,0x00),
 (296,7,4,275924,1183568,0.400353,0.387188,2010,2,0x00),
 (297,7,1,862386,1795935,0.308213,0.309672,2010,3,0x00),
 (298,7,2,655293,294265,0.38222,0.179653,2010,3,0x00),
 (299,7,3,1158401,1955002,0.82335,0.843661,2010,3,0x00),
 (300,7,4,1927124,1915148,0.37389,0.188488,2010,3,0x00),
 (301,7,1,1477524,4582702,0.739155,0.692947,2010,4,0x00),
 (302,7,2,1172988,1734708,0.765527,0.608009,2010,4,0x00),
 (303,7,3,416760,3789121,0.682733,0.297088,2010,4,0x00),
 (304,7,4,464858,69768,0.000454086,0.402041,2010,4,0x00),
 (305,7,1,222710,1622866,0.712884,0.665461,2010,5,0x00),
 (306,7,2,500178,4289155,0.30954,0.436169,2010,5,0x00),
 (307,7,3,1373481,287367,0.716634,0.112322,2010,5,0x00),
 (308,7,4,538822,3522839,0.700528,0.0353403,2010,5,0x00),
 (309,7,1,841392,2199289,0.453273,0.637931,2010,6,0x00),
 (310,7,2,524732,2082303,0.0499587,0.970725,2010,6,0x00),
 (311,7,3,169256,4939822,0.218582,0.0846291,2010,6,0x00),
 (312,7,4,1775073,4267950,0.395359,0.129748,2010,6,0x00),
 (313,7,1,1993096,4399634,0.351893,0.446797,2010,7,0x00),
 (314,7,2,1119700,4489304,0.775335,0.373194,2010,7,0x00),
 (315,7,3,144079,668278,0.0586355,0.963579,2010,7,0x00),
 (316,7,4,1873749,2873806,0.21524,0.333281,2010,7,0x00),
 (317,7,1,962469,2468812,0.271031,0.873296,2010,8,0x00),
 (318,7,2,1526186,2789970,0.706062,0.156636,2010,8,0x00),
 (319,7,3,1956457,2188445,0.519596,0.958444,2010,8,0x00),
 (320,7,4,527093,2960698,0.274198,0.446048,2010,8,0x00),
 (321,7,1,438629,4805957,0.0380963,0.260189,2010,9,0x00),
 (322,7,2,1056535,3092511,0.489762,0.904924,2010,9,0x00),
 (323,7,3,1272919,266699,0.574626,0.59126,2010,9,0x00),
 (324,7,4,1157798,3196508,0.011089,0.438351,2010,9,0x00),
 (325,7,1,1364844,105941,0.631448,0.72615,2010,10,0x00),
 (326,7,2,117829,3026802,0.0130878,0.714664,2010,10,0x00),
 (327,7,3,1027841,371354,0.106274,0.397535,2010,10,0x00),
 (328,7,4,1477664,4312241,0.597101,0.441435,2010,10,0x00),
 (329,7,1,858512,4145409,0.55762,0.477806,2010,11,0x00),
 (330,7,2,555698,4707180,0.529925,0.859779,2010,11,0x00),
 (331,7,3,1253591,3218470,0.566907,0.974627,2010,11,0x00),
 (332,7,4,1866561,3637089,0.909657,0.210898,2010,11,0x00),
 (333,7,1,201456,4713360,0.919957,0.719435,2010,12,0x00),
 (334,7,2,318451,1464779,0.606005,0.178748,2010,12,0x00),
 (335,7,3,1480975,4712195,0.580544,0.877764,2010,12,0x00),
 (336,7,4,571713,4653027,0.572737,0.56276,2010,12,0x00),
 (337,8,1,1900530,2186245,0.678652,0.660325,2010,1,0x00),
 (338,8,2,1441498,849387,0.379917,0.684497,2010,1,0x00),
 (339,8,3,710004,2779629,0.986101,0.863731,2010,1,0x00),
 (340,8,4,727287,4068944,0.563586,0.282178,2010,1,0x00),
 (341,8,1,818548,3247601,0.602195,0.11978,2010,2,0x00),
 (342,8,2,352114,1400840,0.640537,0.89695,2010,2,0x00),
 (343,8,3,1950969,3600227,0.822043,0.982205,2010,2,0x00),
 (344,8,4,194299,3914293,0.885853,0.00483353,2010,2,0x00),
 (345,8,1,375505,252222,0.410225,0.229789,2010,3,0x00),
 (346,8,2,1494488,689949,0.220853,0.398238,2010,3,0x00),
 (347,8,3,335835,4729732,0.752437,0.0147567,2010,3,0x00),
 (348,8,4,1220832,1152292,0.809113,0.570958,2010,3,0x00),
 (349,8,1,820128,3734851,0.607791,0.735351,2010,4,0x00),
 (350,8,2,1275103,2128951,0.208203,0.110555,2010,4,0x00),
 (351,8,3,1799933,2618635,0.434416,0.761496,2010,4,0x00),
 (352,8,4,922566,2312633,0.174813,0.352028,2010,4,0x00),
 (353,8,1,571737,563415,0.511014,0.392453,2010,5,0x00),
 (354,8,2,1328420,3051499,0.470915,0.796685,2010,5,0x00),
 (355,8,3,1333986,2025173,0.327043,0.675382,2010,5,0x00),
 (356,8,4,1583617,643745,0.268613,0.0501139,2010,5,0x00),
 (357,8,1,1632409,236778,0.96416,0.963706,2010,6,0x00),
 (358,8,2,102877,1562179,0.00135557,0.283171,2010,6,0x00),
 (359,8,3,1806426,4822850,0.441595,0.344189,2010,6,0x00),
 (360,8,4,1777697,3284570,0.759139,0.469878,2010,6,0x00),
 (361,8,1,69470,1827039,0.248117,0.311638,2010,7,0x00),
 (362,8,2,1767197,4655555,0.575386,0.906148,2010,7,0x00),
 (363,8,3,356038,702502,0.533233,0.320124,2010,7,0x00),
 (364,8,4,1309576,955880,0.203138,0.763237,2010,7,0x00),
 (365,8,1,568277,4066351,0.680283,0.089642,2010,8,0x00),
 (366,8,2,1437020,104758,0.22822,0.679832,2010,8,0x00),
 (367,8,3,1354910,2268874,0.234096,0.797105,2010,8,0x00),
 (368,8,4,976866,2671125,0.617045,0.64668,2010,8,0x00),
 (369,8,1,55339,1078274,0.40585,0.530582,2010,9,0x00),
 (370,8,2,1721828,4619586,0.0466935,0.687663,2010,9,0x00),
 (371,8,3,941700,2031750,0.627794,0.635692,2010,9,0x00),
 (372,8,4,152111,2966808,0.614951,0.0912331,2010,9,0x00),
 (373,8,1,1391729,1253662,0.880504,0.833051,2010,10,0x00),
 (374,8,2,1592203,774161,0.777935,0.196102,2010,10,0x00),
 (375,8,3,125207,3791595,0.765305,0.23568,2010,10,0x00),
 (376,8,4,1185191,4152391,0.612981,0.985097,2010,10,0x00),
 (377,8,1,136823,1771078,0.544531,0.645292,2010,11,0x00),
 (378,8,2,567380,204089,0.754446,0.991093,2010,11,0x00),
 (379,8,3,1458264,919746,0.622282,0.756341,2010,11,0x00),
 (380,8,4,1626044,1079743,0.600073,0.268923,2010,11,0x00),
 (381,8,1,1382338,1261742,0.188318,0.146768,2010,12,0x00),
 (382,8,2,1223127,573173,0.635588,0.437171,2010,12,0x00),
 (383,8,3,281943,4033113,0.997765,0.184325,2010,12,0x00),
 (384,8,4,1267690,932100,0.97517,0.0437591,2010,12,0x00),
 (385,9,1,1656699,3119010,0.509275,0.227395,2010,1,0x00),
 (386,9,2,1019929,3809650,0.465472,0.759232,2010,1,0x00),
 (387,9,3,1540061,563438,0.854303,0.74922,2010,1,0x00),
 (388,9,4,1009575,532576,0.950815,0.151645,2010,1,0x00),
 (389,9,1,899702,1952384,0.360155,0.264425,2010,2,0x00),
 (390,9,2,451484,3111957,0.547258,0.0469608,2010,2,0x00),
 (391,9,3,1164013,3721056,0.59947,0.186766,2010,2,0x00),
 (392,9,4,541229,3672191,0.0231493,0.728866,2010,2,0x00),
 (393,9,1,1507498,686053,0.188779,0.996991,2010,3,0x00),
 (394,9,2,513517,1224027,0.633859,0.481907,2010,3,0x00),
 (395,9,3,1027908,3353214,0.808807,0.349726,2010,3,0x00),
 (396,9,4,1846228,957441,0.008322,0.231859,2010,3,0x00),
 (397,9,1,1447894,801965,0.169174,0.998301,2010,4,0x00),
 (398,9,2,492903,2480126,0.935053,0.287226,2010,4,0x00),
 (399,9,3,474025,1196902,0.890149,0.666408,2010,4,0x00),
 (400,9,4,1526479,4677386,0.145304,0.435784,2010,4,0x00),
 (401,9,1,445954,3227431,0.52411,0.245501,2010,5,0x00),
 (402,9,2,1077103,1119209,0.440997,0.900074,2010,5,0x00),
 (403,9,3,1408568,3026223,0.189376,0.946854,2010,5,0x00),
 (404,9,4,946810,1190289,0.765108,0.905743,2010,5,0x00),
 (405,9,1,239921,2367263,0.53905,0.287175,2010,6,0x00),
 (406,9,2,1783910,3368814,0.0621509,0.866654,2010,6,0x00),
 (407,9,3,1967755,194297,0.0375574,0.0366761,2010,6,0x00),
 (408,9,4,1199871,3329760,0.0264131,0.440656,2010,6,0x00),
 (409,9,1,1907454,780433,0.767499,0.508522,2010,7,0x00),
 (410,9,2,1711515,798491,0.085609,0.959927,2010,7,0x00),
 (411,9,3,1754198,3069690,0.239512,0.818551,2010,7,0x00),
 (412,9,4,1891358,330457,0.217599,0.989799,2010,7,0x00),
 (413,9,1,1262171,2001278,0.927766,0.994175,2010,8,0x00),
 (414,9,2,608877,2442748,0.447834,0.0199685,2010,8,0x00),
 (415,9,3,1643607,3867379,0.503767,0.0613742,2010,8,0x00),
 (416,9,4,745541,2773302,0.125183,0.541994,2010,8,0x00),
 (417,9,1,1320504,4005226,0.991125,0.48868,2010,9,0x00),
 (418,9,2,1266408,3193545,0.323798,0.0169939,2010,9,0x00),
 (419,9,3,1161805,1374245,0.313928,0.617065,2010,9,0x00),
 (420,9,4,1031102,50237,0.968668,0.487453,2010,9,0x00),
 (421,9,1,838872,819055,0.961395,0.954634,2010,10,0x00),
 (422,9,2,226976,962312,0.532532,0.837029,2010,10,0x00),
 (423,9,3,432055,69098,0.741454,0.465033,2010,10,0x00),
 (424,9,4,1807293,2848499,0.40179,0.952286,2010,10,0x00),
 (425,9,1,1921166,4775684,0.845908,0.228475,2010,11,0x00),
 (426,9,2,1817210,111491,0.259081,0.290242,2010,11,0x00),
 (427,9,3,1692696,1137236,0.699836,0.104296,2010,11,0x00),
 (428,9,4,1990405,3154447,0.0801782,0.605655,2010,11,0x00),
 (429,9,1,1696541,1913500,0.317898,0.273936,2010,12,0x00),
 (430,9,2,499132,3655624,0.592861,0.841934,2010,12,0x00),
 (431,9,3,1385101,2879531,0.140187,0.793262,2010,12,0x00),
 (432,9,4,1240545,4276896,0.295418,0.439596,2010,12,0x00),
 (433,10,1,1067525,3020204,0.570293,0.53314,2010,1,0x00),
 (434,10,2,542082,1731962,0.382431,0.566177,2010,1,0x00),
 (435,10,3,1811935,3016052,0.688234,0.137152,2010,1,0x00),
 (436,10,4,668728,3390004,0.175519,0.021485,2010,1,0x00),
 (437,10,1,1528439,2821205,0.860907,0.875372,2010,2,0x00),
 (438,10,2,14977,3840604,0.906662,0.822122,2010,2,0x00),
 (439,10,3,1365735,384211,0.222717,0.523102,2010,2,0x00),
 (440,10,4,364285,4095672,0.951796,0.719168,2010,2,0x00),
 (441,10,1,1054132,4812526,0.249045,0.643487,2010,3,0x00),
 (442,10,2,98864,2354180,0.862316,0.152946,2010,3,0x00),
 (443,10,3,327796,3531446,0.895198,0.902896,2010,3,0x00),
 (444,10,4,742577,1505490,0.792146,0.398749,2010,3,0x00),
 (445,10,1,59024,4238263,0.0235148,0.29799,2010,4,0x00),
 (446,10,2,719800,4797044,0.168037,0.907472,2010,4,0x00),
 (447,10,3,1237375,3702438,0.0912691,0.423376,2010,4,0x00),
 (448,10,4,713025,2342205,0.700742,0.0950235,2010,4,0x00),
 (449,10,1,426463,1712554,0.322036,0.158761,2010,5,0x00),
 (450,10,2,1502034,2394024,0.0847355,0.0844359,2010,5,0x00),
 (451,10,3,831209,4720849,0.833172,0.404498,2010,5,0x00),
 (452,10,4,1667455,2560724,0.984122,0.154583,2010,5,0x00),
 (453,10,1,608401,4986094,0.442067,0.744446,2010,6,0x00),
 (454,10,2,1041507,2388678,0.152393,0.899409,2010,6,0x00),
 (455,10,3,553333,2265606,0.123826,0.165042,2010,6,0x00),
 (456,10,4,288752,4988648,0.783696,0.351565,2010,6,0x00),
 (457,10,1,1795369,1357177,0.343031,0.209493,2010,7,0x00),
 (458,10,2,1499661,1631101,0.443261,0.574381,2010,7,0x00),
 (459,10,3,635224,41699,0.732253,0.195989,2010,7,0x00),
 (460,10,4,1179822,4486335,0.174651,0.476058,2010,7,0x00),
 (461,10,1,156781,3227263,0.839949,0.378857,2010,8,0x00),
 (462,10,2,1517567,3935251,0.631478,0.849999,2010,8,0x00),
 (463,10,3,746256,345523,0.920421,0.181543,2010,8,0x00),
 (464,10,4,312881,3126497,0.331263,0.895177,2010,8,0x00),
 (465,10,1,151532,4301088,0.988482,0.880349,2010,9,0x00),
 (466,10,2,450356,3705814,0.379077,0.720459,2010,9,0x00),
 (467,10,3,214457,1524749,0.611483,0.367813,2010,9,0x00),
 (468,10,4,299039,2893328,0.258622,0.586776,2010,9,0x00),
 (469,10,1,1908928,3931296,0.161374,0.87465,2010,10,0x00),
 (470,10,2,921968,3334594,0.53842,0.891057,2010,10,0x00),
 (471,10,3,817590,4832724,0.499428,0.779157,2010,10,0x00),
 (472,10,4,478211,3401160,0.590753,0.145831,2010,10,0x00),
 (473,10,1,1679915,2107606,0.316311,0.88298,2010,11,0x00),
 (474,10,2,700220,1866437,0.671017,0.458395,2010,11,0x00),
 (475,10,3,1144542,3177401,0.600137,0.782173,2010,11,0x00),
 (476,10,4,829328,2132656,0.955149,0.263473,2010,11,0x00),
 (477,10,1,358621,2590507,0.955173,0.212418,2010,12,0x00),
 (478,10,2,892171,2434690,0.382768,0.313245,2010,12,0x00),
 (479,10,3,1527025,4264803,0.743846,0.497353,2010,12,0x00),
 (480,10,4,700875,4696528,0.403714,0.17868,2010,12,0x00),
 (481,11,1,1074219,1689494,0.274706,0.478881,2010,1,0x00),
 (482,11,2,1459810,966182,0.975604,0.766063,2010,1,0x00),
 (483,11,3,541592,637018,0.509013,0.558389,2010,1,0x00),
 (484,11,4,1361723,2604792,0.410103,0.602623,2010,1,0x00),
 (485,11,1,853094,185817,0.00858666,0.727765,2010,2,0x00),
 (486,11,2,1056059,3655745,0.915531,0.895173,2010,2,0x00),
 (487,11,3,81957,4104723,0.0975925,0.719139,2010,2,0x00),
 (488,11,4,1372294,1069548,0.933478,0.615669,2010,2,0x00),
 (489,11,1,1351330,899782,0.460906,0.652234,2010,3,0x00),
 (490,11,2,181081,710267,0.617089,0.117588,2010,3,0x00),
 (491,11,3,1643,2074245,0.651719,0.808247,2010,3,0x00),
 (492,11,4,1776022,4319297,0.0486599,0.0370387,2010,3,0x00),
 (493,11,1,1657500,4402568,0.231049,0.409166,2010,4,0x00),
 (494,11,2,658899,3862261,0.0442118,0.482504,2010,4,0x00),
 (495,11,3,1326928,3269143,0.511791,0.531417,2010,4,0x00),
 (496,11,4,111134,934789,0.642697,0.767127,2010,4,0x00),
 (497,11,1,165780,372585,0.129989,0.532763,2010,5,0x00),
 (498,11,2,434341,152991,0.627492,0.187444,2010,5,0x00),
 (499,11,3,1040113,346332,0.915966,0.621349,2010,5,0x00),
 (500,11,4,242743,1704393,0.677833,0.602471,2010,5,0x00),
 (501,11,1,519361,2096353,0.78798,0.445809,2010,6,0x00),
 (502,11,2,690283,4485102,0.997854,0.817053,2010,6,0x00),
 (503,11,3,1433093,1906732,0.641059,0.835328,2010,6,0x00),
 (504,11,4,1015251,2499013,0.520882,0.0233775,2010,6,0x00),
 (505,11,1,624192,1613925,0.453664,0.0685871,2010,7,0x00),
 (506,11,2,285211,3444804,0.0366376,0.80456,2010,7,0x00),
 (507,11,3,1031252,1400452,0.0848514,0.300468,2010,7,0x00),
 (508,11,4,725071,4666527,0.839014,0.454212,2010,7,0x00),
 (509,11,1,1733017,3008829,0.484576,0.0254547,2010,8,0x00),
 (510,11,2,511092,2893568,0.742077,0.615888,2010,8,0x00),
 (511,11,3,87664,426498,0.289799,0.706613,2010,8,0x00),
 (512,11,4,413651,445752,0.561942,0.496333,2010,8,0x00),
 (513,11,1,599741,1342550,0.0290599,0.949071,2010,9,0x00),
 (514,11,2,1171567,1829373,0.412198,0.156421,2010,9,0x00),
 (515,11,3,1647599,3927022,0.408154,0.846897,2010,9,0x00),
 (516,11,4,980819,899951,0.410516,0.633697,2010,9,0x00),
 (517,11,1,1704089,4733539,0.399593,0.382285,2010,10,0x00),
 (518,11,2,980443,17465,0.644113,0.900433,2010,10,0x00),
 (519,11,3,1183365,4776097,0.108487,0.00595542,2010,10,0x00),
 (520,11,4,1118440,3869867,0.491724,0.911102,2010,10,0x00),
 (521,11,1,546601,2080756,0.637512,0.777675,2010,11,0x00),
 (522,11,2,1280505,1890658,0.649728,0.243167,2010,11,0x00),
 (523,11,3,1799430,263025,0.423619,0.695799,2010,11,0x00),
 (524,11,4,1064378,4446284,0.460104,0.0851059,2010,11,0x00),
 (525,11,1,1013919,3931737,0.769144,0.0947518,2010,12,0x00),
 (526,11,2,82644,4219169,0.387851,0.575571,2010,12,0x00),
 (527,11,3,7889,2970168,0.53996,0.239338,2010,12,0x00),
 (528,11,4,1176780,462128,0.745551,0.747586,2010,12,0x00),
 (529,12,1,1814401,3995204,0.253352,0.494808,2010,1,0x00),
 (530,12,2,1425285,49976,0.0127083,0.581695,2010,1,0x00),
 (531,12,3,1074216,3545327,0.0282489,0.701565,2010,1,0x00),
 (532,12,4,328667,504088,0.347542,0.921964,2010,1,0x00),
 (533,12,1,984035,3798199,0.120479,0.633434,2010,2,0x00),
 (534,12,2,1054145,1415709,0.138871,0.258741,2010,2,0x00),
 (535,12,3,933347,2868637,0.0157068,0.668394,2010,2,0x00),
 (536,12,4,1122838,1943779,0.695761,0.632084,2010,2,0x00),
 (537,12,1,1462677,2987746,0.3027,0.0506804,2010,3,0x00),
 (538,12,2,1422287,3313076,0.422581,0.159764,2010,3,0x00),
 (539,12,3,1676069,1114001,0.799591,0.373158,2010,3,0x00),
 (540,12,4,927090,1488432,0.0771294,0.943744,2010,3,0x00),
 (541,12,1,740596,2777053,0.655782,0.158885,2010,4,0x00),
 (542,12,2,1010496,1450823,0.959487,0.359043,2010,4,0x00),
 (543,12,3,1605722,1205050,0.402157,0.670757,2010,4,0x00),
 (544,12,4,1729743,751112,0.129248,0.978893,2010,4,0x00),
 (545,12,1,1575327,36239,0.172249,0.328151,2010,5,0x00),
 (546,12,2,967966,1267211,0.998789,0.640093,2010,5,0x00),
 (547,12,3,865207,4165642,0.567028,0.359469,2010,5,0x00),
 (548,12,4,1815487,4340470,0.900239,0.402469,2010,5,0x00),
 (549,12,1,778850,4527592,0.885955,0.569485,2010,6,0x00),
 (550,12,2,73297,717041,0.473784,0.406341,2010,6,0x00),
 (551,12,3,1634322,3864885,0.696969,0.350413,2010,6,0x00),
 (552,12,4,261536,2970031,0.974998,0.881909,2010,6,0x00),
 (553,12,1,1075062,1785367,0.968058,0.315586,2010,7,0x00),
 (554,12,2,1015804,4328201,0.84882,0.814462,2010,7,0x00),
 (555,12,3,1897394,3656695,0.233067,0.184668,2010,7,0x00),
 (556,12,4,1254089,4087004,0.167855,0.0193089,2010,7,0x00),
 (557,12,1,1027584,4140099,0.514408,0.799294,2010,8,0x00),
 (558,12,2,997147,1027746,0.782658,0.63036,2010,8,0x00),
 (559,12,3,1781235,2413881,0.97532,0.398052,2010,8,0x00),
 (560,12,4,1225123,2520632,0.281633,0.256233,2010,8,0x00),
 (561,12,1,37860,2387466,0.524337,0.529701,2010,9,0x00),
 (562,12,2,1653260,3237509,0.108237,0.307817,2010,9,0x00),
 (563,12,3,1463404,2456769,0.844628,0.233553,2010,9,0x00),
 (564,12,4,1809470,3650062,0.433118,0.25119,2010,9,0x00),
 (565,12,1,1413580,601667,0.570852,0.365903,2010,10,0x00),
 (566,12,2,1296606,4739247,0.628852,0.789791,2010,10,0x00),
 (567,12,3,1650781,1876349,0.586194,0.201421,2010,10,0x00),
 (568,12,4,1622234,1591763,0.444941,0.229763,2010,10,0x00),
 (569,12,1,507417,1593340,0.66224,0.688422,2010,11,0x00),
 (570,12,2,478731,4809311,0.230726,0.53237,2010,11,0x00),
 (571,12,3,1628464,3751959,0.914332,0.986907,2010,11,0x00),
 (572,12,4,1856500,4906459,0.803856,0.80739,2010,11,0x00),
 (573,12,1,926066,512014,0.79508,0.168282,2010,12,0x00),
 (574,12,2,1873142,1122855,0.812,0.251391,2010,12,0x00),
 (575,12,3,1878963,4763497,0.598674,0.205673,2010,12,0x00),
 (576,12,4,701369,2325602,0.685427,0.784806,2010,12,0x00);
/*!40000 ALTER TABLE `estado_resultados` ENABLE KEYS */;


--
-- Definition of table `usuario_depto`
--

DROP TABLE IF EXISTS `usuario_depto`;
CREATE TABLE `usuario_depto` (
  `id_user` int(11) NOT NULL,
  `id_depto` int(11) NOT NULL,
  KEY `id_user` (`id_user`),
  KEY `id_depto` (`id_depto`),
  CONSTRAINT `usuario_depto_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `usuarios` (`id_usuario`) ON UPDATE CASCADE,
  CONSTRAINT `usuario_depto_ibfk_2` FOREIGN KEY (`id_depto`) REFERENCES `departamentos` (`id_depto`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario_depto`
--

/*!40000 ALTER TABLE `usuario_depto` DISABLE KEYS */;
INSERT INTO `usuario_depto` (`id_user`,`id_depto`) VALUES 
 (1,1),
 (1,2),
 (1,3),
 (1,4),
 (2,1),
 (3,2),
 (4,3),
 (5,4);
/*!40000 ALTER TABLE `usuario_depto` ENABLE KEYS */;


--
-- Definition of table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_com` varchar(90) NOT NULL,
  `nombre_user` varchar(20) NOT NULL,
  `contrasena` varchar(10) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id_usuario`,`nombre_com`,`nombre_user`,`contrasena`) VALUES 
 (1,'Rolando Castanon Mendez','Rolando','Rolas01'),
 (2,'Daniel Villagomez Lopez','Dany','Dany01'),
 (3,'Edsel Serrano Montiel','Edsel','Edsel10'),
 (4,'Beatriz Vazquez Hernadez ','Betty','Betty88'),
 (5,'Rosa Gonzalez Gallegos','Rosa','Rosa11');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;