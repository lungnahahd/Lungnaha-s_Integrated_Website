package com.Lungnaha.IntegratedWebsite.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Lungnaha.IntegratedWebsite.BoardVO;
import com.Lungnaha.IntegratedWebsite.common.JDBCUtil;

// VO(������ �⸰ Ŭ����) �� �̿��ؼ� �������� DB ������ ����ϴ� �ڵ�
@Repository("boardDAO")
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// ���� JDBC�� �̿� ���� ���ϴ� sql���� ���� �ۼ����־�� ��
	private final String myINSERT = "insert into blogboard(title,writer,content) values(?,?,?)";
	private final String myUpdate = "update blogboard set title=?,content=? where seq=?";
	private final String myDelete = "delete blogboard where seq=?";
	private final String myGet = "select * from blogboard where seq=?";
	private final String myList = "select * from blogboard order by seq desc";
	
	// �� ���
	public void insertBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC�� insert ��� ����");
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
	// �� ����
	public void updateBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC�� update ��� ����");
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
	// �� ����
	public void deleteBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC�� delete ��� ����");
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
	// ���ϴ� �� ��������
	public BoardVO getBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC�� get ��� ����");
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
	// �� ��� ��������
	public List<BoardVO> getlistBlogBoard(BoardVO vo) {
		System.out.println("===> JDBC�� getlist ��� ����");
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