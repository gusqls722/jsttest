package com.jspt.test.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	public List<Map<String, String>> selectBoardList(String searchType, String searchStr);
}
