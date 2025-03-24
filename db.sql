DROP DATABASE IF EXISTS recipe_manager;
CREATE DATABASE recipe_manager OWNER mateusz;
\c recipe_manager

CREATE TABLE difficulty_level (
	id SERIAL PRIMARY KEY,
	label VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE tag (
	id SERIAL PRIMARY KEY,
	label VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE measurement_unit (
	id SERIAL PRIMARY KEY,
	label VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE ingredient (
	id SERIAL PRIMARY KEY,
	title VARCHAR(100) NOT NULL,
	unit_id INT REFERENCES measurement_unit(id) on DELETE CASCADE,
	amount NUMERIC(3, 1) NOT NULL
);

CREATE TABLE recipe (
	id SERIAL PRIMARY KEY,
	title VARCHAR(100) NOT NULL,
	instructions TEXT,
	preparation_time INT,
	diff_level INT REFERENCES difficulty_level(id) on DELETE CASCADE
);

CREATE TABLE recipe_ingredient (
	id SERIAL PRIMARY KEY,
	recipe_id INT REFERENCES recipe(id) on DELETE CASCADE,
	ingredient_id INT REFERENCES ingredient(id) on DELETE CASCADE
);

CREATE TABLE recipe_tag (
	id SERIAL PRIMARY KEY,
	recipe_id INT REFERENCES recipe(id) on DELETE CASCADE,
	tag_id INT REFERENCES tag(id) on DELETE CASCADE
);

CREATE TABLE app_user (
	id SERIAL PRIMARY KEY,
	username VARCHAR(100) NOT NULL UNIQUE,
	pass VARCHAR(100) NOT NULL
);

CREATE TABLE rating (
	id SERIAL PRIMARY KEY,
	user_id INT REFERENCES app_user(id) on DELETE CASCADE,
	recipe_id INT REFERENCES recipe(id) on DELETE CASCADE,
	comment VARCHAR(255),
	score NUMERIC(3, 1) NOT NULL CHECK (
        	score >= 0 AND score <= 10 AND
        	(score * 2) % 1 = 0
    	)
);
