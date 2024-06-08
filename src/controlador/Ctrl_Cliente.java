/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Modelo_Cliente;

/**
 *
 * @author Edward
 */
public class Ctrl_Cliente {

    //Metodo para registrar cliente
    public boolean guardarCliente(Modelo_Cliente cliente) {
        boolean respuesta = false;
        Connection cx = conexion.ConectionDB.conectar();
        try {
            PreparedStatement st = cx.prepareStatement("insert into cliente values (?,?,?,?,?,?,?);");
            st.setInt(1, 0); //idMoto
            st.setString(2, cliente.getNombre());
            st.setString(3, cliente.getApellido());
            st.setString(4, cliente.getCedula());
            st.setString(5, cliente.getTelefono());
            st.setString(6, cliente.getDireccion());
            st.setString(7, cliente.getCorreo());

            if (st.executeUpdate() > 0) {
                respuesta = true;
            }

            cx.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar cliente " + e);
        }
        return respuesta;
    }

    //Para validar cliente
    public boolean existeCliente(String nombre) {
        boolean d = true;
        Statement st;
        ResultSet rs = null;
        try {
            Connection cx = conexion.ConectionDB.conectar();
            st = cx.createStatement();
            rs = st.executeQuery("Select  *  from cliente where nombre='"+nombre+"';");
            while (rs.next()) {
                String aux = rs.getString(6);
                if (nombre.equalsIgnoreCase(aux)) {
                    d = false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar clienteee" + e);
        }
        return d;
    }

    public boolean existeCedula(String cedula) {
        boolean respuesta = false;
        String sql = "select cedula from cliente where cedula='" + cedula + "';";
        Statement st;

        try {
            Connection cx = conexion.ConectionDB.conectar();
            st = cx.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario " + e);
        }
        return respuesta;
    }

    //Metodo para actualizar cliente
    public boolean actualizarCliente(Modelo_Cliente cliente, int idCliente) {
        boolean respuesta = false;
        Connection cx = conexion.ConectionDB.conectar();
        try {
            PreparedStatement st = cx.prepareStatement("update cliente set nombre=?, apellido=?, direccion=?, telefono=?, cedula=?, correo=? where idCliente='" + idCliente + "'");
            st.setString(1, cliente.getNombre());
            st.setString(2, cliente.getApellido());
            st.setString(3, cliente.getDireccion());
            st.setString(4, cliente.getTelefono());
            st.setString(5, cliente.getCedula());
            st.setString(6, cliente.getCorreo());

            if (st.executeUpdate() > 0) {
                respuesta = true;
            }
            cx.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente " + e);
        }
        return respuesta;
    }

    public static String auxiliar = "";

    public static String buscarCliente(String cedula) {
        String sql = "select nombre, apellido from cliente where cedula='" + cedula + "';";
        Statement st;

        try {
            Connection cx = conexion.ConectionDB.conectar();
            st = cx.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                auxiliar = rs.getString("nombre") + " " + rs.getString("apellido");
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar cliente " + e);
        }
        System.out.println("Parametro enviado al Internal");
        System.out.println(auxiliar);
        return auxiliar;
    }

    //Metodo para eliminar cliente
    public boolean eliminarCiente(int idCliente) {
        boolean respuesta = false;
        Connection cx = conexion.ConectionDB.conectar();
        try {
            PreparedStatement st = cx.prepareStatement("delete from cliente where idCliente='" + idCliente + "'");
            st.executeUpdate();

            if (st.executeUpdate() > 0) {
                respuesta = true;
            }

            cx.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente " + e);
        }
        return respuesta;
    }

    //Existe correo
    //Para validar correo
    public boolean existeCorreo(String correo) {
        boolean respuesta = false;
        String sql = "select correo from cliente where correo='" + correo + "';";
        Statement st;

        try {
            Connection cx = conexion.ConectionDB.conectar();
            st = cx.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar cliente " + e);
        }
        return respuesta;
    }

    //Para buscar correo
    public static String auxCorreo = "";

    public static String buscarCorreo(int idCliente) {
        String sql = "select correo from cliente where id_cliente='" + idCliente + "';";
        Statement st;

        try {
            Connection cx = conexion.ConectionDB.conectar();
            st = cx.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                auxCorreo = rs.getString("correo");
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar correo " + e);
        }
        System.out.println("Parametro enviado al Internal");
        System.out.println(auxCorreo);
        return auxCorreo;
    }
}
