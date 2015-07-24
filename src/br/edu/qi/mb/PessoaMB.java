package br.edu.qi.mb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.qi.bean.AlunoBean;
import br.edu.qi.bean.DeficPessoaBean;
import br.edu.qi.bean.FiliacaoBean;
import br.edu.qi.bean.FuncionarioBean;
import br.edu.qi.bean.HorarioPessoaBean;
import br.edu.qi.bean.PessoaBean;
import br.edu.qi.bean.ProfessorBean;
import br.edu.qi.bean.TelefoneBean;
import br.edu.qi.bean.UsuarioBean;
import br.edu.qi.dto.Aluno;
import br.edu.qi.dto.DeficPessoa;
import br.edu.qi.dto.Filiacao;
import br.edu.qi.dto.Funcionario;
import br.edu.qi.dto.HorarioPessoa;
import br.edu.qi.dto.Pessoa;
import br.edu.qi.dto.Professor;
import br.edu.qi.dto.Telefone;
import br.edu.qi.dto.Usuario;
import br.edu.qi.util.Numeric;

@ManagedBean
@ViewScoped
@SessionScoped
public class PessoaMB {

	@EJB
	PessoaBean ejb;
	@EJB
	DeficPessoaBean ejbDeficPessoa;
	@EJB
	TelefoneBean ejbTelefone;
	@EJB
	FiliacaoBean ejbFiliacao;
	@EJB
	AlunoBean ejbAluno;
	@EJB
	ProfessorBean ejbProfessor;
	@EJB
	FuncionarioBean ejbFuncionario;
	@EJB
	HorarioPessoaBean ejbHorarioPessoa;
	@EJB
	UsuarioBean ejbUsuario;

	public String cep;
	public String nome;
	public String nomeSocial;
	public String logradouro;
	public String idEtnia;
	public String idReligiao;
	public String idSexo;
	public String msgAviso;
	public String tipoPessoa;
	public String telefone;
	public String celular;
	public String nomeFiliacao1;
	public String nomeFiliacao2;
	public String formaPagamento;
	public String cargo;
	public String formacao;
	public String dataAdmissao;
	public String idTipoFiliacao1;
	public String idTipoFiliacao2;
	public String login;
	public String senha;
	public String confirmarSenha;

	public ArrayList<Pessoa> pessoaList;
	public ArrayList<Pessoa> pessoaListAluno;
	public ArrayList<Pessoa> pessoaListFuncionario;
	public ArrayList<Pessoa> pessoaListProfessor;
	public Integer[] deficienciaList;
	public Integer[] horarioList;

	public ArrayList<Pessoa> getPessoaList() {
		try {
			pessoaList = ejb.findAll("");
			return pessoaList;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}

	public ArrayList<Pessoa> getPessoaListAluno() {
		try {
			pessoaListAluno = ejb.findAll("aluno");
			return pessoaListAluno;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}

	public ArrayList<Pessoa> getPessoaListProfessor() {
		try {
			pessoaListProfessor = ejb.findAll("professor");
			return pessoaListProfessor;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}

	public ArrayList<Pessoa> getPessoaListFuncionario() {
		try {
			pessoaListFuncionario = ejb.findAll("funcionario");
			return pessoaListFuncionario;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getIdEtnia() {
		return idEtnia;
	}

	public void setIdEtnia(String idEtnia) {
		this.idEtnia = idEtnia;
	}

	public String getIdReligiao() {
		return idReligiao;
	}

	public void setIdReligiao(String idReligiao) {
		this.idReligiao = idReligiao;
	}

	public String getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(String idSexo) {
		this.idSexo = idSexo;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
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

	public String getnomeFiliacao1() {
		return nomeFiliacao1;
	}

	public void setnomeFiliacao1(String nomeFiliacao1) {
		this.nomeFiliacao1 = nomeFiliacao1;
	}

	public String getnomeFiliacao2() {
		return nomeFiliacao2;
	}

	public void setnomeFiliacao2(String nomeFiliacao2) {
		this.nomeFiliacao2 = nomeFiliacao2;
	}

	public String getIdTipoFiliacao1() {
		return idTipoFiliacao1;
	}

	public void setIdTipoFiliacao1(String idTipoFiliacao1) {
		this.idTipoFiliacao1 = idTipoFiliacao1;
	}

	public String getIdTipoFiliacao2() {
		return idTipoFiliacao2;
	}

	public void setIdTipoFiliacao2(String idTipoFiliacao2) {
		this.idTipoFiliacao2 = idTipoFiliacao2;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
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

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public Integer[] getHorarioList() {
		return horarioList;
	}

	public void setHorarioList(Integer[] horarioList) {
		this.horarioList = horarioList;
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

	public Integer[] getDeficienciaList() {
		return deficienciaList;
	}

	public void setDeficienciaList(Integer[] deficienciaList) {
		this.deficienciaList = deficienciaList;
	}

	public String getNomeFiliacao1() {
		return nomeFiliacao1;
	}

	public void setNomeFiliacao1(String nomeFiliacao1) {
		this.nomeFiliacao1 = nomeFiliacao1;
	}

	public String getNomeFiliacao2() {
		return nomeFiliacao2;
	}

	public void setNomeFiliacao2(String nomeFiliacao2) {
		this.nomeFiliacao2 = nomeFiliacao2;
	}

	private void validation() throws Exception {
		if (this.nome.trim().length() == 0)
			throw new Exception("Informe o Nome");

		if (this.nomeSocial.trim().length() == 0)
			throw new Exception("Informe o Nome Social");
		
		if (this.logradouro.trim().length() == 0)
			throw new Exception("Informe o Logradouro");

		if (this.cep.trim().length() == 0)
			throw new Exception("Informe o CEP");

		if (!Numeric.isNumeric(this.cep))
			throw new Exception("CEP apenas numero");


		if (this.telefone.trim().length() == 0)
			throw new Exception("Informe o Telefone");

		if (this.celular.trim().length() == 0)
			throw new Exception("Informe o Celular");

		if (this.nomeFiliacao1.trim().length() == 0)
			throw new Exception("Informe o Nome do primeiro parente");

		if (this.nomeFiliacao2.trim().length() == 0)
			throw new Exception("Informe o Nome do segundo parente");

		if (this.tipoPessoa == null)
			throw new Exception("Por favor, selecione um tipo de pessoa");

		if (this.login.trim().length() == 0)
			throw new Exception("Informe o Login");

		if (this.senha.trim().length() == 0)
			throw new Exception("Informe a Senha");

		if (!this.senha.equals(this.confirmarSenha))
			throw new Exception("A senha e sua confirmação são diferentes");

	}

	public void gravar() {
		try {
			this.setMsgAviso("");
			this.validation();

			Pessoa dto = new Pessoa(Integer.parseInt(this.cep), this.nome,
					this.nomeSocial, this.logradouro, this.tipoPessoa,
					Integer.parseInt(this.idEtnia),
					Integer.parseInt(this.idReligiao),
					Integer.parseInt(this.idSexo));
			dto = ejb.save(dto);

			for (int i = 0; i < deficienciaList.length; i++) {
				DeficPessoa deficPessoa = new DeficPessoa(dto.getIdPessoa(),
						deficienciaList[i]);
				ejbDeficPessoa.save(deficPessoa);
			}

			Telefone telefone = new Telefone(dto.getIdPessoa(), this.telefone);
			Telefone celular = new Telefone(dto.getIdPessoa(), this.celular);

			ejbTelefone.save(telefone);
			ejbTelefone.save(celular);

			Filiacao filiacao1 = new Filiacao(this.nomeFiliacao1,
					Integer.parseInt(this.idTipoFiliacao1), dto.getIdPessoa());
			Filiacao filiacao2 = new Filiacao(this.nomeFiliacao2,
					Integer.parseInt(this.idTipoFiliacao2), dto.getIdPessoa());

			ejbFiliacao.save(filiacao1);
			ejbFiliacao.save(filiacao2);

			if (tipoPessoa.equals("aluno")) {
				Aluno aluno = new Aluno(dto.getIdPessoa(),
						this.getFormaPagamento());
				ejbAluno.save(aluno);
			} else if (tipoPessoa.equals("funcionario")) {
				Date data = null;
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				format.setLenient(false);
				try {
					data = format.parse(this.getDataAdmissao());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				Funcionario funcionario = new Funcionario(dto.getIdPessoa(),
						data, this.getCargo());
				ejbFuncionario.save(funcionario);
			} else if (tipoPessoa.equals("professor")) {
				Professor professor = new Professor(dto.getIdPessoa(),
						this.getFormacao());
				ejbProfessor.save(professor);
			}

			if (tipoPessoa.equals("professor") || tipoPessoa.equals("aluno")) {
				for (int i = 0; i < horarioList.length; i++) {
					HorarioPessoa horarioPessoa = new HorarioPessoa(
							dto.getIdPessoa(), horarioList[i]);
					ejbHorarioPessoa.save(horarioPessoa);
				}
			}

			ejbUsuario.save(new Usuario(this.login, this.senha, dto
					.getIdPessoa()));

			this.setMsgAviso("Gravação com sucesso");

		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}

}
