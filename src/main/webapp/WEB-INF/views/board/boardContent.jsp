<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<!-- [S] content -->
<div class="container">
    <div>
        <h2 style="font-family: 'Black Han Sans', sans-serif; opacity: 75%; font-size: 50px" class="m-0 mt-5">여행 정보 공유</h2>
        <hr class="mb-3 mt-0" align="left" style="border: solid 3px brown; width: 50%" />
    </div>

    <!-- 글 내용 -->
    <div class="container-lg">
        <h3 style="font-family: 'Black Han Sans', sans-serif; opacity: 75%; font-size: 38px" class="m-0 mt-5">${shareTravelBoard.subject}</h3>

        <div class="row mb-5">
            <div class="col-lg-2">
                <img src="${root }/assets/img/img.jpg" style="width: 100%" alt="프로필이미지" />
            </div>
            <div class="col-lg-10">
                <h3>작성자 : ${shareTravelBoard.userId}</h3>
                <p>작성일 : ${shareTravelBoard.registerTime}</p>
                <p>조회수 : ${shareTravelBoard.hit}</p>
            </div>
        </div>
        <div>
        	${shareTravelBoard.content}
        </div>

        <!-- button -->
        <div class="col text-center">
            <button type="button" class="btn btn-outline-secondary" onclick="location.href='${root }/board/sharetravel/list'">글목록</button>
            
            <%
				if ("ok".equals(request.getAttribute("sameWriter"))) {
            %>
            <button type="button" class="btn btn-outline-secondary" onclick="location.href='${root }/board/sharetravel/update/article_no=${shareTravelBoard.articleNo}'">글수정</button>
            <button type="button" class="btn btn-outline-secondary" onclick="deleteConfirm()">글삭제</button>
            <%
            	}
            %>
        </div>
    </div>
</div>

<script>
    function deleteConfirm() {
        var answer;
        answer = confirm('데이터를 삭제하시겠습니까?');
        if (answer == true) {
            window.location = '${root }/board/sharetravel/delete?articleNo=${shareTravelBoard.articleNo}';
        }
    }
</script>

<!-- [E] content -->

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
