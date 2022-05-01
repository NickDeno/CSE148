package view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Name;
import model.Person;
import model.PersonBag;
import model.Student;
import util.Backup;

public class StudentView {
	private PersonBag studentBag;
	private VBox studentPane;
	
	public StudentView(PersonBag studentBag) {
		this.studentBag = studentBag;
		
		TextField firstNameField = new TextField();
		firstNameField.setPrefSize(100, 30);
		firstNameField.setPromptText("FIRST NAME");
		
		TextField lastNameField = new TextField();
		lastNameField.setPrefSize(100, 30);
		lastNameField.setPromptText("LAST NAME");
		
		TextField gpaField = new TextField();
		gpaField.setPrefSize(100, 30);
		gpaField.setPromptText("GPA");
		
		TextField majorField = new TextField();
		majorField.setPrefSize(100, 30);
		majorField.setPromptText("MAJOR");
		
		TextField idField = new TextField();
		idField.setPrefSize(100, 30);
		idField.setPromptText("ID");

		Button searchBtn = new Button("SEARCH");
		searchBtn.setPrefSize(80, 30);
		
		Button removeBtn = new Button("REMOVE");
		removeBtn.setPrefSize(80, 30);
		
		Button insertBtn = new Button("INSERT");
		insertBtn.setPrefSize(80, 30);
		
		Button updateBtn = new Button("UPDATE");
		updateBtn.setPrefSize(80, 30);
		
		Button exitBtn = new Button("EXIT");
		exitBtn.setPrefSize(80, 30);
		
		TextArea outputArea = new TextArea();
		outputArea.setPromptText("OUTPUT");
		outputArea.setMaxSize(400, 100);
		
		
		HBox inputBox = new HBox(20);
		inputBox.setAlignment(Pos.CENTER);
		inputBox.getChildren().addAll(firstNameField, lastNameField, gpaField, majorField, idField);
		
		HBox btnBox = new HBox(20);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll( searchBtn, removeBtn, insertBtn, updateBtn, exitBtn);
		
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("ID", "FIRST NAME" , "LAST NAME", "GPA", "MAJOR");
		choiceBox.setValue("Search/Remove Parameter:");
		
		VBox outputBox = new VBox(30);
		outputBox.setAlignment(Pos.CENTER);
		outputBox.getChildren().addAll(outputArea);
		
		searchBtn.setOnAction(e -> {
			String userChoice = choiceBox.getValue();
			Person[] predicateSearch = studentBag.search(s -> {
				if(s instanceof Student) {
					if(userChoice.equals("ID")) {
						return s.getId().equals(idField.getText());
					}
					
					if(userChoice.equals("FIRST NAME")) {
						return s.getName().getFirstName().equals(firstNameField.getText());
					}
					
					if(userChoice.equals("LAST NAME")) {
						return s.getName().getLastName().equals(lastNameField.getText());
					}
					
					if(userChoice.equals("MAJOR")) {
						return ((Student) s).getMajor().equalsIgnoreCase(majorField.getText());
					}
					
					if(userChoice.equals("GPA")) {
						return ((Student) s).getGpa() == Double.parseDouble(gpaField.getText());
					}
				}
				return false;
			});
			
			if(userChoice.equals("ID")) {
				outputArea.appendText("Student found with id " + idField.getText() + ":" + "\n");
				idField.clear();
			} else if(userChoice.equals("FIRST NAME")) {
				outputArea.appendText("Students found with first name " + firstNameField.getText() + ":" + "\n");
				firstNameField.clear();
			} else if(userChoice.equals("LAST NAME")) {
				outputArea.appendText("Students found with last name " + lastNameField.getText() + ":" + "\n");	
				lastNameField.clear();
			} else if(userChoice.equals("MAJOR")) {
				outputArea.appendText("Students found with major " + majorField.getText() + ":" + "\n");
				majorField.clear();
			} else if(userChoice.equals("GPA")) {
				outputArea.appendText("Students found with gpa " + gpaField.getText() + ":" + "\n");
				gpaField.clear();
			}
			
			if(predicateSearch.length == 0) {
				outputArea.appendText("No matches found.");
			}else {
				for(int i = 0; i < predicateSearch.length; i++) {
					outputArea.appendText(predicateSearch[i] + "\n");
				}
			}
			outputArea.appendText("\n");
			choiceBox.setValue("Search/Remove Parameter:");
		});
		
		removeBtn.setOnAction(e -> {
			String userChoice = choiceBox.getValue();
			Person[] predicateDelete = studentBag.delete(s -> {
				if(s instanceof Student) {
					if(userChoice.equals("ID")) {
						return s.getId().equals(idField.getText());
					}
					
					if(userChoice.equals("FIRST NAME")) {
						return s.getName().getFirstName().equals(firstNameField.getText());
					}
					
					if(userChoice.equals("LAST NAME")) {
						return s.getName().getLastName().equals(lastNameField.getText());
					}
					
					if(userChoice.equals("MAJOR")) {
						return ((Student) s).getMajor().equalsIgnoreCase(majorField.getText());
					}
					
					if(userChoice.equals("GPA")) {
						return ((Student) s).getGpa() == Double.parseDouble(gpaField.getText());
					}
				}
				return false;
			});
			
			if(userChoice.equals("ID")) {
				outputArea.appendText("Student removed with id" + idField.getText() + ":" + "\n");
				idField.clear();
			} else if(userChoice.equals("FIRST NAME")) {
				outputArea.appendText("Students removed with first name " + firstNameField.getText() + ":" + "\n");
				firstNameField.clear();
			} else if(userChoice.equals("LAST NAME")) {
				outputArea.appendText("Students removed with last name " + lastNameField.getText() + ":" + "\n");	
				lastNameField.clear();
			} else if(userChoice.equals("MAJOR")) {
				outputArea.appendText("Students removed with major " + majorField.getText() + ":" + "\n");
				majorField.clear();
			} else if(userChoice.equals("GPA")) {
				outputArea.appendText("Students removed with gpa " + gpaField.getText() + ":" + "\n");
				gpaField.clear();
			}
			
			if(predicateDelete.length == 0) {
				outputArea.appendText("No matches found.");
			}else {
				for(int i = 0; i < predicateDelete.length; i++) {
					outputArea.appendText(predicateDelete[i] + "\n");
				}
			}
			outputArea.appendText("\n");
			choiceBox.setValue("Search/Remove Parameter:");
			Backup.backupPersonBag(studentBag);
		});
		
		insertBtn.setOnAction(e -> {
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			double gpa = Double.parseDouble(gpaField.getText());
			String major = majorField.getText();
			
			Student s = new Student(new Name(firstName, lastName), gpa, major);
			studentBag.insert(s);
			outputArea.appendText("Student added to PersonBag: " + "\n" + s + "\n");
			
			firstNameField.clear();
			lastNameField.clear();
			gpaField.clear();
			majorField.clear();
			
			Backup.backupPersonBag(studentBag);
		});
		
		exitBtn.setOnAction(e -> {
			Backup.backupPersonBag(studentBag);
			Platform.exit();
		});
		
		studentPane = new VBox(40);
		studentPane.setAlignment(Pos.CENTER);
		studentPane.getChildren().addAll(inputBox,btnBox, choiceBox, outputBox);
	}
	
	public VBox getStudentPane() {
		return studentPane;
	}
	
}
