<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="board.dto.BoardDto"%> 
<%@ include file="/template/header.jsp" %> 
<% BoardDto boardDto = (BoardDto)
request.getAttribute("article"); System.out.println("content : " + boardDto); %>

<!-- [S] content -->
<div class="container">
    <div>
        <h2 style="font-family: 'Black Han Sans', sans-serif; opacity: 75%; font-size: 50px" class="m-0 mt-5">여행 정보 공유</h2>
        <hr class="mb-3 mt-0" align="left" style="border: solid 3px brown; width: 50%" />
    </div>

    <!-- 글 내용 -->
    <div class="container-lg">
        <h3 style="font-family: 'Black Han Sans', sans-serif; opacity: 75%; font-size: 38px" class="m-0 mt-5"><%= boardDto.getSubject() %></h3>

        <div class="row mb-5">
            <div class="col-lg-2">
                <img src="<%= root %>/assets/img/img.jpg" style="width: 100%" alt="프로필이미지" />
            </div>
            <div class="col-lg-10">
                <h3>작성자 : <%= boardDto.getUserId() %></h3>
                <p>작성일 : <%= boardDto.getRegisterTime() %></p>
                <p>조회수 : <%= boardDto.getHit() %></p>
            </div>
        </div>
        <div>
            <%= boardDto.getContent() %>
            <p>배불러요</p>
            <p style="display: none">우주 최강 악덕 업주 KJH..</p>
            <p style="display: none">คʕ•ﻌ•ʔค</p>
        </div>

        <!-- button -->
        <div class="col text-center">
            <button type="button" class="btn btn-outline-secondary" onclick="location.href='<%= root %>/board?action=mvinfo'">글목록</button>
            
            <%
				if ("ok".equals(request.getAttribute("sameWriter"))) {
            %>
            <button type="button" class="btn btn-outline-secondary" onclick="location.href='<%= root %>/board?action=mvmodify&article_no=<%= boardDto.getArticleNo() %>'">글수정</button>
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
            window.location = '<%= root %>/board?action=delete&articleNo=<%= boardDto.getArticleNo() %>';
        }
    }
</script>

<!-- [E] content -->

<%@ include file="/template/footer.jsp" %>
