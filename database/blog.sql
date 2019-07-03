CREATE DATABASE blog DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci ;

USE blog ;

-- -----------------------------------------------------
-- Table blog.role
-- -----------------------------------------------------

CREATE TABLE role (
  id INT(11) NOT NULL,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id));
  
-- -----------------------------------------------------
-- Table blog.user
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
  FOREIGN KEY fk_user_role(role_id)
  REFERENCES role(id)
  ON UPDATE CASCADE
  ON DELETE CASCADE)
;


-- -----------------------------------------------------
-- Table blog.post
-- -----------------------------------------------------
CREATE TABLE post (
  id INT(11) NOT NULL,
  content VARCHAR(255) NOT NULL,
  date_create DATETIME NULL DEFAULT NULL,
  date_update DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table blog.comment
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS comment (
  comment_id INT(11) NOT NULL,
  content VARCHAR(255) NULL DEFAULT NULL,
  date_create DATETIME NULL DEFAULT NULL,
  date_update DATETIME NULL DEFAULT NULL,
  user_id INT(11) NOT NULL,
  post_id INT(11) NOT NULL,
  
  PRIMARY KEY (comment_id),
  
  FOREIGN KEY fk_comment_user(user_id)
  REFERENCES user(id)
  ON UPDATE CASCADE
  ON DELETE CASCADE,
  
  FOREIGN KEY fk_comment_post(post_id)
  REFERENCES post(id)
  ON UPDATE CASCADE
  ON DELETE CASCADE);


-- -----------------------------------------------------
-- Table blog.tag
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS blog.tag (
  id INT(11) NOT NULL,
  name VARCHAR(255) NOT NULL,
  date_create DATETIME NULL DEFAULT NULL,
  date_update DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table blog.tag_posts
-- -----------------------------------------------------

CREATE TABLE tag_posts (
  tag_id INT(11) NOT NULL,
  post_id INT(11) NOT NULL,
  
  FOREIGN KEY fk_tag_id(tag_id)
  REFERENCES tag(id)
  ON UPDATE CASCADE
  ON DELETE CASCADE,
  
  FOREIGN KEY fk_post_id(post_id)
  REFERENCES post(id)
  ON UPDATE CASCADE
  ON DELETE CASCADE,
  
  PRIMARY KEY (tag_id,post_id));
