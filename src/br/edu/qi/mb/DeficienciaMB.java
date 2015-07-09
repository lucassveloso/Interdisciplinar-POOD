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

import br.edu.qi.bean.DeficienciaBean;
import br.edu.qi.dto.Deficiencia;
import br.edu.qi.util.Numeric;

@ManagedBean
@ViewScoped
@SessionScoped
public class DeficienciaMB {

	@EJB
	DeficienciaBean ejb;
	
	public String idDeficiencia;
	public String descricao;
	public String grau;
	public String msgAviso;
	public ArrayList<Deficiencia> deficienciaList;

	public ArrayList<Deficiencia> getDeficienciaList() {
		try {
			deficienciaList = ejb.findAll();
			return deficienciaList;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}

	
	public String getIdDeficiencia() {
		return idDeficiencia;
	}


	public void setIdDeficiencia(String idDeficiencia) {
		this.idDeficiencia = idDeficiencia;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getGrau() {
		return grau;
	}


	public void setGrau(String grau) {
		this.grau = grau;
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
		Numeric n = new Numeric();
		if (this.idDeficiencia.trim().length() == 0)
			throw new Exception("Informe o Id");
		
		if (!n.isNumeric(this.idDeficiencia))
			throw new Exception("Id apenas numero");
		
		if (this.descricao.trim().length() == 0)
			throw new Exception("Informe a Descricao");

		if (this.grau.trim().length() == 0)
			throw new Exception("Informe o Grau");

		if (!n.isNumeric(this.grau))
			throw new Exception("Grau apenas numero");
	}

	public void gravar() {
		try {
			this.setMsgAviso("");
			this.validation();

			Deficiencia dto = new Deficiencia(
					Integer.parseInt(this.idDeficiencia),
					this.descricao,
					Integer.parseInt(this.grau));
			ejb.save(dto);

			this.setMsgAviso("Gravação com sucesso");

		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}

}
