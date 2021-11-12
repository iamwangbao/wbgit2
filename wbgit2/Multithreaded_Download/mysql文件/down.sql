/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.17 : Database - down
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`down` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `down`;

/*Table structure for table `down_information` */

DROP TABLE IF EXISTS `down_information`;

CREATE TABLE `down_information` (
  `down_id` int(32) NOT NULL COMMENT '下载id，取消自动增加',
  `down_url` varchar(60) DEFAULT NULL COMMENT '下载链接',
  `down_filename` varchar(32) DEFAULT NULL COMMENT '文件名',
  `down_savapath` varchar(60) DEFAULT NULL COMMENT '保存路径',
  `down_size` varchar(32) DEFAULT NULL COMMENT '文件大小',
  `down_strattime` datetime(6) DEFAULT NULL COMMENT '下载开始时间',
  `down_endtime` datetime(6) DEFAULT NULL COMMENT '下载结束时间',
  `down_YNsuccess` int(3) DEFAULT NULL COMMENT '下载是否成功，成功为1，失败为0',
  PRIMARY KEY (`down_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `down_information` */

insert  into `down_information`(`down_id`,`down_url`,`down_filename`,`down_savapath`,`down_size`,`down_strattime`,`down_endtime`,`down_YNsuccess`) values 
(1,'1','1','1','1111','2021-11-19 16:21:47.000000','2021-11-05 16:21:53.000000',1),
(2,'2','2','2','2222','2021-11-24 14:56:54.000000','2021-11-23 14:57:00.000000',0),
(3,'3','3','3','3333','2021-11-06 14:57:28.000000','2021-11-06 14:57:31.000000',1),
(4,'https://127.0.0.1','呜呜呜.exe','D://1','12221','2021-11-06 20:55:12.781000','2021-11-06 20:55:12.781000',1),
(5,'https://dldir1.qq.com/qqtv/TencentVideo11.26.5008.0.exe','tx5.exe','D://1','71502088','2021-11-07 15:18:06.387000','2021-11-07 15:18:47.126000',1),
(6,'https://www.baidu.com','1.html','D://1','277','2021-11-08 17:11:55.109000','2021-11-08 17:11:56.193000',1),
(7,'https://www.baidu.com','3.html','D://1','277','2021-11-08 17:11:59.308000','2021-11-08 17:12:00.137000',1),
(8,'https://www.baidu.com','1.html','D://1','277','2021-11-08 17:12:04.298000','2021-11-08 17:12:05.069000',1),
(9,'https://www.baidu.com','3.html','D://1','277','2021-11-08 17:12:09.312000','2021-11-08 17:12:10.168000',1),
(13,'https://www.baidu.com','3.html','D://1','277','2021-11-08 17:51:44.602000','2021-11-08 17:51:45.608000',1),
(14,'https://www.baidu.com','1.html','D://1','277','2021-11-08 22:18:11.708000','2021-11-08 22:18:13.179000',1),
(15,'https://www.baidu.com','3.html','D://1','277','2021-11-08 22:18:15.818000','2021-11-08 22:18:16.929000',1),
(16,'https://www.baidu.com','1.html','D://1','277','2021-11-12 18:31:08.595000','2021-11-12 18:31:09.575000',1),
(17,'https://www.baidu.com','1.html','D://1','277','2021-11-12 18:31:12.604000','2021-11-12 18:31:14.662000',1),
(18,'https://www.baidu.com','1.html','D://1','277','2021-11-12 18:31:17.610000','2021-11-12 18:31:19.545000',1),
(19,'https://www.baidu.com','1','D://1','277','2021-11-12 18:31:22.614000','2021-11-12 18:31:23.771000',1),
(20,'https://www.baidu.com','1.html','D://1','277','2021-11-12 18:36:25.008000','2021-11-12 18:36:25.882000',1),
(21,'https://www.baidu.com','3.html','D://1','277','2021-11-12 18:36:29.926000','2021-11-12 18:36:30.847000',1),
(22,'https://www.baidu.com','1.html','D://1','277','2021-11-12 18:36:34.940000',NULL,0),
(23,'https://www.baidu.com','1.html','D://1','277','2021-11-12 18:39:47.787000','2021-11-12 18:39:49.099000',1),
(24,'https://www.baidu.com','3.html','D://1','277','2021-11-12 18:39:51.870000','2021-11-12 18:39:52.991000',1),
(25,'https://www.baidu.com','1.html','D://1','277','2021-11-12 18:39:53.516000','2021-11-12 18:39:54.361000',1),
(26,'https://www.baidu.com','1.html','D://1','277','2021-11-12 18:39:56.874000','2021-11-12 18:39:57.677000',1),
(27,'https://www.baidu.com','1.html','D://1','277','2021-11-12 18:41:42.587000','2021-11-12 18:41:43.916000',1),
(28,'https://www.baidu.com','3.html','D://1','277','2021-11-12 18:41:46.725000','2021-11-12 18:41:47.620000',1),
(29,'https://www.baidu.com','1.html','D://1','277','2021-11-12 18:41:51.738000','2021-11-12 18:41:52.665000',1),
(30,'https://www.baidu.com','3.html','D://1','277','2021-11-12 18:41:56.743000','2021-11-12 18:41:57.473000',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
