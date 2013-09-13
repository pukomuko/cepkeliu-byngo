	$( document ).ready(function() {
		 
		
		$.ajaxSetup ({  
		    cache: false  
		});  

		$("#card td").click(function(event){
			$(this).addClass("danger");
			
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
	 
		
		function doPollGameInfo(){
			var url = '/game/'+ meetingId +'/info';
			
			var jqxhr = $.getJSON( url, function(data) {
				  console.log(data);
				  
				  if (data.wonByMe) {
					  // redirect to success
					  console.log("laimejau!");
					  $('#success').modal({
						  keyboard: false,
						  backdrop: 'static',
						  show: true
					  });
					  return;
				  }
				  
				  if (data.winner != null) {
					  // redirect to fail
					  console.log("pafeilinau");
					  $('#winner').text(data.winner);
					  $('#fail').modal({
						  keyboard: false,
						  backdrop: 'static',
						  show: true
					  });
					  return;
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
