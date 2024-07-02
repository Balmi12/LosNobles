package model;

import dao.ProveedorDao;

public class Ingrediente {
    private int id_ingrediente;
    private String nombre_ingrediente;
    private Proveedor proveedor;

    public Ingrediente(){

    }

    public Ingrediente(int id_ingrediente, String nombre_ingrediente, Proveedor proveedor) {
        this.id_ingrediente = id_ingrediente;
        this.nombre_ingrediente = nombre_ingrediente;
        this.proveedor = proveedor;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getNombre_ingrediente() {
        return nombre_ingrediente;
    }

    public void setNombre_ingrediente(String nombre_ingrediente) {
        this.nombre_ingrediente = nombre_ingrediente;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}