package models;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;
import models.common.Function;
import utils.FunctionGrapherUtil;

/**
 * Coordinate grid for draw function graph
 * <p>
 * Coordinate grid to draw function graph
 * and export graph to image
 * 
 * @author  quanghuy6698
 * @version 2.1
 * @since   2018-09-11
 */
public class FunctionGrapherCoordinateGrid extends Canvas {
    private static final long serialVersionUID = 1L;
    
    private Function function;
    
    /**
     * Attributes:
     * coeff3: Coefficient order 3
     * coeff2: Coefficient order 2
     * coeff1: Coefficient order 1
     * coeff0: Coefficient order 0
     * rangeLeft: left limit of graph display
     * rangeRight: right limit of graph display
     */
    private double coeff3;
    private double coeff2;
    private double coeff1;
    private double coeff0;
    private double rangeLeft;
    private double rangeRight;

    /**
     * Init:
     * set background color
     * set display size
     */
    public FunctionGrapherCoordinateGrid() {
        setBackground(FunctionGrapherUtil.BACKGROUND_COLOR);
        setSize(FunctionGrapherUtil.APP_WIDTH, FunctionGrapherUtil.APP_HEIGHT);
    }

    /**
     * draw Ox and Oy axis
     * draw units axis
     * draw function formula
     * draw function graph
     */
    @Override
    public void paint(Graphics graphic) {
        drawOxy(graphic);
        drawUnitsAxis(graphic);
        drawFunctionGraph(graphic);
        drawFunctionFormula(graphic);
    }

    /**
     * @Override
     * draw Ox and Oy axis
     */
    private void drawOxy(Graphics graphic) {
    	graphic.setColor(Color.lightGray);

        for (int i = 25; i < 500; i += 25) {
        	graphic.drawLine(0, i, 500, i);
        }

        for (int i = 25; i < 500; i += 25) {
        	graphic.drawLine(i, 0, i, 500);
        }

        graphic.setColor(Color.black);
        graphic.drawLine(0, 250, 500, 250);
        graphic.drawLine(250, 0, 250, 500);
    }

    // Draw units
    private void drawUnitsAxis(Graphics graphic) {
        int k = 4;
        for (int i = 50; i < 500; i += 50) {
        	graphic.drawLine(247, i, 253, i);
            if (k != 0) {
            	graphic.drawString(Integer.toString(k), 255, i);
            }
            k--;
        }
        k = -4;
        for (int i = 50; i < 500; i += 50) {
        	graphic.drawLine(i, 247, i, 253);
            if (k != 0) {
            	graphic.drawString(Integer.toString(k), i, 245);
            }
            k++;
        }
    }

    private void drawFunctionGraph(Graphics graphic) {
    	graphic.setColor(Color.blue);
        Graphics2D graphic2D = (Graphics2D) graphic;
        for (double i = rangeLeft; i < rangeRight; i += 0.1) {
        	graphic2D.draw(new Line2D.Double(i, GPoint(i), i + 0.1, GPoint(i + 0.1)));
        }
    }

    private double GPoint(double x0) {
        x0 = (x0 - 250) / 50;
        double y0 = 250 - (coeff3 * x0 * x0 * x0 + coeff2 * x0 * x0 + coeff1 * x0 + coeff0) * 50;
        return y0;
    }

    private void drawFunctionFormula(Graphics graphic) {
    	graphic.setColor(Color.red);
    	graphic.setFont(new Font("Tahoma", Font.PLAIN, 17));
    	graphic.drawString(functionFormat(), 20, 20);
    }

    private String functionFormat() {
        DecimalFormat df = new DecimalFormat(".##");
        String functionString = "F(x)=";
        if (coeff3 == 1) {
            functionString += "x^3";
        } else if (coeff3 != 0) {
            functionString += df.format(coeff3) + "x^3";
        }

        if (coeff2 == 1) {
            functionString += "x^2";
        } else if (coeff2 != 0) {
            if (coeff2 < 0) {
                functionString += df.format(coeff2) + "x^2";
            } else {
                functionString += "+" + df.format(coeff2) + "x^2";
            }
        }

        if (coeff1 == 1) {
            functionString += "x";
        } else if (coeff1 != 0) {
            if (coeff1 < 0) {
                functionString += df.format(coeff1) + "x";
            } else {
                functionString += "+" + df.format(coeff1) + "x";
            }
        }

        if (coeff0 != 0) {
            if (coeff0 < 0) {
                functionString += df.format(coeff0);
            } else {
                functionString += "+" + df.format(coeff0);
            }
        }

        return functionString;
    }
}
