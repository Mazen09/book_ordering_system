package databaseController;

import java.sql.*;
import java.util.List;

public class DBController {

    private Connection conn;
    private Statement stmt;
    private String sql;
    private static final int  order_quantity = 200;


    private static DBController instance;

    private DBController(){}


    public static synchronized DBController getInstance() {
        if(instance == null) {
            instance = new DBController();
        }
        return instance;
    }


    public void createConnection (String url, String user, String password)
    {
        try {
            conn = conn = DriverManager.getConnection(url, user, password);
            System.out.println("connected :)");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public void createDB(String DBName)
    {
        try {

            stmt = conn.createStatement();

            // creating the schema
            sql = "CREATE SCHEMA IF NOT EXISTS "+DBName;
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");

            // using the schema
            sql = "USE "+DBName;
            stmt.executeUpdate(sql);
            System.out.println(DBName +" is now in use");

            // creating the tables
            createPublisherTable(DBName);
            createAuthorTable(DBName);
            createBookTable(DBName);
            createAuthoredByTable(DBName);
            createOrderTable(DBName);
            createTriggers();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }

    private void createPublisherTable (String DBName)
    {
        try{

            stmt = conn.createStatement();

            sql= "CREATE TABLE IF NOT EXISTS "+ DBName +".PUBLISHER (" +
                    "NAME VARCHAR(45) NOT NULL, " +
                    "ADDRESS VARCHAR(45) NOT NULL, " +
                    "PHONE VARCHAR(15) NULL, " +
                    "PRIMARY KEY (NAME, ADDRESS));";
            System.out.println(sql);

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }

    private void createAuthorTable (String DBName)
    {
        try{

            stmt = conn.createStatement();

            sql= "CREATE TABLE IF NOT EXISTS "+ DBName +".AUTHOR (" +
                    "NAME VARCHAR(45) NOT NULL, " +
                    "ADDRESS VARCHAR(45) NULL, " +
                    "PHONE VARCHAR(15) NULL, " +
                    "PRIMARY KEY (NAME));";
            System.out.println(sql);

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }

    private void createBookTable (String DBName)
    {
        try{

            stmt = conn.createStatement();

            sql= "CREATE TABLE IF NOT EXISTS "+ DBName +".BOOK (" +
                    "ISBN INT UNSIGNED NOT NULL, " +
                    "TITLE VARCHAR(45) NOT NULL, " +
                    "CATEGORY VARCHAR(45) NOT NULL, " +
                    "PRICE INT UNSIGNED NOT NULL, " +
                    "PUBLISHER_NAME VARCHAR(45) NOT NULL, " +
                    "PUBLICATION_YEAR INT UNSIGNED NOT NULL, " +
                    "AMOUNT_IN_STOCK INT UNSIGNED NOT NULL, " +
                    "THRESHOLD INT UNSIGNED NOT NULL, " +

                    "PRIMARY KEY (ISBN), " +
                    "CONSTRAINT  BOOK_PUBLISHER_FK FOREIGN KEY (PUBLISHER_NAME) REFERENCES " +
                    DBName + ".PUBLISHER (NAME) ON DELETE RESTRICT ON UPDATE CASCADE );";
            System.out.println("\n\n"+sql);
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }

    private void createAuthoredByTable (String DBName)
    {
        try{

            stmt = conn.createStatement();

            sql= "CREATE TABLE IF NOT EXISTS "+ DBName +".AUTHORED_BY (" +
                    "ISBN INT UNSIGNED NOT NULL, " +
                    "NAME VARCHAR(45) NOT NULL, " +
                    "PRIMARY KEY (ISBN, NAME), " +
                    "CONSTRAINT  BOOK_AUTHORED_BY_FK FOREIGN KEY (ISBN) REFERENCES " +
                    DBName + ".BOOK (ISBN) ON DELETE CASCADE ON UPDATE CASCADE," +
                    "CONSTRAINT  AUTHOR_AUTHORED_BY_FK FOREIGN KEY (NAME) REFERENCES " +
                    DBName + ".AUTHOR (NAME) ON DELETE RESTRICT ON UPDATE CASCADE " +
                    " );";

            System.out.println("\n\n"+sql);
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }

    private void createOrderTable (String DBName)
    {
        try{

            stmt = conn.createStatement();

            sql= "CREATE TABLE IF NOT EXISTS "+ DBName +".ORDERS (" +
                    "ID INT UNSIGNED NOT NULL AUTO_INCREMENT, " +
                    "ISBN INT UNSIGNED NOT NULL, " +
                    "QUANTITY INT UNSIGNED NOT NULL, " +
                    "ORDER_DATE DATE NOT NULL, " +
                    "PRIMARY KEY (ID), " +
                    "CONSTRAINT  BOOK_ORDER_FK FOREIGN KEY (ISBN) REFERENCES " +
                    DBName + ".BOOK (ISBN) ON DELETE RESTRICT ON UPDATE CASCADE );";

            System.out.println("\n\n"+sql);
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }

    private void createTriggers()
    {
        try {
            stmt = conn.createStatement();

            //1. add new book
            sql = "CREATE TRIGGER BOOK_BEFORE_INSERT\n" +
                    "BEFORE INSERT ON BOOK\n" +
                    "FOR EACH ROW\n" +
                    "BEGIN\n" +
                    "  IF NEW.CATEGORY NOT IN ('Science','Art','Religion','History','Geography') \n" +
                    "  THEN\n" +
                    "   SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'ERROR: INCOMPATIBLE DOMAIN';\n" +
                    "  END IF;\n" +
                    "END;";

            System.out.println("\n\n"+ sql);
            stmt.executeUpdate(sql);

            sql = "CREATE TRIGGER BOOK_AFTER_INSERT\n" +
                    "AFTER INSERT ON BOOK\n" +
                    "FOR EACH ROW\n" +
                    "BEGIN\n" +
                    "  IF NEW.AMOUNT_IN_STOCK < NEW.THRESHOLD\n" +
                    "   THEN\n" +
                    "    INSERT INTO ORDERS (ISBN, QUANTITY, ORDER_DATE) VALUES(NEW.ISBN, 200, curdate());\n" +
                    "   END IF;\n" +
                    "END;";

            System.out.println("\n\n"+ sql);
            stmt.executeUpdate(sql);

            // 2. modify existing book
            sql = "CREATE TRIGGER BOOK_BEFORE_UPDATE\n" +
                    "BEFORE UPDATE ON BOOK\n" +
                    "FOR EACH ROW\n" +
                    "BEGIN\n" +
                    "  IF NEW.CATEGORY NOT IN ('Science','Art','Religion','History','Geography') \n" +
                    "  THEN\n" +
                    "   SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'ERROR: INCOMPATIBLE DOMAIN';\n" +
                    "  END IF;\n" +
                    "  IF NEW.AMOUNT_IN_STOCK < 0\n" +
                    "  THEN\n" +
                    "\tSIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'ERROR: AMOUNT IN STOCK MUST BE POSITIVE';\n" +
                    "  END IF;\n" +
                    "END;";

            System.out.println("\n\n"+ sql);
            stmt.executeUpdate(sql);

            // 3. place orders on books
            sql = "CREATE TRIGGER BOOK_AFTER_UPDATE\n" +
                    "AFTER UPDATE ON BOOK\n" +
                    "FOR EACH ROW\n" +
                    "BEGIN\n" +
                    "  IF NEW.AMOUNT_IN_STOCK < NEW.THRESHOLD\n" +
                    "  THEN\n" +
                    "\tINSERT INTO ORDERS (ISBN, QUANTITY, ORDER_DATE) VALUES(NEW.ISBN, 200, curdate());\n" +
                    "  END IF;\n" +
                    "END;";

            System.out.println("\n\n"+ sql);
            stmt.executeUpdate(sql);


            //4. confirm order (recursive trigger :( )
            sql = "CREATE TRIGGER ORDERS_BEFORE_DELETION\n" +
                    "BEFORE DELETE ON ORDERS\n" +
                    "FOR EACH ROW \n" +
                    "BEGIN\n" +
                    "    UPDATE BOOK SET BOOK.AMOUNT_IN_STOCK = BOOK.AMOUNT_IN_STOCK + OLD.QUANTITY\n" +
                    "    WHERE BOOK.ISBN = OLD.ISBN; \n" +
                    "END;";

            System.out.println("\n\n"+ sql);
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void addBook(String ISBN, String title, List<String> authors,
                          String publisher, String PublicationYear, String price, String category)
    {

    }




}
