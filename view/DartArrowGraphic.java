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
	int[] xPointsArrowhead;
	int[] yPointsArrowhead;
	int nPointsArrowhead = 3; 
	
	int[] xPointsHolder;
	int[] yPointsHolder;
	int nPointsHolder = 4;
	
	int[] xPointsBody; 
	int[] yPointsBody;
	int nPointsBody = 4; 

	int[] xPointsFeather;
	int[] yPointsFeather;
	int nPointsFeather = 8;

	public DartArrowGraphic() {
		this.addMouseMotionListener(this);
		this.mouseX = getWidth() / 2;
        this.mouseY = getHeight() / 2;
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

        double usableHeight = height * 0.6; // Dieser Wert steuert die Länge des Pfeils

        // Die Basis des Pfeils wird als Punkt relativ zur Mausposition festgelegt
        int arrowBaseX = mouseX;
        int arrowBaseY = mouseY;

        // Spitze des Pfeils
        xPointsArrowhead = new int[]{
            arrowBaseX - (int) (usableHeight * percentageArrowHeadHeight / 2),
            arrowBaseX + (int) (usableHeight * percentageArrowHeadHeight / 2),
            arrowBaseX
        };
        yPointsArrowhead = new int[]{
            arrowBaseY,
            arrowBaseY,
            arrowBaseY - (int) (usableHeight * percentageArrowHeadHeight)
        };

        // Halter
        xPointsHolder = new int[]{
            arrowBaseX - (int) (usableHeight * percentageHolderWidth[0]),
            arrowBaseX - (int) (usableHeight * percentageHolderWidth[0]),
            arrowBaseX + (int) (usableHeight * percentageHolderWidth[1]),
            arrowBaseX + (int) (usableHeight * percentageHolderWidth[1])
        };
        yPointsHolder = new int[]{
            arrowBaseY,
            arrowBaseY + (int) (usableHeight * percentageHolderHeight),
            arrowBaseY + (int) (usableHeight * percentageHolderHeight),
            arrowBaseY
        };

        // Wurfkörper
        xPointsBody = new int[]{
            arrowBaseX - (int) (usableHeight * percentageBodyWidth[0]),
            arrowBaseX - (int) (usableHeight * percentageBodyWidth[2]),
            arrowBaseX + (int) (usableHeight * percentageBodyWidth[3]),
            arrowBaseX + (int) (usableHeight * percentageBodyWidth[1])
        };
        yPointsBody = new int[]{
            arrowBaseY + (int) (usableHeight * percentageHolderHeight),
            arrowBaseY + (int) (usableHeight * percentageBodyHeight),
            arrowBaseY + (int) (usableHeight * percentageBodyHeight),
            arrowBaseY + (int) (usableHeight * percentageHolderHeight)
        };

        // Federn
        xPointsFeather = new int[]{
            arrowBaseX - (int) (usableHeight * percentageBodyWidth[2]),
            arrowBaseX - (int) (usableHeight * percentageBodyWidth[2]),
            arrowBaseX - (int) (usableHeight * (percentageBodyWidth[2] + percentageFeatherWidth)),
            arrowBaseX - (int) (usableHeight * percentageBodyWidth[2]),
            arrowBaseX + (int) (usableHeight * percentageBodyWidth[3]),
            arrowBaseX + (int) (usableHeight * percentageBodyWidth[3]),
            arrowBaseX + (int) (usableHeight * (percentageBodyWidth[3] + percentageFeatherWidth)),
            arrowBaseX + (int) (usableHeight * percentageBodyWidth[3])
        };

        yPointsFeather = new int[]{
            arrowBaseY + (int) (usableHeight * percentageBodyHeight),
            arrowBaseY + (int) (usableHeight * percentageFeatherHeight),
            arrowBaseY + (int) (usableHeight * percentageFeatherHeight + arrowBaseY * percentageFeatherWidth * 2),
            arrowBaseY + (int) (usableHeight * percentageBodyHeight),
            arrowBaseY + (int) (usableHeight * percentageBodyHeight),
            arrowBaseY + (int) (usableHeight * percentageFeatherHeight),
            arrowBaseY + (int) (usableHeight * percentageFeatherHeight + arrowBaseY * percentageFeatherWidth * 2),
            arrowBaseY + (int) (usableHeight * percentageBodyHeight)
        };
    }

	
	/*public void setWidthAndHeight(int newWidth, int newHeight) {
		thismouse = newWidth;
		this.height = newHeight;
		this.revalidate();
        this.repaint();
	}*/

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
        mouseY = e.getY();
        repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	
		
	}

}
