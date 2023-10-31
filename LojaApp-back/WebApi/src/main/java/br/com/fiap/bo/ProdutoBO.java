package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.entity.Produto;

public class ProdutoBO {
	
	private ProdutoDao dao;
	
	public List<Produto> buscarProdutos() {
		dao = new ProdutoDao();
		return dao.buscarTodosProdutos();
	}
	
	public Produto buscarPorId(int id) {
		dao = new ProdutoDao();
		return dao.buscarPorId(id);
	}
	
	public void inserir(Produto produto) {
		dao = new ProdutoDao();
		dao.inserir(produto);
	}
	
	public void alterar(Produto produto) {
		dao = new ProdutoDao();
		dao.alterar(produto);
	}
	
	public void excluir(int id) {
		dao = new ProdutoDao();
		dao.remover(id);
	}

}
