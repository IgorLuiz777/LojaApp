package br.com.fiap.resource;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ProdutoBO;
import br.com.fiap.entity.Produto;

//Controller | Resource
@Path("/produtos")
public class ProdutoResource {
	
	private ProdutoBO produtoBo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> buscar() {
		produtoBo = new ProdutoBO();
		return produtoBo.buscarProdutos();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto buscarPorId(@PathParam("id") int codigo) {
		produtoBo = new ProdutoBO();
		return produtoBo.buscarPorId(codigo);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Produto produto, @Context UriInfo uriInfo) {
		produtoBo = new ProdutoBO();
		produtoBo.inserir(produto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString((produto.getCodigo())));
		return Response.created(builder.build()).build();
	}
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(Produto produto, @PathParam("id") int id) {
		produtoBo = new ProdutoBO();
		produto.setCodigo(id);
		produtoBo.alterar(produto);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
	    produtoBo = new ProdutoBO();
	    produtoBo.excluir(id);    
	}

}
	


