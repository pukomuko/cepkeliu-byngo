	$( document ).ready(function() {
		 
		
		$.ajaxSetup ({  
		    cache: false  
		});  

		$("#card td").click(function(event){
			$(this).addClass("warning");
			
			// get all td and construct json request

			var celldata = {};
			
			
			$("#card td").each(function(index, element){
				if (undefined != $(element).attr('class')) {
					celldata[$(element).attr('id')] = true;
				}
				else {
					celldata[$(element).attr('id')] = false;
				}
			});

			console.log(celldata);
			
			url = '/game/'+ meetingId +'/update';
			
			console.log(url);
			
			$.post(url, celldata, function(){}, 'application/json');
		}); 
	 
	});
