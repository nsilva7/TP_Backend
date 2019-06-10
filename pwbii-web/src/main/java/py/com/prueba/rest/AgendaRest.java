package py.com.prueba.rest;

import py.com.prueba.ejb.AgendaEJB;
import py.com.prueba.modelo.Agenda;
import py.com.prueba.modelo.Categoria;
import py.com.prueba.modelo.Especialidad;
import py.com.prueba.modelo.Reserva;
import py.com.prueba.ejb.ReservaEJB;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import py.com.prueba.modelo.Especialidad;
import py.com.prueba.modelo.Persona;

@Path("agenda")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AgendaRest {
    @Inject
    private AgendaEJB agendaEJB;
    @Inject
    private ReservaEJB reservaEJB;
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
        listEntity = agendaEJB.listaEspecialidades(idSucursal);
        Map<String,Object> mapaResultado=new HashMap<String, Object>();
        mapaResultado.put("lista", listEntity);

        return Response.ok(mapaResultado).build();

    }
    
    @GET
    @Path("/profesionales")
    public Response listarProfesionales(@QueryParam("idSucursalServicio") int idSucursalServicio) throws WebApplicationException{
        
        List<Persona> listEntity = null;
        listEntity = agendaEJB.listaProfesionales(idSucursalServicio);
        Map<String,Object> mapaResultado=new HashMap<String, Object>();
        mapaResultado.put("lista", listEntity);

        return Response.ok(mapaResultado).build();

    }
    
    @POST
    @Path("/reserva")
    public Response reservar(Reserva entity) throws WebApplicationException {
        reservaEJB.persist(entity);

        UriBuilder resourcePathBuilder = UriBuilder.fromUri(uriInfo
                .getAbsolutePath());
        URI resourceUri=null;
        try {
            resourceUri = resourcePathBuilder
                    .path(URLEncoder.encode(entity.getIdReserva().toString(), "UTF-8")).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.created(resourceUri).build();
    }
    
    @GET
    @Path("/reserva")
    public Response listar(
            @QueryParam("fechaDesde") String fecha_desde,
            @QueryParam("fechaHasta") String fecha_hasta,
            @QueryParam("horaDesde") String hora_desde,
            @QueryParam("horaHasta") String hora_hasta,
            @QueryParam("idServicio") Integer id_servicio,
            @QueryParam("idEspecialidad") Integer id_especialidad,
            @QueryParam("idEmpleado") Integer id_empleado,            
            @QueryParam("idLocal") Integer id_local,
            @QueryParam("idsucursal") Integer id_sucursal,
            @QueryParam("estado") String estado,
            @QueryParam("asistio") String asistio,
            @QueryParam("from") Integer from,
            @QueryParam("to") Integer to
    ) throws WebApplicationException{
        List list = reservaEJB.lista(fecha_desde, fecha_hasta, hora_desde, hora_hasta,
            id_servicio, id_especialidad, id_empleado, id_local, id_sucursal,
            estado, asistio, from, to
        );
        
        return Response.ok(list).build();

    }
    
    @GET
    @Path("/reserva/disponible")
    public Response listar(@QueryParam("idSucursalServicio") int idSucursalServicio,@QueryParam("fecha") String fecha,@QueryParam("idEmpleado") Integer idEmpleado ) throws WebApplicationException, ParseException{
        System.out.println("listarDisponibles");
        ArrayList<Map<String, String>> listEntity = null;
        Long total = null;
        if(idEmpleado == null)
            idEmpleado = 0;
        listEntity = reservaEJB.listaDisponibles(idSucursalServicio ,fecha, idEmpleado);
        Map<String,Object> mapaResultado=new HashMap<String, Object>();
        mapaResultado.put("lista", listEntity);

        return Response.ok(mapaResultado).build();
    }
    
    @PUT
    @Path("/reserva")
    public Response modificar(Reserva entity) throws WebApplicationException {
        return Response.ok(reservaEJB.actualizar(entity)).build();
    }
}
