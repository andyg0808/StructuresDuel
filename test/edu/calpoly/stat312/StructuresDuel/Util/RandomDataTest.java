package edu.calpoly.stat312.StructuresDuel.Util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.calpoly.stat312.StructuresDuel.StructureTest.DataType;

public class RandomDataTest {

	private RandomData randData;
	private static FileData fileData;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		fileData = new FileData(new File("words"), new File("sentences"));
	}

	@Before
	public void setUp() throws Exception {
		randData = new RandomData();
		randData.setSentences(fileData.getSentencelist());
		randData.setWords(fileData.getWordlist());
	}

	@Test
	public void testRandomDataLong() {
		RandomData a = new RandomData(4436);
		RandomData b = new RandomData(4436);
		for (int i = 0; i < 15; i++) {
			// Check that creating RandomDatas with the same seed results in the
			// same output
			String aString = a.randomString();
			String bString = b.randomString();
			assertTrue(aString.equals(bString));
		}
	}

	@Test
	public void testGetDataBlock() {
		LinkedHashMap<String, String> block = randData.getDataBlock(
				DataType.RANDOM, DataType.RANDOM, 15);
		assertEquals(block.size(), 15);
	}

	@Test
	public void testShuffle() {
		String[] shuffled = fileData.getWordlist().toArray(new String[1]);
		String[] golden = fileData.getWordlist().toArray(new String[1]);
		List<String> a = Arrays.asList(shuffled);
		randData.shuffle(a);
		boolean same = true;
		for (int i = 0; i < shuffled.length; i++) {
			// Look for a difference
			same = same && golden[i].equals(shuffled[i]);
		}
		assertFalse(same);
	}

	@Test
	public void testRandomSentence() {
		String a = randData.randomSentence();
		String b = randData.randomSentence();
		assertFalse(a.equals(b));
	}

	@Test
	public void testRandomWord() {
		String a = randData.randomWord();
		String b = randData.randomWord();
		assertFalse(a.equals(b));
	}

	@Test
	public void testRandomString() {
		String a = randData.randomString();
		String b = randData.randomString();
		assertFalse(a.equals(b));
	}

	@Test
	public void testRandomStringInt() {
		String a = randData.randomString(14);
		String b = randData.randomString(14);
		assertFalse(a.equals(b));
		assertTrue(a.length() == b.length());
		assertEquals(a.length(), 14);
	}

	@Test
	public void testRandomChar() {
		char a = randData.randomChar();
		char b = randData.randomChar();
		assertFalse(a == b);
	}

	@Test
	public void testGetSetWords() {
		List<String> wordlist = fileData.getWordlist();
		randData.setWords(wordlist);
		assertTrue(randData.getWords().equals(wordlist));
	}

	@Test
	public void testGetSetSentences() {
		List<String> sentencelist = fileData.getSentencelist();
		randData.setSentences(sentencelist);
		assertTrue(randData.getSentences().equals(sentencelist));
	}

}
