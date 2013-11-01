package edu.calpoly.stat312.StructuresDuel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class RandomData {

	List<String> words;
	List<String> sentences;
	Random r;

	public RandomData() {
		r = new Random();
	}

	/**
	 * @param seed
	 *            A seed value for the random number generator used to create
	 *            data in this object.
	 */
	public RandomData(long seed) {
		r = new Random(seed);
	}

	/**
	 * Returns a map containing randomly-selected data sourced from the
	 * specified places
	 * 
	 * @param key
	 *            Where to source the key data
	 * @param value
	 *            Where to source the value data
	 * @param length
	 *            How much random data to generate
	 * @return A LinkedHashMap that contains the data. LinkedHashMap is used to
	 *         allow efficient traversal.
	 */
	public LinkedHashMap<String, String> getDataBlock(DataType key,
			DataType value, int length) {
		// Map to store data in. LinkedHashMap used for efficient, unsorted
		// traversals.
		LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();

		// Get generators for random data
		DataGenerator keyMaker = getGenerator(key);
		DataGenerator valueMaker = getGenerator(value);

		// Create random data and add it
		for (int i = 0; i < length; i++) {
			data.put(keyMaker.next(), valueMaker.next());
		}

		// Return the Map of data
		return data;
	}

	private interface DataGenerator {
		public String next();
	}

	private DataGenerator getGenerator(DataType t) {
		switch (t) {
		case WORDS:
			return new DataGenerator() {
				@Override
				public String next() {
					return randomWord();
				}
			};

		case SENTENCES:
			return new DataGenerator() {
				@Override
				public String next() {
					return randomSentence();
				}
			};

		case RANDOM:
			return new DataGenerator() {
				@Override
				public String next() {
					return randomString();
				}
			};

		default:
			throw new RuntimeException(
					"Unknown DataType! Cannot generate data!");
		}
	}

	public List<Integer> randomList(int length) {
		ArrayList<Integer> list = new ArrayList<>();
		Collections.shuffle(list, r);
		return list;
	}

	/**
	 * Shuffles the list using Collections.shuffle and the randomness source for
	 * this RandomData
	 * 
	 * @param list
	 *            The list to shuffle
	 */
	public <T> void shuffle(List<T> list) {
		Collections.shuffle(list, r);
	}

	/**
	 * Choose a random sentence from the list provided
	 * @return The sentence
	 */
	public String randomSentence() {
		return sentences.get(r.nextInt(sentences.size()));
	}

	/**
	 * Choose a random word from the list provided
	 * @return The word
	 */
	public String randomWord() {
		return words.get(r.nextInt(words.size()));
	}

	/**
	 * Generates a random eight-character string
	 * 
	 * @return A string consisting of randomly-chosen lowercase characters
	 */
	public String randomString() {
		return randomString(8);
	}

	/**
	 * Generates a random string of the specified length
	 * 
	 * @param l
	 *            The length of string to generate
	 * @return A string consisting of randomly-chosen lowercase characters.
	 */
	public String randomString(int l) {
		char[] chars = new char[l];
		for (int i = 0; i < l; i++) {
			chars[i] = randomChar();
		}

		return new String(chars);
	}

	/**
	 * @return A random lowercase ASCII character as a Java char
	 */
	public char randomChar() {
		int i = r.nextInt(26);
		// Make a lower-case, ASCII character
		return (char) (0x61 + i);
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public List<String> getSentences() {
		return sentences;
	}

	public void setSentences(List<String> sentences) {
		this.sentences = sentences;
	}
}
