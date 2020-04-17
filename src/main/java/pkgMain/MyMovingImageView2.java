package pkgMain;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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
	private final double LEFT_PANE_WIDTH = 100;
	
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
//    	iv1.setLayoutX(imc.getStartingX());
//    	iv1.setLayoutY(imc.getStartingY());
    	iv1.setFitHeight(100);
    	iv1.setOnMouseDragged(imc.getHandlerForDrag());
    	iv1.setOnMousePressed(imc.getHandlerForPress());
    	iv1.setOnMouseReleased(imc.getHandlerForDragReleased());
    	
    	BorderPane rootPane = new BorderPane();
    	
    	TilePane tile = new TilePane();
    	tile.setHgap(0);
    	tile.setVgap(0);
    	tile.setPrefColumns(0);
    	tile.setPadding(new Insets(5, 0, 5, 0));
    	tile.getChildren().add(iv1);
    	
    	flow = new Pane();
    	flow.setStyle("-fx-background-color: DAE6F3;");
//    	flow.setOnMouseDragOver(imc.getHandlerForDragOver());
//    	flow.setAlignment(Pos.BASELINE_LEFT);
    	
    	rootPane.setCenter(flow);
    	rootPane.setLeft(tile);

    	Scene scene = new Scene(rootPane, WIDTH, HEIGHT);
        stage.setScene(scene);
        
		iv1.setTranslateX(imc.getStartingX());
		iv1.setTranslateY(imc.getStartingY());

        stage.show();
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
    	ivs.get(i).setFitHeight(100);
    	ivs.get(i).setOnMouseDragged(imc.getHandlerForDrag(i));
    	ivs.get(i).setLayoutX(0);
    	ivs.get(i).setLayoutY(0);
    	flow.getChildren().add(ivs.get(i));
    	return i;
    }

}