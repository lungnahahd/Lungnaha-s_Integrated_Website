package com.Lungnaha.IntegratedWebsite.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Lungnaha.IntegratedWebsite.UserVO;

// 회원 관리 DAO 클래스 -> Database 연결
@Repository("userDAO")
public class UserDAO {
	// 여기서도 BoardDAO와 마찬가지로 JdbcTemplate 사용해보기
	@Autowired // 사전에 <bean> 등록했기에 가져올 수 있는 것
	private JdbcTemplate jdbcTemplate; // 순수 JDBC가 아닌 JdbcTemplate을 활용해서 DB 처리하기 위해 사용하는 객체
	

	

	
	
	private final String myUserGet = "select * from users where id=?";
	private final String mySignUp = "insert into users(id,password,name,role) values(?,?,?,?)";
	
	
	// 로그인 기능
	public UserVO getUser(UserVO vo) {
		System.out.println("=======> Jdbc 활용 로그인 기능 시작");
		Object[] args = {vo.getId()};
		try {
			UserVO user = jdbcTemplate.queryForObject(myUserGet, args, new UserRowMapper());
			return user;
		} catch (Exception e) {
			System.out.println("오류 발생");
			return null;
		}
		
		//return jdbcTemplate.queryForObject(myUserGet, args, new UserRowMapper());
	}
	
	// 회원 가입 기능
	public void signUp(UserVO vo) {
		System.out.println("========> 회원 가입 기능 시작");
		jdbcTemplate.update(mySignUp, vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());
		
	}
	
	
	
	
	
	 //JdbcTemplate 객체로 받아오는 정보를 활용할 수 있는 형태로 바꾸어서 VO 객체에 사용할 수 있도록 넣어주는 역할을 하는 클래스
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
