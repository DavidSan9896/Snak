package Controller;

import View.SnakePanel;

public class Score implements Runnable {

    private SnakePanel snake;
    int score = 0;

    public Score(SnakePanel snake) {
        this.snake = snake;
    }

    @Override
    public void run() {

        while (true) {
            // Comprueba si la serpiente ha comido la manzana
            int[] cabezaSerpiente = snake.snake.get(0);
            if (cabezaSerpiente[0] == snake.apple[0] && cabezaSerpiente[1] == snake.apple[1]) {
                // Aumenta la puntuación
                score++;
                // Genera una nueva manzana
                snake.generatePoints();
            }

            // Duerme el hilo durante 100 milisegundos
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public String toString() {
        return "Puntuación: " + score;
    }

}

