package Controller;

import Model.Obstacle;
import View.SnakePanel;

import java.util.ArrayList;
import java.util.List;

public class ObstacleManager implements Runnable {
    private List<Obstacle> obstacles;
    private SnakePanel snakePanel;
    private boolean running;

    public ObstacleManager(SnakePanel snakePanel) {
        this.obstacles = new ArrayList<>();
        this.snakePanel = snakePanel;
        this.running = true;
    }

    @Override
    public void run() {
        while (running) {
            // Genera un nuevo obstáculo cada cierto intervalo de tiempo
            generateObstacle();

            try {
                Thread.sleep(3000); // Ajusta el intervalo de generación de obstáculos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    private void generateObstacle() {
        // Genera un obstáculo en una ubicación aleatoria
        int x = (int) (Math.random() * snakePanel.can);
        int y = (int) (Math.random() * snakePanel.can);

        // Agrega el obstáculo a la lista
        obstacles.add(new Obstacle(x, y));
    }
    public boolean checkCollision(int x, int y) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getX() == x && obstacle.getY() == y) {
                return true;
            }
        }
        stop();
        return false;
    }



    public void stop() {
        running = false;
    }
}
