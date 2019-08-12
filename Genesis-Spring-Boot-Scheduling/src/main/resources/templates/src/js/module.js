$(".button.button-primary.button-wide-mobile.celcius").load(
		function() {
			var city = $(".button.button-wide-mobile.textbox").val();
			var unit = $(this).attr("value");
			var resp = $.parseJSON($.ajax(
					'http://localhost:8080/news/getlatest', {
						dataType : 'json',
						timeout : 500,
						async : false,
						success : function(data, status, xhr) {
						},
						error : function(jqXhr, textStatus, errorMessage) {
							$(".hero-cta.error-msg").css("display", "block");
							$(".data").css("display", "none");
							$(".button.button-primary.button-wide-mobile.error-msg").text(errorMessage);
						}
					}).responseText);
			$(".hero-cta").css("display", "block");	
});