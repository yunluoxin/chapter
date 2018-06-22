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

 Date: 06/22/2018 14:35:20 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `t_login_log`
-- ----------------------------
BEGIN;
INSERT INTO `t_login_log` VALUES ('1', '1', '0:0:0:0:0:0:0:1', '2018-06-22 11:59:03'), ('2', '1', '0:0:0:0:0:0:0:1', '2018-06-22 12:02:48'), ('3', '1', '0:0:0:0:0:0:0:1', '2018-06-22 14:14:39'), ('4', '1', '0:0:0:0:0:0:0:1', '2018-06-22 14:16:04');
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
INSERT INTO `t_user` VALUES ('1', 'root', '123456', '2018-06-22 14:16:04', '0:0:0:0:0:0:0:1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
