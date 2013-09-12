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
	 
		
		function doPollGameInfo(){
			var url = '/game/'+ meetingId +'/info';
			
			var jqxhr = $.getJSON( url, function(data) {
				  console.log(data);
				  
				  if (data.wonByMe) {
					  // redirect to success
				  }
				  
				  if (data.winner != null) {
					  // redirect to fail
				  }
				  
				  // update price
				  if (data.cost != undefined) {
					  $('#price').text(data.cost.toFixed(2));
				  }
				  // update players
				  if (data.players != undefined) {
					  $('#players').empty();
					  $.each(data.players, function(index, element){
						  $('#players').append('<li class="list-group-item">'+ element +'</li>');
						  
					  });
				  }
				  
				  setTimeout(doPollGameInfo, 1000);
				})
				.fail(function() { console.log( "error" ) });
		    
		}
		
		doPollGameInfo();
		
	});
