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

import br.com.gi.resource.bo.AlimentoBO;
import br.com.gi.resource.dao.AlimentoDAO;
import br.com.gi.resource.to.Alimento;

@Path("/alimento")
public class AlimentoResource {

private AlimentoBO ab = new AlimentoBO();
private AlimentoDAO ad = new AlimentoDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alimento> buscar() {
		return ab.listar();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Alimento buscar(@PathParam("id") Long id) {
		return ab.listarId(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar (Alimento alimento, @Context UriInfo uriInfo) {
		ab.inserir(alimento);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(ad.ultimoId()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(Alimento alimento, @PathParam("id") Long id) {
		alimento.setId(id);
		ab.atualiza(alimento);
		return Response.ok().build();
	}
	
}
