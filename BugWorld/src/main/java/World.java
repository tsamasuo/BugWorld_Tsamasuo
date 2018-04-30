/**
 * Created by tsamasuo on 28/04/2018.
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.io.FileInputStream;

public class World extends JPanel {

    private String name;
    protected int sizeX;
    protected int sizeY;
    protected boolean state;

    private Font font = new Font("Arial", Font.BOLD, 24);
    FontMetrics metrics;


    // Constructor for world to set width and height
    public World() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    /*
        Load map contents and update all key positions as per loaded map
     */
 
    public void updateWorld(StringBuffer buffer, World p)
    {
        int x = 0;

        for (int i = 0; i < (p.sizeX * p.sizeY); i++)
        {
            if (i > 0 && (i % p.sizeX) == 0) {
                buffer.append('\n');
                if (((i / p.sizeX) % 2) == 1) {
                    buffer.append(' ');
                }
            }

            char last = ' ';
            /*
                code to update world with items. a if-else loop or case switch is required.
             */

            buffer.append(last);
        }

        return;
    }


    //Logic to paint the hexagonal sell
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        g2d.setFont(font);
        metrics = g.getFontMetrics();
        drawCellGridAdvanced(g2d, 5, 60);
    }


    private void drawCellGridAdvanced(Graphics g, int n, int r) {
        double ang30 = Math.toRadians(30);
        double xOff = Math.cos(ang30) * r;
        //double yOff = Math.sin(ang30) * r;
        int row;
        int col;
        int nrows = 50;
        int ncols = 50;
        for (row = 0; row < nrows; row++) {
            for (col = 0; col < ncols; col++) {
                drawCell(g, (int) ((2 * col + 1)*xOff), (int) ((2*r+3*r*row)), r);
                drawCell(g, (int) (2*col*xOff-1), (int) ((3 *r)* row +r/2 ), r);
            }
        }
    }


    //Logic for cell properties

    private void drawCell(Graphics g, int x, int y, int r) {
        Cell cell = new Cell(x, y, r);

        int h = metrics.getHeight();
        g.setColor(new Color(0xFFFFFF));
        g.fillPolygon(cell);
        g.setColor(new Color(0x17202A));
        g.drawPolygon(cell);
        g.setColor(new Color(0xFFFFFF));
        // g.drawString(text, x - w/2, y + h/2);
    }

/*
Gets the map data from a files in terms of obstacles, positions of food, home areas etc
 */
    private static void readMap(FileInputStream fis){
        /*

         */

    }


}