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

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//상품 수정을 위한 서블릿 매핑
		String code = request.getParameter("code");
		
		ProductDAO pDao = ProductDAO.getIncetance();
		ProductVO pVo = pDao.selectProductByCode(code);
		
		request.setAttribute("product", pVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("productUpdate.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DB에 있는 상품정보 수정을 위한 서블릿
		request.setCharacterEncoding("utf-8");
		
		
		int uploadFileSizeLimit = 10*1024*1024;	//최대 업로드 파일 크기 5MB로 제한
		String encType = "utf-8";
		
		ServletContext context = getServletContext();	//페이지에 대한 실행 환경 정보를 얻어옴
		String uploadFilePath = context.getRealPath("upload");	//업로드하여 저장할
		
		
		MultipartRequest multi=new MultipartRequest(
				request,							//request객체
				uploadFilePath,						//서버상의 실제 저장 디렉토리
				uploadFileSizeLimit,				//최대 업로드 파일크기
				encType,							//인코딩방법
				new DefaultFileRenamePolicy());
			
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		
		String pictureurl = multi.getFilesystemName("pictureurl");
		
		if(pictureurl == null) {
			pictureurl = multi.getParameter("nomakeImg");
		}		

		ProductVO pVo = new ProductVO();
		
		pVo.setCode(Integer.parseInt(code));
		pVo.setName(name);
		pVo.setPrice(price);
		pVo.setDescription(description);
		pVo.setPictureurl(pictureurl);
		
		ProductDAO pDAO = ProductDAO.getIncetance();
		pDAO.updateProduct(pVo);
		
		response.sendRedirect("productList.do");
		
	}

}
