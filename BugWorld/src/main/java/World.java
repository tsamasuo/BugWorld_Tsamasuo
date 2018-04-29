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

public class World extends JPanel {

    private String name;
    protected int sizeX;
    protected int sizeY;

    private Font font = new Font("Arial", Font.BOLD, 24);
    FontMetrics metrics;


    // Constructor for world to set width and height
    public World() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    //Logic to paint the hexagonal sell
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        g2d.setFont(font);
        metrics = g.getFontMetrics();
        drawCellGridAdvanced(g2d, 5, 60);
    }

    // Logic to draw heaxagonal polygons using the midpoint and radius against the y and x axis

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
        //String text = String.format("%s : %s", coord(posX), coord(posY));
        //int w = metrics.stringWidth(text);
        int h = metrics.getHeight();
        g.setColor(new Color(0xFFFFFF));
        g.fillPolygon(cell);
        g.setColor(new Color(0x17202A));
        g.drawPolygon(cell);
        g.setColor(new Color(0xFFFFFF));
        // g.drawString(text, x - w/2, y + h/2);
    }


}