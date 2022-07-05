CREATE TABLE IF NOT EXISTS crawling_data(
    subscription_no INTEGER(5) AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT '청약 번호',
    apartments_name VARCHAR(100) COMMENT '아파트 이름',
    apartments_address VARCHAR(100) COMMENT '아파트 주소',
    latitude VARCHAR(50) COMMENT '위도',
    longitude VARCHAR(50) COMMENT '경도',
    apartments_subscription_date VARCHAR(30) COMMENT '청약 날짜'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;