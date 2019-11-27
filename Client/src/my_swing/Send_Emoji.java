package my_swing;

import javax.swing.ImageIcon;

public class Send_Emoji extends javax.swing.JPanel {

    public Send_Emoji() {
        initComponents();
    }

    public void setPhoto(String emoji) {
        lb.setIcon(new ImageIcon(getClass().getResource("/emoji/" + emoji)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 76));

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emoji/emoji_green (1).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(452, Short.MAX_VALUE)
                .addComponent(lb)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
