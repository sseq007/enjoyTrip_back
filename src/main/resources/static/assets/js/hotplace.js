let index = {
	init: function(){
			$("#btn-write").on("click", () => {
				if(!$("#uploadHotplace").val()){
		    		alert("사진을 등록해 주세요");
		    		return;
		    	}else if(!$("#subject").val()){
		    		alert("제목을 입력해 주세요");
		    		return
		    	}else{
		    		this.write();
		    	}
			});
	},
	write: function(){
		let data = {
			subject: $("#subject").val(),
			content: $("#content").val(),
			sido_code: $("#search-area").val(),
		};
		
		var formData = new FormData($("#form-write")[0]);
		
		$.ajax({
			type: "POST",
			url: "/api/hotplace/write",
			data: formData,
			contentType: false,
			processData: false,
		})
		 .done(function(resp){
		 	alert("글이 등록되었습니다");
		 	location.href = "/board/hotplace/list";
		 })
		 .fail(function (error){
		 	alert(JSON.stringify(error));
		 });
	},
};

index.init();