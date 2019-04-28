package databaseController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBController {

    private Connection conn;
    private Statement stmt;
    private String sql;
    private List<String> queries;
    private StringBuilder tmp;
    private BufferedReader bf;
    private File file;


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


    private void fetchSQLQueries()
    {
        try {

            file = new File("DDL statments.sql");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            tmp = new StringBuilder();
            queries = new ArrayList<String>();

            while((str = br.readLine()) != null)
            {
                if(str.charAt(0) != '#'){
                    tmp.append(str);
                }else{
                    queries.add(tmp.toString());
                    tmp.setLength(0);
                }
            }

            for(String s : queries)
            {
                System.out.println(s);
            }


        }catch (Exception e){
            throw null;
        }

    }

    public void executeDDLStatements ()
    {
        try {

            fetchSQLQueries();

            stmt = conn.createStatement();

            // creating the schema
            for(String str : queries)
            {
                sql = str;
                stmt.executeUpdate(sql);
                System.out.println("Database created successfully...");

            }

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }


    public void addBook(String ISBN, String title, List<String> authors,
                          String publisher, String PublicationYear, String price, String category)
    {

    }




}
