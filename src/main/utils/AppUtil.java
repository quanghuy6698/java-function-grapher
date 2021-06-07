package main.utils;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * App util
 * <p>
 * App configs
 * 
 * @author  quanghuy6698
 * @version 2.1
 * @since   2018-09-11
 */
public class AppUtil {

	/**
	 * Get device screen resolution
	 * 
	 * @return device screen resolution
	 */
    public Dimension getDeviceScreenResolution() {
    	Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
    	return screenResolution;
    }
}
