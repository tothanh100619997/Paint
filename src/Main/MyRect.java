/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.Point;


/**
 *
 * @author toth
 */
public class MyRect implements Hinh2D {

    private Color lineColor = null;
    private Point A, B, C, D;
    private float angle = 0;

    public MyRect() {

    }

    public MyRect(Point A, Point B, Point C, Point D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    @Override
    public void makeObject(Point startDrag, Point endDrag) {
        setLineColor(Gui.selectColor);
        //xác định 4 điểm để vẽ
        setA(new Point(Math.min(startDrag.x, endDrag.x), Math.min(startDrag.y, endDrag.y)));
        setB(new Point(Math.min(startDrag.x, endDrag.x) + Math.abs(startDrag.x - endDrag.x), Math.min(startDrag.y, endDrag.y)));
        setC(new Point(Math.min(startDrag.x, endDrag.x) + Math.abs(startDrag.x - endDrag.x), Math.min(startDrag.y, endDrag.y) + Math.abs(startDrag.y - endDrag.y)));
        setD(new Point(Math.min(startDrag.x, endDrag.x), Math.min(startDrag.y, endDrag.y) + Math.abs(startDrag.y - endDrag.y)));
    }

    public void makeRect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        setA(new Point(x1, y1));
        setB(new Point(x2, y2));
        setC(new Point(x3, y3));
        setD(new Point(x4, y4));
    }

    @Override
    public void draw(GraphicAdapter g) {
        MyLine d1 = new MyLine(this.getA(), this.getB());
        MyLine d2 = new MyLine(this.getC(), this.getB());
        MyLine d3 = new MyLine(this.getC(), this.getD());
        MyLine d4 = new MyLine(this.getA(), this.getD());
        g.getGraphicAdapter().setColor(getLineColor());
        d1.draw(g);
        d2.draw(g);
        d3.draw(g);
        d4.draw(g);
    }

    @Override
    public boolean contains(Point p) {
        int x1, x2, x3, x4, y1, y2, y3, y4;

        x1 = getA().x;
        y1 = getA().y;
        x2 = getB().x;
        y2 = getB().y;
        x3 = getD().x;
        y3 = getD().y;

        double ABC = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        double ABP = Math.abs(x1 * (y2 - p.y) + x2 * (p.y - y1) + p.x * (y1 - y2));
        double APC = Math.abs(x1 * (p.y - y3) + p.x * (y3 - y1) + x3 * (y1 - p.y));
        double PBC = Math.abs(p.x * (y2 - y3) + x2 * (y3 - p.y) + x3 * (p.y - y2));

        boolean isInTriangle1 = ABP + APC + PBC == ABC;

        x4 = getC().x;
        y4 = getC().y;

        double EBC = Math.abs(x4 * (y2 - y3) + x2 * (y3 - y4) + x3 * (y4 - y2));
        double EBP = Math.abs(x4 * (y2 - p.y) + x2 * (p.y - y4) + p.x * (y4 - y2));
        double EPC = Math.abs(x4 * (p.y - y3) + p.x * (y3 - y4) + x3 * (y4 - p.y));

        boolean isInTriangle2 = EBP + EPC + PBC == EBC;

        return isInTriangle1 || isInTriangle2;
    }

    @Override
    public void move(Point startDrag, Point endDrag) {
        Point p1 = new Point(this.getA().x + (endDrag.x - startDrag.x), this.getA().y + (endDrag.y - startDrag.y));
        Point p2 = new Point(this.getB().x + (endDrag.x - startDrag.x), this.getB().y + (endDrag.y - startDrag.y));
        Point p3 = new Point(this.getC().x + (endDrag.x - startDrag.x), this.getC().y + (endDrag.y - startDrag.y));
        Point p4 = new Point(this.getD().x + (endDrag.x - startDrag.x), this.getD().y + (endDrag.y - startDrag.y));

        setA(p1);
        setB(p2);
        setC(p3);
        setD(p4);
    }

    @Override
    public void scale(Point startDrag, Point endDrag) {
        Point p1 = new Point(Gui.rotateAround(this.getA(), this.getAngle() * (-1)));
        Point p2 = new Point(Gui.rotateAround(this.getB(), this.getAngle() * (-1)));
        Point p3 = new Point(Gui.rotateAround(this.getC(), this.getAngle() * (-1)));
        Point p4 = new Point(Gui.rotateAround(this.getD(), this.getAngle() * (-1)));
        int xdDrag, ydDrag;
        xdDrag = endDrag.x - startDrag.x;
        ydDrag = endDrag.y - startDrag.y;

        if (p1.x < p2.x && p1.y < p4.y) {
            p1 = new Point(p1.x - xdDrag, p1.y - ydDrag);
            p2 = new Point(p2.x + xdDrag, p2.y - ydDrag);
            p3 = new Point(p3.x + xdDrag, p3.y + ydDrag);
            p4 = new Point(p4.x - xdDrag, p4.y + ydDrag);
        } else if (p1.x > p2.x && p1.y < p4.y) {
            p1 = new Point(p1.x + xdDrag, p1.y - ydDrag);
            p2 = new Point(p2.x - xdDrag, p2.y - ydDrag);
            p3 = new Point(p3.x - xdDrag, p3.y + ydDrag);
            p4 = new Point(p4.x + xdDrag, p4.y + ydDrag);
        } else if (p1.x < p2.x && p1.y > p4.y) {
            p1 = new Point(p1.x - xdDrag, p1.y + ydDrag);
            p2 = new Point(p2.x + xdDrag, p2.y + ydDrag);
            p3 = new Point(p3.x + xdDrag, p3.y - ydDrag);
            p4 = new Point(p4.x - xdDrag, p4.y - ydDrag);
        } else if (p1.x > p2.x && p1.y > p4.y) {
            p1 = new Point(p1.x + xdDrag, p1.y + ydDrag);
            p2 = new Point(p2.x - xdDrag, p2.y + ydDrag);
            p3 = new Point(p3.x - xdDrag, p3.y - ydDrag);
            p4 = new Point(p4.x + xdDrag, p4.y - ydDrag);
        }

        setA(Gui.rotateAround(p1, this.getAngle()));
        setB(Gui.rotateAround(p2, this.getAngle()));
        setC(Gui.rotateAround(p3, this.getAngle()));
        setD(Gui.rotateAround(p4, this.getAngle()));

    }

    @Override
    public void rotate(float a) {
       // float a = Gui.angleBetween2Lines(startDrag, endDrag);
        Point p1 = getA();
        Point p2 = getB();
        Point p3 = getC();
        Point p4 = getD();

        p1 = Gui.rotateAround(p1, a);
        p2 = Gui.rotateAround(p2, a);
        p3 = Gui.rotateAround(p3, a);
        p4 = Gui.rotateAround(p4, a);

        setA(p1);
        setB(p2);
        setC(p3);
        setD(p4);

        this.setAngle(this.getAngle() + a);
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

    public Point getD() {
        return D;
    }

    public void setD(Point D) {
        this.D = D;
    }

    public int AB() {
        return (int) this.getA().distance(this.getB());
    }

    public int AD() {
        return (int) this.getA().distance(this.getD());
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