
package sheenaa;

/**
 * This class is the controller for the rock paper scissors application.
 * it handles all the mouse events, and the button events.
 * 
 * @author Anup Sheena
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLRpsController extends Application implements Initializable {

	/**
	 * both player and computer are modelled by the player class. These are the
	 * variables for the labels, imageviews, and buttons
	 */
	private Player player = new Player();
	private Player computer = new Player();

	@FXML
	ImageView rock, paper, scissors, imgComputerChoice;

	@FXML
	Label lblPlayerScore, lblCompScore, lblWinner;

	@FXML
	Button btnReset, btnExit;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("FXMLFrame.fxml"));
		Scene window = new Scene(root);
		primaryStage.setScene(window);
		primaryStage.setTitle("Play Rock-Paper-Scissors");
		primaryStage.show();
	}

	/**
	 * this method handles the event for the user clicking one of the images Once
	 * the image is clicked it will update the players move, change
	 * the border of the clicked image, get a random move from
	 * the computer, update the computer image, and then determine the result using methods
	 * from the Rps class.
	 * 
	 * @param event the mouse click of the user
	 */
	@FXML
	private void imgClicked(MouseEvent event) {

		//change borders back to default
		rock.getParent().setStyle("-fx-background-color:green");
		paper.getParent().setStyle("-fx-background-color:green");
		scissors.getParent().setStyle("-fx-background-color:green");
		
		// make image id into a variable and pass it into makeMove method
		ImageView clicked = (ImageView) event.getSource();
		String id = clicked.getId();
		player.makeMove(id);
		
		//change border of clicked image
		clicked.getParent().setStyle("-fx-background-color:red");

		// get random move from computer, and update image
		computer.move = computer.makeRandomMove();
		String compMove = computer.toString();
		imgComputerChoice.setImage(new Image("/sheenaa/res/" + compMove + ".png"));

		// determine result using rps methods and update label
		if (player.move.win(computer.move)) {
			lblWinner.setText("Player Wins!");
			player.incrementScore();
			lblPlayerScore.setText(String.valueOf(player.getScore()));
		} else if (player.move.tie(computer.move)) {
			lblWinner.setText("It's a Tie!");
		} else {
			lblWinner.setText("Computer Wins!");
			computer.incrementScore();
			lblCompScore.setText(String.valueOf(computer.getScore()));
		}
	}

	/**
	 * 
	 * this method is for user clicking reset. It will reset scores to 0, reset
	 * image to the default question mark, and reset the borders to their default
	 * colours.
	 * 
	 */

	@FXML
	private void resetClick(ActionEvent event) {
		// reset scores to 0
		player.setScore(0);
		computer.setScore(0);
		lblWinner.setText("");
		lblPlayerScore.setText(String.valueOf(player.getScore()));
		lblCompScore.setText(String.valueOf(computer.getScore()));

		// reset image to default
		imgComputerChoice.setImage(new Image("/res/question.png"));

		// reset borders
		rock.getParent().setStyle("-fx-background-color:green");
		paper.getParent().setStyle("-fx-background-color:green");
		scissors.getParent().setStyle("-fx-background-color:green");
	}

	/**
	 * 
	 * this method is for user clicking exit. It will exit the GUI application.
	 */

	@FXML
	private void exitClick(ActionEvent event) {
		// exit application
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
