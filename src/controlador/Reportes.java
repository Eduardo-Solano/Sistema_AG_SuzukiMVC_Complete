/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.ConectionDB;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.InterFacturacion;

/**
 *
 * @author Edward
 */
public class Reportes {
    
InterFacturacion f= new InterFacturacion();        
    //Metodo para generar los reportes de los clientes registrados en el sistema
    public void reportesClientes(){
        Document document=new Document();
        try {
            
           
            PdfWriter.getInstance(document, new FileOutputStream(f.guardarComo()));
            Image header=Image.getInstance("src/imagenes/header1.jpg");
            header.scaleToFit(650,1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //Formato del texto
            Paragraph parrafo=new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nEquipo 3 ©Studens ITO\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma",18, Font.BOLD, BaseColor.DARK_GRAY ));
            parrafo.add("Reporte de Clientes \n\n");
            
            document.open();
            //Agregamos los datos header y parrafo
            document.add(header);
            document.add(parrafo);
            
            PdfPTable table=new PdfPTable(5);
            table.addCell("Codigo");
            table.addCell("Nombres");
            table.addCell("Cedula");
            table.addCell("Telefono");
            table.addCell("Direccion");
            
            try {
                Connection cx=ConectionDB.conectar();
                PreparedStatement st=cx.prepareStatement("select idCliente, concat(nombre,' ', apellido) as nombres, cedula, telefono, direccion from cliente");
                ResultSet rs=st.executeQuery();
                
                if(rs.next()){
                    do{
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                    }while(rs.next());
                    document.add(table);                    
                }                
            } catch (SQLException e) {
                System.out.println("Error en: "+e);                
            }
            document.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente");
            
        } catch (DocumentException e) {
            System.out.println("Error 1 en: "+e);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error 2 en: "+ex);
        }catch (IOException ex) {
            //Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error 3 en: "+ex);
        }
    }
    
    
     //Metodo para generar los reportes de los productos registrados en el sistema
    public void reportesMotocicletas(){
        Document document=new Document();
        try {
            
            PdfWriter.getInstance(document, new FileOutputStream(f.guardarComo()));
            Image header=Image.getInstance("src/imagenes/header1.jpg");
            header.scaleToFit(650,1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //Formato del texto
            Paragraph parrafo=new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nEquipo 3 ©Studens ITO\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma",18, Font.BOLD, BaseColor.DARK_GRAY ));
            parrafo.add("Reporte de Motocicletas \n\n");
            
            document.open();
            //Agregamos los datos header y parrafo
            document.add(header);
            document.add(parrafo);
            //Ajustar columnas
            float [] columnasWidths=new float[]{3,5,5,4,5,7,5,6};
            
            PdfPTable table=new PdfPTable(columnasWidths);
            table.addCell("Codigo");
            table.addCell("Nombre");
            table.addCell("Cilindraje");
            table.addCell("Cantidad");
            table.addCell("Precio");
            table.addCell("Descripcion");
            table.addCell("Por. Iva");
            table.addCell("Categoria");
            
            try {
                Connection cx=ConectionDB.conectar();
                PreparedStatement st=cx.prepareStatement("select p.id_motocicleta, p.nombre, p.cilindraje, p.cantidad, p.precio, p.descripcion, p.porcentajeIva, c.descripcion as categoria from producto as p, categoria as c where p.id_categoria=c.idCategoria;");
                ResultSet rs=st.executeQuery();
                
                if(rs.next()){
                    do{
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                        table.addCell(rs.getString(6));
                        table.addCell(rs.getString(7));
                        table.addCell(rs.getString(8));
                    }while(rs.next());
                    document.add(table);                    
                }                
            } catch (SQLException e) {
                System.out.println("Error en: "+e);                
            }
            document.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente");
            
        } catch (DocumentException e) {
            System.out.println("Error 1 en: "+e);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error 2 en: "+ex);
        }catch (IOException ex) {
            //Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error 3 en: "+ex);
        }
    }
    
    //Metodo para generar los reportes de los productos registrados en el sistema
    public void reportesVentas(){
        Document document=new Document();
        try {
            
           PdfWriter.getInstance(document, new FileOutputStream(f.guardarComo()));
            Image header=Image.getInstance("src/imagenes/header1.jpg");
            header.scaleToFit(650,1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //Formato del texto
            Paragraph parrafo=new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nEquipo 3 ©Studens ITO\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma",18, Font.BOLD, BaseColor.DARK_GRAY ));
            parrafo.add("Reporte de Ventas \n\n");
            
            document.open();
            //Agregamos los datos header y parrafo
            document.add(header);
            document.add(parrafo);
            //Ajustar columnas
            float [] columnasWidths=new float[]{3,9,4,5};
            
            PdfPTable table=new PdfPTable(columnasWidths);
            table.addCell("Codigo");
            table.addCell("Cliente");
            table.addCell("Total Pagar");
            table.addCell("Fecha de venta");
            
            try {
                Connection cx=ConectionDB.conectar();
                PreparedStatement st=cx.prepareStatement("select cv.idVenta as Id, concat(c.nombre,' ',c.apellido) as Cliente, "
                        + "cv.cantidadPagar as Total, cv.fecha as Fecha "
                        + "from venta as cv, cliente as c where cv.idCliente=c.idCliente;");
                ResultSet rs=st.executeQuery();
                
                if(rs.next()){
                    do{
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));

                    }while(rs.next());
                    document.add(table);                    
                }                
            } catch (SQLException e) {
                System.out.println("Error en : "+e);                
            }
            document.close();
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente");
            
        } catch (DocumentException e) {
            System.out.println("Error 1 en: "+e);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error 2 en: "+ex);
        }catch (IOException ex) {
            //Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error 3 en: "+ex);
        }
    }
}
