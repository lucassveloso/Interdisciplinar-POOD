	//<![CDATA[
//		var adicionaIgual = function() {
//			var idParent = $(this).parent().attr("id");
//			var classe = $(this).attr("class").split(" ")[0];
//			$template = $("." + classe).clone()[0];
//			$("#" + idParent).append($template)
//		}
//
//		var adicionaTelefone = function() {
//			var $template = $($(".telefones").clone()[0]).val("");
//			$("#divTelefones").append($template)
//		}
//
//		$("#btnCadastrar").click(function() {
//			var properties = $("#divProperties").children();
//			for (var i = 0; i < properties.length; i++) {
//				var $property = $(properties[i]);
//				var $items = $("." + $property.attr("id") + "s");
//
//				$.each($items, function(i, item) {
//					$property.append($('<option>', {
//						value : item.value
//					}));
//				});
//
//				//$prop.push($property.val());
//			}
//			document.forms["formCreate"].submit();
//		});
		

			
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