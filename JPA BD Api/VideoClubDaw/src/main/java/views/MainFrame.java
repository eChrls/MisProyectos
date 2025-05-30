package views;

import entity.Alquiler;
import entity.Pelicula;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    private boolean esAdmin;
    private javax.persistence.EntityManagerFactory emf;
    private entity.Usuario usuarioLogueado;
    private controller.UsuarioController usuarioController;
    private controller.PeliculaController peliculaController;
    private controller.AlquilerController alquilerController;
    private controller.FichaTecnicaController fichaTecnicaController;

    public MainFrame(entity.Usuario usuarioLogueado) {
        // --- Inicializa usuario, rol y controladores principales ---
        this.usuarioLogueado = usuarioLogueado;
        this.esAdmin = usuarioLogueado.isAdmin(); // Usa el getter booleano
        this.emf = javax.persistence.Persistence.createEntityManagerFactory("videoclubdaw");
        this.usuarioController = new controller.UsuarioController(emf);
        this.peliculaController = new controller.PeliculaController(emf);
        this.alquilerController = new controller.AlquilerController(emf);
        this.fichaTecnicaController = new controller.FichaTecnicaController(emf);

        initComponents();

        // --- Personalización visual y lógica tras initComponents() ---
        // 1. Fuentes modernas y coherentes
        java.awt.Font fuenteTitulo = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 22);
        java.awt.Font fuenteBoton = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16);

        txtBienvenida.setFont(fuenteTitulo);
        txtAdmin.setFont(fuenteBoton);

        btnVerPeliculas.setFont(fuenteBoton);
        btnConsultarAlquileres.setFont(fuenteBoton);
        btnVerHistorial.setFont(fuenteBoton);
        btnPerfil.setFont(fuenteBoton);
        btnEliminarCuenta.setFont(fuenteBoton);
        btnCerrarSesion.setFont(fuenteBoton);
        btnSalir.setFont(fuenteBoton);

        btnGestionPeliculas.setFont(fuenteBoton);
        btnGestionUsuarios.setFont(fuenteBoton);
        btnGestionFichas.setFont(fuenteBoton);
        btnConsultarTodosAlquileres.setFont(fuenteBoton);
        btnExportarCSV.setFont(fuenteBoton);

        // 2. Colores de fondo y textos
        getContentPane().setBackground(new java.awt.Color(245, 245, 245)); // Fondo claro y moderno
        panelFondo.setOpaque(false); // Para que se vea el fondo con opacidad

        txtBienvenida.setForeground(new java.awt.Color(33, 37, 41)); // Gris oscuro elegante
        txtAdmin.setForeground(new java.awt.Color(0, 102, 204)); // Azul para destacar admin

        // 4. Ajustar visibilidad de botones y textos según el rol
        ajustarVisibilidadBotones();

        // 5. Centrar y bloquear el tamaño de la ventana
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Videoclub DAW");
    }

    /**
     * Ajusta la visibilidad de los botones según el rol del usuario. El botón
     * "Eliminar cuenta" solo es visible para usuarios normales.
     */
    private void ajustarVisibilidadBotones() {
        btnGestionPeliculas.setVisible(esAdmin);
        btnGestionUsuarios.setVisible(esAdmin);
        btnGestionFichas.setVisible(esAdmin);
        btnConsultarTodosAlquileres.setVisible(esAdmin);
        btnExportarCSV.setVisible(esAdmin);
        txtAdmin.setVisible(esAdmin);
        btnEliminarCuenta.setVisible(!usuarioLogueado.isAdmin());
        // Los demás botones siempre visibles
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        btnVerPeliculas = new javax.swing.JButton();
        btnEliminarCuenta = new javax.swing.JButton();
        btnVerHistorial = new javax.swing.JButton();
        txtBienvenida = new javax.swing.JTextField();
        btnConsultarAlquileres = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtAdmin = new javax.swing.JTextField();
        btnGestionPeliculas = new javax.swing.JButton();
        btnGestionUsuarios = new javax.swing.JButton();
        btnGestionFichas = new javax.swing.JButton();
        btnExportarCSV = new javax.swing.JButton();
        btnConsultarTodosAlquileres = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo = new views.FondoPanel("/img/cine.png", 0.3f);

        btnVerPeliculas.setText("Ver Peliculas");
        btnVerPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPeliculasActionPerformed(evt);
            }
        });

        btnEliminarCuenta.setText("Eliminar Cuenta");
        btnEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCuentaActionPerformed(evt);
            }
        });

        btnVerHistorial.setText("Ver Historial");
        btnVerHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerHistorialActionPerformed(evt);
            }
        });

        txtBienvenida.setText("BIENVENIDO AL VIDEOCLUB DE DAW! ");
        txtBienvenida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBienvenidaActionPerformed(evt);
            }
        });

        btnConsultarAlquileres.setText("Ver Alquileres activos");
        btnConsultarAlquileres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarAlquileresActionPerformed(evt);
            }
        });

        btnPerfil.setText("Mi Perfil");
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtAdmin.setText("ADMIN");
        txtAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminActionPerformed(evt);
            }
        });

        btnGestionPeliculas.setText("Gestión Peliculas");
        btnGestionPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionPeliculasActionPerformed(evt);
            }
        });

        btnGestionUsuarios.setText("Gestion Usuarios");
        btnGestionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionUsuariosActionPerformed(evt);
            }
        });

        btnGestionFichas.setText("Gestión Fichas");
        btnGestionFichas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionFichasActionPerformed(evt);
            }
        });

        btnExportarCSV.setText("Exportar CSV");
        btnExportarCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarCSVActionPerformed(evt);
            }
        });

        btnConsultarTodosAlquileres.setText("Todos los Alquileres");
        btnConsultarTodosAlquileres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarTodosAlquileresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(44, 44, 44))
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGestionPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGestionFichas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultarTodosAlquileres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(68, 68, 68)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addComponent(btnVerPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnVerHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnConsultarAlquileres, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEliminarCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(64, 64, 64)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGestionUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(btnExportarCSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(143, Short.MAX_VALUE))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(txtBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGestionUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGestionPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVerPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConsultarAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGestionFichas, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExportarCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnConsultarTodosAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97)
                .addComponent(btnSalir)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBienvenidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBienvenidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBienvenidaActionPerformed

    /**
     * Muestra los alquileres activos del usuario. Si no hay, muestra mensaje
     * "SIN DATOS".
     */
    private void btnConsultarAlquileresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarAlquileresActionPerformed
        // Muestra los alquileres activos del usuario
        List<Alquiler> alquileresActivos = alquilerController.buscarAlquileresActivosPorUsuario(usuarioLogueado);
        if (alquileresActivos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No tienes alquileres activos.", "Sin datos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Abre un diálogo para mostrar los alquileres activos
            VerAlquileresDialog dialog = new VerAlquileresDialog(this, true, alquileresActivos, alquilerController, false);
            dialog.setVisible(true);
        }


    }//GEN-LAST:event_btnConsultarAlquileresActionPerformed
    /**
     * Muestra el historial de alquileres del usuario. Si no hay, muestra
     * mensaje "SIN DATOS".
     */
    private void btnVerHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerHistorialActionPerformed

        List<Alquiler> historial = alquilerController.buscarHistorialAlquileresPorUsuario(usuarioLogueado);
        if (historial.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No tienes historial de alquileres.", "Sin datos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            VerAlquileresDialog dialog = new VerAlquileresDialog(this, true, historial, alquilerController, true);
            dialog.setVisible(true);
        }

    }//GEN-LAST:event_btnVerHistorialActionPerformed


    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // Salir de la aplicación
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdminActionPerformed

    private void btnGestionPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionPeliculasActionPerformed
        // Abrir gestión de películas (CRUD)
        GestionPeliculasDialog dialog = new GestionPeliculasDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnGestionPeliculasActionPerformed
    /**
     * Abre el diálogo para ver todas las películas.
     */
    private void btnVerPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPeliculasActionPerformed
        // TODO add your handling code here:
        //abre ventana de ver peliculas
        List<entity.Pelicula> peliculas = peliculaController.listarPeliculas();
        if (peliculas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay películas disponibles.", "Sin datos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            VerPeliculasDialog dialog = new VerPeliculasDialog(
                    this,
                    true,
                    peliculas,
                    esAdmin,
                    usuarioLogueado,
                    alquilerController,
                    fichaTecnicaController
            );
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_btnVerPeliculasActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        // Abrir ventana de perfil de usuario

        PerfilDialog dialog = new PerfilDialog(this, true, usuarioLogueado, usuarioController);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnGestionUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionUsuariosActionPerformed
        // Abrir gestión de usuarios (CRUD)
        GestionUsuariosDialog dialog = new GestionUsuariosDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnGestionUsuariosActionPerformed

    private void btnGestionFichasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionFichasActionPerformed
        // Abrir gestión de fichas técnicas (CRUD) con controladores actualizados
        GestionFichasDialog dialog = new GestionFichasDialog(this, true, fichaTecnicaController, peliculaController);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnGestionFichasActionPerformed
    /**
     * Confirma y elimina la cuenta del usuario actual. Solo disponible para
     * usuarios normales.
     */
    private void btnEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCuentaActionPerformed
        // Confirmar y eliminar cuenta
        // Confirmar y eliminar cuenta
        int confirm = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas eliminar tu cuenta?",
                "Confirmar",
                javax.swing.JOptionPane.YES_NO_OPTION
        );
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            try {
                // Elimina el usuario de la base de datos
                usuarioController.eliminarUsuario(usuarioLogueado.getIdUsuario());
                javax.swing.JOptionPane.showMessageDialog(this, "Cuenta eliminada.");
                this.dispose();
                new LoginFrame().setVisible(true);
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Error al eliminar la cuenta: " + e.getMessage(),
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_btnEliminarCuentaActionPerformed

    private void btnExportarCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarCSVActionPerformed
        // Llama a la utilidad de exportar CSV
        try {
            javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
            fileChooser.setDialogTitle("Selecciona la carpeta para guardar los CSV");
            fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

            int seleccion = fileChooser.showSaveDialog(this);
            if (seleccion == javax.swing.JFileChooser.APPROVE_OPTION) {
                java.io.File carpeta = fileChooser.getSelectedFile();
                utils.CSVExporter.exportarUsuarios(usuarioController.listarUsuarios(), new java.io.File(carpeta, "usuarios.csv"));
                utils.CSVExporter.exportarPeliculas(peliculaController.listarPeliculas(), new java.io.File(carpeta, "peliculas.csv"));
                utils.CSVExporter.exportarAlquileres(alquilerController.listarAlquileres(), new java.io.File(carpeta, "alquileres.csv"));
                utils.CSVExporter.exportarFichasTecnicas(fichaTecnicaController.listarFichasTecnicas(), new java.io.File(carpeta, "fichas_tecnicas.csv"));
                JOptionPane.showMessageDialog(this, "¡Copia de seguridad exportada correctamente!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al exportar CSV: " + e.getMessage());
        }
    }//GEN-LAST:event_btnExportarCSVActionPerformed
    /**
     * Abre el diálogo para ver todos los alquileres (ADMIN).
     */
    private void btnConsultarTodosAlquileresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarTodosAlquileresActionPerformed
        // Abrir ventana de todos los alquileres (solo admin)
        List<Alquiler> alquileres = alquilerController.listarAlquileres();
        if (alquileres.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay alquileres registrados.", "Sin datos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            VerAlquileresDialog dialog = new VerAlquileresDialog(this, true, alquileres, alquilerController, true);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_btnConsultarTodosAlquileresActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // Cerrar sesión y volver al login
        this.dispose();
        new LoginFrame().setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed
    /**
     * Método de respaldopara listar todos los alquileres (solo admin). No suele
     * usarse ya que btnConsultarTodosAlquileresActionPerformed lo cubre.
     */
    private void listarAlquileres() {
        List<Alquiler> alquileres = alquilerController.listarAlquileres();
        if (alquileres.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay alquileres registrados.", "Sin datos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            VerAlquileresDialog dialog = new VerAlquileresDialog(this, true, alquileres, alquilerController, true);
            dialog.setVisible(true);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Aquí deberías pasar el usuario logueado real
                // new MainFrame(usuarioLogueado).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConsultarAlquileres;
    private javax.swing.JButton btnConsultarTodosAlquileres;
    private javax.swing.JButton btnEliminarCuenta;
    private javax.swing.JButton btnExportarCSV;
    private javax.swing.JButton btnGestionFichas;
    private javax.swing.JButton btnGestionPeliculas;
    private javax.swing.JButton btnGestionUsuarios;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerHistorial;
    private javax.swing.JButton btnVerPeliculas;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTextField txtAdmin;
    private javax.swing.JTextField txtBienvenida;
    // End of variables declaration//GEN-END:variables
}
