package view;

import java.io.File;
import java.util.Optional;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert.AlertType;
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
	
	public MainView() {
		personBag = new File("backupFolder/Persons.dat").exists() ? Restore.restorePersonBag() : new PersonBag(2000);
		textbookBag = new File("backupFolder/Textbooks.dat").exists() ? Restore.restoreTextbookBag() : new TextbookBag(40000);
		studentView = new StudentView(personBag);
		instructorView = new InstructorView(personBag);
		textbookView = new TextbookView(textbookBag);
		root = new BorderPane();		
		VBox startView = makeStartingView();	
		
		MenuBar menuBar = new MenuBar();		
		Menu fileMenu = new Menu("File");
		Menu importMenu = new Menu("Import (FIRST LAUNCH ONLY)");
		Menu backupMenu = new Menu("Backup");
		Menu viewMenu = new Menu("View");
		Menu clearMenu = new Menu("Clear");	
		MenuItem importStudentsItem = new MenuItem("Import Students");
		MenuItem importInstructorsItem = new MenuItem("Import Instructors");
		MenuItem importTextbooksItem = new MenuItem("Import Textbooks");
		MenuItem backupPersonsItem = new MenuItem("Backup Students/Instructors");
		MenuItem backupTextbooksItem = new MenuItem("Backup Textbooks");
		MenuItem exitItem = new MenuItem("Exit");		
		MenuItem studentViewItem = new MenuItem("Student View");
		MenuItem instructorViewItem = new MenuItem("Instructor View");
		MenuItem textbookViewItem = new MenuItem("Textbook View");	
		MenuItem mainMenuViewItem = new MenuItem("Return to Menu");
		MenuItem clearTextFieldsItem = new MenuItem("Clear Text Fields");
		MenuItem clearAllFieldsItem = new MenuItem("Clear All Fields");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		SeparatorMenuItem separator2 = new SeparatorMenuItem();
		
		importMenu.getItems().addAll(importStudentsItem, importInstructorsItem, importTextbooksItem);
		backupMenu.getItems().addAll(backupPersonsItem, backupTextbooksItem);
		fileMenu.getItems().addAll(importMenu, backupMenu, separator, exitItem);
		viewMenu.getItems().addAll(studentViewItem, instructorViewItem, textbookViewItem, separator2, mainMenuViewItem);
		clearMenu.getItems().addAll(clearTextFieldsItem, clearAllFieldsItem);
		menuBar.getMenus().addAll(fileMenu, viewMenu, clearMenu);
		
		root.setTop(menuBar);
		root.setCenter(startView);
		
		importStudentsItem.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setContentText("Importing students should only be done on first launch. Do you want to continue?");
			Optional<ButtonType> action = alert.showAndWait();
			if(action.get() == ButtonType.OK) {
				Utilities.importStudents(personBag);
				Backup.backupPersonBag(personBag);
				Alert successAlert = new Alert(AlertType.INFORMATION);
				successAlert.setTitle("Import Successful");
				successAlert.setHeaderText(null);
				successAlert.setContentText("Students have been imported!");
				successAlert.showAndWait();
			}
		});
		
		importInstructorsItem.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setContentText("Importing Instructors should only be done on first launch. Do you want to continue?");
			Optional<ButtonType> action = alert.showAndWait();
			if(action.get() == ButtonType.OK) {
				Utilities.importInstructors(personBag);
				Backup.backupPersonBag(personBag);
				Alert successAlert = new Alert(AlertType.INFORMATION);
				successAlert.setTitle("Import Successful");
				successAlert.setHeaderText(null);
				successAlert.setContentText("Instructors have been imported!");
				successAlert.showAndWait();
			}
		});
		
		importTextbooksItem.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setContentText("Importing Textbooks should only be done on first launch. Do you want to continue?");
			Optional<ButtonType> action = alert.showAndWait();
			if(action.get() == ButtonType.OK) {
				Utilities.importTextbooks(textbookBag);
				Backup.backupTextbookBag(textbookBag);
				Alert successAlert = new Alert(AlertType.INFORMATION);
				successAlert.setTitle("Import Successful");
				successAlert.setHeaderText(null);
				successAlert.setContentText("Textbooks have been imported!");
				successAlert.showAndWait();
			}
		});
		
		backupPersonsItem.setOnAction(e -> {
			Backup.backupPersonBag(personBag);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Backup Successful");
			alert.setHeaderText(null);
			alert.setContentText("Students and Instructors have been backed up!");
			alert.showAndWait();
		});	
		
		backupTextbooksItem.setOnAction(e -> {
			Backup.backupTextbookBag(textbookBag);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Backup Successful");
			alert.setHeaderText(null);
			alert.setContentText("Textbooks have been backed up!");
			alert.showAndWait();
		});
		
		exitItem.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to exit? Students, Instructors, and Textbooks will be backed up on exit.");
			Optional<ButtonType> action = alert.showAndWait();
			if(action.get() == ButtonType.OK) {
				Backup.backupPersonBag(personBag);
				Backup.backupTextbookBag(textbookBag);
				Platform.exit();
			}
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
		
		mainMenuViewItem.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to return to main menu?");
			Optional<ButtonType> action = alert.showAndWait();
			if(action.get() == ButtonType.OK) {
				root.setCenter(startView);
				studentView.clearAllFields();
				instructorView.clearAllFields();
				textbookView.clearAllFields();
			}
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
