package View;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeView extends JFrame {
    SnakePanel snake;

    public SnakeView() {
        setSize(850, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        snake = new SnakePanel(800, 30);
        this.add(snake);
        snake.setBounds(10, 10, 800, 800);
        snake.setOpaque(false);

        ViewFund fund = new ViewFund(800, 30);
        this.add(fund);
        fund.setBounds(10, 10, 800, 800);


        this.requestFocus(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        snake.changeOfAddress("ar");
                        break;
                    case KeyEvent.VK_DOWN:
                        snake.changeOfAddress("ab");
                        break;
                    case KeyEvent.VK_LEFT:
                        snake.changeOfAddress("iz");
                        break;
                    case KeyEvent.VK_RIGHT:
                        snake.changeOfAddress("de");
                        break;
                    case KeyEvent.VK_W:
                        snake.changeOfAddress("ar");
                        break;
                    case KeyEvent.VK_S:
                        snake.changeOfAddress("ab");
                        break;
                    case KeyEvent.VK_A:
                        snake.changeOfAddress("iz");
                        break;
                    case KeyEvent.VK_D:
                        snake.changeOfAddress("de");
                        break;
                    default:
                        break;
                }
            }
        });

    }

}

