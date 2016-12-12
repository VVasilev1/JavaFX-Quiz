import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Question {
	private static final int WINDOW_WIDTH = 350;
	private static final int WINDOW_HEIGHT = 350;
	private static final int INSETS_VALUE = 35;
	private static final int VBOX_VALUE = 40;
	static RadioButton temp;

	public static void display(String question, String answerA, String answerB, String answerC, String answerD) {

		ToggleGroup group = new ToggleGroup();

		Button next = new Button("Next Question");
		next.setAlignment(Pos.CENTER);
		next.setOnAction(e -> {
			temp = (RadioButton) group.getSelectedToggle();
			App.check(temp.getText());
		});

		StackPane bot = new StackPane();
		bot.getChildren().add(next);

		RadioButton radio1 = new RadioButton(answerA);
		radio1.setSelected(true);
		radio1.setToggleGroup(group);

		RadioButton radio2 = new RadioButton(answerB);

		radio2.setToggleGroup(group);

		RadioButton radio3 = new RadioButton(answerC);

		radio3.setToggleGroup(group);

		RadioButton radio4 = new RadioButton(answerD);

		radio4.setToggleGroup(group);

		Label label = new Label(question);
		label.setAlignment(Pos.CENTER);

		StackPane top = new StackPane();
		top.getChildren().add(label);

		VBox left = new VBox(VBOX_VALUE);
		left.setPadding(new Insets(60, 0, 0, 0));
		left.getChildren().addAll(radio1, radio3);

		VBox right = new VBox(VBOX_VALUE);
		right.setPadding(new Insets(60, 0, 0, 0));
		right.getChildren().addAll(radio2, radio4);

		BorderPane borderLayout = new BorderPane();
		borderLayout.setPadding(new Insets(INSETS_VALUE, INSETS_VALUE, INSETS_VALUE, INSETS_VALUE));
		borderLayout.setTop(top);

		borderLayout.setLeft(left);
		borderLayout.setRight(right);
		borderLayout.setBottom(bot);

		Scene scene = new Scene(borderLayout, WINDOW_HEIGHT, WINDOW_WIDTH);

		App.setScene(scene);

	}

}
// next.setOnAction(e ->
// App.check(group.selectedToggleProperty().getValue().toString()));