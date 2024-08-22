package view;

import javax.swing.*;
import java.awt.*;


public class DartArrowGraphic extends JPanel {
    
	private int [] xPoints_arrowhead = {718,720,722};
	private int [] yPoints_arrowhead = {295,250,295};
	private int nPoints_arrowhead = 3; // Anzahl der Punkte
	
	private int [] xPoints_body = {718,719,721,722}; 
	private int [] yPoints_body = {295,370,370,295}; 
	private int nPoints_body = 4; 


	private int [] xPoints_feather = {710,715,720,725,730,719,721,}; 
	private int [] yPoints_feather = {400,385,400,385,400,370,370,}; 
	private int nPoints_feather = 7; 

	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;		
		// Setzt Antialiasing für glattere Kanten
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		
		//PfeilSpitze
		g2d.setColor(new Color(221,219,219));
		g2d.fillPolygon(xPoints_arrowhead, yPoints_arrowhead, nPoints_arrowhead);
		g2d.setColor(Color.GRAY);
		g2d.drawPolygon(xPoints_arrowhead, yPoints_arrowhead, nPoints_arrowhead);
		
		
		//Wurfköper Griff
		g2d.setColor(Color.BLACK);
		g2d.fillPolygon(xPoints_body, yPoints_body, nPoints_body);
		g2d.drawPolygon(xPoints_body, yPoints_body, nPoints_body);
		
		//Wurfkörper Vorne an der Spitze
		g2d.setColor(Color.RED); // Farbe in Spieler Farbe Ändern.
		g2d.fillRect(718,285,4,30);
		g2d.drawRect(718,285,4,30);
	
		//Federn
		g2d.setColor(Color.BLACK);
		g2d.fillPolygon(xPoints_feather, yPoints_feather, nPoints_feather);
		g2d.drawPolygon(xPoints_feather, yPoints_feather, nPoints_feather);
	
		
	}
}
