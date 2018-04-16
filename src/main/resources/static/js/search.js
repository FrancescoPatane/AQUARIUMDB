$(document).ready(function () {

	$("#mediaList").children("div.media").each(function () {
		var fishId = $(this).find('input').val();
		//console.log($(this).find('input').val())
		getImageOfFish();
	});

});

function getImageOfFish(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$.ajax({
		type: "POST",
		beforeSend: function(request) {
			request.setRequestHeader(header, token);
		},
		contentType: "application/json",
		url: "/async/getimage",
		//data: JSON.stringify(search),
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {



		},
		error: function (e) {



		}
	});
}