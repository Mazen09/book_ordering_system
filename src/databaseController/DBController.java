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
    private File file;
    private static final String path = "DDL_statements.sql";

    private static DBController instance;

    private DBController(){}

    /**
     * Represents a SQL query parameter for column of type "type".
     */
    public static class Parameter {
      public String type;
      public Object value;

      public Parameter(final String type, final Object value) {
        this.type = type;
        this.value = value;
      }
    }

    /**
     * Prepares a SQL statement with the given parameters.
     *
     * @param query SQL query with '?' placeholders for values.
     * @param params ArrayList of parameters types and values.
     *
     * @return Prepared statement.
     */
    public PreparedStatement prepareStatement(
        final String query, final ArrayList<Parameter> params) {
      try {
        PreparedStatement pstmt = conn.prepareStatement(query);
        int i = 1;
        for (final Parameter param : params) {
          switch (param.type) {
            case "Int":
              pstmt.setInt(i, (Integer) param.value);
              break;
            case "String":
              pstmt.setString(i, (String) param.value);
              break;
            case "Float":
              pstmt.setFloat(i, (Float) param.value);
              break;
            case "Date":
              pstmt.setDate(i, (Date) param.value);
              break;
            default:
              throw new Exception("No such type: " + param.type);
          }
          i += 1;
        }
        return pstmt;
      } catch (Exception ex) {
        ex.printStackTrace();
        return null;
      }
    }

    public static synchronized DBController getInstance() {
        if(instance == null) {
            instance = new DBController();
        }
        return instance;
    }


    public void createConnection (String url, String user, String password)
    {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("connected :)");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        if (conn == null) {
            createConnection("jdbc:mysql://localhost:3306",
                    "SAMPLE", "");
        }
        return conn;
    }


    private void fetchSQLQueries()
    {
        try {

            file = new File(path);
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

            br.close();

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
                System.out.println("Query done successfully...");

            }

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public void closeConnection()
    {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
