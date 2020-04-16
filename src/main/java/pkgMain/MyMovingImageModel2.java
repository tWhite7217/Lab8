package pkgMain;

import java.util.ArrayList;

public class MyMovingImageModel2 {

	private double x1 = 0;
	private double y1 = 0;
	private ArrayList<Double> xs = new ArrayList<Double>();
	private ArrayList<Double> ys = new ArrayList<Double>();
	private final double SIDE = 800;
	private final double BOTTOM = 600;
	
	public double getX() {
		return x1;
	}
	public void setX(double x) {
		this.x1 = Math.min(x, SIDE);
	}
	public double getY() {
		return y1;
	}
	public void setY(double y) {
		this.y1 = Math.min(y, BOTTOM);
	}
	public double getXs(int index) {
		return xs.get(index);
	}
	public void setXs(int index, double x) {
		xs.set(index, Math.min(x, BOTTOM));
	}
	public double getYs(int index) {
		return ys.get(index);
	}
	public void setYs(int index, double y) {
		ys.set(index, Math.min(y, BOTTOM));
	}
	public void addX() {
		xs.add(0.0);
	}
	public void addY() {
		ys.add(0.0);
	}
}
