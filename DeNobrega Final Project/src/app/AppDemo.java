package app;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.PersonBag;
import model.TextbookBag;
import util.Restore;
import view.MainView;

public class AppDemo extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		PersonBag personBag = new File("backupFolder/Persons.dat").exists() ? Restore.restorePersonBag() : new PersonBag(2000);
		TextbookBag textbookBag = new File("backupFolder/Textbooks.dat").exists() ? Restore.restoreTextbookBag() : new TextbookBag(40000);
		MainView mainView = new MainView(personBag, textbookBag);	
		Scene scene = new Scene(mainView.getRoot(), 1000, 700);
		primaryStage.setScene(scene);
		primaryStage.setTitle("DeNobrega Final Project");
		primaryStage.getIcons().add(new Image("BookIcon.png"));
		primaryStage.show();	
	}
}
