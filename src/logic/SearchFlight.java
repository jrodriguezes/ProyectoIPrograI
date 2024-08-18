package logic;

import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objects.Aeropuerto;
import objects.Historial;
import objects.Usuario;
import objects.Vuelo;
import presentacion.FlightSearch;
import presentacion.dialogSeats;

public class SearchFlight {

    // Método para agregar un historial de vuelo
    public void addHistory(String[] history) {
        actualData actualData = new actualData();
        List<Historial> actualHistory = actualData.getFlightHistory();

        Historial newHistory = new Historial();
        SimpleDateFormat actualDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            newHistory.setIdHistorial(Integer.parseInt(history[0]));
            newHistory.setIdPassenger(Integer.parseInt(history[1]));
            newHistory.setIdDepartureAirport(Integer.parseInt(history[2]));
            newHistory.setIdArrivalAirport(Integer.parseInt(history[3]));
            newHistory.setIdStopoverAirport(Integer.parseInt(history[4]));
            newHistory.setRealTimeFlightBought(actualDate.parse(history[5]));
            newHistory.setAmountOfTickets(Integer.parseInt(history[6]));
            newHistory.setSeats(history[7]);
            newHistory.setTotalDuration(Integer.parseInt(history[8]));
            newHistory.setTotalCost(Integer.parseInt(history[9]));
            int idFlight = Integer.parseInt(history[10]);
            Vuelo flight = getFlightById(idFlight, actualData.getFlights());
            if (flight != null) {
                newHistory.setIdFlight(idFlight);
                actualHistory.add(newHistory);
                actualData.setFlightHistory(actualHistory);
            } else {
                throw new Exception("El vuelo con ID " + idFlight + " no existe.");
            }
            newHistory.setIdScale(Integer.parseInt(history[11]));

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al parsear la fecha: " + e.getMessage());
            e.printStackTrace();
            return;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al parsear un numero: " + e.getMessage());
            e.printStackTrace();
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar agregar un historial: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        
    }

    // Generar un ID unico para el historial
    public int generateUniqueHistoryId() {
        return (int) (Math.random() * 100000);
    }

    // Obtener el ID del aeropuerto por nombre
    public int getAirportIdByName(String nameAiport) {
        actualData actualData = new actualData();
        List<Aeropuerto> actualAirport = actualData.getAirports();
        for (Aeropuerto airport : actualAirport) {
            if (airport.getAirportName().equals(nameAiport)) {
                return airport.getIdAirport();
            }
        }
        return -2;
    }

    public String generateActualDate() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(now);
    }

    private Vuelo getFlightById(int idFlight, List<Vuelo> flights) {
        for (Vuelo flight : flights) {
            if (flight.getIdFlight() == idFlight) {
                return flight;
            }
        }
        return null;
    }

    public String getClientNameById(int id) {
        actualData actualData = new actualData();
        List<Usuario> passengersData = actualData.getPassengers();

        for (Usuario actualUser : passengersData) {
            if (actualUser.getIdUser() == id) {
                return actualUser.getUserName();
            }
        }
        return "Error al conseguir nombre del cliente";
    }

    public String getEmailByUserId(int userid) {
        actualData actualData = new actualData();
        List<Usuario> userData = actualData.getPassengers();
        for (Usuario actualUser : userData) {
            if (actualUser.getIdUser() == userid) {
                return actualUser.userMail;
            }
        }
        return "Error al obtener el correo del usuario";
    }

    public int getIdStopoverByIdFlight(int stopoverFlight) {
        actualData actualData = new actualData();
        List<Vuelo> flightData = actualData.getFlights();
        for (Vuelo actualFlight : flightData) {
            if (actualFlight.getIdFlight() == stopoverFlight) {
                return actualFlight.getIdFlight();
            }
        }
        return 0;
    }

    public void processPurchase(int userId, int selectedRow, javax.swing.JTable jTable1, javax.swing.JSpinner spinnerPassengers) {
        boolean disponibles = true;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int columnCount = model.getColumnCount();

        if (columnCount < 10) {
            JOptionPane.showMessageDialog(null, "La tabla no tiene suficientes columnas para procesar la compra.");
            return;
        }

        // Obtener valores del modelo en lugar de la tabla directamente
        String aerolinea = (String) model.getValueAt(selectedRow, 0);
        String aeropuertoSalida = (String) model.getValueAt(selectedRow, 1);
        String aeropuertoLlegada = (String) model.getValueAt(selectedRow, 2);
        String escala = (String) model.getValueAt(selectedRow, 3);

        String duracion = String.valueOf(model.getValueAt(selectedRow, 6));
        String preciosTotales = String.valueOf(model.getValueAt(selectedRow, 7));

        int idFlight = (Integer) model.getValueAt(selectedRow, 8);
        int idScale = (Integer) model.getValueAt(selectedRow, 9);

        Object horaSalidaObj = model.getValueAt(selectedRow, 4);
        Object horaLlegadaObj = model.getValueAt(selectedRow, 5);
        String horaSalida = horaSalidaObj instanceof Date ? dateFormat.format((Date) horaSalidaObj) : horaSalidaObj.toString();
        String horaLlegada = horaLlegadaObj instanceof Date ? dateFormat.format((Date) horaLlegadaObj) : horaLlegadaObj.toString();
        int idStopoverAirport = getIdStopoverByIdFlight(idScale);

        try {
            int uniqueId = generateUniqueHistoryId();
            SimpleDateFormat actualDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            int idDepartureAirport = getAirportIdByName(aeropuertoSalida);
            int idArrivalAirport = getAirportIdByName(aeropuertoLlegada);

            int quantityTickets = (Integer) spinnerPassengers.getValue();
            Date actualDateTime = new Date();

            String[] historial = new String[12];
            historial[0] = String.valueOf(uniqueId);
            historial[1] = String.valueOf(userId);
            historial[2] = String.valueOf(idDepartureAirport);
            historial[3] = String.valueOf(idArrivalAirport);
            historial[4] = String.valueOf(idStopoverAirport);
            historial[5] = actualDate.format(actualDateTime);
            historial[6] = String.valueOf(quantityTickets);
            String[] asientos = generarMatriz(idFlight, idScale, quantityTickets);
            if (!asientos[0].equals(null)) {
                historial[7] = asientos[0];
            }
            else{
                disponibles = false;
            }

            historial[8] = duracion;
            historial[9] = preciosTotales;
            historial[10] = String.valueOf(idFlight);
            historial[11] = String.valueOf(idScale);
            if(disponibles == true){
                if(historial[7].equals("")){
                    
                }
                else{
                    addHistory(historial);
                }
                
                
            }
            
            
            if (asientos[1] != null) {
                historial[7] = asientos[1];
                historial[10] = String.valueOf(idScale);
                historial[11] = String.valueOf(idFlight);
                if(historial[7].equals("") || historial[7] == null){
                    disponibles = false;
                }
                else{
                    addHistory(historial);
                }
            }
            
            
            if(disponibles == true){
            dialogSeats actualDialogSeats = new dialogSeats(null, true);
            actualDialogSeats.editCells(idFlight, idScale);
            actualDialogSeats.setVisible(true);
            actualDialogSeats.pack();

            String[] purchaseDetails = {
                "ID Historial: " + historial[0],
                "ID Cliente: " + historial[1],
                "Aeropuerto de salida (ID): " + historial[2],
                "Aeropuerto de llegada (ID): " + historial[3],
                "Escala (ID): " + historial[4],
                "Fecha y hora de compra: " + historial[5],
                "Cantidad de boletos: " + historial[6],
                "Asientos: " + historial[7],
                "Duración total: " + historial[8] + " minutos",
                "Precio total: " + historial[9]
            };

            String imagePath = ImageGenerator.generatePurchaseImage(purchaseDetails, String.valueOf(uniqueId));

            // Iniciar servidor HTTP para servir la imagen QR
            SimpleHttpServer.initializeServer();

            // Obtener la IP local y el puerto del servidor
            String ipLocal = InetAddress.getLocalHost().getHostAddress();
            int port = SimpleHttpServer.getPort();
            String urlImagePath = "http://" + ipLocal + ":" + port + "/qrphotos/compra_" + uniqueId + ".png";

            // Generar el QR con la URL de la imagen
            QRCodeGenerator qrGenerator = new QRCodeGenerator();
            byte[] qrCode = qrGenerator.generateQRCodeImage(urlImagePath);

            // Obtener correo del usuario
            String userEmail = getEmailByUserId(userId);

            // Enviar el correo con el QR
            EmailSender emailSender = new EmailSender();
            emailSender.sendEmailWithQR(userEmail, "Detalles de tu compra", "Adjunto encontrarás el QR con los detalles de tu compra.", qrCode);

            System.out.println("Compra realizada con éxito. Se ha enviado un correo con el QR de los detalles de tu compra.");
            }
            else{
               JOptionPane.showMessageDialog(null, "No hay asientos disponibles.");
            }
            

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al procesar la compra: " + e.getMessage());
        }
    }
    
     public String[] generarMatriz(int id1, int id2, int quantitySeats){
       String[] asientos = new String[2];
       actualData dataActual = new actualData();
       List<Historial> histories = dataActual.getFlightHistory();
       int[][] matriz = new int[6][6];
       int[][] matriz2 = new int[6][6];
       List<String> seats = new ArrayList<>();
       List<String> seats2 = new ArrayList<>();
       for(Historial ticketActual: histories){
           if(ticketActual.getIdFlight() == id1){
               String actualSeats[] = ticketActual.getSeats().split("-");
               for(String seat: actualSeats){
                   seats.add(seat);
               }
           }
           else if(ticketActual.getIdFlight() == id2){
               String actualSeats[] = ticketActual.getSeats().split("-");
               for(String seat: actualSeats){
                   seats2.add(seat);
               }
           }
           
       }
       
       
        asignarAsientosAMatriz(seats, matriz);
        rellenarMatriz(matriz2);
        if(id2 != 0){
            asignarAsientosAMatriz(seats2, matriz2);
            rellenarMatriz(matriz2);       
        }
       
       
       int x = quantitySeats + 1; // Cantidad de campos libres seguidos que estamos buscando

        // Buscar en toda la matriz y obtener las coordenadas
        List<int[]> coordenadas = buscarCamposLibresSeguidosConCoordenadas(matriz, x);
        if(id2 != 0){
            List<int[]> coordenadas2 = buscarCamposLibresSeguidosConCoordenadas(matriz2, x);
            if (coordenadas2 == null) {
            // Si no se encuentran en toda la matriz, buscar en la mitad de la matriz
            coordenadas2 = buscarCamposLibresSeguidosMitadConCoordenadas(matriz2, x);
        }

        if (coordenadas2 != null) {
            String coordenadasStr2 = agruparCoordenadas(coordenadas2);
            System.out.println("Se encontraron " + x + " campos libres seguidos en las siguientes coordenadas:");
            System.out.println(coordenadasStr2);
            asientos[1] = coordenadasStr2;
        } 
        }

        if (coordenadas == null) {
            // Si no se encuentran en toda la matriz, buscar en la mitad de la matriz
            coordenadas = buscarCamposLibresSeguidosMitadConCoordenadas(matriz, x);
        }

        if (coordenadas != null) {
            String coordenadasStr = agruparCoordenadas(coordenadas);
            System.out.println("Se encontraron " + x + " campos libres seguidos en las siguientes coordenadas:");
            System.out.println(coordenadasStr);
            asientos[0] = coordenadasStr;
            return asientos;
        } else {
            asientos[0] = "";
            asientos[1] = "";
            return asientos;
        }
        
        
        
    }
 public void asignarAsientosAMatriz(List<String> seats, int[][] matriz) {
    for (String seat : seats) {
        int coordenadaX;
        int coordenadaY;
        
        // Determine the column (X) based on the first character
        switch (seat.charAt(0)) {
            case 'A':
                coordenadaX = 0;
                break;
            case 'B':
                coordenadaX = 1;
                break;
            case 'C':
                coordenadaX = 2;
                break;
            case 'D':
                coordenadaX = 3;
                break;
            case 'E':
                coordenadaX = 4;
                break;
            case 'F':
                coordenadaX = 5;
                break;
            default:
                coordenadaX = -1; // In case of an unexpected character
        }

        // Determine the row (Y) based on the second character
        switch (seat.charAt(1)) {
            case '1':
                coordenadaY = 0;
                break;
            case '2':
                coordenadaY = 1;
                break;
            case '3':
                coordenadaY = 2;
                break;
            case '4':
                coordenadaY = 3;
                break;
            case '5':
                coordenadaY = 4;
                break;
            case '6':
                coordenadaY = 5;
                break;
            default:
                coordenadaY = -1; // In case of an unexpected character
        }

        if (coordenadaX != -1 && coordenadaY != -1) {
            matriz[coordenadaX][coordenadaY] = 1;
        }
    }
}


private void rellenarMatriz(int[][] matriz) {
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j] != 1) {
                matriz[i][j] = 0;
            }
        }
    }
}
    
    public static List<int[]> buscarCamposLibresSeguidosConCoordenadas(int[][] matriz, int x) {
        int n = matriz.length;

        // Comprobar filas y columnas
        for (int i = 0; i < n; i++) {
            // Comprobar filas
            List<int[]> resultadoFila = buscarEnArrayConCoordenadas(matriz[i], x, i, true);
            if (resultadoFila != null) {
                return resultadoFila;
            }

            // Comprobar columnas
            int[] columna = new int[n];
            for (int j = 0; j < n; j++) {
                columna[j] = matriz[j][i];
            }
            List<int[]> resultadoColumna = buscarEnArrayConCoordenadas(columna, x, i, false);
            if (resultadoColumna != null) {
                return resultadoColumna;
            }
        }

        return null;
    }

    // Método para buscar campos libres seguidos en solo la mitad de la matriz y obtener las coordenadas
    public static List<int[]> buscarCamposLibresSeguidosMitadConCoordenadas(int[][] matriz, int x) {
        int n = matriz.length;

        // Comprobar filas y columnas en la mitad de la matriz
        for (int i = 0; i < n / 2; i++) {
            // Comprobar filas
            List<int[]> resultadoFila = buscarEnArrayConCoordenadas(matriz[i], x, i, true);
            if (resultadoFila != null) {
                return resultadoFila;
            }

            // Comprobar columnas
            int[] columna = new int[n / 2];
            for (int j = 0; j < n / 2; j++) {
                columna[j] = matriz[j][i];
            }
            List<int[]> resultadoColumna = buscarEnArrayConCoordenadas(columna, x, i, false);
            if (resultadoColumna != null) {
                return resultadoColumna;
            }
        }

        return null;
    }

    // Método para buscar x campos libres consecutivos en un array y obtener las coordenadas
    public static List<int[]> buscarEnArrayConCoordenadas(int[] array, int x, int fixedIndex, boolean isRow) {
        int contador = 0;
        int start_index = -1;
        List<int[]> coordenadas = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (contador == 0) {
                    start_index = i;
                }
                contador++;
                coordenadas.add(isRow ? new int[]{fixedIndex, i} : new int[]{i, fixedIndex});
                if (contador == x) {
                    return coordenadas;
                }
            } else {
                contador = 0;
                coordenadas.clear();
            }
        }
        return null;
    }
    
    public static String agruparCoordenadas(List<int[]> coordenadas) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coordenadas.size(); i++) {
            char fila = (char) ('A' + coordenadas.get(i)[0]);
            int columna = coordenadas.get(i)[1] + 1;
            sb.append(fila).append(columna);
            if (i < coordenadas.size() - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
    
    public void searchForScale(){
        
    }

}
/*for(String seat: seats){
           
           int coordenadaX;
           int coordenadaY;
           switch (seat.charAt(0)) {   
               case 'A':
                    coordenadaX = 0;
                    break;
                case 'B':
                    coordenadaX = 1;
                    break;
                case 'C':
                    coordenadaX = 2;
                    break;
                case 'D':
                    coordenadaX = 3;
                    break;
                case 'E':
                    coordenadaX = 4;
                    break;
                case 'F':
                    coordenadaX = 5;
                    break;
                default:
                    coordenadaX = -1; // In case of an unexpected character
            }
    
                        // Determine the row based on the second character
            switch (seat.charAt(1)) {
                case '1':
                    coordenadaY = 0;
                    break;
                case '2':
                    coordenadaY = 1;
                    break;
                case '3':
                    coordenadaY = 2;
                    break;
                case '4':
                    coordenadaY = 3;
                    break;
                case '5':
                    coordenadaY = 4;
                    break;
                case '6':
                    coordenadaY = 5;
                    break;
                default:
                    coordenadaY = -1; // In case of an unexpected character
            }
            matriz[coordenadaX][coordenadaY] = 1;
       }
       for (int i = 0; i < matriz.length; i++) { // Bucle para las filas
            for (int j = 0; j < matriz[i].length; j++) { // Bucle para las columnas
                if(matriz[i][j] == 1){
                    
                }
                else{
                    matriz[i][j]= 0;
                }    
            }
            
       }*/

