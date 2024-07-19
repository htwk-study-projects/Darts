package view;

import java.awt.Color;
import javax.swing.JFrame;

import model.DartsData;

public class DartsGUI extends JFrame {
	
	private DartsData data;
	
	
	public DartsGUI(DartsData d){
		this.data = d;
		
		this.setTitle("DARTS");
		this.setBounds(EXIT_ON_CLOSE, ABORT, 400, 320);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
	}

}
