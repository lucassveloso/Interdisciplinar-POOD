package br.edu.qi.mb;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.qi.bean.CursoBean;
import br.edu.qi.dto.Curso;

@ManagedBean
@ViewScoped
@SessionScoped
public class CursoMB {

	@EJB
	CursoBean ejb;
	
	public String idCurso;
	public String descricao;
	public String msgAviso;
	public ArrayList<Curso> CursoList;

	public ArrayList<Curso> getCursoList() {
		try {
			CursoList = ejb.findAll();
			return CursoList;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}


	




	public String getIdCurso() {
		return idCurso;
	}







	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}







	public String getDescricao() {
		return descricao;
	}







	public void setDescricao(String descricao) {
		this.descricao = descricao;
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


	

}
