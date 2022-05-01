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
import model.Textbook;
import model.TextbookBag;
import util.Backup;

public class TextbookView {
	private TextbookBag textbookBag;
	private VBox textbookPane;
	
	public TextbookView(TextbookBag textbookBag) {
		this.textbookBag = textbookBag;
		
		TextField titleField = new TextField();
		titleField.setPrefSize(100, 30);
		titleField.setPromptText("TITLE");
		
		TextField isbnField = new TextField();
		isbnField.setPrefSize(100, 30);
		isbnField.setPromptText("ISBN");
		
		TextField authorFirstNameField = new TextField();
		authorFirstNameField.setPrefSize(100, 30);
		authorFirstNameField.setPromptText("AUTHOR FIRST NAME");
		
		TextField authorLastNameField = new TextField();
		authorLastNameField.setPrefSize(100, 30);
		authorLastNameField.setPromptText("AUTHOR LAST NAME");
		
		TextField priceField = new TextField();
		priceField.setPrefSize(100, 30);
		priceField.setPromptText("PRICE");
		
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
		inputBox.getChildren().addAll(titleField, isbnField, authorFirstNameField, authorLastNameField, priceField);
		
		HBox btnBox = new HBox(20);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll( searchBtn, removeBtn, insertBtn, updateBtn, exitBtn);
		
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("TITLE", "ISBN" , "AUTHOR FIRST NAME", "AUTHOR LAST NAME", "PRICE");
		choiceBox.setValue("Search/Remove Parameter:");
		
		VBox outputBox = new VBox(30);
		outputBox.setAlignment(Pos.CENTER);
		outputBox.getChildren().addAll(outputArea);
		
		searchBtn.setOnAction(e -> {
			String userChoice = choiceBox.getValue();
			Textbook[] predicateSearch = textbookBag.search(t -> {
					if(userChoice.equals("TITLE")) {
						return t.getTitle().equals(titleField.getText());
					}
					
					if(userChoice.equals("ISBN")) {
						return t.getIsbn().equals(isbnField.getText());
					}
					
					if(userChoice.equals("AUTHOR FIRST NAME")) {
						return t.getAuthor().getFirstName().equals(authorFirstNameField.getText());
					}
					
					if(userChoice.equals("AUTHOR LAST NAME")) {
						return t.getAuthor().getLastName().equals(authorLastNameField.getText());
					}
					
					if(userChoice.equals("PRICE")){
						return t.getPrice() == Double.parseDouble(priceField.getText());
					}
					return false;
			});
			
			if(userChoice.equals("TITLE")) {
				outputArea.appendText("Textbooks found with title " + titleField.getText() + ":" + "\n");
				titleField.clear();
			} else if(userChoice.equals("ISBN")) {
				outputArea.appendText("Textbook found with isbn " + isbnField.getText() + ":" + "\n");
				isbnField.clear();
			} else if(userChoice.equals("AUTHOR FIRST NAME")) {
				outputArea.appendText("Textbooks found with author first name " + authorFirstNameField.getText() + ":" + "\n");	
				authorLastNameField.clear();
			} else if(userChoice.equals("AUTHOR LAST NAME")) {
				outputArea.appendText("Textbooks found with author last name " + authorLastNameField.getText() + ":" + "\n");
				authorLastNameField.clear();
			} else if(userChoice.equals("PRICE")) {
				outputArea.appendText("Textbooks found with price " + priceField.getText() + ":" + "\n");
				priceField.clear();
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
			Textbook[] predicateDelete = textbookBag.delete(t -> {
					if(userChoice.equals("TITLE")) {
						return t.getTitle().equals(titleField.getText());
					}
					
					if(userChoice.equals("ISBN")) {
						return t.getIsbn().equals(isbnField.getText());
					}
					
					if(userChoice.equals("AUTHOR FIRST NAME")) {
						return t.getAuthor().getFirstName().equals(authorFirstNameField.getText());
					}
					
					if(userChoice.equals("AUTHOR LAST NAME")) {
						return t.getAuthor().getLastName().equals(authorLastNameField.getText());
					}
					
					if(userChoice.equals("PRICE")){
						return t.getPrice() == Double.parseDouble(priceField.getText());
					}
					return false;
			});
			
			if(userChoice.equals("TITLE")) {
				outputArea.appendText("Textbooks removed with title " + titleField.getText() + ":" + "\n");
				titleField.clear();
			} else if(userChoice.equals("ISBN")) {
				outputArea.appendText("Textbook removed with isbn " + isbnField.getText() + ":" + "\n");
				isbnField.clear();
			} else if(userChoice.equals("AUTHOR FIRST NAME")) {
				outputArea.appendText("Textbooks removed with author first name " + authorFirstNameField.getText() + ":" + "\n");	
				authorLastNameField.clear();
			} else if(userChoice.equals("AUTHOR LAST NAME")) {
				outputArea.appendText("Textbooks removed with author last name " + authorLastNameField.getText() + ":" + "\n");
				authorLastNameField.clear();
			} else if(userChoice.equals("PRICE")) {
				outputArea.appendText("Textbooks removed with price " + priceField.getText() + ":" + "\n");
				priceField.clear();
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
			Backup.backupTextbookBag(textbookBag);
		});
		
		insertBtn.setOnAction(e -> {
			String title = titleField.getText();
			String isbn = isbnField.getText();
			Name name = new Name(authorFirstNameField.getText(), authorLastNameField.getText());
			double price = Double.parseDouble(priceField.getText());
			
			Textbook t = new Textbook(title, isbn, name, price);
			textbookBag.insert(t);
			outputArea.appendText("Textbook added to to TextbookBag: " + "\n" + t + "\n");
			
			titleField.clear();
			isbnField.clear();
			authorFirstNameField.clear();
			authorLastNameField.clear();
			
			Backup.backupTextbookBag(textbookBag);
		});
		
		exitBtn.setOnAction(e -> {
			Backup.backupTextbookBag(textbookBag);
			Platform.exit();
		});
		
		textbookPane = new VBox(40);
		textbookPane.setAlignment(Pos.CENTER);
		textbookPane.getChildren().addAll(inputBox,btnBox, choiceBox, outputBox);
		
	}
	
	public VBox getTextbookPane() {
		return textbookPane;
	}
	
}
