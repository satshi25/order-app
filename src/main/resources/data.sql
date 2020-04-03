DROP TABLE IF EXISTS DEMO_INGREDIENT;
DROP TABLE IF EXISTS DEMO_TACO;
DROP TABLE IF EXISTS DEMO_ORDER;


CREATE TABLE DEMO_ORDER (
	ORDER_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
	TACO INTEGER);

CREATE TABLE DEMO_TACO (
	TACO_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
	ODER_ID INTEGER,
	NAME VARCHAR(250) NOT NULL,
	INGREDIENT INTEGER);

CREATE TABLE DEMO_INGREDIENT (
	INGREDIENT_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
	TACO_ID INTEGER,
	NAME VARCHAR(250) NOT NULL,
	foreign key (TACO_ID) references DEMO_TACO(TACO_ID));
	

	
INSERT INTO DEMO_INGREDIENT (INGREDIENT_ID,NAME) VALUES(1,'chicken');
INSERT INTO DEMO_TACO (TACO_ID,NAME, INGREDIENT) VALUES(1,'chickenTaco', 1);
INSERT INTO DEMO_ORDER (ORDER_ID, TACO) VALUES(1, 1);