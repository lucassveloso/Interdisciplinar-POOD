	//<![CDATA[
			
		$(function(){
			  $(".classeCbTipo").change(function(e){
			   var tipo = $(this).val();
				$("#professor").hide();
				$("#funcionario").hide();
				$("#aluno").hide();
				$("#"+tipo).show();
				if(tipo == "funcionario" || !tipo){
					$("#horario").hide();
				}else{
					$("#horario").show();
				}
			  });
			 });
		
		 $(document).ready(function(){
		        $('.divtipos').hide();
		    });
		//]]>