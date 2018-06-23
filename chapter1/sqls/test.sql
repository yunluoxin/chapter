/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 23/06/2018 23:30:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `ibsn` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `author_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of t_book
-- ----------------------------
BEGIN;
INSERT INTO `t_book` VALUES (1, '哈利波特', 1, 50.00, NULL, '未知', '珍藏版');
INSERT INTO `t_book` VALUES (2, '百年孤独', 1, 15.00, NULL, '未知', '好书');
COMMIT;

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_car
-- ----------------------------
BEGIN;
INSERT INTO `t_car` VALUES (1, '宝马', 10000, '这是一个宝马呀！');
INSERT INTO `t_car` VALUES (2, '宝马X5', 150000, '非常高档的车子');
COMMIT;

-- ----------------------------
-- Table structure for t_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `login_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `ip` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `login_date` datetime DEFAULT NULL,
  PRIMARY KEY (`login_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_login_log
-- ----------------------------
BEGIN;
INSERT INTO `t_login_log` VALUES (1, 1, '0:0:0:0:0:0:0:1', '2018-06-23 14:30:03');
INSERT INTO `t_login_log` VALUES (2, 1, '0:0:0:0:0:0:0:1', '2018-06-23 14:38:42');
INSERT INTO `t_login_log` VALUES (3, 1, '0:0:0:0:0:0:0:1', '2018-06-23 14:39:20');
INSERT INTO `t_login_log` VALUES (4, 1, '0:0:0:0:0:0:0:1', '2018-06-23 14:39:23');
INSERT INTO `t_login_log` VALUES (5, 1, '0:0:0:0:0:0:0:1', '2018-06-23 15:09:19');
INSERT INTO `t_login_log` VALUES (6, 1, '0:0:0:0:0:0:0:1', '2018-06-23 15:13:17');
INSERT INTO `t_login_log` VALUES (7, 1, '0:0:0:0:0:0:0:1', '2018-06-23 15:13:32');
INSERT INTO `t_login_log` VALUES (8, 1, '0:0:0:0:0:0:0:1', '2018-06-23 16:05:44');
INSERT INTO `t_login_log` VALUES (9, 1, '0:0:0:0:0:0:0:1', '2018-06-23 23:14:42');
INSERT INTO `t_login_log` VALUES (10, 1, '0:0:0:0:0:0:0:1', '2018-06-23 23:17:57');
INSERT INTO `t_login_log` VALUES (11, 1, '0:0:0:0:0:0:0:1', '2018-06-23 23:24:14');
INSERT INTO `t_login_log` VALUES (12, 1, '0:0:0:0:0:0:0:1', '2018-06-23 23:28:02');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `last_visit` datetime DEFAULT NULL,
  `last_ip` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'root', '123456', '2018-06-23 23:28:02', '0:0:0:0:0:0:0:1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
