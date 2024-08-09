package servicio;

import dao.IDao;
import modelo.Odontologo;

import java.util.List;

public class ServicioOdongolo{

    private IDao<Odontologo> odontoloDao;

    public ServicioOdongolo(IDao<Odontologo> odontoloDao) {
        this.odontoloDao = odontoloDao;
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontoloDao.guardar(odontologo);
    }

    public List<Odontologo> todos() {
        return odontoloDao.todos();
    }

}
