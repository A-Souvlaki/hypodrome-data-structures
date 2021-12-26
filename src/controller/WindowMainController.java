package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import dataStructures.Exception.EmptyFieldException;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Rider;

public class WindowMainController implements Initializable {

	private ObservableList<Rider> riders;

	private TableView<Rider> toShow;

	int k = 0;

	@FXML
	private BorderPane panel;

	@FXML
	private Button add;

	@FXML
	private Button start;

	@FXML
	private TextField rider;

	@FXML
	private TextField horse;

	@SuppressWarnings("unchecked")
	void init() {
		toShow = new TableView<Rider>();
		toShow.setMaxWidth(300);
		toShow.setMaxHeight(360);

		TableColumn<Rider, String> colName = new TableColumn<>("Nombre");
		colName.setCellValueFactory(new PropertyValueFactory<Rider, String>("name_gr"));
		colName.setPrefWidth(toShow.getMaxWidth() / 3);

		TableColumn<Rider, String> colTrack = new TableColumn<>("Pista");
		colTrack.setCellValueFactory(new PropertyValueFactory<Rider, String>("tracker_m"));
		colTrack.setPrefWidth(toShow.getMaxWidth() / 3);

		TableColumn<Rider, String> colHorse = new TableColumn<>("Caballo");
		colHorse.setCellValueFactory(new PropertyValueFactory<Rider, String>("horse_m"));
		colHorse.setPrefWidth(toShow.getMaxWidth() / 3);

		toShow.getColumns().addAll(colName, colTrack, colHorse);
		panel.setCenter(toShow);
		riders = FXCollections.observableArrayList(Main.getHypodrome().getCareer().ridersToShow());
		int verifier = Main.getHypodrome().getCareer().numbersToList();
		if (verifier >= 7 && verifier <= 10) {
			start.setVisible(true);
			add.setVisible(false);
			rider.setEditable(false);
			horse.setEditable(false);
		}
		toShow.setItems(riders);

		add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent t) {

				try {
					if (rider.getText().equals("")||horse.getText().equals("")) {
						throw new EmptyFieldException("Please fill the camps");
					}	
					k++;
					Main.getHypodrome().getCareer().registerRiders(rider.getText(),""+ k, horse.getText());
					if (k >= 7 && k <= 10) {
						start.setVisible(true);
					}
					riders = FXCollections.observableArrayList(Main.getHypodrome().getCareer().ridersToShow());
					toShow.setItems(riders);
				} catch (QueueException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Queue is full");
					alert.setHeaderText(null);
					alert.setContentText("The Queue is full");
					alert.showAndWait();
				} catch (NullPointerException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText("An error has ocurred");
					alert.showAndWait();
				} catch (EmptyFieldException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText(e.getMessage());
					alert.showAndWait();
				}

			}
		});
		
	start.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent t) {

				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("/application/userBet.fxml"));
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		init();

	}

}
