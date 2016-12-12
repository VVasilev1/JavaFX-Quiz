
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ScoreScreen {

	public static void display(Integer score) {

		Label label = new Label("Your score is: " + score + "/6");

		Button button = new Button("Try again?");
		button.setOnAction(e -> App.newTry());

		VBox layout = new VBox(50);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label, button);

		Scene scene = new Scene(layout, 350, 350);

		App.setScene(scene);

	}
}
