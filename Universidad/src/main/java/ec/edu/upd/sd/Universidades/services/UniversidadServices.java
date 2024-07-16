package ec.edu.upd.sd.Universidades.services;

import java.util.List;

import ec.edu.upd.sd.Universidades.business.GestionUniversidad;
import ec.edu.upd.sd.Universidades.model.Universidades;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("uni")
public class UniversidadServices {

	@Inject
	private GestionUniversidad gUni;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear (Universidades Universidades) {
		//Span span = tracer.buildSpan("creacion de mensajes").start();
		try{
			gUni.guardarUniversidads(Universidades);
			ErrorMessage error = new ErrorMessage(1, "ok");
			return Response.status(Response.Status.CREATED).entity(error).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
			
		} 
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Universidades mensajeusuarios) {
		//Span span = tracer.buildSpan("actualizar mensajes").start();
		try{
			gUni.actualizarUniversidad(mensajeusuarios);
			return Response.ok(mensajeusuarios).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		} 
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@QueryParam("id") int codigo) {
		//Span span = tracer.buildSpan("borrar mensajes").start();
	    try {
	        gUni.borrarCliente(codigo);
	        
	        return Response.ok("OK, se borró el Usuario").build();
	    } catch (Exception e) {
	        ErrorMessage error = new ErrorMessage(99, "Error al eliminar el Usuario: " + e.getMessage());
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(error)
	                .build();
	    }
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Universidades> mensajes = gUni.getMensajes();
		if(mensajes.size()>0)
			return Response.ok(mensajes).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran clientes");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
	}
}
