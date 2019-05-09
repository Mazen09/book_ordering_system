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

    public ArrayList<Book> getBooks(String searchAttribute, String searchKey) throws SQLException {

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

    public void promoteUser(User user) throws SQLException

    {

    }

    public ArrayList<User> getUsers(String userName) throws SQLException
    {
        return null;
    }

    public void addToCart(String userName, String ISBN) throws SQLException
    {

    }

    public ArrayList<CartItem> getCartContent(String userName) throws SQLException
    {
      stmt = conn.createStatement();
      ResultSet rs =
        stmt.executeQuery("SELECT * FROM `CART` " +
                          "WHERE `USER_NAME` = " + userName);
      ArrayList<CartItem> rsArrayList = new ArrayList<CartItem>();
      while (rs.next()) {
        CartItem citem = new CartItem();
        citem.quantity = rs.getInt("QUANTITY");
        String isbnString = Integer.toString(rs.getInt("ISBN"));
        citem.book = getBooks("ISBN", isbnString).get(0);
        rsArrayList.add(citem);
      }
      return rsArrayList;
    }

    public void updateCartItem(String userName, String ISBN,int newQuantity) throws SQLException
    {
      stmt = conn.createStatement();
      stmt.executeUpdate("UPDATE `CART` " +
                         "SET `QUANTITY` = '" + newQuantity + "' " +
                         "WHERE `USER_NAME` = '" + userName + "' AND " +
                         "`ISBN` = '" + ISBN + "'");
    }

    public void removeCartItem(String userName, String ISBN) throws SQLException
    {
      stmt = conn.createStatement();
      stmt.executeUpdate("DELETE FROM `CART` " +
                         "WHERE `USER_NAME` = '" + userName + "' AND " +
                         "`ISBN` = '" + ISBN + "'");
    }

    public void addSale(String userName) throws SQLException
    {
      conn.setAutoCommit(false);
      ArrayList<CartItem> cart = getCartContent(userName);
      for (CartItem citem : cart) {
        stmt.executeUpdate(
            "UPDATE `BOOK` " +
            "SET `QUANTITY` = QUANTITY - " + citem.quantity + " " +
            "WHERE `ISBN` = " + citem.book.ISBN);
        PreparedStatement pstmt =conn.prepareStatement(
            "INSERT INTO `CONFIRMED_OPERATION` VALUES(?, ?, ?, ?, ?)");
        pstmt.setString(1, userName);
        pstmt.setInt(2, Integer.parseInt(citem.book.ISBN));
        pstmt.setInt(3, citem.quantity);
        pstmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
        pstmt.setInt(5, Math.round(citem.book.price * citem.quantity));
        pstmt.execute();
        stmt.executeUpdate(
            "DELETE FROM `CART` " +
            "WHERE `USER_NAME` = '" + userName + "' AND " +
            "`ISBN` = '" + citem.book.ISBN + "'");
      }
      conn.commit();
      conn.setAutoCommit(true);
    }

    public void insertOrder(String ISBN, int quantity) throws SQLException
    {

    }

    public void confirmOrder(int id) throws SQLException
    {

    }

    public User logIn(String UserName, String password) throws Exception
    {
        return null;
    }


    public void logOut(String UserName) throws SQLException
    {
    }

    public void reportTotalSales() throws SQLException
    {

    }

    public void reportTopCustomers() throws SQLException
    {

    }

    public void reportTopSellingBooks() throws SQLException
    {

    }
}
