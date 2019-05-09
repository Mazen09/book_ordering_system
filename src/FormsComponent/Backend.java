package FormsComponent;

import java.util.*;
import java.sql.*;

import databaseController.DBController;


public class Backend {

    private Connection conn;
    private Statement stmt;
    private DBController db;
    private String query;


    public Backend ()
    {
        try {
            db = DBController.getInstance();
            conn = db.getConnection();
            query = "USE BOOK_STORE;";
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getBooks(String searchAttribute, String searchKey) {

        ArrayList<Book> books = new ArrayList<Book>();
        try {

            query = "";
            stmt = conn.createStatement();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return books;
    }

    public void insertBook(Book book) throws SQLException {

            int countInserted;
            stmt = conn.createStatement();
            query = "INSERT INTO BOOK VALUES ( "+ book.ISBN +", '"+book.title+"', '"+book.category+"', " +
                    book.price +", '"+ book.publisher +"', "+book.publishingYear+", "+book.currentAmount+", "+
                    book.threshold+" );";
            System.out.println(query);
            countInserted = stmt.executeUpdate(query);
            System.out.println(countInserted + " records inserted.\n");

            for(String a : book.authors)
            {
                query = "INSERT INTO AUTHORED_BY VALUES ( "+ book.ISBN + ", '" + a +"' )";
                System.out.println(query);
                countInserted = stmt.executeUpdate(query);
                System.out.println(countInserted + " records inserted.\n");
            }
    }

    public void updateBook(Book oldBook, Book newBook) throws SQLException { // why old book ?!

    }

    public void insetAuthor(Author author) throws SQLException {
        int countInserted;
        stmt = conn.createStatement();
        query = "INSERT INTO AUTHOR VALUES ( '"+ author.name +"', '"+author.phone+"' );";
        System.out.println(query);
        countInserted = stmt.executeUpdate(query);
        System.out.println(countInserted + " records inserted.\n");
    }

    public void insertPublisher(Publisher publisher) throws SQLException {
        int countInserted;
        stmt = conn.createStatement();
        query = "INSERT INTO PUBLISHER VALUES ( '"+ publisher.name +"', '"+publisher.address+"', '"+publisher.phone+"' );";
        System.out.println(query);
        countInserted = stmt.executeUpdate(query);
        System.out.println(countInserted + " records inserted.\n");
    }

    public void insertUser(User user) throws SQLException {
        int countInserted;
        stmt = conn.createStatement();
        query = "INSERT INTO USER VALUES ( '"+ user.userName +"', '"+user.firstName+"', '"+user.lastName+
                "', '"+user.email+"', '"+user.password+"', '"+user.phone+"', '"+user.address+
                "', '"+user.role+"' );";
        System.out.println(query);
        countInserted = stmt.executeUpdate(query);
        System.out.println(countInserted + " records inserted.\n");
    }

    public void updateUser(User oldUser, User newUser) throws Exception {

    }

    public void promoteUser(User user)

    {

    }

    public ArrayList<User> getUsers(String userName)
    {
        return null;
    }

    public void addToCart(String userName, String ISBN)
    {

    }

    public ArrayList<CartItem> getCartContent(String userName)
    {
        return null;
    }

    public void updateCartItem(String userName, String ISBN,int newQuantity)
    {

    }

    public void removeCartItem(String userName, String ISBN)
    {

    }

    public void addSale(String userName)
    {

    }

    public void insertOrder(String ISBN, int quantity)
    {

    }

    public void confirmOrder(int id)
    {

    }

    public User logIn(String UserName, String password) throws Exception
    {
        return null;
    }


    public void logOut(String UserName)
    {

    }

    public void reportTotalSales()
    {

    }

    public void reportTopCustomers()
    {

    }

    public void reportTopSellingBooks()
    {

    }
}
