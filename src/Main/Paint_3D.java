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

import static Main.Gui.paint3D;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Paint_3D extends JComponent {

	public Paint_3D() 
        {   

        }
        @Override
	public void paint(Graphics g) {
            
		GraphicAdapter g2 = new GraphicAdapter() {};
		g2.setGraphicAdapter(g);
                
                Gui.paint3D.forEach((pt) -> {
                    pt.draw(g2);
                });                           
                
                g.setColor(Color.BLACK);
                g.drawString("X", 1110, 295);
                g.drawString("Y", 100, 590);
                g.drawString("Z", 405, 10);                

                for(int i = 0,a = 0;i < 8;i++,a+=100){
                   g.drawLine(400+a, 298, 400+a, 302);
                   g.drawLine(398, 300-a, 402,300- a);
                   g.drawLine(348-a/2, 348+a/2, 352-a/2, 352+a/2);
                }
                
                MyLine dt1 = new MyLine();
                MyLine dt2 = new MyLine();
                MyLine dt3 = new MyLine();           
                if(Gui.paint3D.isEmpty()){
                    Gui.selectColor = Color.BLACK;
                    dt1.makeLine(400, 300, 400, 0);
                    dt1.draw(g2);
                    dt1.makeLine(400, 300, 1150, 300);            
                    dt1.draw(g2);
                    dt1.makeLine(400, 300, 100, 600);            
                    dt1.draw(g2);
                }             
                //----------------------------------------------
                if(!"".equals(Gui.selectButton)){           
                    if("Cube".equals(Gui.selectButton)){
                        Gui.paint3D.clear();
                        Gui.paint3D.removeAll(paint3D);
                        MyCube obj = new MyCube();
                        obj.makeCube(Gui.X,Gui.Y,Gui.Z);
                        Gui.paint3D.add(obj);
                        
                        dt1.makeLine(obj.getDt1().getB().x,obj.getDt1().getB().y, 400, 0);
                        dt1.draw(g2);
                        Gui.paint3D.add(dt1);
                        dt2.makeLine(obj.getDt4().getB().x,obj.getDt4().getB().y, 1150,  300);
                        Gui.paint3D.add(dt2);
                        dt2.draw(g2);
                        dt3.makeLine(obj.getDt5().getA().x,obj.getDt5().getA().y, 100, 600);
                        Gui.paint3D.add(dt3);
                    }
                    else if("Pyramid".equals(Gui.selectButton)){
                        Gui.paint3D.clear();
                        Gui.paint3D.removeAll(paint3D);
                        MyPyramid obj = new MyPyramid();
                        obj.makePyramid(Gui.X,Gui.Y,Gui.Z);
                        Gui.paint3D.add(obj);
                        

                        dt1.makeLine(obj.getDt12().getB().x, obj.getDt12().getB().y,400,0);
                        Gui.paint3D.add(dt1);
                        dt2.makeLine(obj.getDt1().getB().x,obj.getDt1().getB().y, 1150,  300);
                        Gui.paint3D.add(dt2);
                        dt3.makeLine(obj.getDt2().getA().x,obj.getDt2().getA().y, 100, 600);
                        Gui.paint3D.add(dt3);
                    }
                }
                
                Gui.selectButton = "";              
                repaint();
                validate();
            
	}

}