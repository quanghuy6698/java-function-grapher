package utils;

import java.util.HashMap;

import models.FunctionDegree2;
import models.common.Point;

/**
 * Function degree 2 common methods
 * <p>
 * Function formula: ax^2 + bx + c
 * 
 * @author  quanghuy6698
 * @version 2.1
 * @since   2018-09-11
 */
public class FunctionDegree2Util {
	
	/**
	 * Calculate delta of function degree 2
	 * Function formula: ax^2 + bx + c
	 * Delta = b^2 - 4ac
	 * 
	 * @param functionDegree2 refer to FunctionDegree2 object
	 * @see models.FunctionDegree2
	 * @return delta
	 */
	public static double delta(FunctionDegree2 functionDegree2) {
		HashMap<Integer, Double> coefficients = functionDegree2.getCoefficients();
		double a = coefficients.get(2);
		double b = coefficients.get(1);
		double c = coefficients.get(0);
		double delta = b*b - 4*a*c;
		return delta;
	}
	
	/**
	 * Calculate vertex of function degree 2
	 * Function formula: ax^2 + bx + c
	 * Vertex point is I(-b/2a, -delta/4a)
	 * @see FunctionDegree2Util#delta(FunctionDegree2)
	 * 
	 * @param functionDegree2 refer to FunctionDegree2 object
	 * @see models.FunctionDegree2
	 * @return vertex
	 */
	public static Point vertex(FunctionDegree2 functionDegree2) {
		HashMap<Integer, Double> coefficients = functionDegree2.getCoefficients();
		double a = coefficients.get(2);
		double b = coefficients.get(1);
		double c = coefficients.get(0);
		double delta = b*b - 4*a*c;
		double vertexX = -b/2*a;
		double vertexY = -delta/4*a;
		return new Point(vertexX, vertexY);
	}
}
