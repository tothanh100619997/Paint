package Main;

import java.awt.Color;
import java.awt.Point;

public class MyStar implements Hinh2D {
	private Point A, B;
	private Point[] point = new Point[5]; // 5 phần tử đầu chứa điểm chính, 5 phần tử sau chứa phần tử phụ
	private int size;
	private Color color;
	private float angle = 0;
	private float speed = 4;
	private boolean flag_Resize = false;
	public MyStar() {
	}

	public MyStar(Point a, Point b) {
		A = a;
		B = b;
	}

	public Point getA() {
		return A;
	}

	public void setA(Point a) {
		A = a;
	}

	public Point getB() {
		return B;
	}

	public void setB(Point b) {
		B = b;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Point[] getPoint() {
		return point;
	}

	public void setPoint(Point[] point) {
		this.point = point;
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

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public boolean isFlag_Resize() {
		return flag_Resize;
	}

	public void setFlag_Resize(boolean flag_Resize) {
		this.flag_Resize = flag_Resize;
	}

        @Override
	public void draw(GraphicAdapter g) {
            
		MyLine line;
		if (angle == 0 && flag_Resize == false) {
			
			if (A.x > B.x) {
				Point temp = A;
				A = B;
				B = temp;
			}
                        
			int r = (A.y + B.y) / 2 - A.y; // R bán kính
			int xt = (A.x + B.x) / 2; // xt,yt tọa độ tâm của hình chữ nhật
			int yt = (A.y + B.y) / 2;
			float radian = (float) ((72 * Math.PI) / 180); // Đổi độ sang radian
			float a = radian;
                        
			point[0] = new Point(xt, yt -r);

			for (int i = 1; i < 5; i++) {
				int x = (int) (point[0].x * Math.cos(a) - point[0].y * Math.sin(a) + yt * Math.sin(a)
						+ xt * (1 - Math.cos(a)));
				int y = (int) (point[0].x * Math.sin(a) + point[0].y * Math.cos(a) + yt * (1 - Math.cos(a))
						- xt * Math.sin(a));
				point[i] = new Point(x, y);
				a += radian;
			}		

			
				line = new MyLine(point[0], point[2]);
				line.draw(g);
				line = new MyLine(point[0], point[3]);
				line.draw(g);
				line = new MyLine(point[1], point[3]);
				line.draw(g);
				line = new MyLine(point[1], point[4]);
				line.draw(g);
				line = new MyLine(point[2], point[4]);
				line.draw(g);
			
		}else {
			
				line = new MyLine(point[0], point[2]);
				
				line.draw(g);
				line = new MyLine(point[0], point[3]);
				
				line.draw(g);
				line = new MyLine(point[1], point[3]);
				
				line.draw(g);
				line = new MyLine(point[1], point[4]);
				
				line.draw(g);
				line = new MyLine(point[2], point[4]);
				
				line.draw(g);
                                
		}
               
		   

	}
	@Override
	public void makeObject(Point start, Point end) {
		this.setA(start);
		this.setB(end);
		this.setSize(size);
		this.setColor(color);
	}

	@Override
	public void move(Point start, Point end) {
		int dx = end.x - start.x;
		int dy = end.y - start.y;
		this.setA(new Point(this.getA().x + dx, this.getA().y + dy));
		this.setB(new Point(this.getB().x + dx, this.getB().y + dy));
		for (int i = 0; i < 5; i++) {
			point[i] = new Point(point[i].x + dx, point[i].y + dy);
		}
	}

	@Override
	public void rotate(float a) {
		//float a = Gui.angleBetween2Lines(start, end);
		Point[] p = new Point[5];
		for (int i = 0; i < 5; i++) {
			p[i] = new Point(Gui.rotateAround(point[i], a));
		}
		point = p;
		this.setAngle(this.getAngle() + a);
                
               
	}

	@Override
	public void scale(Point start, Point end) {
		flag_Resize = true;
		int dx = end.x - start.x;
		int dy = end.y - start.y;
		Point[] p = new Point[6];
		p[0] = new Point(Gui.rotateAround(point[3], this.getAngle() *(-1)));
		p[1] = new Point(Gui.rotateAround(point[0], this.getAngle() *(-1)));
		p[2] = new Point(Gui.rotateAround(point[2], this.getAngle() *(-1)));
		p[3] = new Point(Gui.rotateAround(point[4], this.getAngle() *(-1)));
		p[4] = new Point(Gui.rotateAround(point[1], this.getAngle() *(-1)));
		
		point[3] = Gui.rotateAround(new Point(p[0].x - dx, p[0].y + dy), this.getAngle());
		point[0] = Gui.rotateAround(new Point(p[1].x, p[1].y - dy), this.getAngle());
		point[2] = Gui.rotateAround(new Point(p[2].x + dx, p[2].y + dy), this.getAngle());
		point[4] = Gui.rotateAround(new Point(p[3].x - dx*3/2, p[3].y - dy/2), this.getAngle());
		point[1] = Gui.rotateAround(new Point(p[4].x + dx*3/2, p[4].y -dy/2 ), this.getAngle());
	}

	

  
  

    @Override
    public boolean contains(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}