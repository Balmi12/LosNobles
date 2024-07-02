package dao;

import model.Pizza;
import model.Proveedor;
import utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PizzaDao {
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
        String query = "select * from pizza where id_pizza = ?;";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id_pizza);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pizza.setId_pizza(rs.getInt("id"));
                pizza.setNombre_pizza(rs.getString("nombre"));
                pizza.setPrecio_pizza(rs.getInt("precio"));
                pizza.setPizza_ingredientes((ArrayList<Integer>) rs.getArray("pizza_ingredientes"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pizza;
    }

    //Insert para un nuevo usuario
    public boolean insert(Proveedor proveedor){
        boolean flag = false;
        String query = "insert into proveedor(id_proveedor ,nombre_proveedor) values (?,sha2(?,256),?);";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(2,proveedor.getId_proveedor());
            ps.setString(1,proveedor.getNombre_proveedor());
            if(ps.executeUpdate()>0){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    //Read pero para TODOS
    public ArrayList<Proveedor> getAll(){
        ArrayList<Proveedor> lista = new ArrayList<>();
        String query = "select * from proveedor";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Proveedor proveedor = new Proveedor();
                proveedor.setId_proveedor(rs.getInt("id"));
                proveedor.setNombre_proveedor(rs.getString("nombre"));
                lista.add(proveedor);
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
