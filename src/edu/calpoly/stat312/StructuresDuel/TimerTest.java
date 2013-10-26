package edu.calpoly.stat312.StructuresDuel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
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

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// If the sleep is interrupted, don't worry. We're just wanting to
			// make the timer greater than 0
		}

		t.stopTimer();

		assertNotEquals(t.elapsedTime(), 0);
	}

	@Test
	public void testMultipleRuns() {
		long prev = 0;
		// Start and stop the timer a bunch of times; it had better get bigger each time.
		// This is to check that the timer does indeed gain time and not overwrite the last value.
		for (int i = 0; i < 10; i++) {
			t.startTimer();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// If the sleep is interrupted, don't worry. We're just wanting to make the
				// timer greater than 0
			}

			t.stopTimer();

			assertTrue(t.elapsedTime() > prev);
			prev = t.elapsedTime();
		}
	}

	@Test
	public void testStartTimer() {
		t.startTimer();
		assertTrue(t.isRunning());

		// The previous call should have taken time.
		// This checks that the timer is running correctly
		assertNotEquals(t.elapsedTime(), 0);
	}

	@Test(expected = UnrunTimerException.class)
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
