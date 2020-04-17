package pkgMain;

import java.util.ArrayList;

public class MyMovingImageModel2 {

	private ArrayList<Double> xs = new ArrayList<Double>();
	private ArrayList<Double> ys = new ArrayList<Double>();
	private final double FLOW_SIDE = 700;
	private final double FLOW_BOTTOM = 600;
	private final double PIC_SIZE = 100;
	
	public double getXs(int index) {
		return xs.get(index);
	}
	public void setXs(int index, double x) {
		xs.set(index, Math.max(0, Math.min(x, FLOW_SIDE - PIC_SIZE)));
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
