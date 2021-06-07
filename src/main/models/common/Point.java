package main.models.common;

/**
 * Point
 * <p>
 * Declare a point by its coordinates
 * 
 * @author  quanghuy6698
 * @version 2.1
 * @since   2018-09-11
 */
public class Point {
	private double x;
	private double y;
	
	public Point() {
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
