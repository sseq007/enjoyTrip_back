<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<!-- [S] content -->
<div class="container">
    <div>
        <h2 style="font-family: 'Black Han Sans', sans-serif; opacity: 75%; font-size: 50px" class="m-0 mt-5">마이 페이지</h2>
        <hr class="mb-3 mt-0" align="left" style="border: solid 3px brown; width: 50%" />
    </div>
    <div style="margin: auto; margin-top: 100px; margin-bottom: 100px; width: 50%; height: auto; border: 3px solid #ffb5a7; border-radius: 10px" class="text-center">
        <nav class="navbar navbar-expand-sm" style="background-color: #ffb5a7; font-family: 'Black Han Sans', sans-serif; opacity: 75%; text-align: center; font-size: 20px">
            <div class="collpase navbar-collapse justify-content-center">
                <ul class="navbar-nav">
                    <li class="nav-item" style="margin-inline: 70px">
                        <a href="javascript:void(0);" onclick="javascript:goModify();" class="nav-link active">회원 정보 수정</a>
                    </li>
                    <li class="nav-item" style="margin-inline: 70px">
                        <a href="javascript:void(0);" onclick="javascript:goDelete();" class="nav-link active">회원 탈퇴</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div id="modifyContents">
            <form action="" style="text-align: left" id="form-update" method="POST" encType="multipart/form-data">
                <div class="m-5">
                    <h2 style="font-family: 'Black Han Sans', sans-serif; opacity: 75%; font-size: 20px; text-align: left" class="m-0 mt-4">회원 정보 수정</h2>
                    <hr class="mb-3 mt-0" align="left" style="border: solid 2px #ffb5a7; width: 30%; opacity: 100%" />
                    <div class="mb-3 mt-3" align="center">
							<div class="userProfile mb-3 mt-3">
								<c:choose>
									<c:when test="${empty user.profileImage}">
										<img src="${root }/assets/img/noimg.jpg" class="profile_image" style="border-radius: 40%; width: 250px; height: 250px">
									</c:when>
									<c:otherwise>
										<img src="${root }/upload/${user.profileImage}" class="profile_image" style="border-radius: 40%; width: 250px; height: 250px">
									</c:otherwise>
								</c:choose>
								
							</div>
							<div>
								<input type="file" id="updateProfile" name="file" accept=".jpg, .png, .jpeg" value=""/>
							</div>
							
							
					</div>
                    <div class="mb-3 mt-3">
                        <label for="up-userId" class="form-label">id:</label>
                        <input type="text" class="form-control" id="up-userId" name="userId" value="${user.userId }" disabled="true"/>
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="up-userName" class="form-label">이름:</label>
                        <input type="text" class="form-control" id="up-userName" name="userName" value="${user.userName }" />
                    </div>
                    <div class="mb-3">
                        <label for="up-userPw" class="form-label">Password:</label>
                        <input type="password" class="form-control" id="up-userPw" name="userPw" value="${user.userPw }" />
                    </div>
                    <div class="form-row align-items-center">
                        <div class="col-sm-10 my-1">
                            <label class="form-label" for="email id">Email:</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="up-emailId" name="emailId" value="${user.emailId }" />
                                <div class="input-group-prepend">
                                    <div class="input-group-text">@</div>
                                </div>
                                <select id="up-emailDomain" class="form-control" name="emailDomain">
                                    <option selected>${user.emailDomain }</option>
                                    <option value="naver">naver.com</option>
                                    <option value="google">gmail.com</option>
                                    <option value="daum">daum.net</option>
                                </select>
                            </div>
                        </div>
                    </div>
                     <div class="mb-3 mt-3">
                        <label for="joinDate" class="form-label">등록일자:</label>
                        <input type="text" class="form-control" id="up-joinDate" name="joinDate" value="${user.joinDate }" disabled="true"/>
                    </div>
                    <div style="text-align: center">
                        <button type="button" class="btn btn-outline-secondary m-0 mt-4 mb-3" id="btn-modify">수정</button>
                        <button type="button" class="btn btn-outline-secondary m-0 mt-4 mb-3">취소</button>
                    </div>
                </div>
            </form>
        </div>
        <div style="display: none" id="removeId">
            <form action="" style="text-align: left" id="form-delete" method="POST">
                <div class="m-5">
                    <h2 style="font-family: 'Black Han Sans', sans-serif; opacity: 75%; font-size: 20px; text-align: left" class="m-0 mt-4">회원 탈퇴</h2>
                    <hr class="mb-3 mt-0" align="left" style="border: solid 2px #ffb5a7; width: 30%; opacity: 100%" />
                    <div class="mb-3">
                        <label for="pwdCheck" class="form-label">Password check:</label>
                        <input type="password" class="form-control" id="de-pwdCheck" placeholder="비밀번호 확인" name="pwdCheck" />
                    </div>

                    <div style="text-align: center">
                        <button type="button" class="btn btn-outline-secondary m-0 mt-4 mb-3" id="btn-delete">탈퇴</button>
                        <button type="button" class="btn btn-outline-secondary m-0 mt-4 mb-3">취소</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!-- <div class="col text-center">
                <button type="button" class="btn btn-outline-secondary">
                    <a href="/template/boardResult.html" class="nav-link disabled">글작성</a></button>
                <button type="button" class="btn btn-outline-secondary">초기화</button>
            </div> -->
</div>
<script>
	$("#updateProfile").change(function(){
	    if(this.files && this.files[0]){
	   		var reader = new FileReader;
	   		reader.onload = function(data){
	   			$(".userProfile img").attr("src", data.target.result);
	   		}
	   		reader.readAsDataURL(this.files[0]);
	   	}
	});

    document.querySelector("#btn-modify").addEventListener("click", function(){
    	if(!document.querySelector("#up-userName").value){
    		alert("이름을 입력해 주세요");
    		return;
    	}else if(!document.querySelector("#up-userPw").value){
    		alert("비밀번호를 입력해 주세요");
    		return
    	}else if(!document.querySelector("#up-emailId").value){
    		alert("이메일 아이디를 입력해 주세요");
    		return
    	}else if(!document.querySelector("#up-emailDomain").value){
    		alert("이메일 도메인을 입력해 주세요");
    		return
    	}else{
    		$("#up-userId").attr("disabled", false);
    		let form = document.querySelector("#form-update");
    		form.setAttribute('action', '${root }/member/update');
    		form.submit();
    	}
    });
    document.querySelector("#btn-delete").addEventListener("click", function(){
    	if(!document.querySelector("#de-pwdCheck").value){
    		alert("현재 비밀번호를 입력해 주세요");
    		return;
    	}else if(document.querySelector("#de-pwdCheck").value != ${user.userPw}){
    		alert("현재 비밀번호와 다릅니다");
    		return;
    	}else{
    		location.href = '${root }/member/delete';
    	}
    });
</script>
<!-- [E] content -->
<%@ include file="/WEB-INF/views/template/footer.jsp" %>
