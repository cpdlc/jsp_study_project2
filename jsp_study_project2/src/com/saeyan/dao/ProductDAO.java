package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	public void insertProduct(ProductVO pVo)throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into product(name,price,pictureurl,description,code) values(?,?,?,?,?)";
		
		pVo = new ProductVO();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureurl());
			pstmt.setString(4, pVo.getDescription());
			pstmt.setInt(5, pVo.getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, null);
			
		}
		
		
	}
	
	
	
	
	//상품수정
	public void updateProduct(ProductVO pVo)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update product set name=?,price=?,pictureurl=?,description=? where code=? ";
		
		pVo = new ProductVO();
		
		
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
			DBManager.close(conn, pstmt, null);
		}
	}
}
