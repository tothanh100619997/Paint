/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author toth
 */
import java.awt.Color;
import java.awt.Point;


public class MyTriangle implements Hinh2D {

    private Point A, B, C;
    private Color lineColor = null;
    private float angle = 0;

    public MyTriangle() {

    }

    public MyTriangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public void makeObject(Point startDrag, Point endDrag) {
        setLineColor(Gui.selectColor);
        this.setA(new Point(startDrag.x, startDrag.y));
        this.setB(new Point(startDrag.x + (endDrag.x - startDrag.x), startDrag.y + (endDrag.y - startDrag.y)));
        this.setC(new Point(startDrag.x - (endDrag.x - startDrag.x), startDrag.y + (endDrag.y - startDrag.y)));

    }

    public void makeTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.setA(new Point(x1, y1));
        this.setB(new Point(x2, y2));
        this.setC(new Point(x3, y3));
    }

    @Override
    public boolean contains(Point p) {
        int x1 = getA().x, y1 = getA().y;
        int x2 = getB().x, y2 = getB().y;
        int x3 = getC().x;
        int y3 = getC().y;

        double ABC = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        double ABP = Math.abs(x1 * (y2 - p.y) + x2 * (p.y - y1) + p.x * (y1 - y2));
        double APC = Math.abs(x1 * (p.y - y3) + p.x * (y3 - y1) + x3 * (y1 - p.y));
        double PBC = Math.abs(p.x * (y2 - y3) + x2 * (y3 - p.y) + x3 * (p.y - y2));

        boolean isInTriangle = ABP + APC + PBC == ABC;
        return isInTriangle;
    }

    @Override
    public void move(Point startDrag, Point endDrag) {
        Point p1 = new Point(this.getA().x + (endDrag.x - startDrag.x), this.getA().y + (endDrag.y - startDrag.y));
        Point p2 = new Point(this.getB().x + (endDrag.x - startDrag.x), this.getB().y + (endDrag.y - startDrag.y));
        Point p3 = new Point(this.getC().x + (endDrag.x - startDrag.x), this.getC().y + (endDrag.y - startDrag.y));

        this.setA(p1);
        this.setB(p2);
        this.setC(p3);
    }

    @Override
    public void scale(Point startDrag, Point endDrag) {
        int xdDrag, ydDrag;
        Point p1 = new Point(Gui.rotateAround(this.getA(), this.getAngle() * (-1)));
        Point p2 = new Point(Gui.rotateAround(this.getB(), this.getAngle() * (-1)));
        Point p3 = new Point(Gui.rotateAround(this.getC(), this.getAngle() * (-1)));

        xdDrag = endDrag.x - startDrag.x;
        ydDrag = endDrag.y - startDrag.y;

        if (p1.x > p3.x && p1.y < p3.y) {
            p1 = new Point(p1.x, p1.y - ydDrag);
            p2 = new Point(p2.x + xdDrag, p2.y + ydDrag);
            p3 = new Point(p3.x - xdDrag, p3.y + ydDrag);
        } else if (p1.x > p3.x && p1.y > p3.y) {
            p1 = new Point(p1.x, p1.y + ydDrag);
            p2 = new Point(p2.x + xdDrag, p2.y - ydDrag);
            p3 = new Point(p3.x - xdDrag, p3.y - ydDrag);
        } else if (p1.x < p3.x && p1.y < p3.y) {
            p1 = new Point(p1.x, p1.y - ydDrag);
            p2 = new Point(p2.x - xdDrag, p2.y + ydDrag);
            p3 = new Point(p3.x + xdDrag, p3.y + ydDrag);
        } else if (p1.x < p3.x && p1.y > p3.y) {
            p1 = new Point(p1.x, p1.y + ydDrag);
            p2 = new Point(p2.x - xdDrag, p2.y - ydDrag);
            p3 = new Point(p3.x + xdDrag, p3.y - ydDrag);
        }

        setA(Gui.rotateAround(p1, this.getAngle()));
        setB(Gui.rotateAround(p2, this.getAngle()));
        setC(Gui.rotateAround(p3, this.getAngle()));
    }

    @Override
    public void rotate(float a) {
        //float a = Gui.angleBetween2Lines(startDrag, endDrag);
        Point p1 = getA();
        Point p2 = getB();
        Point p3 = getC();

        p1 = Gui.rotateAround(p1, a);
        p2 = Gui.rotateAround(p2, a);
        p3 = Gui.rotateAround(p3, a);

        setA(p1);
        setB(p2);
        setC(p3);
        this.setAngle(this.getAngle() + a);
    }

    @Override
    public void draw(GraphicAdapter g) {
        g.getGraphicAdapter().setColor(getLineColor());
        MyLine d1 = new MyLine(this.getA(), this.getB());
        MyLine d2 = new MyLine(this.getC(), this.getB());
        MyLine d3 = new MyLine(this.getC(), this.getA());

        g.getGraphicAdapter().setColor(getLineColor());
        d1.draw(g);
        d2.draw(g);
        d3.draw(g);
    }

    

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public Point getA() {
        return A;
    }

    public void setA(Point A) {
        this.A = A;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point B) {
        this.B = B;
    }

    public Point getC() {
        return C;
    }

    public void setC(Point C) {
        this.C = C;
    }

    public int AB() {
        return (int) this.getA().distance(this.getB());
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        if (angle > 360) {
            angle -= 360;
        }
        this.angle = angle;
    }

   

}