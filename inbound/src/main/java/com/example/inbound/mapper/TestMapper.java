package com.example.inbound.mapper;

import java.util.List;
import java.util.Map;

import com.example.inbound.model.UserVO;

public interface TestMapper {
	
	public List<UserVO> selectUser() throws Exception;
	
	public int insertUser(UserVO userVO)throws Exception; 
}
