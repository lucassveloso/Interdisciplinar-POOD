package br.edu.qi.mb;

import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.component.export.PDFExporter;

import br.edu.qi.bean.HorarioPessoaBean;
import br.edu.qi.bean.HorarioTurmaBean;
import br.edu.qi.bean.PessoaBean;
import br.edu.qi.bean.ProdTurmaBean;
import br.edu.qi.bean.TurmaBean;
import br.edu.qi.dto.DeficPessoa;
import br.edu.qi.dto.HorarioPessoa;
import br.edu.qi.dto.HorarioTurma;
import br.edu.qi.dto.Item;
import br.edu.qi.dto.Pessoa;
import br.edu.qi.dto.ProdTurma;
import br.edu.qi.dto.Turma;
import br.edu.qi.util.Data;
import br.edu.qi.util.Numeric;

@ManagedBean
@ViewScoped
@SessionScoped
public class TurmaMB {

	@EJB
	TurmaBean ejb;
	@EJB
	PessoaBean ejbPessoa;
	@EJB
	HorarioPessoaBean ejbHorarioPessoa;
	@EJB
	HorarioTurmaBean ejbHorarioTurma;
	@EJB
	ProdTurmaBean ejbProdTurma;


	public String idCurso;
	public String capacidade;
	public String dataInicio;
	public String dataFim;
	public String tema;
	public String idProfessor;
	public String idHorario;
	public String msgAviso;
	public ArrayList<Turma> TurmaList;
	public ArrayList<Pessoa> ProfessorList;
	public Integer[] ItemList;

	public ArrayList<Turma> getTurmaList() {
		try {
			TurmaList = new ArrayList<Turma>();
			ArrayList<Turma> t = ejb.findAll();
			for(Turma turma : t){
				if(turma.getCapacidade()>0){
					TurmaList.add(turma);
				}
			}
			return TurmaList;
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

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(String idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(String idHorario) {
		this.idHorario = idHorario;
	}

	

	public Integer[] getItemList() {
		return ItemList;
	}

	public void setItemList(Integer[] itemList) {
		ItemList = itemList;
	}

	public ArrayList<Pessoa> getProfessorList() {
		return ProfessorList;
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
		
		if (this.idCurso == null)
			throw new Exception("Por favor, selecione um Curso");
		
		if (this.tema.trim().length() == 0)
			throw new Exception("Informe o tema");

		if (this.capacidade.trim().length() == 0)
			throw new Exception("Informe a Capacidade");

		if (!Numeric.isNumeric(this.capacidade))
			throw new Exception("Capacidade apenas numero");
		
		if (this.idHorario == null)
			throw new Exception("Por favor, selecione um horário");
		
		if (this.idProfessor == null)
			throw new Exception("Por favor, selecione um professor");
		
	}

	public void gravar() {
		try {
			this.setMsgAviso("");
			this.validation();

			Turma dto = new Turma(Integer.parseInt(this.idCurso), Integer.parseInt(this.idProfessor),Integer.parseInt(this.capacidade),
					Data.formataData(this.dataInicio), Data.formataData(this.dataFim), tema);
			dto = ejb.save(dto);

			HorarioTurma horarioTurma = new HorarioTurma(dto.getIdTurma(), Integer.parseInt(this.idHorario));
			ejbHorarioTurma.save(horarioTurma);
			
			for (int i = 0; i < ItemList.length; i++) {
				ProdTurma pt = new ProdTurma(dto.getIdTurma(), ItemList[i]);
				ejbProdTurma.save(pt);
			}
				
			
			this.setMsgAviso("Gravação com sucesso");

		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}

	public void refreshProfessores() throws Exception {
		ProfessorList = new ArrayList<Pessoa>();
		ArrayList<HorarioPessoa> horarioPessoa = ejbHorarioPessoa
				.findPorHorario(Integer.parseInt(idHorario));
		ArrayList<Pessoa> professores = ejbPessoa.findAll("professor");

		for (HorarioPessoa hp : horarioPessoa) {
			for (Pessoa p : professores) {
				if (hp.getIdPessoa() == p.getIdPessoa()) {
					ProfessorList.add(p);
				}
			}
		}
		
		

	}

}
