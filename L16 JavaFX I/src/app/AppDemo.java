package app;

import javafx.application.Application;
import javafx.application.Platform;
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
		Application.launch(args); // Static method.
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		TextField nameField = new TextField();
		nameField.setPromptText("NAME");
		TextField gpaField = new TextField();
		gpaField.setPromptText("GPA");
		
		HBox inputBox = new HBox(20);
		inputBox.setAlignment(Pos.CENTER);
		inputBox.getChildren().addAll(nameField, gpaField);
		
		Button okBtn = new Button("OK");
		okBtn.setPrefSize(70, 30);
		Button exitBtn = new Button("EXIT");
		exitBtn.setPrefSize(70, 30);
		
		HBox btnBox = new HBox(80);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(okBtn, exitBtn);
		
		VBox outputBox = new VBox(30);
		TextArea outputArea = new TextArea();
		outputArea.setMaxSize(400, 200);
		outputBox.setAlignment(Pos.CENTER);
		outputBox.getChildren().add(outputArea);
		
		okBtn.setOnAction(e -> {
			String name = nameField.getText();
			double gpa = Double.parseDouble(gpaField.getText());
			outputArea.appendText(name + ": " + gpa + "\n");
			nameField.clear();
			gpaField.clear();
		});
		
		exitBtn.setOnAction(e -> {
			Platform.exit();
		});
		
		VBox root = new VBox(50);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(inputBox, btnBox, outputBox);
		
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("My First Window");
		primaryStage.show();  
	}

}
