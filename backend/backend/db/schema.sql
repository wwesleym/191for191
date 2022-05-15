CREATE SCHEMA IF NOT EXISTS projects;

CREATE TABLE IF NOT EXISTS projects.tag(
	id INT NOT NULL PRIMARY KEY,
	name VARCHAR(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS projects.category(
	id INT NOT NULL PRIMARY KEY,
	name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS projects.sponsor(
	id INT NOT NULL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	website VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS projects.person(
	id INT NOT NULL PRIMARY KEY,
	name_first VARCHAR(50) NOT NULL,
	name_middle VARCHAR(50),
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
	is_professor BOOLEAN,
	is_student BOOLEAN,
	is_sponsor BOOLEAN,
	is_admin BOOLEAN,
	uci_netid VARCHAR(20),
	password VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS projects.course_instance(
	id INT NOT NULL PRIMARY KEY,
	department VARCHAR(100) NOT NULL,
	number VARCHAR(100) NOT NULL,
	professor_id INT NOT NULL,
	term ENUM('WINTER', 'SPRING', 'SUMMER', 'FALL') NOT NULL,
	year INT NOT NULL,
	FOREIGN KEY (professor_id) REFERENCES projects.person (id)
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS projects.project(
	id INT NOT NULL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	team_size INT NOT NULL,
	sponsor_id INT NOT NULL,
	project_description VARCHAR(500) NOT NULL,
	pitch_video VARCHAR(1024) NOT NULL,
	image VARCHAR(1024),
	state ENUM('COMPLETED', 'IN_PROGRESS', 'NOT_STARTED'),
	course_instance_id INT,
	FOREIGN KEY (sponsor_id) REFERENCES projects.sponsor (id)
		ON UPDATE CASCADE ON DELETE RESTRICT,
	FOREIGN KEY (course_instance_id) REFERENCES projects.course_instance (id)
		ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS projects.project_tag(
	project_id INT,
	tag_id INT,
	PRIMARY KEY (project_id, tag_id),
	FOREIGN KEY (project_id) REFERENCES projects.project (id)
		ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (tag_id) REFERENCES projects.tag (id)
		on UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS projects.sponsor_category(
	sponsor_id INT,
	category_id INT,
	PRIMARY KEY (sponsor_id, category_id),
	FOREIGN KEY (sponsor_id) REFERENCES projects.sponsor (id)
		ON UPDATE CASCADE ON DELETE RESTRICT,
	FOREIGN KEY (category_id) REFERENCES projects.category (id)
		ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS projects.sponsor_member(
	sponsor_id INT,
	person_id INT,
	PRIMARY KEY (sponsor_id, person_id),
	FOREIGN KEY (sponsor_id) REFERENCES projects.sponsor (id)
		ON UPDATE CASCADE ON DELETE RESTRICT,
	FOREIGN KEY (person_id) REFERENCES projects.person (id)
		ON UPDATE CASCADE ON DELETE CASCADE
);