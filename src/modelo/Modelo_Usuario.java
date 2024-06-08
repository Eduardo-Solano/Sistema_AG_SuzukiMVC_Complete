/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Edward
 */
public class Modelo_Usuario {
    //Atributos
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private String telefono;
    private String tipoU;
    public static String restriccion;

    //Constructor
    public Modelo_Usuario() {
        id_usuario = 0;
        nombre = "";
        apellido = "";
        usuario = "";
        password = "";
        telefono = "";
    }

    public int getId_usuario() {
        return id_usuario;
    }
    
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTipoU(){
        return tipoU;
    }
    
    public void setTipoU(String tipo){
        this.tipoU=tipo;
    }
   
    public String getRestriccion(){
        return restriccion;
    }
    
    public void setRestriccion( String aux){
       restriccion=aux;
    }

}
