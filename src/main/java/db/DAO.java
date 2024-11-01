package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DAO {

    private static Connection conn = null;

    public static Connection getConnection(){
        try {
            if (conn == null) {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        return conn;
    }

    public static void closeConnection(){
        try{
            conn.close();
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }


    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStmament(Statement stm){
        try{
            stm.close();
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    public static void closeResultSet(ResultSet rs){
        try {
            rs.close();
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }
}
