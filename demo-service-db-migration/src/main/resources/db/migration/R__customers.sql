CREATE TABLE IF NOT EXISTS `customers` (
  `id`           INT AUTO_INCREMENT,
  `status`       VARCHAR(16)                 NOT NULL,
  `email`        VARCHAR(50)                 NOT NULL UNIQUE,
  `first_name`   VARCHAR(50)                 NOT NULL,
  `last_name`    VARCHAR(50),
  `updated_time` DATETIME                    NOT NULL,
  PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;



SELECT COUNT(*) INTO @index FROM information_schema.`COLUMNS` WHERE table_schema=DATABASE()
AND column_name='sex' AND table_name='customers';
SET @SQL=IF(@index=0,'ALTER TABLE customers ADD sex VARCHAR(1)','select \'Column Is Existed\';');
PREPARE statement FROM @SQL;
EXECUTE statement;

--ERROR  zip_code not run
ALTER TABLE customers ADD sex VARCHAR(1);
ALTER TABLE customers ADD zip_code VARCHAR(8);