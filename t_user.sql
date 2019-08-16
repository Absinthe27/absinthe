/*
Navicat MySQL Data Transfer

Source Server         : 阿里云
Source Server Version : 50725
Source Host           : rm-2ze5m0e59ddm2a47vko.mysql.rds.aliyuncs.com:3306
Source Database       : db_springboot_forum

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-08-16 11:50:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `activated` tinyint(1) NOT NULL DEFAULT '1',
  `date_created` datetime NOT NULL,
  `avatar_location` varchar(255) DEFAULT 'avatar/default_avatar.png',
  `bio` varchar(255) DEFAULT NULL,
  `roles` varchar(255) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '$2a$10$HiaJpKERbSfcZcuG5vcvlOZDG6Y/5SkDKi9RvKsSK3t3Spl9.7u6u', 'admin@admin.com', '1', '2017-11-02 00:00:00', 'avatar/default_avatar.png', 'admin bio', 'ADMIN,USER', 'admin');
INSERT INTO `t_user` VALUES ('2', 'user', '$2a$10$Dr2lvPjmjiMuWf3mcMlyQeSbxFHI5LDLudHIB/fK/uygI1pnKk/3m', 'user@user.com', '1', '2017-11-02 00:00:00', 'avatar/default_avatar.png', 'user bio', 'USER', 'user');
INSERT INTO `t_user` VALUES ('5', ' test', '$2a$10$/ZWZdsqDweqEmUCZHaSU0O7.ODXi4GgxOYGOqbyyy1/HX94KiJGEi', 'ssss', '1', '2019-07-27 10:58:10', 'test', 'user bio', 'USER', ' test');
INSERT INTO `t_user` VALUES ('6', 'test1', '$2a$10$EpHpWXn7Srs8DmjcYWEeYuTv/LW6HPLERjQ1QwbHkEDKZ3L5Szr02', '948790393@qq.com', '1', '2019-07-27 11:06:06', 'test1', 'user bio', 'USER', 'test1');
INSERT INTO `t_user` VALUES ('7', 'xude', '$2a$10$akWfRfo/Ti8lhR9jJ/7br.8hrACie2OTG0n2J6Kg7Btwtjev7gmaq', '948790393@qq.com', '1', '2019-07-27 11:06:43', 'avatar/xude/xude.png', '啦啦啦啦啦啦', 'USER', '苦艾酒');
INSERT INTO `t_user` VALUES ('9', 'test2', '$2a$10$qaPbK8fjdGEQ3CncEtXbYeTae6g2.nGkCpoTQXdjq57SUAkQljZFu', 'test2@11', '1', '2019-07-28 17:56:24', 'test2', 'user bio', 'USER', 'test2');
INSERT INTO `t_user` VALUES ('10', 'xude1', '$2a$10$kUvmWnrOciAwKlbeGFpx.e1elmI0tmLZbnqwQxbpLQ/ENd1eF//kC', 'ads@www', '1', '2019-07-29 16:01:53', 'xude1', 'user bio', 'USER', 'xude1');
INSERT INTO `t_user` VALUES ('11', 'xude11', '$2a$10$yUP3YSOs6RIjnoDbKRlrO.Mf3DOVKrsSFqvfNIzJ/YAX8p3r4SWCS', 'dfsffd', '1', '2019-07-29 16:02:23', 'ttt', 'user bio', 'USER', 'xude11');
INSERT INTO `t_user` VALUES ('15', 'xude12', '$2a$10$rG/KxZa9zLNTgBnA.vp7De8xKCDLtwY36PnL30zmcvEB3JDnjFK7u', 'qq@qqq', '1', '2019-08-01 17:01:53', '1234', 'user bio', 'USER', 'xude12');
INSERT INTO `t_user` VALUES ('16', 'ahahaha', '$2a$10$gv9A54.bcdpQpUggUid0SuwEpa11Gnfvgzzh3O2ZbBzdnXmD6hgUq', '6417105690@qq.com', '1', '2019-08-03 23:57:14', 'images/avatar/xude/zz.png', 'user bio', 'USER', 'ahahaha');
INSERT INTO `t_user` VALUES ('17', 'youyouran', '$2a$10$Vx9ALRYHaqT1VZIb7nMZ4.9VeCqfUHZEg531gtwI/vsZqpyNq2ebe', '6417105690@qq.com', '1', '2019-08-04 00:02:58', 'images/avatar/xude/zz.png', 'user bio', 'USER', 'youyouran');
INSERT INTO `t_user` VALUES ('18', 'baekhyun', '$2a$10$QSV93VCdAYEP60031/hQtO9GNyyTAvg/N3BA6ivKgEfLsSQ7V/rvC', '1475972421@qq.com', '1', '2019-08-04 00:26:24', 'avatar/baekhyun/a1.png', 'user bio', 'USER', 'baekhyun');
INSERT INTO `t_user` VALUES ('19', '123456', '$2a$10$1dcmyTtTgauKI2eu5EdGYO75JlIaFtqB8WirsePcv4Zd6KqIlbzBm', '1073344346@qq.com', '1', '2019-08-07 11:23:53', 'images/avatar/xude/zz.png', 'user bio', 'USER', '123456');
INSERT INTO `t_user` VALUES ('20', 'iris', '$2a$10$B2Z8OZ6l7TXJhG8bN3gVUePLdt/k5Rvzju3PIaJ50.4HaJuc9kjv.', '2289947097@qq.com ', '1', '2019-08-07 15:23:19', 'images/avatar/xude/zz.png', 'user bio', 'USER', 'Soek Jin ');
INSERT INTO `t_user` VALUES ('21', '曜灵3', '$2a$10$DSpqAEUed.udia63SeqfROCt3I3ohzAg33zjYQbWBLgZPZU6o8/4a', '1372582254@qq.com', '1', '2019-08-08 01:26:14', 'avatar/曜灵3/E7C85EC9-7FB0-46AB-AB46-54B27EB36570.jpeg', 'user bio', 'USER', '曜灵33');
INSERT INTO `t_user` VALUES ('22', '二狗子', '$2a$10$jZb8Hh9DZLq2PGJpE8H7fex4CvtYajAHFyj3FbFt.EJNv9Rrpi3C6', '331696493@qq.com', '1', '2019-08-08 09:50:02', 'avatar/二狗子/photo1.png', 'user bio', 'USER', '二狗子');
INSERT INTO `t_user` VALUES ('23', '测试123', '$2a$10$C0FH6BlSwH/Vak9PWWMFg.DnutAfiyDAcjjqFrI6SsyGPUNFVkEJu', '905444854@qq.com', '1', '2019-08-08 16:30:16', 'images/avatar/xude/zz.png', 'user bio', 'USER', 'java');
INSERT INTO `t_user` VALUES ('24', 'XBZS', '$2a$10$/bcG1Y87WoIhK80mpXh6KedQ9yI7rn9W3p58aFDuIWWS2FD.ESxbi', '13051065663@163.com', '1', '2019-08-09 15:49:23', 'avatar/XBZS/微信图片_20190815163056.jpg', '小白最帅', 'USER', '三胖');
INSERT INTO `t_user` VALUES ('25', '我是大哥', '$2a$10$qNIbfJeSgrUEgPljy9M7IewOQOjb5lML9e3C2OMs1WLMFWKtjjCeW', '459656538@qq.com', '1', '2019-08-12 17:31:39', 'images/avatar/xude/zz.png', 'user bio', 'USER', '叫我大哥');
INSERT INTO `t_user` VALUES ('26', 'black', '$2a$10$OMyIdv.ZictyRJ.wphji8Oq2Nf7qovwqfYygvfcIAuwKzZ9Xoyz1i', '1490334821@qq.com', '1', '2019-08-12 17:59:33', 'images/avatar/xude/zz.png', 'user bio', 'USER', 'black');
INSERT INTO `t_user` VALUES ('27', 'keyBan', '$2a$10$W.aUxhkaUVINKDuJmIBjL.G7ZWYvTrfxI.vHvIpuJZzGW47NECm2q', '307316817@qq.com', '1', '2019-08-13 13:08:45', 'images/avatar/xude/zz.png', 'user bio', 'USER', 'keyBan');
INSERT INTO `t_user` VALUES ('28', 'abandon', '$2a$10$qD88UbLGXdtIH5UBbBy8xOe2jKbo6adChy7SXp1Limp2tWKgbZsW2', '991715938', '1', '2019-08-13 13:10:40', 'images/avatar/xude/zz.png', 'user bio', 'USER', 'abandon');
INSERT INTO `t_user` VALUES ('29', 'nick', '$2a$10$H0U4cjGSaqWr7yWZwzkB4eruhgUQykDQMuVG41iCHblERKGtFCebO', '', '1', '2019-08-13 13:15:18', 'images/avatar/xude/zz.png', 'user bio', 'USER', '');
INSERT INTO `t_user` VALUES ('30', '叔本轻狂', '$2a$10$pjv2M6/Wkl10KpTItpPI8.3U2X44otzObUxXZDNIrLDGIn/3eC0..', '370161069@qq.com', '1', '2019-08-14 10:31:49', 'images/avatar/xude/zz.png', 'user bio', 'USER', '叔本轻狂');
INSERT INTO `t_user` VALUES ('31', '十斤橙', '$2a$10$WbCcGSOllDoP9nw8Ftf4F.Ftf8s4TkEkyjCA4/XToy4VlypD3BrFu', 'bqshijincheng@126.com', '1', '2019-08-14 17:16:54', 'images/avatar/xude/zz.png', 'user bio', 'USER', 'Jincheng Shi');
INSERT INTO `t_user` VALUES ('32', '会催眠的大白兔', '$2a$10$AoEZO9TFW1dE/UThb.EFLuxfjy5bWuCy6bwhCvObucjHBjjjDhC4u', '123453789@qq.com', '1', '2019-08-15 15:57:24', 'avatar/会催眠的大白兔/就.jpg', 'user bio', 'USER', '会催眠的大白兔');
INSERT INTO `t_user` VALUES ('33', '许德同事小刘', '$2a$10$voYMCS2wZkS1IRRtjQY4de76CHh/e.dAbTO.50brEYwcLLgMikR/W', '905444854@qq.com', '1', '2019-08-15 17:15:49', 'avatar/许德同事小刘/u=231310784,464435296&fm=26&gp=0.jpg', 'user bio', 'USER', 'helloword');
INSERT INTO `t_user` VALUES ('34', 'liiga', '$2a$10$2AaUQWphTYXPOgf5VQFfD.1uycOPGLkrf4eG/Y0do7XIcmbAo7RvO', '907351491@qq.com', '1', '2019-08-16 10:33:21', 'avatar/liiga/3CD67BEC-0EDC-4A20-926F-5212592F3741.jpeg', '算个好人', 'USER', '奈奈酱');
