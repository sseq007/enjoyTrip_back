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
        <h3 style="font-family: 'Black Han Sans', sans-serif; opacity: 75%; font-size: 38px" class="m-0 mt-5">${sharetravels.subject}</h3>

        <div class="row mb-5">
            <div class="col-lg-2">
                <img src="${root }/assets/img/img.jpg" style="width: 100%" alt="프로필이미지" />
            </div>
            <div class="col-lg-10">
            	<input type="hidden"  id="ano"  value=" ${sharetravels.articleNo}"/>
                <h3 >작성자 : ${sharetravels.userId}</h3>
                <p>작성일 : ${sharetravels.registerTime}</p>
                <p>조회수 : ${sharetravels.hit}</p>
            </div>
        </div>
        <div>
        	${sharetravels.content}
        </div>
       
<div class="card">
		<form>
			<input type="hidden" id="userId" value="1"/>
			<input type="hidden"  id="boardId"  value=" ${sharetravels.articleNo}"/>
			<div class="card-body">
				<textarea id="reply-content" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer">
				<button type="button"  id="btn-reply-save" class="btn btn-primary">등록</button>
			</div>
		</form>
	</div>
	<br />
	<div class="card">
		<div class="card-header">댓글 리스트</div>
		<ul id="reply-box" class="list-group">
			<c:forEach var="reply" items="${sharereply}">
				<li id="reply-${reply.replyNo}" class="list-group-item d-flex justify-content-between">
					<div>${reply.content}</div>

					<div class="d-flex">
						<div class="font-italic">작성자 : ${reply.userId} &nbsp;</div>
						<c:if test="${reply.userId ==userinfo.userId}">
								<button onClick="index.replyDelete(${reply.articleNo},${reply.replyNo})" class="badge">삭제</button>
						</c:if>
					</div>
				</li>
			</c:forEach>

		</ul>
	</div>
        <!-- button -->
        <div class="col text-center">
            <button type="button" class="btn btn-outline-secondary" onclick="location.href='${root }/board/sharetravel/list'">글목록</button>
            
           <c:if test="${sharetravels.userId ==userinfo.userId}">
            <button type="button" class="btn btn-outline-secondary" onclick="location.href='${root }/board/sharetravel/updateForm/${sharetravels.articleNo}'">글수정</button>
            <button type="button"  id = "btn-delete"class="btn btn-outline-secondary" >글삭제</button>
            </c:if>
        </div>
    </div>
</div>

<script>
//     function deleteConfirm() {
//         var answer;
//         answer = confirm('데이터를 삭제하시겠습니까?');
//         if (answer == true) {
//             window.location = '${root }/board/sharetravel/delete?articleNo=${shareTravelBoard.articleNo}';
//         }
//     }
</script>

<!-- [E] content -->
<script src="/assets/js/sharetravel.js"></script>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>
