/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import vista.InterFacturacion;


/**
 *
 * @author Edward
 */
public class Ctrl_Correo {
    
    private String emailFrom="suzukimotos888@gmail.com";
    private String password="rphm hysc iizt eqbu";
    private String emailTo;
    private String subject;
    private String contenido;
    private Properties prop; 
    private Session sesion;
    private MimeMessage message;
    public int codigo = (int)(Math.random() * 9000) + 1000;;
    
    public Ctrl_Correo(){
         prop=new Properties();       
    }
    
    public void crearCorreo(String correo){
        emailTo=correo;
        subject="VERIFICACION DEL CORREO";
        contenido="Su codigo de verificacion es: "+codigo;
        
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.smtp.port", "587");
        prop.setProperty("mail.smtp.user", emailFrom);
        prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.setProperty("mail.smtp.auth", "true");
        
        sesion=Session.getDefaultInstance(prop);        
        
        try {
            message=new MimeMessage(sesion);
            message.setFrom(new InternetAddress(emailFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            message.setSubject(subject);
            message.setText(contenido, "ISO-8859-1", "html");
            
        } catch (AddressException ex) {
            Logger.getLogger(Ctrl_Correo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Ctrl_Correo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int sendEmail(String email){
        crearCorreo(email);
        try {
            Transport t=sesion.getTransport("smtp");
            t.connect(emailFrom,password);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            JOptionPane.showMessageDialog(null, "Correo enviado");
            
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Ctrl_Correo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Ctrl_Correo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codigo;
    }

    //De crear Correo PDF
    public void crearCorreoPDF(String correo, String ruta, String nombre) {
        emailTo = correo;
        subject = "FACTURA DE COMPRA DE MOTOCICLETA SUZUKI";
        contenido = "¡ Gracias por su compra, se adjunto su factura !";
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.smtp.port", "587");
        prop.setProperty("mail.smtp.user", emailFrom);
        prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.setProperty("mail.smtp.auth", "true");
        sesion = Session.getDefaultInstance(prop);
        try {
            MimeMultipart mPdf = new MimeMultipart();
            //Contenido del correo
            MimeBodyPart mContenido = new MimeBodyPart();
            mContenido.setContent(contenido, "text/html; charset=utf-8");
            mPdf.addBodyPart(mContenido);
            // Adjuntar el archivo PDF
            MimeBodyPart mArchivo = new MimeBodyPart();
            mArchivo.setDataHandler(new DataHandler(new FileDataSource(ruta)));
            mArchivo.setFileName(nombre);
            mPdf.addBodyPart(mArchivo);
            message = new MimeMessage(sesion);
            message.setFrom(new InternetAddress(emailFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            message.setSubject(subject);
            message.setContent(mPdf);
        } catch (AddressException ex) {
            Logger.getLogger(Ctrl_Correo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Ctrl_Correo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendPDF(String correo, String ruta, String nombre) {
        crearCorreoPDF(correo,ruta,nombre);
        boolean terminar= false;
        try {
            Transport t = sesion.getTransport("smtp");
            t.connect(emailFrom, password);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            JOptionPane.showMessageDialog(null, "Correo enviado");
           InterFacturacion f= new InterFacturacion ();
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Ctrl_Correo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex ) {
            JOptionPane.showMessageDialog(null, "Primero conecte a internet");
        }
        
    }
}
