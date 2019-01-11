package com.jspt.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jspt.test.connection.DBConnection;
import com.jspt.test.dao.BoardDAO;

public class BoardDAOImpl implements BoardDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<Map<String, String>> selectBoardList(String searchType, String searchStr) {
		List<Map<String,String>> boardlist = new ArrayList<Map<String,String>>();
		try {
			
			String sql = "select * from ang_board";
			if(searchStr!=null && !searchStr.equals("")) {
				if(searchType=="title") {
					sql += " where title like *?* ";
				}else {
				sql += " where " + searchType +  " = ? ";
				}
			}
			con = DBConnection.openCon();
			ps = con.prepareStatement(sql);
			if(searchStr!=null && !searchStr.equals("")) {
				ps.setString(1, searchStr);
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> boardMap = new HashMap<String, String>();
				boardMap.put("num", rs.getString("num"));
				boardMap.put("title", rs.getString("title"));
				boardMap.put("content", rs.getString("content"));
				boardMap.put("wdate", rs.getString("wdate"));
				boardMap.put("writer", rs.getString("writer"));
				boardMap.put("cnt", rs.getString("cnt"));
				boardlist.add(boardMap);
			}
			return boardlist;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeCon();
		}
		return null;
	}

}
