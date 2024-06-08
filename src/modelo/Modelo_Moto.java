/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Edward
 */
public class Modelo_Moto {
    private int idMotocicleta;
    private String nombre;
    private String cilindraje;
    private int cantidad;
    private double precio;
    private String descripcion;
    private int porcentajeIva;
    private int idCategoria;
    
    public Modelo_Moto(){
        this.idMotocicleta=0;
        this.nombre="";
        this.cilindraje="";
        this.cantidad=0;
        this.precio=0.0;
        this.descripcion="";
        this.porcentajeIva=0;
        this.idCategoria=0;
    }

    public Modelo_Moto(int idMotocicleta, String nombre, String clindraje, int cantidad, double precio, String descripcion, int porcentajeIva, int idCategoria) {
        this.idMotocicleta = idMotocicleta;
        this.nombre = nombre;
        this.cilindraje = clindraje;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.porcentajeIva = porcentajeIva;
        this.idCategoria = idCategoria;
    }

    
    
    public int getIdMotocicleta() {
        return idMotocicleta;
    }

    public void setIdMotocicleta(int idMotocicleta) {
        this.idMotocicleta = idMotocicleta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String clindraje) {
        this.cilindraje = clindraje;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(int porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    
    
}
