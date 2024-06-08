/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import conexion.ConectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Modelo_CabeceraVenta;
import modelo.Modelo_DetalleVenta;

/**
 *
 * @author Edward
 */
public class Ctrl_RegistrarVenta {
   
    //Variable para saber el ultimo idCabecera
    public static int idCabeceraRegistrada;
    java.math.BigDecimal idColVar;
    
    //Metodo para registrar cabecera venta
    public boolean guardarCabeceraVenta(Modelo_CabeceraVenta cVenta) {
        boolean respuesta = false;
        ConectionDB conector=new ConectionDB();
        Connection cx = conector.conectar();
        try {
            PreparedStatement st = cx.prepareStatement("insert into venta values (?,?,?,?);",
            Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, cVenta.getIdCabecera()); //idCabecera
            st.setInt(2, cVenta.getIdCliente());
            st.setDouble(3, cVenta.getTotalPagar());
            st.setString(4, cVenta.getFecha_Venta());

            if (st.executeUpdate() > 0) {
                respuesta = true;
            }
            
            ResultSet rs=st.getGeneratedKeys();
            
            while(rs.next()){
                idColVar=rs.getBigDecimal(1);
                idCabeceraRegistrada=idColVar.intValue();
            }           
            cx.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar cabecera venta " + e);
        }
        return respuesta;
    }
    
    //Metodo para registrar cliente
    public boolean guardarDetalleVenta(Modelo_DetalleVenta dVenta) {
        boolean respuesta = false;
        ConectionDB conector=new ConectionDB();
        Connection cx = conector.conectar();
        try {
            PreparedStatement st = cx.prepareStatement("insert into detalle_venta values (?,?,?,?,?,?,?,?,?);");
            st.setInt(1, dVenta.getIdDetalleVenta()); //idDetalle venta
            st.setInt(2, idCabeceraRegistrada);
            st.setInt(3, dVenta.getIdMotocicletas());
            st.setInt(4, dVenta.getCantidad());
            st.setDouble(5, dVenta.getPrecioUnitario());
            st.setDouble(6, dVenta.getSubTotal());
            st.setDouble(7, dVenta.getDescuento());
            st.setDouble(8, dVenta.getIva());
            st.setDouble(9, dVenta.getPrecioAPagar());

            if (st.executeUpdate() > 0) {
                respuesta = true;
            }
            cx.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar detalle venta " + e);
        }
        return respuesta;
    }
    
    //Metodo para actualizar motocicleta
    public boolean actualizarMoto(Modelo_CabeceraVenta cabVenta, int idCabVenta){
        boolean respuesta=false;
        Connection cx= conexion.ConectionDB.conectar();
        try {
            PreparedStatement st=cx.prepareStatement("update cabecera_venta set id_cliente=?, estado=? where id_venta='"+idCabVenta+"'");
            st.setInt(1, cabVenta.getIdCliente());
            
            
            if(st.executeUpdate()>0){
                respuesta=true;
            }           
            cx.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cabecera de venta "+e);
        }
        return respuesta;
    }
    
}
