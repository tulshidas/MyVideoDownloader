
package fx2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setMinHeight(400);
        pane.setMinWidth(700);
        VBox bBox = new VBox();
        bBox.setMinHeight(100);
        bBox.setStyle("-fx-border-color:black;-fx-border-width:1 0 1 0;-fx-background-color:green");
        
        VBox bBox2 = new VBox();
        bBox2.setAlignment(Pos.CENTER);
        bBox2.setStyle("-fx-background-color: blue");
        bBox2.setSpacing(10);
        
        TextField tField = new TextField();
        tField.setMaxWidth(200);
        tField.setAlignment(Pos.CENTER);
        TextField passwordField = new TextField();
        passwordField.setAlignment(Pos.CENTER);
        passwordField.setMaxWidth(200);
        Button button = new Button("Submit");
       
        
        Label label = new Label();
        
        button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String username = tField.getText();
				String pass = passwordField.getText();
				if(username.equals("java") && pass.equals("iit123")){
					label.setText("Success");
					BorderPane pane1 = new BorderPane();
			        pane1.setMinHeight(400);
			        pane1.setMinWidth(700);
			        Label lb2 = new Label("second stage");
			        pane1.setCenter(lb2);
			        Scene  s1 = new Scene(pane1);
			        Stage stg = new Stage();
			        stg.setScene(s1);
			        stg.show();
				}
				else label.setText("Wrong");
				
			}
		});
        bBox2.getChildren().addAll(tField,passwordField,button,label);
        
        pane.setTop(bBox);
        pane.setCenter(bBox2);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}