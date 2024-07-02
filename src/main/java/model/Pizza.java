package model;

import java.util.ArrayList;

public class Pizza {
    private int id_pizza;
    private String nombre_pizza;
    private int precio_pizza;
    private ArrayList<Integer> pizza_ingredientes = new ArrayList<>();

    public Pizza(){
    }

    public Pizza(int id_pizza, String nombre_pizza, int precio_pizza, ArrayList<Integer> pizza_ingredientes) {
        this.id_pizza = id_pizza;
        this.nombre_pizza = nombre_pizza;
        this.precio_pizza = precio_pizza;
        this.pizza_ingredientes = pizza_ingredientes;
    }

    public ArrayList<Integer> getPizza_ingredientes() {
        return pizza_ingredientes;
    }

    public void setPizza_ingredientes(ArrayList<Integer> pizza_ingredientes) {
        this.pizza_ingredientes = pizza_ingredientes;
    }

    public int getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(int id_pizza) {
        this.id_pizza = id_pizza;
    }

    public String getNombre_pizza() {
        return nombre_pizza;
    }

    public void setNombre_pizza(String nombre_pizza) {
        this.nombre_pizza = nombre_pizza;
    }

    public int getPrecio_pizza() {
        return precio_pizza;
    }

    public void setPrecio_pizza(int precio_pizza) {
        this.precio_pizza = precio_pizza;
    }
}