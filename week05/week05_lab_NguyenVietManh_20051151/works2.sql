-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.3.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for works2
CREATE DATABASE IF NOT EXISTS `works2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `works2`;

-- Dumping structure for table works2.account
CREATE TABLE IF NOT EXISTS `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `candidate_id` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKgex1lmaqpg0ir5g1f5eftyaa1` (`username`),
  UNIQUE KEY `UKms0j4guy1pgji4pknw2x3oas2` (`candidate_id`),
  UNIQUE KEY `UKpg8nkk2jq7i0q6rq8wlp8y3t3` (`company_id`),
  KEY `FKd4vb66o896tay3yy52oqxr9w0` (`role_id`),
  CONSTRAINT `FKcjammba6x61w5fb3gkwftqg86` FOREIGN KEY (`candidate_id`) REFERENCES `candidate` (`id`),
  CONSTRAINT `FKd4vb66o896tay3yy52oqxr9w0` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKyx9qhair86pc6tnbh322xjg4` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table works2.account: ~3 rows (approximately)
REPLACE INTO `account` (`id`, `password`, `username`, `candidate_id`, `company_id`, `role_id`) VALUES
	(1, '9', 'admin', NULL, 1, NULL),
	(2, '123', 'admin2', NULL, 2, NULL),
	(3, '9', 'admin3', 1, NULL, NULL),
	(6, '123456', 'admin4', 7, NULL, NULL),
	(7, '123456', 'admin5', 8, NULL, NULL),
	(8, '123456', 'admin6', NULL, 3, NULL);

-- Dumping structure for table works2.address
CREATE TABLE IF NOT EXISTS `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` enum('AC','AD','AE','AF','AG','AI','AL','AM','AN','AO','AQ','AR','AS','AT','AU','AW','AX','AZ','BA','BB','BD','BE','BF','BG','BH','BI','BJ','BL','BM','BN','BO','BQ','BR','BS','BT','BU','BV','BW','BY','BZ','CA','CC','CD','CF','CG','CH','CI','CK','CL','CM','CN','CO','CP','CR','CS','CU','CV','CW','CX','CY','CZ','DE','DG','DJ','DK','DM','DO','DZ','EA','EC','EE','EG','EH','ER','ES','ET','EU','EZ','FI','FJ','FK','FM','FO','FR','FX','GA','GB','GD','GE','GF','GG','GH','GI','GL','GM','GN','GP','GQ','GR','GS','GT','GU','GW','GY','HK','HM','HN','HR','HT','HU','IC','ID','IE','IL','IM','IN','IO','IQ','IR','IS','IT','JE','JM','JO','JP','KE','KG','KH','KI','KM','KN','KP','KR','KW','KY','KZ','LA','LB','LC','LI','LK','LR','LS','LT','LU','LV','LY','MA','MC','MD','ME','MF','MG','MH','MK','ML','MM','MN','MO','MP','MQ','MR','MS','MT','MU','MV','MW','MX','MY','MZ','NA','NC','NE','NF','NG','NI','NL','NO','NP','NR','NT','NU','NZ','OM','PA','PE','PF','PG','PH','PK','PL','PM','PN','PR','PS','PT','PW','PY','QA','RE','RO','RS','RU','RW','SA','SB','SC','SD','SE','SF','SG','SH','SI','SJ','SK','SL','SM','SN','SO','SR','SS','ST','SU','SV','SX','SY','SZ','TA','TC','TD','TF','TG','TH','TJ','TK','TL','TM','TN','TO','TP','TR','TT','TV','TW','TZ','UA','UG','UK','UM','UNDEFINED','US','UY','UZ','VA','VC','VE','VG','VI','VN','VU','WF','WS','XI','XK','XU','YE','YT','YU','ZA','ZM','ZR','ZW') DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table works2.address: ~0 rows (approximately)

-- Dumping structure for table works2.candidate
CREATE TABLE IF NOT EXISTS `candidate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dob` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKqfut8ruekode092nlkipgl09g` (`email`),
  UNIQUE KEY `UK9i5yt1gvm0chg5e10qkns7tll` (`phone`),
  KEY `FKa8gnyyhbb2qnhp94grci1n0o9` (`address`),
  CONSTRAINT `FKa8gnyyhbb2qnhp94grci1n0o9` FOREIGN KEY (`address`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table works2.candidate: ~4 rows (approximately)
REPLACE INTO `candidate` (`id`, `dob`, `email`, `full_name`, `phone`, `address`) VALUES
	(1, '2000-11-16', 'nguyenvietmanh1409@gmail.com', 'Nguyễn Viết Mạnh 2', 'qqq', NULL),
	(2, '2024-11-15', 'nguyenvietmanh14092@gmail.com', 'Nguyen Van A', '0375000169', NULL),
	(7, '2000-10-10', 'nguyenvietmanh14094@gmail.com', 'Thanh huy', '0375000164', NULL),
	(8, '2000-10-10', 'nguyenvietmanh14095@gmail.com', 'Thanh huy', '0375000165', NULL);

-- Dumping structure for table works2.candidate_skill
CREATE TABLE IF NOT EXISTS `candidate_skill` (
  `can_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  KEY `FKb7cxhiqhcah7c20a2cdlvr1f8` (`skill_id`),
  KEY `FKb0m5tm3fi0upa3b3kjx3vrlxs` (`can_id`),
  CONSTRAINT `FKb0m5tm3fi0upa3b3kjx3vrlxs` FOREIGN KEY (`can_id`) REFERENCES `candidate` (`id`),
  CONSTRAINT `FKb7cxhiqhcah7c20a2cdlvr1f8` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table works2.candidate_skill: ~3 rows (approximately)
REPLACE INTO `candidate_skill` (`can_id`, `skill_id`) VALUES
	(2, 1),
	(2, 3),
	(1, 1),
	(1, 6),
	(1, 7);

-- Dumping structure for table works2.company
CREATE TABLE IF NOT EXISTS `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `about` varchar(255) DEFAULT NULL,
  `comp_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `web_url` varchar(255) DEFAULT NULL,
  `address` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd5occp4cjwihejbxdbpvkp5tv` (`address`),
  CONSTRAINT `FKd5occp4cjwihejbxdbpvkp5tv` FOREIGN KEY (`address`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table works2.company: ~2 rows (approximately)
REPLACE INTO `company` (`id`, `about`, `comp_name`, `email`, `phone`, `web_url`, `address`) VALUES
	(1, '9', '9', '9', '9', '9', NULL),
	(2, 'Company 2 Company 2', 'Company 2', 'nguyenvietmanh14091@gmail.com', '123', '123', NULL),
	(3, 'Company6', 'Company6', 'nguyenvietmanh14096@gmail.com', '0375000166', 'http://localhost:8080/registerCompany', NULL);

-- Dumping structure for table works2.experience
CREATE TABLE IF NOT EXISTS `experience` (
  `exp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `work_desc` varchar(255) DEFAULT NULL,
  `can_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`exp_id`),
  KEY `FK8d5oqe0wxh52v352i04qnuady` (`can_id`),
  CONSTRAINT `FK8d5oqe0wxh52v352i04qnuady` FOREIGN KEY (`can_id`) REFERENCES `candidate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table works2.experience: ~0 rows (approximately)

-- Dumping structure for table works2.job
CREATE TABLE IF NOT EXISTS `job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_desc` varchar(2000) DEFAULT NULL,
  `job_name` varchar(255) DEFAULT NULL,
  `company` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `FKbaqlvluu78phmo9ld89um7wnm` (`company`),
  CONSTRAINT `FKbaqlvluu78phmo9ld89um7wnm` FOREIGN KEY (`company`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table works2.job: ~8 rows (approximately)
REPLACE INTO `job` (`job_id`, `job_desc`, `job_name`, `company`) VALUES
	(2, 'new', 'new', 1),
	(3, '222', 'new', 1),
	(4, '123', 'new2', 2),
	(5, 'java', 'java', 2),
	(6, 'job java nenw ', 'job java', 2),
	(7, 'Mô tả công việc\r\n- Phát triển các công cụ để lưu trữ dữ liệu và theo dõi hiệu suất đầu tư. Tối ưu hiệu suất ghi/đọc của hệ thống cơ sở dữ liệu.\r\n- Xây dựng các kết nối giao dịch với các đơn vị/đối tác cung cấp dữ liệu.\r\n- Hoàn thiện hệ thống Data center, Data Warehouse\r\n- Tìm kiếm các nguồn dữ liệu mới để tăng hiệu quả và độ chính xác của các mô hình.\r\n\r\nYêu cầu ứng viên\r\n+ Đam mê và tham vọng trở thành tên tuổi trong lĩnh vực Quantitative Finance (những tỷ phú công nghệ)\r\n+ Nắm vững kiến thức toán từ lớp 1 đến lớp 12\r\n+ Biết ít nhất 1 ngôn ngữ lập trình hướng đối tượng\r\n+ Đọc hiểu các tài liệu tiếng Anh\r\n+ Điểm cộng: IELTS > 6.0/ TOEIC > 600', 'Data Science Intern', 2),
	(8, 'Mô tả công việc\r\nPhát triển sản phẩm cho xe điện và hệ sinh thái tự động hóa, điều khiển tự động.\r\nThiết kế hệ quản trị cơ sở dữ liệu quản lý thông tin khách hàng, thiết bị\r\nThiết kế hệ thống xử lý dữ liệu IoT sử dụng các công nghệ sql, no-sql, aws, azure, google cloud\r\nPhát triển hệ thống hiệu năng cao đáp ứng lượng truy cập lớn\r\nThực hiện các nhiệm vụ khác khi được phân công\r\nYêu cầu ứng viên\r\nSinh viên năm cuối các chuyên ngành ngành công nghệ thông tin, các ngành có liên quan, còn ít nhất 01 kỳ học hoặc 6 tháng trước khi tốt nghiệp. Đối với các sinh viên không thuộc diện này vẫn có thể nộp đơn tham gia thực tập bình thường ở công ty.\r\nHiểu biết ít nhất 1 trong các ngôn ngữ: Java, Python,NodeJs ...\r\nCó hiểu biết về các database: PostgreSQL, MySQL, MongoDB', 'Thực Tập Sinh Back-End Java', 2),
	(12, 'What you\'re going to do\r\n\r\nIAM Engineer is the new roles that exist in Vietnam market in recent year, where ​you will​ designs, develops, tests, implements, and integrates Identity and Access Management (IAM) systems and solutions. You ensures that solutions protect information resources against unauthorized use, inappropriate degrees of access, disclosure, damage and/or loss.\r\n\r\nAs a Fresh IAM Engineer, you will be trained in IAM concepts and services such as proxy, authentication, identity management, etc.\r\n\r\nIn your daily work, you will learn how to:\r\n\r\nScanning through IAM product\'s documents to understand the software architecture, integration and configuration\r\nSetting up, configuring and integrating software services based on product documents\r\nWriting build tasks using build tool (Ansible, Bash Shell) to automate deployments\r\nUnderstanding public key infrastructure to set up encrypted channels and secure connections\r\nTroubleshooting problems, reading error stack trace, understanding solution configuration and recording issues and technical knowledge\r\nEstimating and managing tasks via a ticketing system\r\nPerforming end-to-end testing; presenting and demonstrating completed tasks or proof of concepts', 'Fresh IAM Engineer (Internship)', 2),
	(13, 'Mô tả công việc\r\nReview and analyze system specifications\r\nCollaborate with QA Engineers to develop effective strategies and test plans\r\nExecute test cases (manual or automated) and analyze results\r\nReport bugs and errors to development teams\r\nHelp troubleshoot issues\r\nWork with cross-functional teams to ensure quality throughout the software development life cycle\r\nYêu cầu ứng viên\r\n3rd & 4th student faculty in Information Technology, Computer Science, Economics or related areas\r\nPreferably with related work experience\r\nDuration: at least 3 months; can work 4-5 days per week\r\nHard-working, supportive as a team player\r\nCareful, proactive, committed to deadline and results-driven\r\nStrong analytical and critical thinking', 'test', 2);

-- Dumping structure for table works2.job_skill
CREATE TABLE IF NOT EXISTS `job_skill` (
  `job_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  KEY `FKj33qbbf3vk1lvhqpcosnh54u1` (`skill_id`),
  KEY `FK9ix4wg520ii2gu2felxdhdup6` (`job_id`),
  CONSTRAINT `FK9ix4wg520ii2gu2felxdhdup6` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  CONSTRAINT `FKj33qbbf3vk1lvhqpcosnh54u1` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table works2.job_skill: ~20 rows (approximately)
REPLACE INTO `job_skill` (`job_id`, `skill_id`) VALUES
	(2, 1),
	(2, 2),
	(3, 1),
	(3, 2),
	(3, 3),
	(4, 1),
	(4, 2),
	(4, 3),
	(4, 4),
	(5, 1),
	(6, 1),
	(12, 3),
	(12, 4),
	(12, 5),
	(12, 6),
	(8, 1),
	(8, 3),
	(8, 7),
	(7, 1),
	(7, 5),
	(13, 1),
	(13, 2),
	(13, 4);

-- Dumping structure for table works2.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table works2.role: ~0 rows (approximately)

-- Dumping structure for table works2.skill
CREATE TABLE IF NOT EXISTS `skill` (
  `skill_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `skill_desc` varchar(255) DEFAULT NULL,
  `skill_name` varchar(255) DEFAULT NULL,
  `skill_type` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table works2.skill: ~8 rows (approximately)
REPLACE INTO `skill` (`skill_id`, `skill_desc`, `skill_name`, `skill_type`) VALUES
	(1, 'Kỹ năng lập trình Java cơ bản và nâng cao', 'Java', 1),
	(2, 'Phát triển giao diện người dùng với React', 'React', 1),
	(3, 'Lập trình backend với Spring Boot', 'Spring Boot', 1),
	(4, 'Xây dựng ứng dụng web bằng Angular', 'Angular', 1),
	(5, 'Quản lý dữ liệu với SQL', 'SQL', 1),
	(6, 'Xử lý dữ liệu lớn với Python', 'Python', 1),
	(7, 'Phát triển ứng dụng di động với Flutter', 'Flutter', 1),
	(8, 'Kỹ năng triển khai và tối ưu hóa API RESTful', 'RESTful API', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
