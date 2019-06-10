package py.com.prueba.ejb;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerService;
import javax.persistence.Query;

@Singleton
@Startup
public class AcutalizacionDiariaEJB {
       
    @Resource
    TimerService timerService;
    
    @EJB
    ReservaEJB reservaEJB;
    
    @PostConstruct
    public void inicio() {
        System.out.println("-----------INICIO-----------");
        //LocalDate date = LocalDate.now().minusDays(1);
        //Query query = reservaEJB.getEm().createNativeQuery("update reserva set flag_asistio = 'N' " 
        //                +"where fecha = '"+date+"' "
        //                +"and flag_estado = 'R' and flag_asistio is null");
        //Object updated = query.executeUpdate();

        //System.out.println("Actualizaciones: " + updated);
    }

    @Timeout 
    @AccessTimeout(value = 5, unit = TimeUnit.SECONDS) 
    public void actualizarAsistencias() throws ParseException {
        System.out.println("actualizarAsistencias");
        LocalDate date = LocalDate.now().minusDays(1);
        Query query = reservaEJB.getEm().createNativeQuery("update reserva set flag_asistio = 'N' " 
                        +"where fecha = '"+date+"' "
                        +"and flag_estado = 'R' and flag_asistio is null");
        Object updated = query.executeUpdate();

        System.out.println("Actualizaciones: " + updated);
        
    }

}
