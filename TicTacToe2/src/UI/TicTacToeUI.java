package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.TicTacToe;
public class TicTacToeUI extends JFrame {

    private TicTacToe game;
    private JButton[][] buttons;
    
    public TicTacToeUI() {
        game = new TicTacToe();
        buttons = new JButton[3][3];

        initializeUI();
    }

    private void initializeUI() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 80));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));

                add(buttons[i][j]);
            }
        }

        pack();
        setSize(400, 400);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (game.checkWin() || game.isBoardFull()) {
                JOptionPane.showMessageDialog(null, "Game Over. Resetting the game.");
                game.reset();
                updateButtons();
                return;
            }

            if (game.makeMove(row, col)) {
                buttons[row][col].setText(String.valueOf(game.getCurrentPlayer()));
                if (game.checkWin()) {
                    JOptionPane.showMessageDialog(null, "Player " + game.getCurrentPlayer() + " wins! Resetting the game.");
                    game.reset();
                    updateButtons();
                } else if (game.isBoardFull()) {
                    JOptionPane.showMessageDialog(null, "It's a draw! Resetting the game.");
                    game.reset();
                    updateButtons();
                }
            }
        }
    }

    private void updateButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeUI());
    }
}
