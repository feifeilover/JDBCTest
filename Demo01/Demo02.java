首先启动sqlplus在oracle数据库中添加相应的数据库操作：

DROP TABLE member PURGE;
DROP SEQUENCE myseq;
CREATE SEQUENCE myseq;
CREATE TABLE member(
	mid NUMBER,
	name VARCHAR2(20),
	birthday DATE DEFAULT SYSDATE,
	age NUMBER(3),
	note CLOB,
	CONSTRAINT pk_mid PRIMARY KEY(mid)
);
----------------------------------------------

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
        String sql = " insert into member(mid,name,birthday,age,note) " +
                " values(myseq.nextval,'张三',TO_DATE('1997-09-06','yyyy-mm-dd'),17,'你是一个好学生')";
        int len = stmt.executeUpdate(sql);
        System.out.println("影响的数据行:" + len);
        conn.close();

    }
}
