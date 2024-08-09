package dao;

import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BDOdontoloDao implements IDao<Odontologo>{

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        Connection connection = null;

        try{

            connection = BD.getCon();

            String sql = "INSERT INTO ODONTOLOGO (NUMERO_MATRICULA,NOMBRE,APELLIDO) VALUES (?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,odontologo.getNumeroMatricula());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());

            if (preparedStatement.executeUpdate() > 0){
                return odontologo;
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {

            try{
                connection.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }

        }

        return odontologo;
    }

    @Override
    public List<Odontologo> todos() {

        Connection connection = null;
        List odontologos = new ArrayList<>();

        try {

            connection = BD.getCon();

            String sql = "SELECT * FROM ODONTOLOGO";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                odontologos.add(
                        new Odontologo(
                                result.getString(1),
                                result.getString(2),
                                result.getString(3))
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                connection.close();
            }catch (SQLException e){
                System.out.println(e);
            }
        }

        return odontologos;
    }
}
