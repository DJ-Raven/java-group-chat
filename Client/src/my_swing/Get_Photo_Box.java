package my_swing;

import function.Method;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Get_Photo_Box extends javax.swing.JPanel {

    private boolean isOver = false;

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public Get_Photo_Box() {
        initComponents();
    }
    private ImageIcon image;

    public void setPhoto(ImageIcon image) {
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
            this.setPreferredSize(new Dimension(600, image.getIconHeight() + 12));
            this.setMaximumSize(new Dimension(600, image.getIconHeight() + 12));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 142));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(387, 387, 387))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
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
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
