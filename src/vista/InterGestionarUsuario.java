/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import controlador.Ctrl_Usuario;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Modelo_Usuario;

/**
 *
 * @author Edward
 */
public class InterGestionarUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterGestionarCategoria
     */
    private int idUsuario;
    String usuarioComprobar;
    //String auxImagen = "";

    public InterGestionarUsuario() {
        initComponents();
        this.setSize(new Dimension(940, 500));
        this.cargarTablaUsuarios();
        this.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE); //no permite el movimiento del internal
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null); // desactiva la abrra de titulo
        //this.restriccion();
    }

    //Para poner el logo de suzuki a escala en el bar menu
    private void fondoEtiqueta() {
        ImageIcon logo = new ImageIcon("src/img/fondo3.jpg");
        Icon icon = new ImageIcon(logo.getImage().getScaledInstance(940, 500, WIDTH));
        lblFondo.setIcon(icon);
        lblFondo.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        scrollCategorias = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnMostrarC = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbotipoU = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cboBusqueda = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaUsuarios.setBackground(new java.awt.Color(204, 204, 204));
        tablaUsuarios.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.black));
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollCategorias.setViewportView(tablaUsuarios);

        jPanel1.add(scrollCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 730, 270));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnActualizar.setBackground(new java.awt.Color(0, 153, 153));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 250, 140, 270));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Nombre:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Password:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Telefono:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 55, 80, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Apellido:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 12, 80, -1));

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel3.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 170, 25));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 170, 25));

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        jPanel3.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 170, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Usuario:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 12, 70, -1));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 170, 25));
        jPanel3.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 170, -1));

        btnMostrarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Ocultar.png"))); // NOI18N
        btnMostrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCActionPerformed(evt);
            }
        });
        jPanel3.add(btnMostrarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 30, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Tipo:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 60, -1));

        cbotipoU.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbotipoU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo:", "Cajero", "Gerente", "Administrador" }));
        cbotipoU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipoUActionPerformed(evt);
            }
        });
        jPanel3.add(cbotipoU, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 170, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 540, 890, 100));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Buscar por:");

        cboBusqueda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion:", "Nombre", "Apellido", "Tipo Usuario" }));
        cboBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBusquedaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Ingrese el dato a  buscar:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 890, 100));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FONDO8.jpg"))); // NOI18N
        lblFondo.setOpaque(true);
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1366, 766));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtTelefono.getText().isEmpty()
                || txtPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene los campos requeridos");
        } else {
            Modelo_Usuario user = new Modelo_Usuario();
            Ctrl_Usuario ctrl_Usuario = new Ctrl_Usuario();

            if (txtUsuario.getText().equals(usuarioComprobar)) {
                user.setNombre(txtNombre.getText().trim());
                user.setApellido(txtApellido.getText().trim());
                user.setUsuario(txtUsuario.getText().trim());
                user.setPassword(txtPassword.getText().trim());
                user.setTelefono(txtTelefono.getText().trim());
                user.setTipoU("" + cbotipoU.getSelectedItem());

                if (ctrl_Usuario.actualizarUsuario(user, idUsuario)) {
                    JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                    this.cargarTablaUsuarios();
                    this.limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar");
                }
            } else {

                if (!ctrl_Usuario.existeUsuario(txtUsuario.getText())) {
                    user.setNombre(txtNombre.getText().trim());
                    user.setApellido(txtApellido.getText().trim());
                    user.setUsuario(txtUsuario.getText().trim());
                    user.setPassword(txtPassword.getText().trim());
                    user.setTelefono(txtTelefono.getText().trim());
                    user.setTipoU("" + cbotipoU.getSelectedItem());

                    if (ctrl_Usuario.actualizarUsuario(user, idUsuario)) {
                        JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                        this.cargarTablaUsuarios();
                        this.limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ya esta en uso");
                }

            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Ctrl_Usuario ctrl_Usuario = new Ctrl_Usuario();

        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario");
        } else {
            if (!ctrl_Usuario.eliminarUsuario(idUsuario)) {
                JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado");
                this.cargarTablaUsuarios();
                this.limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar usuario");
                this.limpiar();
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMostrarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCActionPerformed
        char i = txtPassword.getEchoChar();
        if (i == 0) {
            txtPassword.setEchoChar('*');
        } else {
            txtPassword.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_btnMostrarCActionPerformed

    private void cbotipoUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipoUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbotipoUActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (!(Character.isLetter(evt.getKeyChar())) && !(evt.getKeyChar() == KeyEvent.VK_SPACE)) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        if (!(Character.isLetter(evt.getKeyChar())) && !(evt.getKeyChar() == KeyEvent.VK_SPACE)) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        // Verifica si el carácter no es un número
        if (!Character.isDigit(c)) {
            // Si no es un número, consume el evento para prevenir la entrada
            evt.consume();
        }           // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarUsuario();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBusquedaActionPerformed
        if (cboBusqueda.getSelectedItem().equals("Seleccione una opcion:")) {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion de busqueda");
        } else if (cboBusqueda.getSelectedItem().equals("Nombre")) {
            txtBusqueda.setText(null);
        } else if (cboBusqueda.getSelectedItem().equals("Apellido")) {
            txtBusqueda.setText(null);
        } else if (cboBusqueda.getSelectedItem().equals("Tipo Usuario")) {
            txtBusqueda.setText(null);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cboBusquedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    public static javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMostrarC;
    private javax.swing.JComboBox<String> cboBusqueda;
    private javax.swing.JComboBox<String> cbotipoU;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblFondo;
    public static javax.swing.JScrollPane scrollCategorias;
    public static javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    //Metodo Limpiar 
    private void limpiar() {
        txtApellido.setText(null);
        txtTelefono.setText(null);
        txtNombre.setText(null);
        txtPassword.setText(null);
        txtUsuario.setText(null);

    }

    //Metodo para motrar todas los clientes registrados
    public void cargarTablaUsuarios() {
        Connection cx = conexion.ConectionDB.conectar();
        DefaultTableModel dfT = new DefaultTableModel();
        String sql = "select *from usuario";
        Statement st;

        try {
            st = cx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarUsuario.tablaUsuarios = new JTable(dfT);
            InterGestionarUsuario.scrollCategorias.setViewportView(InterGestionarUsuario.tablaUsuarios);

            dfT.addColumn("ID");
            dfT.addColumn("Nombre");
            dfT.addColumn("Apellido");
            dfT.addColumn("Usuario");
            dfT.addColumn("Telefono");
            dfT.addColumn("Password");
            dfT.addColumn("Tipo User");

            while (rs.next()) {

                Object fila[] = new Object[7];

                for (int i = 0; i < 7; i++) {

                    fila[i] = rs.getObject(i + 1);

                    //Remplazar letras por * en la contraseña
                    if ((i + 1) == 6) {
                        String aux = sustituirPalabra(rs.getString(i + 1));

                        fila[i] = aux;
                    }

                }
                dfT.addRow(fila);
            }
            cx.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla usuarios: " + e);
        }

        tablaUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tablaUsuarios.rowAtPoint(e.getPoint());
                int columna_point = 0;
                int columna = 3;

                if (fila_point > -1) {
                    idUsuario = (int) dfT.getValueAt(fila_point, columna_point);
                    usuarioComprobar = dfT.getValueAt(fila_point, columna).toString();
                    System.out.println(usuarioComprobar);
                    enviarDatosUsuarioSeleccionada(idUsuario);
                }
            }

        });
    }

    //Para mostrar informacion del cliente
    private void enviarDatosUsuarioSeleccionada(int idUsuario) {
        Connection cx = conexion.ConectionDB.conectar();
        try {
            PreparedStatement pst = cx.prepareStatement(
                    "select * from usuario where idUsuario='" + idUsuario + "';");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                txtNombre.setText(rs.getString("nombre"));
                txtApellido.setText(rs.getString("apellido"));
                txtUsuario.setText(rs.getString("usuario"));
                cbotipoU.setSelectedItem(rs.getString("tipoUsuario"));
                txtPassword.setText(rs.getString("contraseña"));
                txtTelefono.setText(rs.getString("telefono"));

            }
            cx.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar usuario " + e);
        }
    }

    //Metodo para remplazar la contraseña por *
    public String sustituirPalabra(String palabra) {
        String pal = "";
        char[] arr = new char[palabra.length()];
        int i = 0;
        while (i < palabra.length()) {
            arr[i] = '*';
            pal += arr[i];
            i++;
        }
        //System.out.println(pal);
        return pal;
    }

    private void buscarUsuario() {
        int aux;
        String tipoBusqueda = "" + cboBusqueda.getSelectedItem();
        if (!tipoBusqueda.equals("Seleccione una opcion:")) {
            if (cboBusqueda.getSelectedItem().equals("Nombre")) {
                aux = 1;
                String searchText = txtBusqueda.getText().toLowerCase();
                DefaultTableModel model = (DefaultTableModel) tablaUsuarios.getModel();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                tablaUsuarios.setRowSorter(sorter);
                if (searchText.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, aux)); // este sirve para buscar mediante la columna 1 o sea nombre
                }
            } else if (cboBusqueda.getSelectedItem().equals("Apellido")) {
                aux = 2;
                String searchText = txtBusqueda.getText().toLowerCase();
                DefaultTableModel model = (DefaultTableModel) tablaUsuarios.getModel();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                tablaUsuarios.setRowSorter(sorter);
                if (searchText.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, aux)); // este sirve para buscar mediante la columna 1 o sea nombre
                }
            } else if (cboBusqueda.getSelectedItem().equals("Tipo Usuario")) {
                aux = 6;
                String searchText = txtBusqueda.getText().toLowerCase();
                DefaultTableModel model = (DefaultTableModel) tablaUsuarios.getModel();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                tablaUsuarios.setRowSorter(sorter);
                if (searchText.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, aux)); // este sirve para buscar mediante la columna 1 o sea nombre
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion de busqueda");
        }
    }
}
