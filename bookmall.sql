-- create database bookmall;
-- create user 'bookmall'@'localhost' identified by 'bookmall';
-- grant all privileges on bookmall.* to 'bookmall'@'localhost';
-- flush privileges;

use bookmall;
-- 카테고리
DROP TABLE IF EXISTS `category` RESTRICT;

-- 서적
DROP TABLE IF EXISTS `book` RESTRICT;

-- 고객
DROP TABLE IF EXISTS `customer` RESTRICT;

-- 카트
DROP TABLE IF EXISTS `cart` RESTRICT;

-- 주문
DROP TABLE IF EXISTS `order_` RESTRICT;

-- 주문도서
DROP TABLE IF EXISTS `orderbook` RESTRICT;


-- 카테고리
CREATE TABLE `category` (
	`no`    INT(11)     NOT NULL COMMENT 'no', -- no
	`gerne` VARCHAR(20) NOT NULL COMMENT '종류' -- 종류
)
COMMENT '카테고리';

-- 카테고리
ALTER TABLE `category`
	ADD CONSTRAINT `PK_category` -- 카테고리 기본키
		PRIMARY KEY (
			`no` -- no
		);

ALTER TABLE `category`
	MODIFY COLUMN `no` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'no';

-- 서적
CREATE TABLE `book` (
	`no`          INT(11)     NOT NULL COMMENT 'no', -- no
	`price`       INT(20)     NOT NULL COMMENT '가격', -- 가격
	`title`       VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
	`category_no` INT(11)     NOT NULL COMMENT '카테고리_no' -- 카테고리_no
)
COMMENT '서적';

-- 서적
ALTER TABLE `book`
	ADD CONSTRAINT `PK_book` -- 서적 기본키
		PRIMARY KEY (
			`no` -- no
		);

ALTER TABLE `book`
	MODIFY COLUMN `no` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'no';

-- 고객
CREATE TABLE `customer` (
	`no`       INT(11)     NOT NULL COMMENT 'no', -- no
	`name`     VARCHAR(10)     NOT NULL COMMENT '이름', -- 이름
	`number`   VARCHAR(15) NOT NULL COMMENT '전화번호', -- 전화번호
	`email`    VARCHAR(20) NULL     COMMENT '이메일', -- 이메일
	`password` VARCHAR(20) NOT NULL COMMENT '비밀번호' -- 비밀번호
)
COMMENT '고객';

-- 고객
ALTER TABLE `customer`
	ADD CONSTRAINT `PK_customer` -- 고객 기본키
		PRIMARY KEY (
			`no` -- no
		);

ALTER TABLE `customer`
	MODIFY COLUMN `no` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'no';

-- 카트
CREATE TABLE `cart` (
	`amount`      INT(5)  NULL COMMENT '수량', -- 수량
	`book_no`     INT(11) NULL COMMENT '서적_no', -- 서적_no
	`customer_no` INT(11) NULL COMMENT '고객_no' -- 고객_no
)
COMMENT '카트';

-- 주문
CREATE TABLE `order_` (
	`no`          INT(11)     NOT NULL COMMENT 'no', -- no
	`orderno`     INT(20)     NOT NULL COMMENT '주문번호', -- 주문번호
	`address`     VARCHAR(30) NOT NULL COMMENT '배송지', -- 배송지
	`customer_no` INT(11)     NOT NULL COMMENT '고객_no' -- 고객_no
)
COMMENT '주문';

-- 주문
ALTER TABLE `order_`
	ADD CONSTRAINT `PK_order_` -- 주문 기본키
		PRIMARY KEY (
			`no` -- no
		);

ALTER TABLE `order_`
	MODIFY COLUMN `no` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'no';

-- 주문도서
CREATE TABLE `orderbook` (
	`book_no`  INT(11) NOT NULL COMMENT '서적_no', -- 서적_no
	`amount`   INT(5)  NOT NULL COMMENT '수량', -- 수량
	`order_no` INT(11) NOT NULL COMMENT '주문_no' -- 주문_no
)
COMMENT '주문도서';

-- 서적
ALTER TABLE `book`
	ADD CONSTRAINT `FK_category_TO_book` -- 카테고리 -> 서적
		FOREIGN KEY (
			`category_no` -- 카테고리_no
		)
		REFERENCES `category` ( -- 카테고리
			`no` -- no
		);

-- 카트
ALTER TABLE `cart`
	ADD CONSTRAINT `FK_book_TO_cart` -- 서적 -> 카트
		FOREIGN KEY (
			`book_no` -- 서적_no
		)
		REFERENCES `book` ( -- 서적
			`no` -- no
		);

-- 카트
ALTER TABLE `cart`
	ADD CONSTRAINT `FK_customer_TO_cart` -- 고객 -> 카트
		FOREIGN KEY (
			`customer_no` -- 고객_no
		)
		REFERENCES `customer` ( -- 고객
			`no` -- no
		);

-- 주문
ALTER TABLE `order_`
	ADD CONSTRAINT `FK_customer_TO_order_` -- 고객 -> 주문
		FOREIGN KEY (
			`customer_no` -- 고객_no
		)
		REFERENCES `customer` ( -- 고객
			`no` -- no
		);

-- 주문도서
ALTER TABLE `orderbook`
	ADD CONSTRAINT `FK_book_TO_orderbook` -- 서적 -> 주문도서
		FOREIGN KEY (
			`book_no` -- 서적_no
		)
		REFERENCES `book` ( -- 서적
			`no` -- no
		);

-- 주문도서
ALTER TABLE `orderbook`
	ADD CONSTRAINT `FK_order__TO_orderbook` -- 주문 -> 주문도서
		FOREIGN KEY (
			`order_no` -- 주문_no
		)
		REFERENCES `order_` ( -- 주문
			`no` -- no
		);