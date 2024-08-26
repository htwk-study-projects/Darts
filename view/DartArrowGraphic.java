package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

public class DartArrowGraphic extends JPanel implements MouseMotionListener, MouseListener {
	
	private int mouseX;
    private int mouseY;
	
	private int centerX;
	private int baseY;
	
	private boolean shouldDraw = false; // Zustandsvariable
	
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
		this.addMouseMotionListener(this);
		this.addMouseListener(this); // MouseListener hinzufügen
		updatePoints();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (shouldDraw) { // Nur zeichnen, wenn shouldDraw true ist
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
		
		if (mouseX == 0 && mouseY == 0) {
			this.centerX = width / 2;
			this.baseY = height / 2;
		}
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
		// Pfeilposition bei Dragging aktualisieren und neu zeichnen
		mouseX = e.getX();
        mouseY = e.getY();
        shouldDraw = true; // Sicherstellen, dass gezeichnet wird
        repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Nicht verwendet
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Bei Mausklick Pfeil zeichnen und in die Mitte setzen
		shouldDraw = true;
		mouseX = getWidth() / 2;
		mouseY = getHeight() / 2;
		repaint();
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
		// Nicht verwendet
	}
}
