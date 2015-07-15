	//<![CDATA[
		var adicionaIgual = function() {
			var idParent = $(this).parent().attr("id");
			var classe = $(this).attr("class").split(" ")[0];
			$template = $("." + classe).clone()[0];
			$("#" + idParent).append($template)
		}

		var adicionaTelefone = function() {
			var $template = $($(".telefones").clone()[0]).val("");
			$("#divTelefones").append($template)
		}

		$("#btnCadastrar").click(function() {
			var properties = $("#divProperties").children();
			for (var i = 0; i < properties.length; i++) {
				var $property = $(properties[i]);
				var $items = $("." + $property.attr("id") + "s");

				$.each($items, function(i, item) {
					$property.append($('<option>', {
						value : item.value
					}));
				});

				//$prop.push($property.val());
			}
			document.forms["formCreate"].submit();
		});
		

			
		$(function(){
			  $(".classeCbTipo").change(function(e){
			   var tipo = $(this).val();
			   if(tipo == "aluno"){
					$("#professor").removeClass("visible").addClass("hidden");
					$("#funcionario").removeClass("visible").addClass("hidden");
					$("#aluno").removeClass("hidden").addClass("visible");
					$("#horario").removeClass("hidden").addClass("visible");
				}else if(tipo == "funcionario"){
					$("#professor").removeClass("visible").addClass("hidden");
					$("#funcionario").removeClass("hidden").addClass("visible");
					$("#aluno").removeClass("visible").addClass("hidden");
					$("#horario").removeClass("visible").addClass("hidden");
				}else if(tipo == "professor"){
					$("#professor").removeClass("hidden").addClass("visible");
					$("#funcionario").removeClass("visible").addClass("hidden");
					$("#aluno").removeClass("visible").addClass("hidden");

					$("#horario").removeClass("hidden").addClass("visible");
				}else{
					$("#professor").removeClass("visible").addClass("hidden");
					$("#funcionario").removeClass("visible").addClass("hidden");
					$("#aluno").removeClass("visible").addClass("hidden");
					$("#horario").removeClass("visible").addClass("hidden");
				}
			  });
			 });
		
		 $(document).ready(function(){
		        $('.divtipos').addClass("hidden");
		    });
		//]]>