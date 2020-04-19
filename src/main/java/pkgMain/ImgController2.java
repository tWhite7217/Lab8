package pkgMain;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


/**
 * @author Terry Harvey
 * @author Matt Cohen
 * @author Josh Stone
 * @author Ian McCabe
 * @author Tommy White
 * @author Brandon Wu
 */
public class ImgController2 {

	
	private final boolean DEBUG = true;
	
	/**
	 * The view, handles milkweed images and milkweed image creation 
	 */
	MyMovingImageView2 view;
	
	/**
	 * Model for where the milkweed are located on the screen 
	 */
	MyMovingImageModel2 model;
	
	/**
	 * used to determine if a new milkweed image needs to be created 
	 */
	boolean copied = true;
	
	/**
	 * Creates an image controller with a given view 
	 * @param view a view object for displaying the scene
	 * @return nothing
	 * @see nothing
	 */
	ImgController2(MyMovingImageView2 view){
		this.view = view;
		model = new MyMovingImageModel2(view.getWidth(), view.getHeight(), view.getTPWidth(), view.getPicSize());
		if (DEBUG) System.out.println("ic created");
	}
	
	/**
	 * Handles the dragging logic of the static milkweed image in the TilePane 
	 * @param event the drag event that occurred
	 */
	public void drag(MouseEvent event) {
		if (event.getX() > view.getTPWidth() && !copied) {
			int index = view.addIVToFlow();
			model.addX(0);
			model.addY(event.getY());
			view.setXs(index, 0 - view.getPicSize()*index);
			view.setYs(index, event.getY());
			copied = true;
		}
	}
	/**
	 * The logic that allows milkweed ImageViews in the FlowPane to be dragged 
	 * @param i the index in ivs of the ImageView being dragged
	 * @param event the drag event that occurred
	 */
	public void dragFlow(int i, MouseEvent event) {
		if (DEBUG) System.out.println("ic mouse drag tx: " + model.getXs(i) + ", ex: " + event.getX() );
		model.setXs(i, model.getXs(i) + event.getX());
		model.setYs(i, model.getYs(i) + event.getY());
		view.setXs(i, model.getXs(i) );
		view.setYs(i, model.getYs(i) );
	}
	
	/**
	 * Registers a mouse press on the milkweed image, sets copied to false so that a new milkweed image may be generated
	 * @param event the mouse pressing event 
	 */
	public void press(MouseEvent event) {
		copied = false;
	}
	
	/**
	 * Registers a mouse drag released event, sets copied to true so a new milkweed image will not be generated accidentally 
	 * @param event
	 */
	public void dragReleased(MouseEvent event) {
		copied = true;
	}

	/**
	 * Gets the event handler for when a mouse drag event occurs 
	 * @return a drag mouse event 
	 */
	public EventHandler getHandlerForDrag() {
		return event -> drag((MouseEvent) event);
	}
	
	
	/**
	 * Gets event handler for when a mouse drag is released 
	 * @return drag released mouse event 
	 */
	public EventHandler getHandlerForDragReleased() {
		return event -> dragReleased((MouseEvent) event);
	}
	
	/**
	 * Gets the drag event handler for milkweed images in the FlowPane 
	 * @param i the milkweed image that is being dragged 
	 * @return the mouse event handler for the specific milkweed image that was created 
	 */
	public EventHandler getHandlerForDrag(int i) {
		return event -> dragFlow(i, (MouseEvent) event);
	}
	
	/**
	 * Gets the event handler for when the mouse presses on the TilePane milkweed 
	 * @return mouse press event 
	 */
	public EventHandler getHandlerForPress() {
		return event -> press((MouseEvent) event);
	}
	
}
