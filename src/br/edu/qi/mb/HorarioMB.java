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

import br.edu.qi.bean.HorarioBean;
import br.edu.qi.dto.Horario;
import br.edu.qi.util.Numeric;

@ManagedBean
@ViewScoped
@SessionScoped
public class HorarioMB {

	@EJB
	HorarioBean ejb;
	
	public String idHorario;
	public String dia;
	public String turno;
	public String msgAviso;
	public ArrayList<Horario> HorarioList;

	public ArrayList<Horario> getHorarioList() {
		try {
			HorarioList = ejb.findAll();
			return HorarioList;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}





	public String getIdHorario() {
		return idHorario;
	}





	public void setIdHorario(String idHorario) {
		this.idHorario = idHorario;
	}





	public String getDia() {
		return dia;
	}





	public void setDia(String dia) {
		this.dia = dia;
	}





	public String getTurno() {
		return turno;
	}





	public void setTurno(String turno) {
		this.turno = turno;
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
