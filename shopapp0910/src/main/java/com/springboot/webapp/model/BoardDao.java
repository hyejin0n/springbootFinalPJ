package com.springboot.webapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDao {

	// MySQL DB 연결 설정 (JDBC 이용)
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

	// insertBoard(BoardDo bdo)
	public void insertBoard(BoardDo bdo) {
		System.out.println("insertBoard() 시작!!");
		String sql = "insert into board (title, writer, content) values (?, ?, ?)";
		try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			if (conn == null) {
				System.out.println("DB 연결 실패, insertBoard() 중단");
				return;
			}
			pstmt.setString(1, bdo.getTitle());
			pstmt.setString(2, bdo.getWriter());
			pstmt.setString(3, bdo.getContent());
			pstmt.executeUpdate();
			System.out.println("insertBoard() 처리 완료 !!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// getBoardList()
	public ArrayList<BoardDo> getBoardList() {
		System.out.println("getBoardList() 시작 !!");
		ArrayList<BoardDo> bList = new ArrayList<>();
		String sql = "select * from board";
		try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				BoardDo bdo = new BoardDo();
				bdo.setSeq(rs.getInt("seq"));
				bdo.setTitle(rs.getString("title"));
				bdo.setWriter(rs.getString("writer"));
				bdo.setContent(rs.getString("content"));
				bList.add(bdo);
			}
			System.out.println("getBoardList() 처리 완료 !!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}

	// getOneBoard(BoardDo bdo)
	public BoardDo getOneBoard(BoardDo bdo) {
		System.out.println("getOneBoard() 처리 시작 ");
		BoardDo board = new BoardDo();
		String sql = "select * from board where seq = ?";
		try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bdo.getSeq());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					board.setSeq(rs.getInt("seq"));
					board.setTitle(rs.getString("title"));
					board.setWriter(rs.getString("writer"));
					board.setContent(rs.getString("content"));
				}
			}
			System.out.println("getOneBoard() 처리 완료 !!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	// updateBoard(BoardDo bdo)
	public void updateBoard(BoardDo bdo) {
		System.out.println("updateBoard() 처리 시작 !!");
		String sql = "update board set title = ?, content = ? where seq = ?";
		try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, bdo.getTitle());
			pstmt.setString(2, bdo.getContent());
			pstmt.setInt(3, bdo.getSeq());
			pstmt.executeUpdate();
			System.out.println("updateBoard() 처리 완료 !!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// deleteBoard(BoardDo bdo)
	public void deleteBoard(BoardDo bdo) {
		System.out.println("deleteBoard() 처리 시작 !!");
		String sql = "delete from board where seq = ?";
		try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bdo.getSeq());
			pstmt.executeUpdate();
			System.out.println("deleteBoard() 처리 완료 !!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
