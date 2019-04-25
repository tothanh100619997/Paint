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
import java.awt.Graphics;

abstract class GraphicAdapter{
	public Graphics GraphicAdapter;
	public GraphicAdapter(){
	}
	public GraphicAdapter(Graphics g){
		this.GraphicAdapter =  g;
	}

	public Graphics getGraphicAdapter() {
		return GraphicAdapter;
	}
	public void setGraphicAdapter(Graphics graphicAdapter) {
		GraphicAdapter = graphicAdapter;
	}
}