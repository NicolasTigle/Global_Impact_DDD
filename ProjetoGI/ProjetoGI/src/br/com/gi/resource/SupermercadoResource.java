package br.com.gi.resource;

import java.util.List;


import javax.ws.rs.Consumes;
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

import br.com.gi.resource.bo.SupermercadoBO;
import br.com.gi.resource.dao.SupermercadoDAO;
import br.com.gi.resource.to.Supermercado;

@Path("/supermercado")
public class SupermercadoResource {

private SupermercadoBO sb = new SupermercadoBO();
private SupermercadoDAO sd = new SupermercadoDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Supermercado> buscar() {
		return sb.listar();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Supermercado buscar(@PathParam("id") Long id) {
		return sb.listarId(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar (Supermercado supermercado, @Context UriInfo uriInfo) {
		sb.inserir(supermercado);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(sd.ultimoId()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(Supermercado supermercado, @PathParam("id") Long id) {
		supermercado.setId(id);
		sb.atualiza(supermercado);
		return Response.ok().build();
	}
	
}
