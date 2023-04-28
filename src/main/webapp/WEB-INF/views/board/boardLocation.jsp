<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp" %>
        <!-- [S] map modal-->
        <div
            class="modal fade"
            id="map_modal"
            data-bs-backdrop="static"
            data-bs-keyboard="false"
            tabindex="-1"
            aria-labelledby="staticBackdropLabel"
            aria-hidden="true"
        >
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">
                            <i class="fi fi-rr-star" id="map_modal_title"
                                >${positions[i].title}</i
                            >
                        </h4>
                        <button
                            type="button"
                            class="btn-close"
                            data-bs-dismiss="modal"
                        ></button>
                    </div>

                    <!-- Modal Body -->
                    <div class="modal-body">
                        <form action="" class="was-validated">
                            <div class="mb-3 mt-3">
                                <label for="location_address" class="form-label"
                                    >- 주소:</label
                                >
                                <p id="map_modal_addr">${positions[i].addr}</p>
                            </div>
                            <div class="mb-3">
                                <label for="location_image" class="form-label"
                                    >- 위치 이미지:</label
                                >
                                <img
                                    id="map_modal_img"
                                    src="${positions[i].image}"
                                    alt=""
                                    style="width: 100%"
                                />
                            </div>
                            <div class="form-check mb-3">
                                <label class="form-check-label">
                                    <input
                                        class="form-check-input"
                                        type="checkbox"
                                        name="remember"
                                    />
                                    Remember me
                                </label>
                            </div>
                        </form>
                    </div>

                    <!-- Modal Footer -->
                    <!-- <div class="modal-footer">
                    <button type="submit" class="btn btn-outline-secondary">로그인</button>
                    <button type="button" class="btn btn-outline-secondary">아이디 찾기</button>
                    <button type="button" class="btn btn-outline-secondary">비밀번호 찾기</button>
                </div> -->
                </div>
            </div>
        </div>
        <!-- [E] map modal-->

        <!-- [S] content -->
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
                    관광 명소 검색
                </h2>
                <hr
                    class="mb-3 mt-0"
                    align="left"
                    style="border: solid 3px brown; width: 50%"
                />
            </div>
            <!-- [S] 관광지 검색 -->
            <form class="d-flex my-3" onsubmit="return false;" role="search">
                <select id="search-area" class="form-select me-2">
                    <option value="0" selected>검색 할 지역 선택</option>
                </select>
                <select id="search-content-id" class="form-select me-2">
                    <option value="0" selected>관광지 유형</option>
                    <option value="12">관광지</option>
                    <option value="14">문화시설</option>
                    <option value="15">축제공연행사</option>
                    <option value="25">여행코스</option>
                    <option value="28">레포츠</option>
                    <option value="32">숙박</option>
                    <option value="38">쇼핑</option>
                    <option value="39">음식점</option>
                </select>
                <input
                    id="search-keyword"
                    class="form-control me-2"
                    type="search"
                    placeholder="검색어"
                    aria-label="검색어"
                />
                <button
                    id="btn-search"
                    class="btn btn-outline-success"
                    type="button"
                >
                    검색
                </button>
            </form>
            <!-- kakao map start -->
            <div id="map" style="width: 100%; height: 400px"></div>
            <!-- kakao map end -->
            <div class="mt-5" style="background-color: #ffffffb0; width: 100%">
                <table class="table table-striped" style="display: none">
                    <thead>
                        <tr>
                            <th>대표이미지</th>
                            <th>관광지명</th>
                            <th>주소</th>
                            <th class="table_riches">위도</th>
                            <th class="table_riches">경도</th>
                        </tr>
                    </thead>
                    <tbody id="trip-list"></tbody>
                </table>
            </div>
            <!-- [E] 관광지 검색 -->

            <div id="nav_blank" style="height: 77px"></div>
        </div>
        <!-- [E] content -->
        
        <!-- [S] Kakao Map Script -->
        <script
            type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3026af170fa563615090f86740747826&libraries=services,clusterer,drawing"
        ></script>
        
		<script type="text/javascript" src="${root }/assets/js/key.js"></script>
        <script type="text/javascript" src="${root }/assets/js/kakaoMap.js"></script>
		<script type="text/javascript" src="${root }/assets/js/location.js"></script>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>
