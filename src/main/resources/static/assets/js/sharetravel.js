let index = {
  init: function () {
    $("#btn-board-write").on("click", () => {
      this.save();
    });
    $("#btn-delete").on("click", () => {
      this.deleteById();
    });
    $("#btn-board-modify").on("click", () => {
      this.update();
    });
    $("#btn-reply-save").on("click", () => {
      this.replySave();
    });
  },
  save: function () {
    let data = {
      subject: $("#board-write-title").val(),
      content: $("#board-write-content").val(),
    };
    //console.log(data);

    $.ajax({
      type: "POST",
      url: "/api/sharetravel/write",
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
    })
      .done(function (resp) {
        alert("글쓰기가 완료되었습니다");
        //console.log(resp);
        location.href = "/board/sharetravel/list";
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },

  deleteById: function () {
    let id = $("#ano").val();
     var answer;
     answer = confirm('정말로 삭제하시겠습니까?');
      if (answer == true) {
    $.ajax({
      type: "DELETE",
      url: "/api/sharetravel/delete/" + id,
      dataType: "json",
    })
      .done(function (resp) {
        alert("삭제가 완료되었습니다");
        //console.log(resp);
        location.href = "/board/sharetravel/list";
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
      }
  },

  update: function () {
    let data = {
      articleNo: $("#no").val(),
      subject: $("#board-update-title").val(),
      content: $("#board-update-content").val(),
    };
    console.log(data);

    $.ajax({
      type: "PUT",
      url: "/api/sharetravel/modify",
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
    })
      .done(function (resp) {
        alert("글수정이 완료되었습니다");
        //console.log(resp);
        location.href = `/board/sharetravel/view/${data.articleNo}`;
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },

  replySave: function () {
    //alert('user의 save함수 호출된다');
    let data = {
      userId: $("#userId").val(),
      articleNo: $("#boardId").val(),
      content: $("#reply-content").val(),
    };

    $.ajax({
      type: "POST",
      url: `/api/sharetravel/${data.articleNo}/reply`,
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      dataType: "json",
    })
      .done(function (resp) {
        alert("댓글작성이 완료되었습니다");
        //console.log(resp);
        location.href = `/board/sharetravel/view/${data.articleNo}`;
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },

  replyDelete: function (boardId, replyId) {
    $.ajax({
      type: "DELETE",
      url: `/api/sharetravel/${boardId}/reply/${replyId}`,
      dataType: "json",
    })
      .done(function (resp) {
        alert("댓글삭제 성공");
        //console.log(resp);
        location.href = `/board/sharetravel/view/${boardId}`;
      })
      .fail(function (error) {
        alert(JSON.stringify(error));
      });
  },
};

index.init();
