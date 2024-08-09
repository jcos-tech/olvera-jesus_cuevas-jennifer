package dao;

import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListOdontologoDao implements IDao<Odontologo>{

    private ArrayList<Odontologo> odontologos = new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        if(odontologos.add(odontologo)){
            return odontologo;
        }

        return null;
    }

    @Override
    public List<Odontologo> todos() {
        return odontologos;
    }
}
