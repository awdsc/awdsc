-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.9.2-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- cartoon_gall 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `cartoon_gall` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `cartoon_gall`;

-- 테이블 cartoon_gall.gall_board 구조 내보내기
CREATE TABLE IF NOT EXISTS `gall_board` (
  `gall_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '식별',
  `writer` int(11) NOT NULL DEFAULT 0 COMMENT '작성자',
  `title` varchar(1000) NOT NULL DEFAULT '0' COMMENT '제목',
  `content` varchar(9999) NOT NULL DEFAULT '0' COMMENT '내용',
  `readcount` int(11) NOT NULL DEFAULT 0 COMMENT '조회수',
  `redDate` date NOT NULL COMMENT '생성일',
  `filename` varchar(3000) NOT NULL COMMENT '파일',
  `recommendation_count` int(11) NOT NULL DEFAULT 0 COMMENT '추천수',
  `elimination` tinyint(4) NOT NULL DEFAULT 0 COMMENT '삭제여부(기본:0)',
  PRIMARY KEY (`gall_number`),
  KEY `mem_to_bo` (`writer`),
  CONSTRAINT `mem_to_bo` FOREIGN KEY (`writer`) REFERENCES `member` (`member_code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 cartoon_gall.gall_coment 구조 내보내기
CREATE TABLE IF NOT EXISTS `gall_coment` (
  `board_no` int(11) DEFAULT NULL COMMENT '작성게시판',
  `coment_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '댓글식별',
  `writer` int(11) NOT NULL DEFAULT 0 COMMENT '작성자',
  `content` varchar(1000) NOT NULL DEFAULT '0' COMMENT '내용',
  `redDate` date NOT NULL COMMENT '생성일',
  PRIMARY KEY (`coment_no`),
  KEY `mem_to_co` (`writer`),
  KEY `board_to_co` (`board_no`),
  CONSTRAINT `board_to_co` FOREIGN KEY (`board_no`) REFERENCES `gall_board` (`gall_number`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mem_to_co` FOREIGN KEY (`writer`) REFERENCES `member` (`member_code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 cartoon_gall.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `member_code` int(11) NOT NULL AUTO_INCREMENT,
  `mem_id` varchar(1000) NOT NULL DEFAULT '0',
  `mem_pass` varchar(1000) NOT NULL DEFAULT '0',
  PRIMARY KEY (`member_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
