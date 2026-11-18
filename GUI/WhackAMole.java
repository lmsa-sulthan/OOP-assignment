
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class WhackAMole {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // 1. FRAME
            JFrame frame = new JFrame("Whack A Mole");
            frame.setSize(350, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            // 2. INTERMEDIATE COMPONENT
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout(10, 10));

            JPanel gamePanel = new JPanel();
            gamePanel.setLayout(new GridLayout(3, 3, 5, 5));

            // 3. ATOMIC COMPONENT
            JLabel title = new JLabel(
                "WHACK A MOLE",
                SwingConstants.CENTER
            );

            JLabel scoreLabel = new JLabel(
                "Score: 0",
                SwingConstants.CENTER
            );

            JLabel message = new JLabel(
                "Click the MOLE!",
                SwingConstants.CENTER
            );

            JButton[] buttons = new JButton[9];

            // Random mole position
            Random random = new Random();
            int[] molePosition = {random.nextInt(9)};
            int[] score = {0};

            // Create 9 game buttons
            for (int i = 0; i < 9; i++) {

                buttons[i] = new JButton();
                gamePanel.add(buttons[i]);

                final int index = i;

                // 4. EVENT LISTENER
                buttons[i].addActionListener(e -> {

                    if (index == molePosition[0]) {

                        score[0]++;
                        scoreLabel.setText("Score: " + score[0]);
                        message.setText("Nice Hit!");

                        // Move mole to a new position
                        molePosition[0] = random.nextInt(9);

                        while (molePosition[0] == index) {
                            molePosition[0] = random.nextInt(9);
                        }

                        updateButtons(buttons, molePosition[0]);

                    } else {

                        message.setText("Miss! Try Again.");

                    }

                });
            }

            // Initial mole position
            updateButtons(buttons, molePosition[0]);

            // 5. LAYOUT
            JPanel topPanel = new JPanel(new GridLayout(2, 1));
            topPanel.add(title);
            topPanel.add(scoreLabel);

            JButton restartButton = new JButton("Restart");

            restartButton.addActionListener(e -> {

                score[0] = 0;
                scoreLabel.setText("Score: 0");
                message.setText("Click the MOLE!");

                molePosition[0] = random.nextInt(9);
                updateButtons(buttons, molePosition[0]);

            });

            mainPanel.add(topPanel, BorderLayout.NORTH);
            mainPanel.add(gamePanel, BorderLayout.CENTER);
            mainPanel.add(message, BorderLayout.SOUTH);

            frame.add(mainPanel, BorderLayout.CENTER);
            frame.add(restartButton, BorderLayout.SOUTH);

            // Show GUI
            frame.setVisible(true);

        });
    }

    // Update mole position on buttons
    public static void updateButtons(
        JButton[] buttons, int molePosition
    ) {

        for (int i = 0; i < buttons.length; i++) {

            if (i == molePosition) {
                buttons[i].setText("MOLE");
            } else {
                buttons[i].setText("");
            }

        }
    }
}
