/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Plot;

import java.awt.*;
import javax.swing.*;


public class Graph extends JFrame {

    private JLabel statLabel = new JLabel("Current Statistics:");
    private JLabel statLabel1 = new JLabel("100 Cases : |-----|");

    
    
        

     Graph1  stats  = new Graph1();


            
            public Graph()
    {


      
    {
    
       BorderLayout border = new BorderLayout();
       setLayout(border);
        add("North", statLabel);
            add("West", statLabel1);
            add("Center", stats);


        }
    }

    class Graph1 extends java.awt.Canvas {

        int[] point = {1};

        @Override
        public void paint(Graphics screen) {


            for (int i = 0; i < 1; i++) {
                Color blueHue = new Color(0, 0, 255 - (i * 20));
                screen.setColor(blueHue);
                screen.fillRect(10, i * 1, point[i] * 1, 17);

            }

        }
    }

    public static void main(String args[]) {
        Graph application = new Graph();
        application.setSize(370, 280);
        application.setResizable(false);
        application.setVisible(true);

    }
}
