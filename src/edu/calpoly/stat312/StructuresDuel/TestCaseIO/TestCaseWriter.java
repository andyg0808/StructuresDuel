package edu.calpoly.stat312.StructuresDuel.TestCaseIO;

import java.io.IOException;
import java.util.List;

import edu.calpoly.stat312.StructuresDuel.TestCase;

public interface TestCaseWriter {
	/**
	 * Write the TestCase to the destination for this TestCaseWriter
	 * 
	 * @param t
	 *            The TestCase to write
	 * @throws IOException
	 */
	public void write(TestCase t) throws IOException;

	/**
	 * Write all the TestCases in the list to the destination for this
	 * TestCaseWriter.
	 * 
	 * @param l
	 *            The List of TestCases to write
	 * @throws IOException
	 */
	public void writeAll(List<? extends TestCase> l) throws IOException;
}
