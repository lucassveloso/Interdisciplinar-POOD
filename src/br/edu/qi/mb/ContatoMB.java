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
import javax.servlet.http.HttpSession;

import br.edu.qi.bean.ContatoBean;
import br.edu.qi.dto.Contato;

@ManagedBean
@ViewScoped
@SessionScoped
public class ContatoMB {

	@EJB
	ContatoBean ejb;

	public String nome;
	public String apelido;
	public String telefone;
	public String celular;
	public String email;
	public String dataNascimento;
	private String msgAviso;
	public ArrayList<Contato> contatoList;

	public ArrayList<Contato> getContatoList() {
		try {
			contatoList = ejb.findAll();
			return contatoList;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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
		if (this.nome.trim().length() == 0)
			throw new Exception("Informe o Nome");

		if (this.apelido.trim().length() == 0)
			throw new Exception("Informe a Apelido");

		if (this.telefone.trim().length() == 0)
			throw new Exception("Informe a Telefone");

		if (this.celular.trim().length() == 0)
			throw new Exception("Informe a Celular");

		if (this.email.trim().length() == 0)
			throw new Exception("Informe a Email");

		try {
			Date.valueOf(this.dataNascimento);
		} catch (Exception e) {
			throw new Exception("Data inválida, Segue o formato: aaaa-MM-dd");
		}
	}

	public void gravar() {
		try {
			this.setMsgAviso("");
			this.validation();

			Contato dto = new Contato(this.nome, this.apelido, this.telefone,
					this.celular, this.email, Date.valueOf(this.dataNascimento));
			ejb.save(dto);

			this.setMsgAviso("Gravação com sucesso");

		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}

	public void editar() {
		try {
			this.setMsgAviso("");
			this.validation();

			Contato dto = new Contato(this.nome, this.apelido, this.telefone,
					this.celular, this.email, Date.valueOf(this.dataNascimento));
			
			ejb.update(dto);

			this.setMsgAviso("Gravação com sucesso");

		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}

	public void edit(Contato obj) {
		try {
			this.setMsgAviso("");
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			
			session.setAttribute("contato", obj);

			FacesContext.getCurrentInstance().getExternalContext()
			.redirect("editar.xhtml");
			

		
			
		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}

	public void remove(Contato obj) {
		try {
			this.setMsgAviso("");

			ejb.delete(obj);

			contatoList = ejb.findAll();
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
