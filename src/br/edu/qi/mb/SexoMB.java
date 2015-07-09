package br.edu.qi.mb;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import br.edu.qi.bean.SexoBean;
import br.edu.qi.dto.Sexo;

@ManagedBean
@ViewScoped
@SessionScoped
public class SexoMB{

	@EJB
	SexoBean ejb;

	
	public String msgAviso;
	public ArrayList<Sexo> sexoList;
	
	

	public SexoBean getEjb() {
		return ejb;
	}

	public void setEjb(SexoBean ejb) {
		this.ejb = ejb;
	}

	public ArrayList<Sexo> getSexoList() {
		System.out.println("to no mb - list");
		try {
			sexoList = ejb.findAll();
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
		}
		return sexoList;
	}

	public void setSexoList(ArrayList<Sexo> sexoList) {
		this.sexoList = sexoList;
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