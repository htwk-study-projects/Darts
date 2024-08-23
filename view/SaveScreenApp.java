package view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SaveScreenApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create the JFrame
                JFrame frame = new JFrame("Save Screen");

                // Set the default close operation
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Add an instance of SaveScreen to the frame
                frame.getContentPane().add(new SaveScreen());

                // Pack the frame to fit the preferred size of its components
                frame.pack();

                // Set the frame size
                frame.setSize(600, 400);

                // Center the frame on the screen
                frame.setLocationRelativeTo(null);

                // Make the frame visible
                frame.setVisible(true);
            }
        });
    }
}