package edu.calpoly.stat312.StructuresDuel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TimerTest {
	private Timer t;

	@Before
	public void setUp() {
		t = new Timer();
	}

	@Test
	public void testGetElapsedTime() {
		t.startTimer();

		// Waste a little time
		System.out.print('l');

		t.stopTimer();

		// That print had better have taken time!
		assertNotEquals(t.elapsedTime(), 0);
	}

	@Test
	public void testStartTimer() {
		t.startTimer();
		assertTrue(t.isRunning());
		assertNotEquals(t.elapsedTime(), 0); // The previous call should have
												// taken time.
	}

	@Test(expected = RuntimeException.class)
	public void testReadUnstartedTimer() {
		t.elapsedTime(); // This should blow up. That keeps us from reading an
							// unstartd timer by acccident
	}

	@Test
	public void testStopTimer() {
		t.startTimer();
		System.out.print('l');
		t.stopTimer();

		assertFalse(t.isRunning());
		assertTrue(t.hasRun());
	}

}
