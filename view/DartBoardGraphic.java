package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DartBoardGraphic extends JPanel {

    private final static int[] DIAMETERS = {760, 750, 640, 600, 390, 350, 50, 20};
    private final static double ANGLELINES = 2 * Math.PI / 20;
    private final static String[] NUMBERS = {"20", "1", "18", "4", "13", "6", "10", "15", "2", "17", "3", "19", "7", "16", "8", "11", "14", "9", "12", "5"};
    private final static double BOARDSIZE_PANELSIZE_RELATION = 3.2/4.0;
    private final static float STROKE_WIDTH = 2.6f;
    
    private int visibility = 255;
    private Color BLACK;
    private Color GREY; 
    private Color WHITE;
    private Color GREEN;
    private Color RED;
    
    private Font dartBoardNumbersFont;
    private int panelWidth;
    private int panelHeight;
    private int CenterX;
    private int CenterY;
    private int adjustedMAXBoardDiameter;
    private int[] adjustedBoardDiameters;
    private int fontSize;
    
    public DartBoardGraphic(double visibilityMultiplier) {
    	this.visibility *= visibilityMultiplier;
    	this.setColors();
    }
    
    private void setColors() {
    	this.BLACK = new Color(10, 10, 10, visibility);
        this.GREY = new Color(77, 77, 77, visibility);
        this.WHITE = new Color(230, 230, 230, visibility);
        this.GREEN = new Color(39, 200, 89, visibility);
        this.RED = new Color(228, 30, 37, visibility);
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D dartBoardTwoD = (Graphics2D) g;

        widthHeightInit();
        adjustedMAXBoardDiameter = (int) (Math.min(panelWidth, panelHeight) * (BOARDSIZE_PANELSIZE_RELATION)); // Board-Durchmesser relativ zur Panelgröße // bestimmt boarddurchmesser, anhand ob x oder y-wert kleiner ist, da sonst das board mit Rand überlappen würde 
        adjustedBoardDiameters = diameterScaling();
        
        dartBoardNumbersFont = textScaling();
        dartBoardTwoD.setFont(dartBoardNumbersFont);

        drawBackgroundAreas(dartBoardTwoD);
        drawSectorColors(dartBoardTwoD);
        drawBoundaryLinesAndLabels(dartBoardTwoD);
        drawBullseye(dartBoardTwoD);
        drawBoundaryCircles(dartBoardTwoD);
        drawDartHit(dartBoardTwoD,0,170);
        
    }
    
    private void widthHeightInit() {
    	panelWidth = this.getWidth();
        panelHeight = this.getHeight();
        CenterX = panelWidth / 2;
        CenterY = panelHeight / 2;
    }
    
    private int[] diameterScaling() {
    	int[] scaledDiameters = new int[DIAMETERS.length];
    	double basisDiameter = (double) DIAMETERS[0];
        for (int i = 0; i < DIAMETERS.length; i++) {
            scaledDiameters[i] = (int) (DIAMETERS[i] * (adjustedMAXBoardDiameter / basisDiameter));
        }
        return scaledDiameters;
    }
    
    private Font textScaling() {
    	fontSize = Math.max(10, adjustedMAXBoardDiameter / 20); 
    	return dartBoardNumbersFont = new Font("Impact", Font.BOLD, fontSize);
    }
    
    private void drawBackgroundAreas(Graphics2D targetPlace) {
    	targetPlace.setColor(GREY);
    	targetPlace.fillOval(CenterX - adjustedBoardDiameters[0] / 2, CenterY - adjustedBoardDiameters[0] / 2, adjustedBoardDiameters[0], adjustedBoardDiameters[0]);
    	targetPlace.setColor(BLACK);
    	targetPlace.fillOval(CenterX - adjustedBoardDiameters[1] / 2, CenterY - adjustedBoardDiameters[1] / 2, adjustedBoardDiameters[1], adjustedBoardDiameters[1]);
        targetPlace.setColor(WHITE);
        targetPlace.fillOval(CenterX - adjustedBoardDiameters[3] / 2, CenterY - adjustedBoardDiameters[3] / 2, adjustedBoardDiameters[3], adjustedBoardDiameters[3]);
    }
    
    private void drawSectorColors(Graphics2D targetPlace) {
    	for (int i = 0; i < 20; i++) {
    		double angle = (1.5 + i) * ANGLELINES;
    		targetPlace.setColor(i % 2 == 0 ? GREEN : RED);
    		targetPlace.fillArc(CenterX - adjustedBoardDiameters[2] / 2, CenterY - adjustedBoardDiameters[2] / 2, adjustedBoardDiameters[2], adjustedBoardDiameters[2], (int) Math.toDegrees(angle), (int) Math.toDegrees(ANGLELINES));
    		targetPlace.setColor(i % 2 == 0 ? BLACK : WHITE);
    		targetPlace.fillArc(CenterX - adjustedBoardDiameters[3] / 2, CenterY - adjustedBoardDiameters[3] / 2, adjustedBoardDiameters[3], adjustedBoardDiameters[3], (int) Math.toDegrees(angle), (int) Math.toDegrees(ANGLELINES));
    		targetPlace.setColor(i % 2 == 0 ? GREEN : RED);
    		targetPlace.fillArc(CenterX - adjustedBoardDiameters[4] / 2, CenterY - adjustedBoardDiameters[4] / 2, adjustedBoardDiameters[4], adjustedBoardDiameters[4], (int) Math.toDegrees(angle), (int) Math.toDegrees(ANGLELINES));
    		targetPlace.setColor(i % 2 == 0 ? BLACK : WHITE);
    		targetPlace.fillArc(CenterX - adjustedBoardDiameters[5] / 2, CenterY - adjustedBoardDiameters[5] / 2, adjustedBoardDiameters[5], adjustedBoardDiameters[5], (int) Math.toDegrees(angle), (int) Math.toDegrees(ANGLELINES));
    	}
    }
    
    private void drawBullseye(Graphics2D targetPlace) {
    	targetPlace.setColor(GREEN);
    	targetPlace.fillOval(CenterX - adjustedBoardDiameters[6] / 2, CenterY - adjustedBoardDiameters[6] / 2, adjustedBoardDiameters[6], adjustedBoardDiameters[6]);
    	targetPlace.setColor(RED);
    	targetPlace.fillOval(CenterX - adjustedBoardDiameters[7] / 2, CenterY - adjustedBoardDiameters[7] / 2, adjustedBoardDiameters[7], adjustedBoardDiameters[7]);

    }
    
    private void drawBoundaryLinesAndLabels(Graphics2D targetPlace) {
    	for (int i = 0; i < 20; i++) {
    		targetPlace.setStroke(new BasicStroke(STROKE_WIDTH));
    		double angle = (1.5 + i) * ANGLELINES;
    		int x_inner_circle = CenterX + (int) (Math.cos(angle) * adjustedBoardDiameters[6] / 2); 
    		int y_inner_circle = CenterY + (int) (Math.sin(angle) * adjustedBoardDiameters[6] / 2);
    		int x_line = CenterX + (int) (Math.cos(angle) * adjustedBoardDiameters[2] / 2);
    		int y_line = CenterY + (int) (Math.sin(angle) * adjustedBoardDiameters[2] / 2);

    		targetPlace.setColor(WHITE);
    		targetPlace.drawLine(x_inner_circle, y_inner_circle, x_line, y_line);

    		double angle_number = i * ANGLELINES - Math.PI / 2;
    		int x_number = CenterX + (int) (Math.cos(angle_number) * adjustedBoardDiameters[5]);
    		int y_number = CenterY + (int) (Math.sin(angle_number) * adjustedBoardDiameters[5]);
    		
    		int textWidth = targetPlace.getFontMetrics().stringWidth(NUMBERS[i]);
    		int textHeight = targetPlace.getFontMetrics().getHeight();

    		targetPlace.drawString(NUMBERS[i], x_number - textWidth / 2, y_number + textHeight / 3); 
    	}
    }
    
    private void drawBoundaryCircles(Graphics2D targetPlace) {
    	targetPlace.setColor(WHITE);
        for (int diameter : adjustedBoardDiameters) {
        	targetPlace.drawOval(CenterX - diameter / 2, CenterY - diameter / 2, diameter, diameter);
        }
    }
    
    private void drawDartHit(Graphics2D targetPlace, double xDart, double yDart) {
    	
    	double middlePointX = CenterX;
    	double middlePointY = CenterY;
    	double scalingFactor = 300/170;
    	double scalingX = middlePointX + (xDart * scalingFactor);
        double scalingY = middlePointY - (yDart* scalingFactor);
    	int sizeHit = 5;
    	System.out.println(scalingX + " " + scalingY);
    	
    	targetPlace.setColor(GREY);
    	targetPlace.drawLine((int) Math.round(scalingX - sizeHit),(int) Math.round(scalingY - sizeHit),(int) Math.round(scalingX + sizeHit), (int) Math.round(scalingY + sizeHit));
    	targetPlace.drawLine((int) Math.round(scalingX - sizeHit),(int) Math.round(scalingY + sizeHit),(int) Math.round(scalingX + sizeHit), (int) Math.round(scalingY - sizeHit));
    	
    }
}
