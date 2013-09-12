	$( document ).ready(function() {
		 
		$("#card td").click(function(event){
			$(this).addClass("warning");
			
			// get all td and construct json request

			var retval = {};
			
			
			$("#card td").each(function(index, element){
				if (undefined != $(element).attr('class')) {
					retval[$(element).attr('id')] = true;
				}
				else {
					retval[$(element).attr('id')] = false;
				}
			});

			console.log(retval);
			
			// /game/{id}/update
			
		}); 
	 
	});
