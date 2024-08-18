package logic;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;

public class EmailSender {

    public void sendEmailWithQR(String toEmail, String subject, String body, byte[] qrCodeImage) throws AddressException, MessagingException {
        // Configuración del servidor de correo
// Configuración del servidor de correo

        // Configuración del servidor de correo
        String fromEmail = "verificacionvueloproyecto@gmail.com";
        String password = "lqzl tclz iqzx vwxh";

        Properties properties = new Properties();

        // Indica que el servidor SMTP requiere autenticación (nombre de usuario y contraseña)
        properties.put("mail.smtp.auth", "true");

        // Habilita el uso de STARTTLS para asegurar la conexión con cifrado TLS (Transport Layer Security)
        properties.put("mail.smtp.starttls.enable", "true");

        // Especifica el servidor SMTP que se utilizará para enviar correos (smtp.gmail.com para Gmail)
        properties.put("mail.smtp.host", "smtp.gmail.com");

        // Define el puerto a usar para conectarse al servidor SMTP (puerto 587 para conexiones con STARTTLS)
        properties.put("mail.smtp.port", "587");

        // Añadir configuracion adicional para TLS 1.2
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject(subject);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(body, "text/html");

        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        attachmentBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(qrCodeImage, "image/png")));
        attachmentBodyPart.setFileName("CompraQR.png");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        multipart.addBodyPart(attachmentBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
}
