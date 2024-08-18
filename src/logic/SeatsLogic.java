/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.awt.Component;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import objects.Historial;

/**
 *
 * @author Admin
 */
public class SeatsLogic {

    public static void configureTable(JTable table, int rows, int columns) {
        DefaultTableModel model = new DefaultTableModel(rows, columns);
        table.setModel(model);

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {

                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value == null) {
                    cell.setBackground(Color.WHITE); // Celda vacia
                } else if (value.equals("Ocupado")) {
                    cell.setBackground(Color.GREEN);  // Ocupado
                } else if (value.equals("Inhabilitado")) {
                    cell.setBackground(Color.RED);  // Inhabilitado
                } else {
                    cell.setBackground(Color.WHITE);  // Libre
                }

                return cell;
            }
        });
    }

    // Método para llenar la tabla con valores predefinidos
    public static void fillTableWithValues(JTable table, Object[][] data) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                model.setValueAt(data[i][j], i, j);
            }
        }
    }

    public static List<String> getAvailableSeats(JTable table) {
        List<String> availableSeats = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int row = 0; row < model.getRowCount(); row++) {
            for (int column = 0; column < model.getColumnCount(); column++) {
                Object value = model.getValueAt(row, column);
                Component cell = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                Color bgColor = cell.getBackground();

                if (value == null && bgColor.equals(Color.WHITE)) {
                    String seatIdentifier = (String) table.getColumnName(column) + (row + 1);
                    availableSeats.add(seatIdentifier);
                }
            }
        }
        return availableSeats;
    }
    
    
    public void assignSeatsAutomatically(JTable alaIzquierda, JTable alaDerecha, int numberOfPassengers) {
    DefaultTableModel modelIzquierda = (DefaultTableModel) alaIzquierda.getModel();
    DefaultTableModel modelDerecha = (DefaultTableModel) alaDerecha.getModel();
    int assignedSeats = 0;

    // Asignar asientos en AlaIzquierda primero
    for (int row = 0; row < modelIzquierda.getRowCount(); row++) {
        for (int column = 0; column < modelIzquierda.getColumnCount(); column++) {
            Object value = modelIzquierda.getValueAt(row, column);
            if (value == null) { // Verifica que el asiento esté disponible
                if (assignedSeats == numberOfPassengers) {
                    // Asignar un asiento adicional como "inhabilitado" (color rojo)
                    modelIzquierda.setValueAt("Inhabilitado", row, column);
                    alaIzquierda.prepareRenderer(alaIzquierda.getCellRenderer(row, column), row, column).setBackground(Color.RED);
                    return;
                } else {
                    modelIzquierda.setValueAt("Ocupado", row, column);
                    alaIzquierda.prepareRenderer(alaIzquierda.getCellRenderer(row, column), row, column).setBackground(Color.GREEN);
                    assignedSeats++;
                }
            }
        }
    }

    // Si no se completó la asignación en AlaIzquierda, continuar en AlaDerecha
    for (int row = 0; row < modelDerecha.getRowCount(); row++) {
        for (int column = 0; column < modelDerecha.getColumnCount(); column++) {
            Object value = modelDerecha.getValueAt(row, column);
            if (value == null) { // Verifica que el asiento esté disponible
                if (assignedSeats == numberOfPassengers) {
                    // Asignar un asiento adicional como "inhabilitado" (color rojo)
                    modelDerecha.setValueAt("Inhabilitado", row, column);
                    alaDerecha.prepareRenderer(alaDerecha.getCellRenderer(row, column), row, column).setBackground(Color.RED);
                    return;
                } else {
                    modelDerecha.setValueAt("Ocupado", row, column);
                    alaDerecha.prepareRenderer(alaDerecha.getCellRenderer(row, column), row, column).setBackground(Color.GREEN);
                    assignedSeats++;
                }
            }
        }
    }
}
    

    private static void clearSeats(JTable table) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    for (int row = 0; row < model.getRowCount(); row++) {
        for (int column = 0; column < model.getColumnCount(); column++) {
            model.setValueAt(null, row, column);
        }
    }
}
    
    public static List<String> getAssignedSeats(JTable table) {
    List<String> assignedSeats = new ArrayList<>();
    DefaultTableModel model = (DefaultTableModel) table.getModel();

    for (int row = 0; row < model.getRowCount(); row++) {
        for (int column = 0; column < model.getColumnCount(); column++) {
            Object value = model.getValueAt(row, column);
            if ("Ocupado".equals(value)) {
                String seatIdentifier = table.getColumnName(column) + (row + 1);
                assignedSeats.add(seatIdentifier);
            }
        }
    }

    // Limpiar los asientos ocupados después de guardarlos
    clearSeats(table);

    return assignedSeats;
}

    public void markOccupiedSeats(JTable table, List<String> occupiedSeats) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int row = 0; row < model.getRowCount(); row++) {
            for (int column = 0; column < model.getColumnCount(); column++) {
                String seatIdentifier = table.getColumnName(column) + (row + 1);

                if (occupiedSeats.contains(seatIdentifier)) {
                    model.setValueAt("Ocupado", row, column);
                    Component cell = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                    cell.setBackground(Color.GREEN);
                }
            }
        }
    }

    
    
    
}