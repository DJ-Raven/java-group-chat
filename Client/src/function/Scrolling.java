package function;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Scrolling implements MouseListener, MouseMotionListener {

    public static final int DRAGGABLE_HORIZONTAL_SCROLL_BAR = 1;
    public static final int DRAGGABLE_VERTICAL_SCROLL_BAR = 2;
    private int scrollingIntensity = 5;
    private double damping = 0.05;
    private int animationSpeed = 20;
    private javax.swing.Timer animationTimer = null;
    private long lastDragTime = 0;
    private Point lastDragPoint = null;
    private double pixelsPerMSX;
    private double pixelsPerMSY;
    private int scrollBarMask = 15;
    private final int DRAGABLE_VERTICAL_SCROLL_BAR = 15;
    private final int DRAGABLE_HORIZONTAL_SCROLL_BAR = 15;
    private final Component draggableComponent;
    private JScrollPane scroller = null;
    private Cursor defaultCursor;
    private final java.util.List<Point2D.Double> dragSpeeds = new ArrayList<>();

    public Scrolling(Component c) {
        draggableComponent = c;
        defaultCursor = draggableComponent.getCursor();
        draggableComponent.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent arg0) {
                setScroller();
                defaultCursor = draggableComponent.getCursor();
            }
        });
        setScroller();
        c.addMouseListener(this);
        c.addMouseMotionListener(this);
    }

    private void setScroller() {
        Component c = getParentScroller(draggableComponent);
        if (c != null) {
            scroller = (JScrollPane) c;
        } else {
            scroller = null;
        }
    }

    public void setDraggableElements(int mask) {
        scrollBarMask = mask;
    }

    public void setScrollingIntensity(int intensity) {
        scrollingIntensity = intensity;
    }

    public void setAnimationTiming(int timing) {
        animationSpeed = timing;
    }

    public void setDamping(double damping) {
        this.damping = damping;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (animationTimer != null && animationTimer.isRunning()) {
            animationTimer.stop();
        }
        draggableComponent.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        dragSpeeds.clear();
        lastDragPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        draggableComponent.setCursor(defaultCursor);
        if (scroller == null) {
            return;
        }

        long durationSinceLastDrag = System.currentTimeMillis() - lastDragTime;
        if (durationSinceLastDrag > 20) {
            return;
        }
        pixelsPerMSX = 0;
        pixelsPerMSY = 0;
        int j = 0;
        for (int i = dragSpeeds.size() - 1; i >= 0 && i > dragSpeeds.size() - 6; i--, j++) {
            pixelsPerMSX += dragSpeeds.get(i).x;
            pixelsPerMSY += dragSpeeds.get(i).y;
        }
        pixelsPerMSX /= -(double) j;
        pixelsPerMSY /= -(double) j;
        if (Math.abs(pixelsPerMSX) > 0 || Math.abs(pixelsPerMSY) > 0) {
            animationTimer = new javax.swing.Timer(animationSpeed, new ScrollAnimator());
            animationTimer.start();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (scroller == null || lastDragPoint == null) {
            return;
        }
        Point p = e.getPoint();
        int diffx = p.x - lastDragPoint.x;
        int diffy = p.y - lastDragPoint.y;
        lastDragPoint = e.getPoint();
        if ((scrollBarMask & DRAGABLE_HORIZONTAL_SCROLL_BAR) != 0) {
            getHorizontalScrollBar().setValue(getHorizontalScrollBar().getValue() - diffx);
        }
        lastDragPoint.x = lastDragPoint.x - diffx;
        if ((scrollBarMask & DRAGABLE_VERTICAL_SCROLL_BAR) != 0) {
            getVerticalScrollBar().setValue(getVerticalScrollBar().getValue() - diffy);
        }
        lastDragPoint.y = lastDragPoint.y - diffy;
        dragSpeeds.add(new Point2D.Double(
                (e.getPoint().x - lastDragPoint.x),
                (e.getPoint().y - lastDragPoint.y)));
        lastDragTime = System.currentTimeMillis();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    private class ScrollAnimator implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pixelsPerMSX -= pixelsPerMSX * damping;
            pixelsPerMSY -= pixelsPerMSY * damping;
            if (Math.abs(pixelsPerMSX) < 0.01 && Math.abs(pixelsPerMSY) < 0.01) {
                animationTimer.stop();
                return;
            }
            int nValX = getHorizontalScrollBar().getValue() + (int) (pixelsPerMSX * scrollingIntensity);
            int nValY = getVerticalScrollBar().getValue() + (int) (pixelsPerMSY * scrollingIntensity);
            if (nValX <= 0) {
                nValX = 0;
            } else if (nValX >= getHorizontalScrollBar().getMaximum()) {
                nValX = getHorizontalScrollBar().getMaximum();
            }
            if (nValY <= 0) {
                nValY = 0;
            } else if (nValY >= getVerticalScrollBar().getMaximum()) {
                nValY = getVerticalScrollBar().getMaximum();
            }
            if ((nValX == 0 || nValX == getHorizontalScrollBar().getMaximum()) && Math.abs(pixelsPerMSY) < 1) {
                animationTimer.stop();
                return;
            }
            if ((nValY == 0 || nValY == getVerticalScrollBar().getMaximum()) && Math.abs(pixelsPerMSX) < 1) {
                animationTimer.stop();
                return;
            }
            if ((scrollBarMask & DRAGABLE_HORIZONTAL_SCROLL_BAR) != 0) {
                getHorizontalScrollBar().setValue(nValX);
            }
            if ((scrollBarMask & DRAGABLE_VERTICAL_SCROLL_BAR) != 0) {
                getVerticalScrollBar().setValue(nValY);
            }
        }
    }

    private JScrollBar getHorizontalScrollBar() {
        return scroller.getHorizontalScrollBar();
    }

    private JScrollBar getVerticalScrollBar() {
        return scroller.getVerticalScrollBar();
    }

    private Component getParentScroller(Component c) {
        Container parent = c.getParent();
        if (parent != null && parent instanceof Component) {
            Component parentC = (Component) parent;
            if (parentC instanceof JScrollPane) {
                return parentC;
            } else {
                return getParentScroller(parentC);
            }
        }
        return null;
    }
}
