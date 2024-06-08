/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Edward
 */
public class Modelo_CabeceraVenta {
    
    //Variables
    private int idCabecera;
    private int idCliente;
    private double totalPagar;
    private String fecha_Venta;
    
    //Contructor vacio
    public Modelo_CabeceraVenta(){
        this.idCabecera=0;
        this.idCliente=0;
        this.totalPagar=0.0;
        this.fecha_Venta="";
    }
    
    //Constructor lleno, sobrecarga de constructor.
    public Modelo_CabeceraVenta(int idCabecera, int idCliente, double totalPagar, String fecha_Venta, int estado) {
        this.idCabecera = idCabecera;
        this.idCliente = idCliente;
        this.totalPagar = totalPagar;
        this.fecha_Venta = fecha_Venta;
    }

    public int getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(int idCabecera) {
        this.idCabecera = idCabecera;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getFecha_Venta() {
        return fecha_Venta;
    }

    public void setFecha_Venta(String fecha_Venta) {
        this.fecha_Venta = fecha_Venta;
    }


    @Override
    public String toString() {
        return "Modelo_CabeceraVenta{" + "idCabecera=" + idCabecera + ", idCliente=" + idCliente + ", totalPagar=" + totalPagar + ", fecha_Venta=" + fecha_Venta + ", estado=" + '}';
    }
    
    
    
}
