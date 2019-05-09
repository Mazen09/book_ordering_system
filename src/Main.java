import java.util.*;
import java.sql.*;

import FormsComponent.*;

import databaseController.DBController;
import FormsComponent.Backend;





public class Main {


    public static void main(String[] args) throws SQLException {

        DBController db = DBController.getInstance();

        db.createConnection("jdbc:mysql://localhost:3306",
                "SAMPLE", "mazen 2017");

//        db.executeDDLStatements();

        Backend b = new Backend();

//        Book book = new Book();
//
//        book.title = "mazen";
//        book.publisher = "N1";
//        book.category = "History";
//        book.ISBN = "25";
//        book.publishingYear = "2019";
//        book.price = 100;
//        book.threshold = 10;
//        book.currentAmount = 20;
//        ArrayList<String> authors = new ArrayList<String>();
//        authors.add("N1");
//        authors.add("N2");
//        authors.add("N3");
//        book.authors = authors;
//
//        try {
//            b.insertBook(book);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        Author author = new Author();
//        author.name = "mazen";
//        author.phone = "01099810834";
//
//        Publisher publisher = new Publisher();
//        publisher.name = "mazen";
//        publisher.address = "kdjdjksd";
//        publisher.phone = "01099810834";
//
//        User user = new User();
//        user.userName = "Mazen09";
//        user.firstName = "Mazen";
//        user.lastName = "Elmesery";
//        user.email = "mazenelmesery@gmail.com";
//        user.password = "mazen";
//        user.address = "mlk4 d3wa";
//        user.phone = "01099810834";
//        user.role = "Manager";
//
//
//        b.insetAuthor(author);
//        b.insertPublisher(publisher);
//        b.insertUser(user);





    }
}
