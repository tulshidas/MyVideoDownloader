package fx2;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyStage extends Stage {
	public MyStage() {
		// TODO Auto-generated constructor stub
		VBox bBox2 = new VBox();
	    bBox2.setAlignment(Pos.CENTER);
	    bBox2.setStyle("-fx-background-color: blue");
	    bBox2.setSpacing(10);
	    Label label = new Label("This is second stage");
	    bBox2.getChildren().add(label);
	    
	    
	}
	
}
