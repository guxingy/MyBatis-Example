/*
Navicat MySQL Data Transfer

Source Server         : localhost1
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-08-06 11:41:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '测试1', '男', '2020-08-06', '重庆');
INSERT INTO `user` VALUES ('2', '测试2', '女', '2020-08-01', '上海');
INSERT INTO `user` VALUES ('4', '小强', '男', '2020-08-06', '广州');
