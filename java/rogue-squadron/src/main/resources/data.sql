DROP TABLE IF EXISTS `mydb`.`vehicles` ;
DROP TABLE IF EXISTS `mydb`.`vehicules` ;

CREATE TABLE IF NOT EXISTS `mydb`.`vehicles` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(255) NOT NULL,
    `brand` varchar(255) NOT NULL,
    `model` varchar(255) NOT NULL,
    `color` VARCHAR(255) NOT NULL,
    `license_plate` VARCHAR(255) NOT NULL,
    `booking_price` INT NOT NULL,
    `km_price` INT NOT NULL,
    `horsepower` INT NOT NULL,
    `loading_volume` INT NULL,
    `cylinder` INT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC));

INSERT INTO `vehicles` (`type`,`brand`,`model`,`color`,`license_plate`,`booking_price`,`km_price`,`horsepower`,`loading_volume`)
VALUES
  ("MOTORBIKE","lorem","vitae,","#bc403e","XYS86THP7XF",1,8,4,100),
  ("MOTORBIKE","metus.","amet","#30d18b","LFC95EXB3OC",8,10,4,18),
  ("MOTORBIKE","litora","ante","#4ad684","FJP54GRC9EI",4,3,4,95),
  ("MOTORBIKE","rutrum","nunc","#aefcaf","OPQ42MFE4PP",5,5,7,60),
  ("MOTORBIKE","Duis","nostra,","#e5a590","DFG87MOQ1XP",0,5,7,85),
  ("MOTORBIKE","sit","erat","#fce1bd","JCX36XFT5BX",5,9,8,61),
  ("MOTORBIKE","feugiat","lacinia","#67d858","RUK87OOE7AN",10,0,8,89),
  ("MOTORBIKE","nisi","dolor","#75d323","FDO42WSU8HY",9,7,6,12),
  ("MOTORBIKE","eu,","mi","#1b9b40","LKV55JAJ7PI",8,0,9,49),
  ("MOTORBIKE","Aliquam","Donec","#f4a8df","RWY62RHN9LY",9,10,3,59);

INSERT INTO `vehicles` (`type`,`brand`,`model`,`color`,`license_plate`,`booking_price`,`km_price`,`horsepower`,`loading_volume`)
VALUES
  ("TRUCK","lorem","vitae,","#bc403e","XYS86THP7XF",1,8,4,100),
  ("TRUCK","metus.","amet","#30d18b","LFC95EXB3OC",8,10,4,18),
  ("TRUCK","litora","ante","#4ad684","FJP54GRC9EI",4,3,4,95),
  ("TRUCK","rutrum","nunc","#aefcaf","OPQ42MFE4PP",5,5,7,60),
  ("TRUCK","Duis","nostra,","#e5a590","DFG87MOQ1XP",0,5,7,85),
  ("TRUCK","sit","erat","#fce1bd","JCX36XFT5BX",5,9,8,61),
  ("TRUCK","feugiat","lacinia","#67d858","RUK87OOE7AN",10,0,8,89),
  ("TRUCK","nisi","dolor","#75d323","FDO42WSU8HY",9,7,6,12),
  ("TRUCK","eu,","mi","#1b9b40","LKV55JAJ7PI",8,0,9,49),
  ("TRUCK","Aliquam","Donec","#f4a8df","RWY62RHN9LY",9,10,3,59);

INSERT INTO `vehicles` (`type`,`brand`,`model`,`color`,`license_plate`,`booking_price`,`km_price`,`horsepower`)
VALUES
  ("CAR","tristique","lobortis","#d63835","NNL37MKM4FH",1,4,6),
  ("CAR","pede","mauris","#51db4a","KIJ54BEX8CH",4,9,6),
  ("CAR","aliquet.","erat","#8ec6e5","NUW56YUQ5DU",2,6,0),
  ("CAR","porttitor","Quisque","#ba2312","YFY46GBQ5WY",3,8,4),
  ("CAR","ipsum","ac","#f1ffa8","WKB76CDI3CL",3,6,7),
  ("CAR","fermentum","sagittis","#85a2dd","TPM69XWV6KC",6,3,0),
  ("CAR","mi","magna.","#88f7d0","BCH86NPB7AY",0,8,2),
  ("CAR","risus.","gravida.","#ce02f7","NKQ23EAC3SM",1,5,5),
  ("CAR","lectus","velit","#8cffd6","LKV83XNY6TM",8,5,4),
  ("CAR","bibendum","ut","#5d1987","FCX91LRQ7UH",2,2,4);

