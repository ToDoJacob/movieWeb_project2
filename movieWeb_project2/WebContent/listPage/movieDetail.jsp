<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<!-- Goggle Font -->
<link
	href='https://fonts.googleapis.com/css?family=Lato:400,700,900,300'
	rel='stylesheet' type='text/css'>

<!-- Font Css -->
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" type="text/css" href="css/style.css">

<!-- Animation Css -->
<link rel="stylesheet" href="css/animate.css">

<link href="css/main.css" rel="stylesheet" type="text/css" />
<title>Document</title>
<style>
* {
	background-color: black;
	color: white;
	text-align: center;
}

img {
	margin-right: 30px;
}

li {
	text-align: left;
}

#form-commentInfo {
	width: 100%;
}

#comment-count {
	margin-bottom: 10px;
}

#comment-input {
	width: 50%;
	height: 3.3em;
}

#submit {
	background-color: rgb(255, 0, 0);
	width: 5.5em;
	height: 3.3em;;
	font-size: 15px;
	font-weight: bold;
	color: aliceblue;
}

#voteUp, #voteDown {
	width: 3.5em;
	height: 1.9em;
	background-color: aqua;
}

#comments {
	margin-top: 10px;
}

.eachComment {
	width: 50%;
	margin: 10px;
	padding: 0.5em;
	border-bottom: 1px solid #c1bcba;
}

.eachComment .name {
	font-size: 1.5em;
	font-weight: bold;
	margin-bottom: 0.3em;
	display: flex;
	justify-content: space-between;
}

.eachComment .inputValue {
	font-size: 1.2em;
	font-style: italic;
}

.eachComment .time {
	font-size: 0.7em;
	color: #c1bcba;
	font-style: oblique;
	margin-top: 0.5em;
	margin-bottom: 0.5em;
}

.eachComment .voteDiv {
	display: flex;
	justify-content: flex-end;
}

.eachComment .deleteComment {
	background-color: red;
	color: aliceblue;
}

#showTrailer {
	position: relative;
	right: 145px;
}
</style>
</head>

<body>

	<ul class="menu">
		<li id="login"
			style="margin-left: 180px; margin-top: 35px; float: left; z-index: 1;"><a
			href="listPage.html">?????? ??????</a></li>
	</ul>

	<form id="frm" method="POST">
		<!-- new movie -->
		<section id="new_movie">
			<div class="container">
				<div class="row">
					<div class="new"></div>
					<hr>
					<div id="form-commentInfo">
						<input id="comment-input" placeholder="????????? ????????? ?????????.">
						<button id="submit">??????</button>
					</div>
				</div>
				<div id=comments></div>

			</div>
			</div>
		</section>
	</form>
</body>

<script>
<%String movieId = request.getParameter("movieId");%>
//movieDetail.jsp?movieId=3
let  movieId= '<%=movieId%>';

	//comment $()
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', '../CommentServlet?movieId=' + movieId);
	xhtp.send();
	xhtp.onload = function() {

		let comments = JSON.parse(xhtp.responseText);
		console.log(comments);

		let list = document.querySelector('#form-commentInfo');

		for (let i = 0; i < comments.length; i++) {
			list.appendChild(createCommentDiv(comments[i]));
		}
		
	}
	
	
	//movie
	
	let xhtp2 = new XMLHttpRequest();
	xhtp2.open('get', '../MovieServlet');
	xhtp2.send();
	xhtp2.onload = function() {
		console.log(movieId);
		let movies = JSON.parse(xhtp2.responseText);
		console.log(movies);

		let list = document.querySelector('div.new');
		for (let i = 0; i < movies.length; i++) {
			if (movies[i].movie_id == movieId) {
				list.appendChild(createTitleDiv(movies[i]));
				list.appendChild(createContentDiv(movies[i]));
			}
		}
	}
	function createCommentDiv(comment) {
		console.log(comment);
		let div = document.createElement('div');
		div.setAttribute('class', 'comment-count');
		div.innerHTML = '??????: ' + comment.coment;

		return div;
	}

	function createTitleDiv(movie) {
		let div = document.createElement('div');
		div.setAttribute('class', 'new_left')

		let innerDiv = document.createElement('div');
		innerDiv.setAttribute('class', 'play');
		innerDiv.setAttribute('id', 'showTrailer');
		innerDiv.setAttribute('data-youtube', 'cvdxDZbdLsI');

		let img = document.createElement('img');
		img.setAttribute('src', 'images/' + movie.genre + '/' + movie.poster);
		img.setAttribute('height', '400px');

		innerDiv.appendChild(img);
		div.appendChild(innerDiv);

		return div;
	}

	function createContentDiv(movie) {
		let div = document.createElement('div');
		div.setAttribute('class', 'new_right')

		let h3 = document.createElement('h3');
		h3.setAttribute('class', 'title');
		h3.innerHTML = movie.title;

		let span1 = document.createElement('span');
		span1.setAttribute('class', 'icon1');

		let span2 = document.createElement('span');
		span2.setAttribute('class', 'release');
		span2.innerHTML = movie.opening_d.substring(0, 11);

		let ul = document.createElement('ul');
		ul.setAttribute('class', 'summary');

		let liGenre = document.createElement('li');
		liGenre.setAttribute('class', 'genre');

		let spanBar = document.createElement('span');
		spanBar.setAttribute('class', 'bar');
		spanBar.innerHTML = '??????: ' + movie.genre;

		console.log(movie.opening_d);

		let liDesc = document.createElement('li');
		liDesc.setAttribute('class', 'desc');
		liDesc.innerHTML = movie.content_m;

		h3.appendChild(span1);
		div.appendChild(h3);
		div.appendChild(span2);

		liGenre.appendChild(spanBar)
		ul.appendChild(liGenre);
		ul.appendChild(liDesc);
		div.appendChild(ul);

		return div;

	}

	/*
	<div class="new_right">
	<h3 class="title">
		????????????: ????????????<span class="icon1"></span>
	</h3>
	<span class="release">2021??? 02??? 24???</span>
	<ul class="summary">
		<li class="genre"><span class="bar">??????: ??????/SF</span></li>
		<li class="desc">2019??? ????????? ????????? ??????????????? ?????????, ?????? ???????????? ?????? ??????
			???????????? ?????? ?????????, ?????? ??????????????? ????????????, ?????? ????????? ??????????????? ?????? ???????????? ???????????????. ??? ?????????
			2012??? ?????? ???????????????, 2015??? ?????? ????????????: ????????? ?????? ?????????, 2018??? ?????? ????????????: ????????????
			?????? ?????? ?????? ????????? ???????????? ???????????????, ?????? ???????????? ???????????? (MCU)??? 22?????? ????????? ????????????. ?????????
			????????? ??? ????????? ???????????? ??????????????? ???????????? ????????? ???????????? ???????????? ????????? ?????????, ????????? MCU ??????????????????
			?????? ????????? ????????? ??????????????? ????????????.</li>
	</ul>
	</div>*/
</script>

</html>