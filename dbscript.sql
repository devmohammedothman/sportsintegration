
-- command To Create DATABASE
CREATE DATABASE `db_sports_app` /*!40100 DEFAULT CHARACTER SET latin1 */;

-- Command To CREATE TABLE

CREATE TABLE `detailed_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `distance` decimal(20,0) DEFAULT NULL,
  `moving_time` bigint(20) DEFAULT NULL,
  `elapsed_time` bigint(20) DEFAULT NULL,
  `total_elevation_gain` decimal(20,0) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `workout_type` int(11) DEFAULT NULL,
  `source_id` bigint(20) NOT NULL,
  `external_id` bigint(20) DEFAULT NULL,
  `upload_id` bigint(20) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `start_date_local` varchar(250) DEFAULT NULL,
  `timezone` varchar(250) DEFAULT NULL,
  `achievement_count` int(11) DEFAULT NULL,
  `comment_count` int(11) DEFAULT NULL,
  `athlete_count` int(11) DEFAULT NULL,
  `photo_count` int(11) DEFAULT NULL,
  `trainer` tinyint(4) DEFAULT NULL,
  `commute` tinyint(4) DEFAULT NULL,
  `manual` tinyint(4) DEFAULT NULL,
  `private` tinyint(4) DEFAULT NULL,
  `visibility` varchar(45) DEFAULT NULL,
  `athlete_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `source_id_UNIQUE` (`source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

