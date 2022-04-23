CREATE SCHEMA IF NOT EXISTS db;

CREATE TABLE db.tag(
	id INT PRIMARY KEY AUTO_INCREMENT,
	tag VARCHAR(32) NOT NULL
);

CREATE TABLE db.project_tag(
	project_id INT,
	tag_id INT,
	PRIMARY KEY (project_id, tag_id),
	FOREIGN KEY (project_id) REFERENCES db.tag (id)
		ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (tag_id) REFERENCES db.tag (id)
		on UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE db.sponsor(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	website VARCHAR(50)
);

CREATE TABLE db.sponsor_member(
	sponsor_id INT,
	person_id INT,
	PRIMARY KEY (sponsor_id, person_id),
	FOREIGN KEY (sponsor_id) REFERENCES db.sponsor (id)
		ON UPDATE CASCADE ON DELETE RESTRICT,
	FOREIGN KEY (person_id) REFERENCES db.person (id)
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE db.person(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name_first VARCHAR(50) NOT NULL,
	name_last VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL,
	profile_pic VARCHAR(500),
	github_username VARCHAR(100),
	linkedin_username VARCHAR(100),
	personal_url VARCHAR(1024),
	address_country VARCHAR(30),
	address_state VARCHAR(30),
	address_city VARCHAR(30),
	address_street VARCHAR(30),
	phone VARCHAR(15),
	is_professor TINYINT(1),
	is_student TINYINT(1),
	is_sponsor TINYINT(1),
	is_admin TINYINT(1),
	uci_netid VARCHAR(20),
	password VARCHAR(30)
);

CREATE TABLE db.category(
	id INT PRIMARY KEY AUTO_INCREMENT,
	category VARCHAR(50) NOT NULL
);

CREATE TABLE db.sponsor_category(
	sponsor_id INT,
	category_id INT,
	PRIMARY KEY (sponsor_id, category_id),
	FOREIGN KEY (sponsor_id) REFERENCES db.sponsor (id)
		ON UPDATE CASCADE ON DELETE RESTRICT,
	FOREIGN KEY (category_id) REFERENCES db.category (id)
		ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE db.project(
	id INT PRIMARY KEY AUTO_INCREMENT,
	sponsor_id INT NOT NULL,
	project_description VARCHAR(500) NOT NULL,
	pitch_video VARCHAR(1024) NOT NULL,
	image VARCHAR(1024) NOT NULL,
	state ENUM("COMPLETED", "IN_PROGRESS", "NOT_STARTED"),
	course_instance_id INT,
	FOREIGN KEY (sponsor_id) REFERENCES db.sponsor (id)
		ON UPDATE CASCADE ON DELETE RESTRICT,
	FOREIGN KEY (course_instance_id) REFERENCES db.course_instance (id)
		ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE db.course_instance(
	id INT PRIMARY KEY AUTO_INCREMENT,
	department VARCHAR(100) NOT NULL,
	number VARCHAR(100) NOT NULL,
	uci_course_id INT NOT NULL UNIQUE,
	professor_id INT NOT NULL,
	term ENUM("WINTER", "SPRING", "SUMMER", "FALL"),
	year INT NOT NULL,
	FOREIGN KEY (professor_id) REFERENCES db.person (id)
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE db.team(
	id INT PRIMARY KEY AUTO_INCREMENT,
	team_name VARCHAR(50),
	size INT
);

CREATE TABLE db.matching(
	course_instance_id INT,
	project_id INT,
	team_id INT,
	PRIMARY KEY (course_instance_id, project_id, team_id)
	FOREIGN KEY (course_instance_id) REFERENCES db.course_instance (id)
		ON UPDATE CASCADE ON DELETE RESTRICT,
	FOREIGN KEY (project_id) REFERENCES db.project (id)
		ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (team_id) REFERENCES db.team (id)
		ON UPDATE CASCADE ON DELETE CASCADE
);