package pkgMain;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * @author Terry Harvey
 * @author Matt Cohen
 * @author Josh Stone
 * @author Ian McCabe
 * @author Tommy White
 * @author Brandon Wu
 */
public class MyMovingImageView2 extends Application {
	
	private ImgController2 imc;
	private ImageView iv1;
	private ArrayList<ImageView> ivs;
	Pane flow;
	Image im1;
	private final double WIDTH = 800;
	private final double HEIGHT = 600;
	private final double TILE_PANE_WIDTH = 100;
	private final double PIC_SIZE = 100;
	
	/**
	 * Creates a new View 
	 */
	public MyMovingImageView2(){
    	iv1 = new ImageView();
    	ivs = new ArrayList<ImageView>();
		imc = new ImgController2(this);
	}
	
	/**
	 * Starts the stage and displays the initial milkweed program 
	 * @param stage the stage used to hold all images and panes for the project 
	 */
    @Override
    public void start(Stage stage) {
 
    	im1 = new Image(getClass().getResourceAsStream("/img/commonMilkweed.png"));
    	iv1.setImage(im1);
    	iv1.setPreserveRatio(true);
    	iv1.setFitHeight(PIC_SIZE);
    	iv1.setOnMouseDragged(imc.getHandlerForDrag());
    	iv1.setOnMousePressed(imc.getHandlerForPress());
    	iv1.setOnMouseReleased(imc.getHandlerForDragReleased());
    	
    	
    	
    	TilePane tile = new TilePane();
    	tile.getChildren().add(iv1);
    	tile.setMaxWidth(TILE_PANE_WIDTH);
    	
    	flow = new FlowPane();
    	flow.setTranslateX(TILE_PANE_WIDTH);
    	flow.setStyle("-fx-background-color: DAE6F3;");
    	
    	StackPane rootPane = new StackPane(tile, flow);
    	
    	StackPane.setAlignment(tile, Pos.CENTER_LEFT);
    	StackPane.setAlignment(flow, Pos.CENTER);

    	Scene scene = new Scene(rootPane, WIDTH, HEIGHT);
        stage.setScene(scene);

        stage.show();
    }
    
    /**
     * Gets the width of the scene
     * @return the width of the scene 
     */
    public double getWidth() {
    	return WIDTH;
    }
    
    /**
     * Gets the height of the scene 
     * @return the height of the scene 
     */
    public double getHeight() {
    	return HEIGHT;
    }
    
    /**
     * Gets the tile pane width 
     * @return width of the TilePane 
     */
    public double getTPWidth() {
    	return TILE_PANE_WIDTH;
    }
    
    /**
     * Gets the size of the picture
     * @return size of the picture 
     */
    public double getPicSize() {
    	return PIC_SIZE;
    }
    
    /**
     * Sets a new x value for any of the ImageViews in ivs 
     * @param index the index of the ImageView in ivs to be modified
     * @param x the new x value of the specified imagView in ivs
     */
    public void setXs(int index, double x) {
    	ivs.get(index).setTranslateX(ivs.get(index).getLayoutX() + x);
    }
    
    /**
     * Sets a new y value for any of the ImageViews in ivs 
     * @param index the index of the ImageView in ivs to be modified
     * @param y the new y value of the specified ImageView in ivs
     */
    public void setYs(int index, double y) {
    	ivs.get(index).setTranslateY(ivs.get(index).getLayoutY() + y);
    }
    
    /**
     * Starts the program 
     * @param args inputs from the command line that are discarded 
     */
    public static void main(String[] args) {
        launch();
    }
    
    /**
     * Adds a new ImageView to the FlowPane
     * @return the index of the newly added ImageView in the ivs ArrayList
     */
    public int addIVToFlow() {
    	ivs.add(new ImageView());
    	int i = ivs.size()-1;
    	ivs.get(i).setImage(im1);
    	ivs.get(i).setPreserveRatio(true);
    	ivs.get(i).setFitHeight(PIC_SIZE);
    	ivs.get(i).setOnMouseDragged(imc.getHandlerForDrag(i));
    	flow.getChildren().add(ivs.get(i));
    	return i;
    }

}