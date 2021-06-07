package main.models;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import main.constants.CoordinateConstants;

/**
 * Coordinate grid
 * <p>
 * @abbreviated CW reference to coordinate width
 * @abbreviated CH reference to coordinate height
 * 
 * @author  quanghuy6698
 * @version 2.1
 * @since   2018-09-11
 */
public class CoordinateGrid extends Canvas {
    private static final long serialVersionUID = 1L;
    private int coordinateWidth;
    private int coordinateHeight;
    private double unit;
	
	public CoordinateGrid(int coordinateWidth, int coordinateHeight, double unit) {
		this.coordinateWidth = coordinateWidth;
		this.coordinateHeight = coordinateHeight;
		this.unit = unit;
		setBackground(CoordinateConstants.BACKGROUND_COLOR);
		setSize(coordinateWidth, coordinateHeight);
	}

	public int getCoordinateWidth() {
		return coordinateWidth;
	}

	public void setCoordinateWidth(int coordinateWidth) {
		this.coordinateWidth = coordinateWidth;
	}

	public int getCoordinateHeight() {
		return coordinateHeight;
	}

	public void setCoordinateHeight(int coordinateHeight) {
		this.coordinateHeight = coordinateHeight;
	}

	public double getUnit() {
		return unit;
	}

	public void setUnit(double unit) {
		this.unit = unit;
	}
    
	@Override
	public void paint(Graphics g) {
		
	}
	
	/**
	 * Draw Ox and Oy axis
	 * Ox start point is (0, CH/2) and end point is (CW, CH/2)
	 * Oy start point is (CW/2, 0) and end point is (CW/2, CH)
	 * @see CoordinateGrid abbreviated
	 * 
	 * @param graphic refer to canvas graphic pass
	 */
    private void drawOxy(Graphics graphic){
    	graphic.setColor(CoordinateConstants.OXY_AXIS_COLOR);
    	graphic.drawLine(0, coordinateHeight/2, coordinateWidth, coordinateHeight/2);
    	graphic.drawLine(coordinateWidth/2, 0, coordinateWidth/2, coordinateHeight);
    }
    
	/**
	 * Draw Ox and Oy units mark
	 * 
	 * @param graphic refer to canvas graphic pass
	 */
    private void drawOxyUnitsMark(Graphics graphic) {
    	graphic.setColor(CoordinateConstants.UNIT_MARK_COLOR);
    	
    }
    
	/**
	 * Draw Ox and Oy units number
	 * 
	 * @param graphic refer to canvas graphic pass
	 */
    private void drawOxyUnitsNumber(Graphics graphic) {
    	graphic.setColor(CoordinateConstants.UNIT_NUMBER_COLOR);
    	
    }
}
