package com.vasu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vasu.mapper.LoginRowMapper;
import com.vasu.model.Login;
@Repository
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	JdbcTemplate template;

	public int register(Login login) {
		String sql="INSERT INTO USERS(`first_name`, `last_name`, `email`, `phone`, `username`, `password`)VALUES('"+login.getFirstName()+"','"+login.getLastName()+"','"+login.getEmail()+"','"+login.getMoNo()+"','"+login.getUsername()+"','"+login.getPassword()+"')";
		return template.update(sql);
	}

	public String login(String username, String password) {
		String sql="select first_name from users where username='"+username+"' and password='"+password+"'";
		List<String> users = template.queryForList(sql,String.class);
		if(users.isEmpty()) {
			return null;
		}
		else {
			return users.toString();	
		}
        
	}

}
