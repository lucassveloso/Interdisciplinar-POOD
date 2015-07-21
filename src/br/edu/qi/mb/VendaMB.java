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
import br.edu.qi.dto.ProdutoItem;
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

	public String idPessoaAluno;
	public String idPessoaFuncionario;
	public String idPessoaProfessor;
	public String tipoPessoa;
	public int idItemComprado;
	public String data;
	public String quantidade;
	public String valorTotal;
	public String msgAviso;
	public ArrayList<Venda> VendaList;
	public ArrayList<ProdutoItem> ProdutoList;
	public ArrayList<ProdutoItem> ProdutoListTodos;

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

	public ArrayList<ProdutoItem> getProdutoListTodos() {
		try {
			ProdutoListTodos = new ArrayList<ProdutoItem>();
			ArrayList<Produto> produtos = ejbProduto.findAll();
			Item item;
			for (Produto produto : produtos) {
				if (produto.getQuantidade() != 0) {

					item = ejbItem.find(produto.getIdItem());
					ProdutoListTodos.add(new ProdutoItem(item, produto));
				}
			}

			return ProdutoListTodos;
		} catch (Exception e) {
			this.setMsgAviso("");
			setMessage("msgErro", e.getMessage());
			return null;
		}
	}

	public String getIdPessoaAluno() {
		return idPessoaAluno;
	}

	public void setIdPessoaAluno(String idPessoaAluno) {
		this.idPessoaAluno = idPessoaAluno;
	}

	public String getIdPessoaFuncionario() {
		return idPessoaFuncionario;
	}

	public void setIdPessoaFuncionario(String idPessoaFuncionario) {
		this.idPessoaFuncionario = idPessoaFuncionario;
	}

	public String getIdPessoaProfessor() {
		return idPessoaProfessor;
	}

	public void setIdPessoaProfessor(String idPessoaProfessor) {
		this.idPessoaProfessor = idPessoaProfessor;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ArrayList<ProdutoItem> getProdutoList() {
		if (ProdutoList == null) {
			ProdutoList = new ArrayList<ProdutoItem>();
		}
		return ProdutoList;
	}

	public void setProdutoList(ArrayList<ProdutoItem> ProdutoList) {
		this.ProdutoList = ProdutoList;
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

	private void validationItemComprado() throws Exception {
		System.out.println(tipoPessoa);
		if (this.tipoPessoa == null)
			throw new Exception("Informe o tipo de comprador");

		switch (tipoPessoa) {
		case "aluno":
			if (this.idPessoaAluno.trim().length() == 0)
				throw new Exception("Informe o aluno");
			break;
		case "professor":
			if (this.idPessoaAluno.trim().length() == 0)
				throw new Exception("Informe o professor");
			break;
		case "funcionario":
			if (this.idPessoaAluno.trim().length() == 0)
				throw new Exception("Informe o funcionario");
			break;
		}

		if (this.idItemComprado == 0)
			throw new Exception("Selecione um Produto");

		if (this.quantidade.trim().length() == 0)
			throw new Exception("Informe a quantidade");

		if (!Numeric.isNumeric(this.quantidade))
			throw new Exception("Informe apenas números na quantidade");
	}

	private void validation() throws Exception {
		if (this.tipoPessoa == null)
			throw new Exception("Informe o tipo de comprador");

		switch (tipoPessoa) {
		case "aluno":
			if (this.idPessoaAluno.trim().length() == 0)
				throw new Exception("Informe o aluno");
			break;
		case "professor":
			if (this.idPessoaAluno.trim().length() == 0)
				throw new Exception("Informe o professor");
			break;
		case "funcionario":
			if (this.idPessoaAluno.trim().length() == 0)
				throw new Exception("Informe o funcionario");
			break;
		}
	}

	public void addItemComprado() throws Exception {
		try {
			validationItemComprado();
			int estoque = 0;
			Produto p = ejbProduto.find(idItemComprado);
			Item i = ejbItem.find(idItemComprado);

			int quantidadeProdutos = 0;
			p.setQuantidade(Integer.parseInt(this.quantidade));

			ProdutoItem pi = new ProdutoItem(i, p);
			boolean piExistente = false;

			for (ProdutoItem pro : ProdutoList) {
				if (pro.getItem().getIdItem() == pi.getItem().getIdItem()) {
					int quantidadeAtualizada = pro.getProduto().getQuantidade()
							+ pi.getProduto().getQuantidade();
					pro.getProduto().setQuantidade(quantidadeAtualizada);
					piExistente = true;
					quantidadeProdutos = pro.getProduto().getQuantidade();
				}
			}

			if (!piExistente)
				ProdutoList.add(pi);

			estoque = p.getQuantidade()
					- (Integer.parseInt(this.quantidade) + quantidadeProdutos);
			
			System.out.println(estoque);

			if (estoque > 0) {

				if (valorTotal.equals("")) {
					valorTotal = "0";
				}

				float valor = Float.parseFloat(valorTotal);
				for (ProdutoItem pro : ProdutoList) {
					if (pro.getItem().getValor() != 0
							&& pro.getProduto().getQuantidade() != 0) {
						valor += (pro.getItem().getValor() * pro.getProduto()
								.getQuantidade());
					}
				}
				valorTotal = String.valueOf(valor);
			} else {
				this.setMsgAviso("Não possuimos " + quantidade
						+ " unidades do Produto selecionado");
			}
		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}

	}

	public void gravar() {
		try {
			this.setMsgAviso("");
			validation();
			int idPessoa = 0;

			switch (tipoPessoa) {
			case "aluno":
				idPessoa = Integer.parseInt(idPessoaAluno);
				break;
			case "professor":
				idPessoa = Integer.parseInt(idPessoaProfessor);
				break;
			case "funcionario":
				idPessoa = Integer.parseInt(idPessoaFuncionario);
				break;
			}

			Venda venda = new Venda(idPessoa, Float.parseFloat(valorTotal));

			venda = ejb.save(venda);
			Produto produtoEstoque;
			for (ProdutoItem p : ProdutoList) {
				ItemVenda itemvenda = new ItemVenda(p.getItem().getIdItem(),
						venda.getIdVenda(), p.getProduto().getQuantidade(), p
								.getItem().getValor());
				ejbItemVenda.save(itemvenda);
				System.out.println("ID:::" + p.getItem().getIdItem());
				produtoEstoque = ejbProduto.find(p.getItem().getIdItem());
				System.out.println("qUANTIDADE:::"
						+ (produtoEstoque.getQuantidade() - p.getProduto()
								.getQuantidade()));

				ejbProduto
						.updateEstoque((produtoEstoque.getQuantidade() - p
								.getProduto().getQuantidade()), p.getItem()
								.getIdItem());
			}

			this.setMsgAviso("Gravação com sucesso");

		} catch (Exception ex) {
			this.setMsgAviso("");
			setMessage("msgErro", ex.getMessage());
		}
	}
}
