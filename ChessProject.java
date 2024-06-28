/*
Sai Avula
2.28.24
ChessProject.java
Chess Game for fun
*/

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class ChessProject extends JFrame
{

    public static void main (String [] args)
    {
        ChessProject hg2016 = new ChessProject();
        hg2016.run();
    }
    public void run()
    {
        JFrame frame = new JFrame("PaintWords");
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);   // or JFrame.EXIT_ON_CLOSE); or frame.EXIT_ON_CLOSE);
        frame.setLocation(400,50);
        frame.setResizable(true);
        HGPanel hgp = new HGPanel();
        frame.setContentPane(hgp);  // OR frame.getContentPane().add(p_in);

        frame.setVisible(true);
        hgp.grabFocus();
    }
}

class HGPanel extends JPanel {

    Rectangle[][] squares;
    Point[][] squarepoint;
    int x, y;
    Image green;
    Image white;
    int oddcounter;

    public HGPanel() {
        setBackground(Color.green);
        y = 0;
        x = 7;
        squares = new Rectangle[8][8];
        squarepoint = new Point[8][8];
        for (int i = 0; i < 8; i++)
        {
            for (int n = 0; n < 8; n++) {
                squarepoint[i][n] = new Point(x, y);
                y += 90;
            }
            y = 0;
            x+=90;
        }
        green = new ImageIcon("GreenSquare.png").getImage();
        white = new ImageIcon("WhiteSquare.png").getImage();
        for (int i = 0; i < 8; i++) {
            for (int n = 0; n < 8; n++) {
                squares[i][n] = new Rectangle((int) squarepoint[i][n].getX(), (int) squarepoint[i][n].getY(), 90, 90);
            }
        }

    }
    public void paintComponent(Graphics g) {
        for (int i = 0; i < 8; i++) {
            if(i % 2 == 1) oddcounter = 0;
            else oddcounter = 1;
            for (int n = 0; n < 8; n++)
            {
                System.out.println(oddcounter);
                if(oddcounter % 2 == 1)
                {
                    System.out.println("2");
                    g.drawImage(green,(int) squarepoint[i][n].getX(), (int) squarepoint[i][n].getY(), 90, 90, null);
                    System.out.println((int) squarepoint[i][n].getX() + "\n" + (int) squarepoint[i][n].getY());
                }
                else if(oddcounter % 2 == 0)
                {
                    System.out.println("1");
                    g.drawImage(white,(int) squarepoint[i][n].getX(), (int) squarepoint[i][n].getY(), 90, 90, null);
                    System.out.println((int) squarepoint[i][n].getX() + "\n" + (int) squarepoint[i][n].getY());
                }
                oddcounter++;
            }

        }
    }
}