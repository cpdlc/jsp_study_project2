package com.movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.dao.MovieDAO;
import com.movie.dto.MemberVO;

/**
 * Servlet implementation class MovieDeleteServlet
 */
@WebServlet("/moviedelete.do")
public class MovieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String code = request.getParameter("code");
		
		MovieDAO dao = MovieDAO.getMovieDAO();
		MemberVO vo = dao.getMember(code);
		
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("movieDelete.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		MovieDAO dao = MovieDAO.getMovieDAO();
		dao.deleteMovie(code);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("movielist.do");
		dispatcher.forward(request, response);
		
	}

}
