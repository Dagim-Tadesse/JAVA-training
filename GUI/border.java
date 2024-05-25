package GUI;

import javax.swing.*;
import java.awt.*;

public class border {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("BorderLayout Demo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the panel with BorderLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Add buttons to different regions
        panel.add(new JButton("North"), BorderLayout.NORTH);
        panel.add(new JButton("South"), BorderLayout.SOUTH);
        panel.add(new JButton("Center"), BorderLayout.CENTER);

        // Add panel to frame
        frame.add(panel);

        // Set frame visibility
        frame.setVisible(true);
    }
}
