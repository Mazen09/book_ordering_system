package FormsComponent;

import java.util.*;
import java.sql.*;
import java.io.InputStream;

import databaseController.DBController;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

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

    private String attrConverter(String attr)
    {
        switch (attr)
        {
            case "ISBN":
                return "ISBN";
            case "Title":
                return "TITLE";
            case "Publisher":
                return "PUBLISHER_NAME";
            case "Author":
                return "AUTHOR";
            case "Publishing Year":
                return "PUBLICATION_YEAR";
            case "Category":
                return "CATEGORY";
            case "Price":
                return "PRICE";
            default:
                return null;
        }
    }

    public ArrayList<Book> getBooks(String searchAttribute, String searchKey, int offset) throws SQLException {
      ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book();
        ArrayList<String> authors = new ArrayList<>();
        String attr = attrConverter(searchAttribute);
        ResultSet rset;

        if(attr.equals("AUTHOR"))
        {
            query = "SELECT * FROM BOOK " +
                    "natural JOIN " +
                    "(select * FROM AUTHORED_BY WHERE AUTHORED_BY.NAME LIKE '%"+searchKey+"%')" +
                    " AS A order by ISBN ;";
        }else if (attr.equals("PRICE") || attr.equals("PUBLICATION_YEAR")){
            query = "SELECT * FROM AUTHORED_BY " +
                    " natural JOIN (select * from BOOK where "+attr+" = "+searchKey+
                    " ORDER BY ISBN LIMIT 10 OFFSET "+ offset*10 +")" +
                    " AS A ;";
        } else {
            query = "SELECT * FROM AUTHORED_BY " +
                    " natural JOIN (select * from BOOK where "+attr+" like '%"+searchKey+"%'" +
                    " ORDER BY ISBN LIMIT 10 OFFSET "+ offset*10 +")" +
                    " AS A ;";
        }

        stmt = conn.createStatement();
        rset = stmt.executeQuery(query);

        String prevISBN = "none";

        while(rset.next())
        {
            String isbn = rset.getString("ISBN");

            if(!isbn.equals(prevISBN) )
            {
                if(prevISBN != "none"){
                    book.authors = authors;
                    books.add(book);
                }
                prevISBN = isbn;
                book = new Book();
                book.ISBN = rset.getString("ISBN");
                book.title = rset.getString("TITLE");
                book.category = rset.getString("CATEGORY");
                book.price = Float.parseFloat(rset.getString("PRICE"));
                book.publisher = rset.getString("PUBLISHER_NAME");
                book.publishingYear = rset.getString("PUBLICATION_YEAR");
                book.currentAmount = Integer.parseInt(rset.getString("AMOUNT_IN_STOCK"));
                book.threshold = Integer.parseInt(rset.getString("THRESHOLD"));
                authors = new ArrayList<String>();
                authors.add(rset.getString("NAME"));
            }else {
                authors.add(rset.getString("NAME"));
            }
        }
        // last book
        if(!authors.isEmpty()) {
            book.authors = authors;
            books.add(book);
        }

        if(attr.equals("AUTHOR"))
        {
            ArrayList<Book> subList;

            if(books.size() > 10*offset)
            {
                if (books.size() > 10 * offset + 10) {
                    subList = new ArrayList<>(books.subList(offset*10, offset*10 + 10));
                    return  subList;
                }else{
                    subList = new ArrayList<>(books.subList(offset*10, books.size()-1));
                    return subList;
                }
            }else {
                return new ArrayList<Book>();
            }
        }
        return books;
    } // checked

    private boolean [] checkAuthors(ArrayList<String> authors) throws SQLException
    {
        boolean [] tmp = new boolean[authors.size()];
        stmt = conn.createStatement();
        ResultSet rset;

        for(int i = 0; i < authors.size(); i++)
        {
            query = "SELECT NAME FROM AUTHOR WHERE NAME = '"+authors.get(i)+"';";
            rset = stmt.executeQuery(query);

            int count = 0;
            while (rset.next()) count++;

            if(count > 0) tmp[i] = true;

        }

        return  tmp;
    }

    private boolean authorsExist (boolean [] authors)
    {
        for(boolean b : authors)
        {
            if(!b)
            {
                return false;
            }
        }
        return true;
    }

    public void insertBook(Book book) throws SQLException {
            int countInserted;
            stmt = conn.createStatement();
            ResultSet rset;
            boolean [] authorBooleans = checkAuthors(book.authors);

            if(!authorsExist(authorBooleans)) throw new SQLException("SOME AUTHORS NOT FOUND !!!");

            query = "INSERT INTO BOOK VALUES ( '" + book.ISBN + "', '" + book.title + "', '" + book.category + "', " +
                    book.price + ", '" + book.publisher + "', " + book.publishingYear + ", " + book.currentAmount + ", " +
                    book.threshold + " );";
            System.out.println(query);
            countInserted = stmt.executeUpdate(query);
            System.out.println(countInserted + " records inserted.\n");

            for(String a : book.authors)
            {
                query = "INSERT INTO AUTHORED_BY VALUES ( '"+ book.ISBN + "', '" + a +"' )";
                System.out.println(query);
                countInserted = stmt.executeUpdate(query);
                System.out.println(countInserted + " records inserted.\n");
            }

    } // checked

    public void updateBook(Book oldBook, Book newBook) throws SQLException { // why old book ?!
        int countUpdated;
        stmt = conn.createStatement();
        ResultSet rset;
        boolean [] authorBooleans = checkAuthors(newBook.authors);

        if(!authorsExist(authorBooleans)) throw new SQLException("SOME AUTHORS NOT FOUND !!!");


        query = "UPDATE BOOK SET ISBN = '"+ newBook.ISBN +"' , TITLE = '"+newBook.title+"'," +
                " CATEGORY = '"+newBook.category+"', PRICE = '"+newBook.price+"',"+" PUBLICATION_YEAR = "+newBook.publishingYear+
                ", THRESHOLD = "+newBook.threshold+
                " WHERE ISBN = '"+oldBook.ISBN+"' ;";
        System.out.println(query);
        countUpdated = stmt.executeUpdate(query);
        System.out.println(countUpdated + " records updated.\n");

        // DELETE OLD AUTHORED_BY
        query = "DELETE FROM AUTHORED_BY WHERE ISBN = "+ newBook.ISBN +" ;";
        System.out.println(query);
        countUpdated = stmt.executeUpdate(query);
        System.out.println(countUpdated + " records updated.\n");

        // INSERT NEW AUTHORED_BY
        int countInserted;
        for(String a : newBook.authors)
        {
            query = "INSERT INTO AUTHORED_BY VALUES ( '"+ newBook.ISBN + "', '" + a +"' )";
            System.out.println(query);
            countInserted = stmt.executeUpdate(query);
            System.out.println(countInserted + " records inserted.\n");
        }

    } // checked

    public void insetAuthor(Author author) throws SQLException {
        ////try {
        int countInserted;
        stmt = conn.createStatement();
        query = "INSERT INTO AUTHOR VALUES ( '" + author.name + "', '" + author.phone + "' );";
        System.out.println(query);
        countInserted = stmt.executeUpdate(query);
        System.out.println(countInserted + " records inserted.\n");
        //} catch (Exception ex) {
        // ex.printStackTrace();
        //}
    } // checked

    public void insertPublisher(Publisher publisher) throws SQLException {
      ////try {
        int countInserted;
        stmt = conn.createStatement();
        query = "INSERT INTO PUBLISHER VALUES ( '"+ publisher.name +"', '"+publisher.address+"', '"+publisher.phone+"' );";
        System.out.println(query);
        countInserted = stmt.executeUpdate(query);
        System.out.println(countInserted + " records inserted.\n");
      //} catch (Exception ex) {
      //  ex.printStackTrace();
      //}
    }// checked

    public void insertUser(User user) throws SQLException {
      //try {
        int countInserted;
        stmt = conn.createStatement();
        query = "INSERT INTO USER VALUES ( '"+ user.userName +"', '"+user.firstName+"', '"+user.lastName+
                "', '"+user.email+"', '"+user.password+"', '"+user.phone+"', '"+user.address+
                "', '"+user.role+"' );";
        System.out.println(query);
        countInserted = stmt.executeUpdate(query);
        System.out.println(countInserted + " records inserted.\n");
      /*} catch (Exception ex) {
        ex.printStackTrace();
      }*/
    }// checked

    public void updateUser(User oldUser, User newUser) throws SQLException {
      //try {
        int countUpdated;
        stmt = conn.createStatement();
        query = "UPDATE USER SET USER_NAME = '"+newUser.userName+"', FIRST_NAME = '"+newUser.firstName+"'," +
            " LAST_NAME = '"+newUser.lastName+"', EMAIL = '"+newUser.email+"', PASSWORD = '"+newUser.password+"'," +
                " PHONE = '"+newUser.phone+"', SHIPPING_ADDRESS = '"+newUser.address+
                "' WHERE USER_NAME = '"+oldUser.userName+"';";
        System.out.println(query);
        countUpdated = stmt.executeUpdate(query);
        System.out.println(countUpdated + " records updated.\n");
      /*} catch (Exception ex) {
        ex.printStackTrace();
      }*/
    } //checked

    public void promoteUser(User user) throws SQLException {
      //try {
        int countUpdated;
        stmt = conn.createStatement();
        query = "UPDATE USER SET USER_TYPE = 'Manager' WHERE USER_NAME = '"+user.userName+"';";
        System.out.println(query);
        countUpdated = stmt.executeUpdate(query);
        System.out.println(countUpdated + " records updated.\n");
      /*} catch (Exception ex) {
        ex.printStackTrace();
      }*/
    } // checked

    public ArrayList<User> getUsers(String userName) throws SQLException {
      //try {
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        ResultSet rset;
        query = "select * from USER where USER_TYPE='customer' AND USER_NAME like '%"+userName+"%';";
        stmt = conn.createStatement();
        rset = stmt.executeQuery(query);

        while(rset.next())
        {
            user.userName = rset.getString("USER_NAME");
            user.firstName = rset.getString("FIRST_NAME");
            user.lastName = rset.getString("LAST_NAME");
            user.email = rset.getString("EMAIL");
            user.password = rset.getString("PASSWORD");
            user.address = rset.getString("SHIPPING_ADDRESS");
            user.phone = rset.getString("PHONE");
            user.role = rset.getString("USER_TYPE");

            users.add(user);
            user = new User();
        }

        return users;
      /*} catch (Exception ex) {
        ex.printStackTrace();
        return null;
      }*/
    } // checked

    public ArrayList<Order> getOrders(String ISBN) throws SQLException {
      //try {
        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order();
        ResultSet rset;
        query = "select * from ORDERS where ISBN = '"+ISBN+"';";
        stmt = conn.createStatement();
        rset = stmt.executeQuery(query);

        while(rset.next())
        {
            order = new Order();
            order.id = Integer.parseInt(rset.getString("ID"));
            order.ISBN = rset.getString("ISBN");
            order.date = rset.getString("ORDER_DATE");
            order.quantity = Integer.parseInt(rset.getString("QUANTITY"));
            orders.add(order);
        }
        return orders;
      /*} catch (Exception ex) {
        ex.printStackTrace();
        return null;
      }*/
    } // checked

    public void addToCart(String userName, String ISBN) throws SQLException {
      int countInserted;
        ResultSet rset;

        query = "insert into CART (USER_NAME, ISBN, QUANTITY) values" +
                " ('"+userName+"', '"+ISBN+"', 1);";
        System.out.println(query);
        stmt = conn.createStatement();
        countInserted = stmt.executeUpdate(query);
        System.out.println(countInserted + " records inserted.\n");
    } // checked

    public ArrayList<CartItem> getCartContent(String userName) throws SQLException {
      //try {
        stmt = conn.createStatement();
        ResultSet rs =
          stmt.executeQuery("SELECT * FROM `CART` " +
                            "WHERE `USER_NAME` = '" + userName + "'");
        ArrayList<CartItem> rsArrayList = new ArrayList<CartItem>();
        while (rs.next()) {
          CartItem citem = new CartItem();
          citem.quantity = rs.getInt("QUANTITY");
          String isbnString = rs.getString("ISBN");
          citem.book = getBooks("ISBN", isbnString, 0).get(0);
          rsArrayList.add(citem);
        }
        return rsArrayList;
      /*} catch (Exception ex) {
        ex.printStackTrace();
        return null;
      }*/
    }

    public void updateCartItem(String userName, String ISBN,int newQuantity) throws SQLException {
      //try {
        stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE `CART` " +
                           "SET `QUANTITY` = '" + newQuantity + "' " +
                           "WHERE `USER_NAME` = '" + userName + "' AND " +
                           "`ISBN` = '" + ISBN + "'");
      /*} catch (Exception ex) {
        ex.printStackTrace();
      }*/
    }

    public void removeCartItem(String userName, String ISBN) throws SQLException {
      //try {
        stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM `CART` " +
                           "WHERE `USER_NAME` = '" + userName + "' AND " +
                           "`ISBN` = '" + ISBN + "'");
      /*} catch (Exception ex) {
        ex.printStackTrace();
      }*/
    }

    public void addSale(String userName) throws SQLException {
      //try {
        conn.setAutoCommit(false);
        ArrayList<CartItem> cart = getCartContent(userName);
        for (CartItem citem : cart) {
          stmt.executeUpdate(
              "UPDATE `BOOK` " +
              "SET `AMOUNT_IN_STOCK` = AMOUNT_IN_STOCK - " + citem.quantity + " " +
              "WHERE `ISBN` = '" + citem.book.ISBN + "'");
          PreparedStatement pstmt =conn.prepareStatement(
              "INSERT INTO `CONFIRMED_OPERATION` (USER_NAME, ISBN, QUANTITY,CONFIRM_DATE,TOTAL_PRICE) VALUES(?, ?, ?, ?, ?)");
          pstmt.setString(1, userName);
          pstmt.setString(2, citem.book.ISBN);
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
      /*} catch (Exception ex) {
        ex.printStackTrace();
      }*/
    }

    public void insertOrder(String ISBN, int quantity) throws SQLException {
      //try {
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
        db.prepareStatement(
            "INSERT INTO `ORDERS` (ISBN, QUANTITY, ORDER_DATE) VALUES (?, ?, ?)",
            new ArrayList<DBController.Parameter>(Arrays.asList(
                new DBController.Parameter("String", ISBN),
                new DBController.Parameter("Int", quantity),
                new DBController.Parameter("Date", now)))).execute();
      /*} catch (Exception ex) {
        ex.printStackTrace();
      }*/
    }

    public void confirmOrder(int id, String ISBN) throws SQLException {
      db.prepareStatement(
          "DELETE FROM `ORDERS` WHERE `ID` = ?",
          new ArrayList<DBController.Parameter>(Arrays.asList(
              new DBController.Parameter("Int", id)))).execute();
    }

    // DISCLAIMER: CODE-REVIEWER DISCRETION IS ADVISED. WE ARE ABOUT TO
    // MUTILATE SOME VERY BASIC PRINCIPLES.
    public User logIn(String UserName, String password) throws SQLException {
      //try {
        User user = null;
        PreparedStatement pstmtLogin = db.prepareStatement(
            "SELECT * FROM `USER` WHERE `USER_NAME` = ? AND `PASSWORD` = ?",
            new ArrayList<DBController.Parameter>(Arrays.asList(
                new DBController.Parameter("String", UserName),
                new DBController.Parameter("String", password))));
        if (pstmtLogin.execute()) {
          ResultSet rsLogin = pstmtLogin.getResultSet();
          if (rsLogin.next()) {
            user = new User();
            user.userName = UserName;
            user.password = password;
            user.role = rsLogin.getString("USER_TYPE");
            user.phone = rsLogin.getString("PHONE");
            user.firstName = rsLogin.getString("FIRST_NAME");
            user.lastName = rsLogin.getString("LAST_NAME");
            user.email = rsLogin.getString("EMAIL");
            user.address = rsLogin.getString("SHIPPING_ADDRESS");
            return user;
          }
        }
        throw new IllegalArgumentException("Invalid login credentials");
     /* } catch (Exception ex) {
        ex.printStackTrace();
        return null;
      }*/
    }


    public void logOut(String UserName) throws SQLException {
      db.prepareStatement(
          "DELETE FROM `CART` WHERE `USER_NAME` = ?",
          new ArrayList<DBController.Parameter>(
            Arrays.asList(new DBController.Parameter("String", UserName))))
        .execute();
    }

    public void reportTotalSales() throws SQLException {
      try {
        InputStream monthlySalesJasper =
          this.getClass().getResourceAsStream("/jasper/MONTHLY_SALES.jasper");
        JasperPrint report =
          JasperFillManager.fillReport(monthlySalesJasper,
                                       new HashMap(), conn);
        JasperViewer view = new JasperViewer(report, false);
        view.setVisible(true);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    public void reportTopCustomers() throws SQLException {
      try {
        InputStream topCustomersJasper =
          this.getClass().getResourceAsStream("/jasper/TOP_CUSTOMERS.jasper");
        JasperPrint report =
          JasperFillManager.fillReport(topCustomersJasper,
                                       new HashMap(), conn);
        JasperViewer view = new JasperViewer(report, false);
        view.setVisible(true);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    public void reportTopSellingBooks() throws SQLException {
      try {
        InputStream topSellingJasper =
          this.getClass().getResourceAsStream("/jasper/TOP_SELLING.jasper");
        JasperPrint report =
          JasperFillManager.fillReport(topSellingJasper,
                                       new HashMap(), conn);
        JasperViewer view = new JasperViewer(report, false);
        view.setVisible(true);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
}
