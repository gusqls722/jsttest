package com.jspt.test.dao;

import java.util.List;
import java.util.Map;

public interface BoardDAO {

	public List<Map<String, String>> selectBoardList(String searchType, String searchStr);
}
