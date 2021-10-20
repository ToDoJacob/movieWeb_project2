package co.yedam.movie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<MovieVO> getMovieList() {
		connect();
		List<MovieVO> list = new ArrayList<>();
		String sql = "select * from movie order by movie_id";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			//psmt
//			psmt = conn.prepareStatement("select * from movie order by 1");
//			rs = psmt.executeQuery();
			
			while(rs.next()) {
			MovieVO movie = new MovieVO();
			movie.setMovie_id(rs.getInt("movie_id"));
			movie.setPoster(rs.getString("poster"));
			movie.setTitle(rs.getString("title"));
			movie.setGenre(rs.getString("genre"));
			movie.setOpening_d(rs.getString("opening_d"));
			movie.setContent_m(rs.getString("content_m"));
			list.add(movie);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
		
	}
}
