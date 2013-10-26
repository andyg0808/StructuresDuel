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

		// Create consistent data structures to hold the data we'll be accessing
		// This is to try to eliminate any time variations from the data
		// structures used to hold the data
		ArrayList<String> keys = new ArrayList<>(block.keySet());

ArrayList<String> values=null;

		if (o == Operation.INSERT) {
			// If we're going to need the data, then go ahead and create an
			// array of it
			 values= new ArrayList<>(block.values());
		} else {
			// Since we're not going to be putting the data into the data
			// structure, just put it in right now.
			testObj.putAll(block);
		}

		switch (o) {
		case INSERT:
			timer.startTimer();
			for(int i=0; i<keys.size(); i++){
				testObj.put(keys.get(i), values.get(i));
			}
			timer.stopTimer();
			return timer;

		case RETRIEVE:
			timer.startTimer();
			for(int i=0; i<keys.size(); i++){
				testObj.get(keys.get(i));
			}
			timer.stopTimer();
			return timer;

		case DELETE:
			timer.startTimer();
			timer.stopTimer();
			return timer;

		default:
			return null;
		}
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
