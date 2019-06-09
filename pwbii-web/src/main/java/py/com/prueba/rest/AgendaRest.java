package py.com.prueba.rest;

import py.com.prueba.ejb.AgendaEJB;
import py.com.prueba.modelo.Agenda;
import py.com.prueba.modelo.Categoria;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import py.com.prueba.modelo.Especialidad;

@Path("agenda")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AgendaRest {
    @Inject
    private AgendaEJB agendaEJB;
    @Context
    protected UriInfo uriInfo;


    @GET
    @Path("/")
    public Response listar() throws WebApplicationException{
        
        List<Agenda> listEntity = null;
        Long total = null;
        total = agendaEJB.total();
        listEntity = agendaEJB.lista();
        Map<String,Object> mapaResultado=new HashMap<String, Object>();
        mapaResultado.put("total", total);
        mapaResultado.put("lista", listEntity);

        return Response.ok(mapaResultado).build();

    }

    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Integer pk) {
        Agenda entityRespuesta =null;
        entityRespuesta = agendaEJB.get(pk);
        return Response.ok(entityRespuesta).build();
    }

    @POST
    @Path("/")
    public Response crear(Agenda entity) throws WebApplicationException {

        agendaEJB.persist(entity);

        UriBuilder resourcePathBuilder = UriBuilder.fromUri(uriInfo
                .getAbsolutePath());
        URI resourceUri=null;
        try {
            resourceUri = resourcePathBuilder
                    .path(URLEncoder.encode(entity.getIdAgenda().toString(), "UTF-8")).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.created(resourceUri).build();
    }

    @PUT
    @Path("/")
    public Response modificar(Agenda entity) throws WebApplicationException {
        agendaEJB.merge(entity);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{pk}")
    public Response borrar(@PathParam("pk") Integer pk) throws WebApplicationException {

        agendaEJB.delete(pk);
        return Response.ok().build();

    }
    
    @GET
    @Path("/categoria")
    public Response listarCategorias() throws WebApplicationException{
        
        List<Categoria> listEntity = null;
        listEntity = agendaEJB.listaCategorias();
        Map<String,Object> mapaResultado=new HashMap<String, Object>();
        mapaResultado.put("categorias", listEntity);

        return Response.ok(mapaResultado).build();

    }
    
    @GET
    @Path("/especialidad")
    public Response listarEspecialidades(@QueryParam("idSucursal") int idSucursal) throws WebApplicationException{
        
        List<Especialidad> listEntity = null;
        listEntity = agendaEJB.listaEspecialidades();
        Map<String,Object> mapaResultado=new HashMap<String, Object>();
        mapaResultado.put("lista", listEntity);

        return Response.ok(mapaResultado).build();

    }
}
