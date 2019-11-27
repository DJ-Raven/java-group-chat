package my_swing;

import function.Method;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Get_Photo_Box_New extends javax.swing.JPanel {

    private boolean isOver = false;

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public Get_Photo_Box_New() {
        initComponents();
    }
    private ImageIcon image;

    public void setPhoto(int ID, ImageIcon image) {
        this.image = image;
        Image img;
        if (image.getIconHeight() > 130 || image.getIconWidth() > 130) {
            if (image.getIconWidth() > image.getIconHeight()) {
                img = image.getImage().getScaledInstance(130, -1, Image.SCALE_SMOOTH);
            } else {
                img = image.getImage().getScaledInstance(-1, 130, Image.SCALE_SMOOTH);
            }
            ImageIcon icon = new ImageIcon(img);
            lb.setIcon(icon);
        } else {
            lb.setIcon(image);
            if (image.getIconHeight() <= 30) {
                this.setPreferredSize(new Dimension(600, 72));
                this.setMaximumSize(new Dimension(600, 72));
            } else {
                this.setPreferredSize(new Dimension(600, image.getIconHeight() + 37));
                this.setMaximumSize(new Dimension(600, image.getIconHeight() + 37));
            }
        }
        if (Method.getFriends().get(ID).getImage() != null) {
            profile.setIcon(Method.getFriends().get(ID).getImage());
        }
        lbName.setText(Method.getFriends().get(ID).getfName());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        border = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 167));
        setPreferredSize(new java.awt.Dimension(600, 167));

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        border.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        border.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/border_small.png"))); // NOI18N
        jLayeredPane1.add(border);

        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profile_small.png"))); // NOI18N
        jLayeredPane1.add(profile);

        lb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbMouseReleased(evt);
            }
        });

        lbName.setFont(new java.awt.Font("Khmer SBBIC Serif", 1, 12)); // NOI18N
        lbName.setForeground(new java.awt.Color(29, 118, 206));
        lbName.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(106, 106, 106)))
                .addGap(280, 280, 280))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMouseEntered
        isOver = true;
    }//GEN-LAST:event_lbMouseEntered

    private void lbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMouseExited
        isOver = false;
    }//GEN-LAST:event_lbMouseExited

    private void lbMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMouseReleased
        if (isOver) {
            Method.showImage(image);
        }
    }//GEN-LAST:event_lbMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel border;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel profile;
    // End of variables declaration//GEN-END:variables
}
