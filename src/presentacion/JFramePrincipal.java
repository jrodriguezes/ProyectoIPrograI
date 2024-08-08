package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class JFramePrincipal extends javax.swing.JFrame {

    public javax.swing.JMenuItem jMenuItemLogout;
    private int logged = 0;

    public JFramePrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void setLogged(int status) {
        this.logged = status;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        InicioSesion = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InicioSesion.setText("Inicio de Sesion");
        InicioSesion.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                if (logged == 0) {
                    LogIn actualLogIn = new LogIn(JFramePrincipal.this, true);
                    actualLogIn.pack();
                    actualLogIn.setVisible(true);
                    actualLogIn.dispose();
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                System.out.println("Menu deselected");
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                System.out.println("Menu canceled");
            }
        });

        jMenu4.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {

                PassengerRegistration actualPassengerRegistration = new PassengerRegistration(JFramePrincipal.this, true);
                actualPassengerRegistration.pack();
                actualPassengerRegistration.setVisible(true);
                actualPassengerRegistration.dispose();

            }

            @Override
            public void menuDeselected(MenuEvent e) {
                System.out.println("Menu deselected");
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                System.out.println("Menu canceled");
            }
        });;

        jMenuItem1.setText("Creación de vuelos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFlightCreator();
            }
        });

        InicioSesion.add(jMenuItem1);

        jMenuItem2.setText("Búsqueda de vuelos");
        InicioSesion.add(jMenuItem2);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFlightSearch();
            }
        });

        jMenuItem3.setText("Reportes");
        InicioSesion.add(jMenuItem3);

        jMenuBar2.add(InicioSesion);

        jMenuItemLogout.setText("Cerrar Sesión");
        jMenuItemLogout.setVisible(false); // Initially hidden
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        InicioSesion.add(jMenuItemLogout);

        jMenu4.setText("Registro de pasajeros");
        jMenuBar2.add(jMenu4);

        jMenu1.setText("Salir");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }

    private void openFlightSearch() {
        FlightSearch flightWindow = new FlightSearch(this, true);
        flightWindow.setVisible(true);
    }

    private void openFlightCreator() {
        FlightCreator flightCreator = new FlightCreator(this, true);
        flightCreator.setVisible(true);
    }

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {
        // Reset the logged status
        logged = 0;

        // Hide all menu items that should be hidden after logout
        jMenuItem1.setVisible(false);
        jMenuItem2.setVisible(false);
        jMenuItem3.setVisible(false);
        jMenuItemLogout.setVisible(false);

        // Show the login dialog
        LogIn loginDialog = new LogIn(this, true);
        loginDialog.setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    public javax.swing.JMenu InicioSesion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    javax.swing.JMenuItem jMenuItem1;
    javax.swing.JMenuItem jMenuItem2;
    javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration                   
}
