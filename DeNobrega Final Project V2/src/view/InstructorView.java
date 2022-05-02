package view;

import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Instructor;
import model.Name;
import model.Person;
import model.PersonBag;
import util.Backup;

public class InstructorView {
	private PersonBag instructorBag;
	private VBox instructorPane;
	
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField rankField;
	private TextField salaryField;
	private TextField idField;
	private TextField outputField;
	
	private ChoiceBox<String> choiceBox;
	private ListView<Person> listView;
	
	public InstructorView(PersonBag instructorBag) {
		this.instructorBag = instructorBag;
		
		Text title = new Text("Instructor View");
		title.setFill(Paint.valueOf("#ffffff"));
		title.setFont(Font.font("Baskerville Old Face",FontWeight.BOLD, 60));
		
		firstNameField = new TextField();
		firstNameField.setPrefSize(100, 30);
		firstNameField.setPromptText("FIRST NAME");
		
		lastNameField = new TextField();
		lastNameField.setPrefSize(100, 30);
		lastNameField.setPromptText("LAST NAME");
		
		rankField = new TextField();
		rankField.setPrefSize(100, 30);
		rankField.setPromptText("RANK");
	
		salaryField = new TextField();
		salaryField.setPrefSize(100, 30);
		salaryField.setPromptText("SALARY");
		
		idField = new TextField();
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
		
		outputField = new TextField();
		outputField.setPromptText("OUTPUT");
		outputField.setMaxSize(300, 50);
		
		listView = new ListView<>();
		listView.setMaxSize(700, 200);
		
		
		HBox inputBox = new HBox(20);
		inputBox.setAlignment(Pos.CENTER);
		inputBox.getChildren().addAll(firstNameField, lastNameField, rankField, salaryField, idField);
		
		HBox btnBox = new HBox(20);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(searchBtn, removeBtn, insertBtn, updateBtn);
		
		choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("ID", "FIRST NAME" , "LAST NAME", "RANK", "SALARY");
		choiceBox.setValue("Search Parameter:");
		
		VBox outputBox = new VBox(30);
		outputBox.setAlignment(Pos.CENTER);
		outputBox.getChildren().addAll(outputField, listView);
		
		searchBtn.setOnAction(e -> {		
			outputField.clear();
			listView.getItems().clear();
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
					
					if(userChoice.equals("RANK")) {
						return ((Instructor) i).getRank().equalsIgnoreCase(rankField.getText());
					}
					
					if(userChoice.equals("SALARY")) {
						return ((Instructor) i).getSalary() == Double.parseDouble(salaryField.getText());
					}	
				}
				return false;
			});
			
			if(userChoice.equals("ID") && predicateSearch.length > 0) {
				outputField.appendText("Instructor found with id " + idField.getText() + "!");
				setTextFields(predicateSearch[0]);
				
			} else if(predicateSearch.length > 0) {
				outputField.appendText("Search results:");
				ObservableList<Person> results = FXCollections.observableArrayList(predicateSearch);
				listView.getItems().addAll(results);
				listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {

					@Override
					public void changed(ObservableValue<? extends Person> observable, Person oldPerson, Person newPerson) {
						if(newPerson != null) {
							setTextFields(newPerson);
						}
					}	
				});
			
			} else {	
				outputField.appendText("No instructor matches found.");
				clearTextFields();
			}
			choiceBox.setValue("Search Parameter:");	
		});
		
		removeBtn.setOnAction(e -> {
			outputField.clear();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setContentText("Are you sure you want to remove instructor with ID " + idField.getText() + "?");
			Optional<ButtonType> action = alert.showAndWait();
			
			if(action.get() == ButtonType.OK) {
				outputField.appendText("Removed instructor with id " + idField.getText() + "!");
				Person[] predicateDelete = instructorBag.delete(i -> i.getId().equals(idField.getText()));		
				listView.getItems().remove(predicateDelete[0]);
				listView.getSelectionModel().clearSelection();
				clearTextFields();
				Backup.backupPersonBag(instructorBag);
			}
		});
		
		insertBtn.setOnAction(e -> {
			outputField.clear();
			listView.getItems().clear();
			if(checkTextFieldsAreValid() == true && idField.getText().isEmpty()) {
				Instructor i = new Instructor(new Name(firstNameField.getText(), lastNameField.getText()), rankField.getText(), Double.parseDouble(salaryField.getText()));
				instructorBag.insert(i);
				outputField.appendText("Inserted Instructor!");
				clearTextFields();
				Backup.backupPersonBag(instructorBag);
				
			} else if(!idField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Cannot insert instructor with ID chosen by user. Clear ID field and try again.");
				alert.showAndWait();
			}
		});
		
		updateBtn.setOnAction(e -> {
			outputField.clear();	
			Person[] instructorToUpdate = instructorBag.search(s -> s.getId().equals(idField.getText()));
			if(checkTextFieldsAreValid() == true) {
				instructorToUpdate[0].setName(new Name(firstNameField.getText(), lastNameField.getText()));
				((Instructor)instructorToUpdate[0]).setRank(rankField.getText());
				((Instructor)instructorToUpdate[0]).setSalary(Double.parseDouble(salaryField.getText()));
				listView.getSelectionModel().clearSelection();
				outputField.appendText("Instructor with id " + idField.getText() + " was updated!");
				clearTextFields();
				Backup.backupPersonBag(instructorBag);
			}	
		});
		
		instructorPane = new VBox(35);
		instructorPane.setAlignment(Pos.CENTER);
		instructorPane.setPadding(new Insets(30));
		instructorPane.getChildren().addAll(title, inputBox, btnBox, choiceBox, outputBox);
		instructorPane.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #129fb8, #232526 )");
		
	}
	
	public VBox getInstructorPane() {
		return instructorPane;
	}
	
	public void setTextFields(Person p) {
		firstNameField.setText(p.getName().getFirstName());
		lastNameField.setText(p.getName().getLastName());
		rankField.setText(((Instructor)p).getRank());
		salaryField.setText(String.valueOf(((Instructor)p).getSalary()));
		idField.setText(p.getId());
	}
	
	public void clearTextFields() {
		firstNameField.clear();
		lastNameField.clear();
		rankField.clear();
		salaryField.clear();
		idField.clear();
	}
	
	public void clearAllFields() {
		clearTextFields();
		choiceBox.setValue("Search Parameter");
		outputField.clear();
		listView.getItems().clear();
		
	}
	
	private boolean checkTextFieldsAreValid() {
		if(firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || rankField.getText().isEmpty() || salaryField.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please Recheck Text Fields and Try Again.");
			alert.showAndWait();
			return false;
			
		} else if(!(rankField.getText().equalsIgnoreCase("Instructor") || rankField.getText().equalsIgnoreCase("Assistant Professor") || 
				rankField.getText().equalsIgnoreCase("Associate Professor") || rankField.getText().equalsIgnoreCase("Professor"))) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Invalid instructor rank. Please Recheck and Try Again");
			alert.showAndWait();
			return false;
		}
		return true;	
	}	
}
