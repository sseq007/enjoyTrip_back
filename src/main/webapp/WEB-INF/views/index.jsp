<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/template/header.jsp" %>

        <!-- [S] content -->

        <!-- [S] carousel -->
        <div class="text-center position-relative">
            <img
                src="${root }/assets/img/main-trip-intro.png"
                alt="carousel-background"
                id="carousel-top"
            />
            <div class="container" id="carousel-content">
                <div
                    id="carouselExampleFade"
                    class="carousel slide carousel-fade position-absolute top-50 start-50 translate-middle w-75"
                    data-bs-ride="carousel"
                >
                    <img src="${root }/assets/img/Transparence.png" class="w-100" alt="" />
                    <div class="carousel-inner">
                        <div
                            class="carousel-item active"
                            data-bs-interval="3000"
                        >
                            <img
                                src="${root }/assets/img/carousel-0.png"
                                class="d-block w-100"
                                alt="..."
                            />
                        </div>
                        <div class="carousel-item" data-bs-interval="3000">
                            <img
                                src="${root }/assets/img/carousel-1.png"
                                class="d-block w-100"
                                alt="..."
                            />
                        </div>
                        <div class="carousel-item" data-bs-interval="3000">
                            <img
                                src="${root }/assets/img/carousel-2.png"
                                class="d-block w-100"
                                alt="..."
                            />
                        </div>
                    </div>
                    <!-- <button
                        class="carousel-control-prev"
                        type="button"
                        data-bs-target="#carouselExampleFade"
                        data-bs-slide="prev"
                    >
                        <span
                            class="carousel-control-prev-icon"
                            aria-hidden="true"
                        ></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button
                        class="carousel-control-next"
                        type="button"
                        data-bs-target="#carouselExampleFade"
                        data-bs-slide="next"
                    >
                        <span
                            class="carousel-control-next-icon"
                            aria-hidden="true"
                        ></span>
                        <span class="visually-hidden">Next</span>
                    </button> -->
                </div>
            </div>
        </div>
        <!-- [E] carousel -->

        <div style="height: 77px"></div>

        <!-- [S] main content -->
        <div class="container">
            <div class="row">
                <!-- [S] left main content -->
                <div class="col-lg-7">
                    <div class="content-section-heading">
                        <h2
                            style="
                                font-family: 'Black Han Sans', sans-serif;
                                opacity: 75%;
                                font-size: 50px;
                            "
                            class="m-0"
                        >
                            추천 관광명소
                        </h2>
                        <hr
                            class="mb-3 mt-0"
                            align="left"
                            style="border: solid 3px brown; width: 50%"
                        />
                    </div>
                    <div class="row gx-0">
                        <div class="col-md-6">
                            <a class="portfolio-item ratio ratio-4x3" href="#!">
                                <div class="caption">
                                    <div class="caption-content">
                                        <h2
                                            style="
                                                font-family: 'Noto Sans KR',
                                                    sans-serif;
                                            "
                                        >
                                            대전광역시 유성구 덕명동 124
                                        </h2>
                                        <p
                                            style="
                                                font-family: 'Noto Sans KR',
                                                    sans-serif;
                                            "
                                            class="mb-0"
                                        >
                                            대전 유성 연수원
                                        </p>
                                    </div>
                                </div>
                                <img
                                    class="img-fluid"
                                    src="${root }/assets/img/tourist-1.jpg"
                                    alt="..."
                                />
                            </a>
                        </div>
                        <div class="col-md-6">
                            <a class="portfolio-item ratio ratio-4x3" href="#!">
                                <div class="caption">
                                    <div class="caption-content">
                                        <h2
                                            style="
                                                font-family: 'Noto Sans KR',
                                                    sans-serif;
                                            "
                                        >
                                            대전광역시 유성구 덕명동 124
                                        </h2>
                                        <p
                                            class="mb-0"
                                            style="
                                                font-family: 'Noto Sans KR',
                                                    sans-serif;
                                            "
                                        >
                                            대전 유성 연수원
                                        </p>
                                    </div>
                                </div>
                                <img
                                    class="img-fluid"
                                    src="${root }/assets/img/tourist-2.jpg"
                                    alt="..."
                                />
                            </a>
                        </div>
                        <div class="col-md-6">
                            <a class="portfolio-item ratio ratio-4x3" href="#!">
                                <div class="caption">
                                    <div class="caption-content">
                                        <h2
                                            style="
                                                font-family: 'Noto Sans KR',
                                                    sans-serif;
                                            "
                                        >
                                            대전광역시 유성구 덕명동 124
                                        </h2>
                                        <p
                                            class="mb-0"
                                            style="
                                                font-family: 'Noto Sans KR',
                                                    sans-serif;
                                            "
                                        >
                                            대전 유성 연수원
                                        </p>
                                    </div>
                                </div>
                                <img
                                    class="img-fluid"
                                    src="${root }/assets/img/tourist-3.jpg"
                                    alt="..."
                                />
                            </a>
                        </div>
                        <div class="col-md-6">
                            <a class="portfolio-item ratio ratio-4x3" href="#!">
                                <div class="caption">
                                    <div class="caption-content">
                                        <h2
                                            style="
                                                font-family: 'Noto Sans KR',
                                                    sans-serif;
                                            "
                                        >
                                            대전광역시 유성구 덕명동 124
                                        </h2>
                                        <p
                                            class="mb-0"
                                            style="
                                                font-family: 'Noto Sans KR',
                                                    sans-serif;
                                            "
                                        >
                                            대전 유성 연수원
                                        </p>
                                    </div>
                                </div>
                                <img
                                    class="img-fluid"
                                    src="${root }/assets/img/tourist-4.jpg"
                                    alt="..."
                                />
                            </a>
                        </div>
                        <div class="col-md-6">
                            <a class="portfolio-item ratio ratio-4x3" href="#!">
                                <div class="caption">
                                    <div class="caption-content">
                                        <h2
                                            style="
                                                font-family: 'Noto Sans KR',
                                                    sans-serif;
                                            "
                                        >
                                            대전광역시 유성구 덕명동 124
                                        </h2>
                                        <p
                                            class="mb-0"
                                            style="
                                                font-family: 'Noto Sans KR',
                                                    sans-serif;
                                            "
                                        >
                                            대전 유성 연수원
                                        </p>
                                    </div>
                                </div>
                                <img
                                    class="img-fluid"
                                    src="${root }/assets/img/tourist-3.jpg"
                                    alt="..."
                                />
                            </a>
                        </div>
                        <div class="col-md-6">
                            <a class="portfolio-item ratio ratio-4x3" href="#!">
                                <div class="caption">
                                    <div class="caption-content">
                                        <h2
                                            style="
                                                font-family: 'Noto Sans KR',
                                                    sans-serif;
                                            "
                                        >
                                            대전광역시 유성구 덕명동 124
                                        </h2>
                                        <p
                                            class="mb-0"
                                            style="
                                                font-family: 'Noto Sans KR',
                                                    sans-serif;
                                            "
                                        >
                                            대전 유성 연수원
                                        </p>
                                    </div>
                                </div>
                                <img
                                    class="img-fluid"
                                    src="${root }/assets/img/tourist-4.jpg"
                                    alt="..."
                                />
                            </a>
                        </div>
                    </div>
                </div>

                <!-- [E] left main content -->

                <div class="col-lg-1"></div>

                <!-- [	S] right main content -->
                <div class="col-lg-4 text-center">
                    <!-- 상단 이미지 -->
                    <div class="pb-5">
                        <div class="card">
                            <img
                                src="${root }/assets/img/main-content-right-top.PNG"
                                class="card-img"
                                alt="상단이미지"
                            />
                            <div class="card-img-overlay">
                                <div id="img_margin"></div>
                                <button
                                    onclick="location.href='${root }/board/sharetravel'"
                                    id="trip_btn"
                                    class="mb-3"
                                ></button>
                                <button
                                    onclick="location.href='${root }/board/travelplan'"
                                    id="plan_btn"
                                ></button>
                            </div>
                        </div>
                    </div>

                    <!-- 하단 이미지 -->
                    <div
                        id="carouselExampleControls"
                        class="carousel slide mt-lg-5"
                        data-bs-ride="carousel"
                    >
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <a href="${root }/board/hotplace">
                                    <img
                                        src="${root }/assets/img/main-content-right-bottom-1.png"
                                        class="d-block w-100"
                                        alt="하단이미지"
                                    />
                                </a>
                            </div>
                            <div class="carousel-item">
                                <a href="${root }/board/hotplace">
                                    <img
                                        src="${root }/assets/img/main-content-right-bottom-2.png"
                                        class="d-block w-100"
                                        alt="하단이미지"
                                    />
                                </a>
                            </div>
                            <div class="carousel-item">
                                <a href="${root }/board/hotplace">
                                    <img
                                        src="${root }/assets/img/main-content-right-bottom-3.png"
                                        class="d-block w-100"
                                        alt="하단이미지"
                                    />
                                </a>
                            </div>

                            <div class="carousel-item">
                                <a href="${root }/board/hotplace">
                                    <img
                                        src="${root }/assets/img/main-content-right-bottom-4.png"
                                        class="d-block w-100"
                                        alt="하단이미지"
                                    />
                                </a>
                            </div>
                            <div class="carousel-item">
                                <a href="${root }/board/hotplace">
                                    <img
                                        src="${root }/assets/img/main-content-right-bottom-5.png"
                                        class="d-block w-100"
                                        alt="하단이미지"
                                    />
                                </a>
                            </div>
                        </div>
                        <button
                            class="carousel-control-prev"
                            type="button"
                            data-bs-target="#carouselExampleControls"
                            data-bs-slide="prev"
                        >
                            <span
                                class="carousel-control-prev-icon"
                                aria-hidden="true"
                            ></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button
                            class="carousel-control-next"
                            type="button"
                            data-bs-target="#carouselExampleControls"
                            data-bs-slide="next"
                        >
                            <span
                                class="carousel-control-next-icon"
                                aria-hidden="true"
                            ></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>

                <!-- [E] right main content -->
            </div>
        </div>
        <!-- [E] main content -->
        <!-- [E] content -->
        
<%@ include file="/WEB-INF/views/template/footer.jsp" %>

