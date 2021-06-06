package models.common;

import java.util.HashMap;

/**
 * Function
 * <p>
 * Declare function coefficients by a hash map 
 * of each coefficient order as key and coefficient value as value
 * 
 * @author  quanghuy6698
 * @version 2.1
 * @since   2018-09-11
 */
public class Function {
	private int degree;
	private HashMap<Integer, Double> coefficients;
	
	public Function() {
		this.coefficients = new HashMap<>();
	}
	
	public Function(int degree, HashMap<Integer, Double> coefficients) {
		this.degree = degree;
		this.coefficients = coefficients;
	}

	public HashMap<Integer, Double> getCoefficients() {
		return coefficients;
	}

	public void setCoefficients(HashMap<Integer, Double> coefficients) {
		this.coefficients = coefficients;
	}
	
	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	/**
	 * Set a coefficient value by it order with input as an array of coefficients
	 * 
	 * @param coefficients refer to coefficients sort by order of each coefficient descending
	 */
	public void setCoefficients(double[] coefficients) {
		int coefficientsSize = coefficients.length;
		for(int i = coefficientsSize - 1; i >= 0; i--) {
			this.coefficients.put(i, coefficients[i]);
		}
	}
	
	/**
	 * Set a coefficient value by it order
	 * If the coefficient order existed, replace old coefficient value by specified value
	 * If the coefficient order not existed, add new coefficient by specified order and value
	 * 
	 * @param coefficientOrder refer to order of coefficient
	 * @param coefficientValue refer to value of coefficient
	 */
	public void setCoefficientByOrder(int coefficientOrder, double coefficientValue) {
		this.coefficients.put(coefficientOrder, coefficientValue);
	}
	
	/**
	 * Get a coefficient value by it order
	 * 
	 * @param coefficientOrder refer to order of coefficient
	 * @param coefficientValue refer to value of coefficient
	 * 
	 * @return coefficient value
	 */
	public double getCoefficientByOrder(int coefficientOrder, double coefficientValue) {
		return this.coefficients.get(coefficientOrder);
	}
	
	/**
	 * Format function to formula string
	 * 
	 * @return function formula string
	 */
	public String toFormulaString() {
		String functionFormula = "F(X) = ";
		int degreeIndex = degree;
		// Append biggest degree coefficient
		functionFormula += coefficients.get(degreeIndex) + "x^" + degreeIndex;
		/*
		 * Append middle coefficients. 
		 * Middle coefficients is all coefficients 
		 * has degree smaller than function degree 
		 * and bigger than freedom coefficient.
		 * 
		 * Check each coefficient, if it other than 0 then append. 
		 * Append "+" before if it is positive, 
		 * else append "-" before if it is negative.
		 */
		for(int i = degreeIndex - 1; i > 0; i--) {
			if(coefficients.get(degreeIndex) != 0) {
				if(coefficients.get(degreeIndex) > 0) {
					functionFormula += " + " + coefficients.get(degreeIndex) + "x^" + degreeIndex;
				} else {
					functionFormula += " - " + coefficients.get(degreeIndex)*(-1) + "x^" + degreeIndex;
				}
			}
		}
		// Append freedom coefficient
		if(coefficients.get(0) > 0) {
			functionFormula += " + " + coefficients.get(0) + "x^" + degreeIndex;
		} else {
			functionFormula += " - " + coefficients.get(0)*(-1) + "x^" + degreeIndex;
		}
		
		return functionFormula;
	}
}
