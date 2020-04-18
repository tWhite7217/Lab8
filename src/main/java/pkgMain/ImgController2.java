package pkgMain;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ImgController2 {

	private final boolean DEBUG = true;
	MyMovingImageView2 view;
	MyMovingImageModel2 model;
	boolean copied = true;
	
	ImgController2(MyMovingImageView2 view){
		this.view = view;
		model = new MyMovingImageModel2(view.getWidth(), view.getHeight(), view.getTPWidth(), view.getPicSize());
		if (DEBUG) System.out.println("ic created");
	}
	
	public void drag(MouseEvent event) {
		if (event.getX() > 100 && !copied) {
			int index = view.addIVToFlow();
			model.addX(0);
			model.addY(event.getY());
			view.setXs(index, 0 - view.getPicSize()*index);
			view.setYs(index, event.getY());
			copied = true;
		}
	}
	
	public void dragFlow(int i, MouseEvent event) {
		if (DEBUG) System.out.println("ic mouse drag tx: " + model.getXs(i) + ", ex: " + event.getX() );
		model.setXs(i, model.getXs(i) + event.getX());
		model.setYs(i, model.getYs(i) + event.getY());
		view.setXs(i, model.getXs(i) );
		view.setYs(i, model.getYs(i) );
	}
	
	public void press(MouseEvent event) {
		copied = false;
	}
	
	public void dragReleased(MouseEvent event) {
		copied = true;
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
	
}
