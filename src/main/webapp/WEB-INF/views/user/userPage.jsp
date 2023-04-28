<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="member.dto.MemberDto"%> 
<% MemberDto memberDto = (MemberDto) request.getAttribute("user");  %> 
<%@ include file="/template/header.jsp" %>

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
            <form action="" style="text-align: left" id="form-update" method="POST">
                <div class="m-5">
                    <h2 style="font-family: 'Black Han Sans', sans-serif; opacity: 75%; font-size: 20px; text-align: left" class="m-0 mt-4">회원 정보 수정</h2>
                    <hr class="mb-3 mt-0" align="left" style="border: solid 2px #ffb5a7; width: 30%; opacity: 100%" />
                    <div class="mb-3 mt-3">
                        <label for="name" class="form-label">이름:</label>
                        <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value="<%=memberDto.getUserName() %>" />
                    </div>
                    <div class="mb-3">
                        <label for="pwd" class="form-label">Password:</label>
                        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" />
                    </div>
                    <div class="form-row align-items-center">
                        <div class="col-sm-10 my-1">
                            <label class="form-label" for="email id">Email:</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="email id" placeholder="Enter email Id" value="<%=memberDto.getEmailId() %>" />
                                <div class="input-group-prepend">
                                    <div class="input-group-text">@</div>
                                </div>
                                <select id="domain" class="form-control">
                                    <option selected><%=memberDto.getEmailDomain() %></option>
                                    <option value="naver">naver.com</option>
                                    <option value="google">gmail.com</option>
                                    <option value="daum">daum.net</option>
                                    <div class="valid-feedback">Valid.</div>
                                </select>
                            </div>
                        </div>
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
                        <input type="password" class="form-control" id="pwdCheck" placeholder="비밀번호 확인" name="pwdCheck" />
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
    document.querySelector("#btn-modify").addEventListener("click", function(){
    	if(!document.querySelector("#pwd").value){
    		alert("변경할 비밀번호를 입력해 주세요");
    		return;
    	}else{
    		let form = document.querySelector("#form-modify");
    		form.setAttribute("action", "<%= root%>/user?action=update");
    		form.submit();
    	}
    });
    document.querySelector("#btn-delete").addEventListener("click", function(){
    	if(!document.querySelector("#pwdCheck").value){
    		alert("현재 비밀번호를 입력해 주세요");
    		return;
    	}else if(document.querySelector("#pwdCheck").value != <%= memberDto.getUserPw()%>){
    		alert("현재 비밀번호와 다릅니다");
    		return;
    	}else{
    		let form = document.querySelector("#form-delete");
    		form.setAttribute("action", "<%= root%>/user?action=resign");
    		form.submit();
    	}
    });
</script>
<!-- [E] content -->
<%@ include file="/template/footer.jsp" %>
