/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Edward
 */
public class Modelo_DetalleVenta {
    
    //Atributos
    private int idDetalleVenta;
    private int idCabeceraVenta;
    private int idMotocicletas;
    
    //Otros atributos
    private String nombre;
    private String cilindraje;
    private int cantidad;
    private double precioUnitario;
    private double subTotal;
    private double descuento;
    private double iva;
    private double precioAPagar;
    
    //Constructor
    public Modelo_DetalleVenta(){
        this.idCabeceraVenta=0;
        this.idDetalleVenta=0;
        this.idMotocicletas=0;
        this.nombre="";
        this.cantidad=0;
        this.precioUnitario=0.0;
        this.subTotal=0.0;
        this.descuento=0.0;
        this.iva=0.0;
        this.precioAPagar=0.0;
        
    }

    public Modelo_DetalleVenta(int idDetalleVenta, int idCabeceraVenta, int idMotocicletas, String nombre, String cilindraje, int cantidad, double precioUnitario, double subTotal, double descuento, double iva, double precioAPagar) {
        this.idDetalleVenta = idDetalleVenta;
        this.idCabeceraVenta = idCabeceraVenta;
        this.idMotocicletas = idMotocicletas;
        this.nombre = nombre;
        this.cilindraje=cilindraje;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.iva = iva;
        this.precioAPagar = precioAPagar;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdCabeceraVenta() {
        return idCabeceraVenta;
    }

    public void setIdCabeceraVenta(int idCabeceraVenta) {
        this.idCabeceraVenta = idCabeceraVenta;
    }

    public int getIdMotocicletas() {
        return idMotocicletas;
    }

    public void setIdMotocicletas(int idMotocicletas) {
        this.idMotocicletas = idMotocicletas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCilindraje(){
        return cilindraje;
    }
    
    public void setCilindraje(String cilindraje){
        this.cilindraje=cilindraje;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrecioAPagar() {
        return precioAPagar;
    }

    public void setPrecioAPagar(double precioAPagar) {
        this.precioAPagar = precioAPagar;
    }


    @Override
    public String toString() {
        return "Modelo_DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", idCabeceraVenta=" + idCabeceraVenta + ", idMotocicletas=" + idMotocicletas + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subTotal=" + subTotal + ", descuento=" + descuento + ", iva=" + iva + ", precioAPagar=" + precioAPagar + ", estado="  + '}';
    }
    
    
}
