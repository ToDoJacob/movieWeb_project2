package co.yedam.movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DAO {

	// 회원 업로드
	public UserVO insertUser(String userId, String userPw, String UserNick) {
		connect();
		String sql = "insert into users (user_id, user_pw, user_nick)\r\n" + "values(?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setString(2, userPw);
			psmt.setString(3, UserNick);

			int r = psmt.executeUpdate();
			System.out.println(r + "입력됨.");

			UserVO vo = new UserVO();
			vo.setUserId(userId);
			vo.setUserPw(userPw);
			vo.setUserNick(UserNick);
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			disconnect();
		}
	}

//	// 회원 로그인
//	public String loginUser (String userPw) {
//		connect();
//		try {
//			psmt = conn.prepareStatement("select userId form user where userPw=?");
//			psmt.setString(1, userPw);
//			psmt.executeUpdate();
//			return userPw;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			disconnect();
//		}
//	}

	// 회원 로그인
	public int loginUser(UserVO vo) {
		connect();
		String sql = "SELECT user_pw FROM users WHERE user_id = ?";
		int result = -1;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			rs = psmt.executeQuery();

			if (rs.next()) { // 아이디 존재
				if (rs.getString("user_pw").equals(vo.getUserPw())) {
					result = 1; // 비밀번호 일치
				} else {
					result = 0; // 비밀번호 불일치
				}
			} else { // 아이디가 존재하지 않는다
				result = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
