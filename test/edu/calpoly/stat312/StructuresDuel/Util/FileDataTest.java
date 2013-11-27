package edu.calpoly.stat312.StructuresDuel.Util;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileDataTest {

	/**
	 * Check that the sentence list and the word list have something in them
	 * 
	 * @throws IOException
	 */
	@Test
	public void testReadFiles() throws IOException {
		FileData d = new FileData(new File("words"), new File("sentences"));
		assertTrue(d.getSentencelist().size() > 0);
		assertTrue(d.getWordlist().size() > 0);
	}

	@Test(expected = IOException.class)
	public void testReadInvalidFiles() throws IOException {
		// Note deliberately non-extant filename.
		new FileData(new File(")(#%*&@)(%*)3&)%(*W)(Y@W&YT)W"), new File(
				"sentences"));
	}
}
