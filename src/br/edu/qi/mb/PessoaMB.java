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

import br.edu.qi.bean.DeficPessoaBean;
import br.edu.qi.bean.FiliacaoBean;
import br.edu.qi.bean.PessoaBean;
import br.edu.qi.bean.TelefoneBean;
import br.edu.qi.dto.DeficPessoa;
import br.edu.qi.dto.Filiacao;
import br.edu.qi.dto.Pessoa;
import br.edu.qi.dto.Telefone;
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
	
	public String idPessoa;
	public String cep;
	public String nome;
	public String nomeSocial;
	public String logradouro;
	public String idEtnia;
	public String idReligiao;
	public String idSexo;
	public String msgAviso;
	public String idDeficiencia;
	public String telefone;
	public String celular;
	public String pai;
	public String mae;
	public String tipoPessoa;
	public String formaPagamento;
	public String cargo;
	public String formacao;
	public String dataAdmissao;
	public ArrayList<Pessoa> pessoaList;

	public ArrayList<Pessoa> getPessoaList() {
		try {
			pessoaList = ejb.findAll();
			return pessoaList;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}


	public String getIdPessoa() {
		return idPessoa;
	}




	public void setIdPessoa(String idPessoa) {
		this.idPessoa = idPessoa;
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


	


	public String getIdDeficiencia() {
		return idDeficiencia;
	}




	public void setIdDeficiencia(String idDeficiencia) {
		this.idDeficiencia = idDeficiencia;
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


	public String getPai() {
		return pai;
	}


	public void setPai(String pai) {
		this.pai = pai;
	}


	public String getMae() {
		return mae;
	}


	public void setMae(String mae) {
		this.mae = mae;
	}


	public String getTipoPessoa() {
		return tipoPessoa;
	}


	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
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
		if (this.idPessoa.trim().length() == 0)
			throw new Exception("Informe o IdPessoa");
		
		if (!n.isNumeric(this.idPessoa))
			throw new Exception("IdPessoa apenas numero");
		
		if (this.nome.trim().length() == 0)
			throw new Exception("Informe o Nome");

		if (this.nomeSocial.trim().length() == 0)
			throw new Exception("Informe o Nome Social");
	
		if (this.idSexo.trim().length() == 0)
			throw new Exception("Informe o idSexo");
		
		if (!n.isNumeric(this.idSexo))
			throw new Exception("idSexo apenas numero");
		
		if (this.cep.trim().length() == 0)
			throw new Exception("Informe o CEP");

		if (!n.isNumeric(this.cep))
			throw new Exception("CEP apenas numero");
		
		if (this.logradouro.trim().length() == 0)
			throw new Exception("Informe o Logradouro");
		
		if (this.idEtnia.trim().length() == 0)
			throw new Exception("Informe o IdEtnia");
		
		if (!n.isNumeric(this.idEtnia))
			throw new Exception("IdEtnia apenas numero");
		
		if (this.idReligiao.trim().length() == 0)
			throw new Exception("Informe o idReligiao");
		
		if (!n.isNumeric(this.idReligiao))
			throw new Exception("idReligiao apenas numero");
		
	}

	public void gravar() {
		try {
			this.setMsgAviso("");
			this.validation();
			
			Pessoa dto = new Pessoa(Integer.parseInt(this.idPessoa),
					Integer.parseInt(this.cep),
					this.logradouro,
					this.nomeSocial,
					this.tipoPessoa,
					this.nome,
					Integer.parseInt(this.idEtnia),
					Integer.parseInt(this.idReligiao),
					Integer.parseInt(this.idSexo));
			ejb.save(dto);
			
			DeficPessoa deficPessoa = new DeficPessoa(Integer.parseInt(this.idPessoa), Integer.parseInt(this.idDeficiencia));
			ejbDeficPessoa.save(deficPessoa);
			
			Telefone telefone = new Telefone(Integer.parseInt(this.idPessoa), this.telefone);
			Telefone celular = new Telefone(Integer.parseInt(this.idPessoa), this.celular);

			ejbTelefone.save(telefone);
			ejbTelefone.save(celular);
			
			Filiacao pai = new Filiacao(this.pai, 1, Integer.parseInt(this.idPessoa), 0);
			Filiacao mae = new Filiacao(this.mae, 2, Integer.parseInt(this.idPessoa), 0);
			
			ejbFiliacao.save(pai);
			ejbFiliacao.save(mae);
			
			this.setMsgAviso("Gravação com sucesso");

		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}

	

}
