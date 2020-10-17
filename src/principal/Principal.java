/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

//import AnalizadorLexico.FrmPrincipal;
import alertas.AlertError;
import alertas.AlertInformation;
import alertas.AlertSucess;
import alertas.AlertWarning;
import alertas.AlertWarningSave;
import componentes.FadeEffect;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static principal.Funciones.ruta;

/**
 *
 * @author RojeruSan
 */
public class Principal extends javax.swing.JFrame {

    private int x, y;
    private boolean minimiza = false;
    private int contadorNuevo = 0;
    public static boolean creoNuevo = false;
    public static boolean abrioArchivo = false;
    public static boolean abrir = false;
    private int cont;
   

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        FadeEffect.fadeInFrame(this, 50, 0.1f);
        this.setLocationRelativeTo(this);
        this.setIconImage(new ImageIcon(getClass().getResource("/img/logo.png")).getImage());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new principal.MaterialButton();
        jLabel2 = new javax.swing.JLabel();
        btnMinimizar = new principal.MaterialButton();
        lblNombre = new javax.swing.JLabel();
        btnAbrir = new componentes.rsbuttom.RSButtonMetro();
        btnNuevo = new componentes.rsbuttom.RSButtonMetro();
        btnGuardar = new componentes.rsbuttom.RSButtonMetro();
        btnEliminar = new componentes.rsbuttom.RSButtonMetro();
        txtEntrada = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Lineas = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 133, 175), 5));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(10, 133, 175));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Compilador LOOP");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 6, -1, 109));

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setForeground(new java.awt.Color(0, 153, 204));
        btnCerrar.setText("X");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1066, 15, 49, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-txt.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 9, -1, 120));

        btnMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setForeground(new java.awt.Color(0, 153, 204));
        btnMinimizar.setText("__");
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(999, 15, 49, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 1176, -1));

        lblNombre.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 359, 559, 17));

        btnAbrir.setBackground(new java.awt.Color(10, 133, 175));
        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-abrir.png"))); // NOI18N
        btnAbrir.setText("Abrir Archivo");
        btnAbrir.setColorBorde(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new javax.swing.ImageIcon(getClass().getResource("/componentes/rsbuttom/border.png")))); // NOI18N
        btnAbrir.setColorPressed(new java.awt.Color(0, 153, 204));
        btnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 232, 225, 100));

        btnNuevo.setBackground(new java.awt.Color(10, 133, 175));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono.nuevo.png"))); // NOI18N
        btnNuevo.setText("Analizar");
        btnNuevo.setColorBorde(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new javax.swing.ImageIcon(getClass().getResource("/componentes/rsbuttom/border.png")))); // NOI18N
        btnNuevo.setColorPressed(new java.awt.Color(0, 153, 204));
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 126, 225, 100));

        btnGuardar.setBackground(new java.awt.Color(10, 133, 175));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setColorBorde(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new javax.swing.ImageIcon(getClass().getResource("/componentes/rsbuttom/border.png")))); // NOI18N
        btnGuardar.setColorPressed(new java.awt.Color(0, 153, 204));
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 338, 225, 100));

        btnEliminar.setBackground(new java.awt.Color(10, 133, 175));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setColorBorde(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new javax.swing.ImageIcon(getClass().getResource("/componentes/rsbuttom/border.png")))); // NOI18N
        btnEliminar.setColorPressed(new java.awt.Color(0, 153, 204));
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 444, 225, 100));

        txtEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaActionPerformed(evt);
            }
        });
        jPanel1.add(txtEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 144, 860, 49));

        txtArea1.setEditable(false);
        txtArea1.setColumns(20);
        txtArea1.setRows(5);
        txtArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtArea1MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 390, 400));

        txtArea2.setEditable(false);
        txtArea2.setColumns(20);
        txtArea2.setRows(5);
        txtArea2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtArea2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtArea2MousePressed(evt);
            }
        });
        txtArea2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArea2KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtArea2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 450, 400));

        Lineas.setColumns(20);
        Lineas.setRows(5);
        jScrollPane3.setViewportView(Lineas);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 30, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        alertas.AlertWarning a = new AlertWarning(this, true);
        alertas.AlertWarningSave a1 = new AlertWarningSave(this, true);
        if (creoNuevo && !abrioArchivo) {
            a1.lblMensaje1.setText("Aun no guardas el archivo nuevo.");
            a1.lblMensaje2.setText("¿Deseas guardarlo?.");
            a1.setVisible(true);
            if (AlertWarningSave.guardar) {
                new Funciones().CrearFicheroNuevo(this, this.txtArea1.getText(), this.lblNombre.getText());
                FadeEffect.fadeOutFrame(this, 50, 0.1f);
            }
            if (AlertWarningSave.noGuardar) {
                FadeEffect.fadeOutFrame(this, 50, 0.1f);
            }
        } else {
            a.lblMensaje1.setText("La aplicación terminara.");
            a.lblMensaje2.setText("");
            a.setVisible(true);
            if (AlertWarning.ok) {
                FadeEffect.fadeOutFrame(this, 50, 0.1f);
            }
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
        if (!minimiza) {
            minimiza = false;
        } else {
            minimiza = true;
        }
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        new Funciones().LeerFichero(this);
        abrir = true;
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        if (abrir) {
            //JOptionPane.showInputDialog(null, "");
            contadorNuevo++;
            this.lblNombre.setText("Archivo" + contadorNuevo + ".txt");
            // this.txtArea1.setText("");
            // this.txtArea1.setEditable(true);
            this.txtArea1.requestFocus();
            creoNuevo = true;
            abrioArchivo = false;
            File archivo = new File("archivo.txt");
            PrintWriter escribir;
            try {
                escribir = new PrintWriter(archivo);
                escribir.print(txtArea2.getText());
                escribir.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Reader lector = new BufferedReader(new FileReader("archivo.txt"));
                Lexer lexer = new Lexer(lector);
                String resultado = "";
                while (true) {
                    Tokens tokens = lexer.yylex();
                    if (tokens == null) {
                        resultado += "---------Analisis Léxico Correctamente---------";
                        txtArea1.setText(resultado);
                        return;
                    }
                    switch (tokens) {
                        case ERROR:
                            resultado +=  tokens + ":   Simbolo no definido\n";
                            break;
                        case Identificador:
                        case Numero:
                            resultado += lexer.lexeme + ":   Es un " + tokens + "\n";
                            break;
                        case Reservadas:
                            resultado += lexer.lexeme + ":   Es una Palabra Reservada" + "\n";
                            break;
                        default:
                            resultado += "Token: " + tokens + "\n";
                            break;
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            AlertError a = new AlertError(this, true);
            a.lblMensaje1.setText("No hay Texto para analizar");
            a.lblMensaje2.setText("");
            a.setVisible(true);
        }


    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (abrioArchivo) {
            System.out.println("Existente");
            new Funciones().GuardarFichero(this.txtArea1.getText(), this.lblNombre.getText());
            alertas.AlertSucess a = new AlertSucess(this, true);
            a.lblMensaje1.setText("Se Guardo Correctamene");
            a.lblMensaje2.setText(ruta);
            a.setVisible(true);
        }
        if (creoNuevo) {
            System.out.println("Nuevo");
            new Funciones().CrearFicheroNuevo(this, this.txtArea1.getText(), this.lblNombre.getText());
            new Funciones().GuardarFichero(this.txtArea1.getText(), this.lblNombre.getText());
            alertas.AlertSucess a = new AlertSucess(this, true);
            a.lblMensaje1.setText("Se Guardo Correctamene");
            a.lblMensaje2.setText(ruta);
            a.setVisible(true);
        }
        if (!creoNuevo && !abrioArchivo) {
            alertas.AlertInformation a = new AlertInformation(this, true);
            a.lblMensaje1.setText("Debes crear o abrir un archvo");
            a.lblMensaje2.setText("para poder guardarlo.");
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (abrioArchivo) {
            new Funciones().BorrarFichero(this);
            this.lblNombre.setText("");
            this.txtArea1.setText("");
        } else {
            alertas.AlertInformation a = new AlertInformation(this, true);
            a.lblMensaje1.setText("Debes abrir un archvo");
            a.lblMensaje2.setText("para poder eliminarlo.");
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaActionPerformed

    }//GEN-LAST:event_txtEntradaActionPerformed

    private void txtAreaMousePressed(java.awt.event.MouseEvent evt) {

    }
    private void txtArea2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtArea2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArea2MouseClicked

    private void txtArea2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtArea2MousePressed
        if (!this.txtArea2.isEditable()) {
            alertas.AlertInformation a = new AlertInformation(this, true);
            a.lblMensaje1.setText("Para poder escribir debes");
            a.lblMensaje2.setText("crear un nuevo archivo.");
            a.setVisible(true);
        }
    }//GEN-LAST:event_txtArea2MousePressed

    private void txtArea1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtArea1MousePressed
        if (!this.txtArea2.isEditable()) {
            alertas.AlertInformation a = new AlertInformation(this, true);
            a.lblMensaje1.setText("Para poder escribir debes");
            a.lblMensaje2.setText("crear un nuevo archivo.");
            a.setVisible(true);
        }
    }//GEN-LAST:event_txtArea1MousePressed

    private void txtArea2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArea2KeyReleased
        StringTokenizer st = new StringTokenizer(txtArea2.getText(),"\n",true);
        String txt = "",token;
        cont = 1;

        while (st.hasMoreTokens()){
            token= st.nextToken();
            if("\n".equals(token)) cont++;
        }

        for(int i = 1; i <= cont; i++){
            txt += i+"\n";
        }
        Lineas.setText(txt);
        
    }//GEN-LAST:event_txtArea2KeyReleased

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Lineas;
    private componentes.rsbuttom.RSButtonMetro btnAbrir;
    private principal.MaterialButton btnCerrar;
    private componentes.rsbuttom.RSButtonMetro btnEliminar;
    private componentes.rsbuttom.RSButtonMetro btnGuardar;
    private principal.MaterialButton btnMinimizar;
    private componentes.rsbuttom.RSButtonMetro btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel lblNombre;
    public javax.swing.JTextArea txtArea1;
    public javax.swing.JTextArea txtArea2;
    private javax.swing.JTextField txtEntrada;
    // End of variables declaration//GEN-END:variables
}
