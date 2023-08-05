package practiceJDBC;

import utilities.JDBCutils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ProjectDay {

    public static void main(String[] args) throws SQLException {

        JDBCutils.establishConnection();
        List<Map<String,Object>> tabledata = JDBCutils.runQuery("SELECT * FROM core_yard");

        for( Map<String,Object> data: tabledata){
            System.out.println("location");
        }



    }
}
