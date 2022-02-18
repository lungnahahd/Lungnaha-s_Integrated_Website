package com.Lungnaha.IntegratedWebsite.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Lungnaha.IntegratedWebsite.BoardVO;
import com.Lungnaha.IntegratedWebsite.common.JDBCUtil;

// VO(데이터 콰린 클래스) 를 이용해서 실질적인 DB 연동을 담당하는 코드
@Repository("boardDAO")
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// 순수 JDBC는 이와 같이 원하는 sql문을 전부 작성해주어야 함
	private final String myINSERT = "insert into blogboard(title,writer,content) values(?,?,?)";
	private final String myUpdate = "update blogboard set title=?,content=? where seq=?";
	private final String myDelete = "delete blogboard where seq=?";
	private final String myGet = "select * from blogboard where seq=?";
	private final String myList = "select * from blogboard order by seq desc";
	
	// 글 등록
	public void insertBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insert 기능 수행");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(myINSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	// 글 수정
	public void updateBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC로 update 기능 수행");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(myUpdate);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	// 글 삭제
	public void deleteBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC로 delete 기능 수행");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(myDelete);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	// 원하는 글 가져오기
	public BoardVO getBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC로 get 기능 수행");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(myGet);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}
	// 글 목록 가져오기
	public List<BoardVO> getlistBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getlist 기능 수행");
		java.util.List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(myList);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}
	
	
	
}
