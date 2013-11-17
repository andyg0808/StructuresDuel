package edu.calpoly.stat312.StructuresDuel.StructureTest;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.ardverk.collection.PatriciaTrie;
import org.ardverk.collection.StringKeyAnalyzer;

import edu.calpoly.stat312.StructuresDuel.Util.Timer;

public class TestRunner {

	/**
	 * Runs a test specified by the arguments provided and returns a Timer that
	 * has timed the crucial part of the specified Operation
	 * 
	 * @param t
	 *            The type of data structure to test
	 * @param block
	 *            A block of data to use in the data structure during the test
	 * @param o
	 *            The operation to conduct on the data structure
	 * @return A Timer that timed the relevant portion of this method to get a
	 *         time for completion of the specified Operation
	 */
	public static Timer runTest(Type t, Map<String, String> block, Operation o) {
		Map<String, String> testObj = getTestObj(t);
		Timer timer = new Timer();

		// Create consistent data structures to hold the data we'll be accessing
		// This is to try to eliminate any time variations from the data
		// structures used to hold the data
		String[] keys = block.keySet().toArray(new String[block.size()]);

		String[] values = null;

		if (o == Operation.INSERT) {
			// If we're going to need the data, then go ahead and create an
			// array of it
			values = block.values().toArray(new String[keys.length]);
		} else {
			// Since we're not going to be putting the data into the data
			// structure, just put it in right now.
			testObj.putAll(block);
		}

		// Run the correct action depending on the operation
		switch (o) {
		case INSERT:
			timer.startTimer();
			for (int i = 0; i < keys.length; i++) {
				testObj.put(keys[i], values[i]);
			}
			timer.stopTimer();
			return timer;

		case RETRIEVE:
			timer.startTimer();
			for (int i = 0; i < keys.length; i++) {
				testObj.get(keys[i]);
			}
			timer.stopTimer();
			return timer;

		case DELETE:
			timer.startTimer();
			for (int i = 0; i < keys.length; i++) {
				testObj.remove(keys[i]);
			}
			timer.stopTimer();
			return timer;

		default:
			throw new RuntimeException("Invalid operation");
		}
	}

	private static Map<String, String> getTestObj(Type t) {
		switch (t) {
		case BINARY_SEARCH_TREE:
			return new TreeMap<String, String>();

		case HASHTABLE:
			return new HashMap<String, String>();

		case TRIE:
			return new PatriciaTrie<String, String>(StringKeyAnalyzer.CHAR);

		default:
			throw new RuntimeException("Tried to get a non-extant type");
		}
	}
}
