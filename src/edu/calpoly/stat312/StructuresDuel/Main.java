package edu.calpoly.stat312.StructuresDuel;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		RandomData randGen = new RandomData();
		Map<String, String> data = randGen.getDataBlock(DataType.RANDOM,
				DataType.RANDOM, 1000000);
		Timer test = Tester.runTest(Type.BINARY_SEARCH_TREE, data,
				Operation.INSERT);
		System.out.println(test.elapsedNanoTime() * 1e-9);
	}

	/*
	 * What do we need to be able to do? - Run replicates (probably blocked on
	 * time) - Control the data fed to our structures - Generate randomish data
	 * for our structures - Control the amount of data fed to our structure -
	 * Control the operation run on our structure - Feed data to our structures
	 * in blocks & retrieve it in blocks
	 */

}
