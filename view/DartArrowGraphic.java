package view;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import java.awt.event.MouseListener;

public class DartArrowGraphic extends JPanel implements MouseMotionListener, MouseListener {
	
	private int mouseX;
    private int mouseY;
	
	private int centerX;
	private int baseY;
	
	private boolean shouldDraw;
	private boolean shouldPlace;
	private boolean shouldRead;
	
	private final double percentageArrowHeadHeight = 0.23;
	private final double []percentageArrowHeadWidth = {0.45,0.55};
	
	private final double percentageHolderHeight = 0.20 + percentageArrowHeadHeight;
	private final double []percentageHolderWidth = {0.45,0.55};
	
	private final double percentageBodyHeight = 0.43 + percentageHolderHeight;
	private final double []percentageBodyWidth = {0.45,0.55,0.185,0.215};
	
	private final double percentageFeatherHeight = 0.12 + percentageBodyHeight;
	private final double percentageFeatherWidth = 1;
	private final double secondpercentageFeatherHeight = 0.07+percentageFeatherHeight;
	
	private double usableHeight;
	private double usableWidth;
	int [] xPointsArrowhead;
	int [] yPointsArrowhead;
	int nPointsArrowhead = 3; 
	
	int[] xPointsHolder;
	int[] yPointsHolder;
	int nPointsHolder = 4;
	
	int [] xPointsBody; 
	int [] yPointsBody;
	int nPointsBody = 4; 

	int [] xPointsFeather;
	int [] yPointsFeather;
	int nPointsFeather = 8;

	public DartArrowGraphic() {
		shouldPlace = true;
		shouldDraw = false;
		shouldRead = false;
		this.addMouseListener(this); // MouseListener hinzufügen
		this.addMouseMotionListener(this);
		
		updatePoints();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(shouldDraw){
			updatePoints();
			Graphics2D dartArrow2D = (Graphics2D) g;		
	        dartArrow2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// Pfeilspitze
			dartArrow2D.setColor(Color.GRAY);
			dartArrow2D.fillPolygon(xPointsArrowhead, yPointsArrowhead, nPointsArrowhead);
			dartArrow2D.setColor(Color.GRAY);
			dartArrow2D.drawPolygon(xPointsArrowhead, yPointsArrowhead, nPointsArrowhead);
			
			// Holder
			dartArrow2D.setColor(new Color(0,135,60));
			dartArrow2D.fillPolygon(xPointsHolder, yPointsHolder, nPointsHolder);
			dartArrow2D.drawPolygon(xPointsHolder, yPointsHolder, nPointsHolder);
					
			// Wurfkörper Griff
			dartArrow2D.setColor(new Color(96,96,96));
			dartArrow2D.fillPolygon(xPointsBody, yPointsBody, nPointsBody);
			dartArrow2D.drawPolygon(xPointsBody, yPointsBody, nPointsBody);

			// Federn
			dartArrow2D.setColor(new Color(0,135,60));
			dartArrow2D.fillPolygon(xPointsFeather, yPointsFeather, nPointsFeather);
			dartArrow2D.drawPolygon(xPointsFeather, yPointsFeather, nPointsFeather);
		}
	}
	
	private void updatePoints() {
		int width = getWidth();
		int height = getHeight();
		
		this.centerX = mouseX;
		this.baseY = mouseY;
		
		this.usableHeight = height * 0.2;
		this.usableWidth = width * 0.0067;
		
		xPointsArrowhead = new int[]{
				(int) Math.round(centerX-usableWidth * percentageArrowHeadWidth[0]), centerX, (int) Math.round(centerX + usableWidth* percentageArrowHeadWidth[1])
	    };
	    yPointsArrowhead = new int[]{
	            (int) Math.round(baseY + usableHeight * percentageArrowHeadHeight), baseY, (int) Math.round(baseY + usableHeight * percentageArrowHeadHeight)
	    };

	    xPointsHolder = new int[]{
	    		(int) Math.round(centerX-usableWidth * percentageHolderWidth[0]), (int) Math.round(centerX-usableWidth * percentageHolderWidth[0]),
	            (int) Math.round(centerX+usableWidth * percentageHolderWidth[1]), (int) Math.round(centerX+usableWidth * percentageHolderWidth[1])
	    };
	    yPointsHolder = new int[]{
	            (int) Math.round(usableHeight * percentageArrowHeadHeight + baseY),
	            (int) Math.round(usableHeight * percentageHolderHeight + baseY),
	            (int) Math.round(usableHeight * percentageHolderHeight + baseY),
	            (int) Math.round(usableHeight * percentageArrowHeadHeight + baseY)
	    };

	    xPointsBody = new int[]{
	            (int) Math.round(centerX - usableWidth * percentageBodyWidth[0]), (int) Math.round(centerX - usableWidth * percentageBodyWidth[2]),
	            (int) Math.round(centerX + usableWidth * percentageBodyWidth[3]), (int) Math.round(centerX + usableWidth * percentageBodyWidth[1])
	    };
	    yPointsBody = new int[]{
	            (int) Math.round(usableHeight * percentageHolderHeight + baseY),
	            (int) Math.round(usableHeight * percentageBodyHeight + baseY),
	            (int) Math.round(usableHeight * percentageBodyHeight + baseY),
	            (int) Math.round(usableHeight * percentageHolderHeight + baseY)
	    };

	    xPointsFeather = new int[]{
	            (int) Math.round(centerX-usableWidth * percentageBodyWidth[2]), 
	            (int) Math.round(centerX-usableWidth * percentageBodyWidth[2]),
	            (int) Math.round(centerX-usableWidth * (percentageBodyWidth[0] + percentageFeatherWidth)),
	            (int) Math.round(centerX-usableWidth * percentageBodyWidth[2]), 
	            (int) Math.round(centerX+usableWidth * percentageBodyWidth[3]), 
	            (int) Math.round(centerX+usableWidth * percentageBodyWidth[3]), 
	            (int) Math.round(centerX+usableWidth * (percentageBodyWidth[1] + percentageFeatherWidth)),
	            (int) Math.round(centerX+usableWidth * percentageBodyWidth[3])
	    };

	    yPointsFeather = new int[]{
	            (int) Math.round(usableHeight * percentageBodyHeight + baseY),
	            (int) Math.round(usableHeight * percentageFeatherHeight + baseY),
	            (int) Math.round(usableHeight * secondpercentageFeatherHeight + baseY),
	            (int) Math.round(usableHeight * percentageBodyHeight + baseY),
	            (int) Math.round(usableHeight * percentageBodyHeight + baseY),
	            (int) Math.round(usableHeight * percentageFeatherHeight + baseY),
	            (int) Math.round(usableHeight * secondpercentageFeatherHeight + baseY),
	            (int) Math.round(usableHeight * percentageBodyHeight + baseY)
	   };
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(shouldDraw) {
			mouseX = e.getX();
	        mouseY = e.getY();
	        shouldDraw = true;
	        shouldPlace = false;
			shouldRead = true;
	        repaint();
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(shouldPlace){
			shouldDraw = true;
			shouldPlace = false;
			mouseX = getWidth() / 2;
			mouseY = getHeight() / 2;
			repaint();
		}
		if(shouldRead) {
			shouldDraw = false;
			shouldPlace = true;
			shouldRead = false;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Nicht verwendet
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Nicht verwendet
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Nicht verwendet
	}

	@Override
	public void mouseExited(MouseEvent e) {
		shouldPlace = true;
		shouldDraw = false;
		shouldRead = false;
	}
}
