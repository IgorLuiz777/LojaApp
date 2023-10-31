package br.com.fiap.dao;

public class TesteBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (GerenciadorBd.obterConexao() == null) {
            System.out.printf("Erro em estabelecer a conexão");
        } else {
            System.out.println("Conexão concluída!");
        }

		
	}

}
