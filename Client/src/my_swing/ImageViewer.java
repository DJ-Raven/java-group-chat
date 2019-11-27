package my_swing;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ImageViewer extends javax.swing.JPanel {

    public ImageViewer() {
        initComponents();
    }

    ImageIcon icon;

    public void setImage(ImageIcon image) {
        this.icon = image;
        if (image.getIconHeight() > 500 || image.getIconWidth() > 500) {
            Image img;
            if (image.getIconWidth() > image.getIconHeight()) {
                img = image.getImage().getScaledInstance(500, -1, Image.SCALE_SMOOTH);
            } else {
                img = image.getImage().getScaledInstance(-1, 500, Image.SCALE_SMOOTH);
            }
            image = new ImageIcon(img);
        }
        lbImage.setIcon(image);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbImage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbImage;
    // End of variables declaration//GEN-END:variables
}
