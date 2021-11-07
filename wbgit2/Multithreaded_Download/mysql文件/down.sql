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
  `down_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '下载id，自动增加',
  `down_url` varchar(60) DEFAULT NULL COMMENT '下载链接',
  `down_filename` varchar(32) DEFAULT NULL COMMENT '文件名',
  `down_savapath` varchar(60) DEFAULT NULL COMMENT '保存路径',
  `down_size` varchar(32) DEFAULT NULL COMMENT '文件大小',
  `down_strattime` datetime(6) DEFAULT NULL COMMENT '下载开始时间',
  `down_endtime` datetime(6) DEFAULT NULL COMMENT '下载结束时间',
  `down_YNsuccess` int(3) DEFAULT NULL COMMENT '下载是否成功，成功为1，失败为0',
  PRIMARY KEY (`down_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `down_information` */

insert  into `down_information`(`down_id`,`down_url`,`down_filename`,`down_savapath`,`down_size`,`down_strattime`,`down_endtime`,`down_YNsuccess`) values 
(1,'1','1','1','1111','2021-11-19 16:21:47.000000','2021-11-05 16:21:53.000000',1),
(2,'2','2','2','2222','2021-11-24 14:56:54.000000','2021-11-23 14:57:00.000000',0),
(3,'3','3','3','3333','2021-11-06 14:57:28.000000','2021-11-06 14:57:31.000000',1),
(4,'https://127.0.0.1','呜呜呜.exe','D://1','12221','2021-11-06 20:55:12.781000','2021-11-06 20:55:12.781000',1),
(5,'https://127.0.0.1:8080','呜呜呜1.exe','D://2','55555555','2021-11-06 21:38:33.742000','2021-11-06 21:38:33.742000',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
