package com.Lungnaha.IntegratedWebsite.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Lungnaha.IntegratedWebsite.UserVO;

// ȸ�� ���� DAO Ŭ���� -> Database ����
@Repository("userDAO")
public class UserDAO {
	// ���⼭�� BoardDAO�� ���������� JdbcTemplate ����غ���
	@Autowired // ������ <bean> ����߱⿡ ������ �� �ִ� ��
	private JdbcTemplate jdbcTemplate; // ���� JDBC�� �ƴ� JdbcTemplate�� Ȱ���ؼ� DB ó���ϱ� ���� ����ϴ� ��ü
	

	

	
	
	private final String myUserGet = "select * from users where id=?";
	private final String mySignUp = "insert into users(id,password,name,role) values(?,?,?,?)";
	
	
	// �α��� ���
	public UserVO getUser(UserVO vo) {
		System.out.println("=======> Jdbc Ȱ�� �α��� ��� ����");
		Object[] args = {vo.getId()};
		try {
			UserVO user = jdbcTemplate.queryForObject(myUserGet, args, new UserRowMapper());
			return user;
		} catch (Exception e) {
			System.out.println("���� �߻�");
			return null;
		}
		
		//return jdbcTemplate.queryForObject(myUserGet, args, new UserRowMapper());
	}
	
	// ȸ�� ���� ���
	public void signUp(UserVO vo) {
		System.out.println("========> ȸ�� ���� ��� ����");
		jdbcTemplate.update(mySignUp, vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());
		
	}
	
	
	
	
	
	 //JdbcTemplate ��ü�� �޾ƿ��� ������ Ȱ���� �� �ִ� ���·� �ٲپ VO ��ü�� ����� �� �ֵ��� �־��ִ� ������ �ϴ� Ŭ����
	public	class UserRowMapper implements RowMapper<UserVO>{
			public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				UserVO user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				return user;
			}
	}
//	public UserVO mapRow(ResultSet rs, int count) throws SQLException {
//		UserVO user = new UserVO();
//		user.setId(rs.getString("ID"));
//		user.setPassword(rs.getString("PASSWORD"));
//		user.setName(rs.getString("NAME"));
//		user.setRole(rs.getString("ROLE"));
//		return user;
//	}
}
