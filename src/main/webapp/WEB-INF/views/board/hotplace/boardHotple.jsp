<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>        
<!-- [S] content -->
<div class="container">
            <div>
                <h2 style="font-family: 'Black Han Sans', sans-serif; opacity: 75%; font-size: 50px"
                    class="m-0 mt-5">
                    핫플 자랑하기
                </h2>
                <hr class="mb-3 mt-0" align="left" style="border: solid 3px brown; width: 50%" />
            </div>
            
            <div>
            	<div>
	           	 <div><p style="font-family: 'Noto Sans KR', sans-serif; opacity: 75%">다녀왔던 여행지 중 좋았던 곳의 사진을 보여 주세요!</p></div>
	           	 <c:if test="${not empty userinfo }"><div><button type="button" class="btn btn-outline-secondary mb-3" style="text-align:right; align-items: right"  onclick="location.href='/board/hotplace/write'">글쓰기</button></div></c:if>
            	</div>            
            <c:forEach var="card" items="${hotplaceList }">
				<div style="text-align:center; width: 280px;  height: 300px; border-style: solid; border-color: #ffb5a7; border-radius: 5%;" display="inline-block">
					<div style="width: 40%; margin-top: 5px; margin-left: 65px; ">
	            	<div><img alt="" src="${root }/upload/${card.imageName}" style="width: 35%; height: 35%; border-radius: 60%; float: left"></div>
	            	<div><p style="font-family: 'Noto Sans KR', sans-serif; opacity: 75%; float:right; padding-top:7px;">${card.userId }</p></div>
            	</div>
					<a><img alt="" src="${root }/upload/${card.imageName}" style="width: 200px; height: 200px;"> </a>
					<%-- <div class="emoti">
						<div calss="favorite">
							<c:choose>
								로그인 상태일 때 -> 하트 클릭되게 함
								<c:when test="${not empty userinfo }">
									<c:choose>
										<c:when test="${empty card.check}">
										빈 하트일 때
											<span> <a idx="${card.articleNo }" href="javascript:"
												class="heart-click heart_icon${card.articleNo }"><svg 
													xmlns="http://www.w3.org/2000/svg" width="16" height="16" 
													fill="currentColor" class="bi bi-suit-heart" viewBox="0 0 16 16">
														<path 
														d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z"/>
														</svg></a>
											</span>
										</c:when>
										<c:otherwise>
											<span><a idx="${card.articleNo }" href="javascript:"
												class="heart-click heart_icon${card.articleNo }"><svg 
													xmlns="http://www.w3.org/2000/svg" width="16" height="16" 
													fill="currentColor" class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
														<path 
															d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z"/>
															</svg></a>
											</span>
										</c:otherwise>
									</c:choose>
								</c:when>
								로그인 상태가 아닐 때 -> 하트 클릭 안 되게 함
								<c:otherwise>
									<span> <a href="javascript:" class="heart-notlogin">
												<svg class="heart3"	xmlns="http://www.w3.org/2000/svg" 
												width="16" height="16" fill="currentColor"
												class="bi bi-suit-heart" viewBox="0 0 16 16">
														<path 
														d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z"/>
														</svg></a>
											</span>
								</c:otherwise>
							</c:choose>
							<span id="heart${card.articleNo }"> ${card.heart_count}</span>
							
							
							모달창 하트 부분
							<c:choose>
							로그인 상태일 때 -> 하트 클릭되게 함
								<c:when test="${not empty userinfo }">
									<c:choose>
										<c:when test="${empty card.check}">
										빈 하트일 때
											<span> <a idx="${card.articleNo }" href="javascript:"
												class="heart-click heart_icon${card.articleNo }"><svg 
													xmlns="http://www.w3.org/2000/svg" width="16" height="16" 
													fill="currentColor" class="bi bi-suit-heart" viewBox="0 0 16 16">
														<path 
														d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z"/>
														</svg></a>
											</span>
										</c:when>
										<c:otherwise>
											<span><a idx="${card.articleNo }" href="javascript:"
												class="heart-click heart_icon${card.articleNo }"><svg 
													xmlns="http://www.w3.org/2000/svg" width="16" height="16" 
													fill="currentColor" class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
														<path 
															d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z"/>
															</svg></a>
											</span>
										</c:otherwise>
									</c:choose>
								</c:when>
								로그인 상태가 아닐 때 -> 하트 클릭 안 되게 함
								<c:otherwise>
									<span> <a href="javascript:" class="heart-notlogin">
												<svg class="heart3"	xmlns="http://www.w3.org/2000/svg" 
												width="16" height="16" fill="currentColor"
												class="bi bi-suit-heart" viewBox="0 0 16 16">
														<path 
														d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z"/>
														</svg></a>
											</span>
								</c:otherwise>
							</c:choose>
							<span id="heart${card.articleNo }"> ${card.heart_count}</span>
						</div> 
						<div class="reply">
						</div>
					</div> --%>
					<div style="font-family: 'Noto Sans KR', sans-serif; opacity: 75%;">
					${card.subject }
					</div>
				</div>
		</c:forEach>
		</div>
</div>

        <!-- [E] content -->
        <%@ include file="/WEB-INF/views/template/footer.jsp" %>
        
        <script type="text/javascript">
/*         	$(document).ready(function(){
        		GetList(1);
        		
        		$(document).on('click', '.card-img, function(){
        			let articleNo = $(this).attr('idx');
        			
        			console.log(articleNo + "에 hit +1을 함");
        			
        			$.ajax({
        				url : 'picture_view.do',
        				type : 'get',
        				data: {
        					no : no
        				},
        				success : function(to){
        					let hit = to.hit;
        					
        					$('#m_hit'+no).text(hit);
        					$('#hit'+no).text(hit);
        				},
        				error: function(){
        					alert('서버 에러');
        				}
        			})
        		}')
        		
        	}); */
        	
        	$(window).resize(function(){
        		$('.box').each(function(){
        			$(this).height($(this).width());
        		});
        	}).resize();
        	
/*         	$(".heart-click").click(function(){
        		let articleNo = $(this).attr('idx');
        		console.log("heart-click");
        		
        		if($(this).children('svg').attr('class') == "bi bi-suit-heart"){
        			console.log("빈하트 클릭" + articleNo);
        			
        			$.ajax({
        				url : 'saveHeart.do',
        				type : 'get',
        				data: {
        					articleNo : articleNo,
        				},
        				succeess : function(hto){
        					let heart = hto.heart;
        					$('#m_heart'+articleNo).text(heart);
        					$('#heart'+articleNo).text(heart);
        					
        					console.log("하트 추가 성공");
        				},
        				error : function(){
        					alert('서버 에러');
        				}
        			});
        			console.log("빈 하트 -> 꽉 찬 하트");
        			
        			$(this).html('<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" 
								fill="currentColor" class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
									<path 
										d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z"/>
										</svg>');
        			$('.heart_icon'+articleNo).html('<svg 
							xmlns="http://www.w3.org/2000/svg" width="16" height="16" 
								fill="currentColor" class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
									<path 
										d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z"/>
										</svg>');
        		}else if($(this).children('svg').attr('class') == "bi bi-suit-heart-fill"){
        			console.log("꽉 찬 하트 클릭" + articleNo);
        			
        			$.ajax({
        				url: 'removeHeart.do',
        				type: 'get',
        				data: {
        					articleNo : articleNo,
        				},
        				success : function(hto){
        					let heart = hto.heart;
        					
        					$('#m_heart'+articleNo).text(heart);
        					$('#heart'+no).text(heart);
        					
        					console.log("하트 삭제 성공");
        				},
        				error : function(){
        					alert('서버 에러');
        				}
        			});
        			console.log("꽉 찬 하트 -> 빈 하트");
        			
        			
        			$(this).html('<svg xmlns="http://www.w3.org/2000/svg" 
							width="16" height="16" fill="currentColor"
							class="bi bi-suit-heart" viewBox="0 0 16 16">
									<path 
									d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z"/>
									</svg>');
        			$('.heart_icon'+articleNo).html('<svg xmlns="http://www.w3.org/2000/svg" 
							width="16" height="16" fill="currentColor"
							class="bi bi-suit-heart" viewBox="0 0 16 16">
									<path 
									d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595L8 6.236zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z"/>
									</svg>');

        		}
        			
        		
        		
        	});
        	
        	$(".heart-notlogin").unbind('click');
            $(".heart-notlogin").click(function(){
            	alert('로그인 후 이용해 주세요');
            }); */
        </script>

