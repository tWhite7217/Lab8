package pkgMain;

import java.util.ArrayList;


/**
 * @author Terry Harvey
 * @author Matt Cohen
 * @author Josh Stone
 * @author Ian McCabe
 * @author Tommy White
 * @author Brandon Wu
 */
public class MyMovingImageModel2 {
	/*
	 * An arraylist that holds all the x values of the copied milkweed images 
	 */
	private ArrayList<Double> xs = new ArrayList<Double>();
	
	/**
	 * An arraylist that holds all the y values of the copied milkweed images 
	 */
	private ArrayList<Double> ys = new ArrayList<Double>();
	
	
	private double FLOW_SIDE;
	private double FLOW_BOTTOM;
	private double PIC_SIZE;
	
	/**
	 * Initializes the model for the project 
	 * @param w width of the view 
	 * @param h height of the view 
	 * @param tp tile pane width 
	 * @param pic picture dimensions 
	 */
	public MyMovingImageModel2(double w, double h, double tp, double pic) {
		FLOW_SIDE = w - tp;
		FLOW_BOTTOM = h;
		PIC_SIZE = pic;
	}
	
	/**
	 * Gets the x values for the milkweed images that are generated 
	 * @param index specifies which milkweed image the x value is being obtained for 
	 * @return int the x value of the specific milkweed image 
	 */
	public double getXs(int index) {
		return xs.get(index);
	}
	
	/**
	 * sets the x value for a specific milkweed image 
	 * @param index which milkweed image is being modified 
	 * @param x sets the x location for the milkweed image 
	 */
	public void setXs(int index, double x) {
		xs.set(index, Math.max(0 - index*PIC_SIZE*2, Math.min(x, FLOW_SIDE - PIC_SIZE*(index*2+1))));
	}
	
	/**
	 * gets the Y values for the milkweed images that are being modified 
	 * @param index which milkweed image the y value is being obtained for
	 * @return the y value of the milkweed image 
	 */
	public double getYs(int index) {
		return ys.get(index);
	}
	
	/**
	 * sets the y value for  the milkweed image at index index 
	 * @param index the milkweed image whose y value is being set 
	 * @param y the y value of the specific milkweed image 
	 */
	public void setYs(int index, double y) {
		ys.set(index, Math.max(0, Math.min(y, FLOW_BOTTOM - PIC_SIZE)));
	}
	
	/**
	 * Creates a new element for a new milkweed image in the xs ArrayList 
	 * @param x the initial x coordinate of the new milkweed image 
	 */
	public void addX(double x) {
		xs.add(x);
	}
	
	/**
	 * Creates a new element for a new milkweed image in the ys ArrayList
	 * @param y the initial y coordinate of the new milkweed image 
	 */
	public void addY(double y) {
		ys.add(y);
	}
}
