$('#carouselExample').on('slide.bs.carousel', function (e) {


	var $e = $(e.relatedTarget);
	var idx = $e.index();
	var itemsPerSlide = 4;
	var totalItems = $('.carousel-item').length;

	if (idx >= totalItems-(itemsPerSlide-1)) {
		var it = itemsPerSlide - (totalItems - idx);
		for (var i=0; i<it; i++) {
			// append slides to end
			if (e.direction=="left") {
				$('.carousel-item').eq(i).appendTo('.carousel-inner');
			}
			else {
				$('.carousel-item').eq(0).appendTo('.carousel-inner');
			}
		}
	}
});


//$('#carouselExample').carousel({ 
//	interval: 2000
//});




function displayImage(src){
	var modal = document.getElementById('myModal');
	modal.style.display = "block";
	var modalImg = document.getElementById("modalImg");
	modalImg.src = src;
	
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() { 
	    modal.style.display = "none";
	}
};