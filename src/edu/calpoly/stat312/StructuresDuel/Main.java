package edu.calpoly.stat312.StructuresDuel;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

import org.ardverk.collection.PatriciaTrie;

public class Main {

	public static void main(String[] args) {

	}

	/*
	 * What do we need to be able to do? - Run replicates (probably blocked on
	 * time) - Control the data fed to our structures - Generate randomish data
	 * for our structures - Control the amount of data fed to our structure -
	 * Control the operation run on our structure - Feed data to our structures
	 * in blocks & retrieve it in blocks
	 */

	private Timer runTest(Type t, Map<String, String> block, Operation o) {
		Map<String, String> testObj = getTestObj(t);
		Timer timer = new Timer();

		// Set up our data structure for retrieval or deletion
		if (o != Operation.INSERT) {
			testObj.putAll(block);
		}
		
		// Create a consistent data structure to hold the data we'll be accessing
		ArrayList<String> 
		

		switch (o) {
		case INSERT:

			timer.startTimer();
			timer.stopTimer();
			return timer;

		case RETRIEVE:

			break;

		case DELETE:
			break;

		default:
			break;
		}
		return 0;
	}

	private static Map<String, String> getTestObj(Type t) {
		switch (t) {
		case BINARY_SEARCH_TREE:
			return new TreeMap<>();

		case HASHTABLE:
			return new HashMap<>();

		case TRIE:
			return new PatriciaTrie<>();

		default:
			throw new RuntimeException("Tried to get a non-extant type");
		}
	}
}
