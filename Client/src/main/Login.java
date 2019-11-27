package main;

import function.FileChooser;
import function.Method;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.ConnectException;
import java.net.UnknownHostException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        open();
    }

    private void open() {
        setIconImage(new ImageIcon(getClass().getResource("/icon/icon.png")).getImage());
        Method.setTextFieldSyle(txtUser, "User Name");
        Method.setTextFieldSyle(txtIP, "IP Address");
        showStatus(ms);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtIP = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        cmdLogin = new my_swing.Button();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        border = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log in");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtIP.setBackground(new java.awt.Color(204, 204, 204));
        txtIP.setFont(new java.awt.Font("Khmer SBBIC Serif", 1, 18)); // NOI18N
        txtIP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        txtIP.setSelectionColor(new java.awt.Color(131, 188, 227));
        txtIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIPKeyTyped(evt);
            }
        });

        txtUser.setBackground(new java.awt.Color(204, 204, 204));
        txtUser.setFont(new java.awt.Font("Khmer SBBIC Serif", 1, 18)); // NOI18N
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        txtUser.setSelectionColor(new java.awt.Color(131, 188, 227));
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });

        cmdLogin.setBackground(new java.awt.Color(101, 167, 232));
        cmdLogin.setForeground(new java.awt.Color(255, 255, 255));
        cmdLogin.setText("Log in");
        cmdLogin.setColorClick(new java.awt.Color(152, 196, 239));
        cmdLogin.setColorOver(new java.awt.Color(31, 121, 208));
        cmdLogin.setFillBorder(20);
        cmdLogin.setFocusable(false);
        cmdLogin.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        border.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        border.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/border.png"))); // NOI18N
        border.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        border.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borderMouseClicked(evt);
            }
        });
        jLayeredPane1.add(border);

        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile.png"))); // NOI18N
        jLayeredPane1.add(profile);

        lbStatus.setFont(new java.awt.Font("Khmer SBBIC Serif", 0, 14)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(204, 0, 0));
        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(cmdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
        try {
            if (txtUser.getText().equals("") || !txtUser.getName().equals("have")) {
                txtUser.grabFocus();
                showStatus("Please input your user name");
            } else {
                if (txtUser.getText().trim().length() > 15) {
                    txtUser.grabFocus();
                    showStatus("User name must less than 15 character");
                } else {
                    String IP = txtIP.getText().trim();
                    if (txtIP.getText().equals("") || !txtIP.getName().equals("have")) {
                        IP = "localhost";
                        System.err.println("have");
                    }
                    String userName = txtUser.getText().trim();
                    Method.connect(profile_pic, userName, IP);
                    this.dispose();
                    Main.main(null);
                }

            }
        } catch (UnknownHostException e) {
            showStatus("Unknown host : " + txtIP.getText());
        } catch (java.rmi.UnknownHostException e) {
            showStatus("Unknown host : " + txtIP.getText());
        } catch (ConnectException e) {
            showStatus("Server not found");
        } catch (java.rmi.ConnectException e) {
            showStatus("Server not found");
        } catch (Exception e) {
            showStatus("Network is unreachable : connect");
            System.out.println(e);
        }

    }//GEN-LAST:event_cmdLoginActionPerformed

    private void borderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borderMouseClicked
        if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
            JFileChooser ch = new JFileChooser();
            FileChooser preview = new FileChooser();
            ch.setAccessory(preview);
            ch.addPropertyChangeListener(preview);
            ch.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    String name = file.getName();
                    return file.isDirectory() || name.endsWith(".png") || name.endsWith(".PNG") || name.endsWith("jpg") || name.endsWith("JPG");
                }

                @Override
                public String getDescription() {
                    return "png,jpg";
                }
            });
            int opt = ch.showOpenDialog(this);
            if (opt == JFileChooser.APPROVE_OPTION) {
                ImageIcon image = new ImageIcon(ch.getSelectedFile().getAbsolutePath());
                Image img;
                if (image.getIconWidth() > image.getIconHeight()) {
                    img = image.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
                } else {
                    img = image.getImage().getScaledInstance(-1, 100, Image.SCALE_SMOOTH);
                }
                profile_pic = new ImageIcon(img);
                profile.setIcon(profile_pic);
            }
        }
    }//GEN-LAST:event_borderMouseClicked

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        if (evt.getKeyChar() == 10) {
            txtIP.grabFocus();
        }
        if (txtUser.getText().trim().length() >= 15) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUserKeyTyped

    private void txtIPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIPKeyTyped
        if (evt.getKeyChar() == 10) {
            cmdLoginActionPerformed(null);
        }
    }//GEN-LAST:event_txtIPKeyTyped

    private ImageIcon profile_pic;
    private Timer timer = new Timer(5000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            lbStatus.setText("");
            timer.stop();
        }
    });

    private void showStatus(String error) {
        if (timer.isRunning()) {
            lbStatus.setText("");
            timer.stop();
        }
        timer.start();
        lbStatus.setText(error);
    }

    private static String ms = "";

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (args.length == 1) {
                    ms = args[0];
                }
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel border;
    private my_swing.Button cmdLogin;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel profile;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
