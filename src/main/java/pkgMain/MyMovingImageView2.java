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

/*
 * 
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
	
	public MyMovingImageView2(){
    	iv1 = new ImageView();
    	ivs = new ArrayList<ImageView>();
		imc = new ImgController2(this);
	}
		
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
    public double getWidth() {
    	return WIDTH;
    }
    public double getHeight() {
    	return HEIGHT;
    }
    public double getTPWidth() {
    	return TILE_PANE_WIDTH;
    }
    public double getPicSize() {
    	return PIC_SIZE;
    }
    public void setX(double x) {
    	iv1.setTranslateX(iv1.getLayoutX() + x);
    }
    public void setY(double y) {
    	iv1.setTranslateY(iv1.getLayoutY() + y);
    }
    public void setXs(int index, double x) {
    	ivs.get(index).setTranslateX(ivs.get(index).getLayoutX() + x);
    }
    public void setYs(int index, double y) {
    	ivs.get(index).setTranslateY(ivs.get(index).getLayoutY() + y);
    }
    public static void main(String[] args) {
        launch();
    }
    
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