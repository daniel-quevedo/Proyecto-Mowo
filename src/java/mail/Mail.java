/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import EncodeDecode.EncodeDecode;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Daniel
 */
public class Mail {
    
    private String mailEmi;
    private String passEmi;
    private String mailRec;
    private String subject;
    private String message;
    
    private boolean result = false;
    
    public Mail(String mailRec){
        
        
        this.mailRec = mailRec;
        this.mailEmi = "mowoaplication@gmail.com";
        this.passEmi = "mow0_oX12*M_correo";
        this.subject = "Registro de Usuario Mowo_o";
        
    }
    
    public boolean sendMail(){
        
        //codificar el correo**********
        
        EncodeDecode encoDe = new EncodeDecode(this.mailRec);

        String mailEncode = encoDe.encode();
        String mowo_o = "http://localhost:8084/Mowo/pages/validUser/Validate.jsp?m41r=";
        //******************************
        
        
        
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(props);
        
        MimeMessage mail = new MimeMessage(session);
        
        try {
            
            mail.setFrom(new InternetAddress (this.mailEmi));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(this.mailRec));
            mail.setSubject(this.subject);
            mail.addHeader("Content-type", "text/HTML; charset=UTF-8");
            mail.setText(mowo_o+mailEncode+"" , "UTF-8");
            
            //CUERPO DEL CORREO *********************************************************
            
            mail.setContent("<html>\n" +
                                "<head>\n" +
                                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                                    "<title>Restablecer contrase&ntildea</title>\n" +
                                "</head>\n" +
                                "<body style=\"-webkit-text-size-adjust: none; box-sizing: border-box;\n" +
                                            "color: #74787E; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; height: 100%;\n" +
                                            "line-height: 1.4; margin: 0; width: 100% !important;\" bgcolor=\"#F2F4F6\"\n" +
                                ">", "text/html");
            
            mail.setContent("<style type=\"text/css\">\n" +
                                "body {\n" +
                                    "width: 100% !important; height: 100%; margin: 0; line-height: 1.4; background-color: #F2F4F6; color: #74787E; -webkit-text-size-adjust: none;\n" +
                                "}\n" +
                                "@media only screen and (max-width: 600px) {\n" +
                                    ".email-body_inner {\n" +
                                        "width: 100% !important;\n" +
                                    "}\n" +
                                    ".email-footer {\n" +
                                        "width: 100% !important;\n" +
                                    "}\n" +
                                "}\n" +
                                "@media only screen and (max-width: 500px) {\n" +
                                    ".button {\n" +
                                        "width: 100% !important;\n" +
                                    "}\n" +
                                "}\n" +
                                "</style>", "text/css");
            mail.setContent("<span class=\"preheader\" style=\"box-sizing: border-box; display: none !important; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 1px; line-height: 1px; max-height: 0; max-width: 0; mso-hide: all; opacity: 0; overflow: hidden; visibility: hidden;\">Use este enlace para restablecer su contraseña. El enlace solo es válido por 24 horas.</span>\n" +
                                "<table class=\"email-wrapper\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; margin: 0; padding: 0; width: 100%;\" bgcolor=\"#F2F4F6\">\n" +
                                    "<tr>\n" +
                                        "<td align=\"center\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; word-break: break-word;\">\n" +
                                        "<table class=\"email-content\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; margin: 0; padding: 0; width: 100%;\">\n" +
                                            "<tr>\n" +
                                                "<td class=\"email-masthead\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; padding: 25px 0; word-break: break-word;\" align=\"center\">\n" +
                                                    "<a href=\"<?php echo URL; ?>\" class=\"email-masthead_name\" style=\"box-sizing: border-box; color: #bbbfc3; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 16px; font-weight: bold; text-decoration: none; text-shadow: 0 1px 0 white;\">\n" +
                                                        "<h3 class='text-info'> Mowo_o </h3> \n" +
                                                    "</a>\n" +
                                                "</td>\n" +
                                            "</tr>\n"+
                                            "<tr>\n" +
                                                "<td class=\"email-body\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"-premailer-cellpadding: 0; -premailer-cellspacing: 0; border-bottom-color: #EDEFF2; border-bottom-style: solid; border-bottom-width: 1px; border-top-color: #EDEFF2; border-top-style: solid; border-top-width: 1px; box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; margin: 0; padding: 0; width: 100%; word-break: break-word;\" bgcolor=\"#FFFFFF\">\n" +
                                                    "<table class=\"email-body_inner\" align=\"center\" width=\"570\" cellpadding=\"0\" cellspacing=\"0\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; margin: 0 auto; padding: 0; width: 570px;\" bgcolor=\"#FFFFFF\">\n" +
                                                        "<tr>\n" +
                                                            "<td class=\"content-cell\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; padding: 35px; word-break: break-word;\">\n" +
                                                                "<h1 style=\"box-sizing: border-box; color: #2F3133; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 19px; font-weight: bold; margin-top: 0;\" align=\"left\">Hola</h1>\n" +
                                                                "<p style=\"box-sizing: border-box; color: #74787E; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 16px; line-height: 1.5em; margin-top: 0;\" align=\"left\">Recientemente solicit&oacute crear o restablecer su contrase&ntildea para su cuenta en Mowo_o. Use el bot&oacuten de abajo para reiniciarlo. <strong style = \"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif;\"> Este correo solo ser&aacute v&aacutelido durante las pr&oacuteximas 24 horas.</strong></p>\n" +
                                                                "<table class=\"body-action\" align=\"center\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; margin: 30px auto; padding: 0; text-align: center; width: 100%;\">\n" +
                                                                    "<tr>\n" +
                                                                        "<td align=\"center\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; word-break: break-word;\">\n" +
                                                                            "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif;\">\n" +
                                                                                "<tr>\n" +
                                                                                    "<td align=\"center\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; word-break: break-word;\">\n" +
                                                                                        "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif;\">\n" +
                                                                                            "<tr>\n" +
                                                                                                "<td style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; word-break: break-word;\">\n" +
                                                                                                    "<a href=\""+(mowo_o+mailEncode)+"\" class=\"button button--green\" target=\"_blank\" style=\"-webkit-text-size-adjust: none; background: #22BC66; border-color: #22bc66; border-radius: 3px; border-style: solid; border-width: 10px 18px; box-shadow: 0 2px 3px rgba(0, 0, 0, 0.16); box-sizing: border-box; color: #FFF; display: inline-block; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; text-decoration: none;\">Establecer contraseña</a>\n" +
                                                                                                "</td>\n" +
                                                                                            "</tr>\n" +
                                                                                        "</table>\n" +
                                                                                    "</td>\n" +
                                                                                "</tr>\n" +
                                                                            "</table>\n" +
                                                                        "</td>\n" +
                                                                    "</tr>\n" +
                                                                "</table>\n" +
                                                                "<p style=\"box-sizing: border-box; color: #74787E; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 16px; line-height: 1.5em; margin-top: 0;\" align=\"left\">Si no solicit&oacute restablecer la contrase&ntildea, ignore este correo electr&oacutenico o p&oacutengase en contacto con el servicio de asistencia si tiene alguna pregunta. </p>\n" +
                                                                "<p style=\"box-sizing: border-box; color: #74787E; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 16px; line-height: 1.5em; margin-top: 0;\" align=\"left\">Gracias,\n" +
                                                                "<br />Equipo de Mowo_o</p>                                            \n" +
                                                            "</td>\n" +
                                                        "</tr>\n" +
                                                    "</table>\n" +
                                                "</td>\n" +
                                            "</tr>\n"+
                                            "<tr>\n" +
                                                "<td style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; word-break: break-word;\">\n" +
                                                    "<table class=\"email-footer\" align=\"center\" width=\"570\" cellpadding=\"0\" cellspacing=\"0\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; margin: 0 auto; padding: 0; text-align: center; width: 570px;\">\n" +
                                                        "<tr>\n" +
                                                            "<td class=\"content-cell\" align=\"center\" style=\"box-sizing: border-box; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; padding: 35px; word-break: break-word;\">\n" +
                                                                "<p class=\"sub align-center\" style=\"box-sizing: border-box; color: #AEAEAE; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; line-height: 1.5em; margin-top: 0;\" align=\"center\">© Mowo_o. Todos los derechos reservados.</p>\n" +
                                                                "<p class=\"sub align-center\" style=\"box-sizing: border-box; color: #AEAEAE; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; line-height: 1.5em; margin-top: 0;\" align=\"center\">\n" +
                                                                "<br />Cra. 9a Este #108-04 Sur Daniel Eduardo Quevedo Ruiz\n" +
                                                                "<br />311 852 0285\n" +
                                                                "</p>\n" +
                                                            "</td>\n" +
                                                        "</tr>\n" +
                                                    "</table>\n" +
                                                "</td>\n" +
                                            "</tr>\n" +
                                        "</table>\n" +
                                        "</td>\n" +
                                    "</tr>\n" +
                                "</table>\n" +
                            "</body>\n" +
                        "</html>","text/html");
            
            
            //**********************************************************************************
            
            
            
            Transport transport = session.getTransport("smtp");
            transport.connect(this.mailEmi, this.passEmi);
            transport.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transport.close();
            
            this.result = true;
            
            return this.result; 
            
            
        } catch (MessagingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.result; 
    
    }
    
    public static void main(String[] args){
        
        Mail mail = new Mail("vobeb60141@mailetk.com"); 
        
        System.out.println(mail.sendMail());
        
    }
    
    
    
}
