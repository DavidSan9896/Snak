package Controller;

import View.SnakePanel;

public class Score implements Runnable {
    private int score;
    private boolean running;
    private boolean gameOver;
    private boolean appleEaten; // Agrega una bandera para controlar si se ha comido una manzana


    public Score(SnakePanel panel) {
        this.score = 0;
        this.running = true;
        this.gameOver = false;
        this.appleEaten = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000); // Pausa el hilo durante un segundo

                if (gameOver) {
                    break; // Si el juego ha terminado, sal del bucle
                }

                if (appleEaten) {
                    increaseScore(); // Aumenta la puntuación solo cuando se ha comido una manzana
                    appleEaten = false; // Restablece la bandera
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }
    public void appleEaten() {
        appleEaten = true;
    }
    public void setGameOver() {
        gameOver = true;
    }

    public String toString() {
        return "Puntuación: " + score;
    }

}

