<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/template/header.jsp" %>        <!-- [S] content -->
        <div class="container">
            <div>
                <h2
                    style="
                        font-family: 'Black Han Sans', sans-serif;
                        opacity: 75%;
                        font-size: 50px;
                    "
                    class="m-0 mt-5"
                >
                    여행 정보 공유
                </h2>
                <hr
                    class="mb-3 mt-0"
                    align="left"
                    style="border: solid 3px brown; width: 50%"
                />
            </div>
            <div
                style="
                    width: 100%;
                    height: auto;
                    border: 3px solid #ffb5a7;
                    border-radius: 10px;
                "
                class="text-center"
            >
                <h2
                    style="
                        font-family: 'Noto Sans KR', sans-serif;
                        color: #6c584c;
                        opacity: 75%;
                        font-size: 40px;
                    "
                    class="m-0 mt-3"
                >
                    등록 완료!!!
                </h2>
                <p
                    style="
                        font-family: 'Noto Sans KR', sans-serif;
                        opacity: 75%;
                        font-size: 15px;
                    "
                    class="m-0 mt-5"
                >
                    글 작성이 완료되었습니다.
                </p>
                <button
                    type="button"
                    class="btn btn-outline-secondary m-0 mt-4 mb-3"
                >
                    작성글 보기
                </button>
            </div>
            <div
                style="
                    width: 100%;
                    height: auto;
                    border: 3px solid #ffb5a7;
                    border-radius: 10px;
                "
                class="text-center mt-2"
            >
                <h2
                    style="
                        font-family: 'Noto Sans KR', sans-serif;
                        color: #6c584c;
                        opacity: 75%;
                        font-size: 40px;
                    "
                    class="m-0 mt-3"
                >
                    등록 실패T.T
                </h2>
                <p
                    style="
                        font-family: 'Noto Sans KR', sans-serif;
                        opacity: 75%;
                        font-size: 15px;
                    "
                    class="m-0 mt-5"
                >
                    글 작성에 문제가 있습니다<br />
                    잠시 후 다시 시도해 주세요.
                </p>
                <button
                    type="button"
                    class="btn btn-outline-secondary m-0 mt-4 mb-3"
                >
                    글목록 페이지 이동
                </button>
            </div>
        </div>

        <!-- [E] content -->

<%@ include file="/WEB-INF/views/template/footer.jsp" %>
