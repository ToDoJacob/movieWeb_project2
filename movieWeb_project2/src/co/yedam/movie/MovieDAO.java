package co.yedam.movie;

import java.sql.SQLException;

public class MovieDAO extends DAO {

	//추후에 관리자 계정으로 영화 포스터랑 영화정보 업로드하는 기능에 쓸것.
	public void insertMovie(int movie_id, String poster, String title, String genre, String opening_d, String content_m) {
		connect();
		String sql = "insert into movie (movie_id, poster, title, genre, opening_d, content_m) values(?, ?, ?, ?, ?, ?)";
					
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, movie_id);
			psmt.setString(2, poster);
			psmt.setString(3, title);
			psmt.setString(4, genre);
			psmt.setString(5, opening_d);
			psmt.setString(6, content_m);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
			
			MovieVO vo = new MovieVO();
			vo.setMovie_id(movie_id);
			vo.setPoster(poster);
			vo.setTitle(title);
			vo.setGenre(genre);
			vo.setOpening_d(opening_d);
			vo.setContent_m(content_m);
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//영화 data 가지고오는 메소드
	public void getMovie() {
		
	}
}
