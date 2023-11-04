package View;

import javax.swing.*;
import java.awt.*;

public class ViewFund extends JPanel {
    Color background = Color.green;
    int tammax, tam,can,res;

    public ViewFund(int tammax, int can) {
        this.tammax = tammax;
        this.can = can;
        this.tam = tammax/can;
        this.res=tammax%can;
    }
    /*
    Permite volvelo a pintar y borrar
     */
     public void paint(Graphics painter){
         //Regrafica
        super.paint(painter);
        painter.setColor(background);
         for (int i = 0; i <can ; i++) {
             for (int j = 0; j <can ; j++) {
                 painter.fillRect(res/2+i*tam,res/2+j*tam,tam-1,tam-1);
             }
             
         }
     }

}
