package edu.calpoly.stat312.StructuresDuel;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		RandomData randGen = new RandomData();
		Map<String, String> data = randGen.getDataBlock(DataType.RANDOM,
				DataType.RANDOM, 1000000);
		Timer test = Tester.runTest(Type.BINARY_SEARCH_TREE, data,
				Operation.INSERT);
		System.out.println(test.elapsedTime() * 1e-9);
	}

	/*
	 * What do we need to be able to do? - Run replicates (probably blocked on
	 * time) - Control the data fed to our structures - Generate randomish data
	 * for our structures - Control the amount of data fed to our structure -
	 * Control the operation run on our structure - Feed data to our structures
	 * in blocks & retrieve it in blocks
	 */
	//
	// private static final List<String> wordlist = new ArrayList<>();
	// private static final List<String> sentencelist = new ArrayList<>();
	//
	// static {
	// /*
	// * Set up the lists of words and sentences that should be fed to our
	// * data structures.
	// */
	// try {
	// LineReader reader = new LineReader(new FileReader("words"));
	// for (String line : reader) {
	// wordlist.add(line);
	// }
	//
	// reader.close();
	//
	// reader = new LineReader(new FileReader("sentences"));
	// for (String sentence : reader) {
	// sentencelist.add(sentence);
	// }
	//
	// reader.close();
	//
	// } catch (FileNotFoundException e) {
	// throw new RuntimeException("Could not find data file.", e);
	// } catch (IOException e) {
	// throw new RuntimeException("Error with data file", e);
	// }
	// }

}
