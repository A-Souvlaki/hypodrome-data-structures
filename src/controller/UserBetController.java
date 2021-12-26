package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import dataStructures.Exception.ListException;
import dataStructures.Exception.QueueException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import thread.CountDownThread;

public class UserBetController implements Initializable {

	ObservableList<Integer> listA = FXCollections.observableArrayList();

	@FXML
	private TextField name;

	@FXML
	private Label timer;

	@FXML
	private TextField id;

	@FXML
	private ChoiceBox<Integer> horses;

	@FXML
	private TextField value;

	@FXML
	private Button register;
	
	@FXML
	private Button search;
	
	@FXML
	private Button newCareer;
	
	@FXML
	private Button rematch;
	
	@FXML
	private Label st;
	
	@FXML
	private Label nd;
	
	@FXML
	private Label rd;
	
	@FXML
	private Label st_horse;
	
	@FXML
	private Label nd_horse;
	
	@FXML
	private Label rd_horse;
	

	private CountDownThread cdt;

	void init() {

		register.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {

				try {
					int n = horses.getValue();
					Main.getHypodrome().addAnUser(name.getText(), Integer.parseInt(id.getText()), n,
							Integer.parseInt(value.getText()));
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Register Succefull");
					alert.setHeaderText(null);
					alert.setContentText("Your bet has been accepted");
					alert.showAndWait();
					
					name.clear();
					horses.setValue(null);
					id.clear();
					value.clear();

				} catch (NumberFormatException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Use numbers");
					alert.setHeaderText(null);
					alert.setContentText("Some camp could be typed incorrectly, remember ID an value are only numbers");
					alert.showAndWait();
				} catch (NullPointerException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText("Please select a horse");
					alert.showAndWait();
				}

			}
		});
		
		search.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {

				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("/application/searchBet.fxml"));
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setScene(scene);
					stage.centerOnScreen();
					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		
		rematch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				
				try {
					Main.getHypodrome().getCareer().rematch();
				} catch (ListException | QueueException e1) {
					e1.printStackTrace();
				}

				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("/application/WindowMain.fxml"));
					Scene scene = new Scene(root);
					Stage stage = (Stage) ((Node) t.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.centerOnScreen();
					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		
		newCareer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				
				try {
					Main.getHypodrome().getCareer().reNew();
				} catch (QueueException e1) {
					e1.printStackTrace();
				}

				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("/application/WindowMain.fxml"));
					Scene scene = new Scene(root);
					Stage stage = (Stage) ((Node) t.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.centerOnScreen();
					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});

	}

	@SuppressWarnings("unlikely-arg-type")
	void createBox() {
		listA.remove(listA);
		int n = Main.getHypodrome().getCareer().numbersToList();
		for (int i = 0; i < n; i++) {
			listA.add(i + 1);
		}
		horses.getItems().addAll(listA);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startClock();
		init();
		createBox();
	}

	public void updateTime(String time) {
		timer.setText(time);
		if (timer.getText().equals("00:01")) {
			timer.setText("Time is running out");
			
			register.setVisible(false);
			name.setEditable(false);
			id.setEditable(false);
			value.setEditable(false);
			
			search.setVisible(true);
			newCareer.setVisible(true);
			rematch.setVisible(true);
			
			st.setVisible(true);
			nd.setVisible(true);
			rd.setVisible(true);
			
			String winner1 = Main.getHypodrome().getCareer().getWinner().getHorse_m();
			String winner2 = Main.getHypodrome().getCareer().getWinner().getHorse_m();
			String winner3 = Main.getHypodrome().getCareer().getWinner().getHorse_m();
			
			st_horse.setText(winner1);
			nd_horse.setText(winner2);
			rd_horse.setText(winner3);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Time out");
			alert.setHeaderText(null);
			alert.setContentText("The time for bets is finished");
			alert.showAndWait();
		}
	}

	public void startClock() {
		cdt = new CountDownThread(this);
		cdt.start();
		
		
	}

}
