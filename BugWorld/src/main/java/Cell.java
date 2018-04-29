/**
 * Created by tsamasuo on 28/04/2018.
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;

import org.junit.Assert;
import org.junit.Test;

public class Cell extends Polygon implements CellItem{

    private int positionX;
    private int positionY;
    private int coordinateX;
    private int coordinateY;
    private boolean isHomeArea;
    private enum homeArea{blackAntHome,redAntHome}
    private boolean isFoodSource;
    static final int SIDES =6;

    private Point[] points = new Point[SIDES];
    private Point center = new Point(0, 0);
    private int radius;
    private int rotation = 90;

    public Cell(Point center, int radius) {
        npoints = SIDES;
        xpoints = new int[SIDES];
        ypoints = new int[SIDES];
        this.center = center;
        this.radius = radius;
        updatePoints();
    }


    public Cell(int x, int y, int radius) {
        this(new Point(x, y), radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;

        updatePoints();
    }

    public int getRotation() {
        return rotation;
    }

    public void setCenter(Point center) {
        this.center = center;

        updatePoints();
    }

    public void setCenter(int x, int y) {
        setCenter(new Point(x, y));
    }
    // Finding the angle used in the calculation of radius of the different polygons
    private double findAngle(double fraction) {
        return fraction * Math.PI * 2 + Math.toRadians((rotation + 180) % 360);
    }

    private Point findPoint(double angle) {
        int x = (int) (center.x + Math.cos(angle) * radius);
        int y = (int) (center.y + Math.sin(angle) * radius);

        return new Point(x, y);
    }


    //Updating the coordinates of the different polygons as we iterate through the x-axis and the y-axis
    protected void updatePoints() {
        for (int p = 0; p < SIDES; p++) {
            double angle = findAngle((double) p / SIDES);
            Point point = findPoint(angle);
            xpoints[p] = point.x;
            ypoints[p] = point.y;
            points[p] = point;
            System.out.printf("%d. (%d, %d)\n", p, point.x, point.y);
        }
    }


    // Drawing the polygons in 2D
    public void drawPolygon(Graphics2D g, int x, int y, int lineThickness, int colorValue, boolean filled) {
        // Store before changing.
        Stroke tmpS = g.getStroke();
        Color tmpC = g.getColor();

        g.setColor(new Color(colorValue));
        g.setStroke(new BasicStroke(lineThickness, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        if (filled)
            g.fillPolygon(xpoints, ypoints, npoints);
        else
            g.drawPolygon(xpoints, ypoints, npoints);

        // Set values to previous when done.
        g.setColor(tmpC);
        g.setStroke(tmpS);
    }

    //tocheck if a cell is occupied
    private int occupied(){

    /*to do code*/
        return 0;
    }

    //tocheck if a cell is free
    private int FreeCell(){

    /*to do code*/
        return 0;
    }

    //tocheck if a cell has a bug
    private int bugAt(){

    /*to do code*/
        return 0;
    }

}