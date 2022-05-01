package app;

import view.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppDemo extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainView mainView = new MainView();
		Scene scene = new Scene(mainView.getRoot(), 1000, 700);
		primaryStage.setScene(scene);
		primaryStage.setTitle("DeNobrega Final Project");
		primaryStage.show();	
	}
}
