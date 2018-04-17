$(document).ready(function () {

	$("#mediaList").children("div.media").each(function () {
		var fishId = $(this).find('input').val();
		console.log(fishId);
		getImageOfFish(fishId);
	});

});

function getImageOfFish(fishId){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	console.log("9999999");
	$.ajax({
		type: "GET",
		beforeSend: function(request) {
			request.setRequestHeader(header, token);
		},
		contentType: "application/json",
		url: "/async/getimage",
		data: { fishId:fishId},
		//data: fishId,
		//dataType: 'json',
		dataType: 'text',
		cache: false,
		timeout: 600000,
		success: function (data) {
			console.log("ààààààà");
			console.log(data);
			$("#media-"+fishId).find("img").attr("src",data);

		},
		error: function (e) {

			console.log("errrr");

		}
	});
}