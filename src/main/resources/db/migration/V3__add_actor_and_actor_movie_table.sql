CREATE TABLE Actor (
                       ID INTEGER NOT NULL PRIMARY KEY auto_increment,
                       NAME VARCHAR(255)
);

CREATE TABLE Actor_movie (
                             ID INTEGER NOT NULL PRIMARY KEY auto_increment,
                             ACTORID INT,
                             MOVIEID INT,
                             FOREIGN KEY (ACTORID) REFERENCES Actor(ID),
                             FOREIGN KEY (MOVIEID) REFERENCES Movie(ID)
);