package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.entity.Produto;

public class ProdutoDao {
	
	private Connection conexao;

	public void inserir(Produto produto)  {

		conexao = GerenciadorBd.obterConexao();
		PreparedStatement comandoSQL = null;
		try {
			comandoSQL = conexao.prepareStatement("insert into produtos (codigo, titulo, preco, quantidade) values(?,?,?,?)");
			comandoSQL.setInt(1, produto.getCodigo());
			comandoSQL.setString(2, produto.getTitulo());
			comandoSQL.setDouble(3, produto.getPreco());
			comandoSQL.setInt(4, produto.getQuantidade());


			comandoSQL.executeUpdate();
			conexao.close();
			comandoSQL.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	public void alterar(Produto produto) {
		conexao = GerenciadorBd.obterConexao();
		PreparedStatement comandoSQL = null;
		try {
			comandoSQL = conexao.prepareStatement("update produtos set titulo = ?, preco = ?, quantidade = ? where codigo = ?");
			comandoSQL.setString(1, produto.getTitulo());
			comandoSQL.setDouble(2, produto.getPreco());
			comandoSQL.setInt(3, produto.getQuantidade());
			comandoSQL.setInt(4, produto.getCodigo());

			comandoSQL.executeUpdate();
			conexao.close();
			comandoSQL.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void remover(int codigo) {
		conexao = GerenciadorBd.obterConexao();
		PreparedStatement comandoSQL = null;
		try {
			comandoSQL = conexao.prepareStatement("delete from produtos where codigo = ?");
			comandoSQL.setInt(1, codigo);
			comandoSQL.executeUpdate();
			conexao.close();
			comandoSQL.close();		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Produto buscarPorId(int codigo){
		Produto produto = new Produto();
		conexao = GerenciadorBd.obterConexao();
		PreparedStatement comandoSQL = null;
		try {
			comandoSQL = conexao.prepareStatement("select * from produtos where codigo = ?");
			comandoSQL.setInt(1, codigo);
			ResultSet rs =  comandoSQL.executeQuery();
			if (rs.next())
			{
				produto.setCodigo(rs.getInt(1));
				produto.setTitulo(rs.getString(2));
				produto.setPreco(rs.getDouble(3));
				produto.setQuantidade(4);
			}
			conexao.close();
			comandoSQL.close();

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}


	public ArrayList<Produto> buscarTodosProdutos(){

		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		conexao = GerenciadorBd.obterConexao();
		PreparedStatement comandoSQL = null;
		try {
			comandoSQL = conexao.prepareStatement("select * from produtos order by titulo");
			ResultSet rs =  comandoSQL.executeQuery();
			while (rs.next())
			{
				Produto produto = new Produto();
				produto.setCodigo(rs.getInt(1));
				produto.setTitulo(rs.getString(2));
				//double valor = Double.parseDouble(rs.getString(3));
				produto.setPreco(rs.getDouble(3));
				produto.setQuantidade(rs.getInt(4));
				listaProdutos.add(produto);
			}
			conexao.close();
			comandoSQL.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProdutos;
	}


}
