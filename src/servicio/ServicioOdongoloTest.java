package servicio;

import dao.BDOdontoloDao;
import dao.IDao;
import dao.ListOdontologoDao;
import modelo.Odontologo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioOdongoloTest {

    @Test
    public void guardarOdontologo(){

        Odontologo odontologo1 = new Odontologo("001A","Jesus","Olvera");
        IDao odontoloDao = new BDOdontoloDao();
        ServicioOdongolo servicioOdongolo1 = new ServicioOdongolo(odontoloDao);

        assertNotNull(servicioOdongolo1.guardar(odontologo1));

    }

    @Test
    public void listaOdontologoNoVacia(){

        Odontologo odontologo2 = new Odontologo("001B","Jennifer","Cuevas");

        IDao listOdontologoDao = new ListOdontologoDao();

        ServicioOdongolo servicioOdongolo2 = new ServicioOdongolo(listOdontologoDao);

        servicioOdongolo2.guardar(odontologo2);

        assertEquals(1,servicioOdongolo2.todos().size());

    }

}