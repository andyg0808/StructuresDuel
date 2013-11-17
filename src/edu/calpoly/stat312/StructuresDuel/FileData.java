package edu.calpoly.stat312.StructuresDuel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileData {

	private final List<String> wordlist = new ArrayList<String>();
	private final List<String> sentencelist = new ArrayList<String>();

	public FileData(File wordFile, File sentenceFile) throws IOException {
		/*
		 * Set up the lists of words and sentences that should be fed to our
		 * data structures.
		 */
		try {
			LineReader reader = new LineReader(new FileReader(wordFile));
			for (String line : reader) {
				wordlist.add(line);
			}

			reader.close();

			reader = new LineReader(new FileReader(sentenceFile));
			for (String sentence : reader) {
				sentencelist.add(sentence);
			}

			reader.close();

		} catch (IOException e) {
			throw new IOException("Error with data file", e);
		}
	}

	public List<String> getWordlist() {
		return wordlist;
	}

	public List<String> getSentencelist() {
		return sentencelist;
	}
}
