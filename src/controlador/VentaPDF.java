/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import conexion.ConectionDB;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import vista.InterFacturacion;

/**
 *
 * @author Edward
 */
public class VentaPDF {
    
    //Variables
    private String nombreCliente;
    private String cedulaCliente;
    private String telefonoCliente;
    private String direccionCliente;
    private String fechaActual="";
    
    private String nombreArchivo="";
    
    //Metodo para obtener los datos del cliente
    public void datosCliente(int idCliente){
        Connection cx=ConectionDB.conectar();
        String sql="select *from cliente where idCliente='"+idCliente+"';";
        Statement st;
        
        try {
            st=cx.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                nombreCliente=rs.getString("nombre")+" "+rs.getString("apellido");
                cedulaCliente=rs.getString("cedula");
                telefonoCliente=rs.getString("telefono");
                direccionCliente=rs.getString("direccion");
            }
            cx.close();
            
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos del cliente "+e);
        }
    }
    
    //Metodo para generar factura de venta
    public void generarFacturaPDF(String ruta){
        
        try {
           
            //Cargar fecha_actual
            Date date=new Date();
            fechaActual=new SimpleDateFormat("yyyy/MM/dd").format(date);
            //Cambiar formato de fecha
            String nuevaFecha="";
            for(int i=0; i<fechaActual.length();i++){
                if(fechaActual.charAt(i)=='/'){
                    nuevaFecha=fechaActual.replace("/", "_");
                }
            }
            nombreArchivo="Venta_"+nombreCliente+"_"+nuevaFecha+".pdf";
            
            FileOutputStream archivo;
            File file=new File(ruta);
            archivo=new FileOutputStream(file);
            
            Document doc=new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            
            //Colocar imagen
            Image img=Image.getInstance("src/motos/Suzuki-logo.png");
            Paragraph fecha=new Paragraph();
            Font negrita=new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);//Agregar nueva linea
            fecha.add("Comprobante: 001" + "\n.Fecha: "+fechaActual+"\n\n");
            
            //Diseño del encabezado (imagen,informacion y fecha)
            PdfPTable encabezado=new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);//Para quitar el borde de la tabla
            //tamaño de las celdas
            float []columnasEnc=new float[]{20f,30f,70f,40f};
            encabezado.setWidths(columnasEnc);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //Agregar celdas    
            encabezado.addCell(img);//Celda con imagen
            
            String ruc="091802200406";
            String nombre="SUZUKI MOTOS SA. CV";
            String telefono="9541829814";
            String direccion="Oaxaca de Juarez";
            String razonSocial="Conquista las calles con tu motocicleta favorita";           
            
            encabezado.addCell("");
            encabezado.addCell("RFC: "+ruc+"\nNombre: "+nombre+"\nTelefono: "+telefono+"\nDireccion: "+direccion+"\nRazon Social: "+razonSocial);
            encabezado.addCell(fecha);
            
            doc.add(encabezado);
            
            //Diseño del cuerpo del documento
            Paragraph cliente=new Paragraph();
            cliente.add(Chunk.NEWLINE);//Nueva Linea
            cliente.add("Datos del cliente: "+"\n\n");
            doc.add(cliente);
            
            //Datos del cliente
            PdfPTable tablaCliente=new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);//Quitar border
            //Tamaño de celdas
            float [] columnaCliente=new float[]{35f, 45f, 30f, 30f};
            tablaCliente.setWidths(columnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1=new PdfPCell(new Phrase("Cedula/RFC: ", negrita));
            PdfPCell cliente2=new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cliente3=new PdfPCell(new Phrase("Telefono: ", negrita));
            PdfPCell cliente4=new PdfPCell(new Phrase("Direccion:", negrita));
            //Quitar border
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);
            //Agregar las celdas a la tabla
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(direccionCliente);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(telefonoCliente);
            tablaCliente.addCell(cedulaCliente);
            //Agregar al documento
            doc.add(tablaCliente);
            
            //Espacio en Blanco
            Paragraph espacio=new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);
            //Agregar los productos
            PdfPTable tablaProducto=new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            //Tamaño de las celdas
            float [] columnaProducto=new float[]{15f, 45f, 20f, 20f};
            tablaProducto.setWidths(columnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1=new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell producto2=new PdfPCell(new Phrase("Descripcion: ", negrita));
            PdfPCell producto3=new PdfPCell(new Phrase("Precio Unitario: ", negrita));
            PdfPCell producto4=new PdfPCell(new Phrase("Precio Total: ", negrita));
            //Quitar bordes
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            //agregar color al encabezado producto
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //Agregar celdas
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);
            
            for(int i=0; i<InterFacturacion.tablaProductos.getRowCount();i++){
                String producto=InterFacturacion.tablaProductos.getValueAt(i, 1).toString();
                String cantidad=InterFacturacion.tablaProductos.getValueAt(i, 3).toString();
                String precio=InterFacturacion.tablaProductos.getValueAt(i, 4).toString();
                String total=InterFacturacion.tablaProductos.getValueAt(i, 8).toString();
                
                tablaProducto.addCell(cantidad);
                 tablaProducto.addCell(producto);
                tablaProducto.addCell(precio);
                tablaProducto.addCell(total);
            }
            //Agregar al documento
            doc.add(tablaProducto);
            
            //total a pagar
            Paragraph info=new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: "+InterFacturacion.txtTotalPagar.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            //Firma
            Paragraph firma=new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Firma\n\n");
            firma.add("_______________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            
            //Mensaje
            //Firma
            Paragraph mens=new Paragraph();
            mens.add(Chunk.NEWLINE);
            mens.add("¡ Gracias por su compra !");
            mens.setAlignment(Element.ALIGN_CENTER);
            doc.add(mens);
            
            //Cerrar documento y archivo
            doc.close();
            archivo.close();
            
            //Abrir al ser generado
            
        }catch(DocumentException | IOException e) {
            System.out.println("Error en: "+e);
        }
    }
    
}
