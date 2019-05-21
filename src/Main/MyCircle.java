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
import java.awt.Point;

public class MyCircle extends MyEllip {

    @Override
    public void makeObject(Point startDrag, Point endDrag) {
        setLineColor(Gui.selectColor);
        setA(new Point(startDrag.x , startDrag.y));
        setB(new Point(startDrag.x +endDrag.y+endDrag.y,startDrag.y));
        setC(new Point(startDrag.x +endDrag.y+endDrag.y, endDrag.y));
        setD(new Point(startDrag.x ,  endDrag.y));
        
    }

    @Override
    public void scale(Point startDrag, Point endDrag) {
        Point p1 = new Point(Gui.rotateAround(this.getA(), this.getAngle() * (-1)));
        Point p2 = new Point(Gui.rotateAround(this.getB(), this.getAngle() * (-1)));
        Point p3 = new Point(Gui.rotateAround(this.getC(), this.getAngle() * (-1)));
        Point p4 = new Point(Gui.rotateAround(this.getD(), this.getAngle() * (-1)));

        int dDrag, xdDrag, ydDrag;
        xdDrag = endDrag.x - startDrag.x;
        ydDrag = endDrag.y - startDrag.y;
        if (xdDrag > ydDrag) {
            dDrag = xdDrag;
        } else {
            dDrag = ydDrag;
        }

        if (p1.x < p2.x && p1.y < p4.y) {
            p1 = new Point(p1.x - dDrag, p1.y - dDrag);
            p2 = new Point(p2.x + dDrag, p2.y - dDrag);
            p3 = new Point(p3.x + dDrag, p3.y + dDrag);
            p4 = new Point(p4.x - dDrag, p4.y + dDrag);
        } else if (p1.x > p2.x && p1.y < p4.y) {
            p1 = new Point(p1.x + dDrag, p1.y - dDrag);
            p2 = new Point(p2.x - dDrag, p2.y - dDrag);
            p3 = new Point(p3.x - dDrag, p3.y + dDrag);
            p4 = new Point(p4.x + dDrag, p4.y + dDrag);
        } else if (p1.x < p2.x && p1.y > p4.y) {
            p1 = new Point(p1.x - dDrag, p1.y + dDrag);
            p2 = new Point(p2.x + dDrag, p2.y + dDrag);
            p3 = new Point(p3.x + dDrag, p3.y - dDrag);
            p4 = new Point(p4.x - dDrag, p4.y - dDrag);
        } else if (p1.x > p2.x && p1.y > p4.y) {
            p1 = new Point(p1.x + dDrag, p1.y + dDrag);
            p2 = new Point(p2.x - dDrag, p2.y + dDrag);
            p3 = new Point(p3.x - dDrag, p3.y - dDrag);
            p4 = new Point(p4.x + dDrag, p4.y - dDrag);
        }

        setA(Gui.rotateAround(p1, this.getAngle()));
        setB(Gui.rotateAround(p2, this.getAngle()));
        setC(Gui.rotateAround(p3, this.getAngle()));
        setD(Gui.rotateAround(p4, this.getAngle()));
    }

}