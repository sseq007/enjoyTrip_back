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
	write: function()	{	
		var formData = new FormData(document.getElementById('form-write'));
		formData.append("sido_code", $("#search-area").val());
		
		$.ajax({
			type: "POST",
			url: "/api/hotplace/write",
			dataType: 'json',
			data: formData,
			contentType: false,
			processData: false,
			enctype: 'multipart/form-data',
			async: false,
		})
		 .done(function(resp){
		 	alert("글이 등록되었습니다");
		 	location.href = "${root }/api/hotplace/list";
		 })
		 .fail(function (error){
		 	alert(JSON.stringify(error));
		 });
	},
};

index.init();