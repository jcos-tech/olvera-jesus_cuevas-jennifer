import dao.BD;
import dao.IDao;
import dao.BDOdontoloDao;
import dao.ListOdontologoDao;
import modelo.Odontologo;
import org.apache.log4j.Logger;
import servicio.ServicioOdongolo;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        final Logger logger = Logger.getLogger(Main.class);

        Odontologo odontologo1 = new Odontologo("001A","Jesus","Olvera");
        Odontologo odontologo3 = new Odontologo("001V","Cristian","Solis");
        Odontologo odontologo2 = new Odontologo("001B","Jennifer","Cuevas");
        Odontologo odontologo4 = new Odontologo("001F","Cindy","Cely");

        BD.generarBD();

        IDao odontoloDao = new BDOdontoloDao();
        IDao listOdontologoDao = new ListOdontologoDao();

        ServicioOdongolo servicioOdongolo1 = new ServicioOdongolo(odontoloDao);
        logger.info(servicioOdongolo1.guardar(odontologo1));
        logger.info( servicioOdongolo1.guardar(odontologo2));

        for (Odontologo odontologo : servicioOdongolo1.todos()) {
            System.out.println(odontologo);
            logger.info(odontologo);
        }

        ServicioOdongolo servicioOdongolo2 = new ServicioOdongolo(listOdontologoDao);
        logger.info(servicioOdongolo2.guardar(odontologo3));
        logger.info(servicioOdongolo2.guardar(odontologo4));

        for (Odontologo odontologo : servicioOdongolo2.todos()) {
            System.out.println(odontologo);
            logger.info(odontologo);
        }

    }
}
