package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Hypodrome;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	private static Hypodrome hyp;
	
	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("windowMain.fxml"));
		arg0.setScene(new Scene(root));
		arg0.setResizable(true);
		arg0.show();
		
	}

	public static void main(String[] args) {
		hyp = new Hypodrome();
		launch(args);

	}
	
	public static Hypodrome getHypodrome() {
		return hyp;
	}
	
	public static void setHypodrome(Hypodrome hp) {
		hyp = hp;
	}

}
