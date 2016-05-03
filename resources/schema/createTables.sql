CREATE TABLE Users (
	id INTEGER PRIMARY KEY,
	username VARCHAR(127) NOT NULL,
	password VARCHAR(127) NOT NULL,
	email VARCHAR(255),
	role INTEGER NOT NULL,
	points INTEGER,
	status VARCHAR(10),
	lastAccessed TIMESTAMP
)