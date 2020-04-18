package pkgMain;

import java.util.ArrayList;

public class MyMovingImageModel2 {

	private ArrayList<Double> xs = new ArrayList<Double>();
	private ArrayList<Double> ys = new ArrayList<Double>();
	private double FLOW_SIDE;
	private double FLOW_BOTTOM;
	private double PIC_SIZE;
	
	public MyMovingImageModel2(double w, double h, double tp, double pic) {
		FLOW_SIDE = w - tp;
		FLOW_BOTTOM = h;
		PIC_SIZE = pic;
	}
	
	public double getXs(int index) {
		return xs.get(index);
	}
	public void setXs(int index, double x) {
		xs.set(index, Math.max(0 - index*PIC_SIZE*2, Math.min(x, FLOW_SIDE - PIC_SIZE*(index*2+1))));
	}
	public double getYs(int index) {
		return ys.get(index);
	}
	public void setYs(int index, double y) {
		ys.set(index, Math.max(0, Math.min(y, FLOW_BOTTOM - PIC_SIZE)));
	}
	public void addX(double x) {
		xs.add(x);
	}
	public void addY(double y) {
		ys.add(y);
	}
}
