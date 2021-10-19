package co.yedam.movie;

public class UserVO {

	private String userId;
	private String userPw;
	private String userNick;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	@Override
	public String toString() {
		return "Movie [userId=" + userId + ", userPw=" + userPw + ", userNick=" + userNick + ", toString()="
				+ super.toString() + "]";
	}

}
