/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80036 (8.0.36)
 Source Host           : localhost:3306
 Source Schema         : qx_club

 Target Server Type    : MySQL
 Target Server Version : 80036 (8.0.36)
 File Encoding         : 65001

 Date: 22/03/2024 10:40:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for subject_brief
-- ----------------------------
DROP TABLE IF EXISTS `subject_brief`;
CREATE TABLE `subject_brief`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` int NULL DEFAULT NULL COMMENT '题目id',
  `subject_answer` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '题目答案',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '简答题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_brief
-- ----------------------------

-- ----------------------------
-- Table structure for subject_category
-- ----------------------------
DROP TABLE IF EXISTS `subject_category`;
CREATE TABLE `subject_category`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_name` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `category_type` tinyint NULL DEFAULT NULL COMMENT '分类类型',
  `category_icon` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图标连接',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父级id',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除 0: 未删除 1: 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '题目分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_category
-- ----------------------------
INSERT INTO `subject_category` VALUES (1, '前端', 1, 'http://localhost:8081/image', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_category` VALUES (2, '后端', 1, 'http://localhost:8081/image', NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_info
-- ----------------------------
DROP TABLE IF EXISTS `subject_info`;
CREATE TABLE `subject_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '题目名称',
  `subject_difficulty` tinyint NULL DEFAULT NULL COMMENT '题目难度',
  `settle_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '出题人名',
  `subject_type` tinyint NULL DEFAULT NULL COMMENT '题目类型 1单选 2多选 3判断 4简答',
  `subject_score` tinyint NULL DEFAULT NULL COMMENT '题目分数',
  `subject_parse` varchar(512) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '题目解析',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `updated_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '题目信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_info
-- ----------------------------
INSERT INTO `subject_info` VALUES (85, 'java高并发如何设计？', 1, NULL, 1, 10, '题目解析', NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_judge
-- ----------------------------
DROP TABLE IF EXISTS `subject_judge`;
CREATE TABLE `subject_judge`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `is_correct` tinyint NULL DEFAULT NULL COMMENT '是否正确',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '判断题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_judge
-- ----------------------------

-- ----------------------------
-- Table structure for subject_label
-- ----------------------------
DROP TABLE IF EXISTS `subject_label`;
CREATE TABLE `subject_label`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `label_name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标签分类',
  `sort_num` int NULL DEFAULT NULL COMMENT '排序',
  `category_id` bigint NULL DEFAULT NULL,
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '题目标签表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_label
-- ----------------------------
INSERT INTO `subject_label` VALUES (33, 'Angular', NULL, 2, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `subject_label` VALUES (34, 'Spring Boot', NULL, 2, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for subject_mapping
-- ----------------------------
DROP TABLE IF EXISTS `subject_mapping`;
CREATE TABLE `subject_mapping`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `category_id` bigint NULL DEFAULT NULL COMMENT '分类id',
  `label_id` bigint NULL DEFAULT NULL COMMENT '标签id',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `updated_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 178 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '题目分类关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_mapping
-- ----------------------------
INSERT INTO `subject_mapping` VALUES (174, 85, 4, 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (175, 85, 4, 9, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (176, 85, 3, 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_mapping` VALUES (177, 85, 3, 9, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for subject_multiple
-- ----------------------------
DROP TABLE IF EXISTS `subject_multiple`;
CREATE TABLE `subject_multiple`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `option_type` bigint NULL DEFAULT NULL COMMENT '选项类型',
  `option_content` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '选项内容',
  `is_correct` tinyint NULL DEFAULT NULL COMMENT '是否正确',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '多选题信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_multiple
-- ----------------------------

-- ----------------------------
-- Table structure for subject_radio
-- ----------------------------
DROP TABLE IF EXISTS `subject_radio`;
CREATE TABLE `subject_radio`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `subject_id` bigint NULL DEFAULT NULL COMMENT '题目id',
  `option_type` tinyint NULL DEFAULT NULL COMMENT 'a,b,c,d',
  `option_content` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '选项内容',
  `is_correct` tinyint NULL DEFAULT NULL COMMENT '是否正确',
  `created_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `updated_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_deleted` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '单选题信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject_radio
-- ----------------------------
INSERT INTO `subject_radio` VALUES (35, 85, 1, '凉拌', 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `subject_radio` VALUES (36, 85, 2, '热炒', 0, NULL, NULL, NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
