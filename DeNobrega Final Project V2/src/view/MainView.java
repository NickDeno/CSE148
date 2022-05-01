package view;

import java.io.File;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.PersonBag;
import model.TextbookBag;
import util.Backup;
import util.Restore;
import util.Utilities;

public class MainView {
	private BorderPane root;
	private PersonBag personBag;
	private TextbookBag textbookBag;
	
	private StudentView studentView;
	private InstructorView instructorView;
	private TextbookView textbookView;

	//Test
	public MainView() {
		personBag = new File("backupFolder/Persons.dat").exists() ? Restore.restorePersonBag() : new PersonBag(2000);
		textbookBag = new File("backupFolder/Textbooks.dat").exists() ? Restore.restoreTextbookBag() : new TextbookBag(39000);
		root = new BorderPane();	
		studentView = new StudentView(personBag);
		instructorView = new InstructorView(personBag);
		textbookView = new TextbookView(textbookBag);
		VBox startView = makeStartingView();	
		
		MenuBar menuBar = new MenuBar();	
		
		Menu fileMenu = new Menu("File");
		Menu importMenu = new Menu("Import (FIRST LAUNCH ONLY)");
		MenuItem importPersonsItem = new MenuItem("Import Persons/Instructors");
		MenuItem importTextbooksItem = new MenuItem("Import Textbooks");
		importMenu.getItems().addAll(importPersonsItem, importTextbooksItem);
		Menu backupMenu = new Menu("Backup");
		MenuItem backupPersonsItem = new MenuItem("Backup Students/Instructors");
		MenuItem backupTextbooksItem = new MenuItem("Backup Textbooks");
		backupMenu.getItems().addAll(backupPersonsItem, backupTextbooksItem);
		SeparatorMenuItem separator = new SeparatorMenuItem();
		MenuItem exitItem = new MenuItem("Exit");	
		fileMenu.getItems().addAll(importMenu, backupMenu, separator, exitItem);
	
		Menu viewMenu = new Menu("View");
		MenuItem studentViewItem = new MenuItem("Student View");
		MenuItem instructorViewItem = new MenuItem("Instructor View");
		MenuItem textbookViewItem = new MenuItem("Textbook View");	
		SeparatorMenuItem separator2 = new SeparatorMenuItem();
		MenuItem startViewItem = new MenuItem("Return to Menu");
		viewMenu.getItems().addAll(studentViewItem, instructorViewItem, textbookViewItem, separator2, startViewItem);
		
		Menu clearMenu = new Menu("Clear");
		MenuItem clearTextFieldsItem = new MenuItem("Clear Text Fields");
		MenuItem clearAllFieldsItem = new MenuItem("Clear All Fields");
		clearMenu.getItems().addAll(clearTextFieldsItem, clearAllFieldsItem);
		
		importPersonsItem.setOnAction(e -> {
			Utilities.importStudents(personBag);
			Utilities.importInstructors(personBag);
			Backup.backupPersonBag(personBag);
		});
		
		importTextbooksItem.setOnAction(e -> {
			Utilities.importTextbooks(textbookBag);
			Backup.backupTextbookBag(textbookBag);
		});
		
		backupPersonsItem.setOnAction(e -> Backup.backupPersonBag(personBag));	
		backupTextbooksItem.setOnAction(e -> Backup.backupTextbookBag(textbookBag));
		
		exitItem.setOnAction(e -> {
			Backup.backupPersonBag(personBag);
			Platform.exit();
		});
		
		studentViewItem.setOnAction(e -> {
			root.setCenter(studentView.getStudentPane());
			instructorView.clearAllFields();
			textbookView.clearAllFields();
		});
		
		instructorViewItem.setOnAction(e -> {
			root.setCenter(instructorView.getInstructorPane());
			studentView.clearAllFields();
			textbookView.clearAllFields();
		});
		
		textbookViewItem.setOnAction(e -> {
			root.setCenter(textbookView.getTextbookPane());
			studentView.clearAllFields();
			instructorView.clearAllFields();
		});	
		
		startViewItem.setOnAction(e -> {
			root.setCenter(startView);
			studentView.clearAllFields();
			instructorView.clearAllFields();
			textbookView.clearAllFields();
		});

		clearTextFieldsItem.setOnAction(e -> {
			if(root.getCenter().equals(studentView.getStudentPane())) {
				studentView.clearTextFields();	
			}else if(root.getCenter().equals(instructorView.getInstructorPane())){
				instructorView.clearTextFields();	
			}else {
				textbookView.clearTextFields();
			}
		});
		
		clearAllFieldsItem.setOnAction(e -> {
			if(root.getCenter().equals(studentView.getStudentPane())) {
				studentView.clearAllFields();	
			}else if(root.getCenter().equals(instructorView.getInstructorPane())){
				instructorView.clearAllFields();	
			}else {
				textbookView.clearAllFields();
			}
		});
		
		menuBar.getMenus().addAll(fileMenu, viewMenu, clearMenu);
		root.setTop(menuBar);
		root.setCenter(startView);
	}

	public BorderPane getRoot() {
		return root;
	}
	
	public VBox makeStartingView() {
		Text title = new Text("Main Menu");
		title.setFill(Paint.valueOf("#ffffff"));
		title.setFont(Font.font("Baskerville Old Face",FontWeight.BOLD, 100));
		
		Button studentViewBtn = new Button("Student View");
		studentViewBtn.setPrefSize(140, 50);
		studentViewBtn.setFont(new Font("Bookman Old Style", 14));
		studentViewBtn.setOnAction(e -> root.setCenter(studentView.getStudentPane()));
		
		Button instructorViewBtn = new Button("Instructor View");
		instructorViewBtn.setPrefSize(140, 50);
		instructorViewBtn.setFont(new Font("Bookman Old Style", 14));
		instructorViewBtn.setOnAction(e -> root.setCenter(instructorView.getInstructorPane()));
		
		Button textbookViewBtn = new Button("Textbook View");
		textbookViewBtn.setPrefSize(140, 50);
		textbookViewBtn.setFont(new Font("Bookman Old Style", 14));
		textbookViewBtn.setOnAction(e -> root.setCenter(textbookView.getTextbookPane()));
		
		HBox buttonBox = new HBox(40);
		buttonBox.getChildren().addAll(studentViewBtn, instructorViewBtn, textbookViewBtn);
		buttonBox.setAlignment(Pos.CENTER);
		
		VBox startView = new VBox(50);
		startView.getChildren().addAll(title, buttonBox);
		startView.setAlignment(Pos.CENTER);
		startView.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #9e374a, #232526 )");
		
		return startView;
	}	
}
