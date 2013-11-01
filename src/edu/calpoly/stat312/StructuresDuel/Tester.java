package edu.calpoly.stat312.StructuresDuel;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.ardverk.collection.PatriciaTrie;
import org.ardverk.collection.StringKeyAnalyzer;

public class Tester {

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
			return new TreeMap<>();

		case HASHTABLE:
			return new HashMap<>();

		case TRIE:
			return new PatriciaTrie<>(StringKeyAnalyzer.CHAR);

		default:
			throw new RuntimeException("Tried to get a non-extant type");
		}
	}
}
