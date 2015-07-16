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

import br.edu.qi.bean.TipoFiliacaoBean;
import br.edu.qi.dto.TipoFiliacao;
import br.edu.qi.util.Numeric;

@ManagedBean
@ViewScoped
@SessionScoped
public class TipoFiliacaoMB {

	@EJB
	TipoFiliacaoBean ejb;

	public String msgAviso;
	public ArrayList<TipoFiliacao> TipoFiliacaoList;

	public ArrayList<TipoFiliacao> getTipoFiliacaoList() {
		try {
			TipoFiliacaoList = ejb.findAll();
			return TipoFiliacaoList;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
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