package br.edu.qi.mb;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.qi.bean.HorarioPessoaBean;
import br.edu.qi.bean.HorarioTurmaBean;
import br.edu.qi.bean.MatriculaBean;
import br.edu.qi.bean.PessoaBean;
import br.edu.qi.bean.TurmaBean;
import br.edu.qi.dto.HorarioPessoa;
import br.edu.qi.dto.HorarioTurma;
import br.edu.qi.dto.Matricula;
import br.edu.qi.dto.Pessoa;
import br.edu.qi.dto.Turma;
import br.edu.qi.util.Data;
import br.edu.qi.util.Numeric;

@ManagedBean
@ViewScoped
@SessionScoped
public class MatriculaMB {

	@EJB
	MatriculaBean ejb;
	@EJB
	PessoaBean ejbPessoa;
	@EJB
	HorarioPessoaBean ejbHorarioPessoa;
	@EJB
	HorarioTurmaBean ejbHorarioTurma;
	@EJB
	TurmaBean ejbTurma;

	public String idTurma;
	public String msgAviso;
	public ArrayList<Matricula> MatriculaList;
	public ArrayList<Pessoa> AlunoList;
	public Integer[] alunosMatriculados;

	public ArrayList<Matricula> getMatriculaList() {
		try {
			MatriculaList = ejb.findAll();
			return MatriculaList;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}

	public String getidTurma() {
		return idTurma;
	}

	public void setidTurma(String idTurma) {
		this.idTurma = idTurma;
	}

	public String getMsgAviso() {
		return msgAviso;
	}

	public void setMsgAviso(String msgAviso) {
		this.msgAviso = msgAviso;
	}

	public String getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(String idTurma) {
		this.idTurma = idTurma;
	}

	public Integer[] getAlunosMatriculados() {
		return alunosMatriculados;
	}

	public void setAlunosMatriculados(Integer[] alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}

	public void setMatriculaList(ArrayList<Matricula> matriculaList) {
		MatriculaList = matriculaList;
	}

	public ArrayList<Pessoa> getAlunoList() {
		return AlunoList;
	}

	public void setAlunoList(ArrayList<Pessoa> alunoList) {
		AlunoList = alunoList;
	}

	private void setMessage(String objErro, String msg) {
		FacesMessage message = new FacesMessage(msg);
		FacesContext.getCurrentInstance().addMessage(objErro, message);
	}

	private void validation(Turma t) throws Exception {

		if (this.idTurma == null)
			throw new Exception("Por favor, selecione uma Turma");

		if (this.alunosMatriculados.length == 0)
			throw new Exception("Por favor, selecione algum aluno");

		if (alunosMatriculados.length > t.getCapacidade()) {
			throw new Exception(
					"Alunos selecionados ultrapassam a capacidade da turma.");
		}

	}

	public void gravar() {
		try {
			this.setMsgAviso("");

			Turma t = new Turma();
			t.setIdTurma(Integer.parseInt(idTurma));
			t = ejbTurma.find(t);

			this.validation(t);

			for (int i = 0; i < alunosMatriculados.length; i++) {
				ejb.save(new Matricula(Integer.parseInt(this.idTurma),
						alunosMatriculados[i]));
			}

			ejbTurma.updateCapacidade(
					(t.getCapacidade() - alunosMatriculados.length),
					Integer.parseInt(this.idTurma));

			this.setMsgAviso("Gravação com sucesso");

		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}

	public void refreshAlunos() throws Exception {
		AlunoList = new ArrayList<Pessoa>();
		HorarioTurma ht = ejbHorarioTurma.findPorTurma(Integer
				.parseInt(idTurma));
		ArrayList<HorarioPessoa> horarioPessoa = ejbHorarioPessoa
				.findPorHorario(ht.getIdHorario());

		ArrayList<Pessoa> alunos = ejbPessoa.findAll("aluno");
		ArrayList<Matricula> matricula = ejb.findPorTurma(Integer
				.parseInt(idTurma));
		ArrayList<Pessoa> alunosHorarioDisponivel = ejbPessoa.findAll("aluno");

		for (HorarioPessoa hp : horarioPessoa) {
			for (Pessoa a : alunos) {
				if (hp.getIdPessoa() == a.getIdPessoa()) {
					AlunoList.add(a);
				}
			}
		}

		for (int i = 0; i < AlunoList.size(); i++) {
			for (Matricula m : matricula) {
				if (AlunoList.get(i).getIdPessoa() == m.getIdPessoa()) {
					AlunoList.remove(i);
				}
			}
		}

	}

}
