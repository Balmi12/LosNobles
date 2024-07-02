package dao;

import model.Pizza;
import model.Proveedor;
import utils.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProveedorDao {
    public Proveedor getOne(int id_proveedor, String nombre_proveedor){
        Proveedor proveedor = new Proveedor();
        String query = "select * from proveedor where nombre = ? and id = ?;";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,nombre_proveedor);
            ps.setInt(2,id_proveedor);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                proveedor.setNombre_proveedor(rs.getString("nombre"));
                proveedor.setId_proveedor(rs.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return proveedor;
    }

    public Proveedor getOne(int id_proveedor){
        Proveedor proveedor = new Proveedor();
        String query = "select * from proveedor where id = ?;";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id_proveedor);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                proveedor.setId_proveedor(rs.getInt("id"));
                proveedor.setNombre_proveedor(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return proveedor;
    }

    public boolean insert(Proveedor proveedor){
        boolean flag = false;
        String query = "insert into proveedor(nombre) values (?);";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,proveedor.getNombre_proveedor());
            if(ps.executeUpdate()>0){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList<Proveedor> getAll(){
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        String query = "select * from proveedor";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Proveedor proveedor = new Proveedor();
                proveedor.setId_proveedor(rs.getInt("id"));
                proveedor.setNombre_proveedor(rs.getString("nombre"));
                proveedores.add(proveedor);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return proveedores;
    }

    public boolean update(Proveedor proveedor){
        boolean flag = false;
        String query = "update proveedor set nombre = ? where id = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,proveedor.getNombre_proveedor());
            ps.setInt(2,proveedor.getId_proveedor());
            if(ps.executeUpdate()>0){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean eliminarFisico(int id_proveedor) {
        boolean flag = false;
        String query = "delete from proveedor where id = ?";
        try{
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,id_proveedor);
            if(ps.executeUpdate()>0){
                flag = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }
}
