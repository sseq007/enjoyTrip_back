<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String root = request.getContextPath();
request.setAttribute("root", root);
%>

<!-- 로그인 기능 탑재 -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />

<link rel="stylesheet"
	href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css" />

<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Noto+Sans+KR:wght@500&display=swap"
	rel="stylesheet" />

<link rel="stylesheet" href="${root }/assets/css/style.css" />
<link rel="stylesheet" href="${root }/assets/css/index_style.css" />

<link rel="icon" href="${root }/assets/img/logo.ico" type="image/x-icon"
	sizes="16x16" />
<script type="text/javascript" src="${root }/assets/js/data.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<title>Blossom Trip</title>
</head>

<body class="d-flex flex-column min-vh-100">
	<!-- [S] navbar -->
	<nav class="navbar navbar-expand-lg fixed-top">
		<div class="container">
			<!-- main logo -->
			<a class="navbar-brand link-primary fw-bold fs-3"
				href="${root }/index.jsp" style="width: 50px"> <img
				style="width: 100%" src="${root }/assets/img/logo.png" alt="" />
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item py-2" style="opacity: 80%"><i
						class="fi fi-rr-marker ps-3"></i> <a class="nav-link active ps-0"
						aria-current="page" href="${root }/board?action=mvlocation"
						style="display: inline"><p
								style="font-family: 'Noto Sans KR', sans-serif; opacity: 70%; display: inline">지역별여행지</p></a>
					</li>
					<li class="nav-item py-2" style="opacity: 80%"><i
						class="fi fi-rr-calendar ps-3"></i> <a
						class="nav-link active ps-0" aria-current="page"
						href="${root }/board?action=mvplan" style="display: inline"><p
								style="font-family: 'Noto Sans KR', sans-serif; opacity: 70%; display: inline">나의여행계획</p></a>
					</li>

					<li class="nav-item py-2" style="opacity: 80%"><i
						class="fi fi-rr-heart ps-3"></i> <a class="nav-link active ps-0"
						aria-current="page" href="${root }/board?action=mvhotple"
						style="display: inline"><p
								style="font-family: 'Noto Sans KR', sans-serif; opacity: 70%; display: inline">핫플자랑하기</p></a>
					</li>
					<li class="nav-item py-2" style="opacity: 80%"><i
						class="fi fi-rr-paper-plane ps-3"></i> <a
						class="nav-link active ps-0" aria-current="page"
						href="${root }/board?action=mvinfo&pgno=1&key=&word="
						style="display: inline"><p
								style="font-family: 'Noto Sans KR', sans-serif; opacity: 70%; display: inline">여행정보공유</p></a>
					</li>
				</ul>

				<!-- 로그인이 되어 있지 않다면 -->
				<c:if test="${empty userinfo}">
					<div id="header_nav_confirm_off" style="display: contents">
						<ul class="navbar-nav mb-2 mb-lg-0">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> <i
									class="fi fi-rr-lock ps-3 fs"></i>
							</a>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item" href="#"
										data-bs-toggle="modal" data-bs-target="#loginModal">로그인</a></li>
									<li><a class="dropdown-item" href="#"
										data-bs-toggle="modal" data-bs-target="#signUpModal">회원가입</a>
									</li>
								</ul></li>
						</ul>
					</div>
				</c:if>

				<!-- 로그인이 되어 있다면 -->
				<c:if test="${not empty userinfo}">
					<div id="header_nav_confirm_on">
						<ul class="navbar-nav mb-2 mb-lg-0">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> <i
									class="fi fi-rr-unlock"></i>
							</a>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item"
										href="${root }/user?action=logout">로그아웃</a></li>
									<li><a class="dropdown-item"
										href="${root }/user?action=mvMyPage">마이 페이지</a></li>
								</ul></li>
						</ul>
					</div>
				</c:if>
			</div>
		</div>
	</nav>
	<!-- [E] navbar -->

	<!-- [S] login modal-->
	<div class="modal fade" id="loginModal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">
						<i class="fi fi-rr-lock ps-3 fs">Login</i>
					</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal Body -->
				<div class="modal-body">
					<form action="" id="login-form" class="was-validated" method="post">
						<input type="hidden" name="action" value="login" />
						<div class="mb-3 mt-3">
							<label for="id" class="form-label">ID:</label>
							<%
							String c = "";

							Cookie[] cookies = request.getCookies();
							if (cookies != null) {
								for (Cookie cookie : cookies) {
									if ("ssafy_id".equals(cookie.getName())) {
								c = cookie.getValue();
								break;
									}
								}
							}
							%>
							<input type="id" class="form-control" id="login-id"
								name="login-id" placeholder="Enter ID" value="<%=c%>" required />
							<div class="valid-feedback">Valid.</div>
							<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="mb-3">
							<label for="pw" class="form-label">Password:</label> <input
								type="password" class="form-control" id="login-pw"
								name="login-pw" placeholder="Enter password" required />
							<div class="valid-feedback">Valid.</div>
							<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="form-check mb-3">
							<label class="form-check-label"> <input
								class="form-check-input" type="checkbox" name="save-id"
								id="save-id" value="ok" /> 아이디 저장
							</label>
						</div>
					</form>
				</div>

				<!-- Modal Footer -->
				<div class="modal-footer">
					<button type="submit" id="btn-login"
						class="btn btn-outline-secondary">로그인</button>
					<button type="button" class="btn btn-outline-secondary">아이디
						찾기</button>
					<button type="button" class="btn btn-outline-secondary">비밀번호
						찾기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- [E] login modal-->

	<!-- [S] sign up modal-->
	<div class="modal fade" id="signUpModal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">
						<i class="fi fi-rr-lock ps-3 fs"> Sign Up</i>
					</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal Body -->
				<div class="modal-body">
					<form action="" class="was-validated" method="post" id="join-form">
						<!-- <input type="hidden" name="action" value="join" /> -->
						<div class="mb-3 mt-3">
							<label for="name" class="form-label">이름:</label> <input
								type="text" class="form-control" id="name"
								placeholder="Enter name" name="regi-name" required />
							<div class="valid-feedback">Valid.</div>
							<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="mb-3">
							<label for="id" class="form-label">ID:</label> <input type="text"
								class="form-control" id="id" placeholder="Enter ID"
								name="regi-id" required />
							<div class="valid-feedback">Valid.</div>
							<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="mb-3">
							<label for="pw" class="form-label">Password:</label> <input
								type="password" class="form-control" id="pw"
								placeholder="Enter password" name="regi-pw" required />
							<div class="valid-feedback">Valid.</div>
							<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="mb-3">
							<label for="pwCheck" class="form-label">Password check:</label> <input
								type="password" class="form-control" id="pwCheck"
								placeholder="비밀번호 확인" name="regipw-check" required />
							<div class="valid-feedback">Valid.</div>
							<div class="invalid-feedback">Please fill out this field.</div>
						</div>
						<div class="form-row align-items-center">
							<div class="col-sm-10 my-1">
								<label class="form-label" for="emailId">Email:</label>
								<div class="input-group">
									<input type="text" class="form-control" id="emailId"
										name="regi-email-id" placeholder="이메일 아이디" required />
									<div class="input-group-prepend">
										<div class="input-group-text">@</div>
									</div>
									<select id="emailDomain" name="regi-email-domain"
										class="form-control">
										<option selected>도메인 선택</option>
										<option value="naver">naver.com</option>
										<option value="google">gmail.com</option>
										<option value="daum">daum.net</option>
										<div class="valid-feedback">Valid.</div>
										<div class="invalid-feedback">Please check this field.</div>
									</select>
								</div>
							</div>
						</div>
					</form>
				</div>

				<!-- Modal Footer -->
				<div class="modal-footer">
					<button type="button" id="btn-mv-join"
						class="btn btn-outline-secondary">회원가입</button>
				</div>
			</div>
		</div>
	</div>
	<!-- [E] sign up modal-->

	<div style="height: 77px"></div>

	<script type="text/javascript">
            document.querySelector('#btn-login').addEventListener('click', function () {
                if (!document.querySelector('#login-id').value) {
                    alert('아이디 입력');
                    return;
                } else if (!document.querySelector('#login-pw').value) {
                    alert('비밀번호 입력');
                    return;
                } else {
                    let form = document.querySelector('#login-form');
                    form.setAttribute('action', '${root }/user');
                    form.submit();
                }
            });

            document.querySelector('#btn-mv-join').addEventListener('click', function () {
                // location.href = '${root }/user?action=join';
                if(document.querySelector("#pwCheck").value != document.querySelector("#pw").value){
                	alert("비밀번호를 다시 확인해 주세요")
                	return
                }else{
                	let form = document.querySelector('#join-form');
                    form.setAttribute('action', '${root }/user?action=join');
                    console.log('hleo');
                    form.submit();
                } 
            });
        </script>
</body>
</html>
