/*
Navicat MySQL Data Transfer

Source Server         : ddc
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : ddc

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-06-21 15:30:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ddc_programa`
-- ----------------------------
DROP TABLE IF EXISTS `ddc_programa`;
CREATE TABLE `ddc_programa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '栏目名称',
  `type` varchar(10) NOT NULL COMMENT '内容',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `delete_flag` tinyint(2) NOT NULL DEFAULT '0' COMMENT '删除标志 0 未删除 1 已删除 默认 0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ddc_programa
-- ----------------------------
INSERT INTO `ddc_programa` VALUES ('3', '栏目0', '图片', '0', '1561083684312', '1139946923277545474', '1561089025138', '0');
INSERT INTO `ddc_programa` VALUES ('4', '1111111', '图片', '0', '1561083685414', '1139946923277545474', '1561089038698', '0');
INSERT INTO `ddc_programa` VALUES ('5', '栏目2', '文章', '0', '1561083685587', '0', '1561083685587', '0');
INSERT INTO `ddc_programa` VALUES ('6', '栏目3', '文章', '0', '1561083685670', '0', '1561083685670', '0');
INSERT INTO `ddc_programa` VALUES ('7', '栏目4', '文章', '0', '1561083685840', '0', '1561083685840', '0');
INSERT INTO `ddc_programa` VALUES ('8', '栏目5', '文章', '0', '1561083686098', '0', '1561083686098', '0');
INSERT INTO `ddc_programa` VALUES ('9', '栏目6', '文章', '0', '1561083686203', '0', '1561083686203', '0');
INSERT INTO `ddc_programa` VALUES ('10', '栏目7', '文章', '0', '1561083686358', '0', '1561083686358', '0');
INSERT INTO `ddc_programa` VALUES ('11', '栏目8', '文章', '0', '1561083686465', '0', '1561083686465', '0');
INSERT INTO `ddc_programa` VALUES ('12', '栏目9', '文章', '0', '1561083686534', '0', '1561083686534', '0');
INSERT INTO `ddc_programa` VALUES ('13', '栏目10', '文章', '0', '1561083686917', '0', '1561083686917', '0');
INSERT INTO `ddc_programa` VALUES ('14', '栏目11', '文章', '0', '1561083686996', '0', '1561083686996', '0');
INSERT INTO `ddc_programa` VALUES ('15', '栏目12', '文章', '0', '1561083687165', '0', '1561083687165', '0');
INSERT INTO `ddc_programa` VALUES ('16', '栏目13', '文章', '0', '1561083687260', '0', '1561083687260', '0');
INSERT INTO `ddc_programa` VALUES ('17', '栏目14', '文章', '0', '1561083687331', '0', '1561083687331', '0');
INSERT INTO `ddc_programa` VALUES ('18', '栏目15', '文章', '0', '1561083687429', '0', '1561083687429', '0');
INSERT INTO `ddc_programa` VALUES ('19', '栏目16', '文章', '0', '1561083687552', '0', '1561083687552', '0');
INSERT INTO `ddc_programa` VALUES ('20', '栏目17', '文章', '0', '1561083687630', '0', '1561083687630', '0');
INSERT INTO `ddc_programa` VALUES ('21', '栏目18', '文章', '0', '1561083687857', '0', '1561083687857', '0');
INSERT INTO `ddc_programa` VALUES ('22', '栏目19', '文章', '0', '1561083687965', '0', '1561083687965', '0');
INSERT INTO `ddc_programa` VALUES ('23', '栏目20', '文章', '0', '1561083688088', '1139946923277545474', '1561087285457', '0');
INSERT INTO `ddc_programa` VALUES ('29', 'test1', '图片', null, null, null, null, '0');
