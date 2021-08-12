/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 12/08/2021 20:13:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_at` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'test1', 'a', '男', '2021-08-12 14:12:26');
INSERT INTO `user` VALUES (3, 'test3', 'a', '男', '2021-08-12 14:16:34');
INSERT INTO `user` VALUES (4, 'test2', 'a', '男', '2021-08-12 14:16:40');
INSERT INTO `user` VALUES (7, 'test10', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (8, 'test11', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (9, 'test12', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (10, 'test13', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (11, 'test14', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (12, 'test15', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (13, 'test16', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (14, 'test17', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (15, 'test18', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (16, 'test19', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (17, 'test20', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (18, 'test21', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (19, 'test22', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (20, 'test23', 'a', '男', '2021-08-12 15:06:29');
INSERT INTO `user` VALUES (21, 'user', 'aaa', '女', '2021-08-12 16:58:39');

SET FOREIGN_KEY_CHECKS = 1;
