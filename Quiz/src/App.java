import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
	private static final int WINDOW_WIDTH = 350;
	private static final int WINDOW_HEIGHT = 350;
	private static final int DEFAULT_VALUE_INSETS = 35;
	private static final int NUMBER_OF_QUESTIONS = 6;
	private static int score = 0;
	static Stage window;
	private static int counter = 0;

	static ArrayList<String> questions = new ArrayList<String>();
	static ArrayList<String> answersA = new ArrayList<String>();
	static ArrayList<String> answersB = new ArrayList<String>();
	static ArrayList<String> answersC = new ArrayList<String>();
	static ArrayList<String> answersD = new ArrayList<String>();
	static ArrayList<String> rightAnswers = new ArrayList<String>();

	public static void main(String[] args) {

		fill();
		launch(args);

	}

	public static void setScene(Scene scene) {
		window.setScene(scene);
	}

	public static void check(String answer) {

		if (answer.equals(rightAnswers.get(counter))) {
			score++;
		}

		counter++;
		if (counter == NUMBER_OF_QUESTIONS) {
			ScoreScreen.display(score);
			return;
		}

		Question.display(questions.get(counter), answersA.get(counter), answersB.get(counter), answersC.get(counter),
				answersD.get(counter));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Quiz");

		Label label = new Label("Welcome! Press the button to start the quiz.");
		label.setAlignment(Pos.CENTER);
		Button startButton = new Button("Start quiz");
		questions.get(0);
		startButton.setOnAction(e -> {
			Question.display(questions.get(0), answersA.get(0), answersB.get(0), answersC.get(0), answersD.get(0));
		});

		StackPane top = new StackPane();
		top.getChildren().add(label);

		StackPane middle = new StackPane();
		middle.getChildren().add(startButton);

		BorderPane borderLayout = new BorderPane();
		borderLayout.setTop(top);
		borderLayout.setCenter(middle);
		borderLayout.setPadding(new Insets(DEFAULT_VALUE_INSETS,DEFAULT_VALUE_INSETS,DEFAULT_VALUE_INSETS,DEFAULT_VALUE_INSETS));
		Scene scene = new Scene(borderLayout, WINDOW_HEIGHT, WINDOW_WIDTH);

		window.setScene(scene);
		window.show();
	}

	public static void newTry() {
		score = 0;
		counter = 0;
		Question.display(questions.get(0), answersA.get(0), answersB.get(0), answersC.get(0), answersD.get(0));

	}

	private static void fill() {
		questions.add("Which is the most venomous animal on the planet");
		answersA.add("Death Stalker Scorpion");
		answersB.add("Poison Dart Frog");
		answersC.add("Box Jellyfish");
		answersD.add("King Cobra");
		rightAnswers.add("Box Jellyfish");

		questions.add("How old was the world's oldest dog?");
		answersA.add("30");
		answersB.add("27");
		answersC.add("33");
		answersD.add("36");
		rightAnswers.add("30");

		questions.add("What is the capitol of Indonesia?");
		answersA.add("Jakarta");
		answersB.add("Singapore");
		answersC.add("Kuala Lampur");
		answersD.add("Maynila");
		rightAnswers.add("Jakarta");

		questions.add("What's earth's equatorial diameter?");
		answersA.add("10 881km");
		answersB.add("12 909km");
		answersC.add("12 742km");
		answersD.add("10 356km");
		rightAnswers.add("12 742km");

		questions.add("What's the temperature on the surface of the sun?");
		answersA.add("16 705°C");
		answersB.add("20 670°C");
		answersC.add("10 206°C");
		answersD.add("5 504°C");
		rightAnswers.add("5 504°C");
		
		questions.add("What percent of the population has natural red hair?");
		answersA.add("0-1%");
		answersB.add("3-4%");
		answersC.add("1-2%");
		answersD.add("4-5%");
		rightAnswers.add("1-2%");

	}

}
