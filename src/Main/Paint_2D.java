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
    private  Point mouseCoords = null;
    private final  Cursor brush;
    private static javax.swing.Timer t; 
    public static int i=0;
    
    public Paint_2D(){
       
        setSize(990,580);
        Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();        
        Image brushCursor = toolkit.getImage("D:\\Java\\KyThuatDoHoa\\Image\\brushCursor.png");
        this.brush = toolkit.createCustomCursor(brushCursor, new Point(0, 0), "");
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point a =new Point(50,changeY(50));
                Point b =new Point(-50,changeY(-50));
                MyStar obj = new MyStar();                
                obj.makeObject(a, b); 
                Gui.paint2D.add(obj) ;
                Paint pt = Gui.paint2D.get(0);
                ptemp=pt;
                MyStar r = (MyStar) ptemp;
                
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() { 
                    i=i+1;
                    if(ptemp!=null){
                     ptemp.rotate(20);                     
                     ptemp.move(new Point(0,0), new Point(1,changeY(0)));
                     
                     Gui.flag= new Point(i,0);
//                        System.out.println(r.getA()+"-----------"+r.getB());
                        
                };         
                            
                    
               }
              }, 1000, 100);
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
            //Khung3D(g);
        }
        
         
        /////////////////////////////////////////////////////
       
          if ("star".equals(Gui.selectButton)) {
                
//                if(ptemp!=null){
//                     ptemp.rotate(2);
//                };         
//               
////                Timer timer = new Timer();
////                timer.scheduleAtFixedRate(new TimerTask() {
////                @Override
////                public void run() { 
////                    if((Gui.paint2D.size()>=0)){
////                         
////                    }//                   
////                    
////                }
////              }, 1000, 10000);
                
              repaint();   
              
              
            } 
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
          
           
            
          
            
            
            
            //g.drawString("x = " + mouseCoords.x + "," + " y = " + mouseCoords.y, 10, 30);
        
    }
    int changeY(int y){
        return -y;
    }
}
