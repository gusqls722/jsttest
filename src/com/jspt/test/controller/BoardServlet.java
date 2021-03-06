package com.jspt.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspt.test.service.BoardService;
import com.jspt.test.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class BoardServlet
 */

public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService  bs = new BoardServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("search_type");
		String searchStr = request.getParameter("search_str");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("list", bs.selectBoardList(searchType, searchStr));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
