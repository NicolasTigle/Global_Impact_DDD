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

import br.com.gi.resource.bo.EntidadeAssistencialBO;
import br.com.gi.resource.dao.EntidadeAssistencialDAO;
import br.com.gi.resource.to.EntidadeAssistencial;

@Path("/entidade")
public class EntidadeAssistencialResource {

private EntidadeAssistencialBO eb = new EntidadeAssistencialBO();
private EntidadeAssistencialDAO ed = new EntidadeAssistencialDAO();
	
	@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	public List<EntidadeAssistencial> buscar() {
		return eb.listar();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EntidadeAssistencial buscar(@PathParam("id") Long id) {
		return eb.listarId(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar (EntidadeAssistencial entidadeAssistencial, @Context UriInfo uriInfo) {
		eb.inserir(entidadeAssistencial);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(ed.ultimoId()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(EntidadeAssistencial entidadeAssistencial, @PathParam("id") Long id) {
		entidadeAssistencial.setId(id);
		eb.atualiza(entidadeAssistencial);
		return Response.ok().build();
	}
	
}
