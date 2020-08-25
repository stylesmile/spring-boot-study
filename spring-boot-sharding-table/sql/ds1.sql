CREATE DATABASE IF NOT EXISTS
`ds1`

/*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */
;
USE
`ds1`
;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS =
0
;

-- ----------------------------
--
Table
 structure
for
 user_0
-- ----------------------------
DROP TABLE IF EXISTS
`user_0`
;
CREATE TABLE
`user_0`
 (

`id`

int
(
11
) NOT NULL,

`name`
 varchar(
255
) DEFAULT NULL,

`age`

int
(
11
) DEFAULT NULL,
  PRIMARY KEY (
`id`
)
) ENGINE=
InnoDB
 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--
Table
 structure
for
 user_1
-- ----------------------------
DROP TABLE IF EXISTS
`user_1`
;
CREATE TABLE
`user_1`
 (

`id`

int
(
11
) NOT NULL,

`name`
 varchar(
255
) DEFAULT NULL,

`age`

int
(
11
) DEFAULT NULL,
  PRIMARY KEY (
`id`
)
) ENGINE=
InnoDB
 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS =
1
;