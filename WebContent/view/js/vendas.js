 	//<![CDATA[
			
		
			 $(function(){
$(".classeCbTipo").change(function(e){
			   var tipo = $(this).val();
				$("#desconto").hide();
				if(tipo == "aluno"){
					$("#desconto").show();
				}
			  
			 }); });

$(document).ready(function(){
    $('#desconto').hide();
});
			 
			// ]]>
