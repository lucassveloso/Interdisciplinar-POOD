package br.edu.qi.mb;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpSession;

import br.edu.qi.bean.LoginBean;
import br.edu.qi.dto.Login;

@ManagedBean
@ViewScoped
public class LoginMB {

	@EJB
	LoginBean ejb;

	private String usuario;
	private String senha;
	private String msgAviso;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMsgAviso() {
		return msgAviso;
	}

	public void setMsgAviso(String msgAviso) {
		this.msgAviso = msgAviso;
	}

	private void setMessage(String objErro, String msg) {
		/* Cria uma mensagem. */
		FacesMessage message = new FacesMessage(msg);
		/*
		 * Obtém a instancia atual do FacesContext e adiciona a mensagem de erro
		 * nele.
		 */
		FacesContext.getCurrentInstance().addMessage(objErro, message);

	}

	private void validation() throws Exception {
		if (this.usuario.trim().length() == 0)
			throw new Exception("Informe o Usuário");

		if (this.senha.trim().length() == 0)
			throw new Exception("Informe a Senha");

	}

	public void login() {
		try {
			this.setMsgAviso("");
			this.validation();

			Login dto = new Login(this.usuario, this.senha);
			dto = ejb.find(dto);
			if (dto == null) {
				this.setMsgAviso("Login errado.");
			} else {
				HttpSession session = (HttpSession) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSession(false);
				
				session.setAttribute("Usuario", dto);

				FacesContext.getCurrentInstance().getExternalContext()
				.redirect("agenda.xhtml");
			}
		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}
	
public void isLogado(ComponentSystemEvent event){
		
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext()
				.getSession(false);
		Object dto = session.getAttribute("Usuario");		 
		FacesContext fc = FacesContext.getCurrentInstance();
	
		if (dto==null){	 
			ConfigurableNavigationHandler nav 
			   = (ConfigurableNavigationHandler) 
				fc.getApplication().getNavigationHandler();
	 
			nav.performNavigation("access-denied");
		}		
	  }	
}
