package dao;

import model.Pizza;
import utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PizzaDao {
    //id, nombre, precio
    public Pizza getOne(int id_pizza, String nombre_pizza, int precio_pizza){
        Pizza pizza = new Pizza();
        String query = "select * from Pizza where nombre = ? and id = ? and precio = ?;";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,nombre_pizza);
            ps.setInt(2,id_pizza);
            ps.setInt(3,precio_pizza);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pizza.setNombre_pizza(rs.getString("nombre"));
                pizza.setPrecio_pizza(rs.getInt("precio"));
                pizza.setId_pizza(rs.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pizza;
    }

    //Primera parte de modificar usuario
    public Pizza getOne(int id_pizza){
        Pizza pizza = new Pizza();
        String query = "select * from Usuario where id = ?;";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id_pizza);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pizza.setId_pizza(rs.getInt("id"));
                pizza.setNombre_pizza(rs.getString("nombre"));
                pizza.setPrecio_pizza(rs.getInt("precio"));
                pizza.setPizza_ingredientes(rs.getInt())
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pizza;
    }

    //Insert para un nuevo usuario
    public boolean insert(Usuario u){
        boolean flag = false;
        String query = "insert into usuario(nombre,contra,correo) values (?,sha2(?,256),?);";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,u.getNombre());
            ps.setString(2,u.getContra());
            ps.setString(3,u.getCorreo());
            if(ps.executeUpdate()>0){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    //Read pero para TODOS
    public ArrayList<Usuario> getAll(){
        ArrayList<Usuario> lista = new ArrayList<>();
        String query = "select * from usuario";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setContra(rs.getString("contra"));
                u.setCorreo(rs.getString("correo"));
                u.setEstado(rs.getBoolean("estado"));
                lista.add(u);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public boolean update(Pizza pizza){
        boolean flag = false;
        String query = "update pizza set nombre = ?, precio = ? where id = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,pizza.getNombre_pizza());
            ps.setInt(2,pizza.getPrecio_pizza());
            ps.setInt(3,pizza.getId_pizza());
            if(ps.executeUpdate()>0){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

}
