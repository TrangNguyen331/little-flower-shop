INSERT IGNORE INTO `little_flower_shop`.`designs` (`title`, `description`, `created_at`, `updated_at`) VALUES ('Bó hoa tươi', 'Bó hoa nho nhỏ', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`designs` (`title`, `description`, `created_at`, `updated_at`) VALUES ('Giỏ hoa tươi', 'Gió hoa nho nhỏ', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`designs` (`title`, `description`, `created_at`, `updated_at`) VALUES ('Hộp hoa tươi', 'Hộp hoa nho nhỏ', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`designs` (`title`, `description`, `created_at`, `updated_at`) VALUES ('Bình hoa tươi', 'Bình hoa nho nhỏ', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`designs` (`title`, `description`, `created_at`, `updated_at`) VALUES ('Lãng hoa tươi', 'Lãng hoa nho nhỏ', NOW(), NOW());

INSERT IGNORE INTO `little_flower_shop`.`occasions` (`title`, `desciption`, `created_at`, `updated_at`) VALUES ('Anniversary', 'Hoa kỉ niệm', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`occasions` (`title`, `desciption`, `created_at`, `updated_at`) VALUES ('Birthday', 'Hoa sinh nhật', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`occasions` (`title`, `desciption`, `created_at`, `updated_at`) VALUES ('Congratulations', 'Hoa chúc mừng', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`occasions` (`title`, `desciption`, `created_at`, `updated_at`) VALUES ('Christmas', 'Hoa giáng sinh', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`occasions` (`title`, `desciption`, `created_at`, `updated_at`) VALUES ('Thank You', 'Hoa cảm ơn', NOW(), NOW());

INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `created_at`, `updated_at`) VALUES ('Hoa Hồng', 'PINK', 'Rose', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `created_at`, `updated_at`) VALUES ('Hoa Hồng', 'ORANGE', 'Rose', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `created_at`, `updated_at`) VALUES ('Hoa Hồng', 'WHITE', 'Rose', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `created_at`, `updated_at`) VALUES ('Hoa Hồng', 'GREEN', 'Rose', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `created_at`, `updated_at`) VALUES ('Hoa Cẩm Tú', 'GREEN', 'Hydrangea', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `created_at`, `updated_at`) VALUES ('Hoa Cẩm Tú', 'WHITE', 'Hydrangea', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `created_at`, `updated_at`) VALUES ('Hoa Bạch Đàn', 'GREEN', 'Eucalyptus', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `created_at`, `updated_at`) VALUES ('Hoa Cát tường', 'PINK', 'Lisianthus', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `created_at`, `updated_at`) VALUES ('Hoa Hướng dương', 'YELLOW', 'Sunflower', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`flowers` ( `kind`, `color`, `description`, `created_at`, `updated_at`) VALUES ('Hoa Ly', 'PINK', 'Lily', NOW(), NOW());

INSERT IGNORE INTO `little_flower_shop`.`products` ( `title`, `description`, `storage_life`, `dimensions`, `price`, `id_design`, `created_at`, `updated_at`)
VALUES ('Gentleness', 'Best for ever', '5', '30x60x40', '850000', '1', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('1', '5');
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('1', '6');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('1', '1');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('1', '2');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('1', '3');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('1', '5');
INSERT IGNORE INTO `little_flower_shop`.`pictures` (`name`, `url`, `id_product`) VALUES ('img_1_hydrangea.jpg', '/files/img_1_hydrangea.jpg', '1');

INSERT IGNORE INTO `little_flower_shop`.`products` ( `title`, `description`, `storage_life`, `dimensions`, `price`, `id_design`, `created_at`, `updated_at`)
VALUES ('Scintillating Brilliance', 'Best for ever', '10', '40x50x30', '1250000', '1', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('2', '1');
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('2', '2');
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('2', '3');
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('2', '4');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('2', '1');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('2', '2');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('2', '3');
INSERT IGNORE INTO `little_flower_shop`.`pictures` (`name`, `url`, `id_product`) VALUES ('img_2_rose.jpg', '/files/img_2_rose.jpg', '2');

INSERT IGNORE INTO `little_flower_shop`.`products` ( `title`, `description`, `storage_life`, `dimensions`, `price`, `id_design`, `created_at`, `updated_at`)
VALUES ('Affectionate', 'Best for ever', '10', '25x55x30', '950000', '1', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('3', '3');
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('3', '4');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('3', '1');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('3', '3');
INSERT IGNORE INTO `little_flower_shop`.`pictures` (`name`, `url`, `id_product`) VALUES ('img_3_rose.jpg', '/files/img_3_rose.jpg', '3');

INSERT IGNORE INTO `little_flower_shop`.`products` ( `title`, `description`, `storage_life`, `dimensions`, `price`, `id_design`, `created_at`, `updated_at`)
VALUES ('Loveliness', 'Best for ever', '5', '20x50x30', '1550000', '1', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('4', '7');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('4', '1');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('4', '2');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('4', '3');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('4', '4');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('4', '3');
INSERT IGNORE INTO `little_flower_shop`.`pictures` (`name`, `url`, `id_product`) VALUES ('img_4_eucalyptus.jpg', '/files/img_4_eucalyptus.jpg', '4');

INSERT IGNORE INTO `little_flower_shop`.`products` ( `title`, `description`, `storage_life`, `dimensions`, `price`, `id_design`, `created_at`, `updated_at`)
VALUES ('Fascinating White', 'Best for ever', '10', '30x50x40', '550000', '1', NOW(), NOW());
INSERT IGNORE INTO `little_flower_shop`.`product_flower` (`id_product`, `id_flower`) VALUES ('5', '5');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('5', '1');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('5', '2');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('5', '3');
INSERT IGNORE INTO `little_flower_shop`.`product_occasion` (`id_product`, `id_occasion`) VALUES ('5', '5');
INSERT IGNORE INTO `little_flower_shop`.`pictures` (`name`, `url`, `id_product`) VALUES ('img_5_hydrangea.jpg', '/files/img_5_hydrangea.jpg', '5');