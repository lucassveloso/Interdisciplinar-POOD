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
			if (ProdutoListTodos == null) {

				ProdutoListTodos = new ArrayList<ProdutoItem>();
				ArrayList<Produto> produtos = ejbProduto.findAll();
				Item item;
				for (Produto produto : produtos) {
					if (produto.getQuantidade() != 0) {

						item = ejbItem.find(produto.getIdItem());
						ProdutoListTodos.add(new ProdutoItem(item, produto));
					}
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
		if (valorTotal == null) {
			valorTotal = "0.0";
		}
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
			ProdutoItem produtoSelecionado = new ProdutoItem(
					ejbItem.find(idItemComprado),
					ejbProduto.find(idItemComprado));
			int estoqueProdutoSelecionado = 0;

			for (ProdutoItem produto : ProdutoListTodos) {
				if (produto.getItem().getIdItem() == produtoSelecionado
						.getItem().getIdItem()) {
					estoqueProdutoSelecionado = produto.getProduto()
							.getQuantidade();
				}
			}

			int quantidadeProdutosSelecionado = Integer
					.parseInt(this.quantidade);
			produtoSelecionado.getProduto().setQuantidade(
					quantidadeProdutosSelecionado);

			if (quantidadeProdutosSelecionado <= estoqueProdutoSelecionado) {
				this.msgAviso = "";

				estoqueProdutoSelecionado -= quantidadeProdutosSelecionado;

				for (ProdutoItem produto : ProdutoListTodos) {
					if (produto.getItem().getIdItem() == produtoSelecionado
							.getItem().getIdItem()) {
						produto.getProduto().setQuantidade(
								estoqueProdutoSelecionado);
					}
				}

				if (ProdutoList == null) {
					ProdutoList = new ArrayList<ProdutoItem>();
					ProdutoList.add(produtoSelecionado);
				} else {
					boolean contem = false;
					for (ProdutoItem produto : ProdutoList) {
						if (produto.getItem().getIdItem() == produtoSelecionado
								.getItem().getIdItem()) {
							int quantidadeAtualizada = produto.getProduto()
									.getQuantidade()
									+ produtoSelecionado.getProduto()
											.getQuantidade();
							produto.getProduto().setQuantidade(
									quantidadeAtualizada);
							contem = true;
						}
					}

					if (!contem) {
						ProdutoList.add(produtoSelecionado);
					}

				}

				float valor = 0;

				for (ProdutoItem produto : ProdutoList) {
					valor += (produto.getItem().getValor() * produto
							.getProduto().getQuantidade());

				}

				if (tipoPessoa.equals("aluno")) {
					valor = (float) (valor * 0.90);

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
				produtoEstoque = ejbProduto.find(p.getItem().getIdItem());

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
