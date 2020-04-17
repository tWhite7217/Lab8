package pkgMain;

import java.util.ArrayList;

public class MyMovingImageModel2 {

	private ArrayList<Double> xs = new ArrayList<Double>();
	private ArrayList<Double> ys = new ArrayList<Double>();
	private final double SIDE = 800;
	private final double BOTTOM = 600;
	
	public double getXs(int index) {
		return xs.get(index);
	}
	public void setXs(int index, double x) {
		xs.set(index, Math.min(x, SIDE));
	}
	public double getYs(int index) {
		return ys.get(index);
	}
	public void setYs(int index, double y) {
		ys.set(index, Math.min(y, BOTTOM));
	}
	public void addX(double x) {
		xs.add(x);
	}
	public void addY(double y) {
		ys.add(y);
	}
}
