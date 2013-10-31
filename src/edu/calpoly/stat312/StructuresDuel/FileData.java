package edu.calpoly.stat312.StructuresDuel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileData {

	private static final List<String> wordlist = new ArrayList<>();
	private static final List<String> sentencelist = new ArrayList<>();

	static {
		/*
		 * Set up the lists of words and sentences that should be fed to our
		 * data structures.
		 */
		try {
			LineReader reader = new LineReader(new FileReader("words"));
			for (String line : reader) {
				wordlist.add(line);
			}

			reader.close();

			reader = new LineReader(new FileReader("sentences"));
			for (String sentence : reader) {
				sentencelist.add(sentence);
			}

			reader.close();

		} catch (FileNotFoundException e) {
			throw new RuntimeException("Could not find data file.", e);
		} catch (IOException e) {
			throw new RuntimeException("Error with data file", e);
		}
	}
}
