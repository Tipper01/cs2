import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Board gameBoard = new Board();
		System.out.println("Welcome to Tic Tac Toe");
		gameBoard.display();
		// Instantiate a class for two players
		Player[] players = new Player[2];
		players[0] = new Player('x');
		players[1] = new Player('o');

		// Loop while the game is not over
		while (gameBoard.status() == 'P') {
			int row = 0, col = 0;

			// Ask a player a for a row and column
			char crow = players[0].askForSpot();
			if (crow == 'a') {
				row = 0;
			} else if (crow == 'b') {
				row = 1;
			} else if (crow == 'c') {
				row = 2;
			} else {

			}
			char ccol = players[0].askForSpot();
			if (ccol == 'A') {
				col = 0;
			} else if (ccol == 'B') {
				col = 1;
			} else if (ccol == 'C') {
				col = 2;
			} else {

			}

			// Place the proper token on board in the proper place
			gameBoard.token('x', row, col);

			// Display the board
			gameBoard.display();
		}

		// Print the board
		System.out.println(gameBoard.status());
		// Print a victory message or a tie message

	}
}

class Player {
	private char marker = ' ';
	private Scanner keyboard = new Scanner(System.in);

	Player(char token) {
		marker = token;
	}

	public char askForSpot() {
		String guessLine = "";
		char guessLetter = ' ';
		System.out.println("Enter a letter: ");
		String response = keyboard.nextLine();
		response = response.toLowerCase();
		return guessLetter;

	}
}

class Board {
	private char[][] theBoard = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

	Board() {
		// Do nothing for now.
	}

	// This method needs to display the current board.
	void display() {
		System.out.println("    0   1   2");
		System.out.println(" 0  " + theBoard[0][0] + " | " + theBoard[0][1] + " | " + theBoard[0][2]);
		System.out.println("    ----------");
		System.out.println(" 1  " + theBoard[1][0] + " | " + theBoard[1][1] + " | " + theBoard[1][2]);
		System.out.println("    ----------");
		System.out.println(" 2  " + theBoard[2][0] + " | " + theBoard[2][1] + " | " + theBoard[2][2]);
	}

	// Put a token on the board
	void token(char token, int row, int col) {
		theBoard[row][col] = token;

	}

	public char status() {
		// Return token of winner or 'D' for draw or 'P' for in-progress
		for (int r = 0; r < 3; r++) {
			if ((theBoard[r][0] == theBoard[r][1]) && (theBoard[r][1] == theBoard[r][2])) {
				// three in a row
				if (theBoard[r][0] != ' ')
					return (theBoard[r][0]);
			}
		}
		for (int c = 0; c < 3; c++) {
			if (theBoard[0][c] == theBoard[1][c] && theBoard[1][c] == theBoard[2][c]) {
				// three in a row
				if (theBoard[0][c] != ' ')
					return (theBoard[0][c]);
			}
		}
		if (theBoard[0][0] == theBoard[1][1] && theBoard[1][1] == theBoard[2][2]) {
			if (theBoard[1][1] != ' ')
				return (theBoard[1][1]);
		}
		if (theBoard[0][2] == theBoard[1][1] && theBoard[1][1] == theBoard[2][0]) {
			if (theBoard[1][1] != ' ')
				return (theBoard[1][1]);
		}
		for (int c = 0; c < 3; c++) {
			for (int r = 0; r < 3; r++) {
				if (theBoard[r][c] == ' ') {
					return ('P');
				}
			}
		}
		return ('D');
	}
}
