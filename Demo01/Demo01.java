import java.sql.Connection;
import java.sql.DriverManager;

public class Test06 {
    private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:root";
    private static final String USER = "system";
    private static final String PASSWORD = "123456";
    public static void main(String[] args) throws Exception {
        Class.forName(DBDRIVER);
        Connection con = DriverManager.getConnection(DBURL,USER,PASSWORD);
        System.out.println(con);
        con.close();


    }
}
