package py.com.prueba.rest;

import java.text.SimpleDateFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JacksonObjectMapperProvider implements
             ContextResolver<ObjectMapper> {
 
       public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
       private ObjectMapper objectMapper;
 
       public JacksonObjectMapperProvider() {
             objectMapper = new ObjectMapper();
              objectMapper.setDateFormat(new SimpleDateFormat(DATE_FORMAT));
             //objectMapper.getDeserializationConfig().setDateFormat(new SimpleDateFormat(DATE_FORMAT));
             objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
       }
 
       @Override
       public ObjectMapper getContext(Class<?> arg0) {
             return objectMapper;
       }     
}