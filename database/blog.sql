
-- -----------------------------------------------------
-- Database blog
-- -----------------------------------------------------
CREATE DATABASE blog DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci ;
USE blog ;


-- -----------------------------------------------------
-- Table role
-- -----------------------------------------------------
CREATE TABLE role (
  id INT(11) NOT NULL,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table user
-- -----------------------------------------------------
CREATE TABLE user (
  id INT(11) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  role_id INT(11) NOT NULL,
  date_create DATETIME NULL DEFAULT NULL,
  date_update DATETIME NULL DEFAULT NULL,

  PRIMARY KEY (id),

  CONSTRAINT fk_user_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table post
-- -----------------------------------------------------
CREATE TABLE post (
  id INT(11) NOT NULL,
  content VARCHAR(255) NOT NULL,
  user_id INT(11),
  date_create DATETIME NULL DEFAULT NULL,
  date_update DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (id),
 CONSTRAINT fk_post_user
    FOREIGN KEY (user_id)
    REFERENCES user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table comment
-- -----------------------------------------------------
CREATE TABLE comment (
  comment_id INT(11) NOT NULL,
  content VARCHAR(255) NULL DEFAULT NULL,
  date_create DATETIME NULL DEFAULT NULL,
  date_update DATETIME NULL DEFAULT NULL,
  user_id INT(11) NOT NULL,
  post_id INT(11) NOT NULL,

  PRIMARY KEY (comment_id),

  CONSTRAINT fk_comment_post
    FOREIGN KEY (post_id)
    REFERENCES post (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  CONSTRAINT fk_comment_user
    FOREIGN KEY (user_id)
    REFERENCES user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table tag
-- -----------------------------------------------------
CREATE TABLE tag (
  id INT(11) NOT NULL,
  name VARCHAR(255) NOT NULL,
  date_create DATETIME NULL DEFAULT NULL,
  date_update DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table tag_posts
-- -----------------------------------------------------
CREATE TABLE tag_post (
  tag_id INT(11) NOT NULL,
  post_id INT(11) NOT NULL,
  PRIMARY KEY (tag_id, post_id),
  
  CONSTRAINT fk_post_id
    FOREIGN KEY (post_id)
    REFERENCES post (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    
  CONSTRAINT fk_tag_id
    FOREIGN KEY (tag_id)
    REFERENCES tag (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
