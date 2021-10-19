package co.yedam.movie;

public class MovieVO {
	private int movie_id;
	private String poster;
	private String title;
	private String genre;
	private String opening_d;
	private String content_m;
	
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getOpening_d() {
		return opening_d;
	}
	public void setOpening_d(String opening_d) {
		this.opening_d = opening_d;
	}
	public String getContent_m() {
		return content_m;
	}
	public void setContent_m(String content_m) {
		this.content_m = content_m;
	}
	
	@Override
	public String toString() {
		return "MovieVO [movie_id=" + movie_id + ", poster=" + poster + ", title=" + title + ", genre=" + genre
				+ ", opening_d=" + opening_d + ", content_m=" + content_m + "]";
	}
	
}
