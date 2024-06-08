
package controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Modelo_Moto;

/**
 *
 * @author Edward
 */
public class Ctrl_Moto {
    
    //Metodo para registrar moto
    public boolean guardarMoto(Modelo_Moto moto){
        boolean respuesta=false;
        Connection cx= conexion.ConectionDB.conectar();
        try {
            PreparedStatement st=cx.prepareStatement("insert into producto values (?,?,?,?,?,?,?,?);");
            st.setInt(1, moto.getIdMotocicleta()); //idMoto
            st.setString(2, moto.getNombre());
            st.setString(3, moto.getCilindraje());
            st.setInt(4, moto.getCantidad());
            st.setDouble(5, moto.getPrecio());
            st.setString(6, moto.getDescripcion());
            st.setInt(7, moto.getPorcentajeIva());
            st.setInt(8, moto.getIdCategoria());
            
            if(st.executeUpdate()>0){
                respuesta=true;
            }         
            cx.close();           
        } catch (SQLException e) {
            System.out.println("Error al guardar motocicleta"+e);
        }
        return respuesta;
    }
    
    //Para validar motos
    public boolean existeMoto(String moto){
        boolean respuesta=false;
        String sql="select nombre from producto where nombre='"+moto+"';";
        Statement st;
       
        try {
            Connection cx= conexion.ConectionDB.conectar();
            st=cx.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                respuesta=true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al guardar motocicleta "+e);
        }
        return respuesta;
    }
    
    //Metodo para actualizar motocicleta
    public boolean actualizarMoto(Modelo_Moto moto, int idMoto){
        boolean respuesta=false;
        Connection cx= conexion.ConectionDB.conectar();
        try {
            PreparedStatement st=cx.prepareStatement("update producto set nombre=?, cantidad=?, precio=?, descripcion=?, porcentajeIva=?, id_categoria=? where id_motocicleta='"+idMoto+"'");
            st.setString(1, moto.getNombre());
            st.setInt(2, moto.getCantidad());
            st.setDouble(3, moto.getPrecio());
            st.setString(4, moto.getDescripcion());
            st.setInt(5, moto.getPorcentajeIva());
            st.setInt(6, moto.getIdCategoria());
            
            
            if(st.executeUpdate()>0){
                respuesta=true;
            }
            
            cx.close();
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar motocicleta "+e);
        }
        return respuesta;
    }
    
    //Metodo para eliminar motocicleta
    public boolean eliminarMotocicleta(int idMoto){
        boolean respuesta=false;
        Connection cx= conexion.ConectionDB.conectar();
        try {
            PreparedStatement st=cx.prepareStatement("delete from producto where id_motocicleta='"+idMoto+"'");
            st.executeUpdate();
            
            if(st.executeUpdate()>0){
                respuesta=true;
            }        
            cx.close();           
        } catch (SQLException e) {
            System.out.println("Error al eliminar motocicleta "+e);
        }
        return respuesta;
    }
    
}
