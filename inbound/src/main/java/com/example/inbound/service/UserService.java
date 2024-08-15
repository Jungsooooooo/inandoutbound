package com.example.inbound.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inbound.mapper.TestMapper;
import com.example.inbound.model.UserVO;

@Service
public class UserService {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<UserVO> selectUser() throws Exception {
		TestMapper mappers = sqlSession.getMapper(TestMapper.class);
		List<UserVO> vos = mappers.selectUser();
		return vos;
	}
	
	public int insertUser(UserVO userVO) throws Exception {
		TestMapper mappers = sqlSession.getMapper(TestMapper.class);
		
		return	mappers.insertUser(userVO); 
	}
}
