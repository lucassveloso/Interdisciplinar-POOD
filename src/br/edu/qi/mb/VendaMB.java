package br.edu.qi.mb;

import java.util.Date;
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
import br.edu.qi.bean.ItemVendaBean;
import br.edu.qi.bean.ProdutoBean;
import br.edu.qi.bean.VendaBean;
import br.edu.qi.dto.Item;
import br.edu.qi.dto.ItemVenda;
import br.edu.qi.dto.Produto;
import br.edu.qi.dto.Venda;
import br.edu.qi.util.Numeric;

@ManagedBean
@ViewScoped
@SessionScoped
public class VendaMB {

	@EJB
	VendaBean ejb;
	@EJB
	ItemBean ejbItem;
	@EJB
	ProdutoBean ejbProduto;
	@EJB
	ItemVendaBean ejbItemVenda;

	public String idPessoa;
	public int idItemComprado;
	public String data;
	public String quantidade;
	public String valorTotal;
	public String msgAviso;
	public ArrayList<Venda> VendaList;
	public ArrayList<Produto> ProdutoList;

	public ArrayList<Venda> getVendaList() {
		try {
			VendaList = ejb.findAll();
			return VendaList;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ArrayList<Produto> getProdutoList() {
		if (ProdutoList == null) {
			ProdutoList = new ArrayList<Produto>();
		}
		return ProdutoList;
	}

	public void setProdutoList(ArrayList<Produto> ProdutoList) {
		ProdutoList = ProdutoList;
	}

	public int getidItemComprado() {
		return idItemComprado;
	}

	public void setidItemComprado(int idItemComprado) {
		this.idItemComprado = idItemComprado;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getValorTotal() throws Exception {

		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
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

	}

	public void addItemComprado() throws Exception {
		System.out.println(idItemComprado);
		Produto p = ejbProduto.find(idItemComprado);
		Item i = ejbItem.find(idItemComprado);

		int estoque = p.getQuantidade() - Integer.parseInt(this.quantidade);
		System.out.println(estoque);
		if (estoque > 0) {
			p.setQuantidade(Integer.parseInt(this.quantidade));
			// Eu sei que é gamb...
			p.setLocal(i.getDescricao());
			ProdutoList.add(p);

			if (valorTotal.equals("")) {
				valorTotal = "0";
			}

			float valor = Float.parseFloat(valorTotal);

			Item item = new Item();
			for (Produto pro : ProdutoList) {
				item = ejbItem.find(pro.getIdItem());
				if (item.getValor() != 0 && pro.getQuantidade() != 0) {
					valor += (item.getValor() * pro.getQuantidade());
				}
			}
			valorTotal = String.valueOf(valor);
		} else {
			this.setMsgAviso("Não possuimos " + quantidade
					+ " unidades do Produto selecionado");
		}

	}

	public void gravar() {
		try {
			this.setMsgAviso("");

			Venda venda = new Venda(Integer.parseInt(idPessoa), Float.parseFloat(valorTotal));
			System.out.println("valor::::" + Float.parseFloat(valorTotal));
			venda = ejb.save(venda);

			for (Produto p : ProdutoList) {
				Item item = ejbItem.find(p.getIdItem());
				ItemVenda itemvenda = new ItemVenda(p.getIdItem(),
						venda.getIdVenda(), p.getQuantidade(), item.getValor());
				ejbItemVenda.save(itemvenda);
			}

			this.setMsgAviso("Gravação com sucesso");

		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}
}
