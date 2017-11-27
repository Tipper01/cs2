import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dictionary {
	private int MaxWords = 300;
	private String filename = "/home/student/Words.txt";
	private String[] dictionary = new String[MaxWords];

	// The CONSTRUCTOR
	public Dictionary() throws FileNotFoundException {
		// Open the dictionary file
		File dictFile = new File(filename);
		Scanner dictScan = new Scanner(dictFile);

		int index = 0;
		while (dictScan.hasNextLine() == true) {
			// Read in the line
			dictionary[index] = dictScan.nextLine();
			index = index + 1;
		}
	}

	public String randomWord() {
		Random rand = new Random();
		return (dictionary[rand.nextInt(3)]);
	}
}