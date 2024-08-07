package logic;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailLogic {

    public static void emailLogic(String to, String subject, String body) {
        // Datos obtenidos del servidor SMTP para configurar el envío de correo 
        Properties props = new Properties();
        
        // Indica que el servidor SMTP requiere autenticación (nombre de usuario y contraseña)
        props.put("mail.smtp.auth", "true");

        // Habilita el uso de STARTTLS para asegurar la conexión con cifrado TLS (Transport Layer Security)
        props.put("mail.smtp.starttls.enable", "true");

        // Especifica el servidor SMTP que se utilizará para enviar correos (smtp.gmail.com para Gmail)
        props.put("mail.smtp.host", "smtp.gmail.com");

        // Define el puerto a usar para conectarse al servidor SMTP (puerto 587 para conexiones con STARTTLS)
        props.put("mail.smtp.port", "587");

        // Añadir configuracion adicional para TLS 1.2
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        // Crear una sesión con autenticación
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("verificacionvueloproyecto@gmail.com", "lqzl tclz iqzx vwxh");
            }
        });

        try {
            // Crear un objeto MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("verificacionvueloproyecto@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // Enviar el correo electrónico
            Transport.send(message);

            System.out.println("¡Correo electrónico enviado con éxito!");

        } catch (MessagingException e) {
            e.printStackTrace(); // Imprime la pila de errores para depuración
        }
    }
        public static void main(String[] args) {
        // Cambia estos valores al correo electrónico del destinatario
        String to = "rodriguezjeremyinfj@gmail.com";
        String subject = "Correo de Prueba";
        String body = "Hola, este es un correo de prueba.";

        emailLogic(to, subject, body);
    }
}
