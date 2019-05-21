/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;



import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComponent;



/**
 *
 * @author totha
 */


public class Paint_2D extends JComponent{
   
    public Point startDrag, endDrag;
    public Paint ptemp=null;
    public Paint ptemp1=null;
    public Paint ptemlBall=null;
    private  Point mouseCoords = null;
    private final  Cursor brush;
    private static javax.swing.Timer t; 
    public float angle =20;
    public int  kc=Gui.kc;
    public int duration = Gui.duration;
    
    
    public int _vanToc =0;
    public int _giaToc  = 1;

    public Paint_2D(){
       // 495 290
        setSize(990,580);
        Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();        
        Image brushCursor = toolkit.getImage("D:\\Java\\KyThuatDoHoa\\Image\\brushCursor.png");
        this.brush = toolkit.createCustomCursor(brushCursor, new Point(0, 0), "");
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if("star".equals(Gui.selectButton)){    
                           
                            int bk = Gui.bk;                            
                            Point a =new Point(-494,changeY(bk));
                            Point b =new Point(-494+bk*2,changeY(-bk));
                            MyStar obj = new MyStar();                
                            obj.makeObject(a, b); 
                            Gui.paint2D.add(obj) ;
                            Paint pt = Gui.paint2D.get(0);
                            ptemp=pt;
                            MyStar r = (MyStar) ptemp;
                            MyCircle dtr = new MyCircle();
                            dtr.makeObject( a,b);
                            Gui.paint2D.add(dtr);                

                            Paint pt1 = Gui.paint2D.get(1);
                            ptemp1 =pt1;
                            MyRect hcn = new MyRect();
                            hcn.makeObject(new Point(-490,changeY(-bk)), new Point(490,changeY(-bk-5)));
                            Gui.paint2D.add(hcn);

                            Timer timer = new Timer();
                            timer.scheduleAtFixedRate(new TimerTask() {
                            @Override
                            @SuppressWarnings("empty-statement")
                            public void run() { 
                                 if("clear".equals(Gui.selectButton)){
                                    timer.cancel();
                                        angle=20;
                                        kc=5;
                                        Gui.flag=new Point(-494+bk,0);
                                       
                                }
                                if(r.getB().x>495){
                                    angle=-angle;
                                    kc=-kc;
                                }
                                if(r.getA().x<-495){
                                     angle=-angle;
                                    kc=-kc;
                                }

                                if(ptemp!=null){
                                 ptemp.rotate(angle);                     
                                 ptemp.move(new Point(0,0), new Point(kc,changeY(0)));
                                 ptemp1.move(new Point(0,0), new Point(kc,changeY(0)));
                                 Gui.flag= new Point((r.getA().x+r.getB().x)/2,0);

                            };         


                           }
                          }, 2000, duration);
                }
                if("ball".equals(Gui.selectButton)){
                    MyEllip ball = new MyEllip();
                    ball.makeObject(new Point(0,changeY(260)), new Point(30,changeY(230)));
                    Gui.paint2D.add(ball);                    
                     Paint pt = Gui.paint2D.get(0);
                     ptemlBall=pt;
                     MyEllip p = (MyEllip) ptemlBall;
                    MyRhombus rbs = new MyRhombus();
                    rbs.makeObject(new Point(0,changeY(-100)), new Point(200,changeY(-200)));
                    Gui.paint2D.add(rbs);
                    
                    MyRect chan1 = new MyRect();
                    chan1.makeObject(new Point(-200, changeY(-150)), new Point(-198, changeY(-290)));
                    Gui.paint2D.add(chan1);
                    
                    MyRect chan2 = new MyRect();
                    chan2.makeObject(new Point(0, changeY(-200)), new Point(2, changeY(-290)));
                    Gui.paint2D.add(chan2);
                    
                    MyRect chan3 = new MyRect();
                    chan3.makeObject(new Point(200, changeY(-150)), new Point(202, changeY(-290)));
                    Gui.paint2D.add(chan3);
                    
                    MyLine dt1 = new MyLine();
                    dt1.makeObject( new Point(-200,changeY(-160)), new Point(0,changeY(-210)));
                    Gui.paint2D.add(dt1);
                    
                    MyLine dt2 = new MyLine();
                    dt2.makeObject( new Point(0,changeY(-210)), new Point(200,changeY(-160)));
                    Gui.paint2D.add(dt2);
                    
                     Timer timer = new Timer();
                            timer.scheduleAtFixedRate(new TimerTask() {
                            @Override
                            public void run() { 
                                if("clear".equals(Gui.selectButton)){
                                    timer.cancel();
                                    _vanToc=0;
                                    _giaToc=1;
                                }
                                if(ptemlBall!=null){
                                    _vanToc +=_giaToc;//9,8 m/s^2
                                    Gui.vanToc=_vanToc;
                                    if(p.getB().y>100){
                                        _vanToc=(int) (-(int)_vanToc*0.9);
                                    }
                                  
                                   ptemlBall.move(new Point(0,0), new Point(0, (int) changeY(-_vanToc)));
                                }
                            };         

                          }, 1000, duration);
                }
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            
            @Override
            public void mouseDragged(MouseEvent e) {
                
                endDrag = new Point(e.getX(), e.getY() );
                mouseCoords = new Point(e.getX(), e.getY());
                repaint();
            }
           
            @Override
           
            public void mouseMoved(MouseEvent e) {          
                
                mouseCoords = new Point(e.getX(), e.getY());
                
                repaint();
            }

        });
        
        
        //setBackground(Color.RED);
        //setVisible(true);
    }
    
    @Override
   
    public void paint(Graphics g){
        
        setCursor(brush);
        Graphics2D g2d = (Graphics2D) g;       
        g2d.translate(494.0, 290.0);//
        g2d.scale(1, 1);
        
         GraphicAdapter g2 = new GraphicAdapter() {
        };
        g2.setGraphicAdapter(g);
         Point p1, p2, p3, p4;
        if (Gui.Draw3d == false) {
            Khung2D(g);
        } else {
            Khung3D(g);
        }
        
        repaint();
        /////////////////////////////////////////////////////
       

    }
    public void Khung2D(Graphics g) {
      
        GraphicAdapter g2 = new GraphicAdapter() {
            
        };
        g2.setGraphicAdapter(g);
        
      
        //Draw Area
        //setSize(990,580);
         g.setColor(Color.LIGHT_GRAY);
        for (int i = 0, a = -494,b =-290; i < 200; i++, a += 5,b-=5) {//120 -10
            g.drawLine(a, 290, a, -290);
            g.drawLine(-494, a, 494, a);
        }
        
        g.setColor(Color.BLACK);
        g.drawLine(0, 290, 0, -290);//560 0 560 800
        g.drawLine(-494, 0, 494, 0);
        g.drawString("X", 485, 20);
        g.drawString("Y", -20, -275);
        g.drawString("O", -20, 20);
       // g.drawString("20", 520, 310);//570 320
        for (int i = 0, a = -500, b= 300; i < 60; i++, a += 20,b-=20) {//60
            g.drawLine(a, 3, a, -3);
            g.drawLine(3, b, -3, b);
        }
        Gui.paint2D.forEach((pt) -> {
            pt.draw(g2);
        });
        coordinates(g2.getGraphicAdapter());
    }
    public void Khung3D(Graphics g) {
        GraphicAdapter g2 = new GraphicAdapter() {
        };
        g2.setGraphicAdapter(g);

        Gui.paint3D.forEach((pt) -> {
            pt.draw(g2);
        });
        g.setColor(Color.BLACK);
        g.drawString("X", 480, changeY(-20));
        g.drawString("Y", -290, changeY(-280));
        g.drawString("Z", 20, changeY(270));

       

        MyLine dt1 = new MyLine();
        MyLine dt2 = new MyLine();
        MyLine dt3 = new MyLine();
        if (Gui.paint3D.isEmpty()) {
            Gui.selectColor = Color.BLACK;
            dt1.makeLine(0, 0, 0, changeY(290));//oz
            dt1.draw(g2);
            dt1.makeLine(0, 0, -270, changeY(-290));//0y
            dt1.draw(g2);
            dt1.makeLine(0, 0, 495, 0);//ox
            dt1.draw(g2);
        }
        if (!"".equals(Gui.selectButton)) {
            if ("Cube".equals(Gui.selectButton)) {
                Gui.paint3D.clear();
                Gui.paint3D.removeAll(Gui.paint3D);
                MyCube obj = new MyCube();
                obj.makeCube(Gui.X, Gui.Y, Gui.Z);
                Gui.paint3D.add(obj);

                dt1.makeLine(obj.getDt1().getB().x, obj.getDt1().getB().y, 495, 0);//ox
                dt1.draw(g2);
                Gui.paint3D.add(dt1);
                dt2.makeLine(obj.getDt4().getB().x, obj.getDt4().getB().y, 0,changeY(290));//oz
                Gui.paint3D.add(dt2);
                dt2.draw(g2);
                dt3.makeLine(obj.getDt5().getB().x, obj.getDt5().getB().y, -280, changeY(-290));//0y
                Gui.paint3D.add(dt3);
            } else if ("Pyramid".equals(Gui.selectButton)) {
                Gui.paint3D.clear();
                Gui.paint3D.removeAll(Gui.paint3D);
                MyPyramid obj = new MyPyramid();
                obj.makePyramid(Gui.X, Gui.Y, Gui.Z);
                Gui.paint3D.add(obj);

                dt1.makeLine(obj.getDt1().getB().x, obj.getDt1().getB().y, 495, 0);
                Gui.paint3D.add(dt1);
                dt2.makeLine(obj.getDt12().getB().x, obj.getDt12().getB().y, 0, changeY(290));
                Gui.paint3D.add(dt2);
                dt3.makeLine(obj.getDt2().getA().x, obj.getDt2().getA().y, -280, changeY(-290));
                Gui.paint3D.add(dt3);
            }
        }

     
        repaint();
        validate();
    }
    private void coordinates(Graphics g) {
        if (mouseCoords == null) {
            return;
        }
        
            g.setColor(Color.RED);
            
           if(mouseCoords.x<494 && mouseCoords.y<290){                                    // 1 1 494 -290
             g.drawString(" (" + (mouseCoords.x-494) + "," + (mouseCoords.y-290 )*-1 + ")", mouseCoords.x-494+30, mouseCoords.y-290+30);
            }
           if(mouseCoords.x<494 && mouseCoords.y>290){                                    // 1 1 494 -290
             g.drawString(" (" + (mouseCoords.x-494) + "," + (mouseCoords.y-290) + ")", mouseCoords.x-494+30, mouseCoords.y-290+30);
            }
           if(mouseCoords.x>494 && mouseCoords.y<290){                                    // 1 1 494 -290
             g.drawString(" (" + (mouseCoords.x-490) + "," + (mouseCoords.y*-1+290) + ")", mouseCoords.x-494+30, mouseCoords.y-290+30);
            }
           if(mouseCoords.x>494 && mouseCoords.y>290){                                    // 1 1 494 -290
             g.drawString(" (" + (mouseCoords.x-494) + "," + (mouseCoords.y*-1+290) + ")", mouseCoords.x-494+30, mouseCoords.y-290+30);
            }
        
        
    }
    int changeY(int y){
        return -y;
    }
}
