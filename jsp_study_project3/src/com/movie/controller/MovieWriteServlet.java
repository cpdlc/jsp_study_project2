package com.movie.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.movie.dao.MovieDAO;
import com.movie.dto.MemberVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MovieWriteServlet
 */
@WebServlet("/moviewrite.do")
public class MovieWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("movieWrite.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uploadFileSizeLimit = 10*1024*1024;	//최대 업로드 파일 크기 5MB로 제한
		String encType = "utf-8";
		
		ServletContext context = getServletContext();	//페이지에 대한 실행 환경 정보를 얻어옴
		String uploadFilePath = context.getRealPath("upload");	//업로드하여 저장할
		
		
			MultipartRequest multi=new MultipartRequest(
					request,							//request객체
					uploadFilePath,						//서버상의 실제 저장 디렉토리
					uploadFileSizeLimit,				//최대 업로드 파일크기
					encType,							//인코딩방법
					new DefaultFileRenamePolicy());		//업로드시킨 파일이 동일한 이름이 존재하면 새로운 이름 부여됨
		
		String title = multi.getParameter("title");
		String price = multi.getParameter("price");
		String director = multi.getParameter("director");
		String actor = multi.getParameter("actor");
		String synopsis = multi.getParameter("synopsis");
		String poster = multi.getFilesystemName("poster");
		
		MemberVO vo = new MemberVO();
		
		vo.setTitle(title);
		vo.setPrice(Integer.parseInt(price));
		vo.setDirector(director);
		vo.setActor(actor);
		vo.setSynopsis(synopsis);
		vo.setPoster(poster);
		
		MovieDAO dao = MovieDAO.getMovieDAO();
		dao.movieWrite(vo);
		
		response.sendRedirect("movielist.do");
		
	}

}
