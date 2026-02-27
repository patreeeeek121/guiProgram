import javax.swing.*;
import java.awt.*;

public class shapeSwitcher extends JFrame {

    private String currentShape = "Triangle";
    private Color currentColor = Color.BLUE;
    private shapePanel shapePanel;

    public shapeSwitcher() {
        setTitle("RGB Color Mixer & Shape Switcher");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Shape Panel
        shapePanel = new shapePanel();
        shapePanel.setBackground(Color.WHITE);
        shapePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JPanel shapeWrapper = new JPanel(new BorderLayout());
        shapeWrapper.setBorder(BorderFactory.createEmptyBorder(60, 40, 60, 40));
        shapeWrapper.add(shapePanel, BorderLayout.CENTER);

        add(shapeWrapper, BorderLayout.CENTER);

        // Control Panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setPreferredSize(new Dimension(220, 0));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));

        JLabel shapeLabel = new JLabel("Select Shape:");
        shapeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel colorLabel = new JLabel("Select Color:");
        colorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] shapes = {"Triangle", "Square", "Circle"};
        JComboBox<String> shapeMenu = new JComboBox<>(shapes);
        shapeMenu.setSelectedItem("Triangle");
        shapeMenu.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        shapeMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        shapeMenu.addActionListener(e -> {
            currentShape = (String) shapeMenu.getSelectedItem();
            shapePanel.setShape(currentShape);
        });

        JButton redBtn = createColorButton("Red", Color.RED);
        JButton greenBtn = createColorButton("Green", Color.GREEN);
        JButton blueBtn = createColorButton("Blue", Color.BLUE);

        controlPanel.add(Box.createVerticalGlue());
        controlPanel.add(shapeLabel);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        controlPanel.add(shapeMenu);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        controlPanel.add(colorLabel);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        controlPanel.add(redBtn);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        controlPanel.add(greenBtn);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        controlPanel.add(blueBtn);
        controlPanel.add(Box.createVerticalGlue());

        add(controlPanel, BorderLayout.EAST);
    }

    private JButton createColorButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(color == Color.GREEN ? Color.BLACK : Color.WHITE);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 3000));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.addActionListener(e -> {
            currentColor = color;
            shapePanel.setColor(currentColor);
            System.out.println("Selected RGB: "
                    + color.getRed() + ", "
                    + color.getGreen() + ", "
                    + color.getBlue());
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new shapeSwitcher().setVisible(true));
    }
}