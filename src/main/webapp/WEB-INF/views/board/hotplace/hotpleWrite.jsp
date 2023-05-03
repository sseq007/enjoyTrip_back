<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>   
<!-- [S] content -->
<div class="container">
    <div>
        <h2 style="font-family: 'Black Han Sans', sans-serif; opacity: 75%; font-size: 50px" class="m-0 mt-5">핫플 자랑하기</h2>
        <hr class="mb-3 mt-0" align="left" style="border: solid 3px brown; width: 50%" />
    </div>
    <div style="margin: auto; margin-top: 100px; margin-bottom: 100px; width: 50%; height: auto; border: 3px solid #ffb5a7; border-radius: 10px" class="text-center">
        <nav class="navbar navbar-expand-sm" style="background-color: #ffb5a7; font-family: 'Black Han Sans', sans-serif; opacity: 75%; text-align: center; font-size: 20px">
            <div class="collpase navbar-collapse justify-content-center">
                <ul class="navbar-nav">
                    <li class="nav-item" style="margin-inline: 70px">
                        핫플레이스 글 작성
                    </li>
                </ul>
            </div>
        </nav>

        <div id="modifyContents">
            <form action="" style="text-align: left" id="form-write" method="post" encType="multipart/form-data">
                <div class="m-5">
                    <div class="mb-3 mt-3" align="center">
							<div class="hotpleImg mb-3 mt-3">
								<img src="${root }/assets/img/noimg.jpg" class="hotple_image" style="border-radius: 5%; width: 100%; height: 100%;">
							</div>
							<div>
								<label className="input-file-button" for="uploadHotplace" style="padding: 6px 25px; border-radius: 4px; border: solid 2px #ffb5a7; color: #663333 ">업로드</label>
								<input type="file" id="uploadHotplace" name="file" accept=".jpg, .png, .jpeg" value="" style="display: none"/>
							</div>
							
							
					</div>
                    <div class="mb-3 mt-3">
                        <label for="subject" class="form-label" style="color: #663333">Subject:</label>
                        <input type="text" class="form-control" id="subject" name="subject" style="width: 60%;"/>
                    </div>
                    <div class="mb-3">
                        <label for="content" class="form-label" style="color: #663333">Content:</label>
                        <input type="text" class="form-control" id="content" name="content"/>
                    </div>
                    <div class="form-row align-items-center">
                        <div class="col-sm-10 my-1">
                            <label class="form-label" for="email id" style="color: #663333">Area:</label>
                            <div class="input-group">
                                <select id="search-area" class="form-control">
                                    <option selected>지역 선택 안 함</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div style="text-align: center">
                        <button type="button" class="btn btn-outline-secondary m-0 mt-4 mb-3" id="btn-write">등록</button>
                        <button type="button" class="btn btn-outline-secondary m-0 mt-4 mb-3" id="btn-cancle">취소</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
	$("#uploadHotplace").change(function(){
	    if(this.files && this.files[0]){
	   		var reader = new FileReader;
	   		reader.onload = function(data){
	   			$(".hotpleImg img").attr("src", data.target.result);
	   		}
	   		reader.readAsDataURL(this.files[0]);
	   	}
	});    
    document.querySelector("#btn-cancle").addEventListener("click", function(){
    	location.href = '${root }/board/hotplace';
    });
    
    
</script>
<script type="text/javascript" src="${root }/assets/js/key.js"></script>
<script type="text/javascript" src="${root }/assets/js/selection.js"></script>
<script type="text/javascript" src="/assets/js/hotplace.js"></script>
<!-- [E] content -->
<%@ include file="/WEB-INF/views/template/footer.jsp" %>