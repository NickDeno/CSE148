package p1;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Name;
import model.PersonBag;
import model.Student;

public class PersonView {
	private PersonBag personBag;
	private VBox studentPane;
	
	public PersonView(PersonBag personBag) {
		this.personBag = personBag;
		
		Button insertBtn = new Button("INSERT");
		insertBtn.setPrefSize(100, 30);
		
		Button searchBtn = new Button("SEARCH");
		searchBtn.setPrefSize(100, 30);
		
		Button updateBtn = new Button("UPDATE");
		updateBtn.setPrefSize(100, 30);
		
		Button removeBtn = new Button("REMOVE");
		removeBtn.setPrefSize(100, 30);
		
		HBox btnBox = new HBox(30);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(insertBtn, searchBtn, updateBtn, removeBtn);
		
		TextField nameField = new TextField();
		nameField.setPromptText("Name");
		nameField.setPrefSize(150, 30);
		
		TextField gpaField = new TextField();
		gpaField.setPrefSize(150, 30);
		gpaField.setPromptText("GPA");
		
		HBox inputBox = new HBox(20);
		inputBox.setAlignment(Pos.CENTER);
		inputBox.getChildren().addAll(nameField, gpaField);
		
		TextField outputField = new TextField();
		outputField.setMaxSize(300, 30);
		TextArea outputArea = new TextArea();
		outputArea.setMaxSize(600, 300);
		
		VBox outputBox = new VBox(20);
		outputBox.setAlignment(Pos.CENTER);
		outputBox.getChildren().addAll(outputField, outputArea);
		
		insertBtn.setOnAction(e -> {
			String name = nameField.getText();
			double gpa = Double.parseDouble(gpaField.getText());
			Student s = new Student(new Name(name, name), gpa, "CSE");
			personBag.insert(s);
			personBag.display();
			
			nameField.clear();
			gpaField.clear();
			outputField.setText("This is what you entered: ");
			outputArea.appendText("Hey, " + name + ", your curved GPA is " + (gpa + 0.5) + ".\n");
		});
			
	
		studentPane = new VBox(50);
		studentPane.setAlignment(Pos.CENTER);
		studentPane.getChildren().addAll(inputBox, btnBox, outputBox);
		
	}
	
	public VBox getStudentPane() {
		return studentPane;
	}

}
