package Controller;

import View.SnakePanel;


public class Move implements Runnable {
    SnakePanel snake;
    boolean status = true;

    public Move(SnakePanel panel) {
        this.snake = panel;

    }

    @Override
    public void run() {
        while (status) {
            snake.goTo();
            snake.repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void stopp(){
        this.status=false;
    }
}

