package logic;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageGenerator {

    public static String generatePurchaseImage(String[] purchaseDetails, String uniqueId) {
        int width = 400;
        int height = 400;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        
        // Fondo blanco
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        
        // Texto negro
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.PLAIN, 18));
        
        // Escribir cada línea de detalle
        int y = 30;
        for (String line : purchaseDetails) {
            g2d.drawString(line, 10, y);
            y += 30;
        }
        
        g2d.dispose();

        try {
            // Define la ruta donde se guardará la imagen
            String outputPath = "src/resources/qrphotos/compra_" + uniqueId + ".png";
            File file = new File(outputPath);

            // Crear las carpetas si no existen
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs(); // Crear directorios si no existen
            }

            // Guardar la imagen
            ImageIO.write(image, "png", file);
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
