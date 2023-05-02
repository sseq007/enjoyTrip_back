<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ include file="/WEB-INF/views/template/header.jsp" %><!-- [S] content -->
<div class="container">
    <div>
        <h2 style="font-family: 'Black Han Sans', sans-serif; opacity: 75%; font-size: 50px" class="m-0 mt-5">여행 정보 공유</h2>
        <hr class="mb-3 mt-0" align="left" style="border: solid 3px brown; width: 50%" />
    </div>
    <div>
        <p style="font-family: 'Noto Sans KR', sans-serif; opacity: 75%">직접 다녀왔던 여행지 중 좋았던 곳에 대한 정보를 공유해 주세요!</p>

        <div class="col-lg-8 col-md-12 col-sm-12 align-self-end">
          <div class="row">
			<div class="col-md-7">
              <form class="d-flex" id="form-search" action="">
                <input type="hidden" name="action" value="list"/>
                <input type="hidden" name="pgno" value="1"/>
                <button id="btn-sortHit" class="btn btn-dark ms-1 me-1 w-50" type="button">
                <a href="${root }/board/sharetravel/sortHit" style="background-color: transparent; color: #fff; text-decoration-line: none">인기순 정렬</a></button>
                <button id="btn-sortNum" class="btn btn-dark ms-1 me-1 w-50" type="button">
                <a href="${root }/board/sharetravel/sortNum" style="background-color: transparent; color: #fff; text-decoration-line: none">번호순 정렬</a></button>
                <select
                  name="key"
                  id="key"
                  class="form-select form-select-sm ms-5 me-1 w-50"
                  aria-label="검색조건"
                >
                  <option selected>검색조건</option>
                  <option value="article_no">글번호</option>
                  <option value="subject">제목</option>
                  <option value="user_id">작성자</option>
                </select>
                <div class="input-group input-group-sm">
                  <input type="text" name="word" id="word" class="form-control" placeholder="검색어..." />
                  <button id="btn-search" class="btn btn-dark" type="button">검색</button>
                </div>
              </form>
            </div>
           </div>
         </div>
        <table class="table">
            <thead>
                <tr class="text-center">
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${sharetravels }" var="board">
            	<tr class="text-center">
                    <th>${ board.articleNo}</th>
                    <th>
                        <a href="${root}/board/sharetravel/view/${board.articleNo}" style="text-decoration-line: none; color: #000">
						${ board.subject}
						</a>
                    </th>
                    <th>${ board.userId}</th>
                    <th>${ board.hit}</th>
                    <th>${ board.registerTime}</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <c:if test="${userinfo ne null}">
    <button type="button" class="btn btn-outline-secondary" style="float: right">
        <a href="${root }/board/sharetravel/write" style="background-color: transparent; color: #000; text-decoration-line: none">글쓰기</a>
    </button>
    </c:if>
    <div class="row">
    	${navigation.navigator} 
    </div>
    <!--  
    <div class="d-flex justify-content-center">
        <ul class="pagination">
            <li class="page-ite m">
                <a class="page-link" href="#" style="background-color: transparent; color: #000">처음</a>
            </li>
            <li class="page-ite m">
                <a class="page-link" href="#" style="background-color: transparent; color: #000">이전</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#" style="background-color: transparent; color: #000">1</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="#" style="background-color: transparent; color: #000">다음</a>
            </li>
            <li class="page-ite m">
                <a class="page-link" href="#" style="background-color: transparent; color: #000">끝</a>
            </li>
        </ul>
    </div>
     -->
</div>
    <form id="form-param" method="get" action="" >
      <input type="hidden" id="p-action" name="action" value="" >
      <input type="hidden" id="p-pgno" name="pgno" value="">
      <input type="hidden" id="p-key" name="key" value="">
      <input type="hidden" id="p-word" name="word" value="">
    </form>
    <script>
      document.querySelector("#btn-search").addEventListener("click", function () {
    	  let form = document.querySelector("#form-search");
          form.setAttribute("action", "${root }/board/sharetravel/search");
          form.submit();
      });
      
      let pages = document.querySelectorAll(".page-link");
      pages.forEach(function (page) {
        page.addEventListener("click", function () {
          console.log(this.parentNode.getAttribute("data-pg"));
          document.querySelector("#p-action").value = "list";
       	  document.querySelector("#p-pgno").value = this.parentNode.getAttribute("data-pg");
       	  document.querySelector("#p-key").value = "${param.key}";
       	  document.querySelector("#p-word").value = "${param.word}";
          document.querySelector("#form-param").submit();
        });
      });
    </script>

<!-- [E] content -->
<%@ include file="/WEB-INF/views/template/footer.jsp" %>
