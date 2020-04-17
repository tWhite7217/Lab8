package pkgMain;

import java.util.ArrayList;

public class MyMovingImageModel2 {

	private double x1 = 0;
	private double y1 = 0;
	private double mouseXSinceDrag = 0;
	private double mouseYSinceDrag = 0;
	private ArrayList<Double> xs = new ArrayList<Double>();
	private ArrayList<Double> ys = new ArrayList<Double>();
	private final double SIDE = 800;
	private final double BOTTOM = 600;
	private final double FLOW_SIDE = 700;
	private final double FLOW_BOTTOM = 600;
	private final double PIC_SIZE = 100;
	
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
		xs.set(index, Math.max(0, Math.min(x, FLOW_SIDE - PIC_SIZE)));
	}
	public double getYs(int index) {
		return ys.get(index);
	}
	public void setYs(int index, double y) {
		ys.set(index, Math.max(0, Math.min(y, FLOW_BOTTOM - PIC_SIZE)));
	}
	public double getMouseXSinceDrag() {
		return mouseXSinceDrag;
	}
	public double getMouseYSinceDrag() {
		return mouseYSinceDrag;
	}
	public void setMouseXSinceDrag(double x) {
		mouseXSinceDrag = x;
	}
	public void setMouseYSinceDrag(double y) {
		mouseXSinceDrag = y;
	}
	public void addX(double x) {
		xs.add(x);
	}
	public void addY(double y) {
		ys.add(y);
	}
}
