package py.com.prueba.rest;

import py.com.prueba.ejb.SucursalEJB;
import py.com.prueba.modelo.Agenda;
import py.com.prueba.modelo.Categoria;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import py.com.prueba.modelo.Sucursal;

@Path("sucursal")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class SucursalRest {
    @Inject
    private SucursalEJB sucursalEJB;
    @Context
    protected UriInfo uriInfo;
    
    @GET
    @Path("/")
    public Response listar(@QueryParam("categoria_id") Integer categoria_id) throws WebApplicationException{
        System.out.println("LISTAR SUCURSALES");
        System.out.print("LISTAR SUCURSALES");
        List listEntity = null;
        listEntity = sucursalEJB.lista(categoria_id);
        Map<String,Object> mapaResultado=new HashMap<String, Object>();
        mapaResultado.put("lista", listEntity);

        return Response.ok(mapaResultado).build();

    }
    
    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Integer pk) {
        Sucursal entityRespuesta =null;
        entityRespuesta = sucursalEJB.get(pk);
        return Response.ok(entityRespuesta).build();
    }
}
