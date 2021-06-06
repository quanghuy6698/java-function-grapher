package utils;

import java.util.HashMap;

/**
 * Function common methods
 * 
 * @author  quanghuy6698
 * @version 2.1
 * @since   2018-09-11
 */
public class FunctionUtil {

	/**
	 * Check if coefficients is correct format of a function order
	 * Ex: Function order 2 must contains at least one order 2 coefficient and it must other than 0
	 * 
	 * @param functionOrder refer to order of the function
	 * @param coefficients refer to coefficients with type HashMap<Integer, Double>
	 * @return true if coefficients is correct format, else return false
	 */
	public static boolean isFunctionCoefficientsFormat(int functionOrder, HashMap<Integer, Double> coefficients) {
		if(coefficients.size() > functionOrder + 1) {
			return false;
		}
		if(coefficients.get(functionOrder) == 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * Check if coefficients is correct format of a function order.
	 * Ex: Function order 2 must contains at least one order 2 coefficient and it must other than 0
	 * 
	 * @param functionOrder refer to order of the function
	 * @param coefficients refer to coefficients with type array of double
	 * @return true if coefficients is correct format, else return false
	 */
	public static boolean isFunctionCoefficientsFormat(int functionOrder, double[] coefficients) {
		if(coefficients.length > functionOrder + 1) {
			return false;
		}
		if(coefficients[0] == 0) {
			return false;
		}
		return true;
	}
}
