import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test06 {
    private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:root";
    private static final String USER = "system";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
        Statement stmt = conn.createStatement();
        String sql = "update member set name = '李四',birthday = SYSDATE,age = 30 where mid in(2)";
        int len = stmt.executeUpdate(sql);
        System.out.println("影响的数据行:" + len);
        conn.close();

    }
}
