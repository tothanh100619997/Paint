 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author totha
 */
import java.awt.Point;
import java.io.BufferedWriter;


public interface Paint {
	public void draw(GraphicAdapter g); //Chuc nang chinh: Draw - ve doi tuong
	public boolean contains(Point p);	//Kiem tra diem co thuoc doi tuong
	public void move(Point startDrag, Point endDrag);	//Ham di chuyen doi tuong
        public void scale(Point startDrag,Point endDrag);//dieu chinh doi tuong
	public void rotate(Point startDrag, Point endDrag);     
        public void writetoFile(BufferedWriter b);	//Ghi cac gia tri doi tuong ra file text
	public void makeObject(Point startDrag, Point endDrag);	//Tao doi tuong
        
}