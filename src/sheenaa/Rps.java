package sheenaa;

/**
 * This enumeration models three constants ROCK, PAPER, and SCISSORS. Each of
 * these have a name attribute, and a winsOver attribute that contains the name
 * of the move that the constant will win over. The name and winsOver attributes
 * have getter methods. There are methods to determine the RPS constant from a
 * string input, and methods to determine whether an Rps constant will win or
 * tie against another one.
 * 
 * @author Anup Sheena
 *
 */

public enum Rps {
	ROCK("rock", "scissors"), PAPER("paper", "rock"), SCISSORS("scissors", "paper");

	private String name;
	private String winsOver;

	private Rps(String name, String winsOver) {
		this.name = name;
		this.winsOver = winsOver;
	}

	public String getName() {
		return name;
	}

	public String getWinsOver() {
		return winsOver;
	}

	/**
	 * @param name String of either rock paper or scissors
	 * @return matching Rps constant for that name entered
	 */

	public static Rps getRps(String name) {
		Rps rps = null;
		if (name.equalsIgnoreCase("rock"))
			rps = Rps.ROCK;
		if (name.equalsIgnoreCase("paper"))
			rps = Rps.PAPER;
		if (name.equalsIgnoreCase("scissors"))
			rps = Rps.SCISSORS;
		return rps;

	}

	/**
	 * 
	 * @param other RPS that will be compared to see if it is a tie.
	 * @return true or false depending on if the value of that constant is the same
	 *         as the other variable
	 */

	public boolean tie(Rps other) {
		boolean x = false;
		if (this.name == other.name)
			x = true;
		return x;
	}

	/**
	 * 
	 * @param other RPS that will be compared to see if it is a win.
	 * @return true or false depending on if the value of the constant wins against
	 *         the other variable
	 */

	public boolean win(Rps other) {
		boolean x = false;
		if (this.winsOver == other.name)
			x = true;
		return x;
	}

}
