package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class DartArrowGraphic extends JPanel {
    
	public void paintComponent(Graphics g)
	{
		int width = getWidth();
		double height = getHeight();
		
		int centerX = width/2;
		int baseY = 0;
		
		double usableHeight = height*0.9;
		double percentageArrowHeadHeight = 0.23;
		double []percentageArrowHeadWidth = {0.498,0.502};
		
		double percentageHolderHeight = 0.20 + percentageArrowHeadHeight;
		double []percentageHolderWidth = {0.4985,0.5025};
		
		double percentageBodyHeight = 0.43 + percentageHolderHeight;
		double []percentageBodyWidth = {0.4998,0.502,0.49985,0.5015};
		
		double percentageFeather = 0.14;
		double percentageWidth = 0.05;
		
		
		
		int [] xPointsArrowhead = {(int) Math.round(width*percentageArrowHeadWidth[0]),centerX, (int) Math.round(width*percentageArrowHeadWidth[1])}; 
		int [] yPointsArrowhead = {(int) Math.round(usableHeight * percentageArrowHeadHeight),baseY,(int)Math.round(usableHeight * percentageArrowHeadHeight)};
		int nPointsArrowhead = 3; 
		
		int[] xPointsHolder = {(int)Math.round(width*percentageHolderWidth[0]),(int)Math.round(width*percentageHolderWidth[0]), (int)Math.round(width*percentageHolderWidth[1]),(int)Math.round(width*percentageHolderWidth[1])};
		int[] yPointsHolder = {(int)Math.round(usableHeight * percentageArrowHeadHeight),(int)Math.round(usableHeight * percentageHolderHeight),(int)Math.round(usableHeight * percentageHolderHeight),(int)Math.round(usableHeight * percentageArrowHeadHeight)};
		int nPointsHolder = 4;
		
		int [] xPointsBody = {(int)Math.round(width*percentageBodyWidth[0]),(int)Math.round(width*percentageBodyWidth[2]),(int)Math.round(width*percentageBodyWidth[3]),(int)Math.round(width*percentageBodyWidth[1])}; 
		int [] yPointsBody = {(int)Math.round(usableHeight * percentageHolderHeight),(int)Math.round(usableHeight * percentageBodyHeight),(int)Math.round(usableHeight * percentageBodyHeight),(int)Math.round(usableHeight * percentageHolderHeight)}; 
		int nPointsBody = 4; 

		int [] xPointsFeather = {}; 
		int [] yPointsFeather = {}; 
		int nPointsFeather = 7;
		
	
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;		
		// Setzt Antialiasing für glattere Kanten
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		
		//PfeilSpitze
		g2d.setColor(new Color(221,219,219));
		g2d.fillPolygon(xPointsArrowhead, yPointsArrowhead, nPointsArrowhead);
		g2d.setColor(Color.GRAY);
		g2d.drawPolygon(xPointsArrowhead, yPointsArrowhead, nPointsArrowhead);
		
		//Holder
				g2d.setColor(Color.RED);
				g2d.fillPolygon(xPointsHolder, yPointsHolder, nPointsHolder);
				g2d.drawPolygon(xPointsHolder, yPointsHolder, nPointsHolder);
				
		//Wurfköper Griff
		g2d.setColor(Color.BLACK);
		g2d.fillPolygon(xPointsBody, yPointsBody, nPointsBody);
		g2d.drawPolygon(xPointsBody, yPointsBody, nPointsBody);
/*
		//Federn
		g2d.setColor(Color.BLACK);
		g2d.fillPolygon(xPointsFeather, yPointsFeather, nPointsFeather);
		g2d.drawPolygon(xPointsFeather, yPointsFeather, nPointsFeather);
	*/
		
	}
	
	private ArrayList<Double> adjustFactor(int[] factor, double multiplier, ArrayList<Double> adjustFactor) {
	    for (int i = 0; i < factor.length; i++) {
	        double element = factor[i] * multiplier;
	        adjustFactor.add(element);
	    }
	    
	    return  adjustFactor;
	}

}
