package practiceJDBC;
import utilities.JDBCutils;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class JDBD3 {

    public static void main(String[] args) throws SQLException {
        JDBCutils.establishConnection();

        List<Map<String, Object>> tableData =  JDBCutils.runQuery("select * from jobs order by job_id desc");
        for(Map<String, Object> data: tableData){
            System.out.println(data.get("job_id"));
        }
        JDBCutils.closeDatabase();
        List<Map<String, Object>> tableData2 =  JDBCutils.runQuery("select * from employees");

    }
}
