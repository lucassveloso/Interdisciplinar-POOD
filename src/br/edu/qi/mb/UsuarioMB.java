package br.edu.qi.mb;

import java.sql.Date;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.edu.qi.bean.PessoaBean;
import br.edu.qi.bean.UsuarioBean;
import br.edu.qi.dto.Login;
import br.edu.qi.dto.Pessoa;
import br.edu.qi.dto.Usuario;
import br.edu.qi.util.Numeric;

@ManagedBean
@ViewScoped
@SessionScoped
public class UsuarioMB {

	@EJB
	UsuarioBean ejb;
	@EJB
	PessoaBean ejbpessoa;

	public String login;
	public String senha;
	public String idPessoa;
	public String msgAviso;
	public String tipoPessoa;
	public ArrayList<Usuario> usuarioList;

	public ArrayList<Usuario> getusuarioList() {
		try {
			usuarioList = ejb.findAll();
			return usuarioList;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(String idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getMsgAviso() {
		return msgAviso;
	}

	public void setMsgAviso(String msgAviso) {
		this.msgAviso = msgAviso;
	}

	private void setMessage(String objErro, String msg) {
		FacesMessage message = new FacesMessage(msg);
		FacesContext.getCurrentInstance().addMessage(objErro, message);
	}

	private void validation() throws Exception {
		if (this.login.trim().length() == 0)
			throw new Exception("Informe o Login");

		if (this.senha.trim().length() == 0)
			throw new Exception("Informe a Senha");
	}

	public void entrar() {
		try {
			this.setMsgAviso("");
			this.validation();

			Usuario dto = new Usuario(this.login, this.senha);
			dto = ejb.find(dto);
			if (dto == null) {
				this.setMsgAviso("Login errado.");
			} else {
				HttpSession session = (HttpSession) FacesContext
						.getCurrentInstance().getExternalContext()
						.getSession(false);

				session.setAttribute("Usuario", dto);

				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("index.xhtml");
			}
		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}

	public void isLogado(ComponentSystemEvent event) {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Object dto = session.getAttribute("Usuario");
		FacesContext fc = FacesContext.getCurrentInstance();

		if (dto == null) {
			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc
					.getApplication().getNavigationHandler();

			nav.performNavigation("access-denied");
		}
	}

	public void logOff(ComponentSystemEvent event) {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.removeAttribute("Usuario");
		FacesContext fc = FacesContext.getCurrentInstance();

		ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc
				.getApplication().getNavigationHandler();

		nav.performNavigation("login");
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getTipoPessoa() throws Exception {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		Usuario dto = (Usuario) session.getAttribute("Usuario");
		Pessoa p = ejbpessoa.find(dto.getIdPessoa());
		return p.getTipoPessoa();
	}

}
