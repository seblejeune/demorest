CREATE TABLE user (
    id            BIGINT AUTO_INCREMENT NOT NULL,
    first_name    VARCHAR(255)          NOT NULL,
    last_name     VARCHAR(255)          NOT NULL,
    email_address VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
)engine=InnoDB;

ALTER TABLE user
    ADD CONSTRAINT uc_user_emailaddress UNIQUE (email_address);