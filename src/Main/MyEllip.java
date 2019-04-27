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


public class MyEllip implements Hinh2D {

    private Point A, B, C, D;
    private Color lineColor = null;
    private float angle = 0;

    public MyEllip() {
    }

    public MyEllip(Point A, Point B, Point C, Point D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    @Override
    public void makeObject(Point startDrag, Point endDrag) {
        setLineColor(Gui.selectColor);

        setA(new Point(startDrag.x - (endDrag.x - startDrag.x), startDrag.y - (endDrag.y - startDrag.y)));
        setB(new Point(startDrag.x + (endDrag.x - startDrag.x), startDrag.y - (endDrag.y - startDrag.y)));
        setC(new Point(startDrag.x + (endDrag.x - startDrag.x), startDrag.y + (endDrag.y - startDrag.y)));
        setD(new Point(startDrag.x - (endDrag.x - startDrag.x), startDrag.y + (endDrag.y - startDrag.y)));

    }

    public void makeEllip(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, float angle) {
        setA(new Point(x1, y1));
        setB(new Point(x2, y2));
        setC(new Point(x3, y3));
        setD(new Point(x4, y4));
        setAngle(angle);
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
        //float a = Gui.angleBetween2Lines(startDrag, endDrag);
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

    @Override
    public void draw(GraphicAdapter g) {
        float rxSq = this.getDx() * this.getDx();
        float rySq = this.getDy() * this.getDy();
        float x1 = 0, y1 = this.getDy(), p;
        float px = 0, py = 2 * rxSq * y1;
        g.getGraphicAdapter().setColor(this.getLineColor());
        Point p1 = new Point(Gui.rotateAround(this.getO(), this.getAngle()*(-1)));
              
        Gui.Ve4Diem(g.getGraphicAdapter(), p1.x, p1.y, (int)x1, (int)y1, this.getAngle());
        
        //Region 1
        p = rySq - (rxSq * this.getDy()) + (float) (0.25 * rxSq);

        while (px < py) {
            x1++;
            px = px + 2 * rySq;
            if (p < 0) {
                p = p + rySq + px;
            } else {
                y1--;
                py = py - 2 * rxSq;
                p = p + rySq + px - py;
            }
            Gui.Ve4Diem(g.getGraphicAdapter(), p1.x, p1.y, (int)x1, (int)y1, this.getAngle());
        }
        
        //Region 2
        p = (float) (rySq * (x1 + 0.5) * (x1 + 0.5) + rxSq * (y1 - 1) * (y1 - 1) - rxSq * rySq);
        while (y1 > 0) {
            y1--;
            py = py - 2 * rxSq;
            if (p > 0) {
                p = p + rxSq - py;
            } else {
                x1++;
                px = px + 2 * rySq;
                p = p + rxSq - py + px;
            }
            Gui.Ve4Diem(g.getGraphicAdapter(), p1.x, p1.y, (int)x1, (int)y1, this.getAngle());
        }
    }

    
    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color linecolor) {
        this.lineColor = linecolor;
    }

    public Point getO() {
        Point p = new Point();
        p.x = Math.min(this.getA().x, this.getC().x) + Math.abs(this.getA().x - this.getC().x) / 2;
        p.y = Math.min(this.getA().y, this.getC().y) + Math.abs(this.getA().y - this.getC().y) / 2;
        return p;
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

    public void setAngle(float angle) {
        if (angle > 360) {
            angle -= 360;
        }
        this.angle = angle;
    }

    public float getAngle() {
        return angle;
    }

    public float getDx() {
        return (float) this.getA().distance(this.getB()) / 2;
    }

    public float getDy() {
        return (float) this.getA().distance(this.getD()) / 2;
    }

}