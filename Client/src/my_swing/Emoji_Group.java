package my_swing;

import javax.swing.ImageIcon;

public class Emoji_Group extends javax.swing.JButton {

    public int getIcons() {
        return icons;
    }

    public void setIcons(int icons) {
        this.icons = icons;
    }

    private int icons;

    public Emoji_Group(String icon, int icons) {
        this.icons = icons;
        setContentAreaFilled(false);
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(50, 32));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setIcon(new ImageIcon(getClass().getResource("/emoji/" + icon)));
    }

}
