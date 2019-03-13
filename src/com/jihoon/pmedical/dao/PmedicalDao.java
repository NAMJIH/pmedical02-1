package com.jihoon.pmedical.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jihoon.pmedical.vo.PmedicalVo;

public class PmedicalDao {
	public PmedicalVo getByNo(long no) {

		PmedicalVo pv = new PmedicalVo();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?sslMode=DISABLED&characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. 쿼리 준비
			String sql = "select no, name, gender, tel, status from cocohos where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);

			// 4. sql 실행
			rs = pstmt.executeQuery();

			// 5. 결과 받아오기
			while (rs.next()) {
				long no2 = rs.getLong(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String tel = rs.getString(4);
				String status = rs.getString(5);

				pv.setNo(no2);
				pv.setName(name);
				pv.setGender(gender);
				pv.setTel(tel);
				pv.setStatus(status);

			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);

		}

		return pv;

	}

	public void update(PmedicalVo pv) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println(pv);
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?sslMode=DISABLED&characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. 쿼리 준비
			String sql = "UPDATE cocohos SET name=?, gender=?, tel=?, status=?  WHERE no=? ";
			pstmt = conn.prepareStatement(sql);
//			System.out.println(gv.getPassword());

			// 4. 바인딩
			pstmt.setString(1, pv.getName());
			pstmt.setString(2, pv.getGender());
			pstmt.setString(3, pv.getTel());
			pstmt.setString(4, pv.getStatus());
			pstmt.setLong(5, pv.getNo());

			// 5. sql 실행
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 에러" + e);
		} catch (SQLException e) {
			System.out.println("error" + e);
		}

	}

	public void delete(PmedicalVo pv) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?sslMode=DISABLED&characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. 쿼리 준비
			String sql = "delete from cocohos where no=? ";
			pstmt = conn.prepareStatement(sql);
//			System.out.println(gv.getPassword());

			// 4. 바인딩
			pstmt.setLong(1, pv.getNo());

			// 5. sql 실행
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 에러" + e);
		} catch (SQLException e) {
			System.out.println("error" + e);
		}

	}

	public void insert(PmedicalVo pv) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?sslMode=DISABLED&characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. 쿼리 준비
			String sql = "insert into cocohos values(null, ?, ?, ?, ?, now() )";
			pstmt = conn.prepareStatement(sql);
//			System.out.println(gv.getPassword());

			// 4. 바인딩
			pstmt.setString(1, pv.getName());
			pstmt.setString(2, pv.getGender());
			pstmt.setString(3, pv.getTel());
			pstmt.setString(4, pv.getStatus());

			// 5. sql 실행
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 에러" + e);
		} catch (SQLException e) {
			System.out.println("error" + e);
		}

	}

	public List<PmedicalVo> getList() {

		List<PmedicalVo> list = new ArrayList<PmedicalVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?sslMode=DISABLED&characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. 쿼리 준비
			String sql = "select no, name, gender, tel, status, date_format(date, '%Y-%m-%d %h:%i:%s') from cocohos";
			pstmt = conn.prepareStatement(sql);

			// 4. sql 실행
			rs = pstmt.executeQuery();

			// 5. 결과 받아오기
			while (rs.next()) {
				long no = rs.getLong(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String tel = rs.getString(4);
				String status = rs.getString(5);
				String date = rs.getString(6);

				PmedicalVo pv = new PmedicalVo();
				pv.setNo(no);
				pv.setName(name);
				pv.setGender(gender);
				pv.setTel(tel);
				pv.setStatus(status);
				pv.setDate(date);

				list.add(pv);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);

		}

		return list;
	}

}
