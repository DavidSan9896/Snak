package View;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeView extends JFrame {
    SnakePanel snake;
    public SnakeView(){
        setSize(850,850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        snake = new SnakePanel(800,30);
        this.add(snake);
        snake.setBounds(10,10,800,800);
        snake.setOpaque(false);

        ViewFund fund = new ViewFund(800,30);
        this.add(fund);
        fund.setBounds(10,10,800,800);

        this.requestFocus(true);

    }


}

