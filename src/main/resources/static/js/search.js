$(document).ready(function () {

	$("#mediaList").children("div.media").each(function () {
		var fishId = $(this).find("#fishId").val();
		getImageOfFish(fishId);
	});
	
	$('[data-toggle="tooltip"]').tooltip();
	setDifficultyString();

});

function setDifficultyString (){
	$("#difficultyDot1").attr("title","Molto facile");
	$("#difficultyDot2").attr("title","Facile");
	$("#difficultyDot3").attr("title","Medio");
	$("#difficultyDot4").attr("title","Difficile");
	$("#difficultyDot5").attr("title","Molto Difficile");
}

function getImageOfFish(fishId){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$.ajax({
		type: "GET",
		beforeSend: function(request) {
			request.setRequestHeader(header, token);
		},
		contentType: "application/json",
		url: "/async/getimage",
		data: { fishId:fishId},
		dataType: 'text',
		cache: false,
		timeout: 600000,
		success: function (data) {
			$("#media-"+fishId).find("img").attr("src",data);

		},
		error: function (e) {

		}
	});
}

function filterList() {
	var input = $("#fish-name").val().toUpperCase();
	var family = $("#family-select").val();

	$("#mediaList").children("div.media").each(function () {
		var name = $(this).find(".media-body h1").html().toUpperCase();
		var familyId = $(this).find("#fishFamilyId").val();
		//var familyId = $(this).find("#fishFamilyId").val();
		if ((name.indexOf(input) > (-1) || input === "") && (family === familyId || family === ""))
			$(this).show();
		else
			$(this).hide();
	});
}


function filterByName() {
	var input = $("#fish-name").val().toUpperCase();
	$("#mediaList").children("div.media").each(function () {
		var name = $(this).find(".media-body a").html().toUpperCase();
		//var familyId = $(this).find("#fishFamilyId").val();
		if (name.indexOf(input) > (-1) || input === "") 
			$(this).show();
		else
			$(this).hide();
	});
}


function filterByFamily() {
	var family = $("#family-select").val();
	$("#mediaList").children("div.media").each(function () {
		var familyId = $(this).find("#fishFamilyId").val();
		if (family === familyId || family === "")
			$(this).show();
		else
			$(this).hide();
	});

}

