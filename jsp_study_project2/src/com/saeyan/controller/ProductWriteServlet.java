package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;


@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("productWrite.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
request.setCharacterEncoding("utf-8");
		
//		String savePath = "upload"; //여기서 "upload"란 저장할 폴더의 이름.
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

			
			String name = multi.getParameter("name");
			int price = Integer.parseInt(multi.getParameter("price"));
			String pictureurl = multi.getFilesystemName("pictureurl");
			String description = multi.getParameter("description");
			
			
			ProductVO pVo = new ProductVO();
			
			pVo.setName(name);
			pVo.setPrice(price);
			pVo.setPictureurl(pictureurl);
			pVo.setDescription(description);
			
			ProductDAO pDao = ProductDAO.getIncetance();
			pDao.insertProduct(pVo);

			response.sendRedirect("productList.do");
		

	}

}
