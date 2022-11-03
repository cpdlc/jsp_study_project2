package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.dto.MemberVO;
import com.movie.util.DBManager;

public class MovieDAO {

	private MovieDAO() {
		
	}
	
	private static MovieDAO Instance = new MovieDAO();
	
	public static MovieDAO getMovieDAO() {
		return Instance;
	}
	
	//리스트 가져오기
	
	public List<MemberVO> getMemberList(){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from movie order by code desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			
			while(rs.next()) {
				
				MemberVO vo = new MemberVO();
				
				vo.setCode(rs.getInt("code"));
				vo.setTitle(rs.getString("title"));
				vo.setPrice(rs.getInt("price"));
				vo.setDirector(rs.getString("director"));
				vo.setActor(rs.getString("actor"));
				vo.setPoster(rs.getString("poster"));
				vo.setSynopsis(rs.getString("synopsis"));
				
				list.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//영화 정보등록
	
	public void movieWrite(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String title = vo.getTitle();
		int price = vo.getPrice();
		String director = vo.getDirector();
		String actor = vo.getActor();
		String poster = vo.getPoster();
		String synopsis = vo.getSynopsis();
		
		
		String sql = "insert into movie values(seq.nextval,?,?,?,?,?,?)";
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,title);
			pstmt.setInt(2, price);
			pstmt.setString(3, director);
			pstmt.setString(4, actor);
			pstmt.setString(5, poster);
			pstmt.setString(6, synopsis);
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//영화 상세정보 가져오기
	public MemberVO getMember(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from movie where code = ?";
		MemberVO vo = new MemberVO();
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setCode(rs.getInt("code"));
				vo.setTitle(rs.getString("title"));
				vo.setPrice(rs.getInt("price"));
				vo.setDirector(rs.getString("director"));
				vo.setActor(rs.getString("actor"));
				vo.setPoster(rs.getString("poster"));
				vo.setSynopsis(rs.getString("synopsis"));								
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
			
		}
		return vo;
		
		
	}
	
	//영화정보 수정
	public void updateMovie(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		
		String sql = "update movie set title=?,price=?,director=?,actor=?,synopsis=?,poster=? where code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getDirector());
			pstmt.setString(4, vo.getActor());
			pstmt.setString(5, vo.getSynopsis());
			pstmt.setString(6, vo.getPoster());
			pstmt.setInt(7, vo.getCode());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
			
		}
		
		
		
	}
	
	//삭제하기
	
	public void deleteMovie(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from movie where code = ?";
		
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