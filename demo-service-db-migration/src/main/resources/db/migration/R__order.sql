CREATE TABLE IF NOT EXISTS `order` (
  `id`           INT AUTO_INCREMENT,
  `customer_id`  INT                       NOT NULL,
  `description`  VARCHAR(200),
  `created_time` DATETIME                   NOT NULL,
  PRIMARY KEY (`id`)
);
