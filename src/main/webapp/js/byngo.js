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
			
			postUrl = '/game/'+ meetingId +'/update';
			
			console.log(postUrl);
			
			$.ajax({
		        url: postUrl,
		        data: JSON.stringify(celldata),
		        dataType: 'json',
		        type: 'POST',
		        contentType: 'application/json',
		        traditional: false,
		        success: function(data) { console.log(data); }
		      });
		}); 
	 
	});
