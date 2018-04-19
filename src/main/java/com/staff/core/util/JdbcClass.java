package com.staff.core.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcClass {
	//驱动，URL，用户名，密码
    private static final String driver = "oracle.jdbc.driver.OracleDriver";
    private static final String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String username = "cauxgh";
    private static final String password = "123456";
 
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 加 载驱动
            Class.forName(driver);
            // 通过驱动管理类获取数据库连接
            connection = DriverManager.getConnection(url, username, password);
            // 关闭连接
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
 
    // 测试oracle连接是否成功
    public static void main(String[] args) {
        Connection connection = JdbcClass.getConnection();
        if (connection != null) {
            System.out.println("连接oracle数据库成功:" + connection);
        } else {
            System.out.println("连接oracle数据库失败!!!");
        }
 
    }
}
