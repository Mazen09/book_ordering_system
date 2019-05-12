CREATE SCHEMA IF NOT EXISTS BOOK_STORE; 
#
USE BOOK_STORE; 
#
CREATE TABLE IF NOT EXISTS BOOK_STORE.PUBLISHER ( 
NAME VARCHAR(45) NOT NULL, 
ADDRESS VARCHAR(45) NOT NULL, 
PHONE VARCHAR(15) NULL, 
PRIMARY KEY (NAME, ADDRESS)); 
#
CREATE TABLE IF NOT EXISTS BOOK_STORE.AUTHOR ( 
NAME VARCHAR(45) NOT NULL, 
PHONE VARCHAR(15) NULL, 
PRIMARY KEY (NAME)); 
#
CREATE TABLE IF NOT EXISTS BOOK_STORE.BOOK ( 
ISBN VARCHAR(30) NOT NULL, 
TITLE VARCHAR(45) NOT NULL, 
CATEGORY VARCHAR(45) NOT NULL, 
PRICE FLOAT UNSIGNED NOT NULL, 
PUBLISHER_NAME VARCHAR(45) NOT NULL, 
PUBLICATION_YEAR INT UNSIGNED NOT NULL, 
AMOUNT_IN_STOCK INT UNSIGNED NOT NULL, 
THRESHOLD INT UNSIGNED NOT NULL, 
PRIMARY KEY (ISBN), 
CONSTRAINT  BOOK_PUBLISHER_FK FOREIGN KEY (PUBLISHER_NAME) REFERENCES 
BOOK_STORE.PUBLISHER (NAME) ON DELETE RESTRICT ON UPDATE CASCADE ); 
#
CREATE TABLE IF NOT EXISTS BOOK_STORE.AUTHORED_BY ( 
ISBN VARCHAR(30) NOT NULL, 
NAME VARCHAR(45) NOT NULL, 
PRIMARY KEY (ISBN, NAME), 
CONSTRAINT  BOOK_AUTHORED_BY_FK FOREIGN KEY (ISBN) REFERENCES 
BOOK_STORE.BOOK (ISBN) ON DELETE CASCADE ON UPDATE CASCADE, 
CONSTRAINT  AUTHOR_AUTHORED_BY_FK FOREIGN KEY (NAME) REFERENCES 
BOOK_STORE.AUTHOR (NAME) ON DELETE RESTRICT ON UPDATE CASCADE ); 
#
CREATE TABLE IF NOT EXISTS BOOK_STORE.ORDERS ( 
ID INT UNSIGNED NOT NULL AUTO_INCREMENT, 
ISBN VARCHAR(30) NOT NULL, 
QUANTITY INT  NOT NULL, 
ORDER_DATE DATE NOT NULL, 
PRIMARY KEY (ID), 
CONSTRAINT  BOOK_ORDER_FK FOREIGN KEY (ISBN) REFERENCES 
BOOK_STORE.BOOK (ISBN) ON DELETE RESTRICT ON UPDATE CASCADE ); 
#
CREATE TABLE IF NOT EXISTS BOOK_STORE.USER ( 
USER_NAME 			VARCHAR(45) NOT NULL, 
FIRST_NAME 			VARCHAR(20) NOT NULL, 
LAST_NAME 			VARCHAR(20) NOT NULL, 
EMAIL 				VARCHAR(45) NOT NULL, 
PASSWORD    		VARCHAR(45) NOT NULL, 
PHONE 				VARCHAR(15) NOT NULL, 
SHIPPING_ADDRESS 	VARCHAR(100) NOT NULL, 
USER_TYPE			VARCHAR(15) NOT NULL,  
PRIMARY KEY (USER_NAME)); 
#
CREATE TABLE IF NOT EXISTS BOOK_STORE.CART ( 
USER_NAME 			VARCHAR(45) NOT NULL, 
ISBN 				VARCHAR(30) NOT NULL, 
QUANTITY			INT UNSIGNED NOT NULL, 
PRIMARY KEY (USER_NAME, ISBN), 
CONSTRAINT  CART_USER_FK FOREIGN KEY (USER_NAME) REFERENCES 
BOOK_STORE.USER (USER_NAME) ON DELETE RESTRICT ON UPDATE CASCADE, 
CONSTRAINT  CART_BOOK_FK FOREIGN KEY (ISBN) REFERENCES 
BOOK_STORE.BOOK (ISBN) ON DELETE RESTRICT ON UPDATE CASCADE);  
#
CREATE TABLE IF NOT EXISTS BOOK_STORE.CONFIRMED_OPERATION ( 
USER_NAME 			VARCHAR(45) NOT NULL, 
ISBN 				VARCHAR(30) NOT NULL, 
QUANTITY			INT UNSIGNED NOT NULL, 
CONFIRM_DATE		DATE NOT NULL, 
TOTAL_PRICE			INT UNSIGNED NOT NULL, 
PRIMARY KEY (USER_NAME,ISBN), 
CONSTRAINT  CONFIRMED_OPERATION_USER_FK FOREIGN KEY (USER_NAME) REFERENCES 
BOOK_STORE.USER (USER_NAME) ON DELETE RESTRICT ON UPDATE CASCADE, 
CONSTRAINT  CONFIRMED_OPERATION_BOOK_FK FOREIGN KEY (ISBN) REFERENCES  
BOOK_STORE.BOOK (ISBN) ON DELETE RESTRICT ON UPDATE CASCADE); 
#
CREATE TRIGGER USER_BEFORE_INSERT 
BEFORE INSERT ON BOOK_STORE.USER 
FOR EACH ROW 
BEGIN 
IF NEW.EMAIL NOT LIKE '%@%.COM' 
THEN 
SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'ERROR: INVALID EMAIL FORMAT';  
END IF; 
IF NEW.USER_TYPE NOT IN ('Manager','customer') 
THEN  
SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'ERROR: INVALID USER TYPE'; 
END IF; 
END; 
#
CREATE TRIGGER BOOK_BEFORE_INSERT 
BEFORE INSERT ON BOOK 
FOR EACH ROW 
BEGIN 
IF NEW.CATEGORY NOT IN ('Science','Art','Religion','History','Geography') 
THEN 
SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'ERROR: INCOMPATIBLE DOMAIN'; 
END IF; 
END; 
#
CREATE TRIGGER BOOK_AFTER_INSERT 
AFTER INSERT ON BOOK  
FOR EACH ROW 
BEGIN 
DECLARE PREVOIUS_ORDERS INT  DEFAULT 0; 
DECLARE ORDER_AMOUNT INT  DEFAULT 0; 
SELECT SUM(QUANTITY) INTO PREVOIUS_ORDERS   
FROM BOOK_STORE.ORDERS WHERE ORDERS.ISBN = NEW.ISBN; 
IF NEW.AMOUNT_IN_STOCK < NEW.THRESHOLD THEN 
	IF PREVOIUS_ORDERS IS NULL 
	THEN	SELECT (NEW.THRESHOLD - NEW.AMOUNT_IN_STOCK) INTO ORDER_AMOUNT; 
	ELSE 	SELECT (NEW.THRESHOLD - NEW.AMOUNT_IN_STOCK - PREVOIUS_ORDERS) INTO ORDER_AMOUNT; 
	END IF; 
	INSERT INTO ORDERS (ISBN, QUANTITY, ORDER_DATE) VALUES(NEW.ISBN, ORDER_AMOUNT, curdate()); 
END IF; 
END; 
#
CREATE TRIGGER BOOK_BEFORE_UPDATE 
BEFORE UPDATE ON BOOK 
FOR EACH ROW 
BEGIN 
IF NEW.CATEGORY NOT IN ('Science','Art','Religion','History','Geography') 
THEN 
SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'ERROR: INCOMPATIBLE DOMAIN'; 
END IF; 
IF NEW.AMOUNT_IN_STOCK < 0 
THEN 
SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'ERROR: AMOUNT IN STOCK MUST BE POSITIVE'; 
END IF; 
END; 
#
CREATE TRIGGER BOOK_AFTER_UPDATE 
AFTER UPDATE ON BOOK 
FOR EACH ROW 
BEGIN 
DECLARE PREVOIUS_ORDERS INT  DEFAULT 0; 
DECLARE ORDER_AMOUNT INT  DEFAULT 0; 
SELECT SUM(QUANTITY) INTO PREVOIUS_ORDERS   
FROM BOOK_STORE.ORDERS WHERE ORDERS.ISBN = NEW.ISBN; 
IF (NEW.AMOUNT_IN_STOCK < NEW.THRESHOLD and new.AMOUNT_IN_STOCK > 0) THEN 
	IF PREVOIUS_ORDERS IS NULL 
	THEN	SELECT (NEW.THRESHOLD - NEW.AMOUNT_IN_STOCK) INTO ORDER_AMOUNT; 
	ELSE 	SELECT (NEW.THRESHOLD - NEW.AMOUNT_IN_STOCK - PREVOIUS_ORDERS) INTO ORDER_AMOUNT; 
	END IF; 
	INSERT INTO ORDERS (ISBN, QUANTITY, ORDER_DATE) VALUES(NEW.ISBN, ORDER_AMOUNT, curdate()); 
END IF; 
END; 
#
CREATE TRIGGER ORDERS_BEFORE_DELETION 
BEFORE DELETE ON ORDERS 
FOR EACH ROW 
BEGIN 
    UPDATE BOOK SET BOOK.AMOUNT_IN_STOCK = BOOK.AMOUNT_IN_STOCK + OLD.QUANTITY 
    WHERE BOOK.ISBN = OLD.ISBN; 
END;
# 

