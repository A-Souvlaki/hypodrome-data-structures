package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Rider;
import model.User;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class SearchBetController implements Initializable {
	
	@FXML
	private TextField id;
	
	@FXML
	private Label name;
	
	@FXML
	private Label winner;
	
	@FXML
	private Label bet;
	
	@FXML
	private Label name_value;
	
	@FXML
	private Label winner_value;
	
	@FXML
	private Label bet_value;
	
	@FXML
	private Button search;
	

	
	void init () {
		
		
		search.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {

				try {
					int ide = Integer.parseInt(id.getText());
					User one = Main.getHypodrome().searchUser(ide);
					
					name_value.setText(one.getName());
					Rider a = Main.getHypodrome().getCareer().getARider(one.getRiderToBet());
					if (a.getWinner()) {
						winner_value.setText("You win");
					}else {
						winner_value.setText("You lose, good lucky in your next attemp");
					}
					
					bet_value.setText(""+one.getBet());
					
				} catch (NumberFormatException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Use numbers");
					alert.setHeaderText(null);
					alert.setContentText("Some camp could be typed incorrectly, remember ID is only numbers");
					alert.showAndWait();
				} catch(NullPointerException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("User not found");
					alert.setHeaderText(null);
					alert.setContentText("The user is nos registered or doesn't exists");
					alert.showAndWait();
				}

			}
		});
		
		
		
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		init();
	}
}
