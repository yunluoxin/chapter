/*
 Navicat Premium Data Transfer

 Source Server         : local_test
 Source Server Type    : MySQL
 Source Server Version : 50638
 Source Host           : 192.168.0.222
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50638
 File Encoding         : utf-8

 Date: 06/23/2018 16:56:33 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_car`
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `t_car`
-- ----------------------------
BEGIN;
INSERT INTO `t_car` VALUES ('1', '宝马', '10000', '这是一个宝马呀！'), ('2', '宝马X5', '150000', '非常高档的车子');
COMMIT;

-- ----------------------------
--  Table structure for `t_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `login_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `ip` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `login_date` datetime DEFAULT NULL,
  PRIMARY KEY (`login_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `t_login_log`
-- ----------------------------
BEGIN;
INSERT INTO `t_login_log` VALUES ('1', '1', '0:0:0:0:0:0:0:1', '2018-06-23 14:30:03'), ('2', '1', '0:0:0:0:0:0:0:1', '2018-06-23 14:38:42'), ('3', '1', '0:0:0:0:0:0:0:1', '2018-06-23 14:39:20'), ('4', '1', '0:0:0:0:0:0:0:1', '2018-06-23 14:39:23'), ('5', '1', '0:0:0:0:0:0:0:1', '2018-06-23 15:09:19'), ('6', '1', '0:0:0:0:0:0:0:1', '2018-06-23 15:13:17'), ('7', '1', '0:0:0:0:0:0:0:1', '2018-06-23 15:13:32'), ('8', '1', '0:0:0:0:0:0:0:1', '2018-06-23 16:05:44');
COMMIT;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `last_visit` datetime DEFAULT NULL,
  `last_ip` varchar(36) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('1', 'root', '123456', '2018-06-23 16:05:44', '0:0:0:0:0:0:0:1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
