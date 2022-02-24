package com.Lungnaha.IntegratedWebsite.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Lungnaha.IntegratedWebsite.BoardVO;
import com.Lungnaha.IntegratedWebsite.comm.JDBCUtil;

// VO(데이터 콰린 클래스) 를 이용해서 실질적인 DB 연동을 담당하는 코드
@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired // 사전에 <bean> 등록했기에 가져올 수 있는 것
	private JdbcTemplate jdbcTemplate; // 순수 JDBC가 아닌 JdbcTemplate을 활용해서 DB 처리하기 위해 사용하는 객체
	
	// 아래의 주석 처리 3개의 변수들은 모두 순수 JDBC 에서만 사용되고 JdbcTemplate 객체를 이용하면서는 사용하지 않는 변수들
//	private Connection conn = null;
//	private PreparedStatement stmt = null;
//	private ResultSet rs = null;
	
	// 순수 JDBC는 이와 같이 원하는 sql문을 전부 작성해주어야 함
	private final String myINSERT = "insert into blogboard(title,writer,content) values(?,?,?)";
	private final String myUpdate = "update blogboard set title=?,content=? where seq=?";
	private final String myDelete = "delete blogboard where seq=?";
	private final String myGet = "select * from blogboard where seq=?";
	private final String myList = "select * from blogboard order by seq desc";
	
	// 글 등록
	public void insertBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insert 기능 수행");
		jdbcTemplate.update(myINSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
		// 아래의 주석처리 코드는 순수 JDBC에서만 사용되던 코드
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(myINSERT);
//			stmt.setString(1, vo.getTitle());
//			stmt.setString(2, vo.getWriter());
//			stmt.setString(3, vo.getContent());
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			JDBCUtil.close(stmt, conn);
//		}
	}
	// 글 수정
	public void updateBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC로 update 기능 수행");
		jdbcTemplate.update(myUpdate, vo.getTitle(), vo.getContent(),vo.getSeq());
		// 아래의 주석처리 코드는 순수 JDBC에서만 사용되던 코드
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(myUpdate);
//			stmt.setString(1, vo.getTitle());
//			stmt.setString(2, vo.getContent());
//			stmt.setInt(3, vo.getSeq());
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			JDBCUtil.close(stmt, conn);
//		}
	}
	// 글 삭제
	public void deleteBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC로 delete 기능 수행");
		jdbcTemplate.update(myDelete, vo.getSeq());
		// 아래의 주석처리 코드는 순수 JDBC에서만 사용되던 코드
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(myDelete);
//			stmt.setInt(1, vo.getSeq());
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			JDBCUtil.close(stmt, conn);
//		}
	}
	// 원하는 글 가져오기
	public BoardVO getBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC로 get 기능 수행");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(myGet, args, new BoardRowMapper());
		// 아래의 주석처리 코드는 순수 JDBC에서만 사용되던 코드
//		BoardVO board = null;
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(myGet);
//			stmt.setInt(1, vo.getSeq());
//			rs = stmt.executeQuery();
//			if(rs.next()) {
//				board = new BoardVO();
//				board.setSeq(rs.getInt("SEQ"));
//				board.setTitle(rs.getString("TITLE"));
//				board.setWriter(rs.getString("WRITER"));
//				board.setContent(rs.getString("CONTENT"));
//				board.setRegDate(rs.getDate("REGDATE"));
//				board.setCnt(rs.getInt("CNT"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			JDBCUtil.close(rs, stmt, conn);
//		}
//		return board;
	}
	// 글 목록 가져오기
	public List<BoardVO> getlistBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getlist 기능 수행");
		return jdbcTemplate.query(myList, new BoardRowMapper());
		// 아래의 주석처리 코드는 순수 JDBC에서만 사용되던 코드
//		java.util.List<BoardVO> boardList = new ArrayList<BoardVO>();
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(myList);
//			rs = stmt.executeQuery();
//			while(rs.next()) {
//				BoardVO board = new BoardVO();
//				board.setSeq(rs.getInt("SEQ"));
//				board.setTitle(rs.getString("TITLE"));
//				board.setWriter(rs.getString("WRITER"));
//				board.setContent(rs.getString("CONTENT"));
//				boardList.add(board);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			JDBCUtil.close(rs, stmt, conn);
//		}
//		return boardL ist;
	}
	
	// JdbcTemplate 객체로 받아오는 정보를 활용할 수 있는 형태로 바꾸어서 VO 객체에 사용할 수 있도록 넣어주는 역할을 하는 클래스
	class BoardRowMapper implements RowMapper<BoardVO>{
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException{
			BoardVO board = new BoardVO();
			board.setSeq(rs.getInt("SEQ"));
			board.setTitle(rs.getString("TITLE"));
			board.setWriter(rs.getString("WRITER"));
			board.setContent(rs.getString("CONTENT"));
			return board;
		}
	}
	
	
	
}
