package view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Instructor;
import model.Name;
import model.Person;
import model.PersonBag;
import util.Backup;

public class InstructorView {
	private PersonBag instructorBag;
	private VBox instructorPane;
	
	public InstructorView(PersonBag instructorBag) {
		this.instructorBag = instructorBag;
		
		TextField firstNameField = new TextField();
		firstNameField.setPrefSize(100, 30);
		firstNameField.setPromptText("FIRST NAME");
		
		TextField lastNameField = new TextField();
		lastNameField.setPrefSize(100, 30);
		lastNameField.setPromptText("LAST NAME");
		
		TextField rankField = new TextField();
		rankField.setPrefSize(100, 30);
		rankField.setPromptText("RANK");
	
		TextField salaryField = new TextField();
		salaryField.setPrefSize(100, 30);
		salaryField.setPromptText("SALARY");
		
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
		inputBox.getChildren().addAll(firstNameField, lastNameField, rankField, salaryField, idField);
		
		HBox btnBox = new HBox(20);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(searchBtn, removeBtn, insertBtn, updateBtn, exitBtn);
		
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("ID", "FIRST NAME" , "LAST NAME", "SALARY", "RANK");
		choiceBox.setValue("Search/Remove Parameter:");
		
		VBox outputBox = new VBox(30);
		outputBox.setAlignment(Pos.CENTER);
		outputBox.getChildren().addAll(outputArea);
		
		searchBtn.setOnAction(e -> {
			String userChoice = choiceBox.getValue();
			Person[] predicateSearch = instructorBag.search(i -> {
				if(i instanceof Instructor) {
					if(userChoice.equals("ID")) {
						return i.getId().equals(idField.getText());
					}
					
					if(userChoice.equals("FIRST NAME")) {
						return i.getName().getFirstName().equals(firstNameField.getText());
					}
					
					if(userChoice.equals("LAST NAME")) {
						return i.getName().getLastName().equals(lastNameField.getText());
					}
					
					if(userChoice.equals("SALARY")) {
						return ((Instructor) i).getSalary() == Double.parseDouble(salaryField.getText());
					}
					
					if(userChoice.equals("RANK")) {
						return ((Instructor) i).getRank().equalsIgnoreCase(rankField.getText());
					}
				}
				return false;
			});
			
			if(userChoice.equals("ID")) {
				outputArea.appendText("Instructor found with id " + idField.getText() + ":" + "\n");
				idField.clear();
			} else if(userChoice.equals("FIRST NAME")) {
				outputArea.appendText("Instructors found with first name " + firstNameField.getText() + ":" + "\n");
				firstNameField.clear();
			} else if(userChoice.equals("LAST NAME")) {
				outputArea.appendText("Instructors found with last name " + lastNameField.getText() + ":" + "\n");	
				lastNameField.clear();
			} else if(userChoice.equals("SALARY")) {
				outputArea.appendText("Instructors found with salary " + salaryField.getText() + ":" + "\n");
				salaryField.clear();
			} else if(userChoice.equals("RANK")) {
				outputArea.appendText("Instructors found with rank " + rankField.getText() + ":" + "\n");
				rankField.clear();
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
			Person[] predicateDelete = instructorBag.delete(i -> {
				if(i instanceof Instructor) {
					if(userChoice.equals("ID")) {
						return i.getId().equals(idField.getText());
					}
					
					if(userChoice.equals("FIRST NAME")) {
						return i.getName().getFirstName().equals(firstNameField.getText());
					}
					
					if(userChoice.equals("LAST NAME")) {
						return i.getName().getLastName().equals(lastNameField.getText());
					}
					
					if(userChoice.equals("SALARY")) {
						return ((Instructor) i).getSalary() == Double.parseDouble(salaryField.getText());
					}
					
					if(userChoice.equals("RANK")) {
						return ((Instructor) i).getRank().equalsIgnoreCase(rankField.getText());
					}
				}
				return false;
			});
			
			if(userChoice.equals("ID")) {
				outputArea.appendText("Instructor removed with id " + idField.getText() + ":" + "\n");
				idField.clear();
			} else if(userChoice.equals("FIRST NAME")) {
				outputArea.appendText("Instructors removed with first name " + firstNameField.getText() + ":" + "\n");
				firstNameField.clear();
			} else if(userChoice.equals("LAST NAME")) {
				outputArea.appendText("Instructors removed with last name " + lastNameField.getText() + ":" + "\n");	
				lastNameField.clear();
			} else if(userChoice.equals("SALARY")) {
				outputArea.appendText("Instructors removed with salary " + salaryField.getText() + ":" + "\n");
				salaryField.clear();
			} else if(userChoice.equals("RANK")) {
				outputArea.appendText("Instructors removed with rank " + rankField.getText() + ":" + "\n");
				rankField.clear();
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
			Backup.backupPersonBag(instructorBag);
		});
		
		insertBtn.setOnAction(e -> {
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String rank = rankField.getText();
			double salary = Double.parseDouble(salaryField.getText());
			
			Instructor i = new Instructor(new Name(firstName, lastName), rank, salary);
			instructorBag.insert(i);
			outputArea.appendText("Instructor added to PersonBag: " + "\n" + i + "\n");
			
			firstNameField.clear();
			lastNameField.clear();
			rankField.clear();
			salaryField.clear();
			
			Backup.backupPersonBag(instructorBag);
			
		});
		
		exitBtn.setOnAction(e -> {
			Backup.backupPersonBag(instructorBag);
			Platform.exit();
		});
		
		instructorPane = new VBox(40);
		instructorPane.setAlignment(Pos.CENTER);
		instructorPane.getChildren().addAll(inputBox, btnBox, choiceBox, outputBox);
		
	}
	
	public VBox getInstructorPane() {
		return instructorPane;
	}
}
