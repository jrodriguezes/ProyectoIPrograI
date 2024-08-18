/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.URI;

public class SimpleHttpServer {

    private static final int INITIAL_PORT = 8080;
    private static final int MAX_PORT = 8100;
    private static int port;
    private static HttpServer server;
    private static boolean serverStarted = false;

    public static void initializeServer() throws IOException {
        port = findAvailablePort();
        startServer();
    }

    private static int findAvailablePort() {
        for (int currentPort = INITIAL_PORT; currentPort <= MAX_PORT; currentPort++) {
            try (ServerSocket socket = new ServerSocket(currentPort)) {
                System.out.println("Puerto disponible: " + currentPort);
                return currentPort;
            } catch (IOException e) {
                System.out.println("Puerto " + currentPort + " en uso.");
            }
        }
        return INITIAL_PORT; // Retorna el puerto inicial si no encuentra disponible.
    }

    private static void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/qrphotos", new QRImageHandler());
        server.setExecutor(null);
        server.start();
        serverStarted = true;
        System.out.println("Servidor HTTP iniciado en " + getBaseUrl());
    }

    public static String getBaseUrl() {
        try {
            String localIpAddress = InetAddress.getLocalHost().getHostAddress();
            return "http://" + localIpAddress + ":" + port + "/";
        } catch (IOException e) {
            e.printStackTrace();
            return "http://localhost:" + port + "/";
        }
    }

    public static int getPort() {
        return port;
    }


    static class QRImageHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String path = exchange.getRequestURI().getPath();
            String filePath = "src/resources" + path;

            File file = new File(filePath);
            if (file.exists()) {
                exchange.getResponseHeaders().add("Content-Type", "image/png");
                exchange.sendResponseHeaders(200, file.length());
                try (FileInputStream fis = new FileInputStream(file);
                     OutputStream os = exchange.getResponseBody()) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                }
            } else {
                String response = "Archivo no encontrado: " + filePath;
                exchange.sendResponseHeaders(404, response.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            }
        }
    }
}
