package com.jspt.test.service.impl;

import java.util.List;
import java.util.Map;

import com.jspt.test.dao.BoardDAO;
import com.jspt.test.dao.impl.BoardDAOImpl;
import com.jspt.test.service.BoardService;

public class BoardServiceImpl implements BoardService {

	private BoardDAO bdao = new BoardDAOImpl();
	
	@Override
	public List<Map<String, String>> selectBoardList(String searchType, String searchStr) {
		return bdao.selectBoardList(searchType, searchStr);
	}

}
