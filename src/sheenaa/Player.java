package sheenaa;

/**
 * This class is models the player for the application. It has getters and
 * setters for the score attribute. A default constructor for player object, an
 * incrementer for the score attribute, and methods that set the move for the
 * player.
 * 
 * @author Anup Sheena
 */

public class Player {

	public Rps move;
	private int score;

	public Player() {
		this.move = null;
		this.score = 0;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void incrementScore() {
		score++;
	}

	/**
	 * this method takes a String as an attribute, uses the getRps method to get the
	 * Rps value for that String, and assigns it to the move attribute for the class
	 * 
	 * @param move(rock paper or scissors) in String
	 */
	public void makeMove(String move) {

		this.move = Rps.getRps(move);

	}

	/**
	 * this method makes a random move (rock paper or scissors) and assigns it to
	 * the move attribute for the class. It creates a number from 1-3, and uses that
	 * to assign the random move. This is used for the computers moves.
	 */

	public Rps makeRandomMove() {

		int random = (int) (Math.random() * 3 + 1);
		Rps x = null;
		if (random == 1) {
			x = Rps.ROCK;
		}
		if (random == 2) {
			x = Rps.PAPER;
		}
		if (random == 3) {
			x = Rps.SCISSORS;
		}

		return x;

	}

	public String toString() {

		return move.getName();

	}
	
	

}