import javax.swing.*;
import java.awt.*;

public class shapePanel extends JPanel {

    private String currentShape = "Triangle";
    private Color currentColor = Color.BLUE;

    public void setShape(String shape) {
        this.currentShape = shape;
        repaint();
    }

    public void setColor(Color color) {
        this.currentColor = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        int padding = 120;
        int size = Math.min(getWidth(), getHeight()) - padding;
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        g2d.setColor(currentColor);

        switch (currentShape) {
            case "Circle":
                g2d.fillOval(x, y, size, size);
                break;

            case "Square":
                g2d.fillRect(x, y, size, size);
                break;

            case "Triangle":
                int[] xPoints = {getWidth() / 2, x, x + size};
                int[] yPoints = {y, y + size, y + size};
                g2d.fillPolygon(xPoints, yPoints, 3);
                break;
        }
    }
}
