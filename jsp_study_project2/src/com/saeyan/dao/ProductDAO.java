package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;

import util.DBManager;

public class ProductDAO {

	private ProductDAO(){
		
	}
	
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getIncetance() {
		
		return instance;
	}
	
	public List<ProductVO> selectAllProducts() {
		
		String sql="select * from product order by code desc";
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProductVO> list= new ArrayList<ProductVO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ProductVO pVo = new ProductVO();
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureurl(rs.getString("pictureurl"));
				pVo.setDescription(rs.getString("description"));
				
				list.add(pVo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			DBManager.close(conn, pstmt, rs);
			
		}
		return list;
	}
	
	//상품등록
	public void insertProduct(ProductVO pVo){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into product values(product_seq.nextval,?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureurl());
			pstmt.setString(4, pVo.getDescription());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);	
		}
	}
	// 상품 정보 수정을 위한 상품정보 얻어오는 메서드 생성
	public ProductVO selectProductByCode(String code) {
		
		String sql = "select * from product where code = ?";
		ProductVO pVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pVo = new ProductVO();
				pVo.setCode(rs.getInt("code"));
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureurl(rs.getString("pictureurl"));
				pVo.setDescription(rs.getString("description"));
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		return pVo;
	}
	
	//얻어온 상품정보 수정해서 db에 전달하는 메서드
	
	public void updateProduct(ProductVO pVo) {
		
		String sql = "update product set name=?,price=?,pictureurl=?,description=? where code=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureurl());
			pstmt.setString(4, pVo.getDescription());
			pstmt.setInt(5, pVo.getCode());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	//상품 삭제
	public void deleteProduct(String code) {
		String sql = "delete from product where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
			
		}
		
		
	}
	
	
}
