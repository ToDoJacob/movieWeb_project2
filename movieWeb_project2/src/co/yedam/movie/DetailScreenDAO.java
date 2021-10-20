package co.yedam.movie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetailScreenDAO extends DAO {

	// 영화 리스트 불러오기
	public List<MovieVO> getProdList() {
		connect();
		List<MovieVO> list = new ArrayList<>();
		String sql = "select * from movie order by 1";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
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


	// 영화 아이디 조회로
	public MovieVO movieSearch(int movieId) {
		connect();
		MovieVO vo = new MovieVO();
		String sql = "select * from movie where movie_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, movieId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMovie_id(rs.getInt("movie_id"));
				vo.setPoster(rs.getString("poster"));
				vo.setTitle(rs.getString("title"));
				vo.setGenre(rs.getString("genre"));
				vo.setOpening_d(rs.getString("opening_d"));
				vo.setContent_m(rs.getString("content_m"));
			}
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}

	}
}
