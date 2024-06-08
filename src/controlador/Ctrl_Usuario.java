/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Statement;
import modelo.Modelo_Usuario;
import java.sql.Connection;
import conexion.ConectionDB;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Edward
 */
public class Ctrl_Usuario {

    ConectionDB conector = new ConectionDB();
    //Metodo para iniciar sesion
    public boolean logginUser(Modelo_Usuario user) {
        boolean respuesta = false;
        Connection cx = conector.conectar();
        String sql = "select usuario, contraseña, tipoUsuario from usuario where usuario = '" + user.getUsuario() + "' and contraseña= '" + user.getPassword() + "';";
        Statement st;

        try {
            st = cx.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                user.setTipoU(rs.getString("tipoUsuario"));
                user.restriccion=rs.getString("tipoUsuario");
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesion");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
        }
        return respuesta;

    }

    public boolean guardarUsuario(Modelo_Usuario usuario) {
        boolean respuesta = false;
        Connection cx = conexion.ConectionDB.conectar();
        try {
            PreparedStatement st = cx.prepareStatement("insert into usuario values (?,?,?,?,?,?,?);");
            st.setInt(1, usuario.getId_usuario());
            st.setString(2, usuario.getNombre());
            st.setString(3, usuario.getApellido());
            st.setString(4, usuario.getUsuario());
            st.setString(5, usuario.getTelefono());
            st.setString(6, usuario.getPassword());
            st.setString(7, usuario.getTipoU());
            if (st.executeUpdate() > 0) {
                respuesta = true;
            }
            cx.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario " + e);
        }
        return respuesta;
    }

    //Para validar usuario
    public boolean existeUsuario(String usuario) {
        boolean respuesta = false;
        String sql = "select usuario from usuario where usuario='" + usuario + "';";
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

    //Metodo para actualizar usuario
    public boolean actualizarUsuario(Modelo_Usuario user, int idUsuario) {
        boolean respuesta = false;
        Connection cx = conexion.ConectionDB.conectar();
        try {
            PreparedStatement st = cx.prepareStatement("update usuario set nombre=?, apellido=?, usuario=?, tipoUsuario=?, contraseña=?, telefono=? where idUsuario='" + idUsuario + "'");
            st.setString(1, user.getNombre());
            st.setString(2, user.getApellido());
            st.setString(3, user.getUsuario());
            st.setString(4, user.getTipoU());
            st.setString(5, user.getPassword());
            st.setString(6, user.getTelefono());
            //st.setInt(7, user.getEstado());

            if (st.executeUpdate() > 0) {
                respuesta = true;
            }
            cx.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario " + e);
        }
        return respuesta;
    }

    //Metodo para eliminar usuario
    public boolean eliminarUsuario(int idUsuario) {
        boolean respuesta = false;
        Connection cx = conexion.ConectionDB.conectar();
        try {
            PreparedStatement st = cx.prepareStatement("delete from usuario where idUsuario='" + idUsuario + "'");
            st.executeUpdate();

            if (st.executeUpdate() > 0) {
                respuesta = true;
            }
            cx.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario " + e);
        }
        return respuesta;
    }
}
