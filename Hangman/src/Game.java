import java.io.FileNotFoundException;

public class Game {

	public static void main(String[] args) throws FileNotFoundException {
		String secretWord = "";
		int missed = 0;
		System.out.println("Welcome to Hangman");

		// Create a dictionary of words
		// Read the words from the file
		Dictionary Words = new Dictionary();
		secretWord = Words.randomWord();
		System.out.println("The secret word has " + secretWord.length() + " letters");

		// Create a guess object & call the ask for letter method.
		Guess guess = new Guess();

		// Initialize the guessed word
		guess.setWord(secretWord.length());
		System.out.println(guess.getWord());

		while (guess = true) {
			
		}
		// Ask for a letter and save somewhere useful
		char guessedLetter = guess.askForLetter();

		// Evaluate if the guessed letter is in the secret word
		if (secretWord.indexOf(guessedLetter) != -1) {
			// What letter is it?
			int ltrPos = secretWord.indexOf(guessedLetter);

			// LOOP while there are guessed letters in the secret word
			while (ltrPos != -1) {

				// Set the letter in the guessed word
				guess.setWord(guessedLetter, ltrPos);

				// Advance past the current occurrence
				int index = ltrPos + 1;

				// Get next position
				ltrPos = secretWord.indexOf(guessedLetter, index);
			}
			// Give the position of the letter
			System.out.println(guess.getWord());
		} else {
			// Wrong guess!
			missed = missed + 1;
			System.out.println("There is no " + guessedLetter + ". Wrong Guesses: " + missed);
		}
	}
}