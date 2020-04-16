package pkgMain;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ImgController2 {

	private final boolean DEBUG = true;
	MyMovingImageView2 view;
	MyMovingImageModel2 model;
	boolean copied = false;
	
	ImgController2(MyMovingImageView2 view){
		this.view = view;
		model = new MyMovingImageModel2();
		if (DEBUG) System.out.println("ic created");
	}
	
	public void drag(MouseEvent event) {
		System.out.println("here2");
		Node n = (Node)event.getSource();
//		if (DEBUG) System.out.println("ic mouse drag tx: " + n.getTranslateX() + ", ex: " + event.getX() );
		model.setX(model.getX() + event.getX()); //event.getX() is the amount of horiz drag
		model.setY(model.getY() + event.getY());
		view.setX( model.getX() );
		view.setY( model.getY() );
		if (n.getTranslateX() > 100 && !copied) {
			view.addIVToFlow();
			model.addX();
			model.addY();
			copied = true;
		}
		//n.setTranslateX(n.getTranslateX() + event.getX()); //not MVC! what problem does this create?
		//n.setTranslateY(n.getTranslateY() + event.getY());
	}
	
	public void dragFlow(int i, MouseEvent event) {
		System.out.println("here3");
		Node n = (Node)event.getSource();
//		if (DEBUG) System.out.println("ic mouse drag tx: " + n.getTranslateX() + ", ex: " + event.getX() );
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

	public EventHandler getHandlerForDrag() {
		return event -> drag((MouseEvent) event);
	}
	
	public EventHandler getHandlerForDrag(int i) {
		return event -> dragFlow(i, (MouseEvent) event);
	}
	
	public EventHandler getHandlerForPress() {
		return event -> press((MouseEvent) event);
	}
	
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
