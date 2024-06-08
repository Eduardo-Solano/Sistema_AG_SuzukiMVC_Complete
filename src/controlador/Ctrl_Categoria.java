/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import modelo.Modelo_Categoria;
import java.sql.ResultSet;
/**
 *
 * @author Edward
 */
public class Ctrl_Categoria {
    
    //Metodo para registrar categoria
    public boolean guardarCategoria(Modelo_Categoria categoria){
        boolean respuesta=false;
        Connection cx= conexion.ConectionDB.conectar();
        try {
            PreparedStatement st=cx.prepareStatement("insert into categoria values (?,?,?);");
            st.setInt(1, 0);
            st.setString(2, categoria.getDescripcion());
            st.setInt(3, categoria.getEstado());
            
            if(st.executeUpdate()>0){
                respuesta=true;
            }
            
            cx.close();
            
        } catch (SQLException e) {
            System.out.println("Error al guardar categoria "+e);
        }
        return respuesta;
    }
    
    //Para validar categoria
    public boolean existeCategoria(String categoria){
        boolean respuesta=false;
        String sql="select descripcion from categoria where descripcion='"+categoria+"';";
        Statement st;
       
        try {
            Connection cx= conexion.ConectionDB.conectar();
            st=cx.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                respuesta=true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al guardar categoria "+e);
        }
        return respuesta;
    }
    
     //Metodo para actualizar categoria
    public boolean actualizarCategoria(Modelo_Categoria categoria, int idCategoria){
        boolean respuesta=false;
        Connection cx= conexion.ConectionDB.conectar();
        try {
            PreparedStatement st=cx.prepareStatement("update categoria set descripcion=? where id_categoria='"+idCategoria+"'");
            st.setString(1, categoria.getDescripcion());
            
            if(st.executeUpdate()>0){
                respuesta=true;
            }
            
            cx.close();
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar categoria "+e);
        }
        return respuesta;
    }
    
    //Metodo para eliminar categoria
    public boolean eliminarCategoria(int idCategoria){
        boolean respuesta=false;
        Connection cx= conexion.ConectionDB.conectar();
        try {
            PreparedStatement st=cx.prepareStatement("delete from categoria where id_categoria='"+idCategoria+"'");
            st.executeUpdate();
            
            if(st.executeUpdate()>0){
                respuesta=true;
            }
            
            cx.close();
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar categoria "+e);
        }
        return respuesta;
    }
    
}
