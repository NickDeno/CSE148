package app;

import model.PersonBag;
import model.TextbookBag;
import util.Backup;
import util.Restore;
import util.Utilities;
import view.InstructorView;
import view.StudentView;
import view.TextbookView;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Demo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		PersonBag personBag;
		if(new File("backupFolder/Persons.dat").exists()) {
			personBag = Restore.restorePersonBag();
		}else {
			personBag = new PersonBag(2000);
			Utilities.importInstructors(personBag);
			Utilities.importStudents(personBag);
			Backup.backupPersonBag(personBag);
		}
		
		TextbookBag textbookBag;
		if(new File("backupFolder/Textbooks.dat").exists()) {
			textbookBag = Restore.restoreTextbookBag();
		} else {
			textbookBag = new TextbookBag(39000);
			Utilities.importTextbooks(textbookBag);
			Backup.backupTextbookBag(textbookBag);
		}

		StudentView studentView = new StudentView(personBag);
		Scene scene = new Scene(studentView.getStudentPane() ,800, 500);
		primaryStage.setTitle("Student View");
//		InstructorView instructorView = new InstructorView(personBag);
//		Scene scene = new Scene(instructorView.getInstructorPane() ,800, 500);
//		primaryStage.setTitle("Instructor View");
//		TextbookView textbookView = new TextbookView(textbookBag);
//		Scene scene = new Scene(textbookView.getTextbookPane(), 800, 500);
//		primaryStage.setTitle("Textbook View");
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

}
