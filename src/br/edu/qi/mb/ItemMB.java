package br.edu.qi.mb;

import java.sql.Date;
import java.text.SimpleDateFormat;
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

import br.edu.qi.bean.ItemBean;
import br.edu.qi.bean.ProdutoBean;
import br.edu.qi.bean.ServicoBean;
import br.edu.qi.dto.Aluno;
import br.edu.qi.dto.Funcionario;
import br.edu.qi.dto.Item;
import br.edu.qi.dto.Produto;
import br.edu.qi.dto.Servico;
import br.edu.qi.util.Numeric;

@ManagedBean
@ViewScoped
@SessionScoped
public class ItemMB {

	@EJB
	ItemBean ejb;
	@EJB
	ProdutoBean ejbProduto;
	@EJB
	ServicoBean ejbServico;

	public String idtem;
	public String descricao;
	public String valor;
	public String tipoItem;
	public String quantidade;
	public String local;
	public String especificacao;
	public String duracao;
	public String msgAviso;
	public ArrayList<Item> ItemProdutosList;
	public ArrayList<Item> ItemList;

	public ArrayList<Item> getItemList() {
		try {
			ItemList = ejb.findAll();
			return ItemList;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}
	
	public ArrayList<Item> getItemProdutosList() {
		try {
			ItemList = ejb.findProdutos();
			return ItemList;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}

	
	public void setItemProdutosList(ArrayList<Item> itemProdutosList) {
		ItemProdutosList = itemProdutosList;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	
	public String getIdtem() {
		return idtem;
	}

	public void setIdtem(String idtem) {
		this.idtem = idtem;
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
		if (this.descricao.trim().length() == 0)
			throw new Exception("Informe a Descricao");

		if (this.valor.trim().length() == 0)
			throw new Exception("Informe o Valor");

		if (!n.isNumeric(this.valor))
			throw new Exception("valor apenas numero");
		
		if (this.tipoItem == null)
			throw new Exception("Por favor, selecione um tipo de Item");
	}

	public void gravar() {
		try {
			this.setMsgAviso("");
			this.validation();

			Item dto = new Item(this.descricao, Float.parseFloat(this.valor));
			dto =  ejb.save(dto);
			
			if(tipoItem.equals("produto")){
				Produto produto = new Produto(dto.getIdItem(),Integer.parseInt(this.quantidade),this.local);
				ejbProduto.save(produto);
			}else if(tipoItem.equals("servico")){
				Servico servico = new Servico(dto.getIdItem(),this.especificacao, Integer.parseInt(this.duracao));
				ejbServico.save(servico);
			}

			this.setMsgAviso("Gravação com sucesso");

		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}

}
