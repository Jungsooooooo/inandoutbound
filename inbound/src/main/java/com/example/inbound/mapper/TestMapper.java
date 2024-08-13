package com.example.inbound.mapper;

import java.util.List;

import com.example.inbound.model.UserVO;

public interface TestMapper {
	public List<UserVO> selectUser() throws Exception;
}
