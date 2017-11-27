import java.util.Scanner;

public class Guess {
	private Scanner keyboard = new Scanner(System.in);
	private String theWord = "";

	public Guess() {
		// Do nothing for now.
	}

	public String getWord() {
		// getWord() - It returns the currently guessed word.
		return (theWord);
	}

	public void setWord(int size) {
		// setWord(size) - It sets the word size
		// LOOP - for each position in the word
		for (int i = 0; i < size; i++) {
			// Add a '-' to the word
			theWord = theWord + "-";
		}
	}

	public void setWord(char letter, int position) {
		// setWord(character, position) - places the letter at the given position
		// Use substring to replace the '-' with the letter
		theWord = theWord.substring(0, position) + letter + theWord.substring(position + 1);
	}

	public char askForLetter() {
		String guessLine = "";
		char guessLetter = ' ';

		// Loop while we need to keep guessing
		boolean keepGuessing = true;
		while (keepGuessing) {
			// Prompt the user for a guess
			System.out.print("Enter a letter: ");
			guessLine = keyboard.nextLine();
			guessLine = guessLine.toLowerCase();

			// Check if the length is 1
			if ((guessLine.length() == 0) || (guessLine.length() > 1)) {
				// Error condition!
				System.out.print("That is invalid.");
			} else {
				// Check if the character is a valid hangman character
				guessLetter = guessLine.charAt(0);
				if ((guessLetter < 'a') || (guessLetter > 'z')) {
					System.out.println("That is an invalid character.");
				} else {
					// We have a valid character - get out of loop
					keepGuessing = false;
				}
			}
		}
		// Return the valid hangman character
		return guessLetter;

	}
}