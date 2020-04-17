package pkgMain;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ImgController2 {

	private final boolean DEBUG = true;
	MyMovingImageView2 view;
	MyMovingImageModel2 model;
	boolean copied = true;
	
	ImgController2(MyMovingImageView2 view){
		this.view = view;
		model = new MyMovingImageModel2();
		if (DEBUG) System.out.println("ic created");
	}
	
	public void drag(MouseEvent event) {
		System.out.println("here2");
//		Node n = (Node)event.getSource();
//		if (DEBUG) System.out.println("ic mouse drag tx: " + n.getTranslateX() + ", ex: " + event.getX() );
		if (DEBUG) System.out.println("ic mouse drag tx: " + model.getMouseXSinceDrag() + ", ex: " + event.getX() );
//		model.setMouseYSinceDrag(model.getMouseYSinceDrag() + event.getY());
		if (event.getX() > 100 && !copied) {
			int index = view.addIVToFlow();
			model.addX(0);
			model.addY(event.getY());
			view.setXs(index, 0);
			view.setYs(index, event.getY());
			copied = true;
		}
		//n.setTranslateX(n.getTranslateX() + event.getX()); //not MVC! what problem does this create?
		//n.setTranslateY(n.getTranslateY() + event.getY());
	}
	
	public void dragFlow(int i, MouseEvent event) {
		System.out.println("here3");
//		Node n = (Node)event.getSource();
		if (DEBUG) System.out.println("ic mouse drag tx: " + model.getXs(i) + ", ex: " + event.getX() );
		model.setXs(i, model.getXs(i) + event.getX()); //event.getX() is the amount of horiz drag
		model.setYs(i, model.getYs(i) + event.getY());
		view.setXs(i, model.getXs(i) );
		view.setYs(i, model.getYs(i) );
		//n.setTranslateX(n.getTranslateX() + event.getX()); //not MVC! what problem does this create?
		//n.setTranslateY(n.getTranslateY() + event.getY());
	}
	
	public void press(MouseEvent event) {
		System.out.println("here");
		copied = false;
	}
	
	public void dragReleased(MouseEvent event) {
		System.out.println("released");
		copied = true;
		model.setMouseXSinceDrag(0);
	}

	public EventHandler getHandlerForDrag() {
		return event -> drag((MouseEvent) event);
	}
	
	public EventHandler getHandlerForDragReleased() {
		return event -> dragReleased((MouseEvent) event);
	}
	
	public EventHandler getHandlerForDrag(int i) {
		return event -> dragFlow(i, (MouseEvent) event);
	}
	
	public EventHandler getHandlerForPress() {
		return event -> press((MouseEvent) event);
	}
	
//	public EventHandler getHandlerForDragOver() {
//		return event -> dragOver((MouseEvent) event);
//	}
	
//	public EventHandler getHandlerForTileDrag() {
//		return event -> copy((MouseEvent) event);
//	}

/*	public void tellModelStartingCoords(double x, double y) {
		model.setX(view.getImgStartingX());
		model.setY(view.getImgStartingY());
		if (DEBUG) System.out.println("start: " + model.getX() + " " + model.getY());
	}
*/
	public double getStartingX() {
		return model.getX();
	}
	public double getStartingY() {
		return model.getY();
	}
	
	
}
