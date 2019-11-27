package my_swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Button extends javax.swing.JButton {

    private int fillBorder = 0;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private boolean over;

    public Button() {
        setContentAreaFilled(false);
        color = getBackground();
        over = false;
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBG(getColorOver());
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBG(color);
                over = false;
            }

            @Override
            public void mousePressed(MouseEvent me) {
                setBG(getColorClick());
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (over) {
                    setBG(colorOver);
                } else {
                    setBG(color);
                }
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), fillBorder, fillBorder);
        super.paintComponent(g);
    }

    public int getFillBorder() {
        return fillBorder;
    }

    public void setFillBorder(int fillBorder) {
        this.fillBorder = fillBorder;
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        this.color = color;
    }

    private void setBG(Color color) {
        super.setBackground(color);
    }
}
