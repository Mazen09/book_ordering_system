import java.util.*;
import java.sql.*;

import databaseController.DBController;





public class Main {


    public static void main(String[] args) {

        DBController db = DBController.getInstance();

        db.createConnection("jdbc:mysql://localhost:3306",
                "root", "mazen 2017");

        db.executeDDLStatements();

    }
}
