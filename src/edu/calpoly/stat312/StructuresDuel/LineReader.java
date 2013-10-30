package edu.calpoly.stat312.StructuresDuel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

/**
 * This class extends BufferedReader, making it Iterable by line, and enabling
 * the use of BufferedReaders in loops, as in some scripting languages.
 * 
 * @author Andrew Gilbert
 * 
 */
public class LineReader extends BufferedReader implements Iterable<String> {

	/**
	 * @author Andrew Gilbert
	 * 
	 *         This class implements an iterator for BufferedReaders,
	 *         effectively. Rather than throwing IOExceptions, however, it
	 *         returns null and acts like the file has been exhausted. The error
	 *         may be viewed and reset through methods provided for that
	 *         purpose.
	 * 
	 */
	public final class LineIterator implements Iterator<String> {

		String nextLine;
		IOException error;

		private LineIterator() {
			try {
				// Set up local variables
				nextLine = readLine();
				error = null;
			} catch (IOException e) {
				nextLine = null;
				error = e;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			// If the next line isn't null, there is a next line.
			return nextLine != null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		@Override
		public String next() {
			try {
				String oldLine = nextLine;
				// Read the next line
				nextLine = readLine();

				// Return the current line
				return oldLine;
			} catch (IOException e) {
				error = e;
				nextLine = null;
				return null;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException(
					"Cannot remove a line from a LineReader");
		}

		/**
		 * Returns the last IOException which has occurred
		 * 
		 * @return The IOException, as caught by a try-catch
		 */
		public IOException getError() {
			return error;
		}

		/**
		 * Clears the last IOException
		 */
		public void resetError() {
			error = null;
		}

	}

	public LineReader(Reader in, int sz) {
		super(in, sz);
	}

	public LineReader(Reader in) {
		super(in);
	}

	@Override
	public Iterator<String> iterator() {
		return new LineIterator();
	}

}
