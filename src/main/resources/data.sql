INSERT IGNORE INTO `little_flower_shop`.`designs` (`title`, `description`, `create_at`) VALUES ('Bó hoa tươi', 'Bó hoa nho nhỏ', NOW());
INSERT IGNORE INTO `little_flower_shop`.`designs` (`title`, `description`, `create_at`) VALUES ('Giỏ hoa tươi', 'Gió hoa nho nhỏ', NOW());
INSERT IGNORE INTO `little_flower_shop`.`designs` (`title`, `description`, `create_at`) VALUES ('Hộp hoa tươi', 'Hộp hoa nho nhỏ', NOW());
INSERT IGNORE INTO `little_flower_shop`.`designs` (`title`, `description`, `create_at`) VALUES ('Bình hoa tươi', 'Bình hoa nho nhỏ', NOW());
INSERT IGNORE INTO `little_flower_shop`.`designs` (`title`, `description`, `create_at`) VALUES ('Lãng hoa tươi', 'Lãng hoa nho nhỏ', NOW());

INSERT IGNORE INTO `little_flower_shop`.`occasions` (`title`, `desciption`, `create_at`) VALUES ('Anniversary', 'Hoa kỉ niệm', NOW());
INSERT IGNORE INTO `little_flower_shop`.`occasions` (`title`, `desciption`, `create_at`) VALUES ('Birthday', 'Hoa sinh nhật', NOW());
INSERT IGNORE INTO `little_flower_shop`.`occasions` (`title`, `desciption`, `create_at`) VALUES ('Congratulations', 'Hoa chúc mừng', NOW());
INSERT IGNORE INTO `little_flower_shop`.`occasions` (`title`, `desciption`, `create_at`) VALUES ('Christmas', 'Hoa giáng sinh', NOW());
INSERT IGNORE INTO `little_flower_shop`.`occasions` (`title`, `desciption`, `create_at`) VALUES ('Thank You', 'Hoa cảm ơn', NOW());

INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `create_at`) VALUES ('Hoa Cát tường', 'PINK', 'Lisianthus', NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `create_at`) VALUES ('Hoa Hồng', 'PINK', 'Rose', NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `create_at`) VALUES ('Hoa Hướng dương', 'YELLOW', 'Sunflower', NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `create_at`) VALUES ('Hoa Oải hương', 'VIOLET', 'Lavender', NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `create_at`) VALUES ('Hoa Ly', 'PINK', 'Lily', NOW());

INSERT IGNORE INTO `little_flower_shop`.`products` ( `title`, `description`, `storage_life`, `dimensions`, `price`, `id_design`, `create_at`)
VALUES ('Gentleness', 'Best for ever', '5', '20x40x30', '1250000', '1', NOW());
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('1', '1');
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('1', '2');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('1', '1');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('1', '2');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('1', '3');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('1', '5');
INSERT IGNORE INTO `little_flower_shop`.`products` ( `title`, `description`, `storage_life`, `dimensions`, `price`, `id_design`, `create_at`)
VALUES ('Scintillating Brilliance', 'Best for ever', '10', '20x50x30', '2550000', '2', NOW());
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('2', '3');
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('2', '5');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('2', '4');

INSERT IGNORE INTO `little_flower_shop`.`pictures` (`name`, `url`, `id_product`) VALUES ('default_product.webp', '/images/default_product.webp', '1');
INSERT IGNORE INTO `little_flower_shop`.`pictures` (`name`, `url`, `id_product`) VALUES ('default_product.webp', '/images/default_product.webp', '2');