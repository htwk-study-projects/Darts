package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


public class DartArrowGraphic extends JPanel implements MouseMotionListener {
	
	private int mouseX;
    private int mouseY;
	
	private int centerX;
	private int baseY;
	
	private final double percentageArrowHeadHeight = 0.23;
	private final double []percentageArrowHeadWidth = {0.498,0.502};
	
	private final double percentageHolderHeight = 0.20 + percentageArrowHeadHeight;
	private final double []percentageHolderWidth = {0.4975,0.5025};
	
	private final double percentageBodyHeight = 0.43 + percentageHolderHeight;
	private final double []percentageBodyWidth = {0.4978,0.502,0.49985,0.5015};
	
	private final double percentageFeatherHeight = 0.12 + percentageBodyHeight;
	private final double percentageFeatherWidth = 0.008;
	
	private double usableHeight;
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
		updatePoints();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		updatePoints();
		Graphics2D dartArrow2D = (Graphics2D) g;		
        dartArrow2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		//PfeilSpitze
		dartArrow2D.setColor(Color.GRAY);;
		dartArrow2D.fillPolygon(xPointsArrowhead, yPointsArrowhead, nPointsArrowhead);
		dartArrow2D.setColor(Color.LIGHT_GRAY);
		dartArrow2D.drawPolygon(xPointsArrowhead, yPointsArrowhead, nPointsArrowhead);
		
		//Holder
		dartArrow2D.setColor(Color.RED);
		dartArrow2D.fillPolygon(xPointsHolder, yPointsHolder, nPointsHolder);
		dartArrow2D.drawPolygon(xPointsHolder, yPointsHolder, nPointsHolder);
				
		//Wurfköper Griff
		dartArrow2D.setColor(Color.BLACK);
		dartArrow2D.fillPolygon(xPointsBody, yPointsBody, nPointsBody);
		dartArrow2D.drawPolygon(xPointsBody, yPointsBody, nPointsBody);

		//Federn
		dartArrow2D.setColor(Color.BLACK);
		dartArrow2D.fillPolygon(xPointsFeather, yPointsFeather, nPointsFeather);
		dartArrow2D.drawPolygon(xPointsFeather, yPointsFeather, nPointsFeather);
		
	}
	
	private void updatePoints() {
		int width = getWidth();
		int height = getHeight();
		
		this.centerX = mouseX;
		this.baseY = mouseY;
		
		this.usableHeight = height * 0.2;
		
		xPointsArrowhead = new int[]{
				(int) Math.round(width * percentageArrowHeadWidth[0]), centerX, (int) Math.round(width * percentageArrowHeadWidth[1])
	    };
	    yPointsArrowhead = new int[]{
	            (int) Math.round(usableHeight * percentageArrowHeadHeight + baseY), baseY, (int) Math.round(usableHeight * percentageArrowHeadHeight + baseY)
	    };

	    xPointsHolder = new int[]{
	    		(int) Math.round(width * percentageHolderWidth[0]), (int) Math.round(width * percentageHolderWidth[0]),
	            (int) Math.round(width * percentageHolderWidth[1]), (int) Math.round(width * percentageHolderWidth[1])
	    };
	    yPointsHolder = new int[]{
	            (int) Math.round(usableHeight * percentageArrowHeadHeight + baseY),
	            (int) Math.round(usableHeight * percentageHolderHeight + baseY),
	            (int) Math.round(usableHeight * percentageHolderHeight + baseY),
	            (int) Math.round(usableHeight * percentageArrowHeadHeight + baseY)
	    };

	    xPointsBody = new int[]{
	            (int) Math.round(width * percentageBodyWidth[0]), (int) Math.round(width * percentageBodyWidth[2]),
	            (int) Math.round(width * percentageBodyWidth[3]), (int) Math.round(width * percentageBodyWidth[1])
	    };
	    yPointsBody = new int[]{
	            (int) Math.round(usableHeight * percentageHolderHeight + baseY),
	            (int) Math.round(usableHeight * percentageBodyHeight + baseY),
	            (int) Math.round(usableHeight * percentageBodyHeight + baseY),
	            (int) Math.round(usableHeight * percentageHolderHeight + baseY)
	    };

	    xPointsFeather = new int[]{
	            (int) Math.round(width * percentageBodyWidth[2]), (int) Math.round(width * percentageBodyWidth[2]),
	            (int) Math.round(width * (percentageBodyWidth[0] - percentageFeatherWidth)),
	            (int) Math.round(width * percentageBodyWidth[2]), 
	            (int) Math.round(width * percentageBodyWidth[3]), (int) Math.round(width * percentageBodyWidth[3]), 
	            (int) Math.round(width * (percentageBodyWidth[1] + percentageFeatherWidth)),
	            (int) Math.round(width * percentageBodyWidth[3])
	    };

	    yPointsFeather = new int[]{
	            (int) Math.round(usableHeight * percentageBodyHeight + baseY),
	            (int) Math.round(usableHeight * percentageFeatherHeight + baseY),
	            (int) Math.round(usableHeight * percentageFeatherHeight + baseY + baseY * percentageFeatherWidth * 2),
	            (int) Math.round(usableHeight * percentageBodyHeight + baseY),
	            (int) Math.round(usableHeight * percentageBodyHeight + baseY),
	            (int) Math.round(usableHeight * percentageFeatherHeight + baseY),
	            (int) Math.round(usableHeight * percentageFeatherHeight + baseY + baseY * percentageFeatherWidth * 2),
	            (int) Math.round(usableHeight * percentageBodyHeight + baseY)
	   };
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
        mouseY = e.getY();
        repaint(); 
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
