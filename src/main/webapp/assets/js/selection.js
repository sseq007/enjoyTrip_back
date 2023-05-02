// 로딩 후 전국의 도 코드 확인
let areaUrl =
    "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
    serviceKey +
    "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";

fetch(areaUrl)
    .then((response) => response.json())
    .then((data) => makeOption(data));

// 시도 코드에 따라 search-area에 출력
function makeOption(data) {
    let areas = data.response.body.items.item;
    // console.log(areas);
    let sel = document.getElementById("search-area");
    areas.forEach((area) => {
        let opt = document.createElement("option");
        opt.setAttribute("value", area.code);
        opt.appendChild(document.createTextNode(area.name));

        sel.appendChild(opt);
    });
}