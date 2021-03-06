package p1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppDemo extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TextField gpaField = new TextField();
		gpaField.setPrefSize(80, 30);
		gpaField.setPromptText("Enter Gpa");
		
		HBox inputBox = new HBox(20);
		inputBox.setAlignment(Pos.CENTER);
		inputBox.getChildren().add(gpaField);
		
		Button okBtn = new Button("OK");
		okBtn.setPrefSize(80, 30);
		
		HBox btnBox = new HBox(20);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().add(okBtn);
		
		TextArea outputArea = new TextArea();
		outputArea.setPromptText("OUTPUT");
		outputArea.setMaxSize(300, 100);
		
		VBox outputBox = new VBox(30);
		outputBox.setAlignment(Pos.CENTER);
		outputBox.getChildren().add(outputArea);
		
		VBox root = new VBox(50);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(inputBox, btnBox, outputBox);
		
		okBtn.setOnAction(e -> {
			double gpa = Double.parseDouble(gpaField.getText());
			outputArea.appendText("User entered a gpa of " + gpa);
			
		
		});
	
		
		Scene scene = new Scene(root, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
