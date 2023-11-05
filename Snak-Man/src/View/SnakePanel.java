package View;

import Controller.Move;
import Controller.ObstacleManager;
import Controller.Score;
import Model.Obstacle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SnakePanel extends JPanel {

    Color snakeColor = Color.black;
    int tammax;
    int tam;
    public int can;
    int res;
    public List <int[]> snake = new ArrayList<>();
    String  address = "de";
    String nearbyAddress = "de";
    Color appleColor= Color.red;
    public int [] apple = new int[2];
    Thread hilo;
    ObstacleManager obstacleManager;
    Thread obstacleManagerThread;
    Move move;
    Score score;

    public SnakePanel(int tammax, int can) {
        this.tammax = tammax;
        this.can = can;
        this.tam = tammax/can;
        this.res=tammax%can;
        int [] a= {can/2-1,can/2-1};
        int [] b= {can/2,can/2-1};
        snake.add(a);
        snake.add(b);
        generatePoints();
        starMove();
        starScore();
        startObstacleManager();


    }

    public void starMove(){
        move = new Move(this);
        hilo = new Thread(move);
        hilo.start();

    }
    public void starScore(){
        score = new Score(this);
        Thread hilo2 = new Thread(score);
        hilo2.start();
    }
    public void startObstacleManager() {
        obstacleManager = new ObstacleManager(this);
        obstacleManagerThread = new Thread(obstacleManager);
        obstacleManagerThread.start();
    }

    /*
    Permite volvelo a pintar y borrar
     */
    public void paint(Graphics painter){
        //Regrafica
        super.paint(painter);
        painter.setColor(snakeColor);
        //Permite pintar a la serpiente
        for (int[] par:snake) {
            painter.fillRect(res/2+par[0]*tam,res/2+par[1]*tam,tam-1,tam-1);
        }
        //Pintar Apple
        painter.setColor(appleColor);
        painter.fillRect(res/2+apple[0]*tam,res/2+apple[1]*tam,tam-1,tam-1);
        //Marcador
        painter.setColor(Color.BLACK);
        painter.drawString("" + score, 700, 10);
        //Obtaculo
        painter.setColor(Color.gray);
        for (Obstacle obstacle : obstacleManager.getObstacles()) {
            painter.fillRect(res/2 + obstacle.getX() * tam, res/2 + obstacle.getY() * tam, tam - 1, tam - 1);
        }
    }

    public void goTo(){
        equalizeAddress();
        int[] end = snake.get(snake.size()-1);
        int addx =0;
        int addy = 0;
        switch (address){
            case "de":
                addx = 1;
                break;
            case "iz":
                addx = -1;
                break;
            case "ar":
                addy = -1;
                break;
            case "ab":
                addy = 1;
                break;
        }
        int [] neww={
                Math.floorMod(end[0]+addx,can),
                Math.floorMod(end[1]+addy,can)};
        boolean see = false;
        for (int i = 0; i < snake.size() ; i++) {
            if(neww [0] == snake.get(i)[0] &&  neww [1] == snake.get(i)[1]){
                see = true;
                break;
            }
        }
        if (see){
            obstacleManager.checkCollision(neww[0], neww[1]);
            score.setGameOver();
            move.stopp();
            JOptionPane.showMessageDialog(this,"Perdiste");
        }else{
            if (neww[0] == apple[0] && neww[1] == apple[1]){
                snake.add(neww);
                generatePoints();
                score.increaseScore();

            }else {
                snake.add(neww);
                snake.remove(0);
            }
        }

    }

    /**
     * Genera Los puntos
     */
    public void generatePoints(){
        int a = (int) (Math.random()*can);
        int b = (int) (Math.random()*can);
        boolean see = false;
        for (int[] par:snake) {
            if (par[0]==a && par[1]==b){
                see = true;
                generatePoints();
                break;
            }
        }
        if (!see){
            this.apple[0] = a;
            this.apple[1] = b;
        }
    }


    /**
     * Cambia los movimientos
     * @param addr
     */
    public void changeOfAddress(String addr){
        this.nearbyAddress = addr;
    }

    /**
     * Iguala los movimientos
     */
    public void equalizeAddress(){
        this.address = this.nearbyAddress;
    }
}
