import java.sql.*;

public class Test06 {
    private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:root";
    private static final String USER = "system";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        Class.forName(DBDRIVER);
        Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
        String sql = "select mid,name,birthday,age,note from member order by mid";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            int mid = rs.getInt(1);
            String name = rs.getString(2);
            Date birthday = rs.getDate(3);
            int age = rs.getInt(4);
            String note = rs.getString(5);
            System.out.println(mid + "," + name + "," + birthday + ","+ age + "," + note );
        }
        conn.close();

    }
}
