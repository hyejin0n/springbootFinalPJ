package com.springboot.webapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;


import java.sql.*;

@Repository("signupDao")
public class SignupDao {

    //MySQl Db 연결 설정
    private static final String ID = "root";
    private static final String PASSWORD = "111111";
    private static final String URL = "jdbc:mysql://localhost:3306/springdb?characterEncoding=utf-8";

    public Connection getConn() {
        Connection conn = null;
        try {
            // 드라이버 로딩은 최신 JDBC에서 필요하지 않음
            // Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, ID, PASSWORD);
            System.out.println("DB 연결 성공!!");
        } catch (SQLException e) {
            System.out.println("DB 연결 실패: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
    public void closeConn(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                if (!rs.isClosed()) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                if (!pstmt.isClosed()) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                if (!conn.isClosed()) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // signup(Signup bdo)
    public void insertSignup(SignupDo sbdo) {
        System.out.println("insertSignup() 시작!!");
        String sql = "insert into smember (email, userName, passWord) values (?, ?, ?)";
        try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if (conn == null) {
                System.out.println("DB 연결 실패, insertSignup() 중단");
                return;
            }
            pstmt.setString(1, sbdo.getEmail());
            pstmt.setString(2, sbdo.getUserName());
            pstmt.setString(3, sbdo.getPassWord());
            pstmt.executeUpdate();
            System.out.println("insertSignup() 처리 완료 !!");
        } catch (SQLException e) {
            System.out.println("insertSignup() 처리 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
