	//<![CDATA[
			
		$(function(){
			  $(".classeCbTipo").change(function(e){
			   var tipo = $(this).val();
				$("#produto").hide();
				$("#servico").hide();
				$("#"+tipo).show();
		
			  });
			 });
		
		 $(document).ready(function(){
		        $('.divtipos').hide();
		    });
		//]]>