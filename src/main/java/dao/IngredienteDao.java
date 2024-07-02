package dao;

import model.Ingrediente;
import model.Proveedor;
import utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredienteDao {
    public Ingrediente getOne(int id_ingrediente, String nombre_ingrediente){
        Ingrediente ingrediente = new Ingrediente();
        String query = "select * from ingrediente where nombre = ? and id = ?;";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,nombre_ingrediente);
            ps.setInt(2,id_ingrediente);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ingrediente.setNombre_ingrediente(rs.getString("nombre"));
                ingrediente.setId_ingrediente(rs.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ingrediente;
    }

    public Ingrediente getOne(int id_ingrediente){
        Ingrediente ingrediente = new Ingrediente();
        String query = "select * from ingrediente where id = ?;";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id_ingrediente);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ingrediente.setId_ingrediente(rs.getInt("id"));
                ingrediente.setNombre_ingrediente(rs.getString("nombre"));
                ingrediente.setProveedor(rs.getObject("proveedor", Proveedor.class));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ingrediente;
    }

    public boolean insert(Ingrediente ingrediente){
        boolean flag = false;
        String query = "insert into ingrediente(nombre,proveedor) values (?,?);";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,ingrediente.getId_ingrediente());
            ps.setObject(2,ingrediente.getProveedor().getId_proveedor());//duda
            if(ps.executeUpdate()>0){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList<Ingrediente> getAll(){
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        String query = "select * from ingrediente";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setId_ingrediente(rs.getInt("id"));
                ingrediente.setNombre_ingrediente(rs.getString("nombre"));
                ingrediente.setProveedor(rs.getObject("proveedor", Proveedor.class));//duda
                ingredientes.add(ingrediente);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ingredientes;
    }

    public boolean update(Ingrediente ingrediente){
        boolean flag = false;
        String query = "update ingrediente set nombre = ? where id = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,ingrediente.getNombre_ingrediente());
            ps.setInt(2,ingrediente.getId_ingrediente());
            if(ps.executeUpdate()>0){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean eliminarFisico(int id_ingrediente) {
        boolean flag = false;
        String query = "delete from ingrediente where id = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id_ingrediente);
            if(ps.executeUpdate()>0){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }
}
